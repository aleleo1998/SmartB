package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gestioneRicevimento.*;
import Model.*;
import gestioneMail.GestioneMail;
import gestioneMail.GestioneMailConcrete;

/**
 * Servlet implementation class AccettaRicevimentoServlet
 */
@WebServlet("/AccettaRicevimentoServlet")
public class AccettaRicevimentoServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;
	private static final long serialVersionUID = 1L;
	public void init() {
	    //password email mittente (SmartAcale)
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user"); //indirizzo email mittente (smartbookingplatform@gmail.com)
		pass = context.getInitParameter("pass");
	}
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
		  System.out.println(r.getId());
			DocenteModel dm= new DocenteModel();
			StudenteModel sm= new StudenteModel();
			
			Docente doc =(Docente) request.getSession().getAttribute("docente");
			System.out.println(doc);
			Studente s= sm.doRetrieveByKey(r.getMatStudente());
		  if(operazione.equals("1"))
		  {
	     
	      
			
			boolean verifica=gr.accettaRicevimento(r);
			
			if(verifica)
			{
		
			
			String content="Conferma del ricevimento previsto in data "+r.getData()+"\n"+"da parte di: "+doc.getCognome()+" "+doc.getNome()+"\n"+"Matricola: "+doc.getMatricola();
			
			
					GestioneMail gestioneMail = new GestioneMailConcrete();		
					//dm.doRetrieveByKey(request.getParameter("matricolaDocente")).getEmail()
					System.out.println("HOST:"+ host);
						gestioneMail.sendEmail(host, port, user, pass, 
								doc.getEmail(),
								s.getEmail(), "", "", "Conferma ricevimento", content );
						String resultMessage = "The e-mail was sent successfully"; //setta il messaggio di buona riuscita dell'invio
					 
			}
			 
				response.sendRedirect("visualizzaRicevimentiServlet");
			}
		  
	      
		
		  else
		  {
			if(rm.doDelete(id))
			{
				GestioneMail gestioneMail = new GestioneMailConcrete();	
				String content="Ricevimento Rifiutato/Cancellato da parte di "+doc.getCognome()+" "+doc.getNome()+" Matrciola: "
				+doc.getMatricola()+".Per il seguente motivo: "+request.getParameter("motivazioneCancellazione");
				//dm.doRetrieveByKey(request.getParameter("matricolaDocente")).getEmail()
			
					gestioneMail.sendEmail(host, port, user, pass, doc.getEmail(),"alexleopardi98@gmail.com", "", "", "Cancellazione/Rifiuto ricevimneto", content );
					String resultMessage = "The e-mail was sent successfully"; //setta il messaggio di buona riuscita dell'invio
				
					 //altrimenti crea un messaggio di errore
				
		}
				response.sendRedirect("visualizzaRicevimentiServlet");
			}
		  
	    }
        catch (Exception e) {
			
			e.printStackTrace();
		  }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
