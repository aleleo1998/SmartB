/**
 * 
 */
package gestioneListaPreferiti;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Model.Docente;
import Model.Studente;

/**
 * @author ozne2
 *
 */
public interface GestioneListaPreferiti {
	
	public boolean addDocente(Docente d,Studente s);
	public boolean removeDocente(Docente d, Studente s);
	public boolean trovaCorrispondenza(String matDoc, String matStud) throws Exception;

	

}
