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

import java.io.IOException;
import java.util.Date;

import com.lowagie.text.DocumentException;
import com.lowagie.text.rtf.graphic.*;
public class report_test {
	
	public static void main(String[] args)
	{
		String msg = "    ������\n����Զ�̴������޸ġ�ɾ���ļ������������ȡ�ļ�Ŀ¼�����Ի���û����������������Ϣ��Ǳ�ڿ��ܵ��¸߷��յ�©��";
		write_doc ss = new write_doc()
		;
		ss.write("e:\\cc.doc");
		//if(true)
		//return ;
		try {
		//	PromiseNN promise = new PromiseNN("e:\\d4.pdf");
			//promise.write_html("e:\\report\\task_web\\test.html");
		//	PromiseNN promise = new PromiseNN("e:\\d4.pdf");
		//	if(true)
			//   return ;
			Date date1 = new Date();
			String file_name ;
			//file_name= "d4"+date1.getTime()+".html";
			file_name= "d4"+date1.getTime()+".pdf";
			//file_name= "d4"+date1.getTime()+".doc";
			NPromise report = PromiseNN.set_report( "e:\\report\\","e:\\test\\",file_name,false);
			
		//	NPromise report = PromiseNN.set_report( "e:\\d4.doc");
		//	NPromise report = PromiseNN.set_report( "e:\\report\\task_web\\test1.html");
			report.set_chapter("�л�", 1);//д�½� 
			report.set_chapter("�л�", 2);//д�½�  
			report.set_chapter("�л�", 3);         
			report.set_chapter("�л�", 3);  
			report.set_chapter("�л�1", 3); 
		 	report.set_chapter("�л�", 4);
			report.set_chapter("�л�", 5);
		 	report.set_chapter("�л�", 6);
		 	report.write_av("�л�");//д��������
		 	report.write_av("");//д��������
		 	
			PromiseData data = new PromiseData();
			 
			String tempStr[] = new String[] { "����", "©������", "��", "��", "��Ϣ ",
					"�ͷ��� " };
			String colorStr[] = new String[] {"true","true","true","true","true","true"};
			Integer[] Align = new Integer[] {0,0,0,0,0,0};
			Integer[] Colspan = new Integer[] {1,1,0,0,0,1};
			
			data.put(tempStr,colorStr,Align,Colspan);	
			String tempStr1[] = new String[] { "ftp����", "1", "2", "3", "4 ",
					"5  "};	 
			data.put(tempStr1,null,null,null);
			 tempStr1 = new String[] { "snmp����", "1", "2", "3", "4 ",
					"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "stmp����", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "dns����", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "pop3����", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "qq����", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "msn����", "1", "2", "3", "4 ",
				"5  " }; 
			 data.put(tempStr1);	
		 	report.write_av(data,null,true);
		 	report.write_av("");
		 	report.write_av("e:\\tmp.jpg",msg,2 ,null);
		 	report.Write_clean();
		     System.out.println("write_rtf is ok");
			//promise.report.set_chapter(content, plies)
		//	promise.write_pdf("ss",1,true);
		//	promise.write_rtf("e:\\d1.rtf" );
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
