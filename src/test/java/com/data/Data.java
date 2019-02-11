package com.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.main.appmanager.ApplicationManager;

public class Data {
	public static ApplicationManager app;
	File file = new File("");
	File dataDir = new File(file.getAbsolutePath() + "\\data\\");

	public Data() {

		app = new ApplicationManager();
	}

	// Получить рандом строку
	static final String AB = "абвгдеёжзиклмнопрстуфхчщэюяь";
	static SecureRandom rnd = new SecureRandom();
	// Получить рандом строку
	static final String ab = "qwertyuiopasdfghjklzxcvbnm123456789";
	static SecureRandom rndE = new SecureRandom();
	// Получить рандом строку
	static final String phone = "1234567890";
	static SecureRandom rndP = new SecureRandom();

	// Получить рандом строку милллисекунд
	public String dateRandom() {
		Date today = new Date();
		SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HHmm");
		SimpleDateFormat SEC_FORMAT = new SimpleDateFormat("SS");
		String time = TIME_FORMAT.format(today);
		String sec = SEC_FORMAT.format(today);
		String all = time + sec;
		return all;
	}

	// Генераатор рандом строкуи
	public String randomNameRUS(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	// Генераатор рандом строкуи
	public String randomNum(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(phone.charAt(rndP.nextInt(phone.length())));
		return sb.toString();
	}

	// Генераатор рандом строкуи
	public String randomName(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(ab.charAt(rndE.nextInt(ab.length())));
		String emailRes = sb.toString() + "Autotest";
		return emailRes;
	}

	// Запись в файл txt
	public void addIhfoFile(String querierNum, String data) throws InterruptedException, IOException {
		System.out.println(dataDir.toString() + data);
		FileWriter fooWriter = new FileWriter(dataDir + data, false);
		fooWriter.write("");
		fooWriter.close();
		String phone_Old = "(.*?)";
		String phone_New = querierNum;
		try {
			FileReader fr = new FileReader(dataDir + data);
			String s;
			String totalStr = "";
			try (BufferedReader br = new BufferedReader(fr)) {

				while ((s = br.readLine()) != null) {
					totalStr += s;
				}
				totalStr = totalStr.replaceAll(phone_Old, phone_New);

				FileWriter fw = new FileWriter(dataDir + data);
				fw.write(totalStr);
				fw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Прочитать строку из txt
	public String getQuerierNum(String data) throws IOException {
		InputStream is = new FileInputStream(dataDir + data);
		@SuppressWarnings("resource")
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();

		while (line != null) {
			sb.append(line).append("");
			line = buf.readLine();
		}
		String fileAsString = sb.toString();
		System.out.println(" " + fileAsString);
		return fileAsString;
	}

	// Создать новый файл с данными JSON
	public void createJSONFile(String json) throws InterruptedException, IOException {
		System.out.println(dataDir.toString() + json);
		try {
			File file = new File(json);
			if (file.createNewFile()) { // return true
				System.out.println("New file " + json + " is created!");
			} else { // вернуть false
				System.out.println(json + " already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Записать даные в JSON
	@SuppressWarnings("unchecked")
	public void addData(String fileName, String login, String company, String unit, String store, String number,
			String nomenklature, String suppliers, String inn, String kpp, String full, String companyOff) {

		JSONObject object = new JSONObject();
		object.put("login", login);
		object.put("company", company);
		object.put("unit", unit);
		object.put("store", store);
		object.put("numberQ", number);
		object.put("nomenklature", nomenklature);
		object.put("suppliers", suppliers);
		object.put("inn", inn);
		object.put("kpp", kpp);
		object.put("companyFull", full);
		object.put("companyOff", companyOff);

		// JSONArray messages = new JSONArray();
		// messages.add("Message 1");
		// messages.add("Message 2");
		// messages.add("Message 3");
		// object.put("messages", messages);
		try (FileWriter writer = new FileWriter(fileName, false)) {
			writer.write(object.toJSONString());
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Получть нужную строку JSON
	public String getData(String fileName, String getItem) {
		String item = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser
					.parse(new FileReader(file.getAbsolutePath() + "\\data\\" + fileName));
			// Получаем строку
			item = (String) object.get(getItem);
			// System.out.println(getItem + ": " + item);

			// Получаем сообщения
			// JSONArray messages = (JSONArray) object.get("messages");
			// System.out.println("Messages:");
			// Iterator<String> iterator = messages.iterator();
			// while(iterator.hasNext()) {
			// System.out.println("> " + iterator.next());
			// }

		} catch (IOException | ParseException ex) {
			Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
		}
		return item;

	}

	public void createDataJSON(String file) throws InterruptedException, IOException {
	//createJSONFile(dataDir+"\\"+file);
		// Создаем набор данных для тестов
	addData(dataDir+"\\"+file, "login" + app.data().randomNum(5), "Компания " + app.data().randomName(5),
				"Подразделение " + app.data().randomName(5), "Склад " + app.data().randomName(5),
				"auto" + app.data().dateRandom(), "Номенклатура " + app.data().randomNum(5),
				"Поставщик " + app.data().randomNum(5), "ИНН" + app.data().randomNum(8),
				"КПП" + app.data().randomNum(9), "Полное название компании " + app.data().randomNum(9),
				"Название для выгрузки " + app.data().randomNum(5));

	}



}
