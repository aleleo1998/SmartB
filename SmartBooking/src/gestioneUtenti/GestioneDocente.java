package gestioneUtenti;

import java.sql.SQLException;

import Model.Docente;
import Model.DocenteModel;

public class GestioneDocente {
	
	public GestioneDocente() {}
	
	public void registrazioneDocente(Docente d) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		docModel.doSave(d);	
	}

	public void rimuoviDocente(String matricola) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		//System.out.println(matricola);
		docModel.doDelete(matricola);
	}
	
	
}
