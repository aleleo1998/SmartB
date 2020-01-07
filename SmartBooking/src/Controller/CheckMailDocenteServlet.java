package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DocenteModel;

/**
 * Servlet implementation class CheckMailDocenteServlet
 */
@WebServlet("/CheckMailDocenteServlet")
public class CheckMailDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		
		DocenteModel docM = new DocenteModel();
		
		try {
		if(docM.existEmail(email)) {
			System.out.println("Matricola esistente nel DB");
			out.write("0");
		}else {
			System.out.println("Matricola non esistente nel DB");
			out.write("1");
		}
			}catch(Exception e) {
				out.write("errore");
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
