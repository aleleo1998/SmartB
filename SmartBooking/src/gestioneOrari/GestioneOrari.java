/**
 * 
 */
package gestioneOrari;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Docente;
import Model.RichiestaModOrario;

/**
 * @author ozne2
 *
 */
public interface GestioneOrari {
	
	public void aggiungiFirstOrario(String d,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) throws SQLException;
	public void inoltraRichiesta(RichiestaModOrario richiesta)throws SQLException;
	public boolean accettaRichiesta(int id);
	public boolean rifiutaRichiesta(int id);
	

}
