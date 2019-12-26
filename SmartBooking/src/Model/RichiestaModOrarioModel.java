package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import DBConnection.DriverManagerConnectionPool;

public class RichiestaModOrarioModel {

	
private static final String TABLE_NAME = "Richiesta_modifica_orario";
	
	/**
	 * 
	 * @param richiestaModOrario: richiesta da salvare nel database
	 * @throws SQLException
	 */
	public synchronized void doSave(RichiestaModOrario richiestaModOrario) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + RichiestaModOrarioModel.TABLE_NAME
				+ " (id,matricola_docente, matricola_segreteria, ora_inizio, ora_fine, giorno_precedente, giorno) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, richiestaModOrario.getId());
			preparedStatement.setString(2, richiestaModOrario.getMatricolaDocente());
			preparedStatement.setString(3, richiestaModOrario.getMatricolaSegreteria());
			preparedStatement.setString(4, richiestaModOrario.getOraInizio());
			preparedStatement.setString(5, richiestaModOrario.getOraFine());
			preparedStatement.setString(6, richiestaModOrario.getGiornoPrecedente());
			preparedStatement.setString(7, richiestaModOrario.getGiorno());
			

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
	 * @param id : id della richiesta da rimuovere
	 * @return restituisce true se result è diverso da 0, false altrimenti
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + RichiestaModOrarioModel.TABLE_NAME + " WHERE id = ? ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

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
	 * @param order ASC/DESC per ordinare i risultati ottenuti
	 * @return restituisce una collezione di RichiestaModOrario
	 * @throws SQLException
	 */
	public synchronized Collection<RichiestaModOrario> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<RichiestaModOrario> richiesteModOrario = new LinkedList<RichiestaModOrario>();

		String selectSQL = "SELECT * FROM " + RichiestaModOrarioModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RichiestaModOrario bean = new RichiestaModOrario();

				bean.setId(rs.getInt("id"));
				bean.setMatricolaDocente(rs.getString("matricola_docente"));
				bean.setMatricolaSegreteria(rs.getString("matricola_segreteria"));
				bean.setOraInizio(rs.getString("ora_inizio"));
				bean.setOraFine(rs.getString("ora_fine"));
				bean.setGiornoPrecedente(rs.getString("giorno_precedente"));
				bean.setGiorno(rs.getString("giorno"));
				
				richiesteModOrario.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return richiesteModOrario;
	}
	
	
	/**
	 * 
	 * @param id : id della richiesta da ricercare 
	 * @return restituisce una RichiestaModOrario con l'id passato come parametro, se presente nel database
	 * @throws SQLException
	 */
	public synchronized RichiestaModOrario doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		RichiestaModOrario bean = new RichiestaModOrario();

		String selectSQL = "SELECT * FROM " + RichiestaModOrarioModel.TABLE_NAME + " WHERE id = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setMatricolaDocente(rs.getString("matricola_docente"));
				bean.setMatricolaSegreteria(rs.getString("matricola_segreteria"));
				bean.setOraInizio(rs.getString("ora_inizio"));
				bean.setOraFine(rs.getString("ora_fine"));
				bean.setGiornoPrecedente(rs.getString("giorno_precedente"));
				bean.setGiorno(rs.getString("giorno"));
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
	 * @return restituisce una collezione di tutte le richieste presenti nel database
	 * @throws SQLException
	 */
	public synchronized Collection<RichiestaModOrario> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<RichiestaModOrario> richiesteModOrario = new LinkedList<RichiestaModOrario>();

		String selectSQL = "SELECT * FROM " + RichiestaModOrarioModel.TABLE_NAME;

		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RichiestaModOrario bean = new RichiestaModOrario();

				bean.setId(rs.getInt("id"));
				bean.setMatricolaDocente(rs.getString("matricola_docente"));
				bean.setMatricolaSegreteria(rs.getString("matricola_segreteria"));
				bean.setOraInizio(rs.getString("ora_inizio"));
				bean.setOraFine(rs.getString("ora_fine"));
				bean.setGiornoPrecedente(rs.getString("giorno_precedente"));
				bean.setGiorno(rs.getString("giorno"));
				
				richiesteModOrario.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return richiesteModOrario;
	}
	

}
