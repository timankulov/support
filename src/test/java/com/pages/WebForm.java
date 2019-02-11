package com.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class WebForm {
	public static ApplicationManager app;

	
	
	public WebForm() {

		app = new ApplicationManager();
	}

	/**
	 * (Поля web формы) nomenklatura это текст название номенклатуры 
	 * id 2 - Аналог
	 * id 5 - В наличии 
	 * id 6 - Срок доставки 
	 * id 7 - Цена 
	 * id 8 - Отсрочка платежа 
	 * id 9 - Производитель 
	 * id 10 - Гарантия 
	 * id 11 - Размер НДС 
	 * id 12 - Комментарий
	 * Выбрать первый  
	 * //div[text()='Сетка С-2']/../../../../../div[2]
	 * //div[text()='Синхронизатор 5-4 пер. КПП ЯМЗ']/../../../../../../div[1]/div[3]
	 * 
	 */
	public SelenideElement webFormField(String nomenklatura, String id, String text) {		
		SelenideElement div = $(By.xpath("//div[@class='react-grid-Row react-grid-Row--even']/div["+id+"]")).should(visible);
		//div.click();
		div.doubleClick();
        sleep(1000);	
	//	SelenideElement input = $(By.xpath("//div[text()='" + nomenklatura + "']/../../../../../div[" + id + "]//input"));		
		SelenideElement input = $(By.xpath("//input[@class=' editor-main']"));		
		input.sendKeys(Keys.CONTROL, "a");
		input.sendKeys(Keys.BACK_SPACE);		
		input.setValue(text);
		return input;
	}

	// Кнопка Сохранить
	public SelenideElement save() {
		SelenideElement save = $(By.xpath("//button[text()='Сохранить']")).should(visible);
		return save;
	}

	// Кнопка Отменить
	public SelenideElement cancel() {
		SelenideElement save = $(By.xpath("//button[text()='Отменить изменения']")).should(visible);
		return save;
	}

	// Кнопка Копировать
	public SelenideElement copy() {
		SelenideElement save = $(By.xpath("//button[text()='Скопировать позицию']")).should(visible);
		return save;
	}
	
	
	// Кнопка Копировать
	// text название номенклатуры - Если будут одинаковые придется указывать ID div[id]
	public SelenideElement checkBox(String text) {
		SelenideElement save = $(By.xpath("//div[text()='"+text+"']/../../../../../../div//input[@name]")).should(visible);
		return save;
	}
		
	
		// Кнопка OK Popup
	public SelenideElement okBtn() {
		SelenideElement ok = $(By.xpath("//button[@class='mm-popup__btn mm-popup__btn--ok']")).should(visible);
		return ok;
	}
	
	

	// Select НДС
	/**
	 * empty - (Пустой) true -(Включено) false -(Без НДС)
	 */

	public SelenideElement ndsSelect(String text) {
		SelenideElement nds = $(By.xpath("//select[@class='vat']")).should(visible);
		nds.selectOptionByValue(text);
		return nds;
	}

	

}
