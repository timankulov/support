package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Login {
	public static ApplicationManager app;

	public Login() {

		app = new ApplicationManager();
	}

	public SelenideElement loginField() {
		return $(By.xpath("//*[@cuba-id='loginField']")).waitUntil(visible, app.timeOut);
	}

	public SelenideElement passwordField() {
		return $(By.xpath("//*[@cuba-id='passwordField']")).waitUntil(visible, app.timeOut);
	}

	public SelenideElement loginButton() {
		return $(By.xpath("//*[@cuba-id='loginButton']")).waitUntil(visible, app.timeOut);
	}

	public SelenideElement loginButtonGoogle() {
		return $(By.xpath("//*[@cuba-id='googleBtn']")).waitUntil(visible, app.timeOut);
	}

	public SelenideElement logoutButton() {
		return $(By.xpath("//*[@cuba-id='logoutButton']")).waitUntil(visible, app.timeOut);
	}

	public void login(String login, String password) {
		sleep(1500);
		loginField().clear();
		sleep(1500);
		loginField().setValue(login);
		sleep(1500);
		passwordField().clear();
		sleep(1500);
		passwordField().setValue(password);
		sleep(1500);
		loginButton().click();
		sleep(1500);
		logoutButton().waitUntil(exist, app.timeOut);
	}

	public void logOut() {
		sleep(7000);
		logoutButton().waitUntil(visible, app.timeOut).click();
	}

}
