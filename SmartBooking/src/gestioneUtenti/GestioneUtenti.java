package gestioneUtenti;

import java.sql.SQLException;

/**
 * GestioneUtenti è un’interfaccia che viene implementata dalla classe “GestioneUtentiConcrete” e contiene 
 * la specifica di tutti i metodi che verranno utilizzati per realizzare il sottosistema per la gestione degli utenti.
 */


import Model.Studente;
import Model.Docente;
import Model.Utente;

public interface GestioneUtenti {
	
	/**
	 * Il metodo cambiaPassword(Utente u,String vecchiaPassword, String nuovaPassword) permette di modificare la password dell'Utente u passato come parametro, rendendo attuale la password
	 * "nuovaPassword" passata come argomento. Restituisce true se l'aggiornamento va a buon fine, false altrimenti.
	 * @param Utente u
	 * @param String vecchiaPassword
	 * @param String nuovaPassword
	 * @return boolean b
	 */
	public boolean cambiaPassword(Utente u,String vecchiaPassword,String nuovaPassword);
	
	/**
	 * Il metodo ripristinaPasswordEmail(String email) permette di ripristinare la password dell'utente con indirizzo email corrispondente alla mail passata come argomento.
	 * Restituisce true se l'operazione va a buon fine, false altrimenti.
	 * @param String email
	 * @return boolean b
	 *
	 */
	public boolean ripristinaPasswordEmail(String email);
	
	/**
	 * Il metodo registrazioneStudente(Studente s) inserisce nel database, nella tabella ACALE.Studente lo studente passato come argomento.
	 * Il metodo restituisce true se la procedura va a buon fine, altrimenti restituisce false.
	 * @param Studente s
	 * @return boolean b
	 */
	public boolean registrazioneStudente(Studente studente);
	
	/**
	 * Il metodo ripristinaPassword(Utente u, String nuovaPassword) permette di aggiornare la password relativa all'utente u con la stringa "nuovaPassword" passata come argomento.
	 * Il metodo restituisce true se la procedura va a buon fine, false altrimenti.
	 * @param Utente u
	 * @param String nuovaPassword
	 * @return boolean b
	 */
	public boolean ripristinaPassword(Utente u , String nuovaPassword);
	
	/**
	 * Il metodo registrazioneDocente(Docente doc) inserisce nel database, nella tabella ACALE.Docente il docente passato come argomento.
	 * Il metodo restituisce true se la procedura va a buon fine, altrimenti restituisce false.
	 * @param Docente doc
	 * @return boolean b
	 */
	public boolean registrazioneDocente(Docente d);
	
	/**
	 * Il metodo rimuoviDocente(Strina matricola) rimuove dal database, dalla tabella ACALE.Docente il docente con matricola uguale alla String matricola passata come argomento del metodo.
	 * Il metodo restituisce true se la procedura va a buon fine, altrimenti restituisce false.
	 * @param Docente doc
	 * @return boolean b
	 */
	public boolean rimuoviDocente(String matricola);
	
	/**	
	 * Il metodo loginUtente controlla l'accesso verificando se nel database esiste una corrispondenza email/password in una delle tabelle tra Docente,Studente e Segreteria.
	 * @param String email 
	 * @param String password
	 * @return Utente u
	 */
	public Utente loginUtente(String email,String password);
	
	/**
	 * Il metodo cercaStudente(String matricola) ricerca uno studente all'interno della tabella ACALE.Studente del database con matricola uguale alla String matricola passata come argomento del metodo.
	 * Se viene trovata una corrispondenza restituisce lo Studente con le relative informazioni, altrimenti restituisce null.
	 * @param String matricola
	 * @return Studente s
	 */
	public Studente cercaStudente(String matricola);
	
	/**
	 * Il metodo checkMatricolaDocente(String matricola) verifica se nel database, nella tabella ACALE.Docente esiste una corrispondenza per la matricola passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String matricola
	 * @return boolean b
	 * @throws Exception
	 */
	public boolean checkMatricolaDocente(String matricola) throws Exception;
	
	/**
	 * Il metodo cercaEmail(String email) verifica se nel database, nella tabella ACALE.Studente esiste una corrispondenza per la mail passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String email
	 * @return boolean b
	 */
	public boolean cercaEmail(String email);
	
	/**
	 * Il metodo checkEmailDocente(String email) verifica se nel database, nella tabella ACALE.Docente esiste una corrispondenza per la mail passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String email
	 * @return boolean b
	 * @throws Exception
	 */
	public boolean checkEmailDocente(String email) throws Exception;
	
	/**
	 * Il metodo cercaMatricola(String matricola) verifica se nel database, nella tabella ACALE.Studente esiste una corrispondenza per la matricola passata come argomento.
	 * Se esiste una corrispondenza, il metodo restituisce true, altrimenti restituisce false.
	 * @param String matricola
	 * @return boolean b
	 */
	public boolean cercaMatricola(String matricola);
	
	/**
	 * Il metodo cercaDocente(String matricola) ricerca un docente all'interno della tabella ACALE.Docente del database con matricola uguale alla String matricola passata come argomento del metodo.
	 * Se viene trovata una corrispondenza restituisce lo Studente con le relative informazioni, altrimenti restituisce null.
	 * @param String matricola
	 * @return Docente docente
	 */
	public Docente cercaDocente(String matricola);
}
