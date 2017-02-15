package com.myselenium.poc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleExample {

	public static void ExecuteTest() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		String baseUrl = "http://localhost:8080/spider-order-robot-platform/";
		String expectedTitle = "登录";
		String actualTitle = "";

		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();

		/*
		 * compare the actual title of the page witht the expected one and print
		 * the result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// close Firefox
		driver.close();
	}
}
