package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Docente;
import Model.DocenteModel;
import gestioneOrari.GestioneOrari;
import gestioneOrari.GestioneOrariConcrete;

/**
 * Servlet implementation class AggiungiOrarioServlet
 */
@WebServlet("/AggiungiOrarioServlet")
public class AggiungiOrarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GestioneOrari gestioneOrari = new GestioneOrariConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiOrarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Enumeration<String> params = request.getParameterNames();
		
		ArrayList<String> okok = Collections.list(params);
		
		for(String s : okok) {
			
			System.out.println("aooo"+s);
		}*/
		String risposta="";
		//HttpSession session = request.getSession();
		
		Docente d =(Docente) request.getSession().getAttribute("docente");
		System.out.println(d);
		String matricolaDocente = d.getMatricola();
		
		boolean tf=true;
		
		ArrayList<String> giorni = new ArrayList<String>();
		ArrayList<String> orariInizio = new ArrayList<String>();
		ArrayList<String> orariFine = new ArrayList<String>();
		
		String  num = request.getParameter("numOrari");
		
		System.out.println(num);
		
		int numOrari = Integer.parseInt(num);
		
		for(int i = 1 ; i<=numOrari; i++)
		{
			
			System.out.println("giorno: "+request.getParameter("giorno"+i));
			System.out.println(request.getParameter("oraInizio"+i)+" "+request.getParameter("oraFine"+i));
			if(Check.checkGiorno((request.getParameter("giorno"+i))))
			{
			  giorni.add(request.getParameter("giorno"+i));
			  if(Check.checkOra(request.getParameter("oraInizio"+i)))
			  {
			    if(Check.checkOra(request.getParameter("oraFine"+i))) {
			      if(Check.checkOraInizioOraFine((request.getParameter("oraInizio"+i)),(request.getParameter("oraFine"+i))))
			      {
			        orariInizio.add(request.getParameter("oraInizio"+i));
			        orariFine.add(request.getParameter("oraFine"+i));
			      }
			      else{
				    risposta="orario Inizio/Fine non corretto";
				    tf=false;
				    break;
				  }
			    }
			    else
			    {
			    	risposta="orario Fine non corretto";
					tf=false;
					break;
			    }
			  }
			  else {
				risposta="orario Inizio non corretto";
				tf=false;
				break;
			  }
			}
			else{
				tf=false;
				risposta="giorno non corretto";
				break;
			}
		}
		
		try {
			if(tf)
			gestioneOrari.aggiungiFirstOrario(matricolaDocente,giorni,orariInizio,orariFine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print(risposta);
	}

}
