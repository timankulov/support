package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Store {
	public static ApplicationManager app;

	public Store() {
		app = new ApplicationManager();
	}

	// Под Меню Склады
	public SelenideElement menuStore() {
		return $(By.xpath("//span[@cuba-id='supply$Store.browse']")).should(visible);
	}

	// TAB Список складов
	public SelenideElement measureNomenTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Store.browse']")).should(visible);
	}

	// Закрыть TAB склады
	public SelenideElement clouseTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Store.browse']//span[text()='×']")).should(visible);
	}

	// Добавить Склад кнопка (Создать)
	public SelenideElement addCompanyBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}

	// Поле добавить Склад
	public SelenideElement addCompanyName(String text) {
		SelenideElement name = $(By.xpath("//input[@cuba-id='name']")).should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		return name;
	}

	// Поле поиска Склада на форме
	public SelenideElement searchDivision(String text) {
		SelenideElement name = $(By.xpath("//div[@cuba-id='WebLookupPickerField_storeDs_division']/input"))
				.should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return name;
	}

	// Добавить Склад кнопка ОК
	public SelenideElement addCompanyBtnOK() {
		return $(By.xpath("//div[@cuba-id='saveBtn']")).should(visible);
	}

	// Добавить Склад кнопка cancel
	public SelenideElement addCompanyBtnCancel() {
		return $(By.xpath("//div[@cuba-id='cancelBtn']")).should(visible);
	}

	// Возврат (Со слкада) Кнопка
	public SelenideElement btnReturn(String text) {
		SelenideElement btn = $(By.xpath("//*[@cuba-id='btnReturn']")).should(visible);
		btn.click();
		sleep(500);
		SelenideElement item = $(By.xpath("//span[text()='" + text + "']/../..")).should(visible);
		item.click();
		return btn;
	}

	// Возврат Комментарий Поле
	public SelenideElement textArea(String text) {
		SelenideElement textarea = $(By.xpath("//*[@cuba-id='textArea']")).waitUntil(visible, app.timeOut);
		textarea.clear();
		textarea.setValue(text);
		return textarea;
	}

	// Кнопка ok
	public SelenideElement addCompanyBtnOk() {
		return $(By.xpath("//div[@cuba-id='ok']")).should(visible);

	}

	// Кнопка cancel
	public SelenideElement addCompanyBtncancel() {
		return $(By.xpath("//div[@cuba-id='cancel']")).should(visible);

	}

	// #########################
	// Создание склада
	public void createNewStore(String name, String division) {
		app.mainMenu().referencesButton().click();
		menuStore().click();
		addCompanyBtn().click();
		addCompanyName(name);
		searchDivision(division);
		addCompanyBtnOK().click();

	}

	// #########################
	// Вернуть назад  МЕТОД ПРИМЕНИМ ДЛЯ ВСЕХ ОТКАЗОВ И ВОЗВРАТОВ!!!
	public void returnNomen(String text) {
		textArea(text);
		sleep(3000);
		addCompanyBtnOk().click();
	}
	// ########################

}
