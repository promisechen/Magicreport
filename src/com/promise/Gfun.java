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
import java.io.FileReader; // import java.io.PrintStream;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Gfun {

	public static String china_charset = "GBK";

	public String userlimit = "";

	public static char[] HexToBin(String str_h) {
		if ((str_h == null) || ("".equals(str_h)))
			return null;
		int length = str_h.length();
		char[] bin_char = new char[length * 4];
		int m = 0;
		int t = 0;
		for (m = 0; m < length; ++m)
			switch (str_h.charAt(m)) {
			case '0':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				break;
			case '1':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				break;
			case '2':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				break;
			case '3':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				break;
			case '4':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				break;
			case '5':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				break;
			case '6':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				break;
			case '7':

				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				break;
			case '8':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				break;
			case '9':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				break;
			case 'a':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				break;
			case 'b':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				break;
			case 'c':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '0';
				break;
			case 'd':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				bin_char[(t++)] = '1';
				break;
			case 'e':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '0';
				break;
			case 'f':

				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
				bin_char[(t++)] = '1';
			case ':':

			case ';':

			case '<':

			case '=':

			case '>':

			case '?':

			case '@':

			case 'A':

			case 'B':

			case 'C':

			case 'D':

			case 'E':

			case 'F':

			case 'G':

			case 'H':

			case 'I':

			case 'J':

			case 'K':

			case 'L':

			case 'M':

			case 'N':

			case 'O':

			case 'P':

			case 'Q':

			case 'R':

			case 'S':

			case 'T':

			case 'U':

			case 'V':

			case 'W':

			case 'X':

			case 'Y':

			case 'Z':

			case '[':

			case '\\':

			case ']':

			case '^':

			case '_':

			case '`':
			}
		return bin_char;
	}

	public static String HexToStr(String str_h) {
		if ((str_h == null) || ("".equals(str_h)))
			return "";
		int length = str_h.length();
		String str = "";
		int m = 0;
		int t = 0;
		for (m = 0; m < length; ++m)
			switch (str_h.charAt(m)) {
			case '0':

				t += 4;
				break;
			case '1':

				str = str + "," + (t + 3);
				t += 4;
				break;
			case '2':

				str = str + "," + (t + 2);
				t += 4;
				break;
			case '3':

				str = str + "," + (t + 2) + "," + (t + 3);
				t += 4;
				break;
			case '4':

				str = str + "," + (t + 1);
				t += 4;
				break;
			case '5':

				str = str + "," + (t + 1) + "," + (t + 3);
				t += 4;
				break;
			case '6':

				str = str + "," + (t + 1) + "," + (t + 2);
				t += 4;
				break;
			case '7':

				str = str + "," + (t + 1) + "," + (t + 2) + "," + (t + 3);
				t += 4;
				break;
			case '8':

				str = str + "," + t;
				t += 4;
				break;
			case '9':

				str = str + "," + t + "," + (t + 3);
				t += 4;
				break;
			case 'a':

				str = str + "," + t + "," + (t + 2);
				t += 4;
				break;
			case 'b':

				str = str + "," + t + "," + (t + 2) + "," + (t + 3);
				t += 4;
				break;
			case 'c':

				str = str + "," + t + "," + (t + 1);
				t += 4;
				break;
			case 'd':

				str = str + "," + t + "," + (t + 1) + "," + (t + 3);
				t += 4;
				break;
			case 'e':

				str = str + "," + t + "," + (t + 1) + "," + (t + 2);
				t += 4;
				break;
			case 'f':

				str = str + "," + t + "," + (t + 1) + "," + (t + 2) + ","
						+ (t + 3);
				t += 4;
			case ':':

			case ';':

			case '<':

			case '=':

			case '>':

			case '?':

			case '@':

			case 'A':

			case 'B':

			case 'C':

			case 'D':

			case 'E':

			case 'F':

			case 'G':

			case 'H':

			case 'I':

			case 'J':

			case 'K':

			case 'L':

			case 'M':

			case 'N':

			case 'O':

			case 'P':

			case 'Q':

			case 'R':

			case 'S':

			case 'T':

			case 'U':

			case 'V':

			case 'W':

			case 'X':

			case 'Y':

			case 'Z':

			case '[':

			case '\\':

			case ']':

			case '^':

			case '_':

			case '`':
			}
		return str;
	}

	public static double IptoDouble(String ip) {
		double ipn = 0.0D;
		String[] fip = split(ip, ".");
		for (int i = 0; i < 4; ++i) {
			ipn += Integer.parseInt(fip[i]) * Math.pow(256.0D, 3 - i);
		}
		return ipn;
	}

	public String[] changeDate(String[] sdate) {
		String[] edate = sdate;
		int i = 0;
		for (i = 0; i < edate.length; ++i)
			edate[i] = changeDate(sdate[i]);
		return edate;
	}

	public String changeDate(String sdate) {
		String edate = "";
		if (strnull(sdate).equals(""))
			return "";
		do {
			edate = edate + sdate.substring(0, sdate.indexOf("-"));
			sdate = sdate.substring(sdate.indexOf("-") + 1);
		} while (sdate.indexOf("-") > 0);

		edate = edate + sdate;

		return edate;
	}

	public String cutzero(String zstr) {
		int i = 0;
		int j = 0;
		int count = zstr.length();
		for (i = count - 1; i >= 0; --i) {
			if (zstr.charAt(i) != '0')
				break;
			j = i - 1;
		}

		String str1 = zstr.substring(0, j + 1);
		return str1;
	}

	public static String getNow() {
		Date newDate = new Date();
		String nowd = "";
		int hours = newDate.getHours();
		int minutes = newDate.getMinutes();
		int month = newDate.getMonth() + 1;
		int date = newDate.getDate();
		nowd = (1900 + newDate.getYear()) + "-" + ((month < 10) ? "0" : "")
				+ month + "-" + ((date < 10) ? "0" : "") + date + " "
				+ ((hours < 10) ? "0" : "") + hours + ":"
				+ ((minutes < 10) ? "0" : "") + minutes;

		newDate = null;
		return nowd;
	}

	public static String get_a_line_of_file(String file_path, int line_number) {
		File objFile = new File(file_path);
		String soft_edition = "";

		if (objFile.exists()) {
			try {
				FileReader objFileReader = new FileReader(objFile);
				for (int i = 0; i < line_number; ++i) {
					soft_edition = "";
					int intchar = objFileReader.read();
					while ((intchar != 10) && (intchar != -1)) {
						soft_edition = soft_edition + (char) intchar;
						intchar = objFileReader.read();
					}
				}
				objFileReader.close();
			} catch (Exception e) {
			}
			objFile = null;
			return soft_edition;
		}
		objFile = null;
		return null;
	}

	public String get_checkvalue(HttpServletRequest request, String strname) {
		String[] array = request.getParameterValues(strname);
		String strreturn = "";
		int i = 0;
		if (array == null)
			return "";
		for (i = 0; i < array.length; ++i)
			strreturn = strreturn + "," + array[i];
		array = null;
		return strreturn.substring(1);
	}

	public String get_limit() {
		return this.userlimit;
	}

	public String get_quanxian(HttpServletRequest request, String a) {
		String[] access = request.getParameterValues(a);
		char[] limit = new char[200];
		int i = 0;
		int col = 0;
		int maxl = 0;
		if (access == null)
			return "";
		for (i = 0; i < 200; ++i)
			limit[i] = '0';
		for (i = 0; i < access.length; ++i) {
			if (access[i] != null) {
				col = Integer.parseInt(access[i]);
				if (maxl < col)
					maxl = col;
				limit[(col - 1)] = '1';
			}
		}
		String limitaccess = new String(limit, 0, maxl);
		access = null;
		limit = null;
		return limitaccess;
	}

	public static String getdate() {
		String datetime = "";
		String month = "";
		String date = "";
		Date now = new Date();
		month = "0" + (now.getMonth() + 1);
		month = month.substring(month.length() - 2, month.length());
		date = "0" + now.getDate();
		date = date.substring(date.length() - 2, date.length());
		datetime = (now.getYear() + 1900) + month + date;
		month = null;
		date = null;
		now = null;
		return datetime;
	}

	public static String getdatetime() {
		String datetime = "";
		String month = "";
		String date = "";
		String hour = "";
		String min = "";
		Date now = new Date();
		month = "0" + (now.getMonth() + 1);
		month = month.substring(month.length() - 2, month.length());
		date = "0" + now.getDate();
		date = date.substring(date.length() - 2, date.length());
		hour = "0" + now.getHours();
		hour = hour.substring(hour.length() - 2, hour.length());
		min = "0" + now.getMinutes();
		min = min.substring(min.length() - 2, min.length());

		datetime = (now.getYear() + 1900) + month + date + "_" + hour + "h"
				+ min + "m";
		now = null;
		month = null;
		date = null;
		hour = null;
		min = null;
		return datetime;
	}

	public static String getdatetime_cn() {
		String datetime = "";
		String month = "";
		String date = "";
		String hour = "";
		String min = "";
		String sec = "";
		Date now = new Date();
		month = "0" + (now.getMonth() + 1);
		month = month.substring(month.length() - 2, month.length());
		date = "0" + now.getDate();
		date = date.substring(date.length() - 2, date.length());
		hour = "0" + now.getHours();
		hour = hour.substring(hour.length() - 2, hour.length());
		min = "0" + now.getMinutes();
		min = min.substring(min.length() - 2, min.length());

		datetime = (now.getYear() + 1900) + "年" + month + "月" + date + "日 "
				+ hour + "时" + min + "分";
		now = null;
		month = null;
		date = null;
		hour = null;
		min = null;
		return datetime;
	}

	public static int getpage(String btn, int curpage, int maxpage,
			String topage) {
		if (btn != null) {
			if ((btn.equals("上一页")) && (curpage >= 2))
				curpage -= 1;
			else if ((btn.equals("下一页")) && (curpage < maxpage))
				curpage += 1;
			else if (btn.equals("首页"))
				curpage = 1;
			else if (btn.equals("尾页"))
				curpage = maxpage;
			else if (btn.equals("转 到")) {
				if (topage != null) {
					if (topage.length() > 0)
						curpage = (int) Float.parseFloat(topage);
				}
			}
		}
		if (curpage > maxpage)
			curpage = maxpage;
		if (curpage < 1)
			curpage = 1;
		return curpage;
	}

	public static int getpage(String btn, int curpage, int maxpage) {
		if (btn != null) {
			if ((btn.equals("上一页")) && (curpage >= 2))
				curpage -= 1;
			else if ((btn.equals("下一页")) && (curpage < maxpage))
				curpage += 1;
			else if (btn.equals("首页"))
				curpage = 1;
			else if (btn.equals("尾页")) {
				curpage = maxpage;
			}
		}
		return curpage;
	}

	public static String joinstr(String[] str, String br) {
		String results = "";
		StringBuffer stra = new StringBuffer();
		if (str == null)
			return "";
		for (int i = 0; i < str.length; ++i) {
			stra.append(str[i] + br);
		}
		results = stra.toString();
		return results;
	}

	public boolean limit(int limitno) {
		int llen = this.userlimit.length();
		if ((limitno > 0) && (llen >= limitno)) {
			if (this.userlimit.charAt(limitno - 1) != '0')
				return true;
		}
		return false;
	}

	public boolean limit(HttpSession session, HttpServletResponse response)
			throws Exception {
		try {
			return limit(session, response, null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public boolean limit(HttpSession session, HttpServletResponse response,
			int limitno) throws Exception {
		int[] limitlist = null;
		boolean lb = false;
		if (limitno > 0) {
			limitlist = new int[1];
			limitlist[0] = limitno;
		}
		try {
			lb = limit(session, response, limitlist);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			limitlist = null;
		}
		return lb;
	}

	public boolean limit(HttpSession session, HttpServletResponse response,
			int[] limitno) throws Exception {
		try {
			int i = 0;

			String code = (String) session.getValue("MM_Username");
			if (code == null) {
				response.sendRedirect("restrict.jsp");
				return false;
			}

			this.userlimit = ((String) session.getValue("MM_UserAuthorization"));
			if ((this.userlimit == null) || (this.userlimit.equals(""))) {
				response.sendRedirect("restrict.jsp");
				return false;
			}
			int llen = this.userlimit.length();

			if (limitno == null)
				return true;
			for (i = 0; i < limitno.length; ++i) {
				if ((limitno[i] <= 0) || (llen < limitno[i]))
					continue;
				if (this.userlimit.charAt(limitno[i] - 1) != '0')
					return true;
			}

			response.sendRedirect("restrict.jsp");
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static String replace(String source, String str_old, String str_new) {
		String str = "";
		int pos = 0;
		if (source == null)
			return "";
		str = source;
		pos = str.indexOf(str_old);
		while (pos >= 0) {
			if (pos < str.length())
				str = str.substring(0, pos) + str_new
						+ str.substring(pos + str_old.length());
			else
				str = str.substring(0, pos) + str_new;
			pos = str.indexOf(str_old, pos + str_new.length());
		}
		return str;
	}

	public static String replace_luanma(String source) {
		Matcher m = Pattern.compile("[^一-龥&&[^\\x21-\\x7e&&[^\\t\\n\\r ]]]")
				.matcher(source);
		StringBuffer sbr = new StringBuffer();
		for (; m.find(); m.appendReplacement(sbr, "?"))
			;
		m.appendTail(sbr);
		return sbr.toString();
	}

	public static String scanTime() {
		String[] dayNames = new String[7];
		dayNames[0] = "星期日";
		dayNames[1] = "星期一";
		dayNames[2] = "星期二";
		dayNames[3] = "星期三";
		dayNames[4] = "星期四";
		dayNames[5] = "星期五";
		dayNames[6] = "星期六";

		Date newDate = new Date();

		int hours = newDate.getHours();
		int minutes = newDate.getMinutes();
		int seconds = newDate.getSeconds();

		String timeValue = (hours >= 12) ? " 下午 " : " 上午 ";
		timeValue = timeValue + " " + ((hours > 12) ? hours - 12 : hours);
		timeValue = timeValue + ((minutes < 10) ? ":0" : ":") + minutes;
		timeValue = timeValue + ((seconds < 10) ? ":0" : ":") + seconds;
		int month = newDate.getMonth() + 1;
		int date = newDate.getDate();

		String newStr = (1900 + newDate.getYear()) + "年"
				+ ((month < 10) ? "0" : "") + month + "月"
				+ ((date < 10) ? "0" : "") + date + "日 "
				+ dayNames[newDate.getDay()] + timeValue;

		dayNames = null;
		newDate = null;
		return newStr;
	}

	public void set_limit(String limit) {
		this.userlimit = limit;
	}

	public void shenhe_quanxian(HttpSession session,
			HttpServletResponse response, String xiangmudaima, String flag) {
	}

	public static String[] split(String str, String space) {
		Vector vectors = new Vector();
		String temp = "";
		String[] results = null;
		int i = str.indexOf(space);
		while (i > 0) {
			temp = str.substring(0, i);
			str = str.substring(i + 1);
			vectors.addElement(temp);
			i = str.indexOf(space);
		}
		if (!(str.equalsIgnoreCase(""))) {
			vectors.addElement(str);
		}
		results = new String[vectors.size()];
		for (int j = 0; j < vectors.size(); ++j) {
			results[j] = ((String) vectors.get(j));
		}
		vectors = null;
		temp = null;
		return results;
	}

	public static String[] strnull(String[] strIn) {
		String[] strOut = strIn;
		int i = 0;
		if (strIn == null)
			return null;
		for (i = 0; i < strIn.length; ++i) {
			if ((strIn[i] != null) && (!(strIn[i].trim().equals(""))))
				continue;
			strOut[i] = "";
		}
		return strOut;
	}

	public static String strnull(BigDecimal strn) {
		String str = "";
		if (strn == null)
			str = "0";
		else
			str = strn.toString();
		return str;
	}

	public static String strnull(Date strn) {
		String str = "";
		if (strn == null)
			str = "0000-00-00 00:00:00";
		else
			str = strn.toString();
		return str;
	}

	public static String strnull(String strn) {
		if (strn == null)
			strn = "";
		return strn.trim();
	}

	public static String strzero(String strz) {
		if (strz == null)
			strz = "0";
		else if (strz.trim().length() <= 0)
			strz = "0";
		return strz;
	}

	public static Timestamp toTimestamp(String str)
			throws IllegalArgumentException {
		if ((str == null) || (str.trim().equals("")))
			return null;
		String dt = str.trim();
		int len = dt.length();

		if (len == 10)
			dt = dt + " 00:00:00.0";
		else if (len == 16)
			dt = dt + ":00.0";
		else if (len == 19)
			dt = dt + ".0";
		else if (len == 8)
			dt = "20" + dt + " 00:00:00.0";
		else if (len == 14)
			dt = "20" + dt + ":00.0";
		else if (len == 17)
			dt = "20" + dt + ".0";
		else
			dt = "0000-00-00 00:00:00.0";

		return Timestamp.valueOf(dt);
	}

	public static String[] tochinese(String[] strIn) {
		String[] strOut = strIn;
		int i = 0;
		if (strIn == null)
			return null;
		try {
			for (i = 0; i < strIn.length; ++i)
				if ((strIn[i] == null) || (strIn[i].trim().equals("")))
					strOut[i] = "";
				else
					strOut[i] = new String(strIn[i].getBytes("ISO8859_1"),
							china_charset);
		} catch (Exception e) {
		}
		return strOut;
	}

	public static String tochinese(String strIn) {
		if (strIn == null)
			return "";
		Properties prop = System.getProperties();
		String encode = prop.getProperty("file.encoding");

		String strOut = strIn;
		// if (!(encode.substring(0, 2).equals("GB")))
		try {

			// strOut = new String(strIn.getBytes(""), "UTF-8");
		} catch (Exception e) {

		}
		prop = null;
		encode = null;
		return strOut;
	}

	public static String tounicode(String strIn) {
		String strOut = strIn;
		if ((strIn == null) || (strIn.trim().equals("")))
			return strIn;
		try {
			strOut = new String(strIn.getBytes(china_charset), "ISO8859_1");
		} catch (Exception e) {
		}
		return strOut;
	}

}
