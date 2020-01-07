package gestioneRicevimento;

import java.util.Calendar;

import Model.Ricevimento;

public class GestioneRicevimentoConcrete implements GestioneRicevimento
{
	public boolean accettaRicevimento(Ricevimento r)
	{
		return rd.accetta(r);
	}
	public void prenotaRicevimento(Ricevimento r,Calendar c) 
	{
		 rs.prenota(r,c);
	}
	public boolean cancellaRicevimento(Ricevimento r) 
	{
		return rd.cancellaRiv(r);
	}
	
	private RicevimentoDocente rd= new RicevimentoDocente();
	private RicevimentoStudente rs= new RicevimentoStudente();
}
