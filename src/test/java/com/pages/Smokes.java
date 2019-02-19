package com.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.codeborne.selenide.Selenide;
import com.main.appmanager.ApplicationManager;

public class Smokes {
	public static ApplicationManager app;

	public Smokes() {
		app = new ApplicationManager();
	}

	Date today = new Date();
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");
	SimpleDateFormat SEC_FORMAT = new SimpleDateFormat(" -SS -");
	String date = DATE_FORMAT.format(today);
	String time = TIME_FORMAT.format(today);
	String sec = SEC_FORMAT.format(today);
	// Для --SMOKE
	private String nomen = "A";

	// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО отправка на склад
	// -- SMOKE
	// Найти заявку трегольники --
	public void sentQueryToStore(String urgent, String company, String division, String query, String nomen) {
		app.wprocess().linkClosed(urgent).click();
		app.wprocess().waitRefresh(company);
		app.wprocess().linkCompanySpan(company).click();
		app.wprocess().linkDevSpan(division).click();
		app.wprocess().linkQuerySpan(query).click();
		app.wprocess().linkQueryName(nomen).click();
		app.wprocess().btnSetQueryUsefulness().click();
		app.wprocess().btnDone().click();
		app.wprocess().btnRefresh().click();
		app.wprocess().linkQueryNameNotVisible(nomen);

	}

	// Номенклатурный конотроль (Целесообразность заявки) ГОТОВО отправка на склад
	// -- SMOKE (ТЕХЗАДАНИЕ)
	// Найти заявку трегольники --
	public void sentQueryToStoreTechTask(String urgent, String company, String division, String query) {
		app.wprocess().linkClosed(urgent).click();
		app.wprocess().waitRefresh(company);
		app.wprocess().linkCompanySpan(company).click();
		app.wprocess().linkDevSpan(division).click();
		app.wprocess().linkQuerySpan(query).click();
		app.wprocess().linkQueryName("Тех задание №1").doubleClick();
		sleep(2000);
		app.nomen().btnNomen().click();
		sleep(1000);
		app.query().nomenclatureByTextSpan("A").click();
		app.query().nomenclatureByTextWindow("A1").click();
		app.query().btnnomenclatureChoоse().click();
		app.wprocess().linkQueryName("Тех задание №2").doubleClick();
		sleep(2000);
		app.nomen().btnNomen().click();
		sleep(2000);
		app.query().nomenclatureByTextSpan("A").click();
		app.query().nomenclatureByTextWindow("A2").click();
		app.query().btnnomenclatureChoоse().click();
		app.wprocess().linkQueryName("Тех задание №3").doubleClick();
		sleep(2000);
		app.nomen().btnNomen().click();
		sleep(1000);
		app.query().nomenclatureByTextSpan("A").click();
		app.query().nomenclatureByTextWindow("A3").click();
		app.query().btnnomenclatureChoоse().click();
		app.wprocess().btnSetQueryUsefulness().click();
		app.wprocess().btnDone().click();
		app.wprocess().btnRefresh().click();
	}

	// Отправка снабженцам -- SMOKE
	// Найти заявку трегольники
	// Надо сдлеать выборку номенклатур всех как массив, преварительно записать в
	// JSON
	public void sentQueryToSup(String urgent, String company, String division, String query) {
		sleep(1000);
		app.wprocess().linkClosed(urgent).click();
		app.wprocess().waitRefresh(company);
		app.wprocess().linkCompanySpan(company).click();
		app.wprocess().linkDevSpan(division).click();
		app.wprocess().linkQuerySpan(query).click();
		actions().keyDown(Keys.CONTROL).perform();
		app.wprocess().linkQueryName("A1").click();
		// ПЕРЕДАТЬ ВЫДЛИТЬ ВСЕ!!!! .size()
		// linkQueryName("Перья рифлёные 1/16 кг.").click();
		// linkQueryName("Синхронизатор 5-4 пер. КПП ЯМЗ").click();
		actions().keyUp(Keys.CONTROL).perform();

	}
	
	
	// Отправка снабженцам -- SMOKE
		// Найти заявку трегольники
		// Надо сдлеать выборку номенклатур всех как массив, преварительно записать в
		// JSON
		public void sentQueryToStoreA(String urgent, String company, String division, String query) {
			app.wprocess().linkClosed(urgent).click();
			app.wprocess().waitRefresh(company);
			app.wprocess().linkCompanySpan(company).click();
			app.wprocess().linkDevSpan(division).click();
			app.wprocess().linkQuerySpan(query).click();
			actions().keyDown(Keys.CONTROL).perform();
			app.wprocess().linkQueryName("A1").click();
		 //   app.wprocess().linkQueryName("A2").click();
		  //  app.wprocess().linkQueryName("A3").click();
			actions().keyUp(Keys.CONTROL).perform();
			
		}
	
	
	
	
	
	

