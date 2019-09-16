package com.org.learningmaven.Facebook;

import org.testng.annotations.Test;

import com.org.learningmaven.ReuseTest.BaseLogin;

public class TestA extends BaseLogin{
	
	
	
	@Test
	public void testA1() {
		
		openbrowser("Chrome");
		urll("appurl");
		
		if(!verifyText("signintext_Xpath","signintext"))
			reportFailure("text did not match");
		
		if(!isElementPresent("email_id"))
			reportFailure("Email field not present");//critical
			
		login("email_xpath","padmaja.k85@gmail.com");
		//pwd("//*[@id='Next']");
		//logoff();
		
	}
	/*
	@Test(priority=2,dependsOnMethods={"testA1"})
	public void testA2() {
		
	}
	@Test(priority=3,dependsOnMethods= {"testA1"})
	public void testA3() {
		
	}
	
	@Test(priority=4,dependsOnMethods= {"testA2","testA3"})
	public void testA4() {
		
	}
	*/

}
