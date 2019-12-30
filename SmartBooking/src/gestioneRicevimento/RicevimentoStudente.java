package gestioneRicevimento;

import java.sql.SQLException;

import Model.Ricevimento;
import Model.RicevimentoModel;

public class RicevimentoStudente 
{
	
   public void prenota(Ricevimento r){
	try 
	{
		rm.doSave(r);
	} catch (SQLException e) 
	{
		System.out.println("Eccezione nel prenota");
		
	}
	
   } 
   private RicevimentoModel rm= new RicevimentoModel();
}
