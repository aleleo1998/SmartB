package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DocenteModel;
import gestioneOrari.GestioneOrari;
import gestioneOrari.GestioneOrariConcrete;

/**
 * Servlet implementation class AggiungiOrarioServlet
 */
@WebServlet("/AggiungiOrarioServlet")
public class AggiungiOrarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneOrari gestioneOrari = new GestioneOrariConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiOrarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		ArrayList<String> giorni = new ArrayList<String>();
		ArrayList<String> orariInizio = new ArrayList<String>();
		ArrayList<String> orariFine = new ArrayList<String>();
		
		String  num = request.getParameter("numOrari");
		
		int numOrari = Integer.parseInt(num);
		
		int i = 1;
		
		for(i = 1; i<=numOrari; i++);{
			
			giorni.add(request.getParameter("giorno"+i));
			orariInizio.add(request.getParameter("oraInizio"+i));
			orariFine.add(request.getParameter("oraFine"+i));
			
		}
		
		gestioneOrari.aggiungiFirstOrario("123",giorni,orariInizio,orariFine);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
