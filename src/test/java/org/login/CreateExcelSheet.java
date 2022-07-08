package org.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateExcelSheet {

	public static void main(String[] args) throws IOException {
     WebDriverManager.chromedriver().setup();
     WebDriver driver =new ChromeDriver();
     driver.get("http://demo.automationtesting.in/Register.html");
      driver.manage().window().maximize();
       WebElement txt = driver.findElement(By.id("Skills"));
       txt.click();
       Select s=new Select(txt);
       List<WebElement> option=s.getOptions();
      
      File file=new File("E:\\Eclipse java\\FrameworkClass\\excel\\Day1excel.xlsx");
      
	Workbook workbook=new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("NewSheet");
	
	 for (int i = 0; i < option.size(); i++) {
		 
		 WebElement webElement = option.get(i);
		
		 String text = webElement.getText();
	  System.out.println(text);
	   
	  
	  Row createRow = sheet.createRow(i);
	  
	    Cell createCell = createRow.createCell(0);	  
	 
	 createCell.setCellValue(text);
	 
	 
	 }
	 
	 FileOutputStream output =new FileOutputStream(file);
	workbook.write(output);
	
	
	
	 driver.quit();
	
	
	}

}
