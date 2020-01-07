package gestioneUtenti;

import Model.StudenteModel;

public class GestioneEmailStudente {
	
	public GestioneEmailStudente() {}
	
	
	public boolean verificaMail(String email) {
		StudenteModel sm = new StudenteModel();
		try {
			if(sm.existIntoDB(email)) {
				System.out.println("Mail esistente nel DB");
				return false;
			}else {
				System.out.println("Mail non esistente nel DB");
				return true;
				
			}
				}catch(Exception e) {
					return false;
				}
	}


}
