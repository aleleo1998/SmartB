package gestioneUtenti;

import java.sql.SQLException;

import Model.Utente;

public interface GestioneUtenti {
	
	public Boolean cambiaPassword(Utente u,String vecchiaPassword,String nuovaPassword);
	
}
