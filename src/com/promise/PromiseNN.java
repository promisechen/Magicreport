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
import java.io.IOException;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPCell;

public class PromiseNN {
	static int ALIGN_LEFT = 0, ALIGN_CENTER = 1, ALIGN_RIGHT = 2;
	NPromise report = null;

	public static NPromise set_report(String resource, String goal_path,
			String filename, boolean isunix) throws IOException {
		NPromise report = null;
		filename = goal_path + filename;
		String cmd;
		if (filename.indexOf(".doc") > -1) {
			report = new Write_rtf(filename);
		} else if (filename.indexOf(".pdf") > -1) {
			try {
				report = new Write_pdf(filename);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (filename.indexOf(".html") > -1) {
			if (isunix) {
				cmd = "cp -rf " + resource + "html_model/images " + goal_path;
			} else {

				File dirFile = new File(goal_path + "images");
				dirFile.mkdirs();
				cmd = "copy " + resource + "html_model\\images " + goal_path
						+ "images";
			}

			// Runtime.getRuntime().exec(cmd);
			report = new Write_html(filename);

		} else {
			report = new Write_rtf(filename + ".doc");
		}
		return report;

	}

	public PromiseNN(String filename) throws DocumentException, IOException {
		if (filename.indexOf(".doc") > -1) {
			report = new Write_rtf(filename);
		} else if (filename.indexOf(".pdf") > -1) {
			report = new Write_pdf(filename);
		} else {
			report = new Write_rtf(filename + ".doc");
		}
	}

	public void write_rtf(String filename) throws DocumentException,
			IOException {
		filename = "e:\\d1.rtf";

		String msg = "    攻击者可以远程创建、修改、删除文件；\n可以任意读取文件目录；可以获得用户名、口令等敏感信息，潜在可能导致高风险的漏洞";
		// object report;

		// Object o=new Write_pdf("e:\\d2.pdf");
		// o=(Write_pdf)o;

		// report = new Write_pdf("e:\\d2.pdf");

		// ww(filename);
		// report = new Write_rtf(filename);

		System.out.println(PdfPCell.ALIGN_LEFT);
		System.out.println(PdfPCell.ALIGN_CENTER);
		System.out.println(PdfPCell.ALIGN_RIGHT);
		report.set_chapter("中华", 1);// 写章节
		report.set_chapter("中华", 2);
		report.set_chapter("中华", 1);
		report.set_chapter("中华", 2);
		report.set_chapter("中华", 3);
		// report.write_av("中华");//写段落内容
		// report.write_av("");//写段落内容

		PromiseData data = new PromiseData();

		String tempStr[] = new String[] { "类型", "漏洞总数", "高", "中", "信息 ", "低风险 " };
		String colorStr[] = new String[] { "true", "true", "true", "true",
				"true", "true" };
		Integer[] Align = new Integer[] { 0, 0, 0, 0, 0, 0 };
		Integer[] Colspan = new Integer[] { 1, 1, 0, 0, 0, 1 };

		data.put(tempStr, colorStr, Align, Colspan);
		String tempStr1[] = new String[] { "ftp测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1, null, null, null);
		tempStr1 = new String[] { "snmp测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "stmp测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "dns测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "pop3测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "qq测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "msn测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		report.write_av(data, null, true);
		report.write_av("");
		report.write_av("e:\\tmp.jpg", msg, 2, null);
		report.Write_clean();
		System.out.println("write_rtf is ok");
		// report.write("e:\\", "c.rtf");
	}

	public void write_pdf(String filename, int flag, boolean ise)
			throws DocumentException, IOException {
		filename = "e:\\d1.pdf";
		Write_pdf report = new Write_pdf(filename);
		try {
			String msg = "    攻击者\n可以远程创建、修改、删除文件；可以任意读取文件目录；可以获得用户名、口令等敏感信息，潜在可能导致高风险的漏洞";
			report.set_chapter("中华", 1);// 写章节
			report.set_chapter("中华", 2);
			report.set_chapter("中华", 3);
			report.set_chapter("中华", 4);
			report.set_chapter("中华", 5);
			report.write_av("中华");// 写段落内容
			report.write_av("");// 写段落内容
			PromiseData data = new PromiseData();

			String tempStr[] = new String[] { "类型", "漏洞总数", "高", "中", "信息 ",
					"低风险 " };
			String colorStr[] = new String[] { "true", "true", "true", "true",
					"true", "true" };
			Integer[] Align = new Integer[] { 1, 1, 2, 0, 0, 0 };
			Integer[] Colspan = new Integer[] { 1, 1, 0, 0, 0, 1 };

			data.put(tempStr, colorStr, Align, Colspan);
			String tempStr1[] = new String[] { "ftp测试", "1", "2", "3", "4 ",
					"5  " };
			data.put(tempStr1, null, null, null);
			tempStr1 = new String[] { "snmp测试", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "stmp测试", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "dns测试", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "pop3测试", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "qq测试", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "msn测试", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			report.write_av(data, null, true);

			report.write_av("e:\\tmp.jpg", null, PdfPCell.ALIGN_CENTER);
			report.write_av("");
			report.write_av("e:\\tmp.jpg", msg, 0);
			report.write_av("e:\\tmp.jpg", msg, 2);

			report.write_av("asdfasdfdsf");
			report.Write_clean();
			System.out.println("asdfsdaf");
		}// end try
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void write_html(String filename) throws DocumentException,
			IOException {
		filename = "e:\\report\\task_web\\test.html";
		String msg = "    攻击者</p>可以远程创建、修改、删除文件；可以任意读取文件目录；可以获得用户名、口令等敏感信息，潜在可能导致高风险的漏洞";
		Write_html report = new Write_html(filename);
		report.set_chapter("中华", 1);// 写章节
		report.set_chapter("中华", 2);
		report.set_chapter("中华", 3);
		report.set_chapter("中华", 3);
		report.set_chapter("中华", 4);
		report.set_chapter("中华", 5);

		report.set_chapter("中华1", 1);// 写章节
		report.set_chapter("中华1", 2);
		report.set_chapter("中华1", 3);
		report.set_chapter("中华1", 3);
		report.set_chapter("中华1", 4);

		report.write_av("中华");// 写段落内容
		report.write_av("");// 写段落内容
		PromiseData data = new PromiseData();

		String tempStr[] = new String[] { "类型", "漏洞总数", "高", "中", "信息 ", "低风险 " };
		String colorStr[] = new String[] { "true", "true", "true", "true",
				"true", "true" };
		Integer[] Align = new Integer[] { 1, 1, 2, 0, 0, 0 };
		Integer[] Colspan = new Integer[] { 1, 1, 0, 0, 0, 1 };

		data.put(tempStr, colorStr, Align, Colspan);
		String tempStr1[] = new String[] { "ftp测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1, null, null, null);
		tempStr1 = new String[] { "snmp测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "stmp测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "dns测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "pop3测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "qq测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "msn测试", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		report.write_av(data, null, true);
		report.write_av("4.jpg", msg, 2, null);
		report.write_av("4.jpg", msg, 0, null);
		report.Set_Html_Foot();
		report.Write_clean();
	}
}// end fun write
