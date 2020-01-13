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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.*;
import DBConnection.DriverManagerConnectionPool;
import Model.DisponibilitaModel;
import Model.Docente;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

class tc7_0_AggiungiOrario {
    AggiungiOrarioServlet myServlet;
	
	@Mock
	 HttpServletRequest request;
	
	@Mock
	 HttpServletResponse response;
	
	@Mock
	 HttpSession session;
	
	Docente d;
	
	@BeforeEach
	 public void beforeEachTestCase1() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new AggiungiOrarioServlet();
		
		GestioneUtenti gu = new GestioneUtentiConcrete();
		
		d = new Docente("nome","cognome","9992634512","1234","abbdbdbd@studenti.unisa.it","uff");
		
		gu.registrazioneDocente(d);
		
	}
	
	@AfterEach
	 public void afterEachTestCase() throws SQLException {
		
		GestioneUtenti gu = new GestioneUtentiConcrete();
		
		gu.rimuoviDocente("9992634512");
		
		DisponibilitaModel dm = new DisponibilitaModel();
		
		dm.doDelete("9992634512");
		
		
		
		
	}
	
	@Test
	public void tc_7_0_1() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
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
	public void tc_7_0_2() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
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
	public void tc_7_0_3() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		System.out.println("ooo "+d);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("docente")).thenReturn(d);
		
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
	public void tc_7_0_4() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
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
	public void tc_7_0_5() throws IOException, ServletException, SQLException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("docente")).thenReturn(d);
		
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
