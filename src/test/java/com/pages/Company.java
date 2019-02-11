package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Company {
	public static ApplicationManager app;

	public Company() {
		app = new ApplicationManager();
	}

	// Закладка TAB Компании
	public SelenideElement tabWorkPro() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Company.browse']")).should(visible);
	}

	// Закрыть Закладка Компании
	public SelenideElement linkWorkPro() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Company.browse']//span[text()='×']")).should(visible);
	}

	// Меню Компании
	public SelenideElement menuCompany() {
		return $(By.xpath("//span[@cuba-id='supply$Company.browse']")).should(visible);
	}

	// Добавить компанию кнопка
	public SelenideElement addCompanyBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}

	// Поле добавить компанию
	public SelenideElement addCompanyName(String text) {
		SelenideElement name = $(By.xpath("//input[@cuba-id='name']")).should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		return name;
	}

	// Поле добавить полное имя компании
	public SelenideElement addCompanyFullName(String text) {
		SelenideElement fname = $(By.xpath("//input[@cuba-id='fullName']")).should(visible);
		fname.click();
		fname.clear();
		fname.setValue(text);
		return fname;
	}

	// Поле добавить ИНН
	public SelenideElement addCompanyInn(String text) {
		SelenideElement inn = $(By.xpath("//input[@cuba-id='inn']")).should(visible);
		inn.click();
		inn.clear();
		inn.setValue(text);
		return inn;
	}

	// Поле добавить КПП
	public SelenideElement addCompanyKpp(String text) {
		SelenideElement kpp = $(By.xpath("//input[@cuba-id='kpp']")).should(visible);
		kpp.click();
		kpp.clear();
		kpp.setValue(text);
		return kpp;
	}

	// Поле добавить officialName
	public SelenideElement addCompanyOfficialName(String text) {
		SelenideElement officialName = $(By.xpath("//input[@cuba-id='officialName']")).should(visible);
		officialName.click();
		officialName.clear();
		officialName.setValue(text);
		return officialName;
	}

	// Добавить компанию кнопка ОК
	public SelenideElement addCompanyBtnOK() {
		return $(By.xpath("//div[@cuba-id='saveBtn']")).should(visible);
	}

	// Отменить добавление компанию кнопка cancel
	public SelenideElement addCompanyBtnCancel() {
		return $(By.xpath("//div[@cuba-id='cancelBtn']")).should(visible);
	}

	// Поле поиска компании на форме
	public SelenideElement searchCompanyForDivision(String text) {
		SelenideElement name = $(By.xpath("//div[@cuba-id='WebLookupPickerField_divisionDs_company']/input"))
				.should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return name;
	}

	// Поле поиска компании на форме
	public SelenideElement searchDivision(String text) {
		SelenideElement name = $(By.xpath("//div[@cuba-id='WebLookupPickerField_storeDs_division']/input"))
				.should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return name;
	}

	// ##########################

	// Создание компании
	public void createNewCompany(String name, String fullName, String inn, String kpp, String officialName) {
		app.mainMenu().referencesButton().click();
		app.mainMenu().menuStruture().click();
		addCompanyBtn().click();
		addCompanyName(name);
		addCompanyFullName(fullName);
		addCompanyInn(inn);
		addCompanyKpp(kpp);
		addCompanyOfficialName(officialName);
		addCompanyBtnOK().click();

	}

}
