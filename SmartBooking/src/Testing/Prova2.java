package Testing;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import Controller.RegistrazioneStudenteServlet;

public class Prova2 {
	
RegistrazioneStudenteServlet myServlet;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;

	@BeforeEach
	public void beforeEachTestCase(){
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		myServlet = new RegistrazioneStudenteServlet();

	}
	
	@Test
	public void tc_1_0_9() throws IOException, ServletException{
		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		
		when(request.getParameter("nome")).thenReturn("Lorenzo");
		when(request.getParameter("cognome")).thenReturn("Fasolino");
		when(request.getParameter("matricola")).thenReturn("0512102335");
		when(request.getParameter("email")).thenReturn("iao@studenti.unisa.it");
		when(request.getParameter("password")).thenReturn("!");
		when(request.getParameter("confermaPassword")).thenReturn("1234");
		
		
		when(response.getWriter()).thenReturn(out);
		
		
		myServlet.doPost(request, response);
		
		System.out.println(output.toString());
		
		
		assertEquals("Password non ok",output.toString().toString());
		
		
	}
	
	

}
