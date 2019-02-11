package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Nomenclature {
	public static ApplicationManager app;

	public Nomenclature() {

		app = new ApplicationManager();
	}

	// Под меню список
	public SelenideElement listNomenButton() {
		return $(By.xpath("//*[@cuba-id='supply$Nomenclature.browse']")).should(visible);
	}

	// Под меню еденица измирения
	public SelenideElement measureNomenButton() {
		return $(By.xpath("//*[@cuba-id='supply$MeasureUnits.browse']")).should(visible);
	}

	// TAB Номенклатура
	public SelenideElement measureNomenTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Nomenclature.browse']")).should(visible);
	}
	
	
	// Закрыть TAB Номенклатура
	public SelenideElement clouseTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Nomenclature.browse']//span[text()='×']")).should(visible);
	}

	// Поиск #####################
	// Поле поиска Номенклатура
	public SelenideElement measureNomenSearch() {
		return $(By.xpath("//*[@cuba-id='ftsSearchCriteriaField']")).should(visible);
	}

	// Кнопка поиска Номенклатура
	public SelenideElement measureNomenSearchBtn() {
		return $(By.xpath("//*[@cuba-id='search']")).should(visible);
	}

	// Кнопка сброса Номенклатура
	public SelenideElement measureNomenResetBtn() {
		return $(By.xpath("//*[@cuba-id='reset']")).should(visible);
	}

	// Кнопки #####################
	// Созадть копированием
	public SelenideElement measureNomenCopy() {
		return $(By.xpath("//*[@cuba-id='createCopy']")).should(visible);
	}

	// Созадть группу кнопка
	public SelenideElement measureNomenGroup() {
		return $(By.xpath("//*[@cuba-id='newGrp']")).should(visible);
	}

	// Созадть группу кнопка
	public SelenideElement measureNomenElem() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}

	// Изменить кнопка
	public SelenideElement measureNomenEdit() {
		return $(By.xpath("//*[@cuba-id='editBtn']")).should(visible);
	}

	// Изменить удалить
	public SelenideElement measureNomenDel() {
		return $(By.xpath("//*[@cuba-id='removeBtn']")).should(visible);
	}

	// Excel кнопка
	public SelenideElement measureNomenExe() {
		return $(By.xpath("//*[@cuba-id='excelBtn']")).should(visible);
	}

	// Обновить кнопка
	public SelenideElement measureNomenRef() {
		return $(By.xpath("//*[@cuba-id='refreshBtn']")).should(visible);
	}

	// Поля создания группы
	// Поле группа
	public SelenideElement addNameGrp(String text) {
		SelenideElement grp = $(By.xpath("//input[@cuba-id='name']")).should(visible);
		grp.click();
		grp.clear();
		grp.setValue(text);
		return grp;
	}

	// Поле родитель
	public SelenideElement addNameParent(String text) {
		SelenideElement parent = $(By.xpath("//*[@cuba-id='parent']//input")).should(visible);
		parent.click();
		parent.clear();
		parent.setValue(text);
		return parent;
	}

	// Поиск родителя для группы кнопка
	public SelenideElement parentBtnSearch() {
		return $(By.xpath("//*[@cuba-id='open']")).should(visible);
	}

	// Кнопка Ок сохранение группы
	public SelenideElement parentBtnOk() {
		return $(By.xpath("//*[@cuba-id='windowCommit']")).should(visible);
	}

	// Кнопка Отмена сохранение группы
	public SelenideElement parentBtnClose() {
		return $(By.xpath("//*[@cuba-id='windowClose']")).should(visible);
	}

	// Диалог popup ###################

	// Кнопка сохранить
	public SelenideElement parentBtnDialog_ok() {
		return $(By.xpath("//*[@cuba-id='optionDialog_ok']")).should(visible);
	}

	// Кнопка не сохранять
	public SelenideElement parentBtnOptionDialog_discard() {
		return $(By.xpath("//*[@cuba-id='optionDialog_discard']")).should(visible);
	}

	// Кнопка отмена
	public SelenideElement parentBtnOptionDialog_cancel() {
		return $(By.xpath("//*[@cuba-id='optionDialog_cancel']")).should(visible);
	}
	
	
	// Кнопка выбора Номенклатуры
    public SelenideElement btnNomen() {
	return $(By.xpath("//*[@cuba-id='lookup']")).should(visible);
}


	// #########################
	// Cоздание элемента
	// Поле Полное наименование
	public SelenideElement addFullName(String text) {
		SelenideElement fname = $(By.xpath("//input[@cuba-id='fullName']")).should(visible);
		fname.click();
		fname.clear();
		fname.setValue(text);
		return fname;
	}

	// Поле Атикул
	public SelenideElement addArticle(String text) {
		SelenideElement article = $(By.xpath("//input[@cuba-id='article']")).should(visible);
		article.click();
		article.clear();
		article.setValue(text);
		return article;
	}

	// Поле Единица измирения
	public SelenideElement addNomenclatureDs_Unit(String text) {
		SelenideElement btnDs_Unit = $(
				By.xpath("//*[@cuba-id='WebLookupPickerField_nomenclatureDs_unit']/div[@role='button']"))
						.should(visible);
		btnDs_Unit.click();
		SelenideElement ds_Unit = $(By.xpath("//*[@cuba-id='WebLookupPickerField_nomenclatureDs_unit']/input"))
				.should(visible);
		ds_Unit.sendKeys(Keys.BACK_SPACE);
		ds_Unit.setValue(text);
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, 5000).click();
		return ds_Unit;
	}

	// Поле Вес
	public SelenideElement addWeight(String text) {
		SelenideElement weight = $(By.xpath("//input[@cuba-id='weight']")).should(visible);
		weight.click();
		weight.clear();
		weight.setValue(text);
		return weight;
	}
	
		// Поле Вес
	public SelenideElement addDimensionst(String text) {
		SelenideElement dimensions = $(By.xpath("//input[@cuba-id='dimensions']")).should(visible);
		dimensions.click();
		dimensions.clear();
		dimensions.setValue(text);
		return dimensions;
	}
	
	
// ############################	
// Еденицы измирения 
	//Кнопка создать еденицу измирения
	public SelenideElement addBtnDsUnit() {
		return $(By.xpath("//*[@cuba-id='buttonsPanel']")).should(visible);
	}

		// Поле Код
	public SelenideElement addСode(String text) {
		SelenideElement code = $(By.xpath("//input[@cuba-id='code']")).should(visible);
		code.click();
		code.clear();
		code.setValue(text);
		return code;
	}
	
	// Поле Код название
	public SelenideElement addСodeName(String text) {
		SelenideElement name = $(By.xpath("//input[@cuba-id='name']")).should(visible);
		name.click();
		name.clear();
		name.setValue(text);
		return name;
	}
	
	
		// Поле Код полное название
	public SelenideElement addСodeFullName(String text) {
		SelenideElement fullName = $(By.xpath("//input[@cuba-id='fullName']")).should(visible);
		fullName.click();
		fullName.clear();
		fullName.setValue(text);
		return fullName;
	}
	
	
		// Кнопка Сохранить Код
	public SelenideElement btnSaveCode() {
		return $(By.xpath("//*[@cuba-id='saveBtn']")).should(visible);
	}
	
	
		
		// Кнопка Отмена сохранить Код
	public SelenideElement btnСancelBtn() {
		return $(By.xpath("//*[@cuba-id='cancelBtn']")).should(visible);
	}
	

}
