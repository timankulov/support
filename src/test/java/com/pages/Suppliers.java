package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Suppliers {
	public static ApplicationManager app;

	public Suppliers() {
		app = new ApplicationManager();
	}

	// TAB Поставщики
	public SelenideElement tabSuppliers() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Suppliers.browse']")).should(visible);
	}

	// Закрыть TAB Поставщики
	public SelenideElement clouseTabSuppliers() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Suppliers.browse']//span[text()='×']")).should(visible);
	}

	// Поля поиска поставщиков ######################
	// Поле поиск по имени
	public SelenideElement nameSearchField(String text) {
		SelenideElement name = $(By.xpath("//input[@cuba-id='nameSearchField']")).should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		return name;
	}

	// Поле поиск по ИНН
	public SelenideElement innSearchField(String text) {
		SelenideElement inn = $(By.xpath("//input[@cuba-id='innSearchField']")).should(visible);
		inn.click();
		inn.clear();
		inn.setValue(text);
		return inn;
	}

	// Поле поиск по EMAIL
	public SelenideElement emailSearchField(String text) {
		SelenideElement em = $(By.xpath("//input[@cuba-id='emailSearchField']")).should(visible);
		em.click();
		em.clear();
		em.setValue(text);
		return em;
	}

	// Создание поставщиков ######################
	// Добавить поставщика кнопка (Создать)
	public SelenideElement addSuppBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}

	// Изменить поставщика кнопка (Изменить)
	public SelenideElement editSuppBtn() {
		return $(By.xpath("//*[@cuba-id='editBtn']")).should(visible);
	}

	// Удалить поставщика кнопка (Удалить)
	public SelenideElement removeSuppBtn() {
		return $(By.xpath("//*[@cuba-id='removeBtn']")).should(visible);
	}

	// Поля создания поставщика ######################

	// Поле добавить постащика
	public SelenideElement addSupName(String text) {
		SelenideElement name = $(By.xpath("//input[@cuba-id='name']")).should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		return name;
	}

	// Поле добавить полное имя поставщика
	public SelenideElement addSupFullName(String text) {
		SelenideElement fname = $(By.xpath("//input[@cuba-id='fullName']")).should(visible);
		fname.click();
		fname.clear();
		fname.setValue(text);
		return fname;
	}

	// Поле добавить контакты постащика
	public SelenideElement addSupInn(String text) {
		SelenideElement inn = $(By.xpath("//input[@cuba-id='inn']")).should(visible);
		inn.click();
		inn.clear();
		inn.setValue(text);
		return inn;
	}

	// Поле добавить контакты постащика
	public SelenideElement addSupContacts(String text) {
		SelenideElement con = $(By.xpath("//input[@cuba-id='contacts']")).should(visible);
		con.click();
		con.clear();
		con.setValue(text);
		return con;
	}

	// Поле добавить контакты постащика
	public SelenideElement addSupEmail(String text) {
		SelenideElement email = $(By.xpath("//input[@cuba-id='email']")).should(visible);
		email.click();
		email.clear();
		email.setValue(text);
		return email;
	}

	// Поле добавить комментарии
	public SelenideElement addSupCom(String text) {
		SelenideElement com = $(By.xpath("//input[@cuba-id='WebResizableTextArea_suppliersDs_comments']"))
				.should(visible);
		com.click();
		com.clear();
		com.setValue(text);
		return com;
	}

	// НДС поставщика чекбокс
	public SelenideElement ndsSuppCheckbox() {
		return $(By.xpath("//*[@cuba-id='vat']/input")).should(visible);
	}

	// PopUp удаления ##########################

	// Кнопка сохранить
	public SelenideElement supBtnDialog_ok() {
		return $(By.xpath("//*[@cuba-id='optionDialog_ok']")).should(visible);
	}

	// Кнопка отмена
	public SelenideElement supBtnOptionDialog_cancel() {
		return $(By.xpath("//*[@cuba-id='optionDialog_cancel']")).should(visible);
	}

	// ##########################

	// PopUp закрытия TAB поставщики

	// Закрыть вкладку кнопка ОК
	public SelenideElement clouseBtnOK() {
		return $(By.xpath("//div[@cuba-id='optionDialog_yes']")).should(visible);
	}

	// Отменить закрытие вкладки календарь cancel
	public SelenideElement noBtnCancel() {
		return $(By.xpath("//div[@cuba-id='optionDialog_no']")).should(visible);
	}

	// ######################
	// Форма (Выбор поставщиков)

	// Поле поиска постащика
	public SelenideElement searchSup(String text) {
		SelenideElement searchSup = $(By.xpath("//input[@cuba-id='ftsSearchCriteriaField']")).should(visible);
		searchSup.click();
		searchSup.clear();
		searchSup.setValue(text);
		return searchSup;
	}

	// Поиск поставщика кнопка
	public SelenideElement btnSearch() {
		return $(By.xpath("//div[@cuba-id='search']")).should(visible);
	}

	// Поиск поставщика сброс кнопка
	public SelenideElement btnReset() {
		return $(By.xpath("//div[@cuba-id='reset']")).should(visible);
	}

	// Поставщика сброс кнопка
	public SelenideElement btnSuppliers() {
		return $(By.xpath("//div[@cuba-id='btnSuppliers']")).should(visible);
	}

	// #####################
	// Форма отправки
	// Ракрыть форму отправить
	public SelenideElement btnMaximizebox() {
		return $(By.xpath("//div[@class='v-window-maximizebox']")).should(visible);
	}

	// Закрыть форму отправить X кнопка
	public SelenideElement btnvСlosebox() {
		return $(By.xpath("//div[@class='v-window-closebox']")).should(visible);
	}

	// Отправить запрос поставщикам Кнопка
	public SelenideElement btnMessage() {
		return $(By.xpath("//div[@cuba-id='btnMessage']")).should(visible);
	}

	// Кнопка закрыть
	public SelenideElement btnClose() {
		return $(By.xpath("//div[@cuba-id='btnClose']")).should(visible);
	}

	// Поиск поставщика Поле
	public SelenideElement chooseSupp(String supp) {
		SelenideElement chooseSupp = $(By.xpath("//*[@cuba-id='WebLookupPickerField_suppliersDs']/input"))
				.should(visible);
		chooseSupp.sendKeys(Keys.CONTROL, "a");
		chooseSupp.sendKeys(Keys.BACK_SPACE);
		chooseSupp.setValue(supp);
		$(By.xpath("//span[text()='" + supp + "']")).waitUntil(visible, app.timeOut).click();
		return chooseSupp;
	}

	// Кнопка раскрыть список поставщиков поле
	public SelenideElement btnSuppliersDs() {
		return $(By.xpath("//*[@cuba-id='WebLookupPickerField_suppliersDs']//div[@role='button']")).should(visible);
	}

	// Кнопка открыть домолнительную форму поиска поставщика
	public SelenideElement btnLookup() {
		return $(By.xpath("//*[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка очистить поставщиков
	public SelenideElement btnClear() {
		return $(By.xpath("//div//span[text()='Очистить']")).should(visible);
	}

	// Кнопка Добавить поставщиков
	public SelenideElement btnAddSup() {
		return $(By.xpath("//*[@cuba-id='addSuppliersFromTokenList']")).should(visible);
	}

	// Только для SMOKE теста проверка количество поставщиков 1 (Тут Тестовый поставщик 1 )
	public SelenideElement getSupplyers(String text) {
		SelenideElement numSupp = $(By.xpath("//*[text()='" + text + "']")).should(exist);
		numSupp.click();
		return numSupp;
	}


}
