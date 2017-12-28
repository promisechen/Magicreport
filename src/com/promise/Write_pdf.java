/*
********************************************************************************
*                                                                              *
*                         word pdf html 报表统一接口                           *
*                                                                              *
********************************************************************************
*
* 版权声明:  Copyright(c) 2000-2010 PROMISE Networks.All Right Reserved
*
* 文件列表:  ALL
*
* 声    明:  任何人都可随意传播修改，修改后请将修改部分发至chenlx10@163.com,任何
             问题都可与chenlx10@163.com联系。未申请网址：www.frdog.org
*
* 作    者:   陈令祥
*
* 版    本:   v1.0
*
* 日期:     20100920
*
********************************************************************************
*
* 历史记录:
*
*         v1.0 20100920 edited by MagicPromise
*
*/

package com.promise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.Color;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Image;
import com.lowagie.text.Section;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.jfree.data.category.DefaultCategoryDataset;

public class Write_pdf implements NPromise {

	private int firstinfo = 0, lastinfo = 0;
	private Chapter chapter;

	private Section section[] = new Section[10];
	private com.lowagie.text.Font bfChinese10, bfChinese5, bfChinese11,
			bfChinese12, bfChinese13, bfChinese14, bfChinese16, bfChinese20,
			bfChinese32;
	private Document document = new Document(PageSize.A4);
	private Anchor anchor;
	private Paragraph p;
	private Table table;
	private Cell cell;
	private com.lowagie.text.pdf.BaseFont bfChinese, bfChinese_title;

	private String filepath = "e:\\report\\";
	private String imgpath = "e:\\report\\img\\";
	private String fontpath = null;
	private String tmppath = null;
	private jpie pie = null;
	private Image png = null;
	private Color base_Color = new Color(214, 233, 242);// 表单底颜色
	private Color streak_Color = new Color(154, 202, 225);// 表态颜色
	private String font_type = "";
	private int Title_size = 19;
	private int table_width = 80;
	private FileOutputStream file_stream;
	private PdfWriter writer;

	/**
	 * 在pdf文件中添加水印
	 * 
	 * @param inputFile
	 *            原始文件
	 * @param outputFile
	 *            水印输出文件
	 * @param waterMarkName
	 *            水印名字
	 */
	private static void waterMark(String inputFile, String outputFile,
			String userPassWord, String ownerPassWord, String waterMarkName,
			int permission) {
		try {
			System.out.println(inputFile + "/" + outputFile);
			PdfReader reader = new PdfReader(inputFile);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
					outputFile));
			// 设置密码
			stamper.setEncryption(userPassWord.getBytes(), ownerPassWord
					.getBytes(), permission, false);
			/*
			 * int total = reader.getNumberOfPages() + 1; // Image image =
			 * Image.getInstance(imageFilePath); //
			 * image.setAbsolutePosition(200, 400); PdfContentByte under; int j
			 * = waterMarkName.length(); char c = 0; int rise = 0; for (int i =
			 * 1; i < total; i++) { rise = 500; under =
			 * stamper.getUnderContent(i); // 添加图片 // under.addImage(image);
			 * under.beginText(); under.setColorFill(Color.CYAN);
			 * under.setFontAndSize(base, 30); // 设置水印文字字体倾斜 开始 if (j >= 15) {
			 * under.setTextMatrix(200, 120); for (int k = 0; k < j; k++) {
			 * under.setTextRise(rise); c = waterMarkName.charAt(k);
			 * under.showText(c + ""); rise -= 20; } } else {
			 * under.setTextMatrix(80, 100); for (int k = 0; k < j; k++) {
			 * under.setTextRise(rise); c = waterMarkName.charAt(k);
			 * under.showText(c + ""); rise -= 38; } } // 字体设置结束
			 * under.endText(); // 画一个圆 // under.ellipse(250, 450, 350, 550); //
			 * under.setLineWidth(1f); // under.stroke();
			 * 
			 * }
			 */
			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Write_pdf(String file_name) throws DocumentException, IOException {
		font_type = "E:\\report\\fonts\\simkai.ttf";
		bfChinese_title = com.lowagie.text.pdf.BaseFont
				.createFont(font_type, BaseFont.IDENTITY_H,
						com.lowagie.text.pdf.BaseFont.NOT_EMBEDDED);
		bfChinese11 = new com.lowagie.text.Font(bfChinese_title,
				Title_size - 3, com.lowagie.text.Font.NORMAL);
		bfChinese12 = new com.lowagie.text.Font(bfChinese_title,
				Title_size - 2, com.lowagie.text.Font.NORMAL);
		bfChinese13 = new com.lowagie.text.Font(bfChinese_title,
				Title_size - 1, com.lowagie.text.Font.NORMAL);
		bfChinese14 = new com.lowagie.text.Font(bfChinese_title, Title_size,
				com.lowagie.text.Font.NORMAL);
		bfChinese16 = new com.lowagie.text.Font(bfChinese_title, 16,
				com.lowagie.text.Font.NORMAL);
		bfChinese20 = new com.lowagie.text.Font(bfChinese_title, 20,
				com.lowagie.text.Font.NORMAL);
		bfChinese32 = new com.lowagie.text.Font(bfChinese_title, 32,
				com.lowagie.text.Font.NORMAL, new Color(255, 0, 0));
		bfChinese10 = new com.lowagie.text.Font(bfChinese_title, 10,
				com.lowagie.text.Font.NORMAL);
		File file_report = new File(file_name);
		file_stream = new FileOutputStream(file_report);
		writer = PdfWriter.getInstance(document, file_stream);
		// 文档摘要编写
		document.addTitle("Hello World example");
		document.addSubject("This example shows how to add metadata");
		document.addKeywords("Metadata, iText, step 3, tutorial");
		document.addCreator("My program using iText");
		document.addAuthor("Bruno Lowagie");
		document.addHeader("Expires", "0");
		// 开始文档编写
		// writer.setEncryption(null, "hello".getBytes(), 0, 0);
		document.open();
	}

