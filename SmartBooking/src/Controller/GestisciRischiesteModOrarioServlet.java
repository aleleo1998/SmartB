package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneOrari.GestioneOrari;
import gestioneOrari.GestioneOrariConcrete;

/**
 * Servlet implementation class GestisciRischiesteModOrarioServlet
 */
@WebServlet("/GestisciRischiesteModOrarioServlet")
public class GestisciRischiesteModOrarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneOrari gestioneOrari = new GestioneOrariConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestisciRischiesteModOrarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter writer =  response.getWriter();
		
		String id = request.getParameter("id");
		String stato = request.getParameter("stato");
		
		
		
		if(stato.equals("acc")){
			
			
			if(gestioneOrari.accettaRichiesta(Integer.parseInt(id))){
				System.out.println("ok accettata");
				writer.write("ok");
			}
			
			
		}else if(stato.equals("dec")){
			
			if(gestioneOrari.rifiutaRichiesta(Integer.parseInt(id))){
				writer.write("ok");
			}
			
			
		}
		
		writer.close();
		
		
	}
	
}


