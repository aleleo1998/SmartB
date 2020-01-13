package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Docente;
import Model.Studente;

class StudenteTest {

	@Test
	  void testDocentCostructorEmpty() {
	    Studente st = new Studente();
	    assertNotNull(st);
	  }

	  @Test
	  void testGetNome() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    assertEquals("Alfredo", st.getNome());
	  }
	  
	  @Test
	  void testGetCognome() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    assertEquals("Raimondo", st.getCognome());
	  }
	  
	  @Test
	  void testGetMatricola() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    assertEquals("0512105215", st.getMatricola());
	  }
	  
	  
	  @Test
	  void testGetPassword() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    assertEquals("12345678", st.getPassword());
	  }

	  
	  @Test
	  void testGetEmail() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    assertEquals("a.raimondo12@studenti.unisa.it", st.getEmail());
	  }
	  
	  @Test
	  void testSetNome() {
	    Studente st = new Studente("", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    st.setNome("Alfredo");
	    assertEquals("Alfredo", st.getNome());
	  }
	  
	  @Test
	  void testSetCognome() {
	    Studente st = new Studente("Alfredo", "", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	    st.setCognome("Raimondo");
	    assertEquals("Raimondo", st.getCognome());
	  }
	  
	  @Test
	  void testSetMatricola() {
	    Studente st = new Studente("Alfredo", "Raimondo", "", "12345678", "a.raimondo12@studenti.unisa.it");
	    st.setMatricola("0512105215");
	    assertEquals("0512105215", st.getMatricola());
	  }
	  
	  @Test
	  void testSetPassword() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "", "a.raimondo12@studenti.unisa.it");
	    st.setPassword("12345678");
	    assertEquals("12345678", st.getPassword());
	  }
	  
	  @Test
	  void testSetEmail() {
	    Studente st = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "");
	    st.setEmail("a.raimondo12@studenti.unisa.it");
	    assertEquals("Alfredo", st.getNome());
	  }
}

