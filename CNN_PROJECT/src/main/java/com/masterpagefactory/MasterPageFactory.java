package com.masterpagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterPageFactory {
	
	@FindBy(xpath="(//*[@class='sc-htoDjs dpodOf'])[1]//li")
	private List<WebElement> allpage;

	public List<WebElement> getAllpage() {
		return allpage;
	}
	@FindBy(xpath="(//*[text()='Markets'])[1]")
	private WebElement market;

	public WebElement getMarket() {
		return market;
	}
	@FindBy(xpath="//*[@class='ticker-name-change']")
	private List<WebElement> Topname;

	public List<WebElement> getTopname() {
		return Topname;
	}
	
	@FindBy(xpath="//*[@class='stock']")
	private List<WebElement> mostpopulerstock;

	public List<WebElement> getMostpopulerstock() {
		return mostpopulerstock;
	}
	@FindBy(xpath="(//*[@class='disclaimer'])[2]")
	private WebElement timeupdate;

	public WebElement getTimeupdate() {
		return timeupdate;
	}
	
	
	
	
}