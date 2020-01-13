package gestioneOrari;

import java.sql.SQLException;

import Model.DisponibilitaModel;
import Model.RichiestaModOrario;
import Model.RichiestaModOrarioModel;

/**
 * Permette la gestione degli orari da parte della segreteria
 *
 */
public class OrariSegControl {
	
	public OrariSegControl(){}
	
	
	/**
	 * @param id
	 * @return
	 * 
	 * Permette di rifiutare una richiesta di modifica orario
	 */
	public boolean rifiutaRichiesta(int id){
		
		RichiestaModOrarioModel rm = new RichiestaModOrarioModel();
		
		try {
			rm.doDelete(id);
			
			//INVIO EMAIL
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		
		
	}
	
	/**
	 * @param id
	 * @return
	 * 
	 * Permette di accettare una richiesta di modifica orario
	 */
	
public boolean accettaRichiesta(int id){
		
		RichiestaModOrarioModel rm = new RichiestaModOrarioModel();
		
		try {
			rm.doDelete(id);
			
			//INVIO EMAIL
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		
		
	}

}
