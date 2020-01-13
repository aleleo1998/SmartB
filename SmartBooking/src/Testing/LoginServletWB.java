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
import org.mockito.Mockito;

import Controller.LoginServlet;
import Controller.RegistrazioneStudenteServlet;
import Controller.TrovaCorrispondenzaDocenteStudenteServlet;
import DBConnection.DriverManagerConnectionPool;
import Model.Docente;
import Model.StudenteModel;
import Model.Utente;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mockito.Mock;

import Controller.TrovaCorrispondenzaDocenteStudenteServlet;

public class LoginServletWB {
	
	LoginServlet myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	
	@Mock
	GestioneUtenti gestioneUtenti;
	
	@BeforeEach
	public void beforeEachTestCase() throws SQLException{
		gestioneUtenti = mock(GestioneUtentiConcrete.class);
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new LoginServlet();
	}
	
	@Test
	public void tc_wb_2_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		
		
		when(request.getParameter("email")).thenReturn("kdsjkdj");
		when(request.getParameter("password")).thenReturn("sfsufsdi");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Errore",output.toString());
	}
	
	@Test
	public void tc_wb_2_0_2() throws IOException, ServletException, SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		when(request.getSession()).thenReturn(session);

		String insertSQL = "INSERT INTO ACALE.Docente (matricola,nome,cognome,password,email,ufficio) VALUES (?,?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1,"1234567891");
		preparedStatement.setString(2,"Mario");
		preparedStatement.setString(3,"Rossi");
		preparedStatement.setString(4,"00000");
		preparedStatement.setString(5,"doc@unisa.it");
		preparedStatement.setString(6,"Edificio 3");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("email")).thenReturn("doc@unisa.it");
		when(request.getParameter("password")).thenReturn("00000");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Docente",output.toString());
		
		String deleteSQL = "DELETE FROM ACALE.Docente WHERE matricola = ?";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"1234567891");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
	}
	
	
	@Test
	public void tc_wb_2_0_3() throws IOException, ServletException, SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		when(request.getSession()).thenReturn(session);
		
		String insertSQL = "INSERT INTO ACALE.Studente (matricola,nome,cognome,password,email) VALUES (?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1,"9876655554");
		preparedStatement.setString(2,"Mario");
		preparedStatement.setString(3,"Rossi");
		preparedStatement.setString(4,"00077700");
		preparedStatement.setString(5,"doc@studenti.unisa.it");

		preparedStatement.executeUpdate();
		
		connection.commit();


		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("email")).thenReturn("doc@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("00077700");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Studente",output.toString());
		
		String deleteSQL = "DELETE FROM ACALE.Studente WHERE matricola = ?";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"9876655554");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
		
	}
	
	
	
	@Test
	public void tc_wb_2_0_4() throws IOException, ServletException, SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		when(request.getSession()).thenReturn(session);
		
		String insertSQL = "INSERT INTO ACALE.Segreteria (matricola,email,password,nome,cognome,orario) VALUES (?,?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1,"5555555643");
		preparedStatement.setString(2,"seg@segreteria.unisa.it");
		preparedStatement.setString(3,"00078787700");
		preparedStatement.setString(4,"Mario");
		preparedStatement.setString(5,"Rossi");
		preparedStatement.setString(6,"12:00");
		
		preparedStatement.executeUpdate();
		
		connection.commit();


		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("email")).thenReturn("seg@segreteria.unisa.it");
		when(request.getParameter("password")).thenReturn("00078787700");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Segreteria",output.toString());
		
		String deleteSQL = "DELETE FROM ACALE.Segreteria WHERE matricola = ?";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"5555555643");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
		
	}
	
	
	
	
	

}
