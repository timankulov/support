package com.base.common;

import java.io.File;
import org.testng.Reporter;

import com.main.appmanager.ApplicationManager;

public class Logs {
	public ApplicationManager app;

	public Logs() {

		app = new ApplicationManager();
	}

	public void startLogs() {

		Reporter.log("</b><details><summary>Show steps..</summary> <br>");

	}



	public void failTest(String testName, String platform) {
		Reporter.log(
				"<br><b><div align=\"left\" style=\" height:30px; width:250px; padding: 10px; border: 2px solid gray; margin: 0; background-color:#ff2500;\">"
						+ testName + " Fail! " + platform + "</div></b>");

	}

	public void passedTest(String testName, String platform) {
		Reporter.log(
				"<br><b><div align=\"left\" style=\" height:30px; width:250px; padding: 10px;  border: 2px solid gray; margin: 0; background-color:#19FF3A;\">"
						+ testName + " OK! " + platform + "</div></b>");

	}

	public void start_Logs(String device, String parameters) {
		Reporter.log(device + " " + parameters + " <b><br><details><summary>Click to see the Video...</summary> <br>");
	}

	public void text_Error(String text) {
		Reporter.log(" <br>" + text + " <br>");
	}

	public void test_Description(String description) {
		Reporter.log(" <b><br>" + description + " <br>");
		System.out.println(description);
	}

	public void clean(String dir) {

		File f = new File(dir);
		File[] files = f.listFiles();
		for (File file : files) {
			file.delete();
		}

	}

}
