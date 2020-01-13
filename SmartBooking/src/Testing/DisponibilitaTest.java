package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Disponibilita;


class DisponibilitaTest {

	@Test
	  void testDocentCostructorEmpty() {
	    Disponibilita d = new Disponibilita();
	    assertNotNull(d);
	  }

	  @Test
	  void testGetGiorno() {
		String t = "10:00";
		Disponibilita r = new Disponibilita("Lunedi", t, "0512100001");
	    assertEquals("Lunedi", r.getGiorno());
	  }
	  
	  @Test
	  void testGetOra() {
		  String t = "10:00";
		  Disponibilita r = new Disponibilita("Lunedi", t, "0512100001");
	    assertEquals(t, r.getOra());
	  }
	  
	  @Test
	  void testGetMatricolaDocente() {
		  String t = "10:00";
	    Disponibilita r = new Disponibilita("Lunedi", t, "0512100001");
	    assertEquals("0512100001", r.getMatricolaDocente());
	  }
	  
	  @Test
	  void testSetGiorno() {
		  String t = "10:00";
	    Disponibilita r = new Disponibilita("", t, "0512100001");
	    r.setGiorno("Lunedi");
	    assertEquals("Lunedi", r.getGiorno());
	  }
	  
	  @Test
	  void testSetOra() {
		String t = "10:00";
	    Disponibilita r = new Disponibilita("Lunedi", null, "0512100001");
	    r.setOra(t);
	    assertEquals(t, r.getOra());
	  }
	  
	  @Test
	  void testSetMatricolaDocente() {
		String t = "10:00";
	    Disponibilita r = new Disponibilita("Lunedi", t, "");
	    r.setMatricolaDocente("0512100001");
	    assertEquals("0512100001", r.getMatricolaDocente());
	  }


}
