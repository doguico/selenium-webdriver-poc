package com.myselenium.poc.sixpm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Execute {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		SixpmLoginHandler.getInstace(driver).execute();
		SixpmCleanCartHandler.getInstace(driver).execute();
	}
}
