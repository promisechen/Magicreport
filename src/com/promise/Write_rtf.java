/*
********************************************************************************
*                                                                              *
*                         word pdf html ����ͳһ�ӿ�                           *
*                                                                              *
********************************************************************************
*
* ��Ȩ����:  Copyright(c) 2000-2010 PROMISE Networks.All Right Reserved
*
* �ļ��б�:  ALL
*
* ��    ��:  �κ��˶������⴫���޸ģ��޸ĺ��뽫�޸Ĳ��ַ���chenlx10@163.com,�κ�
             ���ⶼ����chenlx10@163.com��ϵ��δ������ַ��www.frdog.org
*
* ��    ��:   ������
*
* ��    ��:   v1.0
*
* ����:     20100920
*
********************************************************************************
*
* ��ʷ��¼:
*
*         v1.0 20100920 edited by MagicPromise
*
*/

package com.promise;

import com.lowagie.text.rtf.graphic.*;

import com.lowagie.text.Anchor; /*      */
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell; /*      */
import com.lowagie.text.Chapter; /*      */
import com.lowagie.text.Document; /*      */
import com.lowagie.text.DocumentException; /*      */
import com.lowagie.text.Element;
import com.lowagie.text.Font; /*      */
import com.lowagie.text.Image; /*      */
import com.lowagie.text.PageSize; /*      */
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section; /*      */
import com.lowagie.text.Table; /*      */
import com.lowagie.text.pdf.BaseFont; /*      */
import com.lowagie.text.pdf.PdfPCell; /*      */
import com.lowagie.text.pdf.PdfPTable; /*      */
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.*;
import org.jfree.*;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*      */import java.io.BufferedReader; /*      */
import java.io.File; /*      */
import java.io.FileInputStream; /*      */
import java.io.FileNotFoundException; /*      */
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter; /*      */
import java.io.IOException;
import java.io.InputStream; /*      */
import java.io.InputStreamReader;
import java.io.OutputStream; /*      */
import java.io.OutputStreamWriter; /*      */
import java.io.PrintStream; /*      */
import java.sql.Connection; /*      */
import java.sql.Driver; /*      */
import java.sql.DriverManager; /*      */
import java.sql.ResultSet;
import java.sql.SQLException; /*      */
import java.sql.Statement; /*      */
import java.util.ArrayList; /*      */
import java.util.Date; /*      */
import java.util.Hashtable;

import javax.servlet.ServletContext; /*      */
import javax.servlet.jsp.JspWriter; /*      */
import org.jfree.data.category.DefaultCategoryDataset; /*      */
import org.jfree.data.general.DefaultPieDataset;

/*      */import com.lowagie.text.Anchor; /*      */
import com.lowagie.text.Cell; /*      */
import com.lowagie.text.Chapter; /*      */
import com.lowagie.text.Document; /*      */
import com.lowagie.text.DocumentException; /*      */
import com.lowagie.text.Font;

/*      */import com.lowagie.text.Image; /*      */
import com.lowagie.text.PageSize; /*      */
import com.lowagie.text.Paragraph; /*      */
import com.lowagie.text.Table; /*      */
import com.lowagie.text.pdf.BaseFont; /*      */
import com.lowagie.text.pdf.PdfPCell; /*      */
import com.lowagie.text.pdf.PdfPTable; /*      */
import com.lowagie.text.pdf.PdfWriter; /*      */
import java.awt.Color; /*      */
import java.io.BufferedReader; /*      */
import java.io.File; /*      */
import java.io.FileOutputStream; /*      */
import java.io.IOException; /*      */
import java.io.InputStreamReader; /*      */
import java.io.PrintStream; /*      */
import java.sql.Connection; /*      */
import java.sql.Driver; /*      */
import java.sql.DriverManager; /*      */
import java.sql.ResultSet; /*      */
import java.sql.Statement; /*      */
import javax.servlet.ServletContext; /*      */
import javax.servlet.jsp.JspWriter; /*      */
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.io.*;
import java.net.MalformedURLException;

import com.lowagie.text.rtf.*;

@SuppressWarnings("unused")
public class Write_rtf implements NPromise {
	int firstinfo = 0, lastinfo = 0;
	Chapter chapter;
	Section section2, section3, section4;
	String filepath = "e:\\report\\", Jheader;
	String imgpath = "e:\\report\\img\\";
	String fontpath = null;
	String tmppath = null;
	jpie pie = null;
	Image png = null;
	Color base_Color = new Color(214, 233, 242);// ��̬��ɫ
	Color streak_Color = new Color(154, 202, 225);// ��̬��ɫ
	String htempStr[] = null;// ������ʱ�����ű�����ַ�����ѭ�����ɱ��
	String tempStr[] = null;// ������ʱ�����ű�����ַ�����ѭ�����ɱ��
	int table_width = 80;
	int talbe_with = 0;
	boolean su = true;
	// only me
	OutputStream write_report = null;
	RrfDocument doc;
	// ReportTable table;
	com.lowagie.text.Font bfChinese12, bfChinese14, bfChinese16, bfChinese20;
	com.lowagie.text.pdf.BaseFont bfChinese;
	// del String tempStr[]=null;
	String tempData[] = null;
	String file;
	int font_chapter_size = 13, font_size = 10;// �����С
	String font_chapter = "����", font_txt = "����";

	public String ReportHead_Foot() {
		return "{\\headerf\\pard\\sl-240\\sb770\\sa430\\plain\\tqc\\tx4512\\tqr\\tx9025 {}\\tab {}\\tab {}\\par}"
				+ "{\\footerf\\pard\\sl-240\\sb770\\sa910\\plain\\tqc\\tx4512\\tqr\\tx9025 {}\\tab {}\\tab {}\\par}"

				+ "\\pgnrestart\\titlepg"
				+ "{\\footer\\f14\\tqc\\tx4000 \\tab {}\\tab { \\chpgn }\\par}"

				+ "{\\header\\f14\\tqc\\tx4512\\tqr\\tx9025\\horzsect{\\ul \\tab}{\\ul\\tab}{\\ul "
				+ Jheader + "}{\\rtlch\\fcs1    } \\par}";
	}

	public Write_rtf(String file_name) {
		try {
			write_report = new FileOutputStream(file_name);

			File file_report = new File(file_name);
			if (!file_report.exists())
				file_report.createNewFile();
			doc = new RrfDocument();
			write_report.write(ReportHead(font_chapter, font_txt).getBytes());
		} catch (Exception e) {

		}
	}

