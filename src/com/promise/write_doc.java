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
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import org.jfree.data.general.DefaultPieDataset;



import com.lowagie.text.Anchor;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.rtf.graphic.RtfShape;
import  com.lowagie.text.rtf.style.RtfParagraphStyle;
import  com.lowagie.text.rtf.style.RtfParagraphStyle.*;
import  com.lowagie.text.rtf.style.*;
import com.lowagie.text.rtf.RtfWriter2;

public class write_doc {
    int firstinfo=0,lastinfo=0;
    Chapter chapter;
    Section section2,section3,section4;
    com.lowagie.text.Font bfChinese12,bfChinese14,bfChinese16,bfChinese20,bfChinese32;
    Document document ; //报表文件
    Anchor anchor;
    Paragraph p;
    Table table;
    Cell cell;
    com.lowagie.text.pdf.BaseFont bfChinese ;
    int i=0,j=0,k=0,m=0;
    String filepath = "";
    RtfWriter2 doc ;
    boolean dd;
    public  void write(String filename)
    {  
    	
    	float[] tablewidths={30,70};
    	  
    	document = new Document(PageSize.A4);
    	File file_report = new File(filename);	  

    	try{	
    		 //com.lowagie.text.rtf.style.RtfParagraphStyle.STYLE_HEADING_1;  
    		   bfChinese = com.lowagie.text.pdf.BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); 
    			//  bfChinese = com.lowagie.text.pdf.BaseFont.createFont("c:\\windows\\fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, com.lowagie.text.pdf.BaseFont.NOT_EMBEDDED);	       
    		 	  bfChinese12=new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);
    		      bfChinese14=new com.lowagie.text.Font(bfChinese, 14, com.lowagie.text.Font.NORMAL);
    		      bfChinese16=new com.lowagie.text.Font(bfChinese, 16, com.lowagie.text.Font.NORMAL);
    		      bfChinese20=new com.lowagie.text.Font(bfChinese, 20, com.lowagie.text.Font.NORMAL);
    		      bfChinese32=new com.lowagie.text.Font(bfChinese, 32, com.lowagie.text.Font.NORMAL,new Color(255, 0, 0));
    		      FileOutputStream file_stream = new FileOutputStream(file_report);
    		     // PdfWriter writer = PdfWriter.getInstance(document, file_stream );
    		     // writer.setHeader(new HeaderFooter ("dasd"));
    		  doc = RtfWriter2.getInstance(document,  file_stream);//生成doc
    		 //    HtmlWriter w =  HtmlWriter.getInstance(document, new FileOutputStream("c:\\22.html") );
    		      document.addTitle("Hello World example");
    		      document.addSubject("This example shows how to add metadata");
    		      document.addKeywords("Metadata, iText, step 3, tutorial");
    		      document.addCreator("My program using iText");
    		      document.addAuthor("Bruno Lowagie");
    		      document.addHeader("Expires", "0");

    		      document.open();	   
    		      RtfParagraphStyle(doc, RtfParagraphStyle.STYLE_HEADING_3);    		          		        		      
    		      RtfParagraphStyle fd ;
    		      Phrase pp = new Phrase("捷普网安远程安全评估系统评估报告",bfChinese16);
    		      //RtfParagraphStyle.STYLE_HEADING_1;
    		      HeaderFooter header = new HeaderFooter(pp, false);
    		      header.setBorder(2);
    		      header.setBorderColor(new Color (50,255,255));
    		      header.setAlignment(1);
    		      document.setHeader(header);
    		      
    		       
    	            //title.setAlignment(com.lowagie.text.rtf.style.RtfParagraphStyle.STYLE_HEADING_1); 
    	         
    		    //  document.add(new Phrase("\\par \\s1\\ql "+"safsd"+"\\par \\pard\\plain "));
    		    //  header = new HeaderFooter(new Phrase("捷普网安远程安全评估系统评估报告",bfChinese16), true);
    		     // RtfWriter2.this.   
    		      //document.setFooter(header);
    		      //document.Header = header;

    		    //  document.setHeader("asdfds");
    		      Paragraph title2 = new Paragraph("This is Chapter 2", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(0, 0, 255)));
    		     
    		      Chapter chapter2 = new Chapter(title2, 1);
    		      chapter2.setNumberDepth(0);
    		      Paragraph someText = new Paragraph("This is some text");
    		      chapter2.add(someText);
    		      Paragraph title21 = new Paragraph("This is Section 1 in Chapter 2", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(255, 0, 0)));
    		      Section section1 = chapter2.addSection(title21);
    		      Paragraph someSectionText = new Paragraph("This is some silly paragraph in a chapter and/or section. It contains some text to test the functionality of Chapters and Section.");
    		      section1.add(someSectionText);
    		      document.add(chapter2);
    		      
    		      RtfShape ii = new RtfShape(1, null);
    		      
    		      
/*  
    		      
    		      
    		      
    		     set_chapter1("扫描概要信息");    		        		       	   		     		     
    		     set_chapter1("网络安全概要信息");
    		      
    		      set_chapter1("漏洞主机");
    		      set_chapter2("10.0.7.66");	         
    		      set_chapter3("主机概要");	
    		      set_chapter3("漏洞信息");
    		      set_chapter4("主要漏洞");
    		      set_chapter4("次要漏洞");
    		      set_chapter2("10.0.7.67");
    		      set_chapter3("主机概要");
    		      set_chapter3("漏洞信息");
    		      //set_chapter("");
    		      
    	*/	
    		         
    		  document.close();
    		    
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();  
		  
	  }
    }
    
    
    private void RtfParagraphStyle(RtfWriter2 doc2,
			RtfParagraphStyle style_heading_1) {
		// TODO Auto-generated method stub
		
	}


	private String PeportChunk(String string, Object object, int l,
			String string2) {
		// TODO Auto-generated method stub
		return null;
	}


	//写标题
    public void set_chapter1(String content) throws DocumentException{ 
  	  firstinfo++;
  	    lastinfo=1; 
      chapter = new Chapter(new Paragraph(content,bfChinese16),firstinfo); 
      
     // chapter.setBookmarkOpen(true);      // 已经设置了在大纲视图中显示，可是还是显示不出来(问题1) 
      //chapter.setComplete(true);
      document.add(chapter);
    }
    //写标题
    public void set_chapter2(String content) throws DocumentException{
  	  section2 = chapter.addSection(new Paragraph(content,bfChinese16),2);	
  	  document.add(section2);
    }
    public void set_chapter3(String content) throws DocumentException{
  	  section3 = section2.addSection(new Paragraph(content,bfChinese16)); 
  	  document.add(section3);
    }
    public void set_chapter4(String content) throws DocumentException{
  	  section4 = section3.addSection(new Paragraph(content,bfChinese16)); 
  	  document.add(section4);
    }
    //写标题
    public void set_chapter(String content) throws DocumentException{

    }
}
