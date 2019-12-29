package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import DBConnection.DriverManagerConnectionPool;

public class UtenteModel {

private static final String TABLE_NAME_STUD = "ACALE.Studente";
private static final String TABLE_NAME_DOC = "ACALE.Docente";
	
	/**
	 * 
	 * @param order: ASC/DESC per ordinare i risultati
	 * @return collezione di docenti trovati
	 * @throws SQLException
	 */
	public synchronized Collection<Utente> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Utente> utenti = new LinkedList<Utente>();

		String selectSQL = "SELECT * FROM " + UtenteModel.TABLE_NAME_STUD + " UNION " + " SELECT * FROM "+ UtenteModel.TABLE_NAME_DOC;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Utente bean = new Utente();

				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				
				utenti.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return utenti;
	}
	

	/**
	 * 
	 * @param matricola: matricola del docente da ricercare
	 * @return bean docente con matricola uguale al parametro matricola
	 * @throws SQLException
	 */
	public synchronized Utente doRetrieveByKey(String matricola) throws SQLException{
		
		StudenteModel sm = new StudenteModel();
		DocenteModel dm = new DocenteModel();
		SegreteriaModel segm = new SegreteriaModel();
		
		Utente bean = sm.doRetrieveByKey(matricola);
		System.out.println(bean);
		if(bean.getMatricola() == null){
			bean = dm.doRetrieveByKey(matricola);
			System.out.println(bean);
		}if(bean.getMatricola() == null){
			bean = segm.doRetrieveByKey(matricola);
			System.out.println(bean);
		}
		
		return bean;
	}

	
	/**
	 * 
	 * @return collezione di tutti i docenti
	 * @throws SQLException
	 */
	public synchronized Collection<Utente> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Utente> utenti = new LinkedList<Utente>();

		String selectSQL = "SELECT * FROM " + UtenteModel.TABLE_NAME_STUD + " UNION " + " SELECT * FROM "+ UtenteModel.TABLE_NAME_DOC;

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Utente bean = new Utente();

				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				
				utenti.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return utenti;
	}
	
	
	/**
	 * 
	 * @param nuovaPassword
	 * @param utente
	 * @return
	 * @throws SQLException
	 */
	public synchronized void changePassword(String nuovaPassword, Utente utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		DocenteModel dm = new DocenteModel();
		StudenteModel sm = new StudenteModel();
		
		String selectSQL = "";
		
		Docente d = dm.doRetrieveByKey(utente.getMatricola());
		
		//connection = DriverManagerConnectionPool.getDbConnection();
		
		
		if(d.getMatricola() != null) {
			selectSQL = "UPDATE Docente SET password='"+nuovaPassword+"' WHERE matricola='"+utente.getMatricola()+"';";
		}
		else {
			Studente s = sm.doRetrieveByKey(utente.getMatricola());
			
			selectSQL = "UPDATE "+ TABLE_NAME_STUD + " SET password = ? WHERE matricola = ?;";
		}
		
		try {
			//connection = DriverManagerConnectionPool.createDBConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			//preparedStatement.setString(1, nuovaPassword);
			//preparedStatement.setString(2,utente.getMatricola());
			
			System.out.println(preparedStatement);

			int a = preparedStatement.executeUpdate();
			System.out.println(a);
			
			
			connection.commit();
			Docente u = dm.doRetrieveByKey(utente.getMatricola());
			System.out.println("Utente modificato "+u);

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	
	}
	/**
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public synchronized Utente retrieveByEmail(String email) throws SQLException{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQLStudente = "SELECT * FROM " + UtenteModel.TABLE_NAME_STUD + " WHERE email = ?";
		String selectSQLDocente = "SELECT * FROM " + UtenteModel.TABLE_NAME_DOC + " WHERE email = ?";
		
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQLStudente);
			preparedStatement.setString(1,email);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Studente bean = new Studente();
				
				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				
				return bean;
						
				
			}
				//controlliamo nei docenti
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQLDocente);
				preparedStatement.setString(1,email);
				
				rs = preparedStatement.executeQuery();
				while(rs.next()) {
					Docente bean = new Docente();
					
					bean.setMatricola(rs.getString("matricola"));
					bean.setNome(rs.getString("nome"));
					bean.setCognome(rs.getString("cognome"));
					bean.setPassword(rs.getString("password"));
					bean.setEmail(rs.getString("email"));
					
					return bean;
				} 
				
				return null;
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	
	
	
}
