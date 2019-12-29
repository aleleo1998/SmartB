/**
 * 
 */
package gestioneOrari;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.DisponibilitaModel;
import Model.Docente;

/**
 * @author ozne2
 *
 */
public class GestioneOrariConcrete implements GestioneOrari {
	
	public GestioneOrariConcrete(){
		orariDocControl = new OrariDocControl();
	}
	
	public void aggiungiFirstOrario(String mDocente,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) throws SQLException {
	
		orariDocControl.aggiungiFirstOrario( mDocente, giorni, orariInizio, orariFine);
	}
	
	
	
	private OrariDocControl orariDocControl;
	

}
