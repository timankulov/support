package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Problems {
	public static ApplicationManager app;

	public Problems() {
		app = new ApplicationManager();
	}

	// TAB Проблемы
	public SelenideElement tabProblem() {
		return $(By.xpath("//*[@cuba-id='tab_supply$QueriesPositionProblem.browse']")).should(visible);
	}

	// Закрыть TAB Проблемы
	public SelenideElement clouseTabProblem() {
		return $(By.xpath("//*[@cuba-id='tab_supply$QueriesPositionProblem.browse']//span[text()='×']"))
				.should(visible);
	}

	// Поля поиска по Проблемы ######################
	// Поле поиск
	public SelenideElement nameSearchProblem(String text) {
		SelenideElement cal = $(By.xpath("//input[@cuba-id='ftsSearchCriteriaField']")).should(visible);
		cal.click();
		cal.clear();
		cal.setValue(text);
		return cal;
	}

	// Кнопка поиска
	public SelenideElement btnSearchProblem() {
		return $(By.xpath("//*[@cuba-id='search']")).should(visible);
	}

	// Кнопка сброс поиска
	public SelenideElement btnResetProblem() {
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

	// Создание проблемы #######################

	// Закрыть редактор проблем ссылка
	public SelenideElement linkBack() {
		return $(By.xpath("//*[@cuba-id='breadCrubms_Button_supply$QueriesPositionProblem.browse']")).should(visible);
	}

	// Кнопка Ок сохранение
	public SelenideElement btnOk() {
		return $(By.xpath("//*[@cuba-id='windowCommit']")).should(visible);
	}

	// Кнопка Отмена
	public SelenideElement btnClose() {
		return $(By.xpath("//*[@cuba-id='windowClose']")).should(visible);
	}
	
	
	// Выбор Позиции
	public SelenideElement problemDs(String text) {
		
		SelenideElement problemDs = $(By.xpath("//*[@cuba-id='WebLookupPickerField_queriesPositionProblemDs_queriesPosition']/input"))
				.should(visible);
		problemDs.sendKeys(Keys.BACK_SPACE);
		problemDs.setValue(text);
		
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return problemDs;
	}

		// Кнопка выбора типа
	public SelenideElement btnProblemType() {
		return $(By.xpath("//*[@cuba-id='lookup']")).should(visible);
	}
	
	public SelenideElement btnClearProblemType() {
		return $(By.xpath("//*[@cuba-id='clear']")).should(visible);
	}
	
		// Поле сообщение
	public SelenideElement problemMessage(String text) {
		SelenideElement message = $(By.xpath("//*[@cuba-id='WebResizableTextArea_queriesPositionProblemDs_message']")).should(visible);
		message.click();
		message.clear();
		message.setValue(text);
		return message;
	}
	

}
