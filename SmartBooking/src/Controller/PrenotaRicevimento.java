package Controller;
import Model.*;
import gestioneRicevimento.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrenotaRicevimento
 */
@WebServlet("/PrenotaRicevimento")
public class PrenotaRicevimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotaRicevimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestioneRicevimento gr= new GestioneRicevimentoConcrete();
		//RicevimentoModel rm= new RicevimentoModel();
		//String stato, Date data, Date dataPrenotazione, int id, String matDocente,
		//String matStudente
		String d= request.getParameter("date");
		
		
		String[]dd=d.split("/");
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		calendar.set(Integer.parseInt(dd[2]), Integer.parseInt(dd[1]), Integer.parseInt(dd[0]));
		response.getWriter().println(calendar);
		Date d1=new Date();
		Date d2=new Date();
		Ricevimento r=new Ricevimento("Non valutato",d2,d1,8,request.getParameter("matricolaDocente"),"0512105641");
		gr.prenotaRicevimento(r,calendar);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
