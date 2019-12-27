package gestioneUtenti;

import java.sql.SQLException;

import Model.Utente;
import Model.UtenteModel;


public class GestionePassword {
	
	public GestionePassword() {}
	
	public void changePassword(Utente u,String vecchiaPassword,String nuovaPassword) throws SQLException {
		
		System.out.println("Passwordddd: "+u.getPassword());
		if(u.getPassword().equals(vecchiaPassword)) {
			System.out.println("Sono uguali");
			UtenteModel utente = new UtenteModel();
			
			utente.changePassword(nuovaPassword,u);
		}
	}

}
