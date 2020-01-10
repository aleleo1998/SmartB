package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Studente;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class RegistrazioneStudenteServlet
 */
@WebServlet("/RegistrazioneStudenteServlet")
public class RegistrazioneStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Studente studente;
		
		PrintWriter writer = response.getWriter();
		
		String risposta = "";
		
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String matricola = request.getParameter("matricola");
		//String genere = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confermaPassword =  request.getParameter("confermaPassword");
		
		
		studente = new Studente(nome,cognome,matricola,password,email);
		
		
		
		///
		
		if(Check.checkNome(nome)) {
			System.out.println("Nome ok");
			//risposta="Nome ok";
			
			if(Check.checkCognome(cognome)){
				System.out.println("Cognome ok");
				//risposta="Cognome ok";
				
				if(Check.checkMatricolaStudente(matricola).contentEquals("ok")) {
					System.out.println("Matricola ok");
					//risposta="Matricola ok";
					
					if(Check.checkStudenteMail(email).contentEquals("ok")) {
						System.out.println("Email ok");
						//risposta="Email ok";
						
						if(Check.checkPassword(password)) {
							System.out.println("Password ok");
							//risposta="Password ok";
							
							if(Check.checkConfermaPassword(password, confermaPassword)) {
								System.out.println("Conferma Password ok");
								//risposta="Conferma Password ok";
								
								
								
								
								
								try {
									if(gestioneUtenti.registrazioneStudente(studente)) {
										
										//***SEND MAIL****//
										
										response.sendRedirect("./jsp/SuccessReg.jsp");
									}else {
										System.out.print("no ok");
									}
									}catch(Exception e) {
										response.sendRedirect("./jsp/RegView.jsp");
									}
								
								
								
								
								
								
								
							}else { 
								System.out.println("Le password non corrispondono");
								risposta="Le password non corrispondono";
								
							}
							
							
						}else {
							System.out.println("Password non ok");
							risposta="Password non corretta";
							
						}
						
					}else if(Check.checkStudenteMail(email).contentEquals("gia esiste")) {
						System.out.println("Email già presente nel database");
						risposta="Email già presente nel database";
					}else if(Check.checkStudenteMail(email).contentEquals("non corretto")) {
						System.out.println("Email non corretta");
						risposta="Email non corretta";
						
					}
					
				}else if(Check.checkMatricolaStudente(matricola).contentEquals("gia esiste")){
					System.out.println("Matricola già presente nel database");
					risposta="Matricola già presente nel database";
				}else if(Check.checkMatricolaStudente(matricola).contentEquals("non corretto")) {
					System.out.println("Matricola non corretta");
					risposta="Matricola non corretta";
					
				}
				
				
				
			}else{
				System.out.println("Cognome non corretto");
				risposta="Cognome non corretto";
				
			}
			
		}else{
			System.out.println("Nome non corretto");
			risposta="Nome non corretto";
		}
		
		 
		
		
		response.setContentType("text");
		writer.print(risposta);
		
		
		
		
		///
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
