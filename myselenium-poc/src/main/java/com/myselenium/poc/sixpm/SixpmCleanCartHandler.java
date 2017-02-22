package com.myselenium.poc.sixpm;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SixpmCleanCartHandler {

	private static String URL = "https://secure-www.6pm.com/cart";
	private static SixpmCleanCartHandler instance = null;
	private static WebDriver driver = null;

	private SixpmCleanCartHandler() {
	}

	public static SixpmCleanCartHandler getInstace(WebDriver pDriver) {
		if (instance == null) {
			instance = new SixpmCleanCartHandler();
			driver = pDriver;
		}

		return instance;
	}

	public void execute() {
		System.out.println("Execute: borrar items del carrito");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(URL);

		System.out.println("Se esperaran 5 segundos");

		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#cart .item .qty .moveFromCart .remove")));
		
		System.out.println("FIn de la espera");
		
		String amount = js
				.executeScript("return document.querySelectorAll('#cart .item .qty .moveFromCart .remove')").toString();

		int a = Integer.parseInt(amount);
		System.out.println("Cantidad inicial: " + amount);

		while (a != 0) {
			js.executeScript(
					"Array.prototype.forEach.call(document.querySelectorAll('#cart .item .qty .moveFromCart .remove'), function (item) {item.click();});");
			amount = js
					.executeScript("return document.querySelectorAll('#cart .item .qty .moveFromCart .remove')").toString();
			System.out.println("Ahora hay: " + amount);
			a = Integer.parseInt(amount);
		}

		System.out.println("Se limpio el carrito con exito: " + test());
	}

	public Boolean test() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(URL);

		String amount = js
				.executeScript("return document.querySelectorAll('#cart .item .qty .moveFromCart .remove')").toString();

		int a = Integer.parseInt(amount);
		
		return a == 0;
	}

}
