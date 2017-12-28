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
import java.io.*;

import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.*; //import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.*;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;

import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle; //import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

import com.lowagie.text.pdf.BaseFont;

public class jpie {

	/**
	 * @param args
	 */
	public boolean draw3DPie(String filename, DefaultPieDataset data,
			String title, int width, int height) {
		try {
			// width = 300;
			// height= 200;
			DefaultPieDataset data_tmp = data;
			JFreeChart chart = ChartFactory.createPieChart3D(title, data_tmp,
					true, true, false);
			Font font = new Font("����", Font.PLAIN, 13);
			// font.createFont(fontFormat, fontFile);
			int i = 0;
			TextTitle tt = new TextTitle(title);
			tt.setFont(font);
			chart.setTitle(tt);
			chart.setBackgroundPaint(Color.white);
			chart.setBorderVisible(false);
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setLabelGenerator(null);// ������

			// plot.setLabelGenerator(new
			// StandardPieSectionLabelGenerator("{2}"));//����ͼƬ��ʾ������,С��
			// plot.setSectionLabelType(section, paint)
			// plot.setExplodePercent(data.getKey(1),0.80);
			plot.setForegroundAlpha(0.2F);// ����͸��
			// plot.setParent(parent);

			plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}({1};{2})"));
			plot.setDepthFactor(0.05D);// ���
			// com.lowagie.text.Font bfChinese =
			// com.lowagie.text.pdf.BaseFont.createFont("STSongStd-Light",
			// "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			plot.setBackgroundPaint(Color.WHITE);// ��ͼ��ɫ
			// plot.setBaseSectionPaint(Color.WHITE);
			plot.setLabelFont(new Font("����", Font.PLAIN, 8));// ͼ��Ϊ����
			System.out.println(data.getKey(0));

			System.out.println(data.getItemCount());
			Color Rcolor[] = new Color[] { new Color(255, 85, 76),
					new Color(228, 94, 230), new Color(255, 254, 77),
					new Color(82, 84, 254), new Color(83, 254, 84) };

			for (i = 0; i < data.getItemCount() && i < 5; i++)
				plot.setSectionPaint(data.getKey(i), Rcolor[4 - i]);
			// System.out.print("key"+data.getValue(0));
			/*
			 * if((data.getValue(0) != null)&& (data.getValue(0).longValue() !=
			 * 0)) plot.setSectionPaint(data.getKey(0), new Color(255,85,76));
			 * 
			 * if(data.getValue(1) != null && data.getValue(0).longValue() != 0)
			 * plot.setSectionPaint(data.getKey(1), new Color(228,94,230));
			 * 
			 * if(data.getValue(2) != null && data.getValue(0).longValue() != 0)
			 * plot.setSectionPaint(data.getKey(2), new Color(255,254,77));
			 * 
			 * if(data.getValue(3) != null && data.getValue(0).longValue() != 0)
			 * plot.setSectionPaint(data.getKey(3), new Color(82,84,254));
			 * 
			 * if(data.getValue(4) != null && data.getValue(0).longValue() != 0)
			 * plot.setSectionPaint(data.getKey(4), new Color(83,254,84));
			 */
			BarRenderer renderer = new BarRenderer();

			renderer.setSeriesPaint(0, new Color(255, 85, 82));
			renderer.setSeriesPaint(1, new Color(255, 85, 255));
			renderer.setSeriesPaint(2, new Color(255, 255, 82));
			renderer.setSeriesPaint(3, new Color(82, 85, 255));
			renderer.setSeriesPaint(4, new Color(82, 255, 82));

			renderer.setSeriesPaint(4, new Color(255, 85, 76), true);
			renderer.setSeriesPaint(3, new Color(228, 94, 230));
			renderer.setSeriesPaint(2, new Color(255, 254, 77));
			renderer.setSeriesPaint(1, new Color(82, 84, 254));
			renderer.setSeriesPaint(0, new Color(83, 254, 84));
			plot.setNoDataMessage("");
			chart.getLegend().setBackgroundPaint(Color.white);
			chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 14));
			ChartUtilities.saveChartAsJPEG(new File(filename), 1, chart, width,
					height);

			chart = null;
			plot = null;
		} catch (Exception e) {
			System.out.println("--draw pie error:" + e + "--");
			return false;
		}
		return true;
	}

	public boolean drawBar(String filename, DefaultCategoryDataset data,
			String title, String rowstr, String colstr, int width, int height) {
		return drawBar(filename, data, title, rowstr, colstr, width, height, 0);
	}

	@SuppressWarnings("deprecation")
	public boolean drawBar(String filename, DefaultCategoryDataset data,
			String title, String rowstr, String colstr, int width, int height,
			double maxranger) {
		try {
			JFreeChart chart = ChartFactory.createBarChart(title, rowstr,
					colstr, data, PlotOrientation.VERTICAL, true, true, false);
			chart.setBackgroundPaint(Color.white);
			java.awt.Font font = new Font("����", Font.PLAIN, 15);
			TextTitle tt = new TextTitle(title);
			tt.setFont(font);
			chart.setTitle(tt);

			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			// plot.setForegroundAlpha(0.9f); //͸����

			// plot.setLabelFont(new Font("����",Font.PLAIN,15));//ͼ��Ϊ����
			// ��ֱ�����������
			System.out.println(plot.getDomainAxisCount());
			ValueAxis rangeAxis = plot.getRangeAxis();
			rangeAxis.setUpperMargin(0.15); // ������ߵ�һ������ͼƬ���˵ľ���
			rangeAxis.setLabelFont(new Font("����", Font.PLAIN, 14)); // ����������
			rangeAxis.setTickLabelFont(new Font("����", Font.PLAIN, 12)); // ����ֵ����
			rangeAxis.setLabelAngle(90);
			if (maxranger > 0)
				rangeAxis.setRange(0, maxranger); // ��������ĸ߶ȷ�Χ

			plot.setRangeAxis(rangeAxis);

			// �������������
			// CategoryAxis domainAxis=plot.getDomainAxis();
			CategoryAxis domainAxis = plot.getDomainAxis(0);
			domainAxis.setLabelFont(new Font("����", Font.PLAIN, 14)); // ���������
			domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 13)); // ����ֵ����
			// domainAxis.setMaximumCategoryLabelWidthRatio(1.2f); //ÿ����Ŀ˵�����ֵļ��
			domainAxis.setMaximumCategoryLabelLines(10); // ����ֵ�����ʾ����
			domainAxis.setCategoryMargin(0.15); // ��Ŀ���
			domainAxis.setUpperMargin(0.03); // ��������������
			domainAxis.setLowerMargin(0.03); // �ұ���ͼ�߿����

			plot.setDomainAxis(domainAxis);

			// ����������ɫ
			BarRenderer renderer = new BarRenderer();
			renderer.setSeriesPaint(4, new Color(255, 85, 76), true);
			renderer.setSeriesPaint(3, new Color(228, 94, 230));
			renderer.setSeriesPaint(2, new Color(255, 254, 77));
			renderer.setSeriesPaint(1, new Color(82, 84, 254));
			renderer.setSeriesPaint(0, new Color(83, 254, 84));
			// LayeredBarRenderer
			// ����ÿ������֮�����
			renderer.setItemMargin(0.0);

			// ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
			// renderer.setBaseItemLabelFont(new Font("����",Font.PLAIN,10));

			renderer.setBaseItemLabelFont(new Font("����", Font.PLAIN, 10));
			renderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setBaseItemLabelFont(new Font("����", Font.PLAIN, 10));
			renderer.setBaseItemLabelsVisible(true);

			renderer.setBaseLegendTextFont(new Font("����", Font.PLAIN, 10));// ��������

			plot.setRenderer(renderer);
			// ����͸����
			// plot.setForegroundAlpha(0.6f);
			plot.setBackgroundPaint(Color.WHITE);
			ChartUtilities.saveChartAsJPEG(new File(filename), 1, chart, width,
					height);
			// ���
			chart = null;
			font = null;
			tt = null;
			plot = null;
			rangeAxis = null;
			domainAxis = null;
			renderer = null;
		} catch (Exception e) {
			System.out.println("  draw chart error :" + e);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String title = "jumpͳ��";
		// Font font = new Font("SimSun", 10, 20);
		jpie p = new jpie();
		DefaultPieDataset piedata = new DefaultPieDataset();

		piedata.setValue("�Ƚϰ�ȫ", 200);
		piedata.setValue("�Ƚϰ�ȫ1", 200);
		piedata.setValue("�Ƚ�Σ��1", 200);
		piedata.setValue("�Ƚ�Σ��", 200);

		p.draw3DPie("C:\\PieChart1.jpg", piedata, title, 300, 200);
		p.draw3DPie("C:\\PieChart21.jpg", piedata, title, 300, 300);
		DefaultCategoryDataset ipdata = new DefaultCategoryDataset();
		ipdata.setValue(1, "a1", "�������������������");
		ipdata.setValue(2, "b2", "���忬�忬�忬�忬�忬�� ");
		ipdata.setValue(3, "c2", "����������������������");
		ipdata.setValue(4, "d2", "��������������������������������");
		ipdata.setValue(3, "e2", "ʱ��ʱ��ʱ��ʱ��ʱ��ʱ��ʱ��ʱ��");
		ipdata.setValue(4, "f2", "ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��");
		p.drawBar("C:\\bar.jpg", ipdata, "��Σ�յ�IP", "IP��ַ", "©����", 692, 220, 0);

	}

	public boolean drawBare(String filename, DefaultCategoryDataset data,
			String title, String rowstr, String colstr, int width, int height,
			double maxranger) {
		try {

			JFreeChart chart = ChartFactory.createBarChart(title, rowstr,
					colstr, data, PlotOrientation.VERTICAL, true, true, false);

			chart.setBackgroundPaint(Color.white);
			java.awt.Font font = new Font("����", Font.PLAIN, 15);
			TextTitle tt = new TextTitle(title);
			tt.setFont(font);
			chart.setTitle(tt);

			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			// plot.setForegroundAlpha(0.9f); //͸����

			// ��ֱ�����������
			ValueAxis rangeAxis = plot.getRangeAxis();
			rangeAxis.setUpperMargin(0.15); // ������ߵ�һ������ͼƬ���˵ľ���
			rangeAxis.setLabelFont(new Font("����", Font.PLAIN, 14)); // ����������
			rangeAxis.setTickLabelFont(new Font("����", Font.PLAIN, 12)); // ����ֵ����
			if (maxranger > 0)
				rangeAxis.setRange(0, maxranger); // ��������ĸ߶ȷ�Χ
			plot.setRangeAxis(rangeAxis);

			// �������������
			CategoryAxis domainAxis = plot.getDomainAxis();
			domainAxis.setLabelFont(new Font("����", Font.PLAIN, 14)); // ���������
			domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 13)); // ����ֵ����
			domainAxis.setMaximumCategoryLabelWidthRatio(1.3f); // ÿ����Ŀ˵�����ֵļ��
			domainAxis.setMaximumCategoryLabelLines(2); // ����ֵ�����ʾ����
			// domainAxis.setCategoryMargin(0.15); //��Ŀ���
			domainAxis.setUpperMargin(0.03); // ��������������
			domainAxis.setLowerMargin(0.03); // �ұ���ͼ�߿����
			plot.setDomainAxis(domainAxis);

			// ����������ɫ
			BarRenderer renderer = new BarRenderer();
			renderer.setSeriesPaint(0, new Color(255, 85, 82));
			renderer.setSeriesPaint(1, new Color(255, 85, 255));
			renderer.setSeriesPaint(2, new Color(255, 255, 82));
			renderer.setSeriesPaint(3, new Color(82, 85, 255));
			renderer.setSeriesPaint(4, new Color(82, 255, 82));
			// ����ÿ������֮�����
			renderer.setItemMargin(0.0);
			// ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
			renderer
					.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setItemLabelFont(new Font("����", Font.PLAIN, 10));
			renderer.setItemLabelsVisible(true);
			plot.setRenderer(renderer);
			plot.setForegroundAlpha(0.6f);
			plot.setBackgroundPaint(Color.WHITE);
			ChartUtilities.saveChartAsJPEG(new File(filename), (float) 0.9,
					chart, width, height);
			// ChartUtilities.saveChartAsJPEG(new
			// File(filename),2,chart,width,height);
			// ���
			chart = null;
			font = null;
			tt = null;
			plot = null;
			rangeAxis = null;
			domainAxis = null;
			renderer = null;
		} catch (Exception e) {
			System.out.println("  draw chart error :" + e);
			return false;
		}
		return true;
	}

	public void drawLine(String filename, DefaultCategoryDataset dataSet,
			String title, String rowstr, String colstr, int width, int height,
			double maxranger) {
		java.awt.Font font = new Font("����", Font.PLAIN, 10);
		String sql = "select count(id) num, DATE_FORMAT(calltime, '%Y��%m��') ym,modulename mn from  tongji t group by DATE_FORMAT(calltime, '%Y��%m��'),mn";
		// List list = getList(sql);
		// ��ͼ���ݼ�
		// DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		// for (Object obj : list) {
		// Map<String, Object> map = (Map) obj;
		// dataSet.setValue((Long) map.get("num"), (String) map.get("mn"),
		// map.get("ym").toString());
		// }

		// 206,207,255
		// �����createLineChart��ΪcreateLineChart3D�ͱ�Ϊ��3DЧ��������ͼ
		
		JFreeChart chart = ChartFactory.createLineChart(title, rowstr, colstr,
				dataSet, PlotOrientation.VERTICAL, // ���Ʒ���
				true, // ��ʾͼ��  linuxϵͳ������TRUE
				true, // ���ñ�׼������
				false // �Ƿ����ɳ�����
				);
		chart.getTitle().setFont(font); // ���ñ�������
		chart.getLegend().setItemFont(font);// ����ͼ���������
		chart.setBorderPaint(Color.green);
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.WHITE); // ���û�ͼ������ɫ
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // ����ˮƽ���򱳾�����ɫ
		plot.setRangeGridlinesVisible(true);// �����Ƿ���ʾˮƽ���򱳾���,Ĭ��ֵΪtrue
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // ���ô�ֱ���򱳾�����ɫ
		plot.setDomainGridlinesVisible(true); // �����Ƿ���ʾ��ֱ���򱳾���,Ĭ��ֵΪfalse

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(font); // ���ú�������
		domainAxis.setTickLabelFont(font);// ������������ֵ����
		domainAxis.setLowerMargin(0.01);// ��߾� �߿����
		domainAxis.setUpperMargin(0.06);// �ұ߾� �߿����,��ֹ���ߵ�һ�����ݿ����������ᡣ
		domainAxis.setMaximumCategoryLabelLines(2);
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(font);
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y����ʾ����
		rangeAxis.setAutoRangeMinimumSize(1); // ��С���
		rangeAxis.setUpperMargin(0.18);// �ϱ߾�,��ֹ����һ�����ݿ����������ᡣ
		rangeAxis.setLowerBound(0); // ��Сֵ��ʾ0
		rangeAxis.setAutoRange(false); // ���Զ�����Y������
		// rangeAxis.setAxisLinePaint(Color.green);
		rangeAxis.setTickMarkStroke(new BasicStroke(1.6f)); // ���������Ǵ�С
		// rangeAxis.setTickMarkPaint(Color.BLACK); // ������������ɫ
		if (maxranger > 0)
			rangeAxis.setRange(0, maxranger); // ��������ĸ߶ȷ�Χ

		// ��ȡ���߶���
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();

		// ����Series��ɫ����������ɫ)
		renderer.setSeriesPaint(0, Color.green);// �� 1
		renderer.setSeriesPaint(1, new Color(255, 0, 255));// �Һ�2
		renderer.setSeriesPaint(2, new Color(255, 255, 128));// ��ɫ3
		renderer.setSeriesPaint(3, new Color(0, 255, 255));// ��4
		renderer.setSeriesPaint(4, new Color(128, 0, 128));// ��5
		renderer.setSeriesPaint(5, new Color(0, 0, 255));// ī��6
		renderer.setSeriesPaint(6, new Color(0, 0, 128));// ��7
		renderer.setSeriesPaint(7, new Color(0, 204, 255));// ����
		renderer.setSeriesPaint(8, new Color(192, 192, 192));// ����
		renderer.setSeriesPaint(9, new Color(204, 255, 204));// ����

		renderer.setBaseOutlinePaint(Color.green);
		renderer.setDrawOutlines(true);
		BasicStroke realLine = new BasicStroke(1f); // ����ʵ��
		// ��������
		float dashes[] = { 5.0f };
		BasicStroke brokenLine = new BasicStroke(2.2f, // ������ϸ
				BasicStroke.CAP_ROUND, // �˵���
				BasicStroke.JOIN_ROUND, // �۵���
				8f, dashes, 0.6f);

		for (int i = 0; i < dataSet.getRowCount(); i++) {
			if (i % 2 == 0)
				renderer.setSeriesStroke(i, realLine); // ����ʵ�߻���
			else
				renderer.setSeriesStroke(i, brokenLine); // �������߻���
		}
		try {
			ChartUtilities.saveChartAsJPEG(new File(filename), 1, chart, width,
					height);
		} catch (IOException exz) {
			System.out.println("....Cant��t Create image File"+exz.toString());
		}
		plot.setNoDataMessage("�޶�Ӧ�����ݣ������²�ѯ��");
		plot.setNoDataMessageFont(font);// ����Ĵ�С
		plot.setNoDataMessagePaint(Color.green);// ������ɫ
	}

	public void drawBar2() {
		// create a default chart based on some sample data...
		// ����ͼ����
		String title = "X����ʾ";
		// ����ͼX����ʾ
		String domain = "Y����ʾ";
		// ����ͼY����ʾ
		String range = "����ͼ�Ա���";
		// ����ͼ�Ա���
		String subtitleStr = "2003�������";
		// ����ʱ������Դ
		// ÿһ��TimeSeries��ͼ����һ������
		TimeSeries ca = new TimeSeries("22");
		for (int i = 1999; i < 2005; i++) {
			{
				// ca.add(new Month(mon + 1, i), new Double(500 + Math.random()
				// * 100));
				// TimeSeriesDataPair��һ��ʱ������ֵ����
				ca.add(new TimeSeriesDataItem(new Day(1, 1 + 1, i), new Double(
						500 + Math.random() * 100)));
			}
		}
		TimeSeries ibm = new TimeSeries("11");
		for (int i = 1999; i < 2005; i++) {
			{
				// ibm.add(new Month(mon+1,i),new
				// Double(400-Math.random()*100));
				ibm.add(new TimeSeriesDataItem(new Day(1, 1 + 1, i),
						new Double(400 - Math.random() * 100)));
			}
		}
		TimeSeries king = new TimeSeries("44");
		for (int i = 1999; i < 2005; i++) {
			{
				// ibm.add(new Month(mon+1,i),new
				// Double(400-Math.random()*100));
				king.add(new TimeSeriesDataItem(new Day(1, 1 + 1, i),
						new Double(300 - Math.random() * 100)));
			}
		}
		// ʱ���������ݼ���
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(ca);
		dataset.addSeries(ibm);
		dataset.addSeries(king);
		// dataset.getSeries(ca);
		// dataset.getSeriesKey(ibm);
		// dataset.getSeriesKey(king);
		// dataset.addSeries(jpy);
		// dataset.addSeries(mav);
		// ʱ������Ԫ��
		JFreeChart chart = ChartFactory.createTimeSeriesChart(title, domain,
				range, dataset, true, true, false);
		// then customise it a little...
		TextTitle subtitle = new TextTitle(subtitleStr, new Font("����",
				Font.BOLD, 12));
		chart.addSubtitle(subtitle);
		chart.setTitle(new TextTitle(title, new Font("����", Font.ITALIC, 15)));
		// pie.setSeriesLabelFont(new Font("����", Font.BOLD, 15));
		chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000,
				Color.blue));
		// sysout
		// ����ļ���ָ��Ŀ¼
		String rfname = "3.jpeg";
		String fileName = "d:/" + rfname;
		try {
			// for
			// System.out.println();
			ChartUtilities.saveChartAsJPEG(new File(fileName), 1, chart, 600,
					600);
			// log.info("....Create image File:" + fileName);
		} catch (IOException exz) {
			System.out.print("....Cant��t Create image File");
		}
	}

}