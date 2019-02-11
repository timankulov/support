package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Messages {
	public static ApplicationManager app;

	public Messages() {
		app = new ApplicationManager();
	}

	// TAB Просмотр истории сообщени...
	public SelenideElement tabCalendar() {
		return $(By.xpath("//*[@cuba-id='tab_sys$SendingMessage.browse']")).should(visible);
	}

	// Закрыть TAB Просмотр истории сообщени...
	public SelenideElement clouseTabCalendar() {
		return $(By.xpath("//*[@cuba-id='tab_sys$SendingMessage.browse']//span[text()='×']")).should(visible);
	}

	// Костыль для обхода email ####################
	// Выбрать из списка сообщений по очереди
	public SelenideElement linkMessageByNum(String id) {
		return $(By.xpath("//*[@class='v-table-table']//tr[" + id + "]")).should(visible);
	}

	// Клик Отобразить сообщение
	public SelenideElement btnShowMessage() {
		return $(By.xpath("//*[@cuba-id='WebButton']")).should(visible);
	}

	// Метод костыль обхода email
	public void notEmail() throws Exception {
		app.mainMenu().administrationButton().click();
		app.mainMenu().messageHistoryButton().click();
		// Выбрать первый пункт сообщений
		app.messages().linkMessageByNum("1").click();
		app.messages().btnShowMessage().click();
		switchTo().window(1);
		// Клик Электронная форма
		$(By.xpath("//a")).click();
		
		

	}

}
