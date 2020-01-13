package gestioneUtenti;

import java.sql.SQLException;

/**
 * GestioneUtentiConrete è una classe che implementa i metodi dell'interfaccia GestioneUtenti
 */

import Model.Studente;
import Model.Docente;
import Model.Utente;
import gestioneMail.GestioneMail;

/**
 * 
 * @author carminesorrentino
 * 
 * La classe GestioneUtentiConcrete si occupa di implementare tutte le funzionalità descritte nell’interfaccia GestioneUtenti
 *
 */
public class GestioneUtentiConcrete implements GestioneUtenti {

	
	/**
	 * Il metodo cambiaPassword(Utente u,String vecchiaPassword, String nuovaPassword) permette di modificare la password dell'Utente u passato come parametro, rendendo attuale la password
	 * "nuovaPassword" passata come argomento. Restituisce true se l'aggiornamento va a buon fine, false altrimenti.
	 * @param Utente u
	 * @param String vecchiaPassword
	 * @param String nuovaPassword
	 * @return boolean b
	 */
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
	
	
	/**
	 * Il metodo ripristinaPasswordEmail(String email) permette di ripristinare la password dell'utente con indirizzo email corrispondente alla mail passata come argomento.
	 * Restituisce true se l'operazione va a buon fine, false altrimenti.
	 * @param String email
	 * @return boolean b
	 *
	 */
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
	 * Il metodo registrazioneStudente(Studente s) inserisce nel database, nella tabella ACALE.Studente lo studente passato come argomento.
	 * Il metodo restituisce true se la procedura va a buon fine, altrimenti restituisce false.
	 * @param Studente s
	 * @return boolean b
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

	
	/**
	 * Il metodo ripristinaPassword(Utente u, String nuovaPassword) permette di aggiornare la password relativa all'utente u con la stringa "nuovaPassword" passata come argomento.
	 * Il metodo restituisce true se la procedura va a buon fine, false altrimenti.
	 * @param Utente u
	 * @param String nuovaPassword
	 * @return boolean b
	 */
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
	 * Il metodo registrazioneDocente(Docente doc) inserisce nel database, nella tabella ACALE.Docente il docente passato come argomento.
	 * Il metodo restituisce true se la procedura va a buon fine, altrimenti restituisce false.
	 * @param Docente doc
	 * @return boolean b
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
	 * Il metodo rimuoviDocente(Strina matricola) rimuove dal database, dalla tabella ACALE.Docente il docente con matricola uguale alla String matricola passata come argomento del metodo.
	 * Il metodo restituisce true se la procedura va a buon fine, altrimenti restituisce false.
	 * @param Docente doc
	 * @return boolean b
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
	 * @param String email 
	 * @param String password
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
	
	
	/**
	 * Il metodo cercaStudente(String matricola) ricerca uno studente all'interno della tabella ACALE.Studente del database con matricola uguale alla String matricola passata come argomento del metodo.
	 * Se viene trovata una corrispondenza restituisce lo Studente con le relative informazioni, altrimenti restituisce null.
	 * @param String matricola
	 * @return Studente s
	 */
	public Studente cercaStudente(String matricola){
		
		return registrazione.findStudenteByKey(matricola);
		
	}
	
	/**
<<<<<<< HEAD
	 * Il metodo checkMatricolaDocente(String matricola) verifica se nel database, nella tabella ACALE.Docente esiste una corrispondenza per la matricola passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String matricola
	 * @return boolean b
	 * @throws Exception
=======
	 * Verifica la matricola del docente
	 * @param matricola matricola da verificare
	 * @return true se la matricola non esiste, false altrimenti
>>>>>>> branch 'master' of https://github.com/ozne23/SmartB.git
	 */
	public boolean checkMatricolaDocente(String matricola) throws Exception{
		
		return docente.matricolaExist(matricola);
	
	}
	
	/**
	 * Il metodo checkEmailDocente(String email) verifica se nel database, nella tabella ACALE.Docente esiste una corrispondenza per la mail passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String email
	 * @return boolean b
	 * @throws Exception
	 */
	public boolean checkEmailDocente(String email) throws Exception{

		return docente.checkMailDocente(email);
	}
	
	/**
	 * Il metodo cercaEmail(String email) verifica se nel database, nella tabella ACALE.Studente esiste una corrispondenza per la mail passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String email
	 * @return boolean b
	 */
	public boolean cercaEmail(String email) {
		
		return  registrazione.verificaMail(email);
		
	}
	
	/**
	 * Il metodo cercaMatricola(String matricola) verifica se nel database, nella tabella ACALE.Studente esiste una corrispondenza per la matricola passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String matricola
	 * @return boolean b
	 */
	public boolean cercaMatricola(String matricola) {
		
		return registrazione.verificaMatricola(matricola);
		
	}
	

	/**
	 * Il metodo cercaDocente(String matricola) ricerca un docente all'interno della tabella ACALE.Docente del database con matricola uguale alla String matricola passata come argomento del metodo.
	 * Se viene trovata una corrispondenza restituisce lo Studente con le relative informazioni, altrimenti restituisce null.
	 * @param String matricola
	 * @return Docente docente
	 */
	public Docente cercaDocente(String matricola) {
		return docente.findDoc(matricola);
	}
	
	/**
	 * Il metodo doRetrieveByKey(String matricola) prende un utente dal database attraverso la matricola passata come parametro.
	 * @param String matricola
	 * @return Utente u
	 * @throws SQLException
	 */
	public Utente doRetriveByKey(String matricola) throws SQLException{
		
		return login.doRetriveByKey(matricola);
		
	}
	
	
	private GestionePassword password = new GestionePassword();
	private GestioneRegistrazioneStudente registrazione = new GestioneRegistrazioneStudente();
	private GestioneDocente docente = new GestioneDocente();
	private GestioneLoginUtenti login = new GestioneLoginUtenti();
	private GestioneEmailStudente mail = new GestioneEmailStudente();
	
	
}
