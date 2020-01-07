package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gestioneRicevimento.*;
import Model.*;

/**
 * Servlet implementation class AccettaRicevimentoServlet
 */
@WebServlet("/AccettaRicevimentoServlet")
public class AccettaRicevimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccettaRicevimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestioneRicevimento gr= new GestioneRicevimentoConcrete();
		RicevimentoModel rm= new RicevimentoModel();
		int id=Integer.parseInt(request.getParameter("id"));
		String operazione = request.getParameter("operazione");
		try
		{
		  Ricevimento r= rm.doRetrieveByKey(id);
		  if(operazione.equals("1"))
		  {
	     
	      
			
			boolean verifica=gr.accettaRicevimento(r);
			System.out.println(verifica);
			if(verifica)
			{
				response.sendRedirect("visualizzaRicevimentiServlet");
			}
		  } 
	      
		
		  else
		  {
			if(rm.doDelete(id))
			{
				response.sendRedirect("visualizzaRicevimentiServlet");
			}
		  }
	    }
        catch (SQLException e) {
			
			e.printStackTrace();
		  }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
