package Model;

	import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
	import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;

import DBConnection.DriverManagerConnectionPool;

	public class RicevimentoModel {
		
	private static final String TABLE_NAME = "Ricevimento";
		
		public synchronized void doSave(Ricevimento Ricevimento,Calendar c) throws SQLException {

			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "INSERT INTO " + RicevimentoModel.TABLE_NAME
					+ " (studente, docente, data_prenotazione, data_ricevimento, stato) VALUES (?, ?, ?, ?,?)";
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, Ricevimento.getMatStudente());
				preparedStatement.setString(2, Ricevimento.getMatDocente());
				preparedStatement.setDate(4, new Date(c.getTimeInMillis()),c);
				preparedStatement.setDate(3, new Date(calendar.getTimeInMillis()),calendar);
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
		
		public synchronized boolean doDelete(int id) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			int result = 0;

			String deleteSQL = "DELETE FROM " + RicevimentoModel.TABLE_NAME + " WHERE id = ? ";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setInt(1,id);

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
		
		
		public synchronized Ricevimento doRetrieveByKey(int id) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Ricevimento bean = new Ricevimento();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME + " WHERE id = ?";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, id);

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
		
		public synchronized Collection<Ricevimento> doRetrieveAllByDoc(String matricolaDoc) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<Ricevimento> rv = new LinkedList<Ricevimento>();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME +" WHERE docente = ?";

			

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setString(1, matricolaDoc);
				ResultSet rs = preparedStatement.executeQuery();
                Date d=new Date(System.currentTimeMillis());
               
				while (rs.next()) {
					Ricevimento bean = new Ricevimento();

					bean.setId(rs.getInt("id"));
					bean.setMatDocente(rs.getString("docente"));
					bean.setMatStudente(rs.getString("studente"));
					bean.setData(rs.getDate("data_ricevimento"));
					bean.setDataPrenotazione(rs.getDate("data_prenotazione"));
					bean.setStato(rs.getString("stato"));
					
                    if(bean.getData().after(d))
                    {
                  
					rv.add(bean);
                    }
                    else
                    {
                    	this.doDelete(bean.getId());
                    }
				}}
				finally {
					try {
						if (preparedStatement != null)
							preparedStatement.close();
					} finally {
						DriverManagerConnectionPool.releaseConnection(connection);
					}
				}
				return rv;
			}
	
				
				
				public synchronized Collection<Ricevimento> doRetrieveAllByDate(Calendar c) throws SQLException {
					Connection connection = null;
					PreparedStatement preparedStatement = null;

					Collection<Ricevimento> rv = new LinkedList<Ricevimento>();

					String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME +" WHERE data_ricevimento = ?";

					

					try {
						connection = DriverManagerConnectionPool.getDbConnection();
						preparedStatement = connection.prepareStatement(selectSQL);
		                preparedStatement.setDate(1, new Date(c.getTimeInMillis()),c);
						ResultSet rs = preparedStatement.executeQuery();
		           
						while (rs.next()) {
							Ricevimento bean = new Ricevimento();
							bean.setId(rs.getInt("id"));
							bean.setMatDocente(rs.getString("docente"));
							bean.setMatStudente(rs.getString("studente"));
							bean.setData(rs.getDate("data_ricevimento"));
							bean.setDataPrenotazione(rs.getDate("data_prenotazione"));
							bean.setStato(rs.getString("stato"));
							rv.add(bean);
							System.out.println("queryyyy");
					
		                    
						}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
			return rv;
		}
		public synchronized void changeState(int id,String state) throws SQLException
		{
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String query= "UPDATE "+RicevimentoModel.TABLE_NAME+" SET stato = ? WHERE id = ? ";
			
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, state);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			connection.commit();
			
			DriverManagerConnectionPool.releaseConnection(connection);
			
			
		}

		
		public synchronized Collection<Ricevimento> doRetrieveAllByStudent(Studente studente) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;


			Collection<Ricevimento> utenti = new LinkedList<Ricevimento>();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME+" WHERE studente = ?";

			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, studente.getMatricola());

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
		
		
		/**
		 * Metodo che restituisce tutti i ricevimenti di un determinato docente per la giornata odierna
		 * @param matricolaDocente matricola del docente 
		 * @return collezione di ricevimenti di un docente nella giornata odierna
		 * @throws SQLException
		 */
		public synchronized Collection<Ricevimento> doRetrieveTodayByDocente(String matricolaDocente) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Collection<Ricevimento> ricevimenti = new LinkedList<Ricevimento>();

			String selectSQL = "SELECT * FROM " + RicevimentoModel.TABLE_NAME+" WHERE docente = ?";
			
			Date date = new Date(System.currentTimeMillis());
			try {
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, matricolaDocente);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Ricevimento bean = new Ricevimento();

					bean.setId(rs.getInt("id"));
					bean.setMatDocente(rs.getString("docente"));
					bean.setMatStudente(rs.getString("studente"));
					bean.setData(rs.getDate("data_prenotazione"));
					bean.setDataPrenotazione(rs.getDate("data_ricevimento"));
					bean.setStato(rs.getString("stato"));
					
					if(bean.getStato().contentEquals("Accettato") && bean.getData().equals(date)) {	
						ricevimenti.add(bean);
					}
				}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
			return ricevimenti;
		}
	}


