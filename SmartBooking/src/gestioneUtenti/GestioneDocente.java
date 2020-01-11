package gestioneUtenti;

import java.sql.SQLException;

import Model.Docente;
import Model.DocenteModel;
import Model.StudenteModel;

public class GestioneDocente {
	
	public GestioneDocente() {}


	/**
	 * Registrazione Docente
	 * @param d docente da registrare
	 * @throws SQLException
	 */
	public void registrazioneDocente(Docente d) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		docModel.doSave(d);	
	}

	/**
	 * Rimuovere un docente registrato dalla piattaforma
	 * @param matricola matricola del docente da rimuovere
	 * @throws SQLException
	 */
	public void rimuoviDocente(String matricola) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		//System.out.println(matricola);
		docModel.doDelete(matricola);
	}
	
	
	public boolean matricolaExist(String matricola) throws Exception{
		
		DocenteModel docM = new DocenteModel();
		
		try {
			if(docM.existMatricola(matricola)){
				
				return true;
				
			}else{
				
				return false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Errore");
		}
		
	}
	
	public boolean checkMailDocente(String email) {
		DocenteModel dm = new DocenteModel();
		try {
			if(dm.existEmail(email)) {
				System.out.println("Mail esistente nel DB");
				return false; //se l'email � presente nel db ritorna false
			}else {
				System.out.println("Mail non esistente nel DB");
				return true; //se l'email NON � presente nel db ritorna true
				
			}
				}catch(Exception e) {
					return false;
				}
	}

	//Metodo da aggiungere alla specifica delle interfacce
	public Docente findDoc(String matricola) {
		DocenteModel dm = new DocenteModel();
		
		try {
			return dm.doRetrieveByKey(matricola);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
