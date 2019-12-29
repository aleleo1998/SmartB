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
	 * 
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
	 * @param order: ASC/DESC per ordinare i risultati
	 * @return collezione di docenti trovati
	 * @throws SQLException
	 */
	public synchronized Collection<Docente> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Docente> docenti = new LinkedList<Docente>();

		String selectSQL = "SELECT * FROM " + DocenteModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

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
}
