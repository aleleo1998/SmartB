package Model;

	import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Collection;
	import java.util.LinkedList;
	import DBConnection.DriverManagerConnectionPool;

	public class RicevimentoModel {
		
	private static final String TABLE_NAME = "Ricevimento";
		
		public synchronized void doSave(Ricevimento Ricevimento) throws SQLException {

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "INSERT INTO " + RicevimentoModel.TABLE_NAME
					+ " (id, studente, docente, data_prenotazione, data_ricevimento, stato) VALUES (?, ?, ?, ?, ?,?)";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setInt(1, Ricevimento.getId());
				preparedStatement.setString(2, Ricevimento.getMatStudente());
				preparedStatement.setString(3, Ricevimento.getMatDocente());
				preparedStatement.setDate(4, (Date) Ricevimento.getDataPrenotazione());
				preparedStatement.setDate(5, (Date) Ricevimento.getData());
				preparedStatement.setString(5, Ricevimento.getStato());

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
		
		public synchronized boolean doDelete(String id) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			int result = 0;

			String deleteSQL = "DELETE FROM " + RicevimentoModel.TABLE_NAME + " WHERE id = ? ";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setString(1, id);

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
		
		
		public synchronized Collection<Ricevimento> doRetrieveAll(String order) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<Ricevimento> utenti = new LinkedList<Ricevimento>();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME;

			if (order != null && !order.equals("")) {
				selectSQL += " ORDER BY " + order;
			}

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Ricevimento bean = new Ricevimento();

					bean.setId(rs.getInt("id"));
					bean.setMatDocente(rs.getString("docente"));
					bean.setMatStudente(rs.getString("studente"));
					bean.setData(rs.getDate("data_prenotazione"));
					bean.setDataPrenotazione(rs.getDate("data_ricevimento"));
					
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
		
		
		public synchronized Ricevimento doRetrieveByKey(String id) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Ricevimento bean = new Ricevimento();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME + " WHERE id = ?";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, id);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					bean.setId(rs.getInt("id"));
					bean.setMatDocente(rs.getString("docente"));
					bean.setMatStudente(rs.getString("studente"));
					bean.setData(rs.getDate("data_prenotazione"));
					bean.setDataPrenotazione(rs.getDate("data_ricevimento"));
					
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

		
		public synchronized Collection<Ricevimento> doRetrieveAll() throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<Ricevimento> utenti = new LinkedList<Ricevimento>();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME;

			

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Ricevimento bean = new Ricevimento();

					bean.setId(rs.getInt("id"));
					bean.setMatDocente(rs.getString("docente"));
					bean.setMatStudente(rs.getString("studente"));
					bean.setData(rs.getDate("data_prenotazione"));
					bean.setDataPrenotazione(rs.getDate("data_ricevimento"));
					
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


