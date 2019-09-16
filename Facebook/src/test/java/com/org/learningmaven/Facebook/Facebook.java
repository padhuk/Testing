package com.org.learningmaven.Facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Facebook {
	
	
	@Test
	public void Dologin()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
			
		WebDriver driver= new ChromeDriver(options);
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
				
				//prefs = {"profile.default_content_setting_values.notifications" : 2}
				//chrome_options.add_experimental_option("prefs",prefs)
				//driver = webdriver.Chrome(chrome_options=chrome_options)
		//List<WebElement> listOfElements=driver.findElements(By.xpath("//div"));
		//System.out.println("List of elements are"+listOfElements.size());
		
		driver.findElement(By.name("email")).sendKeys("padmaja.kalapala@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Facebook@123");
		driver.findElement(By.name("pass")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id='userNavigationLabel']"));
		
		/*WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		
		al.accept();*/
		
		driver.findElement(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).click();
		driver.findElement(By.xpath("//a[@data-tab-key='friends']")).click();
		//*[@id="u_fetchstream_9_1i"]/span/input
		WebElement search= driver.findElement(By.xpath("//input[@placeholder='Search for your friends']"));
		search.sendKeys("Ravi");
		search.click();
		driver.findElement(By.xpath("//*[@id=\'u_0_c\']/a")).click();
		//driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		//	driver.quit();
//		driver.findElement(By.xpath("//*[class='uiScrollableAreaContent']/ul/li[12]/a/span/span")).click();		
	}
	
	
	
}


