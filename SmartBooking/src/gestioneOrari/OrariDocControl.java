package gestioneOrari;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.DisponibilitaModel;
import Model.RichiestaModOrario;
import Model.RichiestaModOrarioModel;

/**
 * 
 * 
 * 
 * Gestisce gli orari di un docente
 *
 */
public class OrariDocControl {
	
	public OrariDocControl(
			
			){}
	
	/**
	 * @param mDocente
	 * @param giorni
	 * @param orariInizio
	 * @param orariFine
	 * @throws SQLException
	 * 
	 * 
	 * Permette di aggiungere per la prima volta l'orario ad un docente
	 */
	public void aggiungiFirstOrario(String mDocente,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) throws SQLException{
		
		DisponibilitaModel  disponibilitaModel = new DisponibilitaModel();
		
		int i = 0;
		
		for(i= 0; i<giorni.size();i++){
			
			System.out.println("Il for è eseguito: "+i);
			
			
			disponibilitaModel.aggiungiOrario(mDocente, giorni.get(i), orariInizio.get(i), orariFine.get(i));
			
		}
		
	}
	
	
	
/**
 * @param mDocente
 * @param giorno
 * @param oraroInizio
 * @param oraroFine
 * @throws SQLException
 * 
 * Permette di aggiungere un orario ad un docente
 */
public void aggiungiOrario(String mDocente,String giorno,String oraroInizio, String oraroFine) throws SQLException{
		
		DisponibilitaModel  disponibilitaModel = new DisponibilitaModel();
		
			disponibilitaModel.aggiungiOrario(mDocente, giorno, oraroInizio, oraroFine);
			
		
		
	}
	
	public void creaRichiestaModificaOrario(RichiestaModOrario richiesta) throws SQLException {
		RichiestaModOrarioModel  model = new RichiestaModOrarioModel();
		
		model.doSave(richiesta);
		
		
	}
	
	
	
	/**
	 * @param matDoc
	 * @param giorno
	 * @throws SQLException
	 * 
	 * Permette di eliminare un orario
	 */
	public void delete(String matDoc, String giorno) throws SQLException{
		DisponibilitaModel  disponibilitaModel = new DisponibilitaModel();
		
		try {
			disponibilitaModel.doDelete(matDoc, giorno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("Cancellazione Fallita");
		}
		
	}

}
