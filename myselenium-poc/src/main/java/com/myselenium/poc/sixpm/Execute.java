package com.myselenium.poc.sixpm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Execute {
	public static void main(String[] args) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.socks", "127.0.0.1");
		profile.setPreference("network.proxy.socks_port", 1080);

		WebDriver driver = new FirefoxDriver(profile);
		Prueba.Execute(driver);

		// SixpmLoginHandler.getInstace(driver).execute();
		// SixpmCleanCartHandler.getInstace(driver).execute();
		// driver.get("https://secure-www.6pm.com/cart");
		// SixpmPayHandler.getInstace(driver).execute();
	}
}
