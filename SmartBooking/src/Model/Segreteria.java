package Model;

public class Segreteria extends Utente{

	/**
	 * @param nome
	 * @param cognome
	 * @param matricola
	 * @param password
	 * @param email
	 */
	public Segreteria(String nome, String cognome, String matricola, String password, String email,String o) {
		super(nome, cognome, matricola, password, email);
		this.orari = o;
		// TODO Auto-generated constructor stub
	}
	
	
	public Segreteria(){super();}
	
	
	private String orari;


	/**
	 * @return the orari
	 */
	public String getOrari() {
		return orari;
	}


	/**
	 * @param orari the orari to set
	 */
	public void setOrari(String orari) {
		this.orari = orari;
	}
		

}
