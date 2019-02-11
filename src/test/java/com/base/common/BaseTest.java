package com.base.common;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.codeborne.selenide.testng.TextReport;
import com.main.appmanager.ApplicationManager;



//@Report
//@Listeners(TextReport.class)

public class BaseTest extends TestListenerAdapter {
	public ApplicationManager app;
	private ScreenRecorder screenRecorder;
	File file = new File("");
	// video
	public void startRecording(File file) throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		Rectangle captureSize = new Rectangle(0, 0, width, height);
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, file, "temp");
		this.screenRecorder.start();
	}

	public void stopRecording() throws Exception {
		Thread.sleep(3000);
		this.screenRecorder.stop();
	}

	
	@Parameters({ "postavshik1", "postavshik2", "postavshik3", "email_password", "contact", "contact_password" })
	
	@BeforeSuite(alwaysRun = true)
	public void cleanUp(String postavshik1, String postavshik2, String postavshik3, String email_password, String contact, String contact_password) throws Exception {
		
		app = new ApplicationManager();
		// Чистим директории 
		File file = new File("");
		app.logs().clean(file.getAbsoluteFile() + "\\screenshots\\");
		app.logs().clean(file.getAbsoluteFile() + "\\videos\\");
		app.logs().clean(file.getAbsoluteFile() + "\\build\\");
		
	//	app.logs().clean(file.getAbsoluteFile() + "\\build\\reports\\tests");
	    // Обязательно установите imap и оключите защиту 
        // https://www.google.com/settings/security/lesssecureapps отключение безопастности gmail
		// https://mail.google.com/mail/#settings/fwdandpop включить imap
		// Удалить все письма Поставщик (Почистить почту)
    	app.deleteMails().delAllEmails(postavshik1, email_password);
    	app.deleteMails().delAllEmails(postavshik2, email_password);
		app.deleteMails().delAllEmails(postavshik3, email_password);
		// Удалить все письма Сотрудник (Почистить почту)
		app.deleteMails().delAllEmails(contact, contact_password);
		
	}

	@Parameters({ "url", "platform" })
	@BeforeClass(alwaysRun = true)
	public void setUp(String url, String platform) throws Exception {
		// Старт Selenide
		app = new ApplicationManager();
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		// Запуск браузера 
		ApplicationManager.getInstance(url, platform);
	}
	
	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun = true)
	public void startVideo(ITestResult result, String browser, String url) throws Exception {
		/*// Создаем файл сготовыми данными для каждого Класса
		String className = this.getClass().getSimpleName();
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(name);
		String path = file.getAbsolutePath() + "\\data\\" + className + ".json";
		app.data().createJSONFile(path);
		
		// Подготовка данных для теста
	//	app.data().createDataJSON(path);
*/		// Директория с video очетом
		File video = new File(file.getAbsoluteFile() + "\\videos\\");
		// Старт video
		startRecording(video);
		Reporter.log("</b><details><summary>Click to see last screen...</summary> <br></b>");
		Reporter.log("Открыть "+url+" <br>");
	}

	@Parameters({ "browser" })
	@AfterMethod(alwaysRun = true)

	public void result(ITestResult result, String browser) throws Exception {
		// Отчеты в консоль 
		TextReport.onSucceededTest = true;
		TextReport.onFailedTest = true;
		// Стоп video
		stopRecording();
		
		String className = this.getClass().getSimpleName();
		Path yourFile = Paths.get(file.getAbsolutePath() + "\\videos\\temp.avi");
		Files.move(yourFile, yourFile.resolveSibling(file.getAbsolutePath() + "\\videos\\" + className +"_"+ result.getMethod().getMethodName() + ".avi"));
		
		if (result.isSuccess()) {
			Reporter.setCurrentTestResult(result);
			Reporter.log("</details></b>");
			Reporter.log("<a href=..\\videos\\" + result.getMethod().getMethodName()
					+ ".avi download=\"filename\">Download video</a>");
			app.logs().passedTest("Class - " + className + " TEST - " + result.getMethod().getMethodName(), browser);
			System.out.println("Class - " + className + "  TEST - " + result.getMethod().getMethodName()
					+ " Passed! browser - " + browser + " \n ");
		}

		if (!result.isSuccess()) {
			Reporter.setCurrentTestResult(result);
			Reporter.log("</details></b>");
			Reporter.log("<a href=..\\videos\\" + result.getMethod().getMethodName()
					+ ".avi download=\"filename\">Download video</a>");
			app.logs().failTest("Class - " + className + "  TEST - " + result.getMethod().getMethodName(), browser);
			System.out.println("Class - " + className + "  TEST - " + result.getMethod().getMethodName()
					+ " Failure!  browser - " + browser + " \n ");
			// Логи, можно добавлять шаги
			app.logs().startLogs();
		}

	}

	@AfterClass(alwaysRun = false)
	public void tearDown() throws Exception {
		app.tearDown();
	}
	



}
