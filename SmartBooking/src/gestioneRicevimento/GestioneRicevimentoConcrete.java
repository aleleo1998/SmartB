package gestioneRicevimento;

import Model.Ricevimento;

public class GestioneRicevimentoConcrete implements GestioneRicevimento
{
	public boolean accettaRicevimento(Ricevimento r)
	{
		return rd.accetta(r);
	}
	public void prenotaRicevimento(Ricevimento r) 
	{
		 rs.prenota(r);
	}
	public boolean cancellaRicevimento(Ricevimento r) 
	{
		return rd.cancellaRiv(r);
	}
	public boolean aggiungiRicevimento(Ricevimento r) 
	{
		return rd.aggiungiRiv(r);
	}
	private RicevimentoDocente rd= new RicevimentoDocente();
	private RicevimentoStudente rs= new RicevimentoStudente();
}
