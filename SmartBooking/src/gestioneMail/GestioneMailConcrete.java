package gestioneMail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import gestioneUtenti.GestionePassword;

public class GestioneMailConcrete implements GestioneMail {
	
	
	/**
	 * Metodo che riceve configurazione email smartbooking e informazioni sull'email da inviare
	 */
	@Override
	public void sendEmail(String host, String port, String userName, String password, String emailMittente,
			String emailDestinatario, String nome, String cognome, String subject, String content) {
		try {
			mailUtility.sendEmail(host, port, userName, password, emailMittente, emailDestinatario, nome, cognome, subject, content);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private EmailUtility mailUtility = new EmailUtility();


}
