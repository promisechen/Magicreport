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

		String msg = "    �����߿���Զ�̴������޸ġ�ɾ���ļ���\n���������ȡ�ļ�Ŀ¼�����Ի���û����������������Ϣ��Ǳ�ڿ��ܵ��¸߷��յ�©��";
		// object report;

		// Object o=new Write_pdf("e:\\d2.pdf");
		// o=(Write_pdf)o;

		// report = new Write_pdf("e:\\d2.pdf");

		// ww(filename);
		// report = new Write_rtf(filename);

		System.out.println(PdfPCell.ALIGN_LEFT);
		System.out.println(PdfPCell.ALIGN_CENTER);
		System.out.println(PdfPCell.ALIGN_RIGHT);
		report.set_chapter("�л�", 1);// д�½�
		report.set_chapter("�л�", 2);
		report.set_chapter("�л�", 1);
		report.set_chapter("�л�", 2);
		report.set_chapter("�л�", 3);
		// report.write_av("�л�");//д��������
		// report.write_av("");//д��������

		PromiseData data = new PromiseData();

		String tempStr[] = new String[] { "����", "©������", "��", "��", "��Ϣ ", "�ͷ��� " };
		String colorStr[] = new String[] { "true", "true", "true", "true",
				"true", "true" };
		Integer[] Align = new Integer[] { 0, 0, 0, 0, 0, 0 };
		Integer[] Colspan = new Integer[] { 1, 1, 0, 0, 0, 1 };

		data.put(tempStr, colorStr, Align, Colspan);
		String tempStr1[] = new String[] { "ftp����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1, null, null, null);
		tempStr1 = new String[] { "snmp����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "stmp����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "dns����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "pop3����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "qq����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "msn����", "1", "2", "3", "4 ", "5  " };
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
			String msg = "    ������\n����Զ�̴������޸ġ�ɾ���ļ������������ȡ�ļ�Ŀ¼�����Ի���û����������������Ϣ��Ǳ�ڿ��ܵ��¸߷��յ�©��";
			report.set_chapter("�л�", 1);// д�½�
			report.set_chapter("�л�", 2);
			report.set_chapter("�л�", 3);
			report.set_chapter("�л�", 4);
			report.set_chapter("�л�", 5);
			report.write_av("�л�");// д��������
			report.write_av("");// д��������
			PromiseData data = new PromiseData();

			String tempStr[] = new String[] { "����", "©������", "��", "��", "��Ϣ ",
					"�ͷ��� " };
			String colorStr[] = new String[] { "true", "true", "true", "true",
					"true", "true" };
			Integer[] Align = new Integer[] { 1, 1, 2, 0, 0, 0 };
			Integer[] Colspan = new Integer[] { 1, 1, 0, 0, 0, 1 };

			data.put(tempStr, colorStr, Align, Colspan);
			String tempStr1[] = new String[] { "ftp����", "1", "2", "3", "4 ",
					"5  " };
			data.put(tempStr1, null, null, null);
			tempStr1 = new String[] { "snmp����", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "stmp����", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "dns����", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "pop3����", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "qq����", "1", "2", "3", "4 ", "5  " };
			data.put(tempStr1);
			tempStr1 = new String[] { "msn����", "1", "2", "3", "4 ", "5  " };
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
		String msg = "    ������</p>����Զ�̴������޸ġ�ɾ���ļ������������ȡ�ļ�Ŀ¼�����Ի���û����������������Ϣ��Ǳ�ڿ��ܵ��¸߷��յ�©��";
		Write_html report = new Write_html(filename);
		report.set_chapter("�л�", 1);// д�½�
		report.set_chapter("�л�", 2);
		report.set_chapter("�л�", 3);
		report.set_chapter("�л�", 3);
		report.set_chapter("�л�", 4);
		report.set_chapter("�л�", 5);

		report.set_chapter("�л�1", 1);// д�½�
		report.set_chapter("�л�1", 2);
		report.set_chapter("�л�1", 3);
		report.set_chapter("�л�1", 3);
		report.set_chapter("�л�1", 4);

		report.write_av("�л�");// д��������
		report.write_av("");// д��������
		PromiseData data = new PromiseData();

		String tempStr[] = new String[] { "����", "©������", "��", "��", "��Ϣ ", "�ͷ��� " };
		String colorStr[] = new String[] { "true", "true", "true", "true",
				"true", "true" };
		Integer[] Align = new Integer[] { 1, 1, 2, 0, 0, 0 };
		Integer[] Colspan = new Integer[] { 1, 1, 0, 0, 0, 1 };

		data.put(tempStr, colorStr, Align, Colspan);
		String tempStr1[] = new String[] { "ftp����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1, null, null, null);
		tempStr1 = new String[] { "snmp����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "stmp����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "dns����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "pop3����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "qq����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		tempStr1 = new String[] { "msn����", "1", "2", "3", "4 ", "5  " };
		data.put(tempStr1);
		report.write_av(data, null, true);
		report.write_av("4.jpg", msg, 2, null);
		report.write_av("4.jpg", msg, 0, null);
		report.Set_Html_Foot();
		report.Write_clean();
	}
}// end fun write
