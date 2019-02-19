package com.main.appmanager;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.base.common.Logs;
import com.codeborne.selenide.Configuration;
import com.data.Data;
import com.data.DelEmails;
import com.data.GetEmail;
import com.pages.Bills;
import com.pages.Company;
import com.pages.Division;
import com.pages.Gmail;
import com.pages.Login;
import com.pages.Logistic;
import com.pages.MainMenu;
import com.pages.Messages;
import com.pages.Nomenclature;
import com.pages.Problems;
import com.pages.PurchasingCommission;
import com.pages.Query;
import com.pages.Settings;
import com.pages.Smokes;
import com.pages.Store;
import com.pages.Suppliers;
import com.pages.WebForm;
import com.pages.WorkProcess;
import com.pages.Сalendar;

public class ApplicationManager {

	public int timeOut = 40000;
	protected static Logs logs;
	// ##########################
	protected Data data;
	// ##########################
	// Pages
	protected MainMenu mainMenu;
	protected Login login;
	protected Query query;
	protected Store store;
	protected Division div;
	protected WorkProcess wprocess;
	protected Company company;
	protected Nomenclature nomen;
	protected Bills bills;
	protected Suppliers supp;
	protected Сalendar сalen;
	protected Settings set;
	protected Problems problems;
	protected Messages messages;
	protected Gmail gmail;
	protected WebForm webform;
	protected DelEmails deleteMails;
	protected GetEmail getEmail;
	protected PurchasingCommission pComm;
    protected Logistic logist;
    // ##########################
      protected Smokes smokes;
    
    
	// ##########################

	public static ApplicationManager app;

	public static ApplicationManager getInstance(String url, String platform) throws Exception {
		app = new ApplicationManager();
		File DriverPath = new File("");
		System.setProperty("webdriver.chrome.driver", DriverPath.getAbsolutePath() + "\\drivers\\chromedriver.exe");
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
		// LoggingPreferences logs = new LoggingPreferences();
		// logs.enable(LogType.BROWSER, Level.ALL);
		// logs.enable(LogType.CLIENT, Level.ALL);
		// logs.enable(LogType.DRIVER, Level.ALL);
		// logs.enable(LogType.PERFORMANCE, Level.ALL);
		// logs.enable(LogType.PROFILER, Level.ALL);
		// logs.enable(LogType.SERVER, Level.ALL);
		// ChromeOptions options = new ChromeOptions();
		// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		// capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
		// options.addArguments("start-maximized");
		// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		Configuration.startMaximized = true;
		open(url);
		return app;
	}

	public void tearDown() throws Exception {
		close();

	}

	// ##############################

	public Logs logs() {
		return logs = new Logs();
	}

	// ##############################

	public Data data() {
		return data = new Data();
	}

	// ##############################

	public DelEmails deleteMails() {
		return deleteMails = new DelEmails();
	}

	// ##############################

	public Gmail gmail() {
		return gmail = new Gmail();
	}

	// ##############################
	
	// ##############################

	public GetEmail getEmail() {
		return getEmail = new GetEmail();
	}

	// ##############################
	
	
	
	
	
	

	public Login login() {
		return login = new Login();
	}

	public Query query() {
		return query = new Query();
	}

	public Store store() {
		return store = new Store();
	}

	public MainMenu mainMenu() {
		return mainMenu = new MainMenu();
	}

	public WorkProcess wprocess() {
		return wprocess = new WorkProcess();
	}

	public Company company() {
		return company = new Company();
	}

	public Nomenclature nomen() {
		return nomen = new Nomenclature();
	}

	public Division div() {
		return div = new Division();
	}

	public Bills bills() {
		return bills = new Bills();
	}

	public Suppliers supp() {
		return supp = new Suppliers();
	}

	public Сalendar сalen() {
		return сalen = new Сalendar();
	}

	public Settings set() {
		return set = new Settings();
	}

	public Problems problems() {
		return problems = new Problems();
	}

	public Messages messages() {
		return messages = new Messages();
	}

	public WebForm webform() {
		return webform = new WebForm();
	}

	public PurchasingCommission pComm() {
		return pComm = new PurchasingCommission();
	}
	
	public Logistic logist() {
		return logist = new Logistic();
	}
	
	public Smokes smokes() {
		return smokes = new Smokes();
	}
	
	
	
	
	// ##############################
	public void switchLoging() throws SecurityException, IOException {
		// set logger Level for RemoteWebDriver
		Logger logger = Logger.getLogger(RemoteWebDriver.class.getName());
		logger.setLevel(Level.ALL);
		// delete all Handlers
		for (Handler handler : logger.getHandlers()) {
			logger.removeHandler(handler);
		}
		// create Console Handler and define level ALL
		ConsoleHandler console = new ConsoleHandler();
		console.setLevel(Level.INFO);
		logger.addHandler(console);
		// create File Handler and define level ALL
		File log = new File("log.txt");
		FileHandler file = new FileHandler(log.getAbsolutePath());
		file.setLevel(Level.ALL);
		file.setFormatter(new SimpleFormatter());
		logger.addHandler(file);
	}

}
