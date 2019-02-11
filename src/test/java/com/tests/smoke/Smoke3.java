package com.tests.smoke;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.common.BaseTest;

public class Smoke3 extends BaseTest {

	// Создание заявки ТехЗадание 
	
	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, priority = 1)
	// Создание заявки сотрудником
	public void smoke1(String sotrudnik, String sotrudnik_password) throws Exception {
		// Создаем данные для теста
		app.data().createDataJSON("Query4.json");
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		app.mainMenu().queriesButton().click();
		app.mainMenu().supplyQueryeButton().click();
		// Передача у работу (Желтый)
		app.smokes().addNewQueryTechTask(sotrudnik, sotrudnik_password, "Query4.json", "Db_info.json");
		// Выход
		app.login().logOut();

	}

	@Parameters({ "nomenklatura", "nomenklatura_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke1" }, priority=2)
	// Перевод заявки на склад
	public void smoke2(String nomenklatura, String nomenklatura_password) throws Exception {
		// Логин
		app.login().login(nomenklatura, nomenklatura_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		app.smokes().sentQueryToStoreTechTask("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query4.json", "numberQ"));
		// Выход
		app.login().logOut();
	}
	
	@Parameters({ "sklad", "sklad_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke2" }, priority=3)
	// Перевод заявки после склада
	public void smoke3(String sklad, String sklad_password) throws Exception {
		// Логин
		app.login().login(sklad, sklad_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		/// Доделать выбор всех номеклатур из файла JSON массивом
		app.smokes().sentQueryTechToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query4.json", "numberQ"));
		app.wprocess().btnDone().click();
		// Выход
		app.login().logOut();
	}

}