	// Выбор поставщика Закупочная комиссия -- SMOKE
	public void chooseQueryToSup(String urgent, String company, String division, String query) {
		sleep(5000);
		app.wprocess().linkClosed(urgent).click();
		app.wprocess().waitRefresh(company);
		app.wprocess().linkCompanySpan(company).click();
		app.wprocess().linkDevSpan(division).click();
		app.wprocess().linkQuerySpan(query).click();
		app.wprocess().linkQueryName("A1").doubleClick();
	}

	// Отправка снабженцам -- SMOKE nomenclatureByTextSpan
	// Найти заявку трегольники
	// Надо сдлеать выборку техзадание всех как массив, преварительно записать в
	// JSON
	public void sentQueryTechToSup(String urgent, String company, String division, String query) {
		app.wprocess().linkClosed(urgent).click();
		app.wprocess().waitRefresh(company);
		app.wprocess().linkCompanySpan(company).click();
		app.wprocess().linkDevSpan(division).click();
		app.wprocess().linkQuerySpan(query).click();
		actions().keyDown(Keys.CONTROL).perform();
		app.wprocess().linkQueryName("A1").click();
		app.wprocess().linkQueryName("A2").click();
		app.wprocess().linkQueryName("A3").click();
		actions().keyUp(Keys.CONTROL).perform();

	}

	// Заполнить форму новой заявки
	public void createNewQuerie(String num, String date, String time, String sysDate, String sysTime, String company,
			String unit, String storage, String contact, String process, String urgency, String origin, String base,
			String periodicity, String comment) {
		sleep(5000);
		app.query().queriesCreateBtn().waitUntil(visible, app.timeOut).click();
		app.query().numberQuerier("").click();
		app.query().numberQuerier(num);
		if (!date.equals("")) {
			app.query().dateQuerier(date);
		}
		if (!time.equals("")) {
			app.query().timeQuerier(time);
		}
		if (!sysDate.equals("")) {
			app.query().dateSysQuerier(sysDate);
		}
		if (!sysTime.equals("")) {
			app.query().timeSysQuerier(sysTime);
		}
		app.query().companyQuerier(company);
		app.query().unitQuerier(unit);
		app.query().storageQuerier(storage).pressEnter();
		app.query().contactQuerier(contact);
		app.query().processQuerier(process);
		app.query().urgencyQuerier(urgency);
		app.query().originQuerier(origin);
		app.query().baseQuerier(base);
		app.query().periodicityQuerier(periodicity);
		app.query().commentQuerier(comment);
	}

	// Создать номенклатуру (Заказ) НОМЕНКЛАТУРА
	public void createNomenclature(String nomenclature, String nomText, String text, String num, String comment,
			String number, String measure) {
		app.query().newBtnQuerier().click();
		app.query().stagesQuerier().doubleClick();
		app.query().tapyPositionsQuerier(nomenclature);
		app.query().nomenclatureBtn().click();
		if (!nomText.equals("")) {
			sleep(5000);
			app.query().nomenclatureByTextSpan(nomText).click();
		}
		app.query().nomenclatureByText(text).should(exist).click();
		app.query().btnnomenclatureChoоse().click();
		app.query().addNumbertnomenclature(number);
		app.query().measureUnit(measure);
		// КАК ПОФИКСЯТ РАССКОМЕНТИРОВАТЬ
		// addQuantitynomenclature(num);
		// sleep(1000);
		app.query().addCommentnomenclature(comment);
		app.query().btnOKChoоse().click();
		// btnInWork().click();
		// listQuantity().click();

	}

