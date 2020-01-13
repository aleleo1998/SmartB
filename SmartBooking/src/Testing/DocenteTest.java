package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Docente;

class DocenteTest {
	
	@Test
	  void testDocentCostructorEmpty() {
	    Docente doc = new Docente();
	    assertNotNull(doc);
	  }

	  @Test
	  void testGetNome() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    assertEquals("Alfredo", doc.getNome());
	  }
	  
	  @Test
	  void testGetCognome() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    assertEquals("Raimondo", doc.getCognome());
	  }
	  
	  @Test
	  void testGetMatricola() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    assertEquals("0512105215", doc.getMatricola());
	  }
	  
	  
	  @Test
	  void testGetPassword() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    assertEquals("12345678", doc.getPassword());
	  }
	  
	  @Test
	  void testGetEmail() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    assertEquals("a.raimondo12@unisa.it", doc.getEmail());
	  }
	  
	  @Test
	  void testGetUfficio() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    assertEquals("uff01", doc.getUfficio());
	  }
	  
	  
	  @Test
	  void testSetNome() {
	    Docente doc = new Docente("", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    doc.setNome("Alfredo");
	    assertEquals("Alfredo", doc.getNome());
	  }
	  
	  
	  @Test
	  void testSetCognome() {
	    Docente doc = new Docente("Alfredo", "", "0512105215", "12345678", "a.raimondo12@unisa.it", "uff01");
	    doc.setCognome("Raimondo");
	    assertEquals("Raimondo", doc.getCognome());
	  }
	  
	  
	  @Test
	  void testSetMatricola() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "", "12345678", "a.raimondo12@unisa.it", "uff01");
	    doc.setMatricola("0512105215");
	    assertEquals("0512105215", doc.getMatricola());
	  }
	  
	  @Test
	  void testSetPassword() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "", "a.raimondo12@unisa.it", "uff01");
	    doc.setMatricola("12345678");
	    assertEquals("12345678", doc.getMatricola());
	  }
	  

	  @Test
	  void testSetEmail() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "", "uff01");
	    doc.setEmail("a.raimondo12@unisa.it");
	    assertEquals("a.raimondo12@unisa.it", doc.getEmail());
	  }
	  

	  @Test
	  void testSetUfficio() {
	    Docente doc = new Docente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@unisa.it", "");
	    doc.setUfficio("uff01");
	    assertEquals("uff01", doc.getUfficio());
	  }
	  
}
