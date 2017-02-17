package com.myselenium.poc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class InteractingExample {

	private static String URL = "http://localhost:8080/spider-order-robot-platform/";
	private static InteractingExample element;

	private InteractingExample() {
	}

	public static InteractingExample GetInstance() {
		if (element == null)
			element = new InteractingExample();
		return element;
	}

	private WebDriver init() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);

		return driver;
	}

	private void login(WebDriver driver) {
		WebElement button = driver.findElement(By.id("button"));
		WebElement user = driver.findElement(By.id("uName"));
		user.sendKeys("admin");
		WebElement pass = driver.findElement(By.id("pwd"));
		pass.sendKeys("admin123");
		button.click();
	}
	
	private void loginWithActions(WebDriver driver) {
		WebElement user = driver.findElement(By.id("uName"));		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(user).click().sendKeys(user, "admin").sendKeys(Keys.TAB)
				.sendKeys("admin123").sendKeys(Keys.ENTER).build();
		seriesOfActions.perform();
	}

	private void close(WebDriver driver) {
		driver.close();
	}

	public void addAgentToHostManual(WebDriver driver) {
		Boolean seBorro;
		String msg;

		WebElement hostMgr = driver.findElement(By.id("hostMgr"));
		hostMgr.click();

		WebElement myButton = driver.findElement(By.xpath("//table/tbody/tr[3]/td[8]"));
		System.out.println("Texto del boton: " + myButton.getText());
		myButton.click();

		WebElement checkbox = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/input"));
		seBorro = checkbox.isSelected();
		msg = checkbox.isSelected() ? "Esta seleccionado, se borrara" : "No esta seleccionado, se agregara";
		System.out.println(msg);
		checkbox.click();
		WebElement saveButton = driver.findElement(By.id("modal_btn"));
		saveButton.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		checkbox = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/input"));
		if (seBorro == checkbox.isSelected())
			System.out.println("Hubo un error");
		else
			System.out.println("Operacion con exito");
	}

	public void execute() {
		WebDriver driver = init();
		//login(driver);
		loginWithActions(driver);
		addAgentToHostManual(driver);
		close(driver);
	}
}
