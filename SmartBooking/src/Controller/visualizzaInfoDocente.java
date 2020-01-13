package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Docente;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * La servlet visualizzaInfoDocente si occupa di ricercare nel database un docente con una specifica matricola, 
 * settandolo in sessione con il nome di “infoDocente”.
 */
@WebServlet("/visualizzaInfoDocente")
public class visualizzaInfoDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public visualizzaInfoDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricola = request.getParameter("matricolaDocente");
		
		GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
		Docente docente = gestioneUtenti.cercaDocente(matricola);
		
		request.getSession().setAttribute("infoDocente",docente);
		
		response.sendRedirect("./jsp/InfoDocente.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
