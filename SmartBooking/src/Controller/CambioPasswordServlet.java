package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

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
		
		PrintWriter writer = response.getWriter();
		
		String risposta = "";
		
		
		String vecchiaPassword = request.getParameter("vecchiaPassword");
		System.out.print("vecchia password: "+vecchiaPassword);
		String nuovaPassword = request.getParameter("nuovaPassword");
		System.out.println("nuova password: "+nuovaPassword);
		
		if(!Check.checkPassword(vecchiaPassword) ) {
			
			risposta = "password non corretta";
			writer.write(risposta);
			return;
		}
		
		if(!Check.checkPassword(nuovaPassword) ) {
			risposta = "nuova password non corretta";
			writer.write(risposta);
			return;
		}
		
		UtenteModel md = new UtenteModel();
		
		
		Utente u = null;
		
		HttpSession session = request.getSession();
		
		u = (Utente) session.getAttribute("studente");
		if(u == null) {
			u = (Utente) session.getAttribute("docente");
			if(u == null) {
				u = (Utente) session.getAttribute("segreteria");
			}
		}
		
		
		
		
		try {
			u = md.doRetrieveByKey(u.getMatricola());
			System.out.println(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		if(gestioneUtenti.cambiaPassword(u, vecchiaPassword, nuovaPassword)) {
			System.out.println("Query effettuata con successo.");
			risposta = "Password cambiata"	;		
		}
			
		else {
			System.out.println("Errore durante l'esecuzione della query");
		}
			
		
		writer.write(risposta);
		response.sendRedirect("./jsp/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

