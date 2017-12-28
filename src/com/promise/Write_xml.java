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
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.lowagie.text.Anchor; /*      */
import com.lowagie.text.Cell; /*      */
import com.lowagie.text.Chapter; /*      */
import com.lowagie.text.Document; /*      */
import com.lowagie.text.DocumentException; /*      */
import com.lowagie.text.Font; /*      */
import com.lowagie.text.Image; /*      */
import com.lowagie.text.PageSize; /*      */
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section; /*      */
import com.lowagie.text.Table; /*      */
import com.lowagie.text.pdf.BaseFont; /*      */
import com.lowagie.text.pdf.PdfPCell; /*      */
import com.lowagie.text.pdf.PdfPTable; /*      */
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.*;
import org.jfree.*;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*      */import java.io.BufferedReader; /*      */
import java.io.File; /*      */
import java.io.FileInputStream; /*      */
import java.io.FileNotFoundException; /*      */
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter; /*      */
import java.io.IOException;
import java.io.InputStream; /*      */
import java.io.InputStreamReader;
import java.io.OutputStream; /*      */
import java.io.OutputStreamWriter; /*      */
import java.io.PrintStream; /*      */
import java.sql.Connection; /*      */
import java.sql.Driver; /*      */
import java.sql.DriverManager; /*      */
import java.sql.ResultSet;
import java.sql.SQLException; /*      */
import java.sql.Statement; /*      */
import java.util.ArrayList; /*      */
import java.util.Date;
import java.util.Hashtable;

/*      */import javax.servlet.ServletContext; /*      */
import javax.servlet.jsp.JspWriter; /*      */
import org.jfree.data.category.DefaultCategoryDataset; /*      */
import org.jfree.data.general.DefaultPieDataset;

/*      */import com.lowagie.text.Anchor; /*      */
import com.lowagie.text.Cell; /*      */
import com.lowagie.text.Chapter; /*      */
import com.lowagie.text.Document; /*      */
import com.lowagie.text.DocumentException; /*      */
import com.lowagie.text.Font;

/*      */import com.lowagie.text.Image; /*      */
import com.lowagie.text.PageSize; /*      */
import com.lowagie.text.Paragraph; /*      */
import com.lowagie.text.Table; /*      */
import com.lowagie.text.pdf.BaseFont; /*      */
import com.lowagie.text.pdf.PdfPCell; /*      */
import com.lowagie.text.pdf.PdfPTable; /*      */
import com.lowagie.text.pdf.PdfWriter; /*      */
import java.awt.Color; /*      */
import java.io.BufferedReader; /*      */
import java.io.File; /*      */
import java.io.FileOutputStream; /*      */
import java.io.IOException; /*      */
import java.io.InputStreamReader; /*      */
import java.io.PrintStream; /*      */
import java.sql.Connection; /*      */
import java.sql.Driver; /*      */
import java.sql.DriverManager; /*      */
import java.sql.ResultSet; /*      */
import java.sql.Statement; /*      */
import javax.servlet.ServletContext; /*      */
import javax.servlet.jsp.JspWriter; /*      */
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.io.*;
import java.net.MalformedURLException;

import com.lowagie.text.rtf.*;

import com.lowagie.text.Chapter;
import com.lowagie.text.Image;
import com.lowagie.text.Section;

public class Write_xml {
	String filepath = "e:\\report\\";
	String imgpath = "e:\\report\\img\\";
	String MDRIVER =   "org.gjt.mm.mysql.Driver";
	String MUSERNAME =   "root";
	String MPASSWORD =   "jump-1-ips";
	String MSTRING =   "jdbc:mysql://10.0.13.120:3306/nvas";
	String sql = null;
	Connection Con = null;
	boolean isL = true;


	public int get_table_data(String Table, String wsql, FileWriter write_report)
			throws SQLException, IOException {
		Hashtable hash = new Hashtable();
		Statement stmt = Con.createStatement();
		ResultSet rs = null;
		int field_count = 0, i = 0;
		String qq = "";
		// 获取字段
		sql = "show FIELDS from " + Table;
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			hash.put(field_count++, rs.getString("Field"));
		}
		rs.close();
		// 获取内容
		sql = "select * from " + Table + "  " + wsql;
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			write_report.write("  <" + Table + ">\r\n");
			for (i = 0; i < field_count; i++) {
				qq = rs.getString(hash.get(i).toString());
				if (qq != null)
					qq = repstr(qq);
				write_report.write("<" + hash.get(i) + ">" + qq + "</"
						+ hash.get(i) + ">\r\n");
			}
			write_report.write("  </" + Table + ">\r\n\r\n");

		}
		rs.close();

		return field_count;
	}

	public String repstr(String str) {
		if (str == null||str.isEmpty())
			return "";
		String strp = str;
		strp = strp.replaceAll("<", "&#60;");
		strp = strp.replaceAll(">", "&#62;");
		strp = strp.replaceAll("\"", "&#34;");
		strp = strp.replaceAll("'", "&#39;");
		strp = strp.replaceAll("&", "  ");
		return strp;
	}
}
