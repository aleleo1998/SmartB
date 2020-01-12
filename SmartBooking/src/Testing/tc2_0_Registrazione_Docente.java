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

import Controller.RegistrazioneDocenteServlet;
import DBConnection.DriverManagerConnectionPool;

public class tc2_0_Registrazione_Docente {

	RegistrazioneDocenteServlet myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;

	
	@BeforeEach
	public void setUp() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new RegistrazioneDocenteServlet();
		
	/*	Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO ACALE.Docente(matricola,nome,cognome,password,email,ufficio) VALUES (?,?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		preparedStatement.setString(1,"0512100000");
		preparedStatement.setString(2,"docente");
		preparedStatement.setString(3, "docente");
		preparedStatement.setString(4, "pass001");
		preparedStatement.setString(5, "d.docente@unisa.it");
		preparedStatement.setString(6, "uff01");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
	
		*/
	}
	
	@AfterEach
	public void tearDown() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM ACALE.Docente WHERE matricola = ? OR matricola = ? OR matricola = ? OR email = ?;";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,"0512100000");
		preparedStatement.setString(2, "0512100001");
		preparedStatement.setString(3, "0512100010");
		preparedStatement.setString(4, "d.docente@unisa.it");
		

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
	}
	
	
	@Test
	public void tc_2_0_1() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	@Test
	public void tc_2_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomenaferruccifilomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena01");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Nome non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_4() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_5() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferruccifilomenaferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_6() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci01");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Cognome non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_7() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("00001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Matricola non corretta",output.toString().toString());
	}
	
	
	@Test
	public void tc_2_0_8() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO ACALE.Docente(matricola,nome,cognome,password,email,ufficio) VALUES (?,?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		preparedStatement.setString(1,"0512100000");
		preparedStatement.setString(2,"docente");
		preparedStatement.setString(3, "docente");
		preparedStatement.setString(4, "pass001");
		preparedStatement.setString(5, "d.docente@unisa.it");
		preparedStatement.setString(6, "uff01");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100000");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Matricola già presente nel database",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_9() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Ufficio non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_10() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficiostanza01piano01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Ufficio non corretto",output.toString().toString());
	}

	
	
	@Test
	public void tc_2_0_11() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio@01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Ufficio non corretto",output.toString().toString());
	}
	
	
	
	@Test
	public void tc_2_0_12() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Email non corretta",output.toString().toString());
	}

	
	
	@Test
	public void tc_2_0_13() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("filomenaferruccifilomenaferruccifilomenaferrucciferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Email non corretta",output.toString().toString());
	}

	
	@Test
	public void tc_2_0_14() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci!!@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Email non corretta",output.toString().toString());
	}

	

	@Test
	public void tc_2_0_15() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO ACALE.Docente(matricola,nome,cognome,password,email,ufficio) VALUES (?,?,?,?,?,?);";
		
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		preparedStatement.setString(1,"0512100000");
		preparedStatement.setString(2,"docente");
		preparedStatement.setString(3, "docente");
		preparedStatement.setString(4, "pass001");
		preparedStatement.setString(5, "d.docente@unisa.it");
		preparedStatement.setString(6, "uff01");

		preparedStatement.executeUpdate();
		
		connection.commit();
		
		DriverManagerConnectionPool.releaseConnection(connection);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("d.docente@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Email già presente nel database",output.toString().toString());
	}
	
	

	@Test
	public void tc_2_0_16() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Filomena");
		when(request.getParameter("cognome")).thenReturn("Ferrucci");
		when(request.getParameter("matricola")).thenReturn("0512100001");
		when(request.getParameter("ufficio")).thenReturn("ufficio01");
		when(request.getParameter("email")).thenReturn("f.ferrucci@unisa.it");
				
		when(response.getWriter()).thenReturn(out);
	
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
				
		assertEquals("Email non corretta",output.toString().toString());
	}
}
