package com.crm.Vtiger.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtility {
	public void maximizeBrowser(WebDriver d) {
		d.manage().window().maximize();
	}
	public void implcitlyWait(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void navToApp(WebDriver d,String url) {
		d.get(url);
	}
	public void CloseBrowser(WebDriver d) {
		d.quit();
	}
	public void selectOptionUsingIndex(WebElement address,int index) {
		Select s=new Select(address);
		s.selectByIndex(index);
	}
	public void selectOptionUsingValue(WebElement address, String value) {
		Select s=new Select(address);
		s.selectByValue(value);
	}
	public void selectOptionUsingVisibleText(WebElement address,String text) {
		Select s=new Select(address);
		s.selectByVisibleText(text);
	}
	public void selectOptionUsingContainsText(WebElement address,String containsText) {
		Select s=new Select(address);
		s.selectByContainsVisibleText(containsText);
	}
}
