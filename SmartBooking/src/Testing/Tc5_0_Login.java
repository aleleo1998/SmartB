package Testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.LoginServlet;
import DBConnection.DriverManagerConnectionPool;

class Tc5_0_Login {

LoginServlet myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;

	@BeforeEach
	public void beforeEachTestCase() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new LoginServlet();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO ACALE.Studente (matricola,nome,cognome,password,email) VALUES (?,?,?,?,?)";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,"0512105474");
		preparedStatement.setString(2,"Alessandro");
		preparedStatement.setString(3,"Leopardi");
		preparedStatement.setString(4,"alex1998");
		preparedStatement.setString(5, "a.leopardi2@studenti.unisa.it");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
	}
	
	
	@BeforeEach
	public void beforeEachTestCase2() throws SQLException{
    PreparedStatement preparedStatement = null;
    Connection connection = null;	
		String query = "INSERT INTO ACALE.Docente (matricola,nome,cognome,password,email,ufficio) VALUES (?,?,?,?,?,?)";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,"0512101232");
		preparedStatement.setString(2,"Filomena");
		preparedStatement.setString(3,"Ferrucci");
		preparedStatement.setString(4,"ffis2020");
		preparedStatement.setString(5, "f.ferrucci3@.unisa.it");
		preparedStatement.setString(6, "stanza 27 edificio D");
		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
	}
	
	
	@BeforeEach
	public void beforeEachTestCase3() throws SQLException{
    PreparedStatement preparedStatement = null;
    Connection connection = null;	
		String query = "INSERT INTO ACALE.Segreteria (matricola,email,password,nome,cognome,orario) VALUES (?,?,?,?,?,?)";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1,"0512104231");
		preparedStatement.setString(2,"segre.segre12@unisa.it");
		preparedStatement.setString(3,"1998");
		preparedStatement.setString(4,"Anna");
		preparedStatement.setString(5, "De stefano");
		preparedStatement.setString(6, "11:00");
		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
	}
	
	@AfterEach
	public void afterEachTestCase() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM ACALE.Studente WHERE matricola = ? ";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"0512105474");
		

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
	}
	
	@AfterEach
	public void afterEachTestCase2() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM ACALE.Docente WHERE matricola = ? ";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"0512101232");
		

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
	}
	
	@AfterEach
	public void afterEachTestCase3() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM ACALE.Segreteria WHERE matricola = ? ";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"0512104231");
		

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
	}
	@Test
	public void tc_5_0_1() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("email")).thenReturn("a.leopardi1@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("alex1998");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("login studente",output.toString().toString());
		
		
		
		
	}
	
	
	
	
	@Test
	public void tc_5_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("email")).thenReturn("f.ferrucci3@.unisa.it");
		when(request.getParameter("password")).thenReturn("ffis2020");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("login docente",output.toString().toString());
		
		
		
		
	}
	
	
	
	@Test
	public void tc_5_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("email")).thenReturn("segre.segre12@unisa.it");
		when(request.getParameter("password")).thenReturn("1998");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("login segreteria",output.toString().toString());
		
		
		
		
	}
	
	
	
	@Test
	public void tc_5_0_4() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("email")).thenReturn("saaaa@unisa.it");
		when(request.getParameter("password")).thenReturn("aaa");
		
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("login fallito",output.toString().toString());
		
		
		
		
	}
	
	

}
