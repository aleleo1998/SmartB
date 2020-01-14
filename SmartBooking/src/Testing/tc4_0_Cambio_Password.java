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

import Controller.CambioPasswordServlet;
import DBConnection.DriverManagerConnectionPool;
import Model.Docente;
import Model.DocenteModel;
import Model.Studente;
import Model.Utente;
import Model.UtenteModel;

public class tc4_0_Cambio_Password {
	
	CambioPasswordServlet myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	@Mock
	Utente utente;

	@BeforeEach
	public void beforeEachTestCase() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new CambioPasswordServlet();
		UtenteModel md = new UtenteModel();	
		utente = md.doRetrieveByKey("123");
	}
	
	/*@AfterEach
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
		
	}*/
	
	@Test
	public void tc_1_0_1() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
	
		when(request.getSession()).thenReturn(session);
		
		when(session.getAttribute("studente")).thenReturn(utente);
		
		when(request.getParameter("vecchiaPassword")).thenReturn("1234567");
		when(request.getParameter("nuovaPassword")).thenReturn("12345678");
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("password non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		
		when(session.getAttribute("studente")).thenReturn(utente);
		
		when(request.getParameter("vecchiaPassword")).thenReturn("1234567@");
		when(request.getParameter("nuovaPassword")).thenReturn("12345678");
	
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("password non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		
		when(session.getAttribute("studente")).thenReturn(utente);
		
		when(request.getParameter("vecchiaPassword")).thenReturn("12345678");
		when(request.getParameter("nuovaPassword")).thenReturn("1234567");
	
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("nuova password non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_1_0_4() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		
		when(session.getAttribute("studente")).thenReturn(utente);
		
		when(request.getParameter("vecchiaPassword")).thenReturn("12345678");
		when(request.getParameter("nuovaPassword")).thenReturn("12345678");
	
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Password cambiata",output.toString().toString());
	}
	
	
	


}