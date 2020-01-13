package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Docente;
import Model.Segreteria;
import Model.Studente;

class SegreteriaTest {

	@Test
	  void testDocentCostructorEmpty() {
	    Segreteria s = new Segreteria();
	    assertNotNull(s);
	  }

	  @Test
	  void testGetNome() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    assertEquals("Alfredo", s.getNome());
	  }
	  
	  @Test
	  void testGetCognome() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    assertEquals("Raimondo", s.getCognome());
	  }
	  
	  @Test
	  void testGetMatricola() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    assertEquals("0512105215", s.getMatricola());
	  }
	  
	  @Test
	  void testGetPassword() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    assertEquals("12345678", s.getPassword());
	  }
	  
	  @Test
	  void testGetEmail() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    assertEquals("segreteria@unisa.it", s.getEmail());
	  }
	  
	  @Test
	  void testGetOrari() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    assertEquals("Lun:15.00-19.00", s.getOrari());
	  }
	  
	  @Test
	  void testSetNome() {
		Segreteria s = new Segreteria("", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    s.setNome("Alfredo");
	    assertEquals("Alfredo", s.getNome());
	  }
	  
	  @Test
	  void testSetCognome() {
		Segreteria s = new Segreteria("Alfredo", "", "0512105215", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    s.setCognome("Raimondo");
	    assertEquals("Raimondo", s.getCognome());
	  }
	  
	  @Test
	  void testSetMatricola() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "", "12345678", "segreteria@unisa.it", "Lun:15.00-19.00");
	    s.setMatricola("0512105215");
	    assertEquals("0512105215", s.getMatricola());
	  }
	  
	  @Test
	  void testSetPassword() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "", "segreteria@unisa.it", "Lun:15.00-19.00");
	    s.setPassword("12345678");
	    assertEquals("12345678", s.getPassword());
	  }
	  
	  @Test
	  void testSetEmail() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "", "Lun:15.00-19.00");
	    s.setEmail("segreteria@unisa.it");
	    assertEquals("segreteria@unisa.it", s.getEmail());
	  }
	  
	  @Test
	  void testSetOrari() {
	    Segreteria s = new Segreteria("Alfredo", "Raimondo", "0512105215", "12345678", "segreteria@unisa.it", "");
	    s.setOrari("Lun:15.00-19.00");
	    assertEquals("Lun:15.00-19.00", s.getOrari());
	  }
	  
	  
}
