/**
 * 
 */
package gestioneOrari;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Docente;
import Model.RichiestaModOrario;

/**
 *
 *
 *
 * 
 * 
 * Interfaccia del sottosistema GestioneOrari, offre funzionalità di aggiungere un orario ad un docente, inoltrari richieste di midifica orario e 
 * permette di gestire alla segreteria quest'ultime
 *
 */
public interface GestioneOrari {
	
	/**
	 * @param d
	 * @param giorni
	 * @param orariInizio
	 * @param orariFine
	 * @throws SQLException
	 * 
	 * Aggiunge per la prima volta l'orario ad un docente
	 */
	public void aggiungiFirstOrario(String d,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) throws SQLException;
	
	
	/**
	 * @param richiesta
	 * @throws SQLException
	 * 
	 * Inoltra le richiesta di modifica orario da parte del docente
	 */
	public void inoltraRichiesta(RichiestaModOrario richiesta)throws SQLException;
	
	
	/**
	 * @param id
	 * @return
	 * 
	 * Accetta le richieste di modifica orario
	 */
	public boolean accettaRichiesta(int id);
	
	
	/**
	 * @param id
	 * @return
	 * 
	 * Rifiuta le richieste di modifica orario
	 */
	public boolean rifiutaRichiesta(int id);
	

}
