package gestioneMail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 
 * @author Alfredo
 *
 */
public class EmailUtility {
	/**
	 * 
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 * @param toAddress
	 * @param subject
	 * @param message
	 * @param nome
	 * @param emailMitt
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendEmail(String host, String port, final String userName, final String password, 
			String emailMittente, String emailDestinatario, String nome, String cognome, String subject, String content)
			//String toAddress,String subject, String message, String nome, String emailMitt) 
	throws AddressException, MessagingException {

		// setta le proprietà del server smtp
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// crea una sessione per autenticare il mittente
	    Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		
	    Session session = Session.getInstance(properties, auth);

		// crea un nuovo messaggio email
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName)); //setta il mittente dell'email (userName=email mitt (sitoweb))
		InternetAddress[] toAddresses = { new InternetAddress(emailDestinatario) }; //Destinatario email 
		msg.setRecipients(Message.RecipientType.TO, toAddresses);  //setta i destinatari
		msg.setSubject(subject); //imposta oggetto del messaggio
		msg.setSentDate(new Date()); //imposta data di invio alla data attuale
		
		//Crea contenuto messaggio da inviare
		String indexEmail="Gentile "+emailDestinatario+" hai ricevuto una nuova mail attraverso il sistema SmartBooking, di seguito tutte le info:";
		String indexMitt="EMAIL MITTENTE: "+emailMittente;
		String indexNome="NOME: "+nome;
		String indexCognome="COGNOME: "+cognome;
		String indexOggetto="OGGETTO : "+subject;
		String indexMex="MESSAGGIO : "+content;
		
		String mex= indexEmail +"\n"+ indexMitt + "\n"+ indexNome + " " + indexCognome+ "\n" + indexOggetto +"\n\n"+indexMex;
				
		System.out.println(mex);
		
		
		
		msg.setText(mex); //imposta il contenuto del messaggio
		

		// invia l'email
		Transport.send(msg);

	}
}
