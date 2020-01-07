package Model;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Collection;
	import java.util.LinkedList;
	import DBConnection.DriverManagerConnectionPool;

	public class SegreteriaModel {
		
	private static final String TABLE_NAME = "Segreteria";
		
		public synchronized void doSave(Segreteria Segreteria) throws SQLException {

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "INSERT INTO " + SegreteriaModel.TABLE_NAME
					+ " (matricola, email, password, nome, cognome, orario) VALUES (?, ?, ?, ?, ?, ?)";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, Segreteria.getMatricola());
				preparedStatement.setString(2, Segreteria.getEmail());
				preparedStatement.setString(3, Segreteria.getPassword());
				preparedStatement.setString(4, Segreteria.getNome());
				preparedStatement.setString(5, Segreteria.getCognome());
				preparedStatement.setString(6, Segreteria.getOrari());
				

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
		
		public synchronized boolean doDelete(String matricola) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			int result = 0;

			String deleteSQL = "DELETE FROM " + SegreteriaModel.TABLE_NAME + " WHERE matricola = ? ";

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
		
		
		public synchronized Collection<Segreteria> doRetrieveAll(String order) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<Segreteria> utenti = new LinkedList<Segreteria>();

			String selectSQL = "SELECT * FROM " + SegreteriaModel.TABLE_NAME;

			if (order != null && !order.equals("")) {
				selectSQL += " ORDER BY " + order;
			}

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Segreteria bean = new Segreteria();

					bean.setMatricola(rs.getString("matricola"));
					bean.setNome(rs.getString("nome"));
					bean.setCognome(rs.getString("cognome"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setOrari(rs.getString("orario"));
					
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
		
		
		public synchronized Segreteria doRetrieveByKey(String matricola) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Segreteria bean = new Segreteria();

			String selectSQL = "SELECT * FROM " + SegreteriaModel.TABLE_NAME + " WHERE matricola = ?";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, matricola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					bean.setMatricola(rs.getString("matricola"));
					bean.setNome(rs.getString("nome"));
					bean.setCognome(rs.getString("cognome"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setOrari(rs.getString("orario"));
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

		
		public synchronized Collection<Segreteria> doRetrieveAll() throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<Segreteria> utenti = new LinkedList<Segreteria>();

			String selectSQL = "SELECT * FROM " + SegreteriaModel.TABLE_NAME;

			

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Segreteria bean = new Segreteria();

					bean.setMatricola(rs.getString("matricola"));
					bean.setNome(rs.getString("nome"));
					bean.setCognome(rs.getString("cognome"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setOrari(rs.getString("orario"));
					
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


