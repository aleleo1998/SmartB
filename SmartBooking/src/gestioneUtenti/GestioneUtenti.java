package gestioneUtenti;

import java.sql.SQLException;

/**
 * Interfaccia per il sottosistema GestioneUtenti.
 */

import Model.Studente;
import Model.Docente;
import Model.Utente;

public interface GestioneUtenti {
	
	public Boolean cambiaPassword(Utente u,String vecchiaPassword,String nuovaPassword);
	public Boolean ripristinaPasswordEmail(String email);
	public Boolean registrazioneStudente(Studente studente);
	public Boolean ripristinaPassword(Utente u , String nuovaPassword);
	public Boolean registrazioneDocente(Docente d);
	public Boolean rimuoviDocente(String matricola);
	public Utente loginUtente(String email,String password);
	public Studente cercaStudente(String matricola);
	public boolean checkMatricolaDocente(String matricola) throws Exception;
	
}
