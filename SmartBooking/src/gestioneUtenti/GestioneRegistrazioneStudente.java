package gestioneUtenti;

import Model.Studente;
import Model.StudenteModel;

public class GestioneRegistrazioneStudente {
	
	
	public GestioneRegistrazioneStudente() {}

	public void registraStudente(Studente studente) {
		StudenteModel sm = new StudenteModel();
		try {
			sm.doSave(studente);
			System.out.println("\nStudente aggiunto correttamente al Database");
		}catch(Exception e) {
			System.out.println("\nErrore nel metodo registraStudente(Studente studente) della classe GestioneRegistrazioneStudente");
			e.printStackTrace();
		}
	}

}
