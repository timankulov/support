package com.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
import com.main.appmanager.ApplicationManager;

public class GetEmail {

	public static ApplicationManager app;

	public GetEmail() {
		app = new ApplicationManager();
	}

	Properties properties = null;
	private Session session = null;
	private Store store = null;
	private Folder inbox = null;
	private Message messages[];
	public String urlWebForm = "";

	public String getMails(String user, String pass) throws IOException, MessagingException {
		getConnection(user, pass);
		readMails();
		closeSession();
		return urlWebForm;
	}

	public void waitMail(String user, String pass) throws IOException, MessagingException, InterruptedException {
		getConnection(user, pass);
		waitMail();
		closeSession();

	}

	public void getConnection(String user, String pass) {
		properties = new Properties();
		properties.setProperty("mail.host", "imap.gmail.com");
		properties.setProperty("mail.port", "995");
		properties.setProperty("mail.transport.protocol", "imaps");
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		try {
			store = session.getStore("imaps");
			store.connect();
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void waitMail() throws IOException, InterruptedException {
		try {
			for (int i = 0; i < 10; i++) {
					messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
					System.out.println("Number of mails = " + messages.length);
					int mails=messages.length;
					
					if (mails==0) {					
					System.err.println("Token ещё не пришел! Ждем .....");
					Thread.sleep(10000);
					}
					
				if (mails>0) {
					System.out.println("Token пришел на почту, можно проверять!");
					break;
				}
}
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void readMails() throws IOException {
		try {
			if (null != inbox) {
				messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
				System.out.println("Number of mails = " + messages.length);
				if (messages.length == 0) {
					System.err.println("!!!===SHIT! Нет новых писаем!!!");
				}
				for (int i = 0; i < messages.length; i++) {
					Message message = messages[i];
					Address[] from = message.getFrom();
					System.out.println("-------------------------------");
					System.out.println("Date : " + message.getSentDate());
					System.out.println("From : " + from[0]);
					System.out.println("Subject: " + message.getSubject());
					// System.out.println("Content :" +
					// message.getContent().toString());
					processMessageBody(message);
					System.out.println("--------------------------------");
				}
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void closeSession() {
		if (null != inbox && null != store) {
			try {
				inbox.close(true);
				store.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	public void processMessageBody(Message message) {
		try {
			Object content = message.getContent();
			// check for string
			// then check for multipart
			if (content instanceof String) {
				System.out.println(content);
			} else if (content instanceof Multipart) {
				Multipart multiPart = (Multipart) content;
				procesMultiPart(multiPart);
			} else if (content instanceof InputStream) {
				@SuppressWarnings("resource")
				InputStream inStream = (InputStream) content;
				int ch;
				while ((ch = inStream.read()) != -1) {
					System.out.write(ch);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void procesMultiPart(Multipart content) throws IOException, MessagingException {
		int multiPartCount = content.getCount();
		for (int i = 0; i < multiPartCount; i++) {
			BodyPart bodyPart = content.getBodyPart(i);
			Object o;
			o = bodyPart.getContent();
			if (o instanceof String) {
				// System.out.println(o);
				String w = o.toString();
				urlWebForm = w.substring(w.indexOf("<a href=") + 9, w.indexOf("'>"));
				System.out.println("Web form url - " + urlWebForm);
				// System.out.println(urlWebForm);
			} else if (o instanceof Multipart) {
				procesMultiPart((Multipart) o);
			}
		}

	}

}