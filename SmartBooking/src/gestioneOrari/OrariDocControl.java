package gestioneOrari;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.DisponibilitaModel;

public class OrariDocControl {
	
	public OrariDocControl(
			
			){}
	
	public void aggiungiFirstOrario(String mDocente,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) throws SQLException{
		
		DisponibilitaModel  disponibilitaModel = new DisponibilitaModel();
		
		int i = 0;
		
		for(i= 0; i<giorni.size();i++){
			
			
			disponibilitaModel.aggiungiOrario(mDocente, giorni.get(i), orariInizio.get(i), orariFine.get(i));
			
		}
		
	}

}
