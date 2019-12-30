package gestioneRicevimento;

import java.sql.SQLException;

import Model.Ricevimento;
import Model.RicevimentoModel;

public class RicevimentoDocente 
{

public boolean accetta(Ricevimento r) 
{
	try {
		rm.changeState(r.getId(),"Accettato");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		return false;
	}
	return true;
}

public boolean cancellaRiv(Ricevimento r)
{
	try {
		rm.doDelete(r.getId());
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

public boolean aggiungiRiv(Ricevimento r)
{
	try {
		rm.doSave(r);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return true;
}
private RicevimentoModel rm = new RicevimentoModel();
}
