package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Studente;
import Model.StudenteModel;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class CheckMatricolaStudenteServlet
 */
@WebServlet("/CheckMatricolaStudenteServlet")
public class CheckMatricolaStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMatricolaStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entrato nella servlet");
		
		PrintWriter out = response.getWriter();
		
		String matricola = request.getParameter("matricola");
		
		System.out.println(matricola);
		
		
		if(gestioneUtenti.cercaStudente(matricola).getMatricola()!=null) 
			out.write("0");  //La matricola già esiste
		else
			out.write("1");  //La matricola non esiste
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