	public void Write_clean() {
		try {
			write_report.write(ReportEnd().getBytes());
			write_report.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean set_chapter(String content, int plies) {
		if (plies > 9 || content == null || plies < 1)
			return false;
		// System.out.println(doc.set_chapter(content,plies));
		try {
			write_report.write(doc.set_chapter(content, plies).getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public void write_av(String data) {
		try {
			write_report
					.write(PeportParagraph(data, font_size, "B").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void write_av(String image, String msg, int Align, Color BorderColor)
			throws BadElementException, MalformedURLException, IOException {
		ReportTable table;
		if (msg == null) {
			table = new ReportTable(1);

		} else {
			table = new ReportTable(2);

		}

		if (Align == Element.ALIGN_RIGHT) {
			table.set_width("60,40");
			table.add_cell(new ReportCell(image, "ImgL", 100));
			table.add_cell(PeportParagraph(msg, font_size, ""));
		} else {
			table.set_width("40,60");
			table.add_cell(PeportParagraph(msg, font_size, ""));
			table.add_cell(new ReportCell(image, "ImgL", 100));
		}
		// if(BorderColor != null)
		table.set_noborder();
		table.write_cellbyte(write_report);
	}

	public boolean write_av(PromiseData Pdata, float tablewidth[], boolean image)
			throws DocumentException, MalformedURLException, IOException {
		int i = 0, j = 0, k = 0, m = 0;
		ReportTable table;
		write_report.write(PeportParagraph("", 36).getBytes());
		write_report.write(PeportParagraph("", 36).getBytes());
		// table.set_width("100");
		int Vlen = 0;// ������
		Hashtable<Integer, String[]> data = Pdata.Hashdata;
		Hashtable<Integer, String[]> colordata = Pdata.Colordata;
		Hashtable<Integer, Integer[]> Align = Pdata.Align;
		Hashtable<Integer, Integer[]> Colspan = Pdata.Colspan;
		int colspan = 0;
		String color = "", align = "";
		if (data == null)
			return false;
		DefaultCategoryDataset ipdata = new DefaultCategoryDataset();
		Vlen = data.get(0).length;
		table = new ReportTable(Vlen);

		// Pcell_color(PdfPTable table, Paragraph p, boolean is,int Align, int
		// Colspan)
		for (i = 0; i < data.size(); i++) {
			Vlen = data.get(i).length;
			for (j = 0; j < Vlen; j++) {
				if (Align.get(i) != null) {
					if (Align.get(i)[j] == PromiseNN.ALIGN_LEFT)
						align = "L";
					else if (Align.get(i)[j] == PromiseNN.ALIGN_RIGHT)
						align = "R";
					else if (Align.get(i)[j] == PromiseNN.ALIGN_CENTER)
						align = "C";
					else
						align = "L";
				} else
					align = "L";
				if (Colspan.get(i) != null) {
					colspan = Colspan.get(i)[j];
				} else {
					colspan = 1;
				}
				if (colspan > 1)
					Vlen = Vlen - colspan + 1;
				if (colordata.get(i) != null
						&& colordata.get(i)[j].equals("true"))
					color = "T";
				else
					color = "";
				table.add_cell(new ReportCell(data.get(i)[j], color + align));
			}
		}

		// ptable.setWidthPercentage(table_width);

		if (tablewidth != null && tablewidth.length == Vlen)
			;// table.set_width(tablewidth);

		table.write_cellbyte(write_report);
		if (image) {
			table.set_width("100");
			jpie p = new jpie();
			for (i = 1; i < data.size(); i++) {
				Vlen = data.get(i).length;
				for (j = 1; j < Vlen; j++)
					ipdata.setValue(Integer.parseInt(data.get(i)[j].trim()),
							data.get(0)[j], data.get(i)[0]);// ��Ҫ�Ľ�
				if (i % 5 == 0 || data.size() == i + 1) {
					p.drawBar("C:\\" + i + ".jpg", ipdata, " ", " ", " ", 692,
							220, 0);
					ipdata.clear();
					table.add_cell(new ReportCell("C:\\" + i + ".jpg", "ImgR",
							80));

				}
			}
			table.write_cellbyte(write_report);
		}

		return true;

	}

	public String write(String filepath, String filename) {
		int i = 0, j = 0, k = 0, m = 0;
		ReportTable table;
		file = filepath + filename;
		doc = new RrfDocument();
		talbe_with = 2;
		table = new ReportTable(talbe_with);
		// doc.drawBar(filename, data, title, rowstr, colstr, width, height);
		jpie pie = new jpie();
		DefaultCategoryDataset ipdata = new DefaultCategoryDataset();
		ipdata.setValue(1, "r1", "c1");
		ipdata.setValue(2, "r2", "c1");
		ipdata.setValue(6, "r3", "c1");

		ipdata.setValue(8, "r1", "c2");
		ipdata.setValue(9, "r2", "c2");
		ipdata.setValue(4, "r3", "c2");

		ipdata.setValue(8, "r1", "c3");
		ipdata.setValue(9, "r2", "c3");
		ipdata.setValue(5, "r3", "c3");

		pie.drawBar("C:\\bar.jpg", ipdata, "����", "����", "���", 692, 220, 0);

		try {
			write_report = new FileOutputStream(file);
			File file_report = new File(file);
			if (!file_report.exists())
				file_report.createNewFile();
			write_report.write(ReportHead(font_chapter, font_txt).getBytes());

			write_report.write(PeportParagraph("", 0, "BC").getBytes());
			write_report.write(PeportParagraph("", 0, "BC").getBytes());
			write_report.write(PeportParagraph("", 0, "BC").getBytes());
			write_report.write(PeportParagraph("", 0, "BC").getBytes());
			// ��Ƥ
			write_report.write(PeportParagraph("����NVSS6.0������ɨ��ϵͳ", 32, "BC")
					.getBytes());
			write_report.write(PeportParagraph("", 0, "BC").getBytes());
			write_report.write(PeportParagraph("      ---IPS������ɨ��", 16, "BC")
					.getBytes());
			write_report.write(PeportParagraph("", 0, "BC").getBytes());

			// �����
			for (i = 0; i < 20; i++) {
				write_report.write(PeportParagraph(" ").getBytes());
			}
			table = new ReportTable(talbe_with);
			table.set_width("45,55");
			table.set_noborder();
			table.add_cell(new ReportCell(PeportChunk("������ʽ��", 16), "R"));
			table.add_cell(new ReportCell(PeportChunk("style_name", 16)));
			table.add_cell(new ReportCell(PeportChunk("��λ��", 16), "R"));
			table.add_cell(new ReportCell(PeportChunk("company_name", 16)));
			table.add_cell(new ReportCell(PeportChunk("�����ˣ�", 16), "R"));
			table.add_cell(new ReportCell(PeportChunk("scan_man", 16)));
			table.add_cell(new ReportCell(PeportChunk("����ʱ�䣺", 16), "R"));
			table.add_cell(new ReportCell(PeportChunk("scan_time", 16)));
			table.write_cellbyte(write_report);
			write_report.write(NewPage().getBytes());

			// ˵��

			write_report.write(NewPage().getBytes());
			write_report.write(NewPage().getBytes());
			// 1�ۺ�����
			write_report.write(doc.Chapter("�ۺ�����").getBytes());

			// 1.1 ��������
			write_report.write(doc.Section("��������").getBytes());
			// ��������
			write_report
					.write(PeportParagraph(
							"      ����Ʒ��2010.3.6�������������ɨ�裬��ɨ��15̨���� ����Ʒ��2010.3.6�������������ɨ�裬��ɨ��15̨���� ����Ʒ��2010.3.6�������������ɨ�裬��ɨ��15̨��������Ʒ��2010.3.6�������������ɨ�裬��ɨ��15̨����������6̨���ߡ�",
							font_size).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			talbe_with = 2;
			table = new ReportTable(talbe_with);
			tempStr = new String[] { "��������", "������Ŀ", "����ֵ  ", "�ǳ�Σ������",
					"ɨ�迪ʼʱ��", "ɨ�����ʱ��" };
			table.set_width("30,70");
			for (i = 0; i < 6; i++) {
				table.add_cell(new ReportCell(tempStr[i], "T"));
				table.add_cell(tempStr[i]);

			}
			table.write_cellbyte(write_report);

			// ��ͼ
			write_report.write(PeportParagraph(" ", 36).getBytes());
			talbe_with = 2;
			table = new ReportTable(talbe_with);
			table.set_width("40,60");
			table.set_noborder();
			String title = "jumpͳ��";
			// write_img(w,"C:\\c.JPG",100);
			table
					.add_cell(PeportParagraph(
							"����Ʒ�� 2010��05��28�� ������   ����  08:17:44 �������������ɨ�裬��ɨ��1̨����������1̨���ߣ������������繲��5��©��",
							10, ""));
			DefaultPieDataset piedata = new DefaultPieDataset();
			piedata.setValue("��", 20);
			piedata.setValue("��", 20);
			piedata.setValue("��", 20);
			piedata.setValue("d", 20);
			piedata.setValue("g", 20);
			piedata.setValue("s", 20);
			pie.draw3DPie(tmppath + "tmp.jpg", piedata, title, 250, 200);
			table.add_cell(new ReportCell(tmppath + "tmp.jpg", "ImgR", 100));
			table.write_cellbyte(write_report);
			write_report.write(PeportParagraph("", 36).getBytes());

			// 1.2��Σ������
			write_report.write(doc.Section("��Σ������").getBytes());
			write_report
					.write(PeportParagraph(
							"    ������������ر��ע:10.0.13.120(chen)��10.0.1.11(li)����ע��̰�ЧӦ,��ֹ�ڿ�ͨ��������Σ���������⼦����������������̱����\n  ����������绷�����ڸ��ӣ�����ά������ʹ�ý���ips�豸����ֹ�ڿ͹����������ڲ����簲ȫ��",
							font_size).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			talbe_with = 8;
			table = new ReportTable(talbe_with);
			table.set_width("20,13,11,11,11,11,11,12");
			tempStr = new String[] { "�ʲ�IP", "������", "���ռ���", "����", "�߷���", "�з���",
					"�ͷ���", "��Ϣ" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "TC"));

			tempStr = new String[] { "10.0.13.110", "��", "155", "15", "12",
					"13", "15", "0" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			tempStr = new String[] { "10.0.13.110", "��", "155", "15", "12",
					"13", "15", "0" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			table.write_cellbyte(write_report);

			// 1.3�������Σ��©��
			write_report.write(doc.Section("�������Σ��©��").getBytes());

			write_report.write(PeportParagraph(
					"      �������©���ر��ע��cgi,p2p��©���ǹ����ߵ�����뼰ʱ�޲�©����", font_size)
					.getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			talbe_with = 6;
			table = new ReportTable(talbe_with);
			table.set_width("13,12,30,15,15,15");
			tempStr = new String[] { "©�����", "©����� ", "©������", " CVE���", "���յȼ�",
					"��ض˿�" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "TC"));

			tempStr = new String[] { "doc©��", "33", "155", "155", "155", "155" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			tempStr = new String[] { "doc©��", "33", "155", "155", "155", "155" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			table.write_cellbyte(write_report);

			// 1.4����ϵͳ������
			write_report.write(doc.Section("����ϵͳ�˺�").getBytes());

			write_report
					.write(PeportParagraph(
							"     ����ϵͳ�����ʹ�������������ȫ����ֹ������¼��ȡ���ϡ�", font_size)
							.getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			talbe_with = 5;
			table = new ReportTable(talbe_with);
			// table.set_width("20,15,15,15,15");
			tempStr = new String[] { "IP��ַ", "������", "�û���", "����", "����" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "TC"));

			tempStr = new String[] { "10.0.13.110", "�ź���", "zhang", "123", "��" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			tempStr = new String[] { "10.0.13.110", "�ź���", "zhang", "123", "��" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			table.write_cellbyte(write_report);

			write_report.write(NewPage().getBytes());

			// �ڶ��� �����Ƕȷ�������
			write_report.write(doc.Chapter("�����Ƕȷ�������").getBytes());
			write_report.write(PeportParagraph(" ", 36).getBytes());
			talbe_with = 2;
			table = new ReportTable(talbe_with);
			table.set_width("40,60");
			table.set_noborder();
			title = "jumpͳ��";
			// write_img(w,"C:\\c.JPG",100);
			table
					.add_cell(PeportParagraph(
							"����Ʒ�� 2010��05��28�� ������   ����  08:17:44 �������������ɨ�裬��ɨ��1̨����������1̨���ߣ������������繲��5��©��",
							10, ""));
			piedata = new DefaultPieDataset();
			piedata.setValue("��", 20);
			piedata.setValue("��", 20);
			piedata.setValue("��", 20);
			piedata.setValue("d", 20);
			piedata.setValue("g", 20);
			piedata.setValue("s", 20);
			pie.draw3DPie(filepath + "c.jpg", piedata, title, 250, 200);
			table.add_cell(new ReportCell(filepath + "c.jpg", "ImgR", 100));
			table.write_cellbyte(write_report);
			write_report.write(PeportParagraph("", 36).getBytes());
			// 2.1������������
			write_report.write(doc.Section("������������").getBytes());

			write_report
					.write(PeportParagraph(
							"    ������������ر��ע:10.0.13.120(chen)��10.0.1.11(li)����ע��̰�ЧӦ,��ֹ�ڿ�ͨ��������Σ���������⼦����������������̱����\n  ����������绷�����ڸ��ӣ�����ά������ʹ�ý���ips�豸����ֹ�ڿ͹����������ڲ����簲ȫ��",
							font_size).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());
			talbe_with = 8;
			table = new ReportTable(talbe_with);
			table.set_width("20,13,11,11,11,11,11,12");
			tempStr = new String[] { "�ʲ�IP", "������", "���ռ���", "����", "�߷���", "�з���",
					"�ͷ���", "��Ϣ" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "TC"));

			tempStr = new String[] { "10.0.13.110", "��", "155", "15", "12",
					"13", "15", "0" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			tempStr = new String[] { "10.0.13.110", "��", "155", "15", "12",
					"13", "15", "0" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			table.write_cellbyte(write_report);

			// 2.2�����������б�

			write_report.write(doc.Section("�����������б�").getBytes());

			write_report.write(PeportParagraph("", 36).getBytes());
			talbe_with = 4;
			table = new ReportTable(talbe_with);
			// table.set_width("20,13,11,11,11,11,11,12");
			tempStr = new String[] { "10.0.13.120", "10.0.13.111",
					"10.0.13.110", "10.0.13.121" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "TC"));

			tempStr = new String[] { "10.0.13.120", "10.0.13.111",
					"10.0.13.110", "10.0.13.121" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			tempStr = new String[] { "10.0.13.120", "10.0.13.111",
					"10.0.13.110", "10.0.13.121" };
			for (i = 0; i < talbe_with; i++)
				table.add_cell(new ReportCell(tempStr[i], "C"));
			table.write_cellbyte(write_report);
			write_report.write(NewPage().getBytes());
			// ������ ©���Ƕȷ�������
			write_report.write(doc.Chapter("©���Ƕȷ�������").getBytes());
			write_report
					.write(PeportParagraph(
							"    ���´�©���Ƕȶ�������������ۺ���ϸ�������ֱ�Դӷ���ϵͳ����в��Ӧ�á�©�����еĽǶȽ��з���������ϸ�۲����ݣ��Ķ����½���������������Ĺ���\n    �������������״̬�����ģ���鿴�½ڣ�\"�����Ƕȷ�������\"��\n    ��������Ǽ�����Ա���������Ա�����������¡�",
							font_size).getBytes());
			write_report.write(PeportParagraph("", 36).getBytes());

			// �������ͷ���
			write_report.write(doc.Section("����").getBytes());

			write_report
					.write(PeportParagraph(
							"    ��Ҫ�ķ�����ftp��mysql��ssh��apache�ȷ��񣬱�ϵͳͨ�����ɨ��,��������������mysql��rpc�����©���϶�,�����ԭ��ʱ�޲��� ",
							font_size).getBytes());

			write_test(filepath);

			write_report.write(doc.Section("ϵͳ").getBytes());

			write_report.write(PeportParagraph(
					"    ��Ҫ����ϵͳ��windows��linux��unix��ϵͳ�������ע���з�������linuxϵͳ��",
					font_size).getBytes());
			write_test(filepath);

			write_report.write(doc.Section("��в").getBytes());

			write_report
					.write(PeportParagraph(
							"    ��Ҫ��в��Զ����Ϣ��ȡ��Զ�����ݲ�����ϵͳ����ϵͳͨ�����ɨ�裬��������������Զ����Ϣ��ȡ©���϶࣬�����ԭ��ʱ�޲��� ",
							font_size).getBytes());
			write_test(filepath);

			write_report.write(doc.Section("Ӧ��").getBytes());
			write_report
					.write(PeportParagraph(
							"    ��ҪӦ����http��ftp��im�ȡ���ϵͳͨ�����ɨ�裬��������������http��ftp©���϶࣬�����ԭ��ʱ�޲���",
							font_size).getBytes());
			write_test(filepath);

			write_report.write(doc.Section("©�����а�").getBytes());
			write_report.write(PeportParagraph("  ©�������������������©�������", font_size)
					.getBytes());
			write_test(filepath);
			write_report.write(NewPage().getBytes());

			// ������ ������
			write_report.write(doc.Chapter("������").getBytes());
			write_report.write(doc.Section("����ϵͳ").getBytes());
			write_test1(filepath);
			write_report.write(doc.Section("Ӧ�����").getBytes());
			write_test1(filepath);
			write_report.write(NewPage().getBytes());
			// ������ ©������
			write_report.write(doc.Chapter("©������").getBytes());
			write_report.write(doc.Section("����10.0.13.120").getBytes());
			write_report.write(doc.Section3("������Ҫ").getBytes());
			write_report.write(doc.Section3("©��").getBytes());
			write_report.write(doc.Section4("©����Ҫ��Ϣ").getBytes());
			write_report.write(doc.Section4("©����ϸ��Ϣ").getBytes());
			// ������ ���ս���
			write_report.write(doc.Chapter("���ս���").getBytes());
			// ������ �ο���׼
			write_report.write(doc.Chapter("�ο���׼").getBytes());
			write_report.write(doc.Section("©����׼").getBytes());
			write_report.write(doc.Section("�������ձ�׼").getBytes());
			write_report.write(doc.Section("������ձ�׼").getBytes());
			write_report.write(doc.Section("���ս���").getBytes());

			// write_report.write(PeportParagraph(" "));
			write_report.write(ReportEnd().getBytes());
			write_report.close();
			System.out.print("doc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sadf";
	}

	public void write_test(String filepath) throws IOException {
		int i = 0, j = 0, k = 0, m = 0;
		ReportTable table;
		write_report.write(PeportParagraph("", 36).getBytes());
		write_report.write(PeportParagraph("", 36).getBytes());
		table = new ReportTable(5);
		table.set_width("40,15,15,15,15");
		tempStr = new String[] { "���", "�߷���", "�з���", "�ͷ���", "�ϼ�" };
		for (i = 0; i < 5; i++)
			table.add_cell(new ReportCell(tempStr[i], "TC"));

		tempData = new String[] { "cgi", "50", "50", "50", "200" };
		for (i = 0; i < 5; i++)
			table.add_cell(new ReportCell(tempData[i], "C"));
		for (i = 0; i < 5; i++)
			table.add_cell(new ReportCell(tempData[i], "C"));
		for (i = 0; i < 5; i++)
			table.add_cell(new ReportCell(tempData[i], "C"));
		table.write_cellbyte(write_report);

		table.set_width("100");
		// table.add_cell(new ReportCell(filepath+"z.jpg","ImgR",80));
		table.write_cellbyte(write_report);
	}

	public void write_test1(String filepath) throws IOException

	{
		ReportTable table;
		write_report.write(PeportParagraph("", 36).getBytes());
		int i = 0, j = 0, k = 0, m = 0;
		table = new ReportTable(4);
		table.set_width("40,20,20,20");

		tempStr = new String[] { "IP��ַ", "�û���", "����", "����" };
		for (i = 0; i < 4; i++)
			table.add_cell(new ReportCell(tempStr[i], "TC"));

		tempData = new String[] { "10.0.13.120", "root", "123", "ʲô" };
		for (i = 0; i < 4; i++)
			table.add_cell(new ReportCell(tempData[i], "C"));
		for (i = 0; i < 4; i++)
			table.add_cell(new ReportCell(tempData[i], "C"));
		for (i = 0; i < 4; i++)
			table.add_cell(new ReportCell(tempData[i], "C"));
		table.write_cellbyte(write_report);
	}

	public void writebyte(OutputStream out, String src) throws IOException {
		out.write(src.getBytes());
	}

	String chcode = "\\f11";

	// rtf�ļ�ͷ
	public String ReportHead(String font_chapter_type, String font_type) {
		java.util.Date nowdate = new java.util.Date();
		if (font_chapter_type == null)
			font_chapter_type = "����";

		if (font_type == null)
			font_type = "����";

		String datestr = "\\yr" + (1900 + nowdate.getYear()) + "\\mo"
				+ (nowdate.getMonth() + 1) + "\\dy" + nowdate.getDay() + "\\hr"
				+ nowdate.getMinutes() + "\\min" + nowdate.getSeconds();
		return "{\\rtf1\\ansi\\deff0"
				+

				"{\\fonttbl"
				+ "{\\f0\\fnil\\fcharset134\\fprq2{\\*\\panose 02010600030101010101}\\'cb\\'ce\\'cc\\'e5{\\*\\falt SIMKAI};}"
				+ "{\\f1\\fdecor Symbol;}"
				+ "{\\f2\\fswiss Helv;}"
				+ "{\\f3\\qc\\b\\deff24;}"
				+

				"{\\f10\\fnil\\fcharset134\\fprq2{\\*\\panose 02010600030101010101}\\'cb\\'ce\\'cc\\'e5\\fttruetype ����{\\*\\falt ����};}"
				+
				// ����
				"{\\f11\\fnil\\fcharset134\\fprq2{\\*\\panose 02010600030101010101}\\'cb\\'ce\\'cc\\'e5\\fttruetype "
				+ font_type
				+ "{\\*\\falt ����};}"
				+
				// ����
				"{\\f12\\fnil\\fcharset134\\fprq2{\\*\\panose 02010600030101010101}\\'cb\\'ce\\'cc\\'e5\\fttruetype "
				+ font_chapter_type
				+ "{\\*\\falt ����};}"
				+

				"{\\f13\\fnil\\fttruetype ����\\fcharset134\\fprq2{\\*\\panose 02010600030101010101}\\'cb\\'ce\\'cc\\'e5{\\*\\falt ����};}"
				+
				// ҳü
				"{\\f14\\fnil\\fcharset134\\fprq2{\\*\\panose 02010600030101010101}\\'cb\\'ce\\'cc\\'e5\\fttruetype "
				+ "����"
				+ "{\\*\\falt ����};}"
				+ "}"
				+ "{\\colortbl;"
				+ "\\red0\\green0\\blue0;"
				+ // ��
				"\\red255\\green0\\blue0;"
				+ // �������գ�c
				"\\red255\\green51\\blue204;"
				+ // �߷��գ�h
				"\\red255\\green153\\blue0;"
				+ // �з��գ�m
				"\\red0\\green0\\blue255;"
				+ // �ͷ��գ�l
				"\\red0\\green128\\blue0;"
				+ // ��Ϣ���գ�i
				"\\red217\\green217\\blue217;"
				+ // ���ҵף�bg
				"\\red255\\green255\\blue0;"
				+ "\\red255\\green255\\blue255;"
				+ // ��ɫ
				"\\red192\\green192\\blue192;"
				+ // ��ɫ10
				"}"
				+
				// "{\\s1\\qj \\li0\\ri0\\sb2\\sa1330\\sl678\\slmult0 \\pnulth\\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs44\\lang1033\\langfe2052\\kerning44\\loch\\f0\\hich\\af0\\dbch\\af17\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 1;}"+
				"{\\stylesheet"
				+ "{\\fs24 \\snext0Normal;}"
				+ "{\\s1\\qj \\li0\\ri0\\sb260\\sa1330\\sl678\\slmult0 \\sbauto \\pnulth\\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs44\\lang1033\\langfe2052\\kerning44\\loch\\f0\\hich\\af0\\dbch\\af17\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 1;}"
				+ "{\\s2\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 2;}"
				+ "{\\s3\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 3;}"
				+ "{\\s4\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 4;}"

				+ "{\\s5\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 5;}"
				+ "{\\s6\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 6;}"
				+ "{\\s7\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 7;}"
				+ "{\\s8\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 8;}"
				+ "{\\s9\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 9;}"
				+ "{\\s10\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 10;}"
				+ "{\\s11\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 11;}"
				+ "{\\s12\\qj \\li0\\ri0\\sb260\\sa260\\sl416\\slmult2 \\keep\\keepn\\nowidctlpar\\aspalpha\\aspnum\\faauto\\adjustright\\rin0\\lin0\\itap0 \\b\\fs32\\lang1033\\langfe2052\\kerning2\\loch\\f1\\hich\\af1\\dbch\\af21\\cgrid\\langnp1033\\langfenp2052 \\sbasedon0 \\snext0 heading 12;}"
				+

				"}"
				+ "{\\info"
				+ "{\\author jump ld}"
				+ "{\\creatim"
				+ datestr
				+ "}"
				+ "{\\version1}"
				+ "{\\edmins0}"
				+ "{\\nofpages1}"
				+ "{\\nofwords0}"
				+ "{\\nofchars0}"
				+ "{\\vern8351}"
				+ "}"
				/*
				 * +
				 * "{\\footerr\\f14                                -\\chpgn--}"
				 * + "{\\headerr\\f14\\fs20\\chbrdr\\red255\\green0\\blue0  " +
				 * Jheader + "}"
				 */
				+ "\\widoctrl\\ftnbj \\sectd\\linex0\\endnhere"
				+ "\\pard\\plain ";
	}

	// rtf�ļ�β
	public String ReportEnd() {
		return " \\par }";
	}

	public class RrfDocument {
		long[] chapter_num = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // ����1������2����

		public RrfDocument() {

			// DefaultCategoryDataset piedata = new DefaultCategoryDataset();
			// piedata.setValue(3, 34, 34);

			// drawBar("c:\\c.jpg",piedata,"��Σ�յ�IP","IP��ַ","©����",692,220,6);
		}

		public String set_chapter(String content, int plies)
				throws DocumentException, IOException {
			String chapter_id = "";
			int i = 0;
			chapter_num[plies - 1]++;
			chapter_num[plies] = 0;
			if (plies == 1)// �½ڻ�ҳ
				write_report.write(NewPage().getBytes());
			for (i = 0; i < plies; i++)
				chapter_id += chapter_num[i] + ".";
			chapter_id += content;
			return "\\par \\s"
					+ plies
					+ "\\ql "
					+ PeportChunk(chapter_id, null, font_chapter_size, "B",
							"\\f12") + "\\par \\pard\\plain ";
		}

		// ����1���������ƣ���������������
		public String Chapter(String str) throws IOException {
			chapter_num[0]++;
			chapter_num[1] = 0;
			write_report.write(NewPage().getBytes());
			return "\\par \\s1\\ql "
					+ PeportChunk(chapter_num[0] + ". " + str, null,
							font_chapter_size, "B", "\\f12")
					+ "\\par \\pard\\plain ";
		}

		// ����2
		public String Section(String str) {
			chapter_num[1]++;
			chapter_num[2] = 0;
			return "\\par \\s2\\ql "
					+ PeportChunk(chapter_num[0] + "." + chapter_num[1] + ". "
							+ str, null, font_chapter_size - 1, "B", "\\f12")
					+ "\\par \\pard\\plain ";
		}

		// ����3
		public String Section3(String str) {
			chapter_num[2]++;
			chapter_num[3] = 0;

			return "\\par \\s3\\ql "
					+ PeportChunk(chapter_num[0] + "." + chapter_num[1] + "."
							+ chapter_num[2] + ". " + str, null,
							font_chapter_size - 1, "B", "\\f12")
					+ "\\par \\pard\\plain ";
		}

		// ����4
		public String Section4(String str) {
			chapter_num[3]++;

			return "\\par \\s4\\ql "
					+ PeportChunk(chapter_num[0] + "." + chapter_num[1] + "."
							+ chapter_num[2] + "." + chapter_num[3] + ". "
							+ str, null, font_chapter_size - 1, "B", "\\f12")
					+ "\\par \\pard\\plain ";
			// return
			// "\\par \\s2\\ql "+PeportChunk(chapter_num[0]+"."+chapter_num[1]+". "+Gfun.tounicode(str),null,14,"B")+"\\par \\pard\\plain ";

		}
	}// class

	// ��������
	// rstyle����ʽ��B�����壻C�����У�R���Ҷ���
	String cs1 = Gfun.tounicode("��");
	String cs2 = Gfun.tounicode("��");
	String cs3 = Gfun.tounicode("��");

	public String repstr(String str) {
		if (str == null || str.isEmpty())
			return "";
		String strp = str;

		System.out.println("strp" + strp);
		System.out.println("strp" + strp);
		strp = strp.replaceAll("}", "\\}");
		strp = strp.replaceAll("{", "\\{");
		strp = strp.replaceAll("\\", "\\\\");
		return strp;
	}

	public String PeportChunk(String str, ReportColor rcolor, int rsize,
			String rstyle, String font_type) {
		if (str == null)
			str = "";
		if (font_type == null)
			font_type = "\\f10";
		if (rstyle == null)
			rstyle = "";
		String style = "{" + font_type;
		if (rcolor != null)
			style += rcolor.color;
		if (rsize > 0)
			style += "\\fs" + 2 * rsize;
		else
			style += "\\fs" + 2 * font_size;
		if (rstyle.indexOf("B") >= 0)
			style += "\\b";
		str = Gfun.replace(str, "\\", "\\\\");
		// return style+" "+Gfun.tounicode(str)+"}";
		// str = str.replaceAll( "}", "\\}");//Gfun.replace(str, "{", "\\{");
		// str = Gfun.replace(str, "}", "\\}");
		// str = str.replaceAll( "{", "\\{");
		str = Gfun.replace(str, "\\b", "  ");
		str = Gfun.replace(str, "\b", "  ");
		str = Gfun.replace(str, "\\n", "�ܣ�par ");
		str = Gfun.replace(str, "\n", "�ܣ�par ");
		// str = Gfun.replace(str, "\\", "\\\\");
		// str = str.replaceAll( "\\", "\\\\");

		str = Gfun.replace(str, "�ܣ�par ", "\\par ");
		str = Gfun.replace(str, "}", "\\}");
		str = Gfun.replace(str, "{", "\\{");
		// str = Gfun.replace(str, "\\", "\\\\");
		// str=repstr(str);
		// str = repstr(str);
		// System.out.println("str"+str);
		return style + " " + str + "}";

	}

	public String PeportChunk(String str, ReportColor rcolor, int rsize,
			String rstyle) {

		return PeportChunk(str, rcolor, 0, "", "\\f11");
	}

	public String PeportChunk(String str, ReportColor color) {
		return PeportChunk(str, color, 0, "", "\\f11");
	}

	public String PeportChunk(String str, int size) {
		return PeportChunk(str, null, size, "", "\\f11");
	}

	public String PeportChunk(String str, String style) {
		return PeportChunk(str, null, 0, style, "\\f11");
	}

	public String PeportChunk(String str) {
		return PeportChunk(str, null, 0, "", "\\f11");
	}

	// ���Ӷ���
	public String PeportParagraph(String str, ReportColor color, int size,
			String pstyle) {
		String style = "\\ql";
		if (pstyle == null)
			pstyle = "";
		if (pstyle.indexOf("C") >= 0)
			style = "\\qc";
		else if (pstyle.indexOf("R") >= 0)
			style = "\\qr";
		style += "\\sl330\\slmult0 ";
		// size = font_size;
		// \\sa120\\sl288\\slmult0\\widctlpar\\tx426\\wrapdefault\\faauto\\adjustright\\rin0\\lin0\\itap0
		// \\rtlch\\fcs1 \\af0\\sfs24\\alang1025
		// System.out.print("\\par "+style+PeportChunk(str,color,size,style,"\\f11"));
		return "\\par " + style + PeportChunk(str, color, size, style, "\\f11");
	}

	public String PeportParagraph(String str, int size, String style) {
		return PeportParagraph(str, null, size, style);
	}

	public String PeportParagraph(String str, ReportColor color) {
		return PeportParagraph(str, color, 0, "");
	}

	public String PeportParagraph(String str, int size) {
		return PeportParagraph(str, null, size, "");
	}

	public String PeportParagraph(String str, String style) {
		return PeportParagraph(str, null, 0, style);
	}

	public String PeportParagraph(String str) {
		return PeportParagraph(str, null, 0, "");
	}

	// ��ҳ
	public String NewPage() {
		return "{\\page }";
	}

	public void write_imgbyte(OutputStream out, String imgfile, int scale)
			throws IOException {

		InputStream is = null;

		FileWriter fwriter1;
		File file_img = new File(imgfile);

		String ss = new String();
		ss = "{\\*\\shppict" + "{\\pict" + "{\\*\\picprop\\shplid1025"
				+ "{\\sp{\\sn shapeType}{\\sv 75}}"
				+ "{\\sp{\\sn fFlipH}{\\sv 0}}" + "{\\sp{\\sn fFlipV}{\\sv 0}}"
				+ "{\\sp{\\sn fLine}{\\sv 0}}"
				+ "{\\sp{\\sn borderTopColor}{\\sv -16777216}}"
				+ "{\\sp{\\sn borderLeftColor}{\\sv -16777216}}"
				+ "{\\sp{\\sn borderBottomColor}{\\sv -16777216}}"
				+ "{\\sp{\\sn borderRightColor}{\\sv -16777216}}"
				+ "{\\sp{\\sn fLayoutInCell}{\\sv 1}}"
				+ "{\\sp{\\sn fLayoutInCell}{\\sv 1}}" + "}" + "\\picscalex"
				+ scale + "\\picscaley" + scale
				+ "\\piccropl0\\piccropr0\\piccropt0\\piccropb0" + "\\jpegblip"
				+ "\\bin" + file_img.length();
		out.write(ss.getBytes());
		try {
			is = new FileInputStream(imgfile);
		} catch (FileNotFoundException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		int c;
		try {
			while ((c = is.read()) != -1) {
				try {
					out.write(c);

				} catch (IOException e) {
					// TODO �Զ����� catch ��
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		out.write("}}".getBytes());
	}

	// дͼƬ scale:���ű���
	public void write_img3(FileWriter fwriter, String imgfile, int scale)
			throws FileNotFoundException, IOException {
		File file_img = new File(imgfile);
		if (!file_img.exists())
			return;
		// д�ļ�ͷ

		System.out.print("д�� �ļ� " + imgfile + scale);
		fwriter
				.write("{\\*\\shppict" + "{\\pict"
						+ "{\\*\\picprop\\shplid1025"
						+ "{\\sp{\\sn shapeType}{\\sv 75}}"
						+ "{\\sp{\\sn fFlipH}{\\sv 0}}"
						+ "{\\sp{\\sn fFlipV}{\\sv 0}}"
						+ "{\\sp{\\sn fLine}{\\sv 0}}"
						+ "{\\sp{\\sn borderTopColor}{\\sv -16777216}}"
						+ "{\\sp{\\sn borderLeftColor}{\\sv -16777216}}"
						+ "{\\sp{\\sn borderBottomColor}{\\sv -16777216}}"
						+ "{\\sp{\\sn borderRightColor}{\\sv -16777216}}"
						+ "{\\sp{\\sn fLayoutInCell}{\\sv 1}}"
						+ "{\\sp{\\sn fLayoutInCell}{\\sv 1}}" + "}"
						+ "\\picscalex" + scale + "\\picscaley" + scale
						+ "\\piccropl0\\piccropr0\\piccropt0\\piccropb0"
						+ "\\jpegblip");
		fwriter.write("\\bin" + file_img.length());
		// д�ļ�����
		FileReader freader = new FileReader(imgfile);
		int amount = 0;
		char ch[] = new char[512];
		while ((amount = freader.read(ch)) != -1) {
			fwriter.write(ch, 0, amount);
			System.out.print(ch);
		}
		freader.close();
		fwriter.write("}}");

	}

	// ������ɫ��chmlit
	public class ReportColor {
		String color = "";

		public ReportColor(String fc) {
			if ("c".equals(fc))
				color = "\\cf2";
			else if ("h".equals(fc))
				color = "\\cf3";
			else if ("m".equals(fc))
				color = "\\cf4";
			else if ("l".equals(fc))
				color = "\\cf5";
			else if ("i".equals(fc))
				color = "\\cf6";
			else if ("t".equals(fc))
				color = "\\cf7"; // ������ɫ
			else
				color = "";
		}
	}

	// ���Ԫ��
	public class ReportCell {
		boolean isimg = false; // �Ƿ�ͼƬ Img
		String content = ""; // ���ݣ����type��ͼƬ����ΪͼƬ�ļ���
		String bgcolor = ""; // ����ɫ
		String align = "\\ql"; // ���뷽ʽ C��R��L
		String merged = ""; // �Ƿ����һ�кϲ� M. �ϲ���\clvmrg�����ϲ���\clvmgf
		int scale = 100;

		public ReportCell() {
		}

		public ReportCell(String str, String fstaly, int imgscale) {
			set_cell(str, fstaly, imgscale);
		}

		public ReportCell(String str, String fstaly) {
			set_cell(str, fstaly, 100);
		}

		public ReportCell(String str) {
			set_cell(str, "", 100);
		}

		// ���õ�Ԫ�����ݣ���ʽ����Img:ͼƬ��T:���⣻C�����У�R���Ҷ��룬M���ϲ�
		public void set_cell(String str, String fstaly, int imgscale) {
			if (str == null)
				str = "";
			if (fstaly == null)
				fstaly = "";
			if (fstaly.indexOf("Img") >= 0)
				isimg = true;
			if (!isimg && str.indexOf(chcode) < 0)
				content = PeportChunk(str, 0);
			else
				content = str;
			if (fstaly.indexOf("T") >= 0)
				bgcolor = "\\clcbpat7";
			else
				bgcolor = "";
			if (fstaly.indexOf("M") >= 0)
				merged = "\\clvmrg";
			else
				merged = "\\clvmgf";
			if (fstaly.indexOf("C") >= 0)
				align = "\\qc";
			else if (fstaly.indexOf("R") >= 0)
				align = "\\qr";
			scale = imgscale;
		}

		// ���õ�Ԫ��
		public void set_cell(String str) {
			set_cell(str, "", 100);
		}
	}

	// ���
	public class ReportTable {
		int width = 8500; // ����ܿ��
		int col_num = 1; // �������
		int cell_with[]; // �����п��
		String trkeep = ""; // �Ƿ������ҳ���У�����ͼƬ��Ϊ������\\trkeep������������Ϊ��
		ArrayList<ReportCell> celllist = new ArrayList<ReportCell>(); // Ҫд��ĵ�Ԫ�������б�
		boolean border_flag = true; // �Ƿ���ʾ�߿�

		public ReportTable(int c) {
			col_num = c;
			cell_with = new int[col_num];
			for (int i = 0; i < col_num; i++) {
				cell_with[i] = (i + 1) * width / col_num;
			}
		}

		// ����Ԫ��������ӵ����
		public void add_cell(ReportCell cell) {
			celllist.add(cell);
			if (cell.isimg)
				trkeep = "\\trkeep";
		}

		public void add_cell(String cellstr) {
			ReportCell cell = new ReportCell(cellstr);
			celllist.add(cell);
		}

		// ���ļ��л��Ʊ��fwriter�ļ���celllist��Ԫ��Ԫ���б�
		public void write_cellbyte(OutputStream out) throws IOException {
			int i = 0;
			ReportCell cell;
			while (celllist.size() > 0) {

				// ��������������
				if (celllist.size() < col_num) {
					for (i = celllist.size(); i < col_num; i++)
						celllist.add(new ReportCell());
				}
				// д�����
				// fwriter.write(RowHead());
				out.write(RowHead().getBytes());
				for (i = 0; i < col_num; i++) {
					cell = (ReportCell) celllist.get(i);
					// fwriter.write(CellHead(cell_with[i],cell.bgcolor+cell.merged));
					out
							.write(CellHead(cell_with[i],
									cell.bgcolor + cell.merged).getBytes());
				}
				// fwriter.write(CellEnd());
				out.write(CellEnd().getBytes());
				// ���Ԫ������
				for (i = 0; i < col_num; i++) {
					cell = (ReportCell) celllist.get(i);
					// fwriter.write(cell.align);
					out.write(cell.align.getBytes());
					if (cell.isimg)
						write_imgbyte(out, cell.content, cell.scale);// ͼƬ
					else
						// fwriter.write(cell.content); //�ı�
						out.write(cell.content.getBytes());
					// fwriter.write("\\cell ");
					out.write("\\cell ".getBytes());
				}
				// fwriter.write(RowEnd());
				out.write(RowEnd().getBytes());
				for (i = 0; i < col_num; i++)
					celllist.remove(0);
			}
			trkeep = "";
		}

		// ���ñ��Ԫ���ȣ����ٷֱȡ���"20,20,60"
		public void set_width(String w) {
			border_flag = true;
			if (w == null || "".equals(w))
				return;
			String tw[] = Gfun.split(w, ",");
			if (tw.length != col_num) {
				col_num = tw.length;
				cell_with = new int[col_num];
			}
			for (int i = 0; i < col_num; i++) {
				cell_with[i] = width * Integer.parseInt(tw[i]) / 100;
				if (i > 0)
					cell_with[i] += cell_with[i - 1];
			}
		}

		// ���ñ��Ԫ���ȣ����ٷֱȡ���"20,20,60"
		public void set_noborder() {
			border_flag = false;
		}

		// ���Ԫ��ͷ��������Ԫ������д������style��ʽ
		public String CellHead(int cellx, String style) {
			String bdcorder = "10";
			if (!border_flag)
				bdcorder = "9";
			// bdcorder = "10";
			return "\\clbrdrt\\brdrs\\brdrw10\\brdrcf" + bdcorder
					+ "\\clcfpat4 " + "\\clbrdrl\\brdrs\\brdrw10\\brdrcf"
					+ bdcorder + " \\clcfpat4 "
					+ "\\clbrdrb\\brdrs\\brdrw10\\brdrcf" + bdcorder
					+ " \\clcfpat4 " + "\\clbrdrr\\brdrs\\brdrw10\\brdrcf"
					+ bdcorder + style + "\\cltxlrtb" + "\\cellx" + cellx + " ";
		}

		// ���Ԫ��β�����е�λ��ͷ������д
		public String CellEnd() {
			return "\\pard \\nowidctlpar\\intbl\\faauto ";
		}

		// �����ͷ
		public String RowHead() {
			return "\\trowd "
					+ "\\trqc\\trgaph10\\trleft-20\\trbrdrt\\brdrs\\brdrw20\\brdrcf1"
					+ trkeep
					+ " "
					+ "\\trbrdrl\\brdrs\\brdrw20\\brdrcf1 \\trbrdrb\\brdrs\\brdrw20\\brdrcf1 "
					+ "\\trbrdrr\\brdrs\\brdrw20\\brdrcf1 \\trbrdrh\\brdrs\\brdrw20\\brdrcf1 "
					+ "\\trbrdrv\\brdrs\\brdrw20\\brdrcf1 "
					+ "\\trpaddl20\\trpaddr20\\trpaddfl3\\trpaddfr3 ";
		}

		// �����β
		public String RowEnd() {
			return "\\pard \\nowidctlpar\\intbl\\aspalpha\\aspnum\\faauto\\adjustright \\row \\pard\\plain ";
		}
		/*
		 * //���ļ��л��Ʊ��fwriter�ļ���celllist��Ԫ��Ԫ���б� public void
		 * write_cell(FileWriter fwriter) throws IOException{ int i=0;
		 * ReportCell cell; while(celllist.size()>0){ //��������������
		 * if(celllist.size()<col_num){ for(i=celllist.size();i<col_num;i++)
		 * celllist.add(new ReportCell()); } //д����� fwriter.write(RowHead());
		 * for(i=0;i<col_num;i++){ cell=(ReportCell)celllist.get(i);
		 * fwriter.write(CellHead(cell_with[i],cell.bgcolor+cell.merged)); }
		 * fwriter.write(CellEnd()); //���Ԫ������ for(i=0;i<col_num;i++){
		 * cell=(ReportCell)celllist.get(i); fwriter.write(cell.align);
		 * if(cell.isimg);// write_img(fwriter,cell.content,cell.scale);//ͼƬ
		 * else fwriter.write(cell.content); //�ı� fwriter.write("\\cell "); }
		 * fwriter.write(RowEnd()); for(i=0;i<col_num;i++) celllist.remove(0); }
		 * trkeep=""; }
		 */

	}
	// д©������ͳ�Ʊ�-----------------------

}
