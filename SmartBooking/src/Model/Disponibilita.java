/**
 * 
 */
package Model;

import java.sql.Time;

/**
 * @author ozne2
 *
 */
public class Disponibilita {
	
	
	//commento
	//hhh
	//new push
	
	/**
	 * @param giorno
	 * @param ora
	 */
	public Disponibilita(String giorno, Time ora, String matricolaDocente) {
		super();
		this.giorno = giorno;
		this.ora = ora;
		this.docente = matricolaDocente;
	}
	public Disponibilita() {}
	
	/**
	 * @return the giorno
	 */
	public String getGiorno() {
		return giorno;
	}
	/**
	 * @param giorno the giorno to set
	 */
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	/**
	 * @return the ora
	 */
	public Time getOra() {
		return ora;
	}
	/**
	 * @param string the ora to set
	 */
	public void setOra(Time ora) {
		this.ora = ora;
	}
	

	/**
	 * @return the docente
	 */
	public String getMatricolaDocente() {
		System.out.println(docente);
		return docente;
	}


	/**
	 * @param docente the docente to set
	 */
	public void setMatricolaDocente(String matricolaDocente) {
		this.docente = matricolaDocente;
	}


	//variabili
	private String giorno;
	private Time ora;
	private String docente;

}
