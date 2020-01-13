package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Docente;
import Model.DocenteModel;
import Model.ListaPreferitiModel;

/**
 * Servlet richiamata da ViewRicercaDocenti.js in maniera asincrona. Effettua una query sul databse
 * in modo da restituire come risultato soltanto una tupla della tabella ACALE.Docente contenente le informazioni riguardanti il docente
 * da ricercare.
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Il metodo restituisce il nome del docente dalla stringa in formato "Cognome Nome".
     * @param fullName
     * @return String nome
     */
    private static String getName(String fullName){
        return fullName.split(" (?!.* )")[1];
    }
    
    /**
     * Il metodo restituisce il cognome del docente dalla stringa in formato "Cognome Nome".
     * @param fullName
     * @return String cognome
     */
    private static String getSurname(String fullName){
        return fullName.split(" (?!.* )")[0];
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String result = "";
		
		System.out.print("\nEntrato in FindServlet");
		
		PrintWriter out = response.getWriter();
		
		String docente = request.getParameter("docente");
		
		String nome = getName(docente);
		String cognome = getSurname(docente);
		
		System.out.println("Nome: "+getName(docente));
		System.out.println("Cognome: "+getSurname(docente));
		
		DocenteModel dm = new DocenteModel();
		Docente d = new Docente();
		
		try {
			d = dm.doRetrieveByNameAndSurname(nome,cognome);
			System.out.print(d);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(d.getMatricola() == null) {  //Se non esiste un docente con quella coppia Nome/Cognome
			
			result = result+"<tr>";
			result = result+"<th scope=\"row\">";
			result = result+"Spiacente. Il docente "+docente+" non &egrave; presente nel database";
			result = result+"</th><td></td><td></td><td></td><td></td>";
			result = result+"</tr>";
			result = result+"<tr>";
			result = result+"<td>";
			result = result+"<a href=\"../jsp/ViewRicercaDocenti.jsp\" ><p id=\"all\">Visualizza tutti i docenti</p></a>";
			result = result+"</td>";
			result = result+"</tr>";
			
			
		}else {
			
			ListaPreferitiModel lpm = new ListaPreferitiModel();
			try {
				
				result = result+"<tr>";
				result = result+"<th scope=\"row\">";
				result = result+"<label name=\"nome\" id=\"nome\">"+d.getNome()+"</label> <label name=\"cognome\" id=\"cognome\">"+d.getCognome()+"</label>";
				result = result+"</th>";
				result = result+"<td><p id=\"ufficio\">"+d.getUfficio()+"<p></td>";
				result = result+"<td>";
				result = result+"<form action=\"../visualizzaInfoDocente\">";
				result = result+"<input id=\"matricolaDocente\" style=\"display:none;\" name=\"matricolaDocente\" value=\""+d.getMatricola()+"\"</>";
				result = result+"<button type=\"submit\" href=\"../visualizzaInfoDocente\"><i class=\"fas fa-info-circle\"></i></button>";
				result = result+"</form>";
				result = result+"</td>";
				result = result+"<td>";
				result = result+"<form name=\"form\" action=\"../addDocenteListaPreferiti\">";
				result = result+"<input id=\"matricolaDocente\" style=\"display:none;\" name=\"matricolaDocente\" value=\""+d.getMatricola()+"\"</>";
			
				if(lpm.existIntoDB(d.getMatricola(),(String) request.getSession().getAttribute("Utente"))) {  //Se esiste una corrispondenza docente studente
																									//il docente è nella lista preferiti dello studente
					result = result+"<button name=\"add\" id=\"addButton"+d.getMatricola()+"\" class=\"addButton\" disabled><i class=\"fas fa-user-plus\"></i></button>";
					result = result+"</form>";
					result = result+"</td>";
					result = result+"<td>";
					result = result+"<form name=\"form\" action=\"../removeDocenteListaPreferiti\">";
					result = result+"<input id=\"matricolaDocente\" style=\"display:none;\" name=\"matricolaDocente\" value=\""+d.getMatricola()+"\"</>";
					result = result+"<button name=\"remove\" id=\"removeButton"+d.getMatricola()+"\" class=\"removeButton\"><i class=\"fas fa-user-plus\"></i></button>";
				}else {
					result = result+"<button name=\"add\" id=\"addButton"+d.getMatricola()+"\" class=\"addButton\"><i class=\"fas fa-user-plus\"></i></button>";
					result = result+"</form>";
					result = result+"</td>";
					result = result+"<td>";
					result = result+"<form name=\"form\" action=\"../removeDocenteListaPreferiti\">";
					result = result+"<input id=\"matricolaDocente\" style=\"display:none;\" name=\"matricolaDocente\" value=\""+d.getMatricola()+"\"</>";
					result = result+"<button name=\"remove\" id=\"removeButton"+d.getMatricola()+"\" class=\"removeButton\" disabled><i class=\"fas fa-user-plus\"></i></button>";
				}
				
				result = result+"</form>";
				result = result+"</td>";
				result = result+"<td>";
	    		result = result+"<form name=\"form\" action=\"############\">";
	    		result = result+"<input id=\"matricolaDocente\" style=\"display:none;\" name=\"matricolaDocente\" value=\""+d.getMatricola()+"\"/>";
	    		result = result+"<button name=\"prenota\" id=\"prenota"+d.getMatricola()+"\" class=\"prenotaButton\">Prenota</button>"; 
	      		result = result+"</form>";
	      		result = result+"</td>";
				result = result+"</tr>";
				result = result+"<tr>";
				result = result+"<td>";
				result = result+"<a id=\"link\" href=\"../jsp/ViewRicercaDocenti.jsp\" ><p id=\"all\">Visualizza tutti i docenti</p></a>";
				result = result+"</td>";
				result = result+"</tr>";
				
				System.out.println(result);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}  //fine else interno
		
		out.append(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
