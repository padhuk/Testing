package com.org.learningmaven.Facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rediff_Explicit {

	public static void main(String[] args) {
		FirefoxDriver driver= new FirefoxDriver();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.id("login1")).sendKeys("selenium");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login1"))));
		
		String text=driver.findElement(By.id("login1")).getText();
		System.out.println("text of the element is " + text);
		
		text=driver.findElement(By.xpath("//*[@id='login1']")).getAttribute("value");
		System.out.println("value for login is" + text);
		
		text=driver.findElement(By.xpath("//*[@id='login1']")).getAttribute("maxlength");
		System.out.println("maxlength for login is" + text);
		
		
		text=driver.findElement(By.xpath("//*[@id='remember']")).getAttribute("checked");
		System.out.println("Check box is checked or not ---- " + text);
	}

}
