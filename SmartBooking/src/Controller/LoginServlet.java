package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Docente;
import Model.Segreteria;
import Model.Studente;
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		
		Utente utente = gestioneUtenti.loginUtente(email, password);
		String risposta="";
		//String matricola=utente.getMatricola();
		//System.out.println(matricola);
		//System.out.println("matricola"+utente.getMatricola()+" "+utente.getNome()+" "+utente.getPassword()+" "+utente.getEmail());
		
		
		
		//System.out.println("Settato in sessione con nome 'user': "+utente);
		
		//System.out.println(utente);
		
		if(utente instanceof Model.Docente) {
			risposta="login docente";
			request.getSession().setAttribute("Utente",utente.getMatricola());
			request.getSession().setAttribute("docente", (Docente) utente);
			response.sendRedirect("./jsp/index.jsp");  //profilo docente
		}else if(utente instanceof Model.Studente) {
			risposta="login studente";
			request.getSession().setAttribute("Utente",utente.getMatricola());
			request.getSession().setAttribute("studente",(Studente) utente);  //'Utente'in sessione restituisce la matricola

			response.sendRedirect("./jsp/ProfiloStudente.jsp");  //profilo studente

		}else if(utente instanceof Model.Segreteria) {
			risposta="login segreteria";
			request.getSession().setAttribute("Utente",utente.getMatricola());
			request.getSession().setAttribute("segreteria",(Segreteria) utente);
			
			response.sendRedirect("./jsp/ProfiloSegreteria.jsp");  //profilo segreteria

		}else
		{
			risposta="login fallito";
			response.sendRedirect("./jsp/Login.jsp");
		}//se le credenziali sono sbagliate l'utente viene riportato sulla pagina di login
		response.getWriter().print(risposta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
