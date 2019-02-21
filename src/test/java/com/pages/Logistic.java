package com.pages;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Logistic {
	public static ApplicationManager app;


	public Logistic() {
		app = new ApplicationManager();
	}

//Раскрывающиеся списки	
// ###########################
		// Выбрать по тексту Компания, Поставщик (Треугольник) 
		public SelenideElement linkByTextLogist(String text) {		
			//return $(By.xpath("//div[@cuba-id='WebLabel']/b[contains(text(),'"+text+"')]/../../span")).waitUntil(disappear, app.timeOut);
			return $(By.xpath("//*[text()='"+text+"']")).waitUntil(exist, app.timeOut);
		}	
// ###########################
	
//Раскрывающиеся списки
// ###########################
		// Выбрать по тексту Компания, Поставщик (Треугольник) 
		public SelenideElement linkByTextNomen(String text) {		
			return $(By.xpath("//div[@cuba-id='WebLabel' and text()='"+text+"']")).waitUntil(disappear, app.timeOut);
		}
// ###########################
		
		
		
	
		
		
// PopUp Да 
		public SelenideElement yesBtn() {		
			return $(By.xpath("//div[@cuba-id='optionDialog_yes']")).waitUntil(exist, app.timeOut);
		}
		
		
// PopUp Нет
		public SelenideElement noBtn() {		
			return $(By.xpath("//div[@cuba-id='optionDialog_no']")).waitUntil(exist, app.timeOut);
		}
		
// ###########################	
		
		
		
		


}
