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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.UUID;
import org.jfree.data.category.DefaultCategoryDataset;
 
public class Write_html implements NPromise {
	private FileWriter write_report;
	private int mark = 0;
	private String list = "",Cover_title;	 
	private long[] chapter_num = { 0, 0, 0, 0 ,0,0,0,0,0,0,0,0,0,0}; // ����1������2����
 
	private String filepath = "e:\\report\\";// �ļ�Ŀ¼
	private String reportpath = "e:\\report\\";// �����Ŀ¼
	private String imgpath = "e:\\report\\task_web\\images\\";
	private String fontpath = "e:\\report\\font\\";
	private String tmppath = "e:\\report\\tmp\\";
 
	private	Color base_Color = new Color(214, 233, 242);// ��̬��ɫ
	private	Color streak_Color = new Color(154, 202, 225);// ��̬��ɫ
 
 
 
	private boolean su = true;
 
    public Write_html(String file_name)
    {
    	File file_report = new File(file_name);
		if (!file_report.exists())
			try {
				file_report.createNewFile();
				write_report = new FileWriter(file_report);
				write_report.write(Head());
	 
				write_report.write(test());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
    }
    
    public void Write_clean()
    {
    	try {
		//	write_report.write(List_head() + list + List_foot());
			write_report.write(End());
			write_report.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
	public void write_av(String data)
	{
		try {
			write_report.write(PeportParagraph(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean write_av(PromiseData Pdata,float tablewidth[],boolean image) throws  MalformedURLException, IOException
	{
		boolean isH = true;
		String qq = "";
 
		String tempStr[] = null;// ������ʱ�����ű�����ַ�����ѭ�����ɱ��
		int i =0 ,j = 0,len = 0;
		 Hashtable<Integer, String[]> data = Pdata.Hashdata;
		 Hashtable<Integer, String[]> colordata = Pdata.Colordata;
		 Hashtable<Integer, Integer[]> Align = Pdata.Align;
		 Hashtable<Integer, Integer[]> Colspan =Pdata.Colspan;
			len = data.get(0).length;
        qq = "<table id=\"threatTable\" class=\"cmn_table\" isSortAble=\"true\">\n";
		if (isH) {
			qq += "<thead>\n"
					+ "	<tr class=\"second_title\" style=\"cursor:pointer\">\n";

			for (i = 0; i < len; i++)
				qq += "	<th >" + data.get(0)[i] + "</th>\n"; // width=\"16%\"

			qq += "         </tr>\n</thead>\n";

			qq = qq + "  <tbody>\n";

		}
	
		if (data == null || data.size() <= 0) {
			qq += "		    	<tr class=\"odd\">\n";
			qq += "		<td colspan=\"" + len + "\" >������</td>";
			qq = qq + "	</tr>\n";
		} else {

			tempStr = new String[len];
			for (i = 1; i < data.size(); i++) {
				qq += "		    	<tr class=\"odd\">\n";
				tempStr = (String[]) data.get(i);
				for (j = 0; j < len; j++) {
					if (tempStr[j] == null)
						tempStr[j] = "---";
					qq += "		<td>" + tempStr[j] + "</td>\n";
				}
				qq = qq + "	</tr>\n";
			}
		}
		qq = qq + "		    </tbody>\n" + " </table> \n";
		write_report.write(qq);
		int Vlen = 0;
		 if(image)
			{
				DefaultCategoryDataset ipdata = new DefaultCategoryDataset();
				jpie p = new jpie();
				for(i = 1 ;i < data.size();i++)
				{  
					Vlen = data.get(i).length;
					for (j = 1; j < Vlen; j++)
				        ipdata.setValue(Integer.parseInt(data.get(i)[j].trim()), data.get(0)[j], data.get(i)[0]);//��Ҫ�Ľ�
					if(i%5 == 0 || data.size()==i+1 )
					{
						p.drawBar(imgpath+i+".jpg", ipdata, " ", " ", " ", 692, 220, 0);
						ipdata.clear();
						write_report.write(Body_img(i+".jpg", "����ͼ"));						
					}
				}	
				 
			}
	return true;
	}
	public void init(String id) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			 IOException {
		String font_type = null;
	
		if (su) {
			reportpath = "/web/ui/report/";
			filepath = reportpath + id + "/";
			imgpath = reportpath + id + "/images/";
			fontpath = "/web/ui/report/fonts/";
			tmppath = "/web/ui/report/tmp/";
		} else {

			reportpath = "e:\\report\\task_web\\";
			filepath = reportpath;
			imgpath = "e:\\report\\task_web\\images\\";
			fontpath = "e:\\report\\fonts\\";
			tmppath = "e:\\report\\tmp\\";
		}
		System.out.println("���������" + reportpath);
	 
		String sql = "select operater,Model_id,Task_all,Ip_all,Task_count,Report_time,Addressee,Send_mode,Title,Title_size,Text,Text_size,Pdf_pwd,Time_start from reporter where id = '"
				+ id + "'";
	
	 
		// ��ȡģ������
	 
		// conn.close();
	}

	private static String getCode() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public void write_av(String image,String msg,int Align,Color BorderColor) throws  MalformedURLException, IOException
	{	
	 
		String img;
		String qq;
	 
		img= chapter_img(image, "����");
		
		qq = "<table id=\"threatTable\" class=\"cmn_table\" isSortAble=\"true\">\n";
		qq += "		    	<tr class=\"odd\">\n";
	//	<br></br>
		if(Align == NPromise.ALIGN_RIGHT)
		{		
		qq += "		<td   >"+img+"  </td>";
		qq += "		<td   >"+msg+"</td>";
		}
		else
		{
			qq += "		<td   >"+msg+"</td>";
			qq += "		<td   >"+img+"  </td>";
		}
		qq = qq + "	</tr>\n";
		qq = qq + "		    </tbody>\n" + " </table> \n";
		write_report.write(qq);
		
		
		
		
		
	}
	public boolean mkdir(String id) throws IOException {
		// cp -r /web/ui/report/html_model/* /web/ui/report/123/
		String cmd = null;
		Process proc;
		BufferedReader procin;
		filepath = reportpath + id + "/";
		imgpath = reportpath + id + "/images/";

		System.out.println("����Ŀ¼�С�����������");
		cmd = "mkdir " + reportpath + id;// ����Ŀ¼

		System.out.println(cmd);
		proc = Runtime.getRuntime().exec(cmd);
		procin = new BufferedReader(
				new InputStreamReader(proc.getInputStream()));
		while ((procin.readLine()) != null) {
		}
		procin.close();
		// �����ļ�
		cmd = "cp -rf " + reportpath + "html_model/images " + reportpath + id;
		Runtime.getRuntime().exec(cmd);
		System.out.println(cmd);
		cmd = "cp -rf " + reportpath + "html_model/hosts " + reportpath + id;
		Runtime.getRuntime().exec(cmd);
		System.out.println(cmd);
		return true;
	}

	public boolean zipfile(String id) throws IOException {
		String cmd = null;
		// ѹ���ļ�
		// tar -zcvf 123.tar.gz 123
		Process proc;
		BufferedReader procin;
		cmd = "tar -zcvf " + reportpath + id + ".tar.gz " + reportpath + id
				+ "/";
		System.out.println(cmd);
		proc = Runtime.getRuntime().exec(cmd);
		procin = new BufferedReader(
				new InputStreamReader(proc.getInputStream()));
		while ((procin.readLine()) != null) {
		}
		procin.close();
		cmd = "rm -r " + reportpath + id;
		proc = Runtime.getRuntime().exec(cmd);
		procin = new BufferedReader(
				new InputStreamReader(proc.getInputStream()));
		while ((procin.readLine()) != null) {
		}
		procin.close();
		return true;
	}

	private String Head() {
		String qq;
		qq = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"
				+ "<!-- saved from url=(0023)http://www.nsfocus.com/ -->\n"
				+ "<html>\n"
				+ " <head>\n"
				+ "   <meta http-equiv=\"Content-Type\" content=\"text/html;charset=gb2312\" />	\n"
				+ "<script src=\"images/prototype.js\" type=\"text/javascript\"></script>\n"
				+ "<script src=\"images/cavy.js\" type=\"text/javascript\"></script>\n"
				+ "<script src=\"images/aurora.js\" type=\"text/javascript\"></script>\n"
				+ "<style type=\"text/css\" media=\"all\">\n"
				+ "@import \"images/link.css\";\n"
				+ "@import \"images/aurora.css\";\n"
				+ "@import \"images/comm_table.css\";\n"
				+ "</style>\n"
				+ "<style type='text/css'>\n"
				+ "html,body {overflow:visible;+overflow:auto} /* For print page in firefox */\n"
				+ "h1{padding:3px 50px;font-size:15px;}\n"
				+ "#reportTitle img{float:left}\n"
				+ ".bline { padding-top:5px;border-top-width:3px;border-top-style: solid;border-top-color: #bababa; width:645px }\n"

				+ "#summaryWithIndex,#vulnView,#osDistribution,#ipList,#vulnDistribution,#accounts,#standard,#ipSummaryWithIndex,#portwithvulnlist,#info,#advance { width:645px;clear:both; text-align:left }\n"

				+ "#summary h2,#summary1 h2, #vulnView h2,#osDistribution h2,#ipList h2,#vulnDistribution h2,#accounts h2,#standard h2,#portwithvulnlist h2,#info h2,#advance h2 { cursor:pointer;background: #bababa;font-weight:bold;line-height:25px;font-size:14px;padding:1px 0px 1px 1px;background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;margin:1px 0 0;}\n"
				+ "#summary { float:left;width:645px; }\n"
				+ "#summary table { width:100%;vertical-align:text-top;border-collapse:collapse;border-padding:0px; }\n"
				+ "#summary table tr th { background:#d9d9d9;text-align:left;height:20px; border-bottom: 1px #bababa solid;padding-left:15px;white-space:normal; word-break:break-all; }\n"
				+ "#summary table tr td { text-align:left;border-bottom: 1px #bababa solid;padding-left:15px;white-space:normal; word-break:break-all;  }\n"
				// width:175px;
				+ "#reportIndex { border:1px solid #bababa; text-align:left; float:right; padding-bottom:10px;}\n"
				+ "#reportIndex h2 { line-height:25px;font-size:14px;padding-left:5px; }\n"
				+ "#reportIndex ul { list-style-type:none;margin:0px;list-style-position:outside;padding-left:5px;position:relative;}\n"
				+ "#reportIndex ul ol { list-style-type:none;margin:0px;list-style-position:inside;padding-left:5px }\n"

				+ "#vulnView h3,#accounts h3,#standard h3,#portwithvulnlist h3,#info h3,#summary h3,#osDistribution h3 { cursor:pointer;font-size:13px;text-align:left;padding-left:15px;border-bottom:2px #bababa solid; background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;}\n"
				+ "#vulnView h4,#accounts h4,#standard h4,#portwithvulnlist h4,#info h4,#summary h4,#osDistribution h4 { cursor:pointer;font-size:13px;text-align:left;padding-left:30px;border-bottom:2px #bababa solid; background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;}\n"
				+ "#vulnView h5,#accounts h5,#standard h5,#portwithvulnlist h5,#info h5,#summary h5,#osDistribution h5 { cursor:pointer;font-size:13px;text-align:left;padding-left:40px;border-bottom:2px #bababa solid; background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;}\n"
				+ "#vulnView h6,#accounts h6,#standard h6,#portwithvulnlist h6,#info h6,#summary h6,#osDistribution h6 { cursor:pointer;font-size:13px;text-align:left;padding-left:50px;border-bottom:2px #bababa solid; background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;}\n"
				+ "#vulnView h7,#accounts h7,#standard h7,#portwithvulnlist h7,#info h7,#summary h7,#osDistribution h7 { cursor:pointer;font-size:13px;text-align:left;padding-left:60px;border-bottom:2px #bababa solid; background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;}\n"
				+ "#vulnView h8,#accounts h8,#standard h8,#portwithvulnlist h8,#info h8,#summary h8,#osDistribution h8 { cursor:pointer;font-size:13px;text-align:left;padding-left:70px;border-bottom:2px #bababa solid; background-image:url(images/up.gif);background-repeat: no-repeat; background-position: right;}\n"
				+ "#vulnView div img { clear:both;padding-bottom:5px; }\n"
				+ "#vulnView div table,#osDistribution table,#ipList table,#vulnDistribution table,#accounts table,#standard table,#portwithvulnlist table,#info table { width: 100%;border-collapse:collapse;border-padding:0px; }\n"
				+ "#vulnView div table tr th,#osDistribution table tr th,#ipList table tr th,#vulnDistribution table tr th,#accounts table tr th,#standard table tr th,#portwithvulnlist table tr th,#info table tr th { background:#d9d9d9;text-align:left;height:20px; border-bottom: 1px #bababa solid;padding-left:15px;white-space:normal; word-break:break-all;}\n"
				+ "#vulnView div table tr td,#osDistribution table tr td,#ipList table tr td,#vulnDistribution table tr td,#accounts table tr td,#standard table tr td,#portwithvulnlist table tr td,#info table tr td { text-align:left;border-bottom: 1px #bababa solid;padding-left:15px;white-space:normal; word-break:break-all;}\n"
				+ "#vulnView div table tr td.hv { background:#fedbcf }\n"
				+ "#vulnView div table tr td.mv { background:#f4e8ca }\n"

				+ "#info table caption { text-align:left; padding-left:15px; color: #707070 }\n"

				+ "#vulnDistribution table tr.vh td a,#portwithvulnlist table tr td ul li.vh a,#portwithvulnlist table tbody tr th.vh a { color:#e42b00 }\n"
				+ "#vulnDistribution table tr.vm td a,#portwithvulnlist table tr td ul li.vm a,#portwithvulnlist table tbody tr th.vm a { color:#ff9c00 }\n"
				+ "#vulnDistribution table tr.vl td a,#portwithvulnlist table tr td ul li.vl a,#portwithvulnlist table tbody tr th.vl a { color:#007f00 }\n"

				+ "#portwithvulnlist table tbody.lt tr th { background:transparent;vertical-align:text-top;white-space:nowrap }\n"
				+ "#portwithvulnlist table tbody.lt tr td { white-space:normal }\n"
				+ "#standard table tr.vh td { color:#e42b00 }\n"
				+ "#standard table tr.vm td { color:#ff9c00 }\n"
				+ "#standard table tr.vl td { color:#007f00 }\n"
				+ "#standard pre { text-align:left;padding-left:15px; }\n"
				+ "#standard div p { text-indent:0.6cm }\n"
				+ "#standard ul{padding:5px 20px;}\n"
				+ "#portwithvulnlist table tr td ul { list-style-type:none;margin:0px;list-style-position:outside;padding-left:5px }\n"
				+ "</style>\n"
				+ "<script language=\"JavaScript\">\n"
				+ "window.onload = function(){\n"
				+ "   setTitleList();\n"
			//	+ "   setTitle();\n"
				+ "}\n"
				+ "function setTitle(){\n"
				+ "   var h2 = $$('h2');\n"
				+ "   var h3 = $$('h3');\n"
				+ "   for(var i=0; i<h2.length; i++){\n"
				+ "       new Insertion.Top(h2[i], (i+1)+'.');\n"
				+ "   }\n"
				+ "   var preSeq = 1;\n"
				+ "   var secSeq = 1;\n"
				+ "   for(var j=0; j<h3.length; j++){\n"
				+ "       var preH2 = h3[j].previous('h2');\n"
				+ "     var index = h2.indexOf(preH2)+1;\n"
				+ "       if(index == 0) continue;\n"
				+ "       if(index != preSeq){\n"
				+ "           preSeq = index;\n"
				+ "           secSeq = 1;\n"
				+ "       }"
				+ "       new Insertion.Top(h3[j], preSeq+'.'+secSeq);\n"
				+ "       secSeq++;\n"
				+ "   }\n"
				+ "}\n"
				+ "function setTitleList(){\n"
				+ "   var arr = $$('#titleList li');\n"
				+ "    var nowSeq = 0;\n"
				+ "    var secSeq = 1;\n"
				+ "   for(var i=0; i<arr.length; i++){\n"
				+ "       if(arr[i].up(0).id !='titleList'){\n"
				+ "           new Insertion.Top(arr[i], nowSeq + '.' + secSeq);\n"
				+ "           secSeq++;\n"
				+ "           continue;\n"
				+ "       }\n"
				+ "       secSeq = 1;\n"
				+ "       nowSeq = nowSeq+1;\n"
				+ "       new Insertion.Top(arr[i], nowSeq + '.');\n"
				+ "   }\n"
				+ "}\n"
				+ "</script>  \n"
				+ "<body>\n"
				+ "<script>\n"
				+ "Event.observe(document.body, 'click', function(event){\n"
				+ "    var elt = Event.element(event);\n"
				+ "  if ('H2' == elt.tagName){\n"
				+ "      var img = $(elt).style.backgroundImage;\n"
				+ "      if(!img || img == \"url(images/up.gif)\"){\n"
				+ "          $(elt).style.backgroundImage =\"url(images/down.gif)\";\n"
				+ "        $(elt).nextSiblings().invoke('hide');\n"
				+ "  }else if(img == \"url(images/down.gif)\"){\n"
				+ "      $(elt).style.backgroundImage =\"url(images/up.gif)\";\n"
				+ "    $(elt).nextSiblings().invoke('show');\n"
				+ "  }\n"
				+ " }\n"
				+ " if ('H3' == elt.tagName){\n"
				+ "  var n = $(elt).nextSiblings();\n"
				+ "        if(!n) return false;\n"
				+ " for(var j=0; j<n.length; j++){\n"
				+ "  if(n[j].tagName == 'H3') break;\n"
				+ "  n[j].toggle();\n"
				+ "}\n"
				+ "}\n"
				
				+ " if ('H4' == elt.tagName){\n"
				+ "  var n = $(elt).nextSiblings();\n"
				+ "        if(!n) return false;\n"
				+ " for(var j=0; j<n.length; j++){\n"
				+ "  if(n[j].tagName == 'H4') break;\n"
				+ "  n[j].toggle();\n"
				+ "}\n"
				+ "}\n"
				+ "});\n"

				+ " showTheIp = function(t){\n"
				+ "	var  nextRow = $('vulDataTable').rows[t.rowIndex+1];\n"
				+ "	if(nextRow.style.display == \"none\") nextRow.style.display = \"\";\n"
				+ "	else nextRow.style.display = \"none\";\n"
				+ "	imageSwap(t.getElementsByTagName('img')[0], 'images/plus.gif','images/minus.gif');\n"
				+ "		}\n"

				+ "</script>\n";
		return qq;
	}

	private String End() {
		String qq;
		qq = " <div id=\"statusInformation\" style=\"display:none;\"><img src='/images/loading.gif' /> ���ݼ�����,���Ժ�...</div>\n"
				+ "<div id=\"responseMessage\" style=\"display:none;\"><!--������ʾ��Ϣ--></div> \n"
				+ " </body>\n" + " </html> \n";
		return qq;
	}

	private String List() {
		String qq;

		qq = " <!--������Ŀ¼-->"
				+ "  <script language=\"JavaScript\"> "
				+ " lastScrollY=0; "
				+ "  function heartBeat(){ "
				+ "  diffY=document.body.scrollTop; "
				+ "  percent=.1*(diffY-lastScrollY); "
				+ "  if(percent>0)percent=Math.ceil(percent); "
				+ "  else percent=Math.floor(percent); "
				+ "  document.all.reportIndex.style.pixelTop+=percent; "
				+ "  lastScrollY=lastScrollY+percent; "
				+ "  } "
				+ "  suspendcode45='<div id=\"reportIndex\" style=\"left:10px;POSITION:absolute;TOP:100px;\">"
				+ "<h1>Ŀ¼</h1><ul id=\"titleList\">" + "</ol>"
				+ "<li> <a href=\"#summary1\">�ۺ�����</a></li>" + "<ol>"
				+ " <li><a href=\"#summary1.1\">��������</a></li> "
				+ "<li><a href=\"#summary1.2\">��Σ������</a></li>"
				+ " <li><a href=\"#summary1.3\">�����Σ�յ�©��</a></li>"
				+ " <li><a href=\"#summary1.4\">����ϵͳ������</a></li>" + "</ol>"
				+ "<li> <a href=\"#summary2\">�����Ƕȷ�������</a></li>" + "<ol> "
				+ "<li><a href=\"#summary2.1\">������������</a></li>"
				+ " <li><a href=\"#summary2.2\">�����������б�</a></li>" + "</ol>"
				+ "<li> <a href=\"#summary3\">©���Ƕȷ�������</a></li>" + " <ol> "
				+ "<li><a href=\"#summary3.1\">���</a></li>	"
				+ "<li><a href=\"#summary3.2\">����</a></li> "
				+ "<li><a href=\"#summary3.3\">ϵͳ</a></li> "
				+ "<li><a href=\"#summary3.4\">��в</a></li>"
				+ " <li><a href=\"#summary3.5\">Ӧ��</a></li>"
				+ " <li><a href=\"#summary3.6\">ʱ��</a></li>"
				+ " <li><a href=\"#summary3.7\">©�����а�</a></li>" + "</ol>"
				+ "<li><a href=\"#summary4\">������</a></li>" + " <ol>"
				+ "<li><a href=\"#summary4.1\">����ϵͳ</a></li>"
				+ "<li><a href=\"#summary4.2\">Ӧ�ó����ʺ�</a></li>" + "</ol>"
				+ " <li><a href=\"#summary5\">©���ֲ�</a></li>" + "<ol>   "
				+ "</ol>   " + "<li><a href=\"#summary6\">�ο���׼</a></li>   "
				+ "<ol>   "
				+ "   <li><a href=\"#summary5.1\">©�����յȼ�������׼</a></li> "
				+ " <li><a href=\"#summary5.2\">�������յȼ�������׼</a></li> "
				+ " <li><a href=\"#summary5.3\">������յȼ�������׼</a></li>"
				+ " <li><a href=\"#summary5.4\">��ȫ����</a></li>" +

				"</ul> " + "</div>' ;" + "  document.write(suspendcode45); "
				+ "  window.setInterval(\"heartBeat()\",1); " + "  </script> ";
		return qq;
	}

	private String List_head() {
		String qq;

		qq = " <!--������Ŀ¼-->\n"
				+ "  <script language=\"JavaScript\"> \n"
				+ " lastScrollY=0; \n"
				+ "  function heartBeat(){ \n"
				+ "  diffY=document.body.scrollTop;\n "
				+ "  percent=.1*(diffY-lastScrollY); \n"
				+ "  if(percent>0)percent=Math.ceil(percent); \n"
				+ "  else percent=Math.floor(percent); \n"
				+ "  document.all.reportIndex.style.pixelTop+=percent;\n "
				+ "  lastScrollY=lastScrollY+percent; \n"
				+ "  } "
				+ "  suspendcode45='<div id=\"reportIndex\" style=\"left:10px;POSITION:absolute;TOP:100px;\">"
				+ "<h1>Ŀ¼</h1><ul id=\"titleList\">";
		// list = qq;
		return qq;
	}

	private String List_foot() {
		String qq;

		qq = "</ul> " + "</div>' ;" + "  document.write(suspendcode45);"
				+ "  window.setInterval(\"heartBeat()\",1); " + "  </script> ";
		// list += qq;
		return qq;
	}

	private String test() {
		String qq;
		qq = "<center>\n" + " <h1><img src=\"images/titlepic.gif\">"
				+ Cover_title + "</h1>\n " + "  <div class='bline'></div> \n";
		return qq;
	}

	private boolean write_file(FileWriter write_report, String msg)
			throws IOException {
		write_report.write(msg);
		return true;
	}

	private String Chapter_Head(String chapter, String info) {
		String qq;
		
		qq = " <div id='summaryWithIndex'>\n" + "<div id='summary'>\n"
				+ "<h2 id='summary" + (mark) + "' > " + info + "</h2> \n";
		list += "</ol>" + "<li> <a href=\"#summary" + (mark++) + "\" > " + info
				+ "</a></li> " + "<ol>";
		return qq;
	}
	private String Chapter(String str) {
		String qq;
		chapter_num[0]++;
		 
	 
		qq = Chapter_foot()+" <div id='summaryWithIndex'>\n" + "<div id='summary'>\n"
				+ "<h2 id='summary" + (mark) + "' > " + chapter_num[0]+str + "</h2> \n";
		list += "</ol>" + "<li> <a href=\"#summary" + (mark++) + "\" > " + str
				+ "</a></li> " + "<ol>";
		return qq;
	}
	public boolean set_chapter(String content,int plies)
	{
		String qq = "",p;
	
		if(plies == 1)
			qq = Chapter(content);
		else
		{
		 
			qq = Section(plies,content);
		}
		try {
			write_report.write(qq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;	
	}
	public boolean Set_Html_Foot()
	{
		try {
			write_report.write(Chapter_foot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;	
	}
	
	// Section("2","1.2","dasd"); 2
	private String Section(int plies, String info) {
		String qq;
		int i = 0;
	    String chapter_id = "";
		chapter_num[plies-1]++;
		chapter_num[plies] = 0;
		for(i = 0;i < plies;i ++)
			chapter_id += chapter_num[i]+".";
		qq = " <br>\n <h" + (plies+1) + " id='summary" + (mark) + "' > " + chapter_id+info
				+ "</h" + (plies+1) + ">\n <br/> \n";
		list += " <li><a href=\"#summary" + (mark++) + "\" > " + replist(info)+ "</a></li>  ";
	 
		return qq;
	}
	// Section("2","1.2","dasd");
	private String Section(String grade, String chapter, String info) {
		String qq;
		qq = " <br>\n <h" + grade + " id='summary" + (mark) + "' > " + info
				+ "</h" + grade + ">\n <br/> \n";
		list += " <li><a href=\"#summary" + (mark++) + "\" > " + replist(info)+ "</a></li>  ";
	 
		return qq;
	}
	public String replist(String str) {
		if (str == null||str.isEmpty())
			return "";
		String strp = str;
		strp = strp.replaceAll("\r", ""); 
		strp = strp.replaceAll("\n", ""); 
		return strp;
	}


	private String Strong(String info) {
		String qq;

		qq = " <br>" + "<strong >     " + info + "</strong>" + "<br/> "
				+ "<br/> ";
		return qq;
	}

	private String Href(String info) {
		String qq;
	 
		String tempStr[] = null;// ������ʱ�����ű�����ַ�����ѭ�����ɱ��
		qq = tempStr[0] = " <a href=\"" + info + "\"   target=\"_blank\">"
				+ info + "</a>";
		return qq;
	}

	public String Chapter_foot() {
		String qq;
		qq = " </div>\n </div>\n";	 
		return qq;
	}

	private String PeportParagraph(String info) {
		String qq;
		qq = "<table class=\"cmn_table\">\n" // id=\"cont_1\"
				+ "  <tr class=\"even\">\n " + "    <td>\n"
				+ info
				+ "     <br/> &nbsp;\n" + "     </td>\n"
				+ "   </tr>\n"
				+ "  </table>\n";
		return qq;

	}

	// Table_td( img,title,url,info)
	private String Table_td(String img, String title, String url, String info) {
		String qq = "";
		if (img != null && !img.isEmpty())
			qq = "<img src=\"images/" + img + "\" title=\"" + title
					+ "\" width=\"19\" height=\"17\" > ";
		/* �������URL����,�Ժ����ڼ���ȥ�� */
		if (url != null && !url.isEmpty())
			qq += "<a href=\"hosts/" + url + "\" target=\"_blank\">" + info
					+ "</a>";
		else
			qq += info;

		return qq;

	}

	// Table_td( img,title,url,info)
	private String Table_td_tmp(String img, String title, String url,
			String info) {
		String qq = "";
		if (img != null && !img.isEmpty())
			qq = "<img src=\"images/" + img + "\" title=\"" + title
					+ "\" width=\"19\" height=\"17\" > ";
		/*
		 * �������URL����,�Ժ����ڼ���ȥ�� if (url != null && !url.isEmpty()) qq +=
		 * "<a href=\"hosts/" + url + "\" target=\"_blank\">" + info + "</a>";
		 * else
		 */
		qq += info;

		return qq;

	}

	private String HTable(String Head[], Hashtable body) {
		return HTable(Head, body, true);
	}

	private String HTable(String Head[], Hashtable body, boolean isH) {
		String qq = "";
 
		String tempStr[] = null;// ������ʱ�����ű�����ַ�����ѭ�����ɱ��
		int i = 0, j = 0, len = 0;
		if (Head == null || Head.length <= 0)
			return qq;

		if (body != null) {
			len = body.size();
		}

		qq = "<table id=\"threatTable\" class=\"cmn_table\" isSortAble=\"true\">\n";
		if (isH) {
			qq += "<thead>\n"
					+ "	<tr class=\"second_title\" style=\"cursor:pointer\">\n";

			for (i = 0; i < Head.length; i++)
				qq += "	<th >" + Head[i] + "</th>\n"; // width=\"16%\"

			qq += "         </tr>\n</thead>\n";

			qq = qq + "  <tbody>\n";

		}

		if (body == null || body.size() <= 0) {
			qq += "		    	<tr class=\"odd\">\n";
			qq += "		<td colspan=\"" + Head.length + "\" >������</td>";
			qq = qq + "	</tr>\n";
		} else {

			tempStr = new String[Head.length];
			for (i = 0; i < len; i++) {
				qq += "		    	<tr class=\"odd\">\n";
				tempStr = (String[]) body.get(i);
				for (j = 0; j < Head.length; j++) {
					if (tempStr[j] == null)
						tempStr[j] = "---";
					qq += "		<td>" + tempStr[j] + "</td>\n";
				}
				qq = qq + "	</tr>\n";
			}
		}
		qq = qq + "		    </tbody>\n" + " </table> \n";
		// qq = repstr(qq);
		return qq;
	}

	public String repstr(String str) {
		if (str == null||str.isEmpty())
			return "";
		String strp = str;
		strp = strp.replaceAll("<", "&#60;");
		strp = strp.replaceAll(">", "&#62;");
		strp = strp.replaceAll("\"", "&#34;");
		strp = strp.replaceAll("'", "&#39;");
		return strp;
	}

	private String Table(String Head[], String body[][]) {
		return Table(Head, body, true);
	}

	private String Table(String Head[], String body[][], boolean isH) {
		String qq = "";
		int i = 0, j = 0, len = 0;
		if (Head == null || Head.length <= 0)
			return qq;

		if (body != null) {
			len = body.length;
		}

		qq = "<table id=\"threatTable\" class=\"cmn_table\" isSortAble=\"true\">\n";
		if (isH) {
			qq += "<thead>\n"
					+ "	<tr class=\"second_title\" style=\"cursor:pointer\">\n";

			for (i = 0; i < Head.length; i++)
				qq += "	<th >" + Head[i] + "</th>\n"; // width=\"16%\"

			qq += "         </tr>\n</thead>\n";

			qq = qq + "  <tbody>\n";
		}

		if (body == null || body.length <= 0) {
			qq += "		    	<tr class=\"odd\">\n";
			qq += "		<td colspan=\"" + Head.length + "\" >������</td>";
			qq = qq + "	</tr>\n";
		} else {

			for (i = 0; i < len; i++) {
				qq += "		    	<tr class=\"odd\">\n";
				for (j = 0; j < Head.length; j++) {
					if (body[i][j] == null)
						body[i][j] = "---";
					qq += "		<td>" + body[i][j] + "</td>\n";
				}
				qq = qq + "	</tr>\n";
			}
		}
		qq = qq + "		    </tbody>\n" + " </table> \n";

		return qq;
	}

	private String Body_img(String img, String alt) {
		String qq = "";
		// <img id="cont_2"
		// src="images/7f785e85c5b95110a652994841a074b5summary.png" alt='�ǳ�Σ��'
		// valign="middle" style="margin-left:40px" />
		File file = new File(imgpath + img);
		if (file.exists() && file.isFile()) {
			qq = "<img class=\"odd\" src='images/" + img + "' alt='" + alt
			+ "'width='642' /> ";
		}
	 
	
		return qq;
	}

	private String chapter_img(String img, String alt) {
		String qq = "";
		qq = "<img id=\"cont_2\" width='300' src='images/" + img + "' alt='" + alt
				+ "' valign=\"middle\" style=\"margin-left:40px\" />";
		return qq;
	}

}
