package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Ricevimento;
import Model.RicevimentoModel;
import gestioneRicevimento.GestioneRicevimento;
import gestioneRicevimento.GestioneRicevimentoConcrete;

/**
 * Servlet implementation class CancellaGiornataAppServlet
 */
@WebServlet("/CancellaGiornataAppServlet")
public class CancellaGiornataAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellaGiornataAppServlet() {
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
		String data=request.getParameter("insertData");
		String []dd=data.split("-");
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		calendar.set(Integer.parseInt(dd[0]), (Integer.parseInt(dd[1])-1), Integer.parseInt(dd[2]));
		System.out.println("claendario"+calendar);
		Date d=new Date();
				d=calendar.getTime();
		Collection<Ricevimento> ricevimenti= new LinkedList<Ricevimento>();
				try 
				{
					
					
					ricevimenti=rm.doRetrieveAllByDate(calendar);
	
					for(Ricevimento r: ricevimenti)
					{
						rm.doDelete(r.getId());
				}} catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("visualizzaRicevimentiServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
