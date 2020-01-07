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
 * Servlet implementation class CheckMailDocenteServlet
 */
@WebServlet("/CheckMailDocenteServlet")
public class CheckMailDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();

	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMailDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		System.out.print(email);
		
		try {
			if(gestioneUtenti.checkEmailDocente(email)==false) {
				out.write("0");  //email già esiste nel database
			}else {
				out.write("1");  //matricola non esiste nel database
			}
		} catch (Exception e) {
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
