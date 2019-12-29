package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Utente;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente = gestioneUtenti.loginUtente(email, password);
		
		request.getSession().setAttribute("Utente", utente.getMatricola());  //'Utente'in sessione restituisce la matricola
		
		System.out.println(utente);
		
		if(utente instanceof Model.Docente)
			response.sendRedirect("");  //profilo docente
		else if(utente instanceof Model.Studente)
			response.sendRedirect("");  //profilo studente
		else if(utente instanceof Model.Segreteria)
			response.sendRedirect("");  //profilo segreteria
		else
			response.sendRedirect("./jsp/Login.jsp");  //se le credenziali sono sbagliate l'utente viene riportato sulla pagina di login
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
