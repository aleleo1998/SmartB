package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import Controller.RegistrazioneStudenteServlet;
import DBConnection.DriverManagerConnectionPool;
import Model.StudenteModel;

public class tc1_0_Registrazione_Studente {
	
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
		
		when(request.getParameter("matricola")).thenReturn("123456789101112");
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
	public void tc_1_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("051210564L");
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
	public void tc_1_0_4() throws IOException, ServletException, SQLException{
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
	public void tc_1_0_5() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_6() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("CarmineAlessandroAlfredoLorenzoEnzo");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_7() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine10");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_8() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_9() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("SorrentinoLeopardiRaimondoFasolinoVenditto");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_10() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino10");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_11() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Email non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_12() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("carminesorrentino50carminecarmine@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Email non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_13() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@gmail.com");
		when(request.getParameter("password")).thenReturn("carminesorrentino96");
		when(request.getParameter("confermaPassword")).thenReturn("carminesorrentino96");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Email non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_14() throws IOException, ServletException, SQLException{
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
	public void tc_1_0_15() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("1234567");
		when(request.getParameter("confermaPassword")).thenReturn("1234567");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Password non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_16() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("123456789@");
		when(request.getParameter("confermaPassword")).thenReturn("123456789@");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Password non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_17() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("12345678910");
		when(request.getParameter("confermaPassword")).thenReturn("82947291093");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Le password non corrispondono",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_18() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("matricola")).thenReturn("0512105641");
		when(request.getParameter("nome")).thenReturn("Carmine");
		when(request.getParameter("cognome")).thenReturn("Sorrentino");
		when(request.getParameter("email")).thenReturn("c.sorrentino50@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("12345678910");
		when(request.getParameter("confermaPassword")).thenReturn("12345678910");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("",output.toString().toString());
	}
	
	
}
