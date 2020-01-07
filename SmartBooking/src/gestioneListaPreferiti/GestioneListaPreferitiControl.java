package gestioneListaPreferiti;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Model.Docente;
import Model.ListaPreferitiModel;
import Model.Studente;

public class GestioneListaPreferitiControl implements GestioneListaPreferiti {
	
	
	
	
	

	@Override
	public boolean addDocente(Docente d, Studente s) {
		// TODO Auto-generated method stub
		// chiama model e aggiungi le due matricole 
		ListaPreferitiModel model = new ListaPreferitiModel();
		
		try {
			model.addDocente(d, s);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeDocente(Docente d, Studente s) {
		// TODO Auto-generated method stub
		// chiama model passando le due matricole 
		ListaPreferitiModel model = new ListaPreferitiModel();
		
		try {
			model.removeDocente(d,s);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean trovaCorrispondenza(String matDoc, String matStud) throws Exception{
		ListaPreferitiModel lpm = new ListaPreferitiModel();
		
		try {
			if(lpm.existIntoDB(matDoc,matStud)) //se esiste corrispondenza
				return true;
			else
				return false;
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Errore");

		}
		
	}

}
