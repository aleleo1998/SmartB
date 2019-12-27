package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import DBConnection.DriverManagerConnectionPool;

public class ListaPreferitiModel {
private static final String TABLE_NAME = "Lista_preferiti";
private static final String	SECOND_COLUMN = "Lista_preferiti.matricola_docente";


		public synchronized Collection<Docente> getAllDocenti(Studente s) throws SQLException {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			Collection<Docente> docenti= new LinkedList<Docente>();

			String insertSQL = "SELECT * FROM" + ListaPreferitiModel.TABLE_NAME + "JOIN Docente ON" + ListaPreferitiModel.SECOND_COLUMN + "= Docente.matricola WHERE" +"matricola_studente ="+s.getMatricola();
			
			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					Docente bean = new Docente();

					bean.setMatricola("matricola");
					bean.setNome(rs.getString("nome"));
					bean.setCognome(rs.getString("cognome"));
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
		public synchronized void addDocente(Docente d, Studente s) throws SQLException {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "INSERT INTO" + ListaPreferitiModel.TABLE_NAME + " (matricola_studente,matricola_docente) VALUES (?, ?)";
	
			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, s.getMatricola());
				preparedStatement.setString(2, d.getMatricola());


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
		public synchronized void removeDocente(Docente d, Studente s) throws SQLException {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "DELETE FROM" + ListaPreferitiModel.TABLE_NAME + "WHERE matricola_studente = ? AND matricola_docente = ?";
	
			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, s.getMatricola());
				preparedStatement.setString(2, d.getMatricola());
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
		
}

