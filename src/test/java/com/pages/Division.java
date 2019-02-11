package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Division {
	public static ApplicationManager app;

	public Division() {
		app = new ApplicationManager();
	}
	
	
	// Меню Подразделения
		public SelenideElement menuDivision() {
			return $(By.xpath("//span[@cuba-id='supply$Division.browse']")).should(visible);
		}

	
	// TAB Список Подразделения
	public SelenideElement divisionTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Division.browse']")).should(visible);
	}
	
	// Закрыть TAB Подразделения
	public SelenideElement clouseTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Division.browse']//span[text()='×']")).should(visible);
	}
		
	// Добавить Подразделени кнопка (Создать)
	public SelenideElement addCompanyBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}
	
	// Поле поиска 
	public SelenideElement searchCompanyForDivision(String text) {
		SelenideElement name = $(By.xpath("//div[@cuba-id='WebLookupPickerField_divisionDs_company']/input"))
				.should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return name;
	}
	
	
	// Поле добавить подразделение
	public SelenideElement addCompanyDivision(String text) {
		SelenideElement officialName = $(By.xpath("//input[@cuba-id='name']")).should(visible);
		officialName.click();
		officialName.clear();
		officialName.setValue(text);
		return officialName;
	}
	
	// Добавить кнопка ОК
	public SelenideElement addCompanyBtnOK() {
		return $(By.xpath("//div[@cuba-id='saveBtn']")).should(visible);
	}
	
	
	// #######################
	// Создание подразделения
		public void createNewDivision(String name, String division) {
			app.mainMenu().referencesButton().click();
			menuDivision().click();
			addCompanyBtn().click();
			searchCompanyForDivision(name);
			addCompanyDivision(division);
			addCompanyBtnOK().click();

		}
	
	

}
