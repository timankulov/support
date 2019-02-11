package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

// Класс работы с почтовым ящиком через web интрефейс 
public class Gmail {
	public static ApplicationManager app;
    String url="https://mail.google.com/mail/u/0/h/1pq68r75kzvdr/";
    
    
	public Gmail() {
		app = new ApplicationManager();
	}
	
	
	public SelenideElement emailField() {
		return $(By.name("identifier")).shouldBe(visible);
	}

	public SelenideElement passwordField() {
		return $(By.name("password")).shouldBe(visible);
	}

	public SelenideElement nextBtn() {
		return $(By.id("identifierNext")).shouldBe(visible);
	}

	public SelenideElement nextPassBtn() {
		return $(By.id("passwordNext")).shouldBe(visible);
	}

	public ElementsCollection emails() {
		return $$(By.xpath("//input[@name='t']"));
	}

	public SelenideElement checkBox(int sizeEmails) {
		return $(By.xpath("//tbody/tr[" + sizeEmails + "]/td/input[@name='t']")).shouldBe(visible);
	}

	public SelenideElement okBtn() {
		return $(By.xpath("//input[@name='nvp_bbu_go']")).shouldBe(visible);
	}

	public SelenideElement delBtn() {
		return $(By.xpath("//input[@name='nvp_a_tr']")).shouldBe(visible);
	}

	public void openNewTab(String login, String password) {
		Selenide.executeJavaScript("window.open()");
		switchTo().window(1);
		open(url);
		emailField().setValue(login);
		nextBtn().click();
		passwordField().setValue(password);
		nextPassBtn().click();
		sleep(7000);
		System.out.println(emails().size());

		// switchTo().window(1).close();

	}

	public void clearGmail(String login, String password) {
		open(url);
		emailField().setValue(login);
		nextBtn().click();
		passwordField().setValue(password);
		nextPassBtn().click();
		okBtn();
		System.out.println(emails().size());
		int emailsCheckBox = emails().size();
		if (!emails().isEmpty()) {
			int i;
			for (i = 1; i <= emailsCheckBox; i++) {
				sleep(500);
				checkBox(i).click();
			}
		} 
        if (!emails().isEmpty())
		{
			delBtn().click();
		}

	}

}
