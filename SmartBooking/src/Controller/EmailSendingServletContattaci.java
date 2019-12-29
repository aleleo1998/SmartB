package Controller;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneMail.EmailUtility;;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServletContattaci")
public class EmailSendingServletContattaci extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// legge dal file web.xml le impostazioni del server SMTP
		ServletContext context = getServletContext();
		host = context.getInitParameter("host"); 
		port = context.getInitParameter("port");
		user = context.getInitParameter("user"); //indirizzo email mittente (sitoweb)
		pass = context.getInitParameter("pass"); //password email mittente
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// legge i parametri ricevuti dal form
		String destinatario = "acawrestlingfederation@gmail.com"; //Destinatario (in questo caso il destinatario sarà l'email del sito stesso) 
		String emailMittente = request.getParameter("email-mittente"); //email mittente
		String nome = request.getParameter("nome"); //nome mittente
		String subject = request.getParameter("subject"); //oggetto
		String content = request.getParameter("content"); //contenuto 

		String messaggio = "";
		messaggio = messaggio + emailMittente + "\n" + nome + "\n" + content;
		System.out.println(messaggio);
		String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, destinatario, subject, content, nome, emailMittente); //chiama la funzione sendEmail per inviare l'email
			resultMessage = "The e-mail was sent successfully"; //setta il messaggio di buona riuscita dell'invio
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage(); //altrimenti crea un messaggio di errore
		} finally {
//			request.setAttribute("Message", resultMessage);
			request.getSession().setAttribute("Message", resultMessage);  //crea in entrambi i casi il messaggio di successo/insuccesso
			response.sendRedirect("./jsp/ResultContattaci.jsp");
//			getServletContext().getRequestDispatcher("../jsp/ResultContattaci.jsp").forward(request, response); 
		} 
	}
}