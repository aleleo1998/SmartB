package gestioneUtenti;

import java.sql.SQLException;

import Model.Docente;
import Model.DocenteModel;

public class GestioneDocente {
	
	public GestioneDocente() {}
	
<<<<<<< HEAD
	public void registrazioneDocente(Docente d) throws SQLException 
	{
=======
	/**
	 * Registrazione Docente
	 * @param d docente da registrare
	 * @throws SQLException
	 */
	public void registrazioneDocente(Docente d) throws SQLException {
>>>>>>> branch 'master' of https://github.com/ozne23/SmartB.git
		DocenteModel docModel = new DocenteModel();
		docModel.doSave(d);	
	}

	/**
	 * Rimuovere un docente registrato dalla piattaforma
	 * @param matricola matricola del docente da rimuovere
	 * @throws SQLException
	 */
	public void rimuoviDocente(String matricola) throws SQLException {
		DocenteModel docModel = new DocenteModel();
		//System.out.println(matricola);
		docModel.doDelete(matricola);
	}
	
	
}
