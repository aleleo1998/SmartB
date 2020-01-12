package gestioneUtenti;

import java.sql.SQLException;

import Model.Studente;
import Model.StudenteModel;

/**
 * 
 * @author carminesorrentino
 * 
 * La classe GestioneRegistrazioneStudente si occupa di andare a inserire in maniera persistente i dati di uno studente nel 
 * database e di andare ad effettuare delle query per controllare tramite matricola o email se lo studente è presente nel database.
 *
 */
public class GestioneRegistrazioneStudente {
	
	public GestioneRegistrazioneStudente() {}
	
	/**
	 * Il metodo registraStudente(Studente studente) prende in input uno studente e lo va ad inserire in maniera persistente all'interno del database
	 * @param Studente studente
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
	
	/**
	 * Il metodo findStudenteByKey(String matricola) ricerca nel database uno studente con la matricola uguale al parametro passato come argomento.
	 * Se lo studente viene trovato, viene restituito, altrimenti viene restituito un valore null.
	 * @param String matricola
	 * @return Studente s
	 */
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

	/**
	 * Il metodo verificaMatricola(String matricola) ricerca nel database se esiste uno studente con matricola
	 * uguale a quella passata come parametro. Se viene trovato restituisce true, altrimenti restituisce false.
	 * @param String matricola
	 * @return boolean b
	 */
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
	
	/**
	 * Il metodo verificaMail(String email) ricerca nel database se esiste uno studente con email
	 * uguale a quella passata come parametro. Se viene trovato restituisce true, altrimenti restituisce false.
	 * @param String email
	 * @return boolean b
	 */
	public boolean verificaMail(String email) {
		StudenteModel sm = new StudenteModel();
		try {
			if(sm.existIntoDB(email)) {
				System.out.println("Mail esistente nel DB");
				return false;
			}else {
				System.out.println("Mail non esistente nel DB");
				return true;
				
			}
				}catch(Exception e) {
					return false;
				}
	}


}
