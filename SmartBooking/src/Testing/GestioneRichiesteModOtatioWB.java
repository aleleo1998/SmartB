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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.AggiungiOrarioServlet;
import Controller.GestisciRischiesteModOrarioServlet;
import DBConnection.DriverManagerConnectionPool;
import Model.DisponibilitaModel;
import Model.Docente;
import Model.RichiestaModOrario;
import Model.RichiestaModOrarioModel;
import gestioneOrari.GestioneOrari;
import gestioneOrari.GestioneOrariConcrete;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

class GestioneRichiesteModOtatioWB {

	GestisciRischiesteModOrarioServlet myServlet;
	
	@Mock
	 HttpServletRequest request;

	@Mock
	 HttpServletResponse response;
	
	@Mock
	 HttpSession session;
	
	int idRichiesta;

	@BeforeEach
	 public void beforeEachTestCase1() throws SQLException{
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new GestisciRischiesteModOrarioServlet();
		
		GestioneUtenti gu = new GestioneUtentiConcrete();
		
		Docente d = new Docente("nome","cognome","9934857635","eee@unisa.it","1234","stanza");
		
		gu.registrazioneDocente(d);
		
		GestioneOrari gs = new GestioneOrariConcrete();
		
		RichiestaModOrario richiesta = new RichiestaModOrario(123,"9934857635","123","12:00:00","13:00:00","lunedì","martedì");
		
		gs.inoltraRichiesta(richiesta);
		
		RichiestaModOrarioModel rm = new RichiestaModOrarioModel();
		idRichiesta = rm.doRertiveByDoc(d.getMatricola()).getId();
		
		
		
	}
	
	@AfterEach
	 public void afterTestCase1() throws SQLException{
		 GestioneUtenti gu = new GestioneUtentiConcrete();
		 
		 gu.rimuoviDocente("9934857635");
		 
		 DisponibilitaModel dm = new DisponibilitaModel();
		 
		 dm.doDelete("9934857635");
		 
		 RichiestaModOrarioModel rm = new RichiestaModOrarioModel();
		 
		 rm.doDeleteByDoc("9934857635");
		 
		
	}
	
	
	@Test
	public void tc_1_0_1() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("stato")).thenReturn("acc");
		when(request.getParameter("id")).thenReturn(idRichiesta+"");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("ok",output.toString().toString()); 
	}
	
	@Test
	public void tc_1_0_2() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("stato")).thenReturn("dec");
		when(request.getParameter("id")).thenReturn(idRichiesta+"");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doGet(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("ok",output.toString().toString());
	}
	
	@Test
	public void tc_1_0_3() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("stato")).thenReturn("de");
		when(request.getParameter("id")).thenReturn(idRichiesta+"");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doGet(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("",output.toString().toString());
	}
	
	

}
