package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import DBConnection.DriverManagerConnectionPool;

public class DocenteModel {
	private static final String TABLE_NAME = "Docente";
	
	/**
	 * Metodo per salvare un docente nel database
	 * @param docente: docente da salvare all'interno del database
	 * @throws SQLException
	 */
	public synchronized void doSave(Docente docente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + DocenteModel.TABLE_NAME
				+ " (matricola, nome, cognome, password, email, ufficio) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, docente.getMatricola());
			preparedStatement.setString(2, docente.getNome());
			preparedStatement.setString(3, docente.getCognome());
			preparedStatement.setString(4, docente.getPassword());
			preparedStatement.setString(5, docente.getEmail());
			preparedStatement.setString(6, docente.getUfficio());

			preparedStatement.executeUpdate();

			connection.commit();
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
	 * 
	 * @param matricola: matricola del docente da rimuovere
	 * @return : true se result diverso da 0, false altrimenti
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(String matricola) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + DocenteModel.TABLE_NAME + " WHERE matricola = ? ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, matricola);

			result = preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	

	

	/**
	 * 
	 * @param matricola: matricola del docente da ricercare
	 * @return bean docente con matricola uguale al parametro matricola
	 * @throws SQLException
	 */
	public synchronized Docente doRetrieveByKey(String matricola) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Docente bean = new Docente();

		String selectSQL = "SELECT * FROM " + DocenteModel.TABLE_NAME + " WHERE matricola = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, matricola);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setUfficio(rs.getString("ufficio"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	
	/**
	 * 
	 * @return collezione di tutti i docenti
	 * @throws SQLException
	 */
	public synchronized Collection<Docente> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Docente> docenti = new LinkedList<Docente>();

		String selectSQL = "SELECT * FROM " + DocenteModel.TABLE_NAME;

		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Docente bean = new Docente();

				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setUfficio(rs.getString("ufficio"));
			
				
				docenti.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return docenti;
	}

	public Docente doRetrieveByNameAndSurname(String name, String surname) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Docente bean = new Docente();

		String selectSQL = "SELECT * FROM " + DocenteModel.TABLE_NAME + " WHERE nome = ? AND cognome = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,surname);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setUfficio(rs.getString("ufficio"));
			}
			
			System.out.print("Docente bean dopo la query: "+bean);

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
	
	/**
	 * Verifica se un email da verificare, passata come parametro, esiste gi� nel database come email associata a un docente
	 * @param email email da verificare
	 * @return false se l'email non esiste, true altrimenti
	 * @throws Exception
	 */
	public synchronized Boolean existEmail(String email) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Docente bean = new Docente();

		String selectSQL = "SELECT * FROM " + DocenteModel.TABLE_NAME + " WHERE email = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setMatricola("matricola");
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setUfficio(rs.getString("ufficio"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
			System.out.println("EMAIL QUERY RETURN : "+bean.getEmail());
		if(bean.getEmail()==null)
			
			return false;
		else
			return true;
	}
	
	
	/**
	 * verifica se esiste una matricola, passata come parametro, gi� associata a un docente nel database
	 * @param matricola : matricola da verificare
	 * @return false se la matricola non esiste, true altrimenti
	 * @throws Exception
	 */
	public synchronized Boolean existMatricola(String matricola) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Docente bean = new Docente();

		String selectSQL = "SELECT * FROM " + DocenteModel.TABLE_NAME + " WHERE matricola = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, matricola);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setMatricola("matricola");
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
				bean.setUfficio(rs.getString("ufficio"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		if(bean.getMatricola()==null)
			return false;
		else
			return true;
	}
	
}
