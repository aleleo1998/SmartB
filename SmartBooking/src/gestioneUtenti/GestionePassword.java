package gestioneUtenti;

import java.sql.SQLException;

import Model.Utente;
import Model.UtenteModel;
import encryption.EncryptionUtils;


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
	
	public void changePassword(Utente u,String nuovaPassword) throws SQLException {
		
		System.out.println("Passwordddd: "+u.getPassword());
			UtenteModel utente = new UtenteModel();
			
			utente.changePassword(nuovaPassword,u);
		
	}

	public void sendResetPasswordEmail(String email) {
		// TODO AutR-generated method stub
		
		UtenteModel utente = new UtenteModel();
		try {
			Utente u = utente.retrieveByEmail(email);
			if(u != null) {
				String matCriptata = EncryptionUtils.encryptMatricola(u.getMatricola());
				String url = "http://localhost:8080/SmartBooking/jsp/CambioRipristinoPassword.jsp?mat="+matCriptata;
				System.out.println(url);
				
				//Invio email
				
				
			}
				
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		}
	

}
