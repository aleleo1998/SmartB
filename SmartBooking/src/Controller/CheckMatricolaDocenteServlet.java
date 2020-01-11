package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DocenteModel;
import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

/**
 * Servlet implementation class CheckMatricolaDocenteServlet
 */
@WebServlet("/CheckMatricolaDocenteServlet")
public class CheckMatricolaDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMatricolaDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String matricola = request.getParameter("matricola");
		//System.out.print(matricola);
		
		try {
			if(gestioneUtenti.checkMatricolaDocente(matricola)){
				
				out.write("0");
				
			}else{
				
				out.write("1");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	//	DocenteModel docM = new DocenteModel();
		
		
		
		//OLD
		/*try {
		if(docM.existMatricola(matricola)) {
			//System.out.println("Matricola esistente nel DB");
			out.write("0");
		}else {
			//System.out.println("Matricola non esistente nel DB");
			out.write("1");
		}
			}catch(Exception e) {
				out.write("errore");
			}	*/	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
