package com.Actitime.Testscript;

import org.testng.annotations.Test;

import com.Actitime.GenricLibrary.Baseclass;
import com.Actitime.GenricLibrary.FileLibrary;
import com.Actitime.Pom.HomePage;
import com.Actitime.Pom.TaskPage;

public class CreateCustomer extends Baseclass{

	@Test 
	public void create() {
		
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();
		TaskPage tp = new TaskPage(driver);
		tp.getAddnew().click();
		tp.getNewcustomer().click();
		FileLibrary f= new FileLibrary();
		String custname = f.readDataFromExcel("CustomerDetails",2,2);
		tp.getCustname().sendKeys(custname);
		String custdesp() =f.readDataFromExcel("CustomerDetails", 2, 1);
		tp.getCustdesp().sendKeys(custdesp);
		tp.getCreatbtn().click();
		}
	
}
