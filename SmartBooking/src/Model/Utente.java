/**
 * 
 */
package Model;

/**
 * @author ozne2
 *
 */
public class Utente {
	
	
	
	public Utente() {}
	
	
	/**
	 * @param nome
	 * @param cognome
	 * @param matricola
	 * @param password
	 * @param email
	 */
	public Utente(String nome, String cognome, String matricola, String password, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.password = password;
		this.email = email;
	}
	//getters setters
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the matricola
	 */
	public String getMatricola() {
		return matricola;
	}
	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Variabili
	private String nome;
	private String cognome;
	private String matricola;
	private String password;
	private String email;
	
	

}
