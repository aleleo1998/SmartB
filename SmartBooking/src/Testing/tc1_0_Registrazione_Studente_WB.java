package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.RegistrazioneStudenteServlet;
import DBConnection.DriverManagerConnectionPool;

public class tc1_0_Registrazione_Studente_WB {
	
RegistrazioneStudenteServlet myServlet;
	
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
		myServlet = new RegistrazioneStudenteServlet();
	}
	
	@AfterEach
	public void afterEachTestCase() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM ACALE.Studente WHERE matricola = ? OR matricola = ? OR email = ?;";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"0512105641");
		preparedStatement.setString(2,"0512105642");
		preparedStatement.setString(3, "c.sorrentino50@studenti.unisa.it");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
	}
	
	@Test
	public void tc_1_0_1() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("1234");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Matricola non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("1234");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("12345678910");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Le password non corrispondono",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("1234");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("0");
		when(request.getParameter("confermaPassword")).thenReturn("1234567890");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Password non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_4() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("190");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("12345678910");
		when(request.getParameter("confermaPassword")).thenReturn("12345678910");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_5() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("S1rentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("12345678910");
		when(request.getParameter("confermaPassword")).thenReturn("12345678910");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_6() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO ACALE.Studente (matricola,nome,cognome,email,password) VALUES (?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1,"0512105641");
		preparedStatement.setString(2,"Carmine");
		preparedStatement.setString(3,"Sorrentino");	
		preparedStatement.setString(4,"ccccccccccc@studenti.unisa.it");
		preparedStatement.setString(5,"00000000000000000");	

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("12345678910");
		when(request.getParameter("confermaPassword")).thenReturn("12345678910");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Matricola già presente nel database",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_7() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO ACALE.Studente (matricola,nome,cognome,email,password) VALUES (?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1,"0512105642");
		preparedStatement.setString(2,"Carmine");
		preparedStatement.setString(3,"Sorrentino");	
		preparedStatement.setString(4,"c.sorrentino50@studenti.unisa.it");
		preparedStatement.setString(5,"00000000000000000");	

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Email già presente nel database",output.toString().toString());
	}
	
	

	@Test
	public void tc_1_0_8() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("sorrentino@unisa.it");
		when(request.getParameter("password")).thenReturn("12345678910");
		when(request.getParameter("confermaPassword")).thenReturn("12345678910");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Email non corretta",output.toString().toString());
	}


}
