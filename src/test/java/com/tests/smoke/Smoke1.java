package com.tests.smoke;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.common.BaseTest;

public class Smoke1 extends BaseTest {
	
  // Сознаие заявки и прогон её по всем этапам до стартуса (Выполнено)
	
	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, priority=1)
	// Создание заявки сотрудником
	public void smoke1(String sotrudnik, String sotrudnik_password) throws Exception {
		// Создаем данные для теста
		app.data().createDataJSON("Query1.json");
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		app.mainMenu().queriesButton().click();
		app.mainMenu().supplyQueryeButton().click();
		// Передача у работу (Желтый)
		app.smokes().addNewQuery(sotrudnik, sotrudnik_password, "Query1.json", "Db_info.json");
		// Выход
		app.login().logOut();

	}

	@Parameters({ "nomenklatura", "nomenklatura_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke1" },  priority=2)
	// Перевод заявки на склад
	public void smoke2(String nomenklatura, String nomenklatura_password) throws Exception {
		// Логин
		app.login().login(nomenklatura, nomenklatura_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		app.smokes().sentQueryToStore("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query1.json", "numberQ"), "A1");
		// Выход
		app.login().logOut();
	}

	@Parameters({ "sklad", "sklad_password" })
	@Test(groups = { "smoke" },  dependsOnMethods = { "smoke2" }, priority=3)
	// Перевод заявки после склада
	public void smoke3(String sklad, String sklad_password) throws Exception {
		// Логин
		app.login().login(sklad, sklad_password);
		// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО перевод на склад
		/// Доделать выбор всех номеклатур из файла JSON массивом
		app.smokes().sentQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query1.json", "numberQ"));
		app.wprocess().btnDone().click();
		// Выход
		app.login().logOut();
	}

	@Parameters({ "snabjenec", "snabjenec_password" })
	@Test(groups = { "smoke" },  dependsOnMethods = { "smoke3" }, priority=4)
	public void smoke4(String snabjenec, String snabjenec_password) throws Exception {
		// Подбор поставщиков
		// Логин
		app.login().login(snabjenec, snabjenec_password);
		// Подбор поставщиков
		app.wprocess().linkSupSelection().click();
		// Выбрать заявки
		app.smokes().sentQueryToSup("Сверхсрочная", app.data().getData("Db_info.json", "company"),
				app.data().getData("Db_info.json", "unit"), app.data().getData("Query1.json", "numberQ"));
		// Отправка поставщикам
		app.smokes().addSupSend();
		// Выход
		app.login().logOut();
		
	}
	
	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke4" }, priority=5)
	// Создание заявки сотрудником (Для экономии времени-- джем email) НОАВЯ ЗАЯВКА (Зеленый)
	public void smoke5(String sotrudnik, String sotrudnik_password) throws Exception {
		// Создаем данные для теста
		app.data().createDataJSON("Query2.json");
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		app.mainMenu().queriesButton().click();
		app.mainMenu().supplyQueryeButton().click();
		// Передача у работу (Зеленый)
		app.smokes().addNewQueryGreen(sotrudnik, sotrudnik_password, "Query2.json", "Db_info.json");
		// Выход
		app.login().logOut();
	
	}

	@Parameters({ "postavshik1", "postavshik2", "postavshik3", "email_password", "snabjenec", "snabjenec_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke5" }, priority=6)
	// Перевод заявки после склада - заполние web формы
	public void smoke6(String postavshik1, String postavshik2, String postavshik3, String email_password,
			String snabjenec, String snabjenec_password) throws Exception {		
		sleep(20000);
		// Ждать почту 
		app.getEmail().waitMail(postavshik1, email_password);
		app.getEmail().waitMail(postavshik2, email_password);
		app.getEmail().waitMail(postavshik3, email_password);		

		// Получить ссылку из письма 3 поставщика
		app.smokes().openNewTabWebForm(app.getEmail().getMails(postavshik1, email_password));
		app.smokes().openNewTabWebForm(app.getEmail().getMails(postavshik2, email_password));
		app.smokes().openNewTabWebForm(app.getEmail().getMails(postavshik3, email_password));
		// Логин снабженец
		sleep(5000);
		app.login().login(snabjenec, snabjenec_password);
		app.smokes().sentQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query1.json", "numberQ"));
		// Проверяем что есть поставщик 1 который заполнил web форму
		app.supp().getSupplyers("3/3");
		// Отправка на ценовую аналитику
		app.wprocess().btnDone().click();
		// Открыть ценовую аналитику
		sleep(5000);
		app.wprocess().linkAnalysis().click();
		// Обновить
		app.wprocess().btnRefresh();
		// Найти нашу заявку
		app.smokes().sentQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1",
				app.data().getData("Query1.json", "numberQ"));
		// Отправка на закупочную комиссию
		app.wprocess().btnDone().click();
		// Выход
		app.login().logOut();

	}

	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke6" }, priority=7)
	// Перевод заявки закупочную комиссю и голосование #1
	public void smoke7(String sotrudnik, String sotrudnik_password) throws Exception {
		// Логин админ
		app.login().login(sotrudnik, sotrudnik_password);
		// Перейти на закупочную комиссию
		app.wprocess().linkComission().click();
		// Найти заявку Закупочной комиссии
		app.smokes().chooseQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1", app.data().getData("Query1.json", "numberQ"));
		// Выбрать поставщик в закупочной комиссии одн поставщик
		app.pComm().supplier("Тестовый поставщик 1").click();
        // Кнопка Выбрать и PopUp 
		app.pComm().supplierBtn();		
		// Выход
		app.login().logOut();

	}

	@Parameters({ "nomenklatura", "nomenklatura_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke7" }, priority=8)
	// Перевод заявки закупочную комиссю и голосование #2
	public void smoke8(String nomenklatura, String nomenklatura_password) throws Exception {
		// Логин
		app.login().login(nomenklatura, nomenklatura_password);
		// Перейти на закупочную комиссию
				app.wprocess().linkComission().click();
				// Найти заявку Закупочной комиссии
				app.smokes().chooseQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1", app.data().getData("Query1.json", "numberQ"));
				// Выбрать поставщик в закупочной комиссии одн поставщик
				app.pComm().supplier("Тестовый поставщик 1").click();
		        // Кнопка Выбрать и PopUp 
				app.pComm().supplierBtn();		
				// Выход
				app.login().logOut();
	
	}
		
	@Parameters({ "sklad", "sklad_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke8" }, priority=9)
	// Перевод заявки закупочную комиссю и голосование #3
	public void smoke9(String sklad, String sklad_password) throws Exception {
		// Логин
		app.login().login(sklad, sklad_password);
		// Перейти на закупочную комиссию
		app.wprocess().linkComission().click();
		// Найти заявку Закупочной комиссии
		app.smokes().chooseQueryToSup("Сверхсрочная", "Тестовая Компания 1", "Подразделение Тестовой Компании 1", app.data().getData("Query1.json", "numberQ"));
		// Выбрать поставщик в закупочной комиссии один поставщик
		app.pComm().supplier("Тестовый поставщик 1").click();
        // Кнопка Выбрать и PopUp 
		app.pComm().supplierBtn();		
		// Выход
		app.login().logOut();
	}

	
	
	@Parameters({ "snabjenec", "snabjenec_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke9" }, priority=10)
	public void smoke10(String snabjenec, String snabjenec_password) throws Exception {
		// Создание счета
		// Логин
		app.login().login(snabjenec, snabjenec_password);
	   // Клик Счета
		app.wprocess().linkBills().click();
		// Светнуть все клик Кнопка
		app.wprocess().btnCollapseAll();
		
		// Выбрать нашу заявку для создания счета
		app.smokes().getQuery();
		//Клик создание счета
		app.bills().crtBillBtn().click();
		// Создать счет
		app.smokes().crtBill();
		// Выход
		app.login().logOut();

	}
	
	

	@Parameters({ "sotrudnik", "sotrudnik_password" })
	@Test(groups = { "smoke" }, dependsOnMethods = { "smoke10" }, priority=10)
	// Проверка Заявки
	public void smoke11(String sotrudnik, String sotrudnik_password) throws Exception {
		// Логин
		app.login().login(sotrudnik, sotrudnik_password);
		app.mainMenu().queriesButton().click();
		app.mainMenu().supplyQueryeButton().click();
		// Проверяем наличие заявки
		sleep(10000);
		app.wprocess().linkQueryName(app.data().getData("Query1.json", "numberQ")).should(visible).doubleClick();
		sleep(1000);
		app.query().getDoneQueryStatus("Выполнено");
		sleep(1000);

	}
	
	
}
