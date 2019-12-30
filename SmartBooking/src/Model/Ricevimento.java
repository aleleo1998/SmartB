/**
 * 
 */
package Model;

import java.util.Date;

/**
 * @author ozne2
 *
 */
public class Ricevimento {
	
	
	
	public Ricevimento(String stato, Date data, Date dataPrenotazione, String id, String matDocente,
			String matStudente) {
		super();
		this.stato = stato;
		this.data = data;
		this.dataPrenotazione = dataPrenotazione;
		this.id = id;
		this.matDocente = matDocente;
		this.matStudente = matStudente;
	}
	
	public Ricevimento(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatDocente() {
		return matDocente;
	}

	public void setMatDocente(String matDocente) {
		this.matDocente = matDocente;
	}

	public String getMatStudente() {
		return matStudente;
	}

	public void setMatStudente(String matStudente) {
		this.matStudente = matStudente;
	}

	
	
	/**
	 * @return the stato
	 */
	public String getStato() {
		return stato;
	}
	/**
	 * @param stato the stato to set
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the dataPrenotazione
	 */
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	/**
	 * @param dataPrenotazione the dataPrenotazione to set
	 */
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	//variabili
	private String stato;
	private Date data;
	private Date dataPrenotazione;
	private String id;
	private String matDocente;
	private String matStudente;
	

}
