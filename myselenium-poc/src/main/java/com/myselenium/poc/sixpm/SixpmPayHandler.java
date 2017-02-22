package com.myselenium.poc.sixpm;

import org.openqa.selenium.WebDriver;

public class SixpmPayHandler {

	private static String URL = "http://www.6pm.com/";
	private static SixpmPayHandler instance = null;
	private static WebDriver driver = null;

	private SixpmPayHandler() {
	}

	public static SixpmPayHandler getInstace(WebDriver pDriver) {
		if (instance == null) {
			instance = new SixpmPayHandler();
			driver = pDriver;
		}
		return instance;
	}
	
	public void execute() {
	}

}
