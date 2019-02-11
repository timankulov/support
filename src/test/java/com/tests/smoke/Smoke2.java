package com.tests.smoke;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.common.BaseTest;

public class Smoke2 extends BaseTest {

	// Возврат на Номенклатурный контроль
	
	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, priority = 1)
	// Создание заявки сотрудником
	public void smoke1(String sotrudnik, String sotrudnik_password) throws Exception {
		// Создаем данные для теста
		app.data().createDataJSON("Query3.json");
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		app.mainMenu().queriesButton().click();
		app.mainMenu().supplyQueryeButton().click();
		// Передача у работу (Желтый)
		app.smokes().addNewQuery2(sotrudnik, sotrudnik_password, "Query3.json", "Db_info.json");
		// Выход
		app.login().logOut();

	}

	@Parameters({ "nomenklatura", "nomenklatura_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke1" }, priority = 2)
	// Перевод заявки на склад
	public void smoke2(String nomenklatura, String nomenklatura_password) throws Exception {
		// Логин
		app.login().login(nomenklatura, nomenklatura_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		app.smokes().sentQueryToStore("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query3.json", "numberQ"), "Сетка С-2");
		// Выход
		app.login().logOut();

	}

	@Parameters({ "sklad", "sklad_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke2" }, priority = 3)
	// Возврат заявки назад из склада
	public void smoke3(String sklad, String sklad_password) throws Exception {
		// Логин
		app.login().login(sklad, sklad_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		/// Доделать выбор всех номеклатур из файла JSON массивом
		app.smokes().sentQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query3.json", "numberQ"));
		// Клик список возврата
		app.store().btnReturn("Номенклатурный контроль");
		app.store().returnNomen("Автотест");
		// Выход
		app.login().logOut();
	}

	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke3" }, priority = 4)
	// Проверка возврата
	public void smoke4(String sotrudnik, String sotrudnik_password) throws Exception {
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		// Клик на Заявки
		app.mainMenu().queriesButton().click();
		// Клик на Заявки Под меню
		app.mainMenu().supplyQueryeButton().click();
		// Найти и открыть возвращенную заявку	
		sleep(10000);
		app.query().nomenclatureByText(app.data().getData("Query3.json", "numberQ")).doubleClick();		
		sleep(5000);
		if (!app.query().clickByTextOpenQuery("Сетка С-2", 12).isDisplayed()) {
			
			int i;
			for (i = 4; i <= 12; i++) {
			app.query().clickByTextOpenQuery("Сетка С-2", i).waitUntil(exist, app.timeOut).click();
			
			if (app.query().clickByTextOpenQuery("Сетка С-2", 12).isDisplayed())
				
			{
				break;
			}
	}

		app.query().clickByTextOpenQuery("Сетка С-2", 12).waitUntil(exist, app.timeOut).shouldHave(exist, text("Возврат на Номенклатурный контроль : Автотест"));
		// Выход
		app.login().logOut();

	} }

}
