package com.pages;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class WorkProcess {
	public static ApplicationManager app;

	public WorkProcess() {
		app = new ApplicationManager();
	}

	// Закладка TAB Рабочий процесс
	public SelenideElement tabWorkPro() {
		return $(By.xpath("//*[@cuba-id='tab_tabView']//div[text()='Рабочий процесс']")).should(visible);
	}

	// Закрыть Закладка Рабочий процесс
	public SelenideElement linkWorkPro() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Nomenclature.browse']//span[text()='×']")).should(visible);
	}
	
	
	// Поиск сброс кнопка
		public SelenideElement btnReset() {
			return $(By.xpath("//div[@cuba-id='reset']")).should(visible);
		}
	
	

	// ######################
	// Под меню рабочего процесса ADMIN

	// Ссылка Номенклатурный контроль (#)
	public SelenideElement linkWorkProNomControl() {
		return $(By.xpath("//*[@cuba-id='NomControl']")).should(visible);

	}

	// Ссылка Складской контроль (#)
	public SelenideElement linkStoreControl() {
		return $(By.xpath("//*[@cuba-id='StoreControl']")).should(visible);

	}

	// Ссылка Подбор поставщиков (#)
	public SelenideElement linkSupSelection() {
		return $(By.xpath("//*[@cuba-id='SupSelection']")).should(visible);

	}

	// Ссылка Ценовая политика (#)
	public SelenideElement linkAnalysis() {
		return $(By.xpath("//*[@cuba-id='Analysis']")).should(visible);

	}

	// Ссылка Счета (#)
	public SelenideElement linkBills() {
		return $(By.xpath("//*[@cuba-id='Bills']")).should(visible);

	}

	// Ссылка Логистика (#)
	public SelenideElement linkLogistic() {
		return $(By.xpath("//*[@cuba-id='Logistic']")).should(visible);

	}

	// Ссылка Доверенность (#)
	public SelenideElement linkRetention() {
		return $(By.xpath("//*[@cuba-id='Retention']")).should(visible);

	}

	// Ссылка Доверенность (#)
	public SelenideElement linkProblems() {
		return $(By.xpath("//*[@cuba-id='Problems']")).should(visible);

	}

	// Ссылка Закупочная комиссия (#)
	public SelenideElement linkComission() {
		return $(By.xpath("//*[@cuba-id='Comission']")).should(visible);

	}

	// ###########################
	// Кнопки Nomenklatura

	// Записать изминения в таблицу
	public SelenideElement btnWrite() {
		return $(By.xpath("//*[@cuba-id='btnWrite']")).should(visible);

	}

	// Готово
	public SelenideElement btnDone() {
		return $(By.xpath("//*[@cuba-id='btnDone']")).should(visible);

	}

	// Отказ
	public SelenideElement btnCancel() {
		return $(By.xpath("//*[@cuba-id='btnCancel']")).should(visible);

	}

	// ОБновить
	public SelenideElement btnRefresh() {
		return $(By.xpath("//*[@cuba-id='btnRefresh']")).should(visible);

	}

	// Развернуть все
	public SelenideElement btnExpandAll() {
		return $(By.xpath("//*[@cuba-id='btnExpandAll']")).should(visible);

	}

	// Свернуть все
	public SelenideElement btnCollapseAll() {
	SelenideElement locator = $(By.xpath("//*[@cuba-id='btnCollapseAll']")).waitUntil(visible, app.timeOut);
		locator.click();
		sleep(3000);
		return locator;

	}

	// Ообрать целиком
	public SelenideElement btnWholeQuery() {
		return $(By.xpath("//*[@cuba-id='btnWholeQuery']")).should(visible);

	}

	// Целиособразность заявки
	public SelenideElement btnSetQueryUsefulness() {
		return $(By.xpath("//*[@cuba-id='btnSetQueryUsefulness']")).waitUntil(exist, app.timeOut);

	}

	// Порядок группировки
	public SelenideElement group_order() {
		return $(By.xpath("//*[@cuba-id='group_order']")).should(visible);

	}

	// Проблемы
	public SelenideElement btnProblems() {
		return $(By.xpath("//*[@cuba-id='btnProblems']")).should(visible);

	}

	// Выделить текст
	public SelenideElement WebCheckBox() {
		return $(By.xpath("//*[@cuba-id='WebCheckBox']/input")).should(visible);

	}

	// ###########################
	// Главная рабочий процесс

	// Плановая Сверхсрочная Срочная

	// #####################
	// Ссылка (#) Двойной клик
	public SelenideElement linkControlPlan(String urgent) {
		return $(By.xpath("//*[@cuba-id='WebLabel']/b[text()='" + urgent + "']")).should(visible);

	}

	// Ссылка (#) клик на треугольник свернут
	public SelenideElement linkClosed(String urgent) {
		return $(By.xpath(
				"//span[@class='v-treetable-treespacer v-treetable-node-closed']//../div[@cuba-id='WebLabel']/b[text()='"
						+ urgent + "']/../../span")).should(visible);

	}

	// Ссылка (#) клик на треугольник развернут
	public SelenideElement linkOpen(String urgent) {
		return $(By.xpath(
				"//span[@class='v-treetable-treespacer v-treetable-node-open']//../div[@cuba-id='WebLabel']/b[text()='"
						+ urgent + "']/../../span")).should(visible);

	}

	// Ссылка компания doubleClick
	public SelenideElement linkCompany(String company) {
		return $(By.xpath("//b[text()='" + company + "']")).waitUntil(visible, app.timeOut);

	}

	// Ссылка компания треугольник
	public SelenideElement linkCompanySpan(String company) {
		// b[text()='Тестовая Компания 1']/../../span
		// *[@cuba-id='WebLabel']//b[text()='Тестовая Компания 1']/../../span
		return $(By.xpath("//*[@cuba-id='WebLabel']//b[text()='" + company + "']/../../span")).waitUntil(visible, app.timeOut);

	}

	// Ссылка подразделение компании doubleClick
	public SelenideElement linkDev(String dev) {
		return $(By.xpath("//b[text()='" + dev + "']")).waitUntil(visible, app.timeOut);

	}

	// Ссылка подразделение компании треугольник
	public SelenideElement linkDevSpan(String dev) {
		return $(By.xpath("//b[text()='" + dev + "']/../../span")).waitUntil(visible, app.timeOut);

	}

	// Ссылка заявка doubleClick
	public SelenideElement linkQuery(String query) {
		return $(By.xpath("//div[text()='Заявка: ']/b[contains(.,'" + query + "')]")).waitUntil(visible, app.timeOut);

	}

	// Ссылка заявка треугольник
	public SelenideElement linkQuerySpan(String query) {
		return $(By.xpath("//div[text()='Заявка: ']/b[contains(.,'" + query + "')]/../../span")).waitUntil(visible,
				app.timeOut);

	}
	
	// Номенклатура заявки 
	public SelenideElement linkQueryName(String nomen) {
		//div[text()='Заявка: ']/b[contains(.,'\" + query + \"')]/../../../../..
		return $(By.xpath("//div[text()='"+nomen+"']")).waitUntil(visible, app.timeOut);
	}
	
	
	
	
	
	// Номенклатура заявки невидимая
	public SelenideElement linkQueryNameNotVisible(String nomen) {
		//div[text()='Заявка: ']/b[contains(.,'\" + query + \"')]/../../../../..
		return $(By.xpath("//div[text()='"+nomen+"']")).waitUntil(disappear, app.timeOut);
	}
	
	// ###########################
	
	
	//div[text()='Сетка С-2']
	//*[@class='v-table-table']//div[text()='Сетка С-2']
	

	// Обновлять 5 раз каждые до появления компании
	public void waitRefresh(String text) {
		for (int i = 0; i < 10; i++) {
			if (!linkCompanySpan(text).isDisplayed()) {
				sleep(1000);
				btnRefresh().click();
				sleep(1000);
				
			}
			if (linkCompanySpan(text).waitUntil(visible, app.timeOut).isDisplayed()) {
				break;
			}
		}
	}

	// Обновлять 5 раз каждые до исчезновения номенклатуты из контроля
		public void waitRefreshAway(String text) {
			for (int i = 0; i < 5; i++) {
				if (linkQueryName(text).isDisplayed()) {
					sleep(700);
					btnRefresh().click();
					sleep(700);
				}
				if (!linkQueryName(text).waitUntil(visible, app.timeOut).isDisplayed()) {
					break;
				}
			}
		}
	

		
	
}
