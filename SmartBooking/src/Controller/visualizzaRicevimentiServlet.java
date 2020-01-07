package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.*;

/**
 * Servlet implementation class visualizzaRicevimentiServlet
 */
@WebServlet("/visualizzaRicevimentiServlet")
public class visualizzaRicevimentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public visualizzaRicevimentiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RicevimentoModel rm=new RicevimentoModel();
		Collection<Ricevimento> ricevimenti = new LinkedList<Ricevimento>();
		HttpSession sessione= request.getSession();
		try 
		{
			ricevimenti = rm.doRetrieveAllByDoc((String)sessione.getAttribute("Utente"));
			sessione.setAttribute("ricevimenti", ricevimenti);
			response.sendRedirect("./jsp/RicevimentiView.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
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
