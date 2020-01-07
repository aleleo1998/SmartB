package Controller;
import Model.*;
import gestioneMail.GestioneMail;
import gestioneMail.GestioneMailConcrete;
import gestioneRicevimento.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletContext;
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
	private String host;
	private String port;
	private String user;
	private String pass;
	private static final long serialVersionUID = 1L;
	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host"); 
		port = context.getInitParameter("port");
		user = context.getInitParameter("user"); //indirizzo email mittente (smartbookingplatform@gmail.com)
		pass = context.getInitParameter("pass"); //password email mittente (SmartAcale)
	}
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
		RicevimentoModel rm= new RicevimentoModel();
		DocenteModel dm= new DocenteModel();
		StudenteModel sm= new StudenteModel();
		//String stato, Date data, Date dataPrenotazione, int id, String matDocente,
		//String matStudente
		String d= request.getParameter("date");
		
		
		String[]dd=d.split("/");
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		calendar.set(Integer.parseInt(dd[2]), Integer.parseInt(dd[1])-1, Integer.parseInt(dd[0]));
		
		response.getWriter().println(calendar);
		Date d1=new Date();
		Date d2=new Date();
		Ricevimento r=new Ricevimento("Non valutato",d2,d1,8,request.getParameter("matricolaDocente"),(String)request.getSession().getAttribute("Utente"));
		gr.prenotaRicevimento(r,calendar);
		
		try {
	
			Studente s = sm.doRetrieveByKey((String)request.getSession().getAttribute("Utente"));
			Docente doc= dm.doRetrieveByKey(request.getParameter("matricolaDocente"));
			System.out.println(s);
		
		String content="Prenotazione effettuata per la data "+d+" da parte dello studente:\n"+s.getCognome()+" "+s.getNome()+"\nMatricola: "+s.getMatricola();
		
		
				GestioneMail gestioneMail = new GestioneMailConcrete();		
				//dm.doRetrieveByKey(request.getParameter("matricolaDocente")).getEmail()
				try {
					gestioneMail.sendEmail(host, port, user, pass, user,doc.getEmail(), "", "", "Prenotazione Ricevimento", content );
					content="La prenotazione è stata inoltrata al docente:\n"+doc.getCognome()+" "+doc.getNome()+"\nMatricola: "+doc.getMatricola();
					gestioneMail.sendEmail(host, port, user, pass, user,s.getEmail(), "", "", "Conferma prenotazione Ricevimento", content );//invio email di EmailUtility
					String resultMessage = "The e-mail was sent successfully"; //setta il messaggio di buona riuscita dell'invio
				} catch (Exception ex) {
					ex.printStackTrace();
					String resultMessage = "There were an error: " + ex.getMessage(); //altrimenti crea un messaggio di errore
				} finally {
					//**Cosa fare dopo aver fatto il sendMail***
				} 
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
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
