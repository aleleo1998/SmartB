package gestioneUtenti;

import Model.Utente;
import Model.UtenteModel;

/**
 * 
 * @author carminesorrentino
 * 
 * La classe GestioneLoginUtenti si occupa della ricerca nel database in una tabella tra Docente,Studente
 * e Segreteria della corrispondenza email/password per l’accesso.
 *
 */

public class GestioneLoginUtenti {
	
	public GestioneLoginUtenti() {}
	
	/**
	 * 
	 * Il metodo controlloAccesso(String email,String password) controlla l'accesso verificando se nel database esiste una corrispondenza email/password in una delle tabelle tra Docente,Studente e Segreteria.
	 * 
	 * @param String email
	 * @param String password
	 * @return Utente u
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
