package gestioneUtenti;

import Model.Utente;
import Model.UtenteModel;

/**
 * 
 * @author carminesorrentino
 * 
 * GestioneLoginUtenti è una classe che si occupa della funzionalità relativa al Login.
 *
 */

public class GestioneLoginUtenti {
	
	public GestioneLoginUtenti() {}
	
	/**
	 * 
	 * Il metodo controlloAccesso(String email,String password) controlla l'accesso verificando se nel database esiste una corrispondenza email/password in una delle tabelle tra Docente,Studente e Segreteria.
	 * 
	 * @param email
	 * @param password
	 * @return Utente
	 */
	
	public Utente controlloAccesso(String email,String password) {
		
		UtenteModel um = new UtenteModel();
		
		try {
		 return um.checkLogin(email, password);
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
