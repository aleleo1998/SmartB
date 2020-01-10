package Testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import Controller.RegistrazioneStudenteServlet;

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

}
