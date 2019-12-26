/**
 * 
 */
package Model;

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
	public Disponibilita(String giorno, String ora, String matricolaDocente) {
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
	public String getOra() {
		return ora;
	}
	/**
	 * @param ora the ora to set
	 */
	public void setOra(String ora) {
		this.ora = ora;
	}
	

	/**
	 * @return the docente
	 */
	public String getMatricolaDocente() {
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
	private String ora;
	private String docente;

}
