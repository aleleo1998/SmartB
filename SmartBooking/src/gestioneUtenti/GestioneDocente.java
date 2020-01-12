package gestioneUtenti;

import java.sql.SQLException;

import Model.Docente;
import Model.DocenteModel;
import Model.StudenteModel;

/**
 * 
 * @author carminesorrentino
 *
 *La classe GestioneDocente si occupa di andare a inserire in maniera persistente i dati di un docente nel database e 
 *di andare ad effettuare delle query per controllare tramite matricola o email se il docente è presente nel database.
 *Inoltre prevede query per la cancellazione del docente e per la ricerca.
 *
 */
public class GestioneDocente {
	
	public GestioneDocente() {}


	/**
	 * Il metodo registrazioneDocente(Docente d) consente di memorizzare nel database in maniera persistente il Docente passato come argomento.
	 * @param Docente d
	 * @throws SQLException
	 */
	public void registrazioneDocente(Docente d) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		docModel.doSave(d);	
	}

	/**
	 * Il metodo rimuoviDocente(String matricola) permette di rimuovere dalla tabella ACALE.Docente nel database il docente con matricola uguale a String 'matricola' passata come argomento del metodo.
	 * @param String matricola
	 * @throws SQLException
	 */
	public void rimuoviDocente(String matricola) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		//System.out.println(matricola);
		docModel.doDelete(matricola);
	}
	
	/**
	 * Il metodo matricolaExist(String matricola) consente di ricercare nel database, nella tabella ACALE.Docente se esiste un docente con matricola = String 'matricola' passata come argomento del metodo.
	 * Nel caso in cui esiste una corrispondenza il metodo restituisce true, altrimenti false.
	 * @param String matricola
	 * @return boolean b
	 * @throws Exception
	 */
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
	
	/**
	 * Il metodo checkMailDocente(String email) consente di ricercare nel database, nella tabella ACALE.Docente se esiste un docente con email = String 'email' passata come argomento del metodo.
	 * Nel caso in cui esiste una corrispondenza il metodo restituisce true, altrimenti false.
	 * @param String email
	 * @return boolean b
	 * @throws Exception
	 */
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

	/**
	 * Il metodo findDoc(String matricola)consente di ricercare nel database, nella tabella ACALE.Docente se esiste un docente con matricola = String 'matricola' passata come argomento del metodo.
	 * Nel caso in cui esiste una corrispondenza il metodo restituisce il Docente, altrimenti restituisce null.
	 * @param String matricola
	 * @return Docente docente
	 */
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
