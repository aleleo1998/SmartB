package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Docente;
import Model.Studente;
import Model.StudenteModel;
import Model.UtenteModel;
import gestioneListaPreferiti.GestioneListaPreferiti;
import gestioneListaPreferiti.GestioneListaPreferitiControl;

/**
 * Servlet implementation class removeDocenteListaPreferiti
 */
@WebServlet("/removeDocenteListaPreferiti")
public class removeDocenteListaPreferiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestioneListaPreferiti gestioneLista = new GestioneListaPreferitiControl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeDocenteListaPreferiti() {
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
		
		UtenteModel md = new UtenteModel();
		
		//
			
			Studente s = (Studente) session.getAttribute("studente");
			System.out.println("Matricola studente: "+s.getMatricola());
			
		//
		//Studente s = (Studente) session.getAttribute("user");
		Docente d = new Docente();
		d = null;
		try {
			d = (Docente) md.doRetrieveByKey(matricolaDocente);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		if(gestioneLista.removeDocente(d,s))
			System.out.println("Query effettuata con successo.");
		else
			System.out.println("Errore durante l'esecuzione della query");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
