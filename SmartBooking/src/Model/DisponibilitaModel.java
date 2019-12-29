package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import DBConnection.DriverManagerConnectionPool;

/**
 * @author ozne2
 *
 */

/**
 * @author ozne2
 *
 */
public class DisponibilitaModel {
	
private static final String TABLE_NAME = "Disponibilità";
	
	/**
	 * @param Disponibilita
	 * @throws SQLException
	 */
	public synchronized void doSave(Disponibilita Disponibilita) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + DisponibilitaModel.TABLE_NAME
				+ " (giorno, ora, matricola_docente) VALUES (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, Disponibilita.getGiorno());
			preparedStatement.setString(2, Disponibilita.getOra());
			preparedStatement.setString(3, Disponibilita.getMatricolaDocente());		

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
	 * @param matricola_docente
	 * @return
	 * @throws SQLException
	 */
	public synchronized boolean doDelete(String matricola_docente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + DisponibilitaModel.TABLE_NAME + " WHERE matricola_docente = ? ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, matricola_docente);

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
	 * @param order
	 * @return
	 * @throws SQLException
	 */
	public synchronized Collection<Disponibilita> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Disponibilita> listaDisponibilita = new LinkedList<Disponibilita>();

		String selectSQL = "SELECT * FROM " + DisponibilitaModel.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Disponibilita bean = new Disponibilita();

				bean.setGiorno(rs.getString("giorno"));
				bean.setOra(rs.getString("ora"));
				bean.setMatricolaDocente("matricola_docente");
				
				listaDisponibilita.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return listaDisponibilita;
	}
	
	
	/**usato anche per la segreteria!
	 * @param matricola_docente
	 * @return
	 * @throws SQLException
	 */
	public synchronized Collection<Disponibilita> doRetrieveByKey(String matricola_docente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Disponibilita> listaOrari = new LinkedList<Disponibilita>();
		

		String selectSQL = "SELECT * FROM " + DisponibilitaModel.TABLE_NAME + " WHERE matricola_docente = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, matricola_docente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Disponibilita bean = new Disponibilita();
				
				bean.setGiorno(rs.getString("giorno"));
				bean.setOra(rs.getString("ora"));
				bean.setMatricolaDocente("matricola_docente");
				
				listaOrari.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return listaOrari;
	}

	
	/**
	 * @return
	 * @throws SQLException
	 */
	public synchronized Collection<Disponibilita> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Disponibilita> listaDisponibilita = new LinkedList<Disponibilita>();

		String selectSQL = "SELECT * FROM " + DisponibilitaModel.TABLE_NAME;

		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Disponibilita bean = new Disponibilita();

				bean.setGiorno(rs.getString("giorno"));
				bean.setOra(rs.getString("ora"));
				bean.setMatricolaDocente("matricola_docente");
				
				listaDisponibilita.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return listaDisponibilita;
	}

}

