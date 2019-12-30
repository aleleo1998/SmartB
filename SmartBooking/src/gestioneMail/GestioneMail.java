package gestioneMail;

public interface GestioneMail {
	public void sendEmail(String host, String port, final String userName, final String password, 
			String emailMittente, String emailDestinatario, String nome, String cognome, String subject, String content);
	
	
	

}
