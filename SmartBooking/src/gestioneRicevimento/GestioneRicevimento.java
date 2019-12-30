package gestioneRicevimento;

import Model.Ricevimento;

public interface GestioneRicevimento {
	
	public boolean accettaRicevimento(Ricevimento r);
	public void prenotaRicevimento(Ricevimento r);
	public boolean cancellaRicevimento(Ricevimento r);
	public boolean aggiungiRicevimento(Ricevimento r);

}
