package gestioneRicevimento;

import java.sql.SQLException;
import java.util.Calendar;

import Model.Ricevimento;
import Model.RicevimentoModel;

public class RicevimentoStudente 
{
	
   public void prenota(Ricevimento r,Calendar c){
	try 
	{
		rm.doSave(r,c);
	} catch (SQLException e) 
	{
		System.out.println("Eccezione nel prenota");
		
	}
	
   } 
   private RicevimentoModel rm= new RicevimentoModel();
}
