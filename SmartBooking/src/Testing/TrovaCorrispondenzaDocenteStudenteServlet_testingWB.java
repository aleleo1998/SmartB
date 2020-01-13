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
import Controller.TrovaCorrispondenzaDocenteStudenteServlet;
import DBConnection.DriverManagerConnectionPool;
import Model.StudenteModel;

public class TrovaCorrispondenzaDocenteStudenteServlet_testingWB {
	
	TrovaCorrispondenzaDocenteStudenteServlet myServlet;
	
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
		myServlet = new TrovaCorrispondenzaDocenteStudenteServlet();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO ACALE.Lista_preferiti (matricola_studente,matricola_docente) VALUES (?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		preparedStatement.setString(1,"0512105473");
		preparedStatement.setString(2,"0512104597");

		preparedStatement.executeUpdate();
		
		connection.commit();
	}
	
	@AfterEach
	public void afterEachTestCase() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM ACALE.Lista_preferiti WHERE matricola_studente = ?";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"0512105473");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
	}
	
	@Test
	public void tc_wb_1_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		
		when(request.getParameter("matricolaDocente")).thenReturn("0512104597");
		when(session.getAttribute("Utente")).thenReturn("0512105473");
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("esiste",output.toString().toString());
	}
	
	
	@Test
	public void tc_wb_1_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getSession()).thenReturn(session);
		
		when(request.getParameter("matricolaDocente")).thenReturn("0512104597");
		when(session.getAttribute("Utente")).thenReturn("00000000000");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("non esiste",output.toString().toString());
	}
	
}
