package org.login;

import org.in.LibGlobal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdactinHotelMavenTask{

public static void main(String[] args) {
	
	
	WebDriver driver;
	
	
	LibGlobal bc=new LibGlobal();
	
	
	bc.getDriver();
	bc.getUrl("https://adactinhotelapp.com/index.php");
	bc.maximize();
	WebElement id = bc.findElementById("username");
	String data = bc.getData("Sheet2", 1, 0);
	bc.sendKeys(id, data);
	WebElement idusername = bc.findElementById("password");
	String data2 = bc.getData("Sheet2", 1, 1);
	bc.sendKeys(idusername, data2);
	WebElement login = bc.findElementById("login");
	bc.click(login);
	WebElement location = bc.findElementById("location");
	bc.selectByIndex(location, 5);
	WebElement submit = bc.findElementById("Submit");
	bc.click(submit);
	WebElement rb = bc.findElementById("radiobutton_4");
	bc.click(rb);
	WebElement con = bc.findElementById("continue");
	bc.click(con);
	WebElement firstname = bc.findElementById("first_name");
	String data3 = bc.getData("Sheet2", 1, 2);
	bc.sendKeys(firstname, data3);
	WebElement lastname = bc.findElementById("last_name");
	String data4 = bc.getData("Sheet2",1,3);
	bc.sendKeys(lastname, data4);
	WebElement address = bc.findElementById("address");
	String data5 = bc.getData("Sheet2", 1, 4);
	bc.sendKeys(address, data5);
	WebElement ccnum = bc.findElementById("cc_num");
	String data6 = bc.getData("Sheet2", 1, 5);
	bc.sendKeys(ccnum, data6);
	
	 WebElement cc = bc.findElementById("cc_type");
	bc.selectByIndex(cc, 2);
	WebElement month = bc.findElementById("cc_exp_month");
	bc.selectByIndex(month, 7);
	WebElement year = bc.findElementById("cc_exp_year");
	bc.selectByIndex(year, 7);
	WebElement cvv = bc.findElementById("cc_cvv");
	String data7 = bc.getData("Sheet2", 1, 6);
	bc.sendKeys(cvv, data7);
	WebElement book = bc.findElementById("book_now");
	bc.click(book);
	
	bc.implicitWait(7000);
	
	WebElement orderno = bc.findElementById("order_no");
	Object value = bc.getAttributeJs(orderno);
	System.out.println(value);
	bc.getinsertValueInCell(orderno, "Sheet2", 1, 7);	
	
}
}
