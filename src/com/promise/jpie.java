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
			Font font = new Font("宋体", Font.PLAIN, 13);
			// font.createFont(fontFormat, fontFile);
			int i = 0;
			TextTitle tt = new TextTitle(title);
			tt.setFont(font);
			chart.setTitle(tt);
			chart.setBackgroundPaint(Color.white);
			chart.setBorderVisible(false);
			PiePlot3D plot = (PiePlot3D) chart.getPlot();
			plot.setLabelGenerator(null);// 设置线

			// plot.setLabelGenerator(new
			// StandardPieSectionLabelGenerator("{2}"));//设置图片显示线数据,小手
			// plot.setSectionLabelType(section, paint)
			// plot.setExplodePercent(data.getKey(1),0.80);
			plot.setForegroundAlpha(0.2F);// 设置透明
			// plot.setParent(parent);

			plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}({1};{2})"));
			plot.setDepthFactor(0.05D);// 厚度
			// com.lowagie.text.Font bfChinese =
			// com.lowagie.text.pdf.BaseFont.createFont("STSongStd-Light",
			// "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			plot.setBackgroundPaint(Color.WHITE);// 饼图底色
			// plot.setBaseSectionPaint(Color.WHITE);
			plot.setLabelFont(new Font("宋体", Font.PLAIN, 8));// 图上为中文
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
			chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 14));
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
			java.awt.Font font = new Font("宋体", Font.PLAIN, 15);
			TextTitle tt = new TextTitle(title);
			tt.setFont(font);
			chart.setTitle(tt);

			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			// plot.setForegroundAlpha(0.9f); //透明度

			// plot.setLabelFont(new Font("宋体",Font.PLAIN,15));//图上为中文
			// 竖直坐标参数设置
			System.out.println(plot.getDomainAxisCount());
			ValueAxis rangeAxis = plot.getRangeAxis();
			rangeAxis.setUpperMargin(0.15); // 设置最高的一个柱与图片顶端的距离
			rangeAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14)); // 竖标题字体
			rangeAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 12)); // 竖数值字体
			rangeAxis.setLabelAngle(90);
			if (maxranger > 0)
				rangeAxis.setRange(0, maxranger); // 设置柱体的高度范围

			plot.setRangeAxis(rangeAxis);

			// 横坐标参数设置
			// CategoryAxis domainAxis=plot.getDomainAxis();
			CategoryAxis domainAxis = plot.getDomainAxis(0);
			domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14)); // 横标题字体
			domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 13)); // 横数值字体
			// domainAxis.setMaximumCategoryLabelWidthRatio(1.2f); //每个项目说明文字的间隔
			domainAxis.setMaximumCategoryLabelLines(10); // 横数值最多显示行数
			domainAxis.setCategoryMargin(0.15); // 项目间距
			domainAxis.setUpperMargin(0.03); // 左边与纵坐标距离
			domainAxis.setLowerMargin(0.03); // 右边与图边框距离

			plot.setDomainAxis(domainAxis);

			// 设置柱体颜色
			BarRenderer renderer = new BarRenderer();
			renderer.setSeriesPaint(4, new Color(255, 85, 76), true);
			renderer.setSeriesPaint(3, new Color(228, 94, 230));
			renderer.setSeriesPaint(2, new Color(255, 254, 77));
			renderer.setSeriesPaint(1, new Color(82, 84, 254));
			renderer.setSeriesPaint(0, new Color(83, 254, 84));
			// LayeredBarRenderer
			// 设置每个柱体之间距离
			renderer.setItemMargin(0.0);

			// 显示每个柱的数值，并修改该数值的字体属性
			// renderer.setBaseItemLabelFont(new Font("宋体",Font.PLAIN,10));

			renderer.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 10));
			renderer
					.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setBaseItemLabelFont(new Font("宋体", Font.PLAIN, 10));
			renderer.setBaseItemLabelsVisible(true);

			renderer.setBaseLegendTextFont(new Font("宋体", Font.PLAIN, 10));// 设置列名

			plot.setRenderer(renderer);
			// 设置透明度
			// plot.setForegroundAlpha(0.6f);
			plot.setBackgroundPaint(Color.WHITE);
			ChartUtilities.saveChartAsJPEG(new File(filename), 1, chart, width,
					height);
			// 清除
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
		String title = "jump统计";
		// Font font = new Font("SimSun", 10, 20);
		jpie p = new jpie();
		DefaultPieDataset piedata = new DefaultPieDataset();

		piedata.setValue("比较安全", 200);
		piedata.setValue("比较安全1", 200);
		piedata.setValue("比较危险1", 200);
		piedata.setValue("比较危险", 200);

		p.draw3DPie("C:\\PieChart1.jpg", piedata, title, 300, 200);
		p.draw3DPie("C:\\PieChart21.jpg", piedata, title, 300, 300);
		DefaultCategoryDataset ipdata = new DefaultCategoryDataset();
		ipdata.setValue(1, "a1", "标题标题标题标题标题标题");
		ipdata.setValue(2, "b2", "楷体楷体楷体楷体楷体楷体 ");
		ipdata.setValue(3, "c2", "黑体黑体黑体黑体黑体黑体黑体");
		ipdata.setValue(4, "d2", "宋体宋体宋体宋体宋体宋体宋体宋体");
		ipdata.setValue(3, "e2", "时体时体时体时体时体时体时体时体");
		ipdata.setValue(4, "f2", "只体只体只体只体只体只体只体只体");
		p.drawBar("C:\\bar.jpg", ipdata, "最危险的IP", "IP地址", "漏洞数", 692, 220, 0);

	}

	public boolean drawBare(String filename, DefaultCategoryDataset data,
			String title, String rowstr, String colstr, int width, int height,
			double maxranger) {
		try {

			JFreeChart chart = ChartFactory.createBarChart(title, rowstr,
					colstr, data, PlotOrientation.VERTICAL, true, true, false);

			chart.setBackgroundPaint(Color.white);
			java.awt.Font font = new Font("宋体", Font.PLAIN, 15);
			TextTitle tt = new TextTitle(title);
			tt.setFont(font);
			chart.setTitle(tt);

			CategoryPlot plot = (CategoryPlot) chart.getPlot();
			// plot.setForegroundAlpha(0.9f); //透明度

			// 竖直坐标参数设置
			ValueAxis rangeAxis = plot.getRangeAxis();
			rangeAxis.setUpperMargin(0.15); // 设置最高的一个柱与图片顶端的距离
			rangeAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14)); // 竖标题字体
			rangeAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 12)); // 竖数值字体
			if (maxranger > 0)
				rangeAxis.setRange(0, maxranger); // 设置柱体的高度范围
			plot.setRangeAxis(rangeAxis);

			// 横坐标参数设置
			CategoryAxis domainAxis = plot.getDomainAxis();
			domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14)); // 横标题字体
			domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 13)); // 横数值字体
			domainAxis.setMaximumCategoryLabelWidthRatio(1.3f); // 每个项目说明文字的间隔
			domainAxis.setMaximumCategoryLabelLines(2); // 横数值最多显示行数
			// domainAxis.setCategoryMargin(0.15); //项目间距
			domainAxis.setUpperMargin(0.03); // 左边与纵坐标距离
			domainAxis.setLowerMargin(0.03); // 右边与图边框距离
			plot.setDomainAxis(domainAxis);

			// 设置柱体颜色
			BarRenderer renderer = new BarRenderer();
			renderer.setSeriesPaint(0, new Color(255, 85, 82));
			renderer.setSeriesPaint(1, new Color(255, 85, 255));
			renderer.setSeriesPaint(2, new Color(255, 255, 82));
			renderer.setSeriesPaint(3, new Color(82, 85, 255));
			renderer.setSeriesPaint(4, new Color(82, 255, 82));
			// 设置每个柱体之间距离
			renderer.setItemMargin(0.0);
			// 显示每个柱的数值，并修改该数值的字体属性
			renderer
					.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 10));
			renderer.setItemLabelsVisible(true);
			plot.setRenderer(renderer);
			plot.setForegroundAlpha(0.6f);
			plot.setBackgroundPaint(Color.WHITE);
			ChartUtilities.saveChartAsJPEG(new File(filename), (float) 0.9,
					chart, width, height);
			// ChartUtilities.saveChartAsJPEG(new
			// File(filename),2,chart,width,height);
			// 清除
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
		java.awt.Font font = new Font("宋体", Font.PLAIN, 10);
		String sql = "select count(id) num, DATE_FORMAT(calltime, '%Y年%m月') ym,modulename mn from  tongji t group by DATE_FORMAT(calltime, '%Y年%m月'),mn";
		// List list = getList(sql);
		// 绘图数据集
		// DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		// for (Object obj : list) {
		// Map<String, Object> map = (Map) obj;
		// dataSet.setValue((Long) map.get("num"), (String) map.get("mn"),
		// map.get("ym").toString());
		// }

		// 206,207,255
		// 如果把createLineChart改为createLineChart3D就变为了3D效果的折线图
		
		JFreeChart chart = ChartFactory.createLineChart(title, rowstr, colstr,
				dataSet, PlotOrientation.VERTICAL, // 绘制方向
				true, // 显示图例  linux系统不可是TRUE
				true, // 采用标准生成器
				false // 是否生成超链接
				);
		chart.getTitle().setFont(font); // 设置标题字体
		chart.getLegend().setItemFont(font);// 设置图例类别字体
		chart.setBorderPaint(Color.green);
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.WHITE); // 设置绘图区背景色
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // 设置水平方向背景线颜色
		plot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY); // 设置垂直方向背景线颜色
		plot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(font); // 设置横轴字体
		domainAxis.setTickLabelFont(font);// 设置坐标轴标尺值字体
		domainAxis.setLowerMargin(0.01);// 左边距 边框距离
		domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
		domainAxis.setMaximumCategoryLabelLines(2);
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(font);
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y轴显示整数
		rangeAxis.setAutoRangeMinimumSize(1); // 最小跨度
		rangeAxis.setUpperMargin(0.18);// 上边距,防止最大的一个数据靠近了坐标轴。
		rangeAxis.setLowerBound(0); // 最小值显示0
		rangeAxis.setAutoRange(false); // 不自动分配Y轴数据
		// rangeAxis.setAxisLinePaint(Color.green);
		rangeAxis.setTickMarkStroke(new BasicStroke(1.6f)); // 设置坐标标记大小
		// rangeAxis.setTickMarkPaint(Color.BLACK); // 设置坐标标记颜色
		if (maxranger > 0)
			rangeAxis.setRange(0, maxranger); // 设置柱体的高度范围

		// 获取折线对象
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();

		// 设置Series颜色（线条的颜色)
		renderer.setSeriesPaint(0, Color.green);// 蓝 1
		renderer.setSeriesPaint(1, new Color(255, 0, 255));// 桃红2
		renderer.setSeriesPaint(2, new Color(255, 255, 128));// 黄色3
		renderer.setSeriesPaint(3, new Color(0, 255, 255));// 蓝4
		renderer.setSeriesPaint(4, new Color(128, 0, 128));// 紫5
		renderer.setSeriesPaint(5, new Color(0, 0, 255));// 墨绿6
		renderer.setSeriesPaint(6, new Color(0, 0, 128));// 蓝7
		renderer.setSeriesPaint(7, new Color(0, 204, 255));// 草绿
		renderer.setSeriesPaint(8, new Color(192, 192, 192));// 天蓝
		renderer.setSeriesPaint(9, new Color(204, 255, 204));// 天蓝

		renderer.setBaseOutlinePaint(Color.green);
		renderer.setDrawOutlines(true);
		BasicStroke realLine = new BasicStroke(1f); // 设置实线
		// 设置虚线
		float dashes[] = { 5.0f };
		BasicStroke brokenLine = new BasicStroke(2.2f, // 线条粗细
				BasicStroke.CAP_ROUND, // 端点风格
				BasicStroke.JOIN_ROUND, // 折点风格
				8f, dashes, 0.6f);

		for (int i = 0; i < dataSet.getRowCount(); i++) {
			if (i % 2 == 0)
				renderer.setSeriesStroke(i, realLine); // 利用实线绘制
			else
				renderer.setSeriesStroke(i, brokenLine); // 利用虚线绘制
		}
		try {
			ChartUtilities.saveChartAsJPEG(new File(filename), 1, chart, width,
					height);
		} catch (IOException exz) {
			System.out.println("....Cant’t Create image File"+exz.toString());
		}
		plot.setNoDataMessage("无对应的数据，请重新查询。");
		plot.setNoDataMessageFont(font);// 字体的大小
		plot.setNoDataMessagePaint(Color.green);// 字体颜色
	}

	public void drawBar2() {
		// create a default chart based on some sample data...
		// 曲线图标题
		String title = "X轴提示";
		// 曲线图X轴提示
		String domain = "Y轴提示";
		// 曲线图Y轴提示
		String range = "曲线图自标题";
		// 曲线图自标题
		String subtitleStr = "2003财年分析";
		// 创建时间数据源
		// 每一个TimeSeries在图上是一条曲线
		TimeSeries ca = new TimeSeries("22");
		for (int i = 1999; i < 2005; i++) {
			{
				// ca.add(new Month(mon + 1, i), new Double(500 + Math.random()
				// * 100));
				// TimeSeriesDataPair是一个时间点的数值体现
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
		// 时间曲线数据集合
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(ca);
		dataset.addSeries(ibm);
		dataset.addSeries(king);
		// dataset.getSeries(ca);
		// dataset.getSeriesKey(ibm);
		// dataset.getSeriesKey(king);
		// dataset.addSeries(jpy);
		// dataset.addSeries(mav);
		// 时间曲线元素
		JFreeChart chart = ChartFactory.createTimeSeriesChart(title, domain,
				range, dataset, true, true, false);
		// then customise it a little...
		TextTitle subtitle = new TextTitle(subtitleStr, new Font("黑体",
				Font.BOLD, 12));
		chart.addSubtitle(subtitle);
		chart.setTitle(new TextTitle(title, new Font("隶书", Font.ITALIC, 15)));
		// pie.setSeriesLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000,
				Color.blue));
		// sysout
		// 输出文件到指定目录
		String rfname = "3.jpeg";
		String fileName = "d:/" + rfname;
		try {
			// for
			// System.out.println();
			ChartUtilities.saveChartAsJPEG(new File(fileName), 1, chart, 600,
					600);
			// log.info("....Create image File:" + fileName);
		} catch (IOException exz) {
			System.out.print("....Cant’t Create image File");
		}
	}

}