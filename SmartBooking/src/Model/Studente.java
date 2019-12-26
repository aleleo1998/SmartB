package Model;

import java.util.ArrayList;

public class Studente extends Utente {
	
	
	
	

	/**
	 * @param nome
	 * @param cognome
	 * @param matricola
	 * @param password
	 * @param email
	 */
	public Studente(String nome, String cognome, String matricola, String password, String email) {
		super(nome, cognome, matricola, password, email);
		listaPreferiti = new ArrayList<Docente>();
		// TODO Auto-generated constructor stub
	}

	public Studente() {
		super();
	}
	
	/**
	 * @return the listaPreferiti
	 */
	public ArrayList<Docente> getListaPreferiti() {
		return listaPreferiti;
	}

	/**
	 * @param listaPreferiti the listaPreferiti to set
	 */
	public void setListaPreferiti(ArrayList<Docente> listaPreferiti) {
		this.listaPreferiti = listaPreferiti;
	}

	private ArrayList<Docente> listaPreferiti;
	

}
