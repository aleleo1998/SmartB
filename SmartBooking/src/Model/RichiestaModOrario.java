package Model;


public class RichiestaModOrario {
	
	public RichiestaModOrario() {}
	
	public RichiestaModOrario(int id,String matricolaDocente, String matricolaSegreteria, String oraInizio, String oraFine, String giornoPrecedente, String giorno) {
		this.id=id;
		this.matricolaDocente = matricolaDocente;
		this.matricolaSegreteria = matricolaSegreteria;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.giornoPrecedente = giornoPrecedente;
		this.giorno = giorno;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getMatricolaDocente() {
		return matricolaDocente;
	}

	public void setMatricolaDocente(String matricolaDocente) {
		this.matricolaDocente = matricolaDocente;
	}

	public String getMatricolaSegreteria() {
		return matricolaSegreteria;
	}

	public void setMatricolaSegreteria(String matricolaSegreteria) {
		this.matricolaSegreteria = matricolaSegreteria;
	}

	public String getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(String oraInizio) {
		this.oraInizio = oraInizio;
	}

	public String getOraFine() {
		return oraFine;
	}

	public void setOraFine(String oraFine) {
		this.oraFine = oraFine;
	}

	public String getGiornoPrecedente() {
		return giornoPrecedente;
	}

	public void setGiornoPrecedente(String giornoPrecedente) {
		this.giornoPrecedente = giornoPrecedente;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	

	


	@Override
	public String toString() {
		return "RichiestaModOrario [id=" + id + ", matricolaDocente=" + matricolaDocente + ", matricolaSegreteria="
				+ matricolaSegreteria + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", giornoPrecedente="
				+ giornoPrecedente + ", giorno=" + giorno + "]";
	}






	private int id;
	private String matricolaDocente;
	private String matricolaSegreteria;
	private String oraInizio;
	private String oraFine;
	private String giornoPrecedente;
	private String giorno;
	
}
