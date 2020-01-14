package Testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.*;
import DBConnection.DriverManagerConnectionPool;
import Model.Docente;

class tc7_0_AggiungiOrario {
AggiungiOrarioServlet myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	
	@BeforeEach
	public void beforeEachTestCase1() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new AggiungiOrarioServlet();
		
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
	
	@AfterEach
	public void afterEachTestCase() throws SQLException {
		
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
	
	@Test
	public void tc_1_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String select="SELECT nome,cognome,email,password,ufficio,matricola FROM ACALE.Docente WHERE matricola = ?";
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1,"0512101232");
		
		ResultSet set=preparedStatement.executeQuery();
		Docente d= null;
		while(set.next())
		{
		d=new Docente();
		
		d.setMatricola(set.getString("matricola"));
		d.setCognome(set.getString("cognome"));
		d.setNome(set.getString("nome"));
		d.setPassword(set.getString("password"));
		d.setEmail(set.getString("email"));
		d.setUfficio(set.getString("ufficio"));
	
		
		}
		
		//System.out.println("quii"+session.getAttribute("docente"));
		//session.setAttribute("nome", 123);
		when(session.getAttribute("docente")).thenReturn(d);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("numOrari")).thenReturn("1");
		when(request.getParameter("giorno1")).thenReturn("lunedi");
		when(request.getParameter("oraInizio1")).thenReturn("08:00");
		when(request.getParameter("oraFine1")).thenReturn("09:00");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("",output.toString().toString());
		
		
		
		
	}
	
	@Test
	public void tc_2_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String select="SELECT nome,cognome,email,password,ufficio,matricola FROM ACALE.Docente WHERE matricola = ?";
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1,"0512101232");
		
		ResultSet set=preparedStatement.executeQuery();
		Docente d= null;
		while(set.next())
		{
		d=new Docente();
		
		d.setMatricola(set.getString("matricola"));
		d.setCognome(set.getString("cognome"));
		d.setNome(set.getString("nome"));
		d.setPassword(set.getString("password"));
		d.setEmail(set.getString("email"));
		d.setUfficio(set.getString("ufficio"));
	
		
		}
		
		//System.out.println("quii"+session.getAttribute("docente"));
		//session.setAttribute("nome", 123);
		when(session.getAttribute("docente")).thenReturn(d);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("numOrari")).thenReturn("1");
		when(request.getParameter("giorno1")).thenReturn("lunadas");
		when(request.getParameter("oraInizio1")).thenReturn("08:00");
		when(request.getParameter("oraFine1")).thenReturn("09:00");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("giorno non corretto",output.toString().toString());
		
		
		
		
	}
	@Test
	public void tc_3_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String select="SELECT nome,cognome,email,password,ufficio,matricola FROM ACALE.Docente WHERE matricola = ?";
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1,"0512101232");
		
		ResultSet set=preparedStatement.executeQuery();
		Docente d= null;
		while(set.next())
		{
		d=new Docente();
		
		d.setMatricola(set.getString("matricola"));
		d.setCognome(set.getString("cognome"));
		d.setNome(set.getString("nome"));
		d.setPassword(set.getString("password"));
		d.setEmail(set.getString("email"));
		d.setUfficio(set.getString("ufficio"));
	
		
		}
		
		//System.out.println("quii"+session.getAttribute("docente"));
		//session.setAttribute("nome", 123);
		when(session.getAttribute("docente")).thenReturn(d);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("numOrari")).thenReturn("1");
		when(request.getParameter("giorno1")).thenReturn("lunedi");
		when(request.getParameter("oraInizio1")).thenReturn("0:00");
		when(request.getParameter("oraFine1")).thenReturn("09:00");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("orario Inizio non corretto",output.toString().toString());
		
		
		
		
	}
	
	
	@Test
	public void tc_4_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String select="SELECT nome,cognome,email,password,ufficio,matricola FROM ACALE.Docente WHERE matricola = ?";
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1,"0512101232");
		
		ResultSet set=preparedStatement.executeQuery();
		Docente d= null;
		while(set.next())
		{
		d=new Docente();
		
		d.setMatricola(set.getString("matricola"));
		d.setCognome(set.getString("cognome"));
		d.setNome(set.getString("nome"));
		d.setPassword(set.getString("password"));
		d.setEmail(set.getString("email"));
		d.setUfficio(set.getString("ufficio"));
	
		
		}
		
		//System.out.println("quii"+session.getAttribute("docente"));
		//session.setAttribute("nome", 123);
		when(session.getAttribute("docente")).thenReturn(d);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("numOrari")).thenReturn("1");
		when(request.getParameter("giorno1")).thenReturn("lunedi");
		when(request.getParameter("oraInizio1")).thenReturn("08:00");
		when(request.getParameter("oraFine1")).thenReturn("0:00");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("orario Fine non corretto",output.toString().toString());
		
		
		
		
	}
	
	@Test
	public void tc_5_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String select="SELECT nome,cognome,email,password,ufficio,matricola FROM ACALE.Docente WHERE matricola = ?";
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(select);
		preparedStatement.setString(1,"0512101232");
		
		ResultSet set=preparedStatement.executeQuery();
		Docente d= null;
		while(set.next())
		{
		d=new Docente();
		
		d.setMatricola(set.getString("matricola"));
		d.setCognome(set.getString("cognome"));
		d.setNome(set.getString("nome"));
		d.setPassword(set.getString("password"));
		d.setEmail(set.getString("email"));
		d.setUfficio(set.getString("ufficio"));
	
		
		}
		
		//System.out.println("quii"+session.getAttribute("docente"));
		//session.setAttribute("nome", 123);
		when(session.getAttribute("docente")).thenReturn(d);
		when(request.getSession()).thenReturn(session);
		when(request.getParameter("numOrari")).thenReturn("1");
		when(request.getParameter("giorno1")).thenReturn("lunedi");
		when(request.getParameter("oraInizio1")).thenReturn("11:00");
		when(request.getParameter("oraFine1")).thenReturn("10:00");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("orario Inizio/Fine non corretto",output.toString().toString());
		
		
		
		
	}
	
	
	
	
	

}
