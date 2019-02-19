package com.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;


public class Query {
	public static ApplicationManager app;

	public Query() {
		app = new ApplicationManager();
	}

	

	// TAB Заявка
	public SelenideElement measureNomenTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Query.browse']")).should(visible);
	}

	// Закрыть TAB Заявки
	public SelenideElement clouseTAB() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Query.browse']//span[text()='×']")).should(visible);
	}

	// Кнопка создать заявку
	public SelenideElement queriesCreateBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).waitUntil(exist, app.timeOut);
	}

	// Кнопка Изменить
	public SelenideElement queriesEditBtn() {
		return $(By.xpath("//*[@cuba-id='editBtn']")).should(visible);
	}

	// Кнопка обновить
	public SelenideElement queriesRefreshBtn() {
		return $(By.xpath("//*[@cuba-id='refreshBtn']")).waitUntil(visible, app.timeOut);
	}

	// Кнопка Удалить
	public SelenideElement queriesRemoveBtn() {
		return $(By.xpath("//*[@cuba-id='removeBtn']")).should(visible);
	}

	// Кнопка excel
	public SelenideElement queriesExcelBtn() {
		return $(By.xpath("//*[@cuba-id='excelBtn']")).should(visible);
	}

	// Кнопка В работу список заявок вверх
	public SelenideElement queriesTo_WorkBtn() {
		return $(By.xpath("//*[@cuba-id='to_work']")).should(visible);
	}

	// Поля формы
	// Номер
	public SelenideElement numberQuerier(String num) {
		sleep(1000);
		return $(By.xpath("//*[@cuba-id='number']")).waitUntil(exist, app.timeOut).setValue(num);
	}

	// Дата Создания формат (01.01.2019)
	public SelenideElement dateQuerier(String date) {
		return $(By.xpath("//*[@cuba-id='timeCreation']/div/div/input")).should(visible).setValue(date);
	}

	// Дата Создания Кнопка календаря
	public SelenideElement dateQuerierCalendar() {
		return $(By.xpath("//*[@cuba-id='timeCreation']/div/div/button")).should(visible);
	}

	// Время создания поле время формат (00:00)
	public SelenideElement timeQuerier(String time) {
		return $(By.xpath("//*[@cuba-id='timeCreation']/div/input")).should(visible).setValue(time);
	}

	// Время создания (системное) Дата формат (01.01.2019)
	public SelenideElement dateSysQuerier(String date) {
		return $(By.xpath("//*[@cuba-id='createTs']/div/div/input")).should(visible).setValue(date);
	}

	// Время создания (системное) Кнопка календаря
	public SelenideElement btnCalendar() {
		return $(By.xpath("//*[@cuba-id='createTs']/div/div/button")).should(visible);
	}

	// Время создания (системное) поле время формат (00:00)
	public SelenideElement timeSysQuerier(String time) {
		return $(By.xpath("//*[@cuba-id='createTs']/div/input")).should(visible).setValue(time);
	}

	// ЧекБокс Обработка заявки целиком
	public SelenideElement queryWorkout() {
		return $(By.xpath("//*[@cuba-id='wholeQueryWorkout']/input")).should(visible);
	}

	// Кнопка 1 выбор компании
	public SelenideElement btnCompany() {
		return $(By.xpath("//*[@cuba-id='company']/div/div/div[@role='button']")).should(visible);
	}

	// Кнопка 2 выбор компании
	public SelenideElement btnCompanyLookup() {
		return $(By.xpath("//*[@cuba-id='company']//div[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка 3 выбор компании
	public SelenideElement btnCompanyClear() {
		return $(By.xpath("//*[@cuba-id='company']//div[@cuba-id='clear']")).should(visible);
	}

	// Компания Поле
	public SelenideElement companyQuerier(String company) {
		SelenideElement companyQuerier = $(By.xpath("//*[@cuba-id='company']/div/div/input")).should(visible);
		companyQuerier.sendKeys(Keys.CONTROL, "a");
		companyQuerier.sendKeys(Keys.BACK_SPACE);
		companyQuerier.setValue(company);
		sleep(1000);
		
		$(By.xpath("//span[contains(.,'"+company+"')]")).waitUntil(visible, app.timeOut).click();
		
	//	$(By.xpath("//span[text()='" + company + "']")).waitUntil(visible, app.timeOut).click();
		return companyQuerier;
	}

	// Кнопка 1 выбор Подразделение
	public SelenideElement btnDivision() {
		return $(By.xpath("//*[@cuba-id='division']/div/div/div[@role='button']")).should(visible);
	}

	// Кнопка 2 выбор Подразделение
	public SelenideElement btnDivisionLookup() {
		return $(By.xpath("//*[@cuba-id='division']//div[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка 3 выбор Подразделение
	public SelenideElement btnDivisionClear() {
		return $(By.xpath("//*[@cuba-id='division']//div[@cuba-id='clear']")).should(visible);
	}

	// Поле подраздеоение
	public SelenideElement unitQuerier(String unit) {
		SelenideElement unitQuerier = $(By.xpath("//*[@cuba-id='division']/div/div/input")).should(visible);
		unitQuerier.sendKeys(Keys.CONTROL, "a");
		unitQuerier.sendKeys(Keys.BACK_SPACE);
		unitQuerier.setValue(unit);
		sleep(1000);
		$(By.xpath("//span[contains(.,'"+unit+"')]")).waitUntil(visible, app.timeOut).click();
		//$(By.xpath("//span[text()='" + unit + "']")).waitUntil(exist, app.timeOut).click();
		return unitQuerier;
	}

	// Кнопка 1 выбор Склад
	public SelenideElement btnStore() {
		return $(By.xpath("//*[@cuba-id='store']/div/div/div[@role='button']")).should(visible);
	}

	// Кнопка 2 выбор Склад
	public SelenideElement btnStoreLookup() {
		return $(By.xpath("//*[@cuba-id='store']//div[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка 3 выбор Склад
	public SelenideElement btnStoreClear() {
		return $(By.xpath("//*[@cuba-id='store']//div[@cuba-id='clear']")).should(visible);
	}

	// Поле склад
	public SelenideElement storageQuerier(String storage) {
		SelenideElement storageQuerier = $(By.xpath("//*[@cuba-id='store']/div/div/input")).should(visible);
		storageQuerier.sendKeys(Keys.CONTROL, "a");
		storageQuerier.sendKeys(Keys.BACK_SPACE);
		storageQuerier.setValue(storage);
		sleep(1000);
		$(By.xpath("//span[contains(.,'"+storage+"')]")).waitUntil(visible, app.timeOut).click();
		
		//$(By.xpath("//span[text()='" + storage + "']")).waitUntil(visible, app.timeOut).click();
		return storageQuerier;
	}

	// Кнопка 1 выбор Контакт
	public SelenideElement btnСontact() {
		return $(By.xpath("//*[@cuba-id='contact']/div/div/div[@role='button']")).should(visible);
	}

	// Кнопка 2 выбор Контакт
	public SelenideElement btnСontactLookup() {
		return $(By.xpath("//*[@cuba-id='contact']//div[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка 3 выбор Контакт
	public SelenideElement btnСontactClear() {
		return $(By.xpath("//*[@cuba-id='contact']//div[@cuba-id='clear']")).should(visible);
	}

	// Поле контакт
	public SelenideElement contactQuerier(String contact) {
		SelenideElement contactQuerier = $(By.xpath("//*[@cuba-id='contact']/div/div/input")).should(visible);
		if (!contact.equals("")) {
			contactQuerier.sendKeys(Keys.CONTROL, "a");
			contactQuerier.sendKeys(Keys.BACK_SPACE);
			contactQuerier.setValue(contact);
			sleep(1000);
			
			//$(By.xpath("//*[@class='gwt-MenuItem gwt-MenuItem-selected']")).waitUntil(visible, app.timeOut).click();
			
			$(By.xpath("//span[contains(.,'"+contact+"')]")).waitUntil(visible, app.timeOut).click();
			
			//$(By.xpath("//span[text()='" + contact + "']")).waitUntil(visible, app.timeOut).click();
		}
		return contactQuerier;
	}

	// Кнопка 1 выбор Рабочий процесс
	public SelenideElement btnWorkflow() {
		return $(By.xpath("//*[@cuba-id='workflow']/div/div/div[@role='button']")).should(visible);
	}

	// Кнопка 2 выбор Рабочий процесс
	public SelenideElement btnWorkflowLookup() {
		return $(By.xpath("//*[@cuba-id='workflow']//div[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка 3 выбор Рабочий процесс
	public SelenideElement btnWorkflowClear() {
		return $(By.xpath("//*[@cuba-id='workflow']//div[@cuba-id='clear']")).should(visible);
	}

	// Поле Рабочий процесс
	public SelenideElement processQuerier(String process) {
		SelenideElement processQuerier = $(By.xpath("//*[@cuba-id='workflow']/div/div/input")).should(visible);
		processQuerier.sendKeys(Keys.CONTROL, "a");
		processQuerier.sendKeys(Keys.BACK_SPACE);
		processQuerier.setValue(process);
		sleep(1000);
		
		$(By.xpath("//span[contains(.,'"+process+"')]")).waitUntil(visible, app.timeOut).click();
		
	//	$(By.xpath("//span[text()='" + process + "']")).waitUntil(visible, app.timeOut).click();
		return processQuerier;
	}

	// Кнопка 1 выбор Срочность
	public SelenideElement btnUrgency() {
		return $(By.xpath("//*[@cuba-id='urgency']/div/div/div[@role='button']")).should(visible);
	}

	// Кнопка 2 выбор Срочность
	public SelenideElement btnUrgencyLookup() {
		return $(By.xpath("//*[@cuba-id='urgency']//div[@cuba-id='lookup']")).should(visible);
	}

	// Кнопка 3 выбор Строчность
	public SelenideElement btnUrgencyClear() {
		return $(By.xpath("//*[@cuba-id='urgency']//div[@cuba-id='clear']")).should(visible);
	}

	// Поле Срочность
	public SelenideElement urgencyQuerier(String urgency) {
		SelenideElement urgencyQuerier = $(By.xpath("//*[@cuba-id='urgency']/div/div/input")).should(visible);
		urgencyQuerier.sendKeys(Keys.CONTROL, "a");
		urgencyQuerier.sendKeys(Keys.BACK_SPACE);
		urgencyQuerier.setValue(urgency);
		sleep(1000);
		
		$(By.xpath("//span[contains(.,'"+urgency+"')]")).waitUntil(visible, app.timeOut).click();
		
		//$(By.xpath("//span[text()='" + urgency + "']")).waitUntil(visible, app.timeOut).click();
		return urgencyQuerier;
	}

	// Кнопка 1 выбор Происхождение
	public SelenideElement btnOrigin() {
		return $(By.xpath("//*[@cuba-id='origin']/div[@role='button']")).should(visible);
	}

	public SelenideElement originQuerier(String origin) {
		SelenideElement originQuerier = $(By.xpath("//*[@cuba-id='origin']/input")).should(visible);
		if (!origin.equals("")) {
			originQuerier.sendKeys(Keys.CONTROL, "a");
			originQuerier.sendKeys(Keys.BACK_SPACE);
			originQuerier.setValue(origin);
			sleep(1000);
			
			$(By.xpath("//span[contains(.,'"+origin+"')]")).waitUntil(visible, app.timeOut).click();			
			
		//	$(By.xpath("//span[text()='" + origin + "']")).waitUntil(visible, app.timeOut).click();
		}
		return originQuerier;
	}

	// Кнопка 1 выбор Основание
	public SelenideElement btnСause() {
		return $(By.xpath("//*[@cuba-id='cause']/div[@role='button']")).should(visible);
	}

	// Поле основание
	public SelenideElement baseQuerier(String base) {
		SelenideElement baseQuerier = $(By.xpath("//*[@cuba-id='cause']/input")).should(visible);
		if (!base.equals("")) {
			baseQuerier.sendKeys(Keys.CONTROL, "a");
			baseQuerier.sendKeys(Keys.BACK_SPACE);
			baseQuerier.setValue(base);
			sleep(1000);
			
			$(By.xpath("//span[contains(.,'"+base+"')]")).waitUntil(visible, app.timeOut).click();
			
		//	$(By.xpath("//span[text()='" + base + "']")).waitUntil(visible, app.timeOut).click();
		}
		return baseQuerier;
	}

	// Кнопка 1 выбор Периодичность
	public SelenideElement btnPeridiocity() {
		return $(By.xpath("//*[@cuba-id='peridiocity']/div[@role='button']")).should(visible);
	}

	public SelenideElement periodicityQuerier(String periodicity) {
		SelenideElement periodicityQuerier = $(By.xpath("//*[@cuba-id='peridiocity']/input")).should(visible);
		if (!periodicity.equals("")) {
			periodicityQuerier.sendKeys(Keys.CONTROL, "a");
			periodicityQuerier.sendKeys(Keys.BACK_SPACE);
			periodicityQuerier.setValue(periodicity);
			sleep(1000);
			
			$(By.xpath("//span[contains(.,'"+periodicity+"')]")).waitUntil(visible, app.timeOut).click();
			
		//	$(By.xpath("//span[text()='" + periodicity + "']")).waitUntil(visible, app.timeOut).click();
		}
		return periodicityQuerier;
	}

	// Поле комментарии
	public SelenideElement commentQuerier(String comment) {
		return $(By.xpath("//*[@cuba-id='WebResizableTextArea']")).should(visible).setValue(comment);
	}

	// Кнопки формы создания заявки
	// Кнопка Новый
	public SelenideElement newBtnQuerier() {
		return $(By.xpath("//*[@cuba-id='createPosition']")).should(visible);
	}

	// Конпка Удалить
	public SelenideElement removeBtnQuerier() {
		return $(By.xpath("//*[@cuba-id='remove']")).should(visible);
	}

	// Кнопка Редактировать Аналоги
	public SelenideElement editAnalogsBtnQuerier() {
		return $(By.xpath("//*[@cuba-id='btnEditAnalogs']")).should(visible);
	}

	// Сохранить выбор заказа
	public SelenideElement saveBtnQuerier() {
		return $(By.xpath("//*[@cuba-id='windowCommit']")).waitUntil(exist, app.timeOut).should(visible);
	}

	// Span ожидания данных формы
	public SelenideElement span(String text) {
		if (!text.equals("") && $(By.xpath("//span[text()='" + text + "']")).isDisplayed()) {
			return $(By.xpath("//span[text()='" + text + "']")).shouldBe(visible);
		} else {
			return $(By.xpath("//body"));
		}
	}

	// Выбор этапов tr[1] первый этап итд /tr[2].... это по таблицу
	public SelenideElement stagesQuerierId(int num) {
		String id = String.valueOf(num);
		SelenideElement stagesQuerier = $(By.xpath("//tbody[@class='v-grid-body']/tr[" + id + "]")).lastChild();
		return stagesQuerier;
	}

	// Выбор этапов последний tr
	public SelenideElement stagesQuerier() {
		sleep(2000);
		SelenideElement stagesQuerier = $(By.xpath("//tbody[@class='v-grid-body']/tr[last()]")).lastChild();
		return stagesQuerier;
	}

	// Кнопка Тип Позиции и выбор по тексту
	public SelenideElement tapyPositionsQuerier(String text) {
		SelenideElement tapyPositionsQuerier = $(By.xpath("//*[@cuba-id='WebLookupField_ds_positionType']/div"))
				.should(visible);
		tapyPositionsQuerier.click();
		$(By.xpath("//span[text()='" + text + "']")).waitUntil(visible, app.timeOut).click();
		return tapyPositionsQuerier;
	}

	// Кнопка Номенклатуры (Выбор номенклатуры)
	public SelenideElement nomenclatureBtn() {
		// Есть id WebPickerField_ds_nomenclature		
		SelenideElement nomenclatureBtn = $(By.xpath(
				"//div[@class='c-pickerfield v-widget v-has-width c-pickerfield-error c-pickerfield-error-error c-pickerfield-required v-required']/div/div"))
						.should(visible);
		return nomenclatureBtn;
	}

	// Работа с окном номенклатуры ##############################
	// Поле поиска номенклатуры
	public SelenideElement addnomenclatureSearch(String nomen) {
		return $(By.xpath("//*[@cuba-id='ftsSearchCriteriaField']")).should(visible).setValue(nomen);
	}

	// Кнопка поиск номенклатуры
	public SelenideElement btnnomenclature() {
		return $(By.xpath("//*[@cuba-id='search']")).should(visible);
	}

	// Выбрать номенклатуту по тексту применим в других случаях
	// ожидания данных по тексту
	public SelenideElement nomenclatureByTextWindow(String text) {
		//sleep(1000);
		return $(By.xpath("//div[@class='v-window-contents']//div[text()='" + text + "']")).waitUntil(visible, app.timeOut);
	}
	
	
	// Выбрать номенклатуту по тексту применим в других случаях
		// ожидания данных по тексту
		public SelenideElement nomenclatureByText(String text) {
			SelenideElement nomen = $(By.xpath("//div[text()='" + text + "']")).waitUntil(visible, app.timeOut);
			sleep(7000);
			return nomen;
		}
		
	

	// Выбрать вложенную номенклатуту по тексту применим в других случаях
	// Кклик на треугольник для ракрытия дерева номенклатуры
	public SelenideElement nomenclatureByTextSpan(String text) {
		return $(By.xpath("//div[text()='" + text + "']/span")).waitUntil(visible, app.timeOut);
	}

	// выбор по первому tr
	public SelenideElement nomenclatureByFirts(String text) {
		return $(By.xpath("//table[@class='v-table-table']//tr")).waitUntil(exist, app.timeOut);
	}

	// выбор по последнему tr
	public SelenideElement nomenclatureByLast(String text) {
		return $(By.xpath("//table[@class='v-table-table']//tr")).lastChild().waitUntil(exist, app.timeOut);
	}

	// Кнопка выбора номенклатуры (ВЫБРАТЬ)
	public SelenideElement btnnomenclatureChoоse() {
		SelenideElement choоseBtn = $(By.xpath("//*[@cuba-id='selectButton']")).should(visible);
		sleep(1000);
		return choоseBtn;
	}
	// Поле техЗадание
	public SelenideElement addTechTask(String tasks) {
		SelenideElement task = $(By.xpath("//input[@cuba-id='WebTextField_ds_specification']")).should(visible);
		task.click();
		task.clear();
		task.setValue(tasks);
		return task;
	}

	// Поле количества
	public SelenideElement addQuantitynomenclature(String num) {
		SelenideElement quantity = $(By.xpath("//*[@cuba-id='WebTextField_ds_quantity']")).should(visible);
		quantity.sendKeys(Keys.CONTROL, "a");
		quantity.sendKeys(Keys.BACK_SPACE);
		quantity.setValue(num);
		return quantity;
	}

	
	// Поле комментарий
	public SelenideElement addCommentnomenclature(String text) {
		SelenideElement comment = $(By.xpath("//*[@cuba-id='WebTextField_ds_comment']")).should(visible);
		comment.click();
		comment.clear();
		comment.setValue(text);
		return comment;
	}

	// Поле номер номенклатуры
	public SelenideElement addNumbertnomenclature(String numbern) {
		SelenideElement number = $(By.xpath("//*[@cuba-id='WebTextField_ds_numberArticle']")).should(visible);
		number.click();
		number.clear();
		number.setValue(numbern);
		return number;
	}

	// Единца измирения
	public SelenideElement measureUnit(String measure) {
		SelenideElement measureUnitBtn = $(
				By.xpath("//*[@cuba-id='WebLookupField_ds_measureUnit']/div[@role='button']")).should(visible);
		measureUnitBtn.click();
		SelenideElement measureUnit = $(By.xpath("//*[@cuba-id='WebLookupField_ds_measureUnit']/input"))
				.should(visible);
		measureUnit.sendKeys(Keys.BACK_SPACE);
		measureUnit.setValue(measure);
		sleep(1000);
		$(By.xpath("//span[text()='" + measure + "']")).waitUntil(visible, app.timeOut).click();
		return measureUnit;
	}

	// Кнопка OK выбора номенклатуры
	public SelenideElement btnOKChoоse() {
		return $(By.xpath("//button[text()='OK']")).should(visible);
	}

	// Кнокпи нижнего меню
	// Кнопка в работу
	public SelenideElement btnInWork() {
		sleep(1500);
		
		//toWork 
		
		SelenideElement btnInWork = $(By.xpath("//*[@cuba-id='toWork']")).should(visible);
		btnInWork.click();
		$(By.xpath("//h1[text()='Только просмотр']")).waitUntil(Condition.disappear, app.timeOut);

		return btnInWork;
	}

	// Список заявок
	public SelenideElement listQuantity() {
		return $(By.xpath("//*[@cuba-id='breadCrubms_Button_supply$Query.browse']")).should(visible);
	}

	// Сортировки
	// Список заявок
	public SelenideElement columnTimeCreationQuantity() {
		return $(By.xpath("//*[@cuba-id='column_timeCreation']")).should(visible);
	}

	// Поиск ###################
	// Поле Поиска
	public SelenideElement searchQuerie(String text) {
		SelenideElement searchQuerie = $(By.xpath("//*[@cuba-id='ftsSearchCriteriaField']")).should(visible);
		searchQuerie.click();
		searchQuerie.clear();
		searchQuerie.setValue(text);
		return searchQuerie;
	}

	// Кнопка Поиска
	public SelenideElement btnSearchQuerie() {
		SelenideElement searchQuerie = $(By.xpath("//*[@cuba-id='search']")).should(visible);
		return searchQuerie;
	}

	// Клик по тексту
	public SelenideElement clickByText(String text) {
		SelenideElement searchResultQuerie = $(By.xpath("//div[text()='" + text + "']"));
		return searchResultQuerie;
	}
	
	
		// Выбор данных Открытой заявки -- 
	public SelenideElement clickByTextOpenQuery(String text, int td) {
		SelenideElement searchResultQuerie = $(By.xpath("//*[text()='"+text+"']/.././td["+td+"]"));
		return searchResultQuerie;
	}
	
	
		// Горизонтальный скролл
	public SelenideElement scrollerHorizontal() {
		SelenideElement scrollerHorizontal = $(By.xpath("//div[@class='v-grid-scroller v-grid-scroller-horizontal']"));
		return scrollerHorizontal;
	}
	
	
// Кнопка выбора опций в grid
	public SelenideElement addDelGridOptions() {
		SelenideElement addDelGridOptions = $(By.xpath("//*[@class='v-grid-sidebar-button']"));
		return addDelGridOptions;
	}
	
	
	
		public SelenideElement clickByTextCSS(String text) {
		SelenideElement searchResultQuerie = $(By.xpath("//div[text()='" + text + "']//..//.."));
		return searchResultQuerie;
	}
	

	// Сортировка по времени создания
	public SelenideElement sortByTime() {
		SelenideElement sortBtn = $(By.xpath("//*[@cuba-id='column_timeCreation']/div[2]")).waitUntil(visible, app.timeOut);
		return sortBtn;
	}

	// Пагинатор кнопка на один шаг вперед
	public SelenideElement paginBtnFront() {
		SelenideElement pBtn = $(By.xpath("//*[@class='v-slot v-slot-c-paging-change-page v-slot-c-paging-next v-align-center v-align-middle']"));
		return pBtn;
	}
	
	
	
	// Пагинатор кнопка на один шаг назад
	public SelenideElement paginBtnBack() {
		                 
		SelenideElement pBtn = $(By.xpath("v-slot v-slot-c-paging-change-page v-slot-c-paging-prev v-align-center v-align-middle']")).should(visible);
		return pBtn;
	}
	
	
	

	// Пагинатор кнопка к концу списка
	public SelenideElement paginBtnLast() {
		SelenideElement pBtnL = $(By.xpath("v-slot v-slot-c-paging-change-page v-slot-c-paging-last v-align-center v-align-middle']")).should(visible);
		return pBtnL;
	}
	// Пагинатор кнопка в начало списка
		public SelenideElement paginBtnFirst() {
		SelenideElement pBtnF = $(By.xpath("v-slot v-slot-c-paging-change-page v-slot-c-paging-first v-align-center v-align-middle']")).should(visible);
		return pBtnF;
	}
		
		// Проверка текста
		public SelenideElement getDoneQueryStatus(String text) {
		SelenideElement getDoneQueryStatus = $(By.xpath("//*[text()='"+text+"']")).should(visible);
		return getDoneQueryStatus;
	}
		
		
		// Клик на результат поиска по тексту
		public void clickQuerie(String text) {
			clickByText(text).should(exist).doubleClick();
		}		
		
	
	
	// Рефрешь
	public void refresh() {
		queriesRefreshBtn().click();
		sleep(2000);
	}

	// Сортировка
	public void sort() {
		sortByTime().click();
		sleep(5000);
	}

	// Клик на заявку в списке заявок
	public void openQueryList(String className) {
		app.query().clickByText(app.data().getData(className, "numberQ")).click();
		sleep(500);
		app.query().clickByText(app.data().getData(className, "numberQ")).doubleClick();
	}

	// Искать заявку по пагинатору
	public void findQueryPagination(String text) {
		
		if(app.query().paginBtnFront().isDisplayed())
		{
		
		while (true) {

			if (!clickByText(text).isDisplayed()) {				
				app.query().paginBtnFront().click();
			}

			if (clickByText(text).waitUntil(visible, app.timeOut).isDisplayed())
			{
				break;
			}
		}
		}
		
	}

	

}
