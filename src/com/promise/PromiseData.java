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

import java.util.Hashtable;

public class PromiseData {
	private int key = 0;
	public Hashtable<Integer, String[]> Hashdata = new Hashtable<Integer, String[]>();
	public Hashtable<Integer, String[]> Colordata = new Hashtable<Integer, String[]>();
	public Hashtable<Integer, Integer[]> Align = new Hashtable<Integer, Integer[]>();
	public Hashtable<Integer, Integer[]> Colspan = new Hashtable<Integer, Integer[]>();
	String colorStr[] = new String[] {"true","true","true","true","true","true","true","true","true"};
    public PromiseData()
    {
    	int i = 0;       	
    }
	public boolean put(String data[],String colordata[],Integer[] align,Integer[] colspan)
	{
		int i = 0;
		if(data==null || data.length > 20)
		    return false;
		if(colordata !=null)
		    Colordata.put(key, colordata);
	 
		if(align !=null)		
			Align.put(key, align);
		if(colspan !=null)
			Colspan.put(key, colspan);
		Hashdata.put(key++, data);	 
		return true;
	}
	public void put(String data[])
	{	
		put(data,null,null,null);
	}
	public void set_color(int skey)
	{
		 	
	}
	public void set_color()
	{
		
		
	}

	public String[] get(int gkey)
	{			
	    return Hashdata.get(gkey);
	}
	
}
