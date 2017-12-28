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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class jDate {

	public int long_week(long time) {
		java.util.Date date = new Date(time * 1000);
		SimpleDateFormat formatter4 = new SimpleDateFormat("EEEE");
		String mydate3 = formatter4.format(date);
		return 1;
	}

	// 输入格林时间返回周几 time 为0时 取当天时间
	public int getWeek(long time) {
		int hour = 0;
		Date date = null;
		// 再转换为时间
		if (time == 0)
			date = new Date();
		else
			date = new Date(time * 1000);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		hour = c.get(Calendar.DAY_OF_WEEK);
		hour--;
		if (hour == 0)
			hour = 7;
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return hour;
	}

	// 返回该日期的00时00分00秒长整形数据
	// 数据格林时间制时间
	// 返回周一的时间
	public Long getMonday(long time) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getMondayx(time, 0));
		ret = date.getTime() / 1000;

		return ret;
	}

	// 获得周一的日期 x:以该周一为基础向后计算 本周一为0
	public String getMondayx(long time, int x) {
		int mondayPlus = 1 - getWeek(time) + 7 * x;

		Date date = null;
		if (time == 0)
			date = new Date();
		else
			date = new Date(time * 1000);

		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.setTime(date);
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		SimpleDateFormat myFormatter1 = new SimpleDateFormat(
				"yyyy-MM-dd 00:00:00");

		String preMonday = myFormatter1.format(monday);

		return preMonday;
	}

	// 返回该日期的00时00分00秒长整形数据
	// 数据格林时间制时间
	// 返回周一的时间
	public Long getNextMonday(long time) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getMondayx(time, 1));
		ret = date.getTime() / 1000;

		return ret;
	}

	// 返回该日期的00时00分00秒长整形数据
	// 数据格林时间制时间
	// 返回周一的时间
	public Long getMondays(long time, int x) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getMondayx(time, x));
		ret = date.getTime() / 1000;

		return ret;
	}

	// 返回起始至结束日期的天数
	// end 大于start
	public int getWeeks(long start_time, long end_time) throws ParseException {
		int ret = 0;
		long start = 0, end = 0, tmp = 0;
		if (start_time > end_time) {
			tmp = start_time;
			start_time = end_time;
			end_time = tmp;
		}
		start = getMonday(start_time);// 开始日期的周一
		end = getNextMonday(end_time);// 结束日期的下周一
		while (start < end) {
			start = start + 7 * 24 * 60 * 60;
			ret++;
		}
		return ret;
	}

	// 按照格式获取字符型日期，用于界面显示
	public static String getDate(long time, String format) {
		Date date = new Date(time * 1000);
		SimpleDateFormat myFormatter = new SimpleDateFormat(format);
		return myFormatter.format(date);
	}
	public static String getDate(String time, String format) {
		Date date = new Date(Long.parseLong(time) * 1000);
		SimpleDateFormat myFormatter = new SimpleDateFormat(format);
		return myFormatter.format(date);
	}
	// 获取当月第一天
	public String getFirstDayOfMonth(long time) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

		Calendar lastDate = Calendar.getInstance();
		Date date = new Date(time * 1000);
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 获取以后月第一天
	public String getFirstDayOfMonthx(long time, int x) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

		Calendar lastDate = Calendar.getInstance();
		Date date = new Date(time * 1000);
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, x);// 加一个月，变为下月的1号

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// 返回该日期的00时00分00秒长整形数据
	// 数据格林时间制时间
	// 返回一号的时间
	public Long getMonthx(long time, int x) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getFirstDayOfMonthx(time, x));
		ret = date.getTime() / 1000;

		return ret;
	}

	// 返回该日期的00时00分00秒长整形数据
	// 数据格林时间制时间
	// 返回一号的时间
	public Long getMonth(long time) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getFirstDayOfMonth(time));
		ret = date.getTime() / 1000;

		return ret;
	}

	// 返回起始至结束日期的天数
	// end 大于start
	// 获取月数
	public int getMonths(long start_time, long end_time) throws ParseException {
		int ret = 0;
		long start = 0, end = 0, tmp = 0;
		if (start_time > end_time) {
			tmp = start_time;
			start_time = end_time;
			end_time = tmp;
		}
		start = getMonthx(start_time, 0);// 开始日期的1号
		end = getMonthx(end_time, 1);// 结束日期的下月1号
		while (start < end) {

			ret++;
			start = getMonthx(start_time, ret);
		}
		return ret;
	}

	// 或取执行次数
	public int getcount(String type, long start_time, long end_time)
			throws ParseException {
		if (type.equals("week"))
			return getWeeks(start_time, end_time);
		else
			return getMonths(start_time, end_time);

	}

	// 获取起始时间
	public long getStartTime(String type, long start_time, int x)
			throws ParseException {
		if (type.equals("week"))
			return getMondays(start_time, x);
		else
			return getMonthx(start_time, x);

	}

	// 无用
	public long getTimeGap(String type, long start_time) throws ParseException {
		if (type.equals("week"))
			return getMonday(start_time);
		else
			return getMonthx(start_time, 0);
	}
	/*
	 * public static void main(String[] args) throws ParseException { jDate jj =
	 * new jDate(); Date date = new Date(); String format =
	 * "yyyy-MM-dd HH:mm:ss"; long i = date.getTime()/1000;
	 * System.out.println("now"); System.out.println(+i); i=
	 * jj.getMonday(1281961111);//获取周一] System.out.println(i);
	 * i=jj.getNextMonday(1281961111);//获取下周一 System.out.println(i); i=
	 * jj.getMondays(1281961111,2);//获取下er周一
	 * 
	 * System.out.println(i);
	 * 
	 * System.out.println(jj.getFirstDayOfMonthx(1281961111,1));
	 * System.out.println(jj.getMonthx(1281961111,1));//获取该月的x月1号
	 * System.out.println("jj"+jj.getMonths(1283270405,1277914362)); }
	 */
}
