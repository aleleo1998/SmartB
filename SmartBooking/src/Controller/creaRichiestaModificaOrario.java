package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Docente;
import Model.RichiestaModOrario;
import gestioneOrari.GestioneOrari;
import gestioneOrari.GestioneOrariConcrete;

/**
 * Servlet implementation class creaRichiestaModificaOrario
 */
@WebServlet("/creaRichiestaModificaOrario")
public class creaRichiestaModificaOrario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static GestioneOrari gestioneOrari = new GestioneOrariConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creaRichiestaModificaOrario() {
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
		
		HttpSession session = request.getSession();
		
		Docente d =(Docente) session.getAttribute("docente");
		
		String matricolaDocente = d.getMatricola();

		RichiestaModOrario richiesta = new RichiestaModOrario();
		
		
		richiesta.setMatricolaSegreteria("1234");
		richiesta.setMatricolaDocente(matricolaDocente);
		richiesta.setOraInizio(request.getParameter("orarioInizio"));
		richiesta.setOraFine(request.getParameter("orarioFine"));
		richiesta.setGiornoPrecedente(request.getParameter("giornoVecchio"));
		richiesta.setGiorno(request.getParameter("giornoNuovo"));
		
		
		if(Check.checkGiorno(richiesta.getGiorno())){
			
			if(Check.checkGiorno(richiesta.getGiornoPrecedente())){
				
				if(Check.checkOra(richiesta.getOraInizio())){
					
					if(Check.checkOra(richiesta.getOraFine())){
						
						if(Check.checkOraInizioOraFine(richiesta.getOraInizio(), richiesta.getOraFine())){
							
							try {
								gestioneOrari.inoltraRichiesta(richiesta);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							
						}else {
							
							risposta = "Orario fine non corretto";
							
						}
						
						
						
					}else{
						
						risposta = "Orario fine non corretto";
						
					}
					
					
				}else {
					
					risposta = "Orario inizio non corretto";
					
				}
				
				
			}else {
				
				risposta = "Giorno da modificare non corretto";
				
			}
			
		}else{
			
			risposta = "Nuovo giorno non corretto";
			
		}
		
		
		
		response.setContentType("text");
		writer.print(risposta);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
