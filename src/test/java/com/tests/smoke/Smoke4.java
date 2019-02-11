package com.tests.smoke;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;
import com.base.common.BaseTest;

public class Smoke4 extends BaseTest {

	// Создание заявки Номенклватура - отказ от заявки  
	
	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, priority = 1)
	// Создание заявки сотрудником
	public void smoke1(String sotrudnik, String sotrudnik_password) throws Exception {
		// Создаем данные для теста
		app.data().createDataJSON("Query5.json");
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		app.mainMenu().queriesButton().click();
		app.mainMenu().supplyQueryeButton().click();
		// Передача у работу (Желтый)
		app.smokes().addNewQuery3(sotrudnik, sotrudnik_password, "Query5.json", "Db_info.json");
		// Выход
		app.login().logOut();

	}

	@Parameters({ "nomenklatura", "nomenklatura_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke1" }, priority=2)
	// Отказ заявки
	public void smoke2(String nomenklatura, String nomenklatura_password) throws Exception {
		// Логин
		app.login().login(nomenklatura, nomenklatura_password);
		// Номенклатурный конотроль ОТКАЗ
		app.smokes().sentQueryReject("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query5.json", "numberQ"));
		// Выход
		app.login().logOut();
	}
	
	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke2" }, priority = 3)
	// Проверка Отказа
	public void smoke3(String sotrudnik, String sotrudnik_password) throws Exception {
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		// Клик на Заявки
		app.mainMenu().queriesButton().click();
		// Клик на Заявки Под меню
		app.mainMenu().supplyQueryeButton().click();
		// Найти и открыть возвращенную заявку	
		sleep(10000);
		app.query().nomenclatureByText(app.data().getData("Query5.json", "numberQ")).doubleClick();
		sleep(10000);
		app.query().clickByTextOpenQuery("A1", 4).waitUntil(exist, app.timeOut).click();
			int i;
			for (i = 3; i <= 9; i++) {
		app.query().clickByTextOpenQuery("A1", i).waitUntil(exist, app.timeOut).click();
				
			}
		app.query().clickByTextOpenQuery("A1", 12).waitUntil(exist, app.timeOut).shouldHave(exist, text("Отказ : Автотест"));
		app.query().clickByTextOpenQuery("A2", 12).waitUntil(exist, app.timeOut).shouldHave(exist, text("Отказ : Автотест"));
		app.query().clickByTextOpenQuery("A3", 12).waitUntil(exist, app.timeOut).shouldHave(exist, text("Отказ : Автотест"));
		// Вернутся ск списку заявок 
		app.query().listQuantity().click();
			// Создаем данные для теста
			app.data().createDataJSON("Query5.json");
			// Передача у работу (Желтый) Создать новыю заявку
			app.smokes().addNewQuery3(sotrudnik, sotrudnik_password, "Query5.json", "Db_info.json");
			// Выход
			app.login().logOut();
		}



	@Parameters({ "nomenklatura", "nomenklatura_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke3" },   priority=3)
	// Перевод заявки на склад
	public void smoke4(String nomenklatura, String nomenklatura_password) throws Exception {
		// Логин
		app.login().login(nomenklatura, nomenklatura_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		app.smokes().sentQueryToStoreA("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
		app.data().getData("Query5.json", "numberQ"));
		app.wprocess().btnSetQueryUsefulness().click();
		app.wprocess().btnDone().click();
		app.wprocess().btnRefresh().click();
		app.wprocess().linkQueryNameNotVisible(app.data().getData("Query5.json", "numberQ"));

		// Выход
		app.login().logOut();
	}
		

	@Parameters({ "sklad", "sklad_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke4" },   priority=4)
	// Перевод заявки после склада
	public void smoke5(String sklad, String sklad_password) throws Exception {
		// Логин
		app.login().login(sklad, sklad_password);
		// Склад ОТКАЗ
				app.smokes().sentQueryReject("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
						app.data().getData("Query5.json", "numberQ"));
				// Выход
				app.login().logOut();
	}
		
		
		
}
	
	
	
	
	
	
	
	

	
	
	


