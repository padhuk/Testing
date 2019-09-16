package com.org.learningmaven.Facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CNN {
	
	@Test
	public void cnn_test()
	{
		FirefoxDriver driver= new FirefoxDriver();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.cnn.com/");
		System.out.println("Title is " + driver.getTitle());
		//driver.findElement(By.xpath("/html/body/div[9]/section[2]/div[2]/div/div[1]/ul/li[2]/article/div/div/h3/a/span[1]")).click();
		//driver.navigate().back();
		List<WebElement> listOfElements=driver.findElements(By.xpath("//div"));
		System.out.println("List of elements are " + listOfElements.size());
		driver.findElement(By.xpath("//*[@class='nav-menu-links']/a[1]")).click();
		List<WebElement> listOfElements1=driver.findElements(By.xpath("//div"));
		System.out.println("------------------------------------");
		System.out.println("List of elements are in US" + listOfElements1.size());
	}

}
