package com.myselenium.poc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageProperties {

	private static String URL = "http://localhost:8080/spider-order-robot-platform/";
	private static PageProperties instance = null;
	
	private PageProperties() {}
	
	public static PageProperties GetInstance(){
		if(instance == null)
			instance = new PageProperties();
		
		return instance;
	}

	private WebDriver init() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);

		return driver;
	}

	private void getPageInfo(WebDriver driver) {
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		String sourcePage = driver.getPageSource();

		System.out.println("Titulo: " + title);
		System.out.println("URL: " + currentUrl);
		System.out.println("Source page: " + sourcePage);
	}

	public void executeTest() {
		WebDriver driver = init();
		getPageInfo(driver);

		driver.close();
	}

}
