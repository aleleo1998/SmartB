package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DocenteModel;
import Model.ListaPreferitiModel;
import gestioneListaPreferiti.GestioneListaPreferiti;
import gestioneListaPreferiti.GestioneListaPreferitiControl;

/**
 * Servlet richiamata da ViewRicercaDocenti.js. Legge un dato dalla richiesta http (matricolaDocente), 
 * riceve informazioni dalla sessione riguardanti la matricola dello studente ed effettua una query nel database (tabella ListaPreferiti)
 * per determinare se la lista dei preferiti dello studente loggato contiene il docente ottenuto dalla richiesta.
 */
@WebServlet("/TrovaCorrispondenzaDocenteStudenteServlet")
public class TrovaCorrispondenzaDocenteStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneListaPreferiti gestioneListaPreferiti = new GestioneListaPreferitiControl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrovaCorrispondenzaDocenteStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String matricolaDocente = request.getParameter("matricolaDocente");
		
		String matricolaStudente = (String) request.getSession().getAttribute("Utente"); 
		
		try {
			if(gestioneListaPreferiti.trovaCorrispondenza(matricolaDocente, matricolaStudente)){
				
				out.write("esiste");
				
			}else{
				
				out.write("non esiste");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//OLD
		/*ListaPreferitiModel lpm = new ListaPreferitiModel();
		
		try {
			if(lpm.existIntoDB(matricolaDocente,matricolaStudente)) //se esiste corrispondenza
				out.write("esiste");
			else
				out.write("non esiste");
				
		} catch (Exception e) {
			

		}*/
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
