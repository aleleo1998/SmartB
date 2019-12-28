package gestioneUtenti;

import java.sql.SQLException;

import Model.Utente;
import Model.UtenteModel;


public class GestionePassword {
	
	public GestionePassword() {}
	
	/**
	 * @param u
	 * @param vecchiaPassword
	 * @param nuovaPassword
	 * @throws SQLException
	 */
	public void changePassword(Utente u,String vecchiaPassword,String nuovaPassword) throws SQLException {
		
		System.out.println("Passwordddd: "+u.getPassword());
		if(u.getPassword().equals(vecchiaPassword)) {
			System.out.println("Sono uguali");
			UtenteModel utente = new UtenteModel();
			
			utente.changePassword(nuovaPassword,u);
		}
	}

	public void sendResetPasswordEmail(String email) {
		// TODO AutR-generated method stub
		
		UtenteModel utente = new UtenteModel();
		try {
			if(utente.checkEmailInDB(email)) {
				//mandare mail server reset?
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
	}

}
