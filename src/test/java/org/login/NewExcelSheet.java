package org.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewExcelSheet {

	public static void main(String[] args) throws Exception {

	
	File file=new File("E:\\Eclipse java\\FrameworkClass\\excel\\NewSheet.xlsx");
	 Workbook workbook =new XSSFWorkbook();
	 Sheet sheet=workbook.createSheet();
	 Row createRow = sheet.createRow(9);
	 Cell cell = createRow.createCell(0);
	
	cell.setCellValue("Ezhil");
	
	FileOutputStream out=new FileOutputStream(file);
	
	workbook.write(out);
	
	
	}

}
