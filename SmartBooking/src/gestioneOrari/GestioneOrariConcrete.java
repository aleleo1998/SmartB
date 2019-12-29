/**
 * 
 */
package gestioneOrari;

import java.util.ArrayList;

import Model.DisponibilitaModel;
import Model.Docente;

/**
 * @author ozne2
 *
 */
public class GestioneOrariConcrete implements GestioneOrari {
	
	public void aggiungiFirstOrario(String mDocente,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) {
	
		OrariDocControl.aggiungiFirstOrario(String mDocente,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine);
	}
	
	
	
	private OrariDocControl = new OrariDocControl();
	

}
