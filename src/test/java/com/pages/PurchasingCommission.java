package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class PurchasingCommission {
	public static ApplicationManager app;

	public PurchasingCommission() {
		app = new ApplicationManager();
	}

	// Окно голосования
	// ##########################

	// Выбрать поставщика
	public SelenideElement supplier(String supp) {
		SelenideElement supplier = $(By.xpath("//*[text()='" + supp + "']")).should(visible);
		sleep(2000);
		return supplier;
	}

	// Кнопка выбрать поставщика
	public SelenideElement supplierBtn() {
		SelenideElement suppbtn = $(By.xpath("//*[@cuba-id='onSelect_invoke']")).should(visible);
		suppbtn.click();
		// Ждем PopUp
		$(By.xpath("//*[@class='v-assistive-device-only']/../h1")).waitUntil(visible, app.timeOut).click();
		sleep(1000);
		
		return suppbtn;
	}

}
