
```   
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

import java.io.IOException;
import java.util.Date;

import com.lowagie.text.DocumentException;
import com.lowagie.text.rtf.graphic.*;
public class report_test {
	
	public static void main(String[] args)
	{
		String msg = "    攻击者\n可以远程创建、修改、删除文件；可以任意读取文件目录；可以获得用户名、口令等敏感信息，潜在可能导致高风险的漏洞";
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
			report.set_chapter("中华", 1);//写章节 
			report.set_chapter("中华", 2);//写章节  
			report.set_chapter("中华", 3);         
			report.set_chapter("中华", 3);  
			report.set_chapter("中华1", 3); 
		 	report.set_chapter("中华", 4);
			report.set_chapter("中华", 5);
		 	report.set_chapter("中华", 6);
		 	report.write_av("中华");//写段落内容
		 	report.write_av("");//写段落内容
		 	
			PromiseData data = new PromiseData();
			 
			String tempStr[] = new String[] { "类型", "漏洞总数", "高", "中", "信息 ",
					"低风险 " };
			String colorStr[] = new String[] {"true","true","true","true","true","true"};
			Integer[] Align = new Integer[] {0,0,0,0,0,0};
			Integer[] Colspan = new Integer[] {1,1,0,0,0,1};
			
			data.put(tempStr,colorStr,Align,Colspan);	
			String tempStr1[] = new String[] { "ftp测试", "1", "2", "3", "4 ",
					"5  "};	 
			data.put(tempStr1,null,null,null);
			 tempStr1 = new String[] { "snmp测试", "1", "2", "3", "4 ",
					"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "stmp测试", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "dns测试", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "pop3测试", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "qq测试", "1", "2", "3", "4 ",
				"5  " }; 
			data.put(tempStr1);
			 tempStr1 = new String[] { "msn测试", "1", "2", "3", "4 ",
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
```   
