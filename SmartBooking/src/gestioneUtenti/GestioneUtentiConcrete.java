package gestioneUtenti;

import java.sql.SQLException;

/**
 * GestioneUtentiConrete è una classe che implementa i metodi dell'interfaccia GestioneUtenti
 */

import Model.Studente;
import Model.Docente;
import Model.Utente;
import gestioneMail.GestioneMail;

public class GestioneUtentiConcrete implements GestioneUtenti {

	@Override
	public boolean cambiaPassword(Utente u, String vecchiaPassword, String nuovaPassword){
		try {
		password.changePassword(u,vecchiaPassword, nuovaPassword);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean ripristinaPasswordEmail(String email) {
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
	public boolean registrazioneStudente(Studente s) {
		try {
			registrazione.registraStudente(s);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ripristinaPassword(Utente u , String nuovaPassword){
		
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
	public boolean registrazioneDocente(Docente doc) {
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
	public boolean rimuoviDocente(String matricola) {
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
	
	/**
	 * Verifica la matricola del docente
	 * @param matricola matricola da verificare
	 * @return true se la matricola non esiste, false altrimenti
	 */
	public boolean checkMatricolaDocente(String matricola) throws Exception{
		
		return docente.matricolaExist(matricola);
	
	}
	
	/**
	 * Verifica la mail del docente
	 * @param email mail da verificare
	 * @return true se la mail non esiste, false altrimenti
	 */
	public boolean checkEmailDocente(String email){
		return docente.checkMailDocente(email);
	}
	
	
	public boolean cercaEmail(String email) {
		
		return  registrazione.verificaMail(email);
		
	}
	
	
	public boolean cercaMatricola(String matricola) {
		
		return registrazione.verificaMatricola(matricola);
		
	}
	
	
	private GestionePassword password = new GestionePassword();
	private GestioneRegistrazioneStudente registrazione = new GestioneRegistrazioneStudente();
	private GestioneDocente docente = new GestioneDocente();
	private GestioneLoginUtenti login = new GestioneLoginUtenti();
	private GestioneEmailStudente mail = new GestioneEmailStudente();
	
}
