package gestioneUtenti;

import java.sql.SQLException;

/**
 * Interfaccia per il sottosistema GestioneUtenti.
 */

import Model.Studente;
import Model.Docente;
import Model.Utente;

public interface GestioneUtenti {
	
	public boolean cambiaPassword(Utente u,String vecchiaPassword,String nuovaPassword);
	public boolean ripristinaPasswordEmail(String email);
	public boolean registrazioneStudente(Studente studente);
	public boolean ripristinaPassword(Utente u , String nuovaPassword);
	public boolean registrazioneDocente(Docente d);
	public boolean rimuoviDocente(String matricola);
	public Utente loginUtente(String email,String password);
	public Studente cercaStudente(String matricola);
	public boolean checkMatricolaDocente(String matricola) throws Exception;
	public boolean cercaEmail(String email);
	public boolean checkEmailDocente(String email) throws Exception;
	public boolean cercaMatricola(String matricola);
	
}
