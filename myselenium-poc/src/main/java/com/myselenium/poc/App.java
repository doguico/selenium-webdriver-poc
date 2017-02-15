package com.myselenium.poc;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("SimpleExample - 1");
		System.out.println("GUIElementsTest - 2");
		System.out.println("GetElementByTagName - 3");
		System.out.println("Login - 4");


		int i = input.nextInt();

		while (i != 0) {
			
			switch (i) {
			case 1:
				SimpleExample.ExecuteTest();
				break;
			case 2:
				GUIElementsTest.GetInstance().GetElementById();
				break;
			case 3:
				GUIElementsTest.GetInstance().GetElementByTagName();
				break;
			case 4:
				InteractingExample.GetInstance().Login("http://localhost:8080/spider-order-robot-platform");
				break;
			}
			
			input.nextInt();
			i = input.nextInt();
		}
		input.close();
	}
}
