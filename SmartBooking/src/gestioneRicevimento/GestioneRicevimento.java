package gestioneRicevimento;

import java.util.Calendar;

import Model.Ricevimento;

public interface GestioneRicevimento {
	
	public boolean accettaRicevimento(Ricevimento r);
	public void prenotaRicevimento(Ricevimento r,Calendar c);
	public boolean cancellaRicevimento(Ricevimento r);
	

}
