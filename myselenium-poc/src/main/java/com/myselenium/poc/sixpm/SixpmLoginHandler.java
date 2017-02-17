package com.myselenium.poc.sixpm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SixpmLoginHandler {

	private static String URL = "http://www.6pm.com/";
	private static SixpmLoginHandler instance = null;
	private static WebDriver driver = null;

	private SixpmLoginHandler() {
	}

	public static SixpmLoginHandler getInstace(WebDriver pDriver) {
		if (instance == null) {
			instance = new SixpmLoginHandler();
			driver = pDriver;
		}
		return instance;
	}

	public void execute() {
		System.out.println("Se entra en execute");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(URL);
		System.out.println("Se cargo la pagina:" + URL);
		String link = js
				.executeScript(
						"return document.getElementsByClassName('gae-click*Global*Header*Log-In-or-Register')[0].href")
				.toString();
		System.out.println("Link de la pagina de logueo: " + link);
		driver.get(link);
		System.out.println("Se cargo la pagina:" + link);
		driver.findElement(By.id("ap_email")).sendKeys("guido.corazza@outlook.com");
		driver.findElement(By.id("ap_password")).sendKeys("6pmLluvia92");
		driver.findElement(By.id("signInSubmit-input")).click();

		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.herospecialContainer")));

		System.out.println("Se logueo con exito :" + test());
	}

	public Boolean test() {
		System.out.println("Se entra al test del logueo");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Se buscara el href para corroborrar el logout");
		WebElement link = (WebElement) js
				.executeScript("return document.getElementsByClassName('gae-click*Global*Header*Logout')[0].href");
		System.out.println("Link para corroborrar que se logueo a la pagina con exito: " + link.getAttribute("href"));
		return link != null && link.getAttribute("href").indexOf("logout") != -1;
	}
}
