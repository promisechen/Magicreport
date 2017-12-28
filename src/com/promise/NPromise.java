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
import java.io.IOException;
import java.net.MalformedURLException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;

public interface NPromise {
	  static int ALIGN_LEFT = 0,ALIGN_CENTER = 1,ALIGN_RIGHT =2;
	boolean set_chapter(String content,int plies)throws DocumentException, IOException ;
    public void Write_clean();
	public void write_av(String image,String msg,int Align,Color BorderColor) throws BadElementException, MalformedURLException, IOException;
    public void write_av(String data);
    public boolean write_av(PromiseData Pdata,float tablewidth[],boolean image) throws DocumentException, MalformedURLException, IOException;
	
    
}
