package com.myselenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InteractingExample {

	private static InteractingExample element;

	private InteractingExample() {
	}

	public static InteractingExample GetInstance() {
		if (element == null)
			element = new InteractingExample();
		return element;
	}

	public void Login(String pUrl) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get(pUrl);
		WebElement button = driver.findElement(By.id("button"));
		WebElement user = driver.findElement(By.id("uName"));
		user.sendKeys("admin");
		WebElement pass = driver.findElement(By.id("pwd"));
		pass.sendKeys("admin123");
		button.click();
		driver.close();
	}	
}
