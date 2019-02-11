package com.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.main.appmanager.ApplicationManager;

public class Сalendar {
	public static ApplicationManager app;

	public Сalendar() {
		app = new ApplicationManager();
	}

	// TAB Календарь
	public SelenideElement tabCalendar() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Holiday.browse']")).should(visible);
	}

	// Закрыть TAB Календарь
	public SelenideElement clouseTabCalendar() {
		return $(By.xpath("//*[@cuba-id='tab_supply$Holiday.browse']//span[text()='×']")).should(visible);
	}

	// Поля поиска по Каледадрю ######################
	// Поле поиск по имени
	public SelenideElement nameSearchCalendar(String text) {
		SelenideElement cal = $(By.xpath("//input[@cuba-id='ftsSearchCriteriaField']")).should(visible);
		cal.click();
		cal.clear();
		cal.setValue(text);
		return cal;
	}
	
	// Кнопка поиска
	public SelenideElement btnSearchCalendar() {
		return $(By.xpath("//*[@cuba-id='search']")).should(visible);
	}
	
	// Кнопка сброс поиска
	public SelenideElement btnResetCalendar() {
		return $(By.xpath("//*[@cuba-id='reset']")).should(visible);
	}
	
	
	// кнопки создания #######################
	
	// Добавить событие в календаре кнопка
	public SelenideElement addCalendarBtn() {
		return $(By.xpath("//*[@cuba-id='createBtn']")).should(visible);
	}
	
	// Изменить событие кнопка (Изменить)
	public SelenideElement editCalendarBtn() {
		return $(By.xpath("//*[@cuba-id='editBtn']")).should(visible);
	}

	// Удалить
	public SelenideElement btnCalendarDel() {
		return $(By.xpath("//*[@cuba-id='removeBtn']")).should(visible);
	}
	
	// поля создания ######################	
	// Поле дата -формат- (01.01.2019)
		public SelenideElement addCalendarDate(String text) {
			SelenideElement name = $(By.xpath("//*[@cuba-id='day']//input"))
					.should(visible);
			name.click();
			name.clear();
			name.setValue(text);
			return name;
		}
	
// Проверка календаря, надо сделать позже. Не важный функционал ######################	
		public SelenideElement btnCalendarDate() {
			SelenideElement date =$(By.xpath("//*[@cuba-id='day']//button")).should(visible);		
		//span[@class='v-datefield-calendarpanel-month']	
			return date;
		}
	
		
	// Поле рабочие часы (int)
		public SelenideElement addCalendarWorkingHours(String text) {
			SelenideElement wh = $(By.xpath("//input[@cuba-id='workingHours']"))
					.should(visible);
			wh.click();
			wh.clear();
			wh.setValue(text);
			return wh;
		}
	
		
		// Добавить запись в календарь кнопка ОК
		public SelenideElement addCompanyBtnOK() {
			return $(By.xpath("//div[@cuba-id='saveBtn']")).should(visible);
		}

		// Отменить запись в календарь кнопка cancel
		public SelenideElement addCompanyBtnCancel() {
			return $(By.xpath("//div[@cuba-id='cancelBtn']")).should(visible);
		}
	
// PopUp закрытия TAB календарь	
	
		// Закрыть вкладку кнопка ОК
		public SelenideElement clouseBtnOK() {
			return $(By.xpath("//div[@cuba-id='optionDialog_yes']")).should(visible);
		}

		// Отменить закрытие вкладки календарь cancel
		public SelenideElement noBtnCancel() {
			return $(By.xpath("//div[@cuba-id='optionDialog_no']")).should(visible);
		}
	
	
	
	
	

}
