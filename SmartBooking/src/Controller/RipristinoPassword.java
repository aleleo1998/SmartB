package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class RipristinoPassword
 */
@WebServlet("/RipristinoPassword")
public class RipristinoPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RipristinoPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		String risposta = "";
		
		String email = request.getParameter("email");
		
		
		
		
		risposta = Check.checkStudenteMail(email);		
		if(risposta.equals("ok")) {
			String risp ="";
			risp = "L'indirizzo email non esiste nel db";
			writer.write(risp);	
			return;
		}
		if(risposta.equals("non corretto")) {
			writer.write(risposta);
			return;
		}
		gestioneUtenti.ripristinaPasswordEmail(email);
		risposta = "email inviato";
		writer.write(risposta);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
