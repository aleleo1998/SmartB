package gestioneUtenti;

import java.sql.SQLException;

import Model.Studente;
import Model.StudenteModel;

/**
 * 
 * @author carminesorrentino
 * 
 * La classe GestioneRegistrazioneStudente si occupa della gestione della registrazione dal punto di vista dello studente.
 *
 */
public class GestioneRegistrazioneStudente {
	
	public GestioneRegistrazioneStudente() {}
	
	/**
	 * Il metodo registraStudente(Studente studente) prende in input uno studente e lo va ad inserire in maniera persistente all'interno del database
	 * @param studente
	 */

	public void registraStudente(Studente studente) {
		StudenteModel sm = new StudenteModel();
		try {
			sm.doSave(studente);
			System.out.println("\nStudente aggiunto correttamente al Database");
		}catch(Exception e) {
			System.out.println("\nErrore nel metodo registraStudente(Studente studente) della classe GestioneRegistrazioneStudente");
			e.printStackTrace();
		}
	}
	
	
	public Studente findStudenteByKey(String matricola){
		
		StudenteModel sm = new StudenteModel();
		
		try {
			return sm.doRetrieveByKey(matricola);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean verificaMatricola(String matricola) {
		
		StudenteModel sm = new StudenteModel();
		try {
			if(sm.existMatricolaIntoDB(matricola)) {
				System.out.println("Matricola esistente nel DB");
				return false;
			}else {
				System.out.println("Matricola non esistente nel DB");
				return true;
				
			}
				}catch(Exception e) {
					return false;
				}
	}

}
