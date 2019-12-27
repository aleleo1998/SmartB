package gestioneUtenti;

import java.sql.SQLException;

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
	
	private GestionePassword password = new GestionePassword();

}
