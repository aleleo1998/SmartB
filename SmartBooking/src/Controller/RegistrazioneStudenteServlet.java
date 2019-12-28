package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Studente;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class RegistrazioneStudenteServlet
 */
@WebServlet("/RegistrazioneStudenteServlet")
public class RegistrazioneStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Studente studente;
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String matricola = request.getParameter("matricola");
		//String genere = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confermaPassword =  request.getParameter("confermaPassword");
		
		studente = new Studente(nome,cognome,matricola,password,email);
		
		if(gestioneUtenti.registrazioneStudente(studente)) {
			System.out.print("ok");
		}else {
			System.out.print("no ok");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
