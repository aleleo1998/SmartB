/**
 * 
 */
package gestioneOrari;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.DisponibilitaModel;
import Model.Docente;
import Model.RichiestaModOrario;
import Model.RichiestaModOrarioModel;

/**
 *
 *
 *
 * 
 *
 *Implementa i metodi che mette a disposizione l'interfaccia GestioneOrari
 */
public class GestioneOrariConcrete implements GestioneOrari {
	
	public GestioneOrariConcrete(){
		orariDocControl = new OrariDocControl();
		orariSegControl = new OrariSegControl();
	}
	
	
	/* (non-Javadoc)
	 * @see gestioneOrari.GestioneOrari#aggiungiFirstOrario(java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
	 */
	public void aggiungiFirstOrario(String mDocente,ArrayList<String> giorni,ArrayList<String> orariInizio, ArrayList<String> orariFine) throws SQLException {
	
		orariDocControl.aggiungiFirstOrario( mDocente, giorni, orariInizio, orariFine);
	}
	
	/* (non-Javadoc)
	 * @see gestioneOrari.GestioneOrari#inoltraRichiesta(Model.RichiestaModOrario)
	 */
	@Override
	public void inoltraRichiesta(RichiestaModOrario richiesta) throws SQLException {
		// TODO Auto-generated method stub
		
		orariDocControl.creaRichiestaModificaOrario(richiesta);
		
	}
	
	/* (non-Javadoc)
	 * @see gestioneOrari.GestioneOrari#accettaRichiesta(int)
	 */
	public boolean accettaRichiesta(int id){
		
		RichiestaModOrarioModel rm = new RichiestaModOrarioModel();
		
		
			
			try {
				RichiestaModOrario richiesta = rm.doRetrieveByKey(id);
				if(orariSegControl.accettaRichiesta(id)){
					orariDocControl.delete(richiesta.getMatricolaDocente(),richiesta.getGiornoPrecedente());
					orariDocControl.aggiungiOrario(richiesta.getMatricolaDocente(),richiesta.getGiorno(),richiesta.getOraInizio().substring(0, 4),richiesta.getOraFine().substring(0, 4));
					
					return true;
				}
				
				return false;
				
			} catch (SQLException e) {
				
				return false;
				
			}
			
			
			
	}
	
	/* (non-Javadoc)
	 * @see gestioneOrari.GestioneOrari#rifiutaRichiesta(int)
	 */
	public boolean rifiutaRichiesta(int id){
		
		return orariSegControl.rifiutaRichiesta( id);
		
	}




	private OrariDocControl orariDocControl;
	private OrariSegControl orariSegControl;
	

}
