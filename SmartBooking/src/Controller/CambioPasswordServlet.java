package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Model.Utente;
import Model.UtenteModel;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CambioPasswordServlet
 */
@WebServlet("/CambioPasswordServlet")
public class CambioPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambioPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vecchiaPassword = request.getParameter("vecchiaPassword");
		System.out.print("vecchia password: "+vecchiaPassword);
		String nuovaPassword = request.getParameter("nuovaPassword");
		System.out.println("nuova password: "+nuovaPassword);
		
		UtenteModel md = new UtenteModel();
		
		
		Utente u = null;
		try {
			u = md.doRetrieveByKey("123");
			System.out.println(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		if(gestioneUtenti.cambiaPassword(u, vecchiaPassword, nuovaPassword))
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