	// Создать (Заказ) ТЕХЗАДАНИЕ
	public void addNewTechTask(String techTask, String task, String num, String comment) {
		app.query().newBtnQuerier().click();
		app.query().stagesQuerier().doubleClick();
		app.query().tapyPositionsQuerier(techTask);
		app.query().addTechTask(task);
		app.query().addQuantitynomenclature(num);
		app.query().addCommentnomenclature(comment);
		app.query().btnOKChoоse().click();
	}

	// Найти заявку
	public void searchQuerier(String text) {
		app.query().searchQuerie(text);
		app.query().btnSearchQuerie().click();
		app.query().clickByText(text).should(exist).doubleClick();
		System.out.println(text);

	}

	// Создание заявки сотрудником и в работу --SMOKE НОМАНКЛАТУРА
	public void addNewQuery(String sotrudnik, String sotrudnik_password, String fileName, String data)
			throws Exception {
		createNewQuerie(app.data().getData(fileName, "numberQ"), "", "", "", "", app.data().getData(data, "company"),
				app.data().getData(data, "unit"), app.data().getData(data, "store"),
				app.data().getData(data, "contact") + " ", "Общий", "Сверхсрочная", "", "", "",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		// Создание стадии
		createNomenclature("Номенклатура", "A", "A1", "10",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"кг");

		/*
		 * app.query().createNomenclature("Номенклатура", "",
		 * "Синхронизатор 5-4 пер. КПП ЯМЗ", "5", "Комментарий авто-тест создал " +
		 * sotrudnik + " " + date + " Время создания " + time + "-" + sec, "", "шт");
		 * app.query().createNomenclature("Номенклатура", "ТМЦ",
		 * "Перья рифлёные 1/16 кг.", "1", "Комментарий авто-тест создал " + sotrudnik +
		 * " " + date + " Время создания " + time + "-" + sec, "", "шт");
		 */

		// В работу
		app.query().btnInWork();
		// Вернутся к списку заявок
		app.query().listQuantity().click();
		// Клики обновить
		app.query().refresh();
		app.query().findQueryPagination(app.data().getData(fileName, "numberQ"));
		// Проверка CSS цвет желтый
		// Selenide как то транно отработал!!!
		// app.query().clickByTextCSS(app.data().getData(className,
		// "numberQ")).shouldHave(cssClass("v-table-row-cs cs in-work-query
		// v-table-row-odd"));
		// v-table-row-cs cs in-work-query v-table-row
		// String css= app.query().clickByTextCSS(app.data().getData(fileName,
		// "numberQ")).getAttribute("class");
		// Assert.assertEquals(css, "v-table-row-cs cs in-work-query v-table-row
		// v-table-focus");

	}

	// Создание заявки сотрудником и в работу --SMOKE НОМАНКЛАТУРА
	public void addNewQueryGreen(String sotrudnik, String sotrudnik_password, String fileName, String data)
			throws Exception {
		createNewQuerie(app.data().getData(fileName, "numberQ"), "", "", "", "", app.data().getData(data, "company"),
				app.data().getData(data, "unit"), app.data().getData(data, "store"),
				app.data().getData(data, "contact") + " ", "Общий", "Сверхсрочная", "", "", "",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		// Создание стадии
		createNomenclature("Номенклатура", "A", "A1", "10",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"кг");
		createNomenclature("Номенклатура", "A", "A2", "5",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"шт");
		createNomenclature("Номенклатура", "A", "A3", "1",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"шт");
		// Сохранить
		app.query().saveBtnQuerier().click();
		app.query().refresh();
		app.query().findQueryPagination(app.data().getData(fileName, "numberQ"));
		// Проверка CSS цвет зеленый
		// Selenide как то транно отработал!!!
		// app.query().clickByTextCSS(app.data().getData(className,
		// "numberQ")).shouldHave(cssClass("v-table-row-cs cs in-work-query
		// v-table-row-odd"));

		// css= app.query().clickByTextCSS(app.data().getData(fileName,
		// "numberQ")).getAttribute("class");

		// Assert.assertEquals(css, "v-table-row-cs cs new-query v-table-row
		// v-table-focus v-selected");

	}

	// ############################

	// Создание заявки сотрудником и в работу --SMOKE НОМАНКЛАТУРА
	public void addNewQuery2(String sotrudnik, String sotrudnik_password, String fileName, String data)
			throws Exception {
		createNewQuerie(app.data().getData(fileName, "numberQ"), "", "", "", "", app.data().getData(data, "company"),
				app.data().getData(data, "unit"), app.data().getData(data, "store"),
				app.data().getData(data, "contact") + " ", "Общий", "Сверхсрочная", "", "", "",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		// Создание стадии
		createNomenclature("Номенклатура", "", "A", "10",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"кг");

		createNomenclature("Номенклатура", "", "Синхронизатор 5-4 пер. КПП ЯМЗ", "5",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"шт");
		createNomenclature("Номенклатура", "A", "A1", "10",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
				"шт");
		// В работу
		app.query().btnInWork();
		// Вернутся к списку заявок
		app.query().listQuantity().click();
		// Клики обновить
		app.query().refresh();
		app.query().findQueryPagination(app.data().getData(fileName, "numberQ"));
	}

	
	// Создание заявки сотрудником и в работу --SMOKE НОМАНКЛАТУРА для Отказа
		public void addNewQuery3(String sotrudnik, String sotrudnik_password, String fileName, String data)
				throws Exception {
			createNewQuerie(app.data().getData(fileName, "numberQ"), "", "", "", "", app.data().getData(data, "company"),
					app.data().getData(data, "unit"), app.data().getData(data, "store"),
					app.data().getData(data, "contact") + " ", "Общий", "Сверхсрочная", "", "", "",
					"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
			// Создание стадии
			createNomenclature("Номенклатура", "A", "A1", "10",
					"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
					"кг");

			createNomenclature("Номенклатура", "A", "A2", "5",
					"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
					"шт");
			createNomenclature("Номенклатура", "A", "A3", "10",
					"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec, "",
					"шт");
			// В работу
			app.query().btnInWork();
			// Вернутся к списку заявок
			app.query().listQuantity().click();
			// Клики обновить
			app.query().refresh();
			app.query().findQueryPagination(app.data().getData(fileName, "numberQ"));
		}

		
	
	
	
	// ###########################
	// ТЕХЗАДАНИЕ -- SMOKE
	// Создание заявки сотрудником ТехЗадание
	public void addNewQueryTechTask(String sotrudnik, String sotrudnik_password, String fileName, String data)
			throws Exception {
		createNewQuerie(app.data().getData(fileName, "numberQ"), "", "", "", "", app.data().getData(data, "company"),
				app.data().getData(data, "unit"), app.data().getData(data, "store"),
				app.data().getData(data, "contact") + " ", "Общий", "Сверхсрочная", "", "", "",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		// Создание техзадания
		addNewTechTask("Техзадание", "Тех задание №1", "2",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		addNewTechTask("Техзадание", "Тех задание №2", "3",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		addNewTechTask("Техзадание", "Тех задание №3", "4",
				"Комментарий авто-тест создал " + sotrudnik + " " + date + " Время создания " + time + "-" + sec);
		// В работу
		app.query().btnInWork();
		// Вернутся к списку заявок
		app.query().listQuantity().click();
		// Клики обновить
		app.query().refresh();
		app.query().findQueryPagination(app.data().getData(fileName, "numberQ"));

	}

	// ###########################
	// Отмена заявки -- SMOKE

	// Номенклатурный конотроль Отмена заявки
	// -- SMOKE 
	// Найти заявку трегольники --
	public void sentQueryReject(String urgent, String company, String division, String query) {
		app.wprocess().linkClosed(urgent).click();
		app.wprocess().waitRefresh(company);
		app.wprocess().linkCompanySpan(company).click();
		app.wprocess().linkDevSpan(division).click();
		app.wprocess().linkQuerySpan(query).click();
		actions().keyDown(Keys.CONTROL).perform();
		app.wprocess().linkQueryName("A1").click();
		app.wprocess().linkQueryName("A2").click();
		app.wprocess().linkQueryName("A3").click();
		actions().keyUp(Keys.CONTROL).perform();
		app.wprocess().btnCancel().click();
		// Форма отказа 
		app.store().returnNomen("Автотест");
	
		
		
	}

	
	
	
	
	
	
	
	// ########################

	// Выбор заявки --SMOKE
	public void getQuery() throws Exception {
		// Срочность
		app.bills().linkQueryBill("Сверхсрочная").click();
		// Выбрать компанию
		app.bills().linkQueryBill("Тестовая Компания 1").click();
		// Выбрать подразделение
		app.bills().linkQueryBill("Подразделение Тестовой Компании 1").click();
		// Заявка
		app.bills().linkQueryBill(app.data().getData("Query1.json", "numberQ")).click();
		// Выбрать поставщика
		app.bills().getSupp("Тестовый поставщик 1").click();
	}

	// ########################
	// Создание счета до логистики --SMOKE
	public void crtBill() throws Exception {
		app.bills().numberQuerier(app.data().getData("Query1.json", "login"));
		app.bills().timePayment(date);
		// amount("150");
		app.bills().billsDs_supplier("");
		app.bills().billsDs_company("");
		app.bills().file("\\bills\\test.pdf");
		app.bills().okBtn().click();
		app.bills().newBillLink(app.data().getData("Query1.json", "login")).click();
		app.bills().attachBillBtn().click();
		app.wprocess().btnDone().click();
		// переход в логистику
		app.wprocess().linkLogistic().click();
		sleep(10000);
		// Свернуть
		app.wprocess().btnCollapseAll();
		// Выбрать поставшика в логистике
		app.logist().linkByTextLogist("Тестовый поставщик 1").doubleClick();
		sleep(2000);
		app.logist().linkByTextLogist("Тестовая Компания 1").doubleClick();
		sleep(2000);
		app.logist().linkByTextLogist("Подразделение Тестовой Компании 1").doubleClick();
		sleep(2000);
		app.logist().linkByTextLogist(app.data().getData("Query1.json", "login")).doubleClick();
		app.logist().linkByTextLogist("A1").click();
		// Готово
		sleep(5000);
		app.wprocess().btnDone().click();
		sleep(5000);
		// Кнопка Да
		app.logist().yesBtn().click();
		sleep(5000);

	}

	// Выбрать поставщиков -- SMOKE один поставщик
	public void addSupSend() {
		app.wprocess().linkSupSelection().click();
		app.supp().btnSuppliers().click();
		sleep(1000);
		app.supp().chooseSupp("Тестовый поставщик 1");
		sleep(1000);
		app.supp().chooseSupp("Тестовый поставщик 2");
		sleep(1000);
		app.supp().chooseSupp("Тестовый поставщик 3");
		sleep(3000);
		app.supp().btnAddSup().click();
		sleep(1000);
		app.supp().btnMessage().click();
		sleep(1000);
		app.supp().btnClose().click();
		// Сообщение - проверка - доделать " Отправлены запросы по позициям " а пока sleep
		sleep(5000);

	}

	// Добавление данных к web форме SMOKE
	public void openNewTabWebForm(String urlWebForm) {
		Selenide.executeJavaScript("window.open()");
		switchTo().window(1);
		Selenide.open(urlWebForm);
		// webFormField("Сетка С-2", "2", "Аналог тест");
	//	Было КГ
	//	app.webform().webFormField(nomen, "5", "50");
		app.webform().webFormField(nomen, "6", "3");
		app.webform().webFormField(nomen, "7", "120");
		app.webform().webFormField(nomen, "8", "1");
		app.webform().webFormField(nomen, "9", "2");
			app.webform().webFormField(nomen, "10", "Алрес ---");
		app.webform().webFormField(nomen, "11", "Производитель SONY");
		
		// Эти поля убрали
	//	app.webform().webFormField(nomen, "10", "1");
	//	app.webform().webFormField(nomen, "11", "15");
	//	app.webform().webFormField(nomen, "12", "Комментарий автотест Smoke Сетка С-2");
		app.webform().ndsSelect("false");
		app.webform().save().click();
		app.webform().okBtn().click();
		Selenide.executeJavaScript("window.close()");
		switchTo().window(0);
	}

}
