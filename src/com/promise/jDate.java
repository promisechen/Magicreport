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

	// �������ʱ�䷵���ܼ� time Ϊ0ʱ ȡ����ʱ��
	public int getWeek(long time) {
		int hour = 0;
		Date date = null;
		// ��ת��Ϊʱ��
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
		// hour�д�ľ������ڼ��ˣ��䷶Χ 1~7
		// 1=������ 7=����������������
		return hour;
	}

	// ���ظ����ڵ�00ʱ00��00�볤��������
	// ���ݸ���ʱ����ʱ��
	// ������һ��ʱ��
	public Long getMonday(long time) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getMondayx(time, 0));
		ret = date.getTime() / 1000;

		return ret;
	}

	// �����һ������ x:�Ը���һΪ���������� ����һΪ0
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

	// ���ظ����ڵ�00ʱ00��00�볤��������
	// ���ݸ���ʱ����ʱ��
	// ������һ��ʱ��
	public Long getNextMonday(long time) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getMondayx(time, 1));
		ret = date.getTime() / 1000;

		return ret;
	}

	// ���ظ����ڵ�00ʱ00��00�볤��������
	// ���ݸ���ʱ����ʱ��
	// ������һ��ʱ��
	public Long getMondays(long time, int x) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getMondayx(time, x));
		ret = date.getTime() / 1000;

		return ret;
	}

	// ������ʼ���������ڵ�����
	// end ����start
	public int getWeeks(long start_time, long end_time) throws ParseException {
		int ret = 0;
		long start = 0, end = 0, tmp = 0;
		if (start_time > end_time) {
			tmp = start_time;
			start_time = end_time;
			end_time = tmp;
		}
		start = getMonday(start_time);// ��ʼ���ڵ���һ
		end = getNextMonday(end_time);// �������ڵ�����һ
		while (start < end) {
			start = start + 7 * 24 * 60 * 60;
			ret++;
		}
		return ret;
	}

	// ���ո�ʽ��ȡ�ַ������ڣ����ڽ�����ʾ
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
	// ��ȡ���µ�һ��
	public String getFirstDayOfMonth(long time) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

		Calendar lastDate = Calendar.getInstance();
		Date date = new Date(time * 1000);
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ��ȡ�Ժ��µ�һ��
	public String getFirstDayOfMonthx(long time, int x) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

		Calendar lastDate = Calendar.getInstance();
		Date date = new Date(time * 1000);
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
		lastDate.add(Calendar.MONTH, x);// ��һ���£���Ϊ���µ�1��

		str = sdf.format(lastDate.getTime());
		return str;
	}

	// ���ظ����ڵ�00ʱ00��00�볤��������
	// ���ݸ���ʱ����ʱ��
	// ����һ�ŵ�ʱ��
	public Long getMonthx(long time, int x) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getFirstDayOfMonthx(time, x));
		ret = date.getTime() / 1000;

		return ret;
	}

	// ���ظ����ڵ�00ʱ00��00�볤��������
	// ���ݸ���ʱ����ʱ��
	// ����һ�ŵ�ʱ��
	public Long getMonth(long time) throws ParseException {
		long ret = 0;
		Date date = null;
		SimpleDateFormat myFormatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		date = myFormatter.parse(getFirstDayOfMonth(time));
		ret = date.getTime() / 1000;

		return ret;
	}

	// ������ʼ���������ڵ�����
	// end ����start
	// ��ȡ����
	public int getMonths(long start_time, long end_time) throws ParseException {
		int ret = 0;
		long start = 0, end = 0, tmp = 0;
		if (start_time > end_time) {
			tmp = start_time;
			start_time = end_time;
			end_time = tmp;
		}
		start = getMonthx(start_time, 0);// ��ʼ���ڵ�1��
		end = getMonthx(end_time, 1);// �������ڵ�����1��
		while (start < end) {

			ret++;
			start = getMonthx(start_time, ret);
		}
		return ret;
	}

	// ��ȡִ�д���
	public int getcount(String type, long start_time, long end_time)
			throws ParseException {
		if (type.equals("week"))
			return getWeeks(start_time, end_time);
		else
			return getMonths(start_time, end_time);

	}

	// ��ȡ��ʼʱ��
	public long getStartTime(String type, long start_time, int x)
			throws ParseException {
		if (type.equals("week"))
			return getMondays(start_time, x);
		else
			return getMonthx(start_time, x);

	}

	// ����
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
	 * jj.getMonday(1281961111);//��ȡ��һ] System.out.println(i);
	 * i=jj.getNextMonday(1281961111);//��ȡ����һ System.out.println(i); i=
	 * jj.getMondays(1281961111,2);//��ȡ��er��һ
	 * 
	 * System.out.println(i);
	 * 
	 * System.out.println(jj.getFirstDayOfMonthx(1281961111,1));
	 * System.out.println(jj.getMonthx(1281961111,1));//��ȡ���µ�x��1��
	 * System.out.println("jj"+jj.getMonths(1283270405,1277914362)); }
	 */
}
