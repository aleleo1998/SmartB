package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Docente;
import gestioneMail.GestioneMail;
import gestioneMail.GestioneMailConcrete;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class RegistrazioneDocenteServlet
 */
@WebServlet("/RegistrazioneDocenteServlet")
public class RegistrazioneDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String host;
	private String port;
	private String user;
	private String pass;

	/**
	 * metodo di configurazione, legge i dati dal file web.xml 
	 */
	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host"); 
		port = context.getInitParameter("port");
		user = context.getInitParameter("user"); //indirizzo email mittente (smartbookingplatform@gmail.com)
		pass = context.getInitParameter("pass"); //password email mittente (SmartAcale)
	}

	/**
	 * metodo che genera una stringa di 8 caratteri casuali
	 * @return p stringa di 8 caratteri
	 */
	public String generaPassword() {
		Random rnd = new Random ();
		char[] arr = new char[8];

		for (int i=0; i<8; i++) {
		int n = rnd.nextInt (36);
		arr[i] = (char) (n < 10 ? '0'+n : 'a'+n-10);
		}

		return new String (arr);
		
	}
	
	private static GestioneMail gestioneMail = new GestioneMailConcrete();
	private static GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("SONO IN REGSERVLET");
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String matricola = request.getParameter("matricola");
		System.out.println(matricola);
		/* Genera password casuale*/
		String password=generaPassword();
		//System.out.println("password"+password);
		
		//String password = request.getParameter("password");
		String email = request.getParameter("email");
		String ufficio = request.getParameter("ufficio");
		
		System.out.println("CREO DOCENTE DA INSERIRE");
		Docente doc = new Docente(nome, cognome, matricola, password, email, ufficio);
		System.out.println("DOCENTE CREATO");
		//System.out.println(doc.getNome());
		gestioneUtenti.registrazioneDocente(doc);
		
		System.out.println("Registrazione fatta");
		
		
			
		//*******INVIO EMAIL********//
			//Invio email con credenziali
			String emailMittente="smartbookingplatform@gmail.com";
			String emailDestinatario=email;
			String subject="Benvenuto Su SmartBooking";
			
			//Creazione messaggio(content) da inviare 
			String indexEmail="Gentile "+cognome +" "+ nome+" "+"benvenuto su SmartBooking. \n Le sue credenziali di accesso sono: \n";
			String indexCredenziali="Email: "+email+"\n"+"Password: "+password;
			
			String content= indexEmail +"\n"+ indexCredenziali;
			
			
			String resultMessage = "";
	
			try {
				gestioneMail.sendEmail(host, port, user, pass, emailMittente, emailDestinatario, nome, cognome, subject, content); //invio email di EmailUtility
				resultMessage = "The e-mail was sent successfully"; //setta il messaggio di buona riuscita dell'invio
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage(); //altrimenti crea un messaggio di errore
			} finally {
				//**Cosa fare dopo aver fatto il sendMail***
			} 
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
