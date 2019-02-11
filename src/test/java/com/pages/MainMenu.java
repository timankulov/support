package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class MainMenu {
	public static ApplicationManager app;

	public MainMenu() {

		app = new ApplicationManager();
	}

	// Кнопки главного меню
	public SelenideElement mainProcessButton() {
		return $(By.xpath("//*[@cuba-id='tabView']"));
	}

	// Справочники
	public SelenideElement referencesButton() {
		return $(By.xpath("//*[@cuba-id='references']"));
	}

	// Справочники под меню
	// #######################
	// Под меню Номенклатура
	public SelenideElement nomenButton() {
		return $(By.xpath("//*[@cuba-id='nomenclature']")).should(visible);
	}

	// Меню структура
	public SelenideElement menuStruture() {
		return $(By.xpath("//span[@cuba-id='orgstru']")).should(visible);
	}

	// Под меню Поставщики
	public SelenideElement btnSuppliersMenu() {
		return $(By.xpath("//*[@cuba-id='supply$Suppliers.browse']")).should(visible);
	}

	// Под меню Календарь
	public SelenideElement btnCalendarsMenu() {
		return $(By.xpath("//*[@cuba-id='supply$Holiday.browse']")).should(visible);
	}

	// Под меню Настройки
	public SelenideElement btnSettingssMenu() {
		return $(By.xpath("//*[@cuba-id='supply$Settings.browse']")).should(visible);
	}

	// Под меню Счета
	public SelenideElement btnBillsMenu() {
		return $(By.xpath("//*[@cuba-id='supply$Bills.browse']")).should(visible);
	}

	// Под меню Проблемы
	public SelenideElement btnProblemsMenu() {
		return $(By.xpath("//*[@cuba-id='supply$QueriesPositionProblem.browse']")).should(visible);
	}

	// Под меню Тип Проблемы
	public SelenideElement btnTypeProblemsMenu() {
		return $(By.xpath("//*[@cuba-id='supply$QueriesPositionProblemType.browse']")).should(visible);
	}

	// Под меню Экспедиторы
	public SelenideElement btnForwarder() {
		return $(By.xpath("//*[@cuba-id='supply$Forwarder.browse']")).should(visible);
	}
	
	// Под меню Сотрудники
	public SelenideElement btnEmployee() {
		return $(By.xpath("//*[@cuba-id='supply$Employee.browse']")).should(visible);
	}
	
	
	// Под меню Nomenclature Sets
	public SelenideElement btnNomenclatureSet() {
		return $(By.xpath("//*[@cuba-id='supply$NomenclatureSet.browse']")).should(visible);
	}
	
	
	// Под меню Company Nomenclatures
	public SelenideElement btnCompanyNomenclature() {
		return $(By.xpath("//*[@cuba-id='supply$CompanyNomenclature.browse']")).should(visible);
	}
	
	
	// Под меню Additional Info
	public SelenideElement btnAdditionalInfo() {
		return $(By.xpath("//*[@cuba-id='additionalInfo']")).should(visible);
	}
	

	// #######################
// Заявки
	public SelenideElement queriesButton() {
		SelenideElement queries = $(By.xpath("//*[@cuba-id='queries']")).should(visible);
		sleep(1000);
		return queries;
	}
	
	
	// Кнокпка Заявки подменю
		public SelenideElement supplyQueryeButton() {
			return $(By.xpath("//div[@class='popupContent']//span[@cuba-id='supply$Query.browse']")).waitUntil(visible, app.timeOut);
		}

	
	
// Отчеты
	public SelenideElement reportsButton() {
		return $(By.xpath("//*[@cuba-id='Reports']"));
	}
// Инструменты 
	public SelenideElement toolsButton() {
		return $(By.xpath("//*[@cuba-id='Tools']"));
	}
	
	
// Администрирование ####################
	public SelenideElement administrationButton() {
		return $(By.xpath("//*[@cuba-id='administration']"));
	}
	
// Допменю Администрирование ####################

	// История сообщений
	public SelenideElement messageHistoryButton() {
		return $(By.xpath("//*[@cuba-id='sys$SendingMessage.browse']"));
	}
	
	
	
// ####################	

// Помощь
	public SelenideElement helpButton() {
		return $(By.xpath("//*[@cuba-id='help']"));
	}
// Текст
	public SelenideElement testButton() {
		return $(By.xpath("//*[@cuba-id='Test']"));
	}
	
	

}