	/* 书写完成，关闭对象 */
	public void Write_clean() {
		document.close();
		writer.close();
		try {
			file_stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void talbe_color(Table talbe, Paragraph p, Color c) {
		Cell cell_color = new Cell();
		cell_color.setBackgroundColor(c); // 设置cell底层颜色
		cell_color.add(p);
		table.addCell(cell_color);
	}

	public void ptable_color(PdfPTable table, Paragraph p, Color c) {
		PdfPCell cell_color = new PdfPCell(p);
		cell_color.setBackgroundColor(c); // 设置cell底层颜色
		// cell_color.add(p);
		cell_color.setBorderColor(streak_Color);
		table.addCell(cell_color);
	}

	public void Pcell_color(PdfPTable table, Paragraph p, boolean is,
			int Align, int Colspan) {

		PdfPCell cell_color = new PdfPCell(p);
		if (is) {
			cell_color.setBackgroundColor(base_Color); // 设置cell底层颜色
			// cell_color.setFixedHeight(17);// 列高
		}
		cell_color.setHorizontalAlignment(Align);// 字居中
		if (Colspan > 1)
			cell_color.setColspan(Colspan);
		// cell_color.add(p);
		// cell_color.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
		cell_color.setBorderColor(streak_Color);
		table.addCell(cell_color);
	}

	public void Pcell_color(PdfPTable table, Paragraph p, boolean is,
			int Colspan) {
		Pcell_color(table, p, is, PdfPCell.ALIGN_CENTER, Colspan);
		// Pcell_color(talbe, p, is, PdfPCell.ALIGN_LEFT, Colspan);
	}

	public void Pcell_color(PdfPTable table, Paragraph p, boolean is) {
		Pcell_color(table, p, is, PdfPCell.ALIGN_CENTER, 1);
		// Pcell_color(talbe, p, is, PdfPCell.ALIGN_LEFT, 1);
	}

	private void Paragraph(Table table, Paragraph p) throws DocumentException {
		table = new Table(1);
		table.setBorderColor(new Color(255, 255, 255));
		table.addCell(p);
		document.add(table);
	}

	private void Paragraph(String data) throws DocumentException {
		Table table = new Table(1);
		table.setBorderColor(new Color(255, 255, 255));
		table.addCell(new Paragraph(data, bfChinese10));
		document.add(table);
	}

	public void Ptable_image_text(PdfPTable table, Paragraph p, String f)
			throws MalformedURLException, IOException, DocumentException {
		PdfPCell TMcell = new PdfPCell();
		float[] tablew = { 20, 40 };
		PdfPTable ptable_in = new PdfPTable(2);
		PdfPCell Tcell = new PdfPCell();
		// Tcell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		// ptable_in.setHorizontalAlignment(PdfPCell.ALIGN_TOP);
		// Tcell.setVerticalAlignment(PdfPCell.ALIGN_TOP);
		png = Image.getInstance(f);
		png.setWidthPercentage(70);
		png.setBorderWidth(1);

		Tcell.addElement(png);
		Tcell.setBorderColor(Color.white);

		// Tcell.setBorderColorLeft(streak_Color);
		// Tcell.setBorderColorTop(streak_Color);
		ptable_in.addCell(Tcell);

		Tcell = new PdfPCell();
		// Tcell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		// Tcell.setVerticalAlignment(PdfPCell.ALIGN_TOP);
		Tcell.setBorderColor(Color.white);

		Tcell.addElement(p);
		Tcell.setFixedHeight(19);
		// Tcell.setVerticalAlignment(0);
		ptable_in.addCell(Tcell);

		// Pcell_color(ptable_in,p,false);

		ptable_in.setWidthPercentage(80);
		ptable_in.setWidths(tablew);
		TMcell.setBorderColor(streak_Color);
		TMcell.addElement(ptable_in);
		TMcell.setVerticalAlignment(0);
		// TMcell.setBorderWidth(4);
		table.addCell(TMcell);
	}

	public String convert(long mill) {
		Date date = new Date(mill);
		String strs = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-m-dd hh:mm:ss");
			strs = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strs;
	}

	@SuppressWarnings("static-access")
	// 写标题
	private void set_chapter1(String content) throws DocumentException {
		firstinfo++;
		lastinfo = 1;
		chapter = new Chapter(new Paragraph(content, bfChinese14), firstinfo);
		document.add(chapter);
	}

	// 写标题
	private void set_chapter2(String content) throws DocumentException {
		lastinfo++;
		section[0] = chapter.addSection(new Paragraph(content, bfChinese13), 2);
		document.add(section[0]);
	}

	private void set_section(String content, int pies) throws DocumentException {
		lastinfo++;
		section[pies - 2] = section[pies - 3].addSection(new Paragraph(content,
				bfChinese11));
		document.add(section[pies - 2]);
	}

	public boolean set_chapter(String content, int plies)
			throws DocumentException {
		if (plies > 9)
			return false;
		switch (plies) {
		case 1:
			set_chapter1(content);
			break;
		case 2:
			set_chapter2(content);
			break;
		default:
			set_section(content, plies);
			break;
		}
		return true;
	}

	private void set_section(String content) throws DocumentException {
		lastinfo++;
		table = new Table(2);
		// table.setDefaultCellBorderColor(new Color(255,255,255));
		table.setBorderColor(new Color(255, 255, 255));
		chapter.addSection(new Paragraph(content, bfChinese14));
		table.addCell(new Paragraph(content, bfChinese14));
		anchor = new Anchor(firstinfo + "-" + lastinfo);
		anchor.setReference("#TOC-" + firstinfo + "-" + lastinfo);
		anchor.setName(firstinfo + "-" + lastinfo);
		cell = new Cell();
		cell.setHorizontalAlignment("RIGHT");
		cell.add(anchor);
		table.addCell(cell);
		table.setWidth(100);
		document.add(table);
	}

	// 设置目录 level :1,2；tz:符号个数
	private void set_index(String content, int level) throws DocumentException {
		set_index(content, level, 0);
	}

	private void set_index(String content, int level, int tz)
			throws DocumentException {
		int k = 0, m = 0;
		if (level == 1) {
			firstinfo++;
			lastinfo = 1;
		} else {
			lastinfo++;
			content = "" + content;
			tz = tz + 2;
		}
		m = 34 - ((firstinfo + "" + lastinfo).length() - 1) / 2 - tz;
		content += "   ";
		for (k = 0; k < m; k++)
			content += "．";
		content += "  ";
		// System.out.print(Gfun.tounicode(content).length()+"  ");
		p = new Paragraph(content, bfChinese14);
		anchor = new Anchor(firstinfo + "-" + lastinfo);
		anchor.setName("TOC-" + firstinfo + "-" + lastinfo);
		anchor.setReference("#" + firstinfo + "-" + lastinfo);
		p.add(anchor);
		document.add(p);
		document.addTitle("ddddsss");
	}// end fun set_index

	public void write_av(String data) {
		try {
			Paragraph(data);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write_av(String image, String msg, int Align)
			throws BadElementException, MalformedURLException, IOException {
		write_av(image, msg, Align, null);
	}

	// 0:字在左 2:字在右 \n可以换行
	public void write_av(String image, String msg, int Align, Color BorderColor)
			throws BadElementException, MalformedURLException, IOException {
		int i = 0;
		int wind = 2;// 列数

		Image jpeg = Image.getInstance(image);
		p = new Paragraph();
		PdfPCell pcell = null, pcellm = null;
		if (BorderColor == null)
			BorderColor = streak_Color;
		pcell = new PdfPCell();
		pcell.addElement(jpeg);

		pcell.setBorderColor(BorderColor);
		if (msg == null) {
			wind = 1;
		} else {
			String tmp[] = msg.split("\n");
			for (i = 0; i < tmp.length; i++)
				p.add(new Paragraph(tmp[i], bfChinese10));
			pcellm = new PdfPCell();
			pcellm.setPhrase(p);
			pcellm.setBorderColor(BorderColor);
		}
		PdfPTable ptable = new PdfPTable(wind);
		if (Align == Element.ALIGN_RIGHT) {
			ptable.addCell(pcell);
			if (wind == 2)
				ptable.addCell(pcellm);
		} else {
			if (wind == 2)
				ptable.addCell(pcellm);
			ptable.addCell(pcell);
		}
		/*
		 * if(wind == 2) ptable.setWidthPercentage(table_width); else
		 * ptable.setWidthPercentage(table_width - 20);
		 */
		ptable.setWidthPercentage(table_width);
		try {
			document.add(ptable);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean write_av(PromiseData Pdata, float tablewidth[], boolean image)
			throws DocumentException, MalformedURLException, IOException {
		int i = 0, j = 0;
		int Vlen = 0;// 行向宽度
		Hashtable<Integer, String[]> data = Pdata.Hashdata;
		Hashtable<Integer, String[]> colordata = Pdata.Colordata;
		Hashtable<Integer, Integer[]> Align = Pdata.Align;
		Hashtable<Integer, Integer[]> Colspan = Pdata.Colspan;
		int align = 0, colspan = 0;
		boolean color = false;
		if (data == null)
			return false;
		DefaultCategoryDataset ipdata = new DefaultCategoryDataset();
		Vlen = data.get(0).length;
		PdfPTable ptable = new PdfPTable(Vlen);
		// Pcell_color(PdfPTable table, Paragraph p, boolean is,int Align, int
		// Colspan)
		for (i = 0; i < data.size(); i++) {
			Vlen = data.get(i).length;
			for (j = 0; j < Vlen; j++) {
				if (Align.get(i) != null)
					align = Align.get(i)[j];
				else
					align = 0;
				if (Colspan.get(i) != null) {
					colspan = Colspan.get(i)[j];
				} else {
					colspan = 1;
				}
				if (colspan > 1)
					Vlen = Vlen - colspan + 1;
				if (colordata.get(i) != null
						&& colordata.get(i)[j].equals("true"))
					color = true;
				else
					color = false;

				Pcell_color(ptable, new Paragraph(data.get(i)[j], bfChinese10),
						color, align, colspan);

			}

		}
		ptable.setWidthPercentage(table_width);
		// float[] tablewidths2 = { 19, 13, 29, 11, 11, 11, 11, 11, 11 };
		if (tablewidth != null && tablewidth.length == Vlen)
			ptable.setWidths(tablewidth);
		document.add(ptable);
		if (image) {
			jpie p = new jpie();
			for (i = 1; i < data.size(); i++) {
				Vlen = data.get(i).length;
				for (j = 1; j < Vlen; j++)
					ipdata.setValue(Integer.parseInt(data.get(i)[j].trim()),
							data.get(0)[j], data.get(i)[0]);// 需要改进
				if (i % 5 == 0 || data.size() == i + 1) {
					p.drawBar("C:\\" + i + ".jpg", ipdata, " ", " ", " ", 692,
							220, 0);
					ipdata.clear();
					write_av("C:\\" + i + ".jpg", null, 2);
				}
			}
		}

		return true;
	}

	public class PromiseData1 {
		private int key = 0;
		public Hashtable<Integer, String[]> Hashdata = new Hashtable<Integer, String[]>();
		public Hashtable<Integer, String[]> Colordata = new Hashtable<Integer, String[]>();

		public void put(String data[]) {
			Hashdata.put(key++, data);
		}

		public String[] get(int gkey) {
			return Hashdata.get(gkey);
		}
	}
}
