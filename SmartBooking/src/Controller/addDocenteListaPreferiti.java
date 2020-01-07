package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Utente;
import Model.UtenteModel;
import gestioneListaPreferiti.GestioneListaPreferiti;
import gestioneListaPreferiti.GestioneListaPreferitiControl;
import Model.Docente;
import Model.Studente;

/**
 * Servlet implementation class addDocenteListaPreferiti
 */
@WebServlet("/addDocenteListaPreferiti")
public class addDocenteListaPreferiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneListaPreferiti gestioneLista = new GestioneListaPreferitiControl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDocenteListaPreferiti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String matricolaDocente = request.getParameter("matricolaDocente");
		
		System.out.println(matricolaDocente);
		
		UtenteModel md = new UtenteModel();
		
		
		Studente s = (Studente) session.getAttribute("studente");
		Docente d = new Docente();
		d = null;
		try {
			d = (Docente) md.doRetrieveByKey(matricolaDocente);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(gestioneLista.addDocente(d, s))
			System.out.println("Query effettuata con successo.");
		else
			System.out.println("Errore durante l'esecuzione della query");
		
		
		response.sendRedirect("./jsp/ViewRicercaDocenti.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
