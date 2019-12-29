package gestioneUtenti;

import java.sql.SQLException;

import Model.Studente;
import Model.Docente;
import Model.Utente;

public interface GestioneUtenti {
	
	public Boolean cambiaPassword(Utente u,String vecchiaPassword,String nuovaPassword);
	public Boolean ripristinaPasswordEmail(String email);
	public Boolean registrazioneStudente(Studente studente);
	public Boolean ripristinaPassword(Utente u , String nuovaPassword);
	public Boolean registrazioneDocente(Docente d);
	
}
