package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import DBConnection.DriverManagerConnectionPool;

public class UtenteModel {

private static final String TABLE_NAME_STUD = "Studente";
private static final String TABLE_NAME_DOC = "Docente";
	
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
	public synchronized Docente doRetrieveByKey(String matricola) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Docente bean = new Docente();

		String selectSQL = "SELECT * FROM " + UtenteModel.TABLE_NAME_STUD + " WHERE matricola = ? "+ " UNION " + " SELECT * FROM "+ UtenteModel.TABLE_NAME_DOC + " WHERE matricola = ? ";


		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, matricola);
			preparedStatement.setString(2, matricola);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setMatricola(rs.getString("matricola"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setPassword(rs.getString("password"));
				bean.setEmail(rs.getString("email"));
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
}
