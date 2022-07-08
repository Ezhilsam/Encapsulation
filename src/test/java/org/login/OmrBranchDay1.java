package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OmrBranchDay1 {
	
	public static void main(String[] args) throws IOException {
 
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver =new ChromeDriver();
//		driver.get("https://omrbranch.com/");
//		driver.manage().window().maximize();
			//mention path of excel
			File file=new File("E:\\Eclipse java\\FrameworkClass\\excel\\Dummyexcel.xlsx");;
		//get object from file		
		FileInputStream stream=new FileInputStream(file);
		//create workbook
   Workbook workbook =new XSSFWorkbook(stream);
		
		//get the sheet
  		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("TaskSheet");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row eachrow = sheet.getRow(i);
			for (int j = 0; j < eachrow.getPhysicalNumberOfCells(); j++) {
				Cell cell = eachrow.getCell(j);
//			
//			System.out.println(cell);
				
				//day2
				
				//cell type string--->text,numeric(numbers)
      CellType type =cell.getCellType();
      
      switch(type) {
      case STRING:
    	  
    	  String name = cell.getStringCellValue();
       System.out.println(name);
      break;
      case NUMERIC:
    	  if(DateUtil.isCellDateFormatted(cell)) {
    		 Date dateCellValue = cell.getDateCellValue();
    		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy");
    		String date = simpleDateFormat.format(dateCellValue);
    		System.out.println(date);
    		  }
    	  else {
    		  double d = cell.getNumericCellValue();
    		   BigDecimal b = BigDecimal.valueOf(d);
    		  String s = b.toString();
    		  System.out.println(s);
    	  }
     break;
    }
			}
		}
	}
}		
	
	

 