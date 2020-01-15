package Model;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.sql.Time;

import DBConnection.DriverManagerConnectionPool;


/**
 * Permette di eseguire query per la gestione delle disponibilità
 *
 */
public class DisponibilitaModel {

private static final String TABLE_NAME = "Disponibilità";
	
	/**
	 * @param Disponibilita
	 * @throws SQLException
	 * 
	 * Salva una disponibilità nel DB
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
			
			System.out.println(preparedStatement);

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
	 * 
	 * Cancela una disponibilità legata al docente
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
	 * @param matricola_docente
	 * @param giorno
	 * @return
	 * @throws SQLException
	 * 
	 * Cancella una disponibilità
	 */
	public synchronized boolean doDelete(String matricola_docente, String giorno) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + DisponibilitaModel.TABLE_NAME + " WHERE matricola_docente = ? AND giorno = ? ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, matricola_docente);
			preparedStatement.setString(2, giorno);

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
	
	
	
	
	
	
	
	
	/**usato anche per la segreteria!
	 * @param matricola_docente
	 * @return
	 * @throws SQLException
	 * 
	 * Prende tutte le disponibilità di un docente
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
				bean.setMatricolaDocente(rs.getString("matricola_docente"));
				
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
	 * @param mDocente
	 * @param giorno
	 * @param orarioInizio
	 * @param orarioFine
	 * @throws SQLException
	 * 
	 * Aggiunge una disponibilità al DB
	 */
	@SuppressWarnings("deprecation")
	public synchronized void aggiungiOrario(String mDocente, String giorno,String orarioInizio, String orarioFine) throws SQLException {
			Disponibilita d = new Disponibilita();
		 	int mintoset = 0;
	        DateFormat sdf = new SimpleDateFormat("hh:mm");
	        
	        try{    
	                Date datefine = (Date) sdf.parse(orarioFine);
	            	Date date = (Date) sdf.parse(orarioInizio);
	            	while(date.compareTo(datefine) <= 0){
	            		
	            		System.out.println(date.compareTo(datefine));
	            	     System.out.println(date.getHours()+":"+date.getMinutes());
	            	     	d.setGiorno(giorno);
	            			d.setOra(date.getHours()+":"+date.getMinutes());
	            			d.setMatricolaDocente(mDocente); 
	            			doSave(d);
	            	     mintoset += 15;
	            	     if(mintoset % 60 == 0){
	            	         mintoset = 0;
	            	         date.setHours(date.getHours()+1);
	            	     }
	            	     date.setMinutes(mintoset);
	            	}
			       
	        }catch(Exception e){
	            System.out.println("Hello Java");
	            e.printStackTrace();
	        }
		
	    }
	
	public synchronized boolean checkOrarioDefinito(String matricola_docente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Disponibilita> listaOrari = new LinkedList<Disponibilita>();
		

		String selectSQL = "SELECT * FROM " + DisponibilitaModel.TABLE_NAME + " WHERE matricola_docente = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, matricola_docente);

			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {
				return true;
			}else {
				return false;
			}

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

