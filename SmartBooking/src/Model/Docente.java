package Model;

public class Docente extends Utente{

	public Docente(String nome, String cognome, String matricola, String password, String email, String ufficio) {
		super(nome, cognome, matricola, password, email);
		this.ufficio=ufficio;
		// TODO Auto-generated constructor stub
	}

	public Docente() {
		super();
	}
	
	public String getUfficio() {
		return ufficio;
	}
	
	public void setUfficio(String ufficio) {
		this.ufficio=ufficio;
	}
	
	private String ufficio;
}
