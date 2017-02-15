package com.myselenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GUIElementsTest {

	private static GUIElementsTest element;

	private GUIElementsTest() {
	}

	public static GUIElementsTest GetInstance() {
		if (element == null)
			element = new GUIElementsTest();
		return element;
	}

	public void GetElementById() {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/spider-order-robot-platform/";
		String tagName = "";

		driver.get(baseUrl);
		tagName = driver.findElement(By.id("uName")).getTagName();
		System.out.println(tagName);
		driver.close();
	}

	public void GetElementByTagName() {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/spider-order-robot-platform/";
		
		
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.tagName("div"));
		System.out.println(element.toString());
		driver.close();
	}

}
