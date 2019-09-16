package com.org.learningmaven.Facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alllinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver= new FirefoxDriver();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.cnn.com/");
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Elements are " + links.size());
		WebElement eightlink=links.get(8);
		System.out.println(" eight link " + eightlink.getText());
		
		for(int i=0;i<links.size();i++) {
			WebElement link=links.get(i);
			System.out.println("Element of "+ i + "-- " + link.getText()+ " ---- "+ link.isDisplayed());
		}

	}

}
