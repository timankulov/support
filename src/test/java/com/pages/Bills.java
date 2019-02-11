package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Bills {
	public static ApplicationManager app;
	Date today = new Date();
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	String date = DATE_FORMAT.format(today);
	File file = new File("");
	
	

	public Bills() {
		app = new ApplicationManager();
	}

	// Закладка TAB Счета
	public SelenideElement tabWorkPro() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Bills.browse']")).should(visible);
	}

	// Закрыть Закладка Счета
	public SelenideElement linkWorkPro() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Bills.browse']//span[text()='×']")).should(visible);
	}

	// #########################
	// Кнопки работы со счетами

	// Создание Счета
	public SelenideElement crtBillBtn() {
		return $(By.xpath("//*[@cuba-id='btnBills']")).should(visible);
	}

	// Запросить Счет
	public SelenideElement getBillBtn() {
		return $(By.xpath("//*[@cuba-id='btnQueryBill']")).should(visible);
	}

	// Прикрепить
	public SelenideElement attachBillBtn() {
		return $(By.xpath("//*[@cuba-id='btnAttach']")).should(visible);
	}

	// Открепить
	public SelenideElement unblockBillBtn() {
		return $(By.xpath("//*[@cuba-id='btnUndock']")).should(visible);
	}

	// Загрузить
	public SelenideElement uploadBillBtn() {
		return $(By.xpath("//*[@cuba-id='uploadField']")).should(visible);
	}

	// Скачать
	public SelenideElement downloadBillBtn() {
		return $(By.xpath("//*[@cuba-id='downloadImageBtn']")).should(visible);
	}

	// Удалить
	public SelenideElement delBillBtn() {
		return $(By.xpath("//*[@cuba-id='clearImageBtn']")).should(visible);
	}

	// Открыть в новом окне
	public SelenideElement openBillBtn() {
		return $(By.xpath("//*[@cuba-id='OpenInNewTabBtn']")).should(visible);
	}

	// Экспорт счетов
	public SelenideElement exportBillsBtn() {
		return $(By.xpath("//*[@cuba-id='exportBillsBtn']")).should(visible);
	}

	// Возврат (Закупочная комиссия итд)
	public SelenideElement btnReturn(String text) {
		SelenideElement btn = $(By.xpath("//*[@cuba-id='btnReturn']")).should(visible);
		btn.click();
		sleep(1000);
		SelenideElement item = $(By.xpath("//span[text()='" + text + "']")).should(visible);
		item.click();
		return item;
	}

	// Выделить все
	public SelenideElement selectAllTabBills() {
		return $(By.xpath("//*[@cuba-id='select_all_tabBills']")).should(visible);
	}

	// ########################

	// Под меню Срочность, Компания, Подразделение итд СОРТИРОВКИ
	// #########################
	// Срочность
	public SelenideElement columnQueryUrgency() {
		return $(By.xpath("//*[@cuba-id='column_query.urgency']")).should(visible);
	}

	// Компания
	public SelenideElement columnQueryCompany() {
		return $(By.xpath("//*[@cuba-id='column_query.company']")).should(visible);
	}

	// Подразделения
	public SelenideElement columnQueryDivision() {
		return $(By.xpath("//*[@cuba-id='column_query.division']")).should(visible);
	}

	// Заявки
	public SelenideElement columnQuery() {
		return $(By.xpath("//*[@cuba-id='column_query']")).should(visible);
	}

	// #########################

	// Закладки заявок
	// Сверхсрочная закладка
	public SelenideElement link() {
		return $(By.xpath("//div[@class='c-grouptable-float' and contains(text(),'Сверхсрочная')]")).should(visible);
	}

	// Выбираем закладки по тесту + один клик развернуть 
	public SelenideElement linkQuery(String text) {
	//	c-grouptable-group-cell-expander
		SelenideElement locator = $(By.xpath("//div[@class='c-grouptable-float' and contains(text(),'" + text + "')]/../div[1]"))
				.waitUntil(visible, app.timeOut);
		return locator;
	}
	
	
	// Выбираем закладки по тесту + один клик развернуть 
	public SelenideElement linkQueryBill(String text) {
		SelenideElement locator = $(By.xpath("//div[@cuba-id='WebLabel']/b[contains(text(),'"+text+"')]/../../span")).waitUntil(visible, app.timeOut);
		return locator;
	}
	
	
	
		// Выбираем закладки по тесту далеклик double
	public SelenideElement linkDoubleQuery(String text) {
	//	c-grouptable-group-cell-expander
		
		SelenideElement loctor = $(By.xpath("//div[@class='c-grouptable-float' and contains(text(),'" + text + "')]/../div"))
				.should(visible);
	
		loctor.doubleClick();
		return loctor;
	}
	
	

	// Выбираем закладки поставщик
	public SelenideElement getSupp(String text) {
		SelenideElement loctor = $(By.xpath(
				"//div[@class='v-splitpanel-second-container v-scrollable']//div[contains(text(),'" + text + "')]"))
						.should(visible);
		sleep(500);
		return loctor;
	}

	// ########################
	// Поля формы (Редактирование счета)
	// Номер
	public SelenideElement numberQuerier(String text) {
		return $(By.xpath("//*[@cuba-id='number']")).waitUntil(exist, app.timeOut).setValue(text);
	}

	// Дата платежа - формат (01.01.2019)
	public SelenideElement timePayment(String text) {
		return $(By.xpath("//*[@cuba-id='timePayment']//input")).waitUntil(exist, app.timeOut).setValue(text);
	}

	// Количество
	public SelenideElement amount(String text) {
		
		SelenideElement amount = $(By.xpath("//*[@cuba-id='amount']")).waitUntil(exist, app.timeOut);
		if (!text.equals(""))
		{
			amount.setValue(text);
			
		}
		
		return amount;
	}

	// Поле Поставщик
	public SelenideElement billsDs_supplier(String text) {
		SelenideElement billsDs_supplier = $(By.xpath("//*[@cuba-id='WebLookupPickerField_billsDs_supplier']/input"))
				.should(visible);
		if (!text.equals("")) {
			billsDs_supplier.sendKeys(Keys.CONTROL, "a");
			billsDs_supplier.sendKeys(Keys.BACK_SPACE);
			billsDs_supplier.setValue(text);
			sleep(1000);
			$(By.xpath("//span[contains(.,'" + text + "')]")).waitUntil(visible, app.timeOut).click();

		}
		return billsDs_supplier;
	}

	// Поле Компания
	public SelenideElement billsDs_company(String text) {
		SelenideElement billsDs_company = $(By.xpath("//*[@cuba-id='WebLookupPickerField_billsDs_company']/input"))
				.should(visible);
		if (!text.equals("")) {
			billsDs_company.sendKeys(Keys.CONTROL, "a");
			billsDs_company.sendKeys(Keys.BACK_SPACE);
			billsDs_company.setValue(text);
			sleep(1000);
			$(By.xpath("//span[contains(.,'" + text + "')]")).waitUntil(visible, app.timeOut).click();

		}
		return billsDs_company;
	}

	// Кнопка очитстить
	public SelenideElement amount() {
		return $(By.xpath("//div[@class='v-button v-widget c-fileupload-clear v-button-c-fileupload-clear']"))
				.should(visible);
	}
	
	
	// Загрузка файла
		public SelenideElement file(String fileName) {
			SelenideElement locator = $(By.xpath("//*[@name='files[]']")).waitUntil(exist, app.timeOut);
			locator.uploadFile(new File(file.getAbsolutePath()+fileName));
			return locator;
	
		}
	

	// Кнопка Ок
	public SelenideElement okBtn() {
		return $(By.xpath("//*[@cuba-id='windowCommit']")).should(visible);
	}

	// Кнопка Отмена
	public SelenideElement closeBtn() {
		return $(By.xpath("//*[@cuba-id='windowClose']")).should(visible);
	}
	
	// ########################
	// Клик на созданный счет
	
		public SelenideElement newBillLink(String text) {
		return $(By.xpath("//div[text()='"+text+"']")).should(visible);
	}
	
	

	

}
