package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Settings {
	public static ApplicationManager app;

	public Settings() {
		app = new ApplicationManager();
	}

	//######################
	// Данный класс бует дописан при необходимости 	
	//######################
	
	// TAB Настройки
	public SelenideElement tabCalendar() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Settings.browse']")).should(visible);
	}

	// Закрыть TAB Настройки
	public SelenideElement clouseTabCalendar() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Settings.browse']//span[text()='×']")).should(visible);
	}

	// Поля поиска по Настройкам ######################
	// Поле поиск
	public SelenideElement nameSearchCalendar(String text) {
		SelenideElement cal = $(By.xpath("//input[@cuba-id='ftsSearchCriteriaField']")).should(visible);
		cal.click();
		cal.clear();
		cal.setValue(text);
		return cal;
	}

	// Кнопка поиска
	public SelenideElement btnSearchCalendar() {
		return $(By.xpath("//*[@cuba-id='search']")).should(visible);
	}

	// Кнопка сброс поиска
	public SelenideElement btnResetCalendar() {
		return $(By.xpath("//*[@cuba-id='reset']")).should(visible);
	}

	// кнопки #######################

	// Добавить кнопка
	public SelenideElement addSetBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}

	// Изменить кнопка (Изменить)
	public SelenideElement editSetBtn() {
		return $(By.xpath("//span[@cuba-id='//*[@cuba-id='editBtn']")).should(visible);
	}

	// Кнорка Удалить
	public SelenideElement btnSetDel() {
		return $(By.xpath("//*[@cuba-id='removeBtn']")).should(visible);
	}

	// Обновить кнопка
	public SelenideElement btnSetRef() {
		return $(By.xpath("//*[@cuba-id='refreshBtn']")).should(visible);
	}

	// Настройки SMTP
	public SelenideElement btnInitSMTP() {
		return $(By.xpath("//*[@cuba-id='initSMTP']")).should(visible);
	}
	// Создание настроек #######################
	
	// Вернутся в настройки
	
		// Настройки SMTP
	public SelenideElement btnBackSet() {
		return $(By.xpath("//*[@cuba-id='breadCrubms_Button_supply$Settings.browse']")).should(visible);
	}
	
	
	// Поле Тип значения
	
	public SelenideElement fieldType(String text) {
		SelenideElement fieldType = $(By.xpath("//*[@cuba-id='lookupFieldType']//input")).should(visible);
		fieldType.click();
		fieldType.clear();
		fieldType.setValue(text);
		return fieldType;
	}
	
	// Кнопка выбора настройки
	public SelenideElement btnFieldType(String text) {	
		SelenideElement btnFieldType = $(
				By.xpath("//*[@cuba-id='lookupFieldType']//div")).should(visible);
		btnFieldType.click();
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return btnFieldType;
	}

	// Диалог popup ################### 
	// Кнопка сохранить
		public SelenideElement btnDialog_ok() {
			return $(By.xpath("//*[@cuba-id='optionDialog_ok']")).should(visible);
		}

		// Кнопка отмена
		public SelenideElement btnOptionDialog_cancel() {
			return $(By.xpath("//*[@cuba-id='optionDialog_cancel']")).should(visible);
		}

	
	
	
	

}
