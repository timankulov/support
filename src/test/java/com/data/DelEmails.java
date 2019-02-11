package com.data;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class DelEmails {
// Origin from https://www.codejava.net/java-ee/javamail/delete-e-mail-messages-on-mail-server-programmatically
	
	
	
	
	
	public void deleteMessages(String host, String port, String userName, String password) {
		Properties properties = new Properties();
		// server setting
		properties.put("mail.imap.host", host);
		properties.put("mail.imap.port", port);
		// SSL setting
		properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.socketFactory.fallback", "false");
		properties.setProperty("mail.imap.socketFactory.port", String.valueOf(port));
		Session session = Session.getDefaultInstance(properties);
		try {
			// connects to the message store
			Store store = session.getStore("imap");
			store.connect(userName, password);

			// opens the inbox folder
			Folder folderInbox = store.getFolder("INBOX");
			folderInbox.open(Folder.READ_WRITE);
			

			// fetches new messages from server
			Message[] arrayMessages = folderInbox.getMessages();
			for (int i = 0; i < arrayMessages.length; i++) {
				Message message = arrayMessages[i];
				String subject = message.getSubject();
				// if (subject.contains(subjectToDelete)) {
				message.setFlag(Flags.Flag.DELETED, true);
				System.out.println("Marked DELETE for message: " + subject);
				// }
			}
			// expunges the folder to remove messages which are marked deleted
			boolean expunge = true;
			folderInbox.close(expunge);
			// another way:
			// folderInbox.expunge();
			// folderInbox.close(false);
			// disconnect
			store.close();
		} catch (NoSuchProviderException ex) {
			System.out.println("No provider.");
			ex.printStackTrace();
		} catch (MessagingException ex) {
			System.out.println("Could not connect to the message store.");
			ex.printStackTrace();
		}
	}
	

	/**
	 * Runs this program to delete e-mail messages on a Gmail account via IMAP
	 * protocol.
	 */
	public  void delAllEmails(String userName, String password) {
		String host = "imap.gmail.com";
		String port = "993";
		DelEmails remover = new DelEmails();
		// try to delete all messages contain this string its Subject field
		remover.deleteMessages(host, port, userName, password);

	}
}
