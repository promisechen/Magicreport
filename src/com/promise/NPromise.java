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
