package com.myselenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GUIElementsTest {

	private static String URL = "http://localhost:8080/spider-order-robot-platform/";
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
		String tagName = "";

		driver.get(URL);
		tagName = driver.findElement(By.id("uName")).getTagName();
		System.out.println(tagName);
		driver.close();
	}

	public void GetElementByTagName() {
		WebDriver driver = new FirefoxDriver();

		driver.get(URL);
		WebElement element = driver.findElement(By.tagName("div"));
		System.out.println("ToString - " + element.toString());
		System.out.println("Text - " + element.getText());
		driver.close();
	}

	public void GetElementByCssSelector() {
		WebDriver driver = new FirefoxDriver();

		driver.get(URL);
		WebElement element = driver.findElement(By.cssSelector("input[value=登录]"));
		System.out.println("Color: " + element.getCssValue("color"));
		driver.close();
	}

	// ??
	public void GetElementByLinkText() {
		WebDriver driver = new FirefoxDriver();

		driver.get(URL);
		WebElement element = driver.findElement(By.linkText("ispider")); // ??
		System.out.println(element.toString());
		driver.close();
	}

	public void GetElementByName() {
		WebDriver driver = new FirefoxDriver();

		driver.get(URL);
		WebElement element = driver.findElement(By.name("userName"));
		System.out.println("Elemento con nombre username tiene el tag : " + element.getTagName());
		driver.close();
	}

}
