package com.org.learningmaven.Facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver= new FirefoxDriver();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		System.out.println("Title is " + driver.getTitle());
		WebElement usrname=driver.findElement(By.id("login1"));
		System.out.println(usrname.getLocation().x);
		System.out.println(usrname.getLocation().y);
		usrname.sendKeys("selenium");
		driver.findElement(By.name("passwd")).sendKeys("selenium");
		driver.findElement(By.name("proceed")).click();
	}

}
