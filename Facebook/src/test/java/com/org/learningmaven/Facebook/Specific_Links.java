package com.org.learningmaven.Facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Specific_Links {

	public static void main(String[] args) {
		FirefoxDriver driver= new FirefoxDriver();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.cnn.com/");
		WebElement box=driver.findElement(By.xpath("//*[@id='homepage1-zone-1']/div[2]/div/div[3]"));
		List<WebElement> links=box.findElements(By.tagName("a"));
		System.out.println("List of elements in Top story is" + links.size());
		
		for(int i=0;i<links.size();i++) {
			WebElement link=links.get(i);
			System.out.println("Element of "+ i + "-- " + link.getText()+ " ---- "+ link.isDisplayed());
		}
		
	}

}
