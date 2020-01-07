package gestioneOrari;

import java.sql.SQLException;

import Model.RichiestaModOrarioModel;

public class OrariSegControl {
	
	public OrariSegControl(){}
	
	
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
