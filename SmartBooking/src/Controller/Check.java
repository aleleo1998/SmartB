package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import gestioneUtenti.GestioneUtenti;
import gestioneUtenti.GestioneUtentiConcrete;

public class Check {
	
	public Check() throws IOException {
		file = new FileWriter("log.txt");
	}

	public static String checkMatricolaStudente(String matricola) {
		
		GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
		
		if(matricola.matches("[0-9]{10}")) {
			if(gestioneUtenti.cercaMatricola(matricola))
				return "ok";
			else
				return "gia esiste";
		}
		else
			return "non corretto";
	}
	
	public static boolean checkNome(String nome) {
		if(nome.matches("[A-Za-z]{1,10}"))
			return true;
		else 
			return false;
	}
	
	public static boolean checkCognome(String cognome) {
		if(cognome.matches("[A-Za-z]{1,20}"))
			return true;
		else
			return false;
	}
	
	public static String checkStudenteMail(String email){
		
			GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
		
			if(email.matches("\\w+([\\.-]?\\w+)*@studenti[.]{1}unisa[.]{1}it")  &&  email.length()>=20 &&  email.length() <=50) {
				if(gestioneUtenti.cercaEmail(email))
					return "ok";
				else
					return "gia esiste";
			}
			else 
				return "non corretto";
		}

	
	public static boolean checkDocenteMail(String email) throws IOException {
		
		file = new FileWriter("log.txt");
		
		GestioneUtenti gestioneUtenti = new GestioneUtentiConcrete();
		
		if(email.matches("\\w+([\\.-]?\\w+)*@unisa[.]{1}it")) {
			if(gestioneUtenti.cercaEmail(email)) {
				return true;
			}
			String message = "Email già esiste nel database";
			//byte[] b = message.getBytes();
			file.write(message);
			file.close();
			
			FileInputStream read = new FileInputStream("log.txt");
			System.out.println("leggo: "+read.read());
			file.close();
			
			//email già esiste nel database
			return false;
		}
		else {
			//email non corretta
			return false;
		}
	}
	
	public static boolean checkPassword(String password) {
		if(password.matches("[A-Za-z0-9]{8,20}"))
			return true;
		else
			return false;
	}
	
	public static boolean checkConfermaPassword(String password,String conferma) {
		if(conferma.matches("[A-Za-z0-9]{8,20}") && conferma.contentEquals(password))
			return true;
		else
			return false;
	}
	
	public static boolean checkUfficio(String ufficio) {
		if(ufficio.matches("[A-Za-z0-9]{1,20}"))
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
	
	
	//GESTIONE RICHIESTA MODIFCA ORARIO
	
		public static boolean checkGiorno(String giorno){
			
			if(giorno.equalsIgnoreCase("lunedi") || giorno.equalsIgnoreCase("lunedì")){
				return true;
			}
			
			if(giorno.equalsIgnoreCase("martedi") || giorno.equalsIgnoreCase("martedì")){
				return true;
			}
			
			if(giorno.equalsIgnoreCase("mercoledi") || giorno.equalsIgnoreCase("mercoledì")){
				return true;
			}
			
			if(giorno.equalsIgnoreCase("giovedi") || giorno.equalsIgnoreCase("giovedì")){
				return true;
			}
			
			if(giorno.equalsIgnoreCase("venerdi") || giorno.equalsIgnoreCase("venerdì")){
				return true;
			}
			
			if(giorno.equalsIgnoreCase("sabato")){
				return true;
			}
			
			if(giorno.equalsIgnoreCase("domenica")){
				return true;
			}
			
			return false;
			
		}
		
		
		
			public static boolean checkOra(String ora){
					
					if(ora.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
						
						return true;
						
					}
					
					return false;
					
				}
			
			
			public static boolean checkOraInizioOraFine(String oraInizio, String oraFine){
				
				if(oraInizio.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")  &&  oraFine.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
					
					float temp2 = Float.parseFloat(oraInizio.substring(3,5));
					float temp = Float.parseFloat(oraInizio.substring(0,2));
					
					float inizio = temp +(temp2/100);
					
					temp2 = Float.parseFloat(oraFine.substring(3,5));
					temp = Float.parseFloat(oraFine.substring(0,2));
					
					float fine = temp +(temp2/100);
					
					if(inizio < fine)
				    	return true;
					else
				    	return false;
					
					
					
				}
				
				return false;
				
				
				
			}
	
	
	
	
	 private static FileWriter file;

}
