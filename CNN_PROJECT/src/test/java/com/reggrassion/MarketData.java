package com.reggrassion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.ExcelRead;
import com.generic.DriverScripts;
import com.masterpagefactory.MasterPageFactory;
import com.utill.ExplictWait;
import com.utill.HighLighter;

public class MarketData {
	MasterPageFactory pf;
	WebDriver driver;
	Map<String, String> myMap;
	
	@BeforeTest

	public void setup_01() {

		driver = new DriverScripts().getdriver("URL");

		pf = PageFactory.initElements(driver, MasterPageFactory.class);
		
	}

	@Test
	public void regression_tc02() {

		System.out.println(pf.getAllpage().size());
		for (int i = 0; i < pf.getAllpage().size(); i++) {
			ExplictWait.getwait(driver, pf.getAllpage().get(i));
			HighLighter.colour(driver, pf.getAllpage().get(i));
			pf.getAllpage().get(i).click();
			//new Actions(driver).moveToElement(pf.getAllpage().get(i)).click().perform();
			System.out.println("current page title: " + driver.getTitle());
			driver.navigate().back();
		}
		
	}
	
	@Test(dependsOnMethods = { "regression_tc02" })
	public void regression_tc3() throws Throwable {

		myMap = new LinkedHashMap<>();
		new Actions(driver).moveToElement(pf.getAllpage().get(0)).click().perform();// 1
		

		for (int i = 0; i < pf.getTopname().size(); i++) {
			ExplictWait.getwait(driver, pf.getTopname().get(0));
			HighLighter.colour(driver, pf.getTopname().get(i));
			myMap.put(pf.getTopname().get(i).getAttribute("data-ticker-name"), pf.getTopname().get(i).getText());
		}
		System.out.println(myMap.toString());// whole map==> Key :: Value
//		System.out.println(myMap.keySet().toString());// keys
//		System.out.println(myMap.values().toString());// values=====> Test data
	}

	@Test(dependsOnMethods = { "regression_tc3" })
	public void regression_tc4() throws Throwable {
		 
		List<String>testDataList = new ArrayList<>();
		testDataList = ExcelRead.returnExcel("./Test Data/Test Data Financial.xlsx", "Market");
		System.out.println(testDataList.get(1));

		if (myMap.keySet().toString().trim().contains(testDataList.get(0).trim())) {

			System.out
					.println("Top section Name Validation Passed ....." + myMap.keySet() + " = " + testDataList.get(0));
//			Assert.assertEquals(myMap.keySet().toString().trim(), testDataList.get(0).trim(),
//					"Passed the name........");

		} else {

			System.out
					.println("Top section Name Validation Falied ....." + myMap.keySet() + " = " + testDataList.get(0));
			//Assert.assertEquals(myMap.keySet(), testDataList.get(0), "Failed the name........");
		}

		if (myMap.values().toString().trim().contains(testDataList.get(1).toString().trim())) {

			System.out.println(
					"Top section Value Validation Passed ....." + myMap.values() + " = " + testDataList.get(1));
//			Assert.assertEquals(myMap.values().toString().trim(), testDataList.get(1).toString().trim(),
//					"Passed the value........");
		} else {

			System.out.println(
					"Top section Value Validation Failed ....." + myMap.values() + " = " + testDataList.get(1));
//			Assert.assertEquals(myMap.values(), testDataList.get(1),"Failed the value........");
					
		}
	}
	
	@Test(dependsOnMethods = { "regression_tc4" })
	
	public void regression_tc5() {
		
	pf.getMarket().click();
	System.out.println(pf.getMostpopulerstock().size());
	for(int i=0;i<pf.getMostpopulerstock().size();i++) {
		
		HighLighter.colour(driver, pf.getMostpopulerstock().get(i));
		System.out.println(pf.getMostpopulerstock().get(i).getText());
		
		System.out.println(pf.getTimeupdate().getText());
		
	}
		
	}
@Test(dependsOnMethods = { "regression_tc5" })
public void regression_tc6() {
	
	List<String> testdata =new ArrayList<>();
	testdata = ExcelRead.returnExcel("./Test Data/Test Data Financial.xlsx", "Most Popular Stocks");
	for(int i=0;i<testdata.size();i++) {
		HighLighter.colour(driver, pf.getMostpopulerstock().get(i));
		System.out.println(testdata.get(i));
		
	
	
}

}
	
	@AfterTest
	public void teardown() {
		//driver.quit();

		// System.out.println("teardown");

	}

}
