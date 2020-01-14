package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import DBConnection.DriverManagerConnectionPool;

import Model.*;
class StudenteModelWB {

	@Test
	void testAll() throws SQLException {
		
		 StudenteModel dm = new StudenteModel();
		    
		    LinkedList<Studente> studenti =(LinkedList<Studente>) dm.doRetrieveAll();
		    
		    
		    Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			String countSQL = "SELECT * FROM ACALE.Studente";
			
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(countSQL);
			
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			DriverManagerConnectionPool.releaseConnection(connection);
			int num = 0;
			while(rs.next()){
			 num = rs.getRow();
				
			}
			
		    
			System.out.println(num);
		    
		    assertEquals(studenti.size(),num);
		
	}

}
