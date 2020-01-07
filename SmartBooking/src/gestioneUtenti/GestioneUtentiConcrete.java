package gestioneUtenti;

import java.sql.SQLException;

/**
 * GestioneUtentiConrete è una classe che implementa i metodi dell'interfaccia GestioneUtenti
 */

import Model.Studente;
import Model.Docente;
import Model.Utente;

public class GestioneUtentiConcrete implements GestioneUtenti {

	@Override
	public Boolean cambiaPassword(Utente u, String vecchiaPassword, String nuovaPassword){
		try {
		password.changePassword(u,vecchiaPassword, nuovaPassword);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Boolean ripristinaPasswordEmail(String email) {
		try {
			password.sendResetPasswordEmail(email);
			return true;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
	/**
	 * Il metodo registrazioneStudente(Studente s) si occupa di invocare un metodo tramite il quale lo studente verrà memorizzato in maniera persistente nel database.
	 * @param Studente s
	 */
	
	@Override
	public Boolean registrazioneStudente(Studente s) {
		try {
			registrazione.registraStudente(s);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean ripristinaPassword(Utente u , String nuovaPassword){
		
		try {
			password.changePassword(u,nuovaPassword);
			return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}

	/**
	 * Registrazione docente (segreteria puo aggiungere un nuovo docente)
	 * @param Docente doc docente da inserire 
	 * @return true se � stata invocata correttamente registrazioneDocente(doc), false altrimenti
	 */
	@Override
	public Boolean registrazioneDocente(Docente doc) {
		try {
			docente.registrazioneDocente(doc);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Rimuovi Docente (La segreteria pu� rimuovere un docente)
	 * @param String matricola del docente da rimuovere
	 * @return true se � stata invocata correttamete rimuoviDocente(matricola), false altrimenti
	 */
	@Override
	public Boolean rimuoviDocente(String matricola) {
		try {
			docente.rimuoviDocente(matricola);
			System.out.println(matricola);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**	
	 * Il metodo loginUtente controlla l'accesso verificando se nel database esiste una corrispondenza email/password in una delle tabelle tra Docente,Studente e Segreteria.
	 * @param email 
	 * @param password
	 * @return Utente u
	 */
	@Override
	public Utente loginUtente(String email,String password) {
		try {
			return login.controlloAccesso(email, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Studente cercaStudente(String matricola){
		
		return registrazione.findStudenteByKey(matricola);
		
	}
	
	public boolean checkMatricolaDocente(String matricola) throws Exception{
		
		return docente.matricolaExist(matricola);
		
	}
	
	
	private GestionePassword password = new GestionePassword();
	private GestioneRegistrazioneStudente registrazione = new GestioneRegistrazioneStudente();
	private GestioneDocente docente = new GestioneDocente();
	private GestioneLoginUtenti login = new GestioneLoginUtenti();
}
