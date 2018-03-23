package com.atguigu.springmvc.views;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

@Component(value="excelView")
public class ExcelView extends AbstractExcelView{


	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("生成excel表格开始");
		// Go to the first sheet.
		// getSheetAt: only if workbook is created from an existing document
		// HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFSheet sheet = workbook.createSheet("ExcelView");
		sheet.setDefaultColumnWidth(22);
//workbook.gener
		// Write a text at A1.
		HSSFCell cell = getCell(sheet, 0, 0);
		setText(cell, "Spring POI test");

		// Write the current date at A2.
		HSSFCellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		cell = getCell(sheet, 1, 0);
		cell.setCellValue(new Date());
		cell.setCellStyle(dateStyle);

		// Write a number at A3
		getCell(sheet, 2, 0).setCellValue(458);

		// Write a range of numbers.
		HSSFRow sheetRow = sheet.createRow(3);
		for (short i = 0; i < 10; i++) {
			sheetRow.createCell(i).setCellValue(i * 10);
		}
		 try{

             // 设置response参数，可以打开下载页面
             String fileName="员工表1.xls";
             fileName = URLEncoder.encode(fileName, "utf-8");
             request.setCharacterEncoding("utf-8");
             response.setCharacterEncoding("utf-8");
             response.setContentType("application/x-download");
             response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
             
             OutputStream out = response.getOutputStream();
             workbook.write(out);
             out.close();
         }catch(Exception e){
             e.printStackTrace();
         }
		 System.out.println("生成excel表格成功");
	}

}
