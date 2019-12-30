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
 * Servlet implementation class RimuoviDocenteServlet
 */
@WebServlet("/RimuoviDocenteServlet")
public class RimuoviDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricola = request.getParameter("matricola");
		System.out.println("Devo eliminare"+matricola);
		
		gestioneUtenti.rimuoviDocente(matricola);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
