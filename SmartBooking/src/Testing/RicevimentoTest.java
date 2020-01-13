package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import Model.Ricevimento;
import Model.Segreteria;

class RicevimentoTest {

	@Test
	  void testDocentCostructorEmpty() {
	    Ricevimento r = new Ricevimento();
	    assertNotNull(r);
	  }

	  @Test
	  void testGetStato() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    assertEquals("Accettato", r.getStato());
	  }

	  @Test
	  void testGetData() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    assertEquals(d, r.getData());
	  }

	  @Test
	  void testGetDataPrenotazione() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    assertEquals(d, r.getDataPrenotazione());
	  }
	  
	  @Test
	  void testGetId() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    assertEquals(1, r.getId());
	  }
	  
	  @Test
	  void testGetMatDocente() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    assertEquals("0512100001", r.getMatDocente());
	  }
	  
	  @Test
	  void testGetMatStudente() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    assertEquals("0512105215", r.getMatStudente());
	  }
	  
	  @Test
	  void testSetStato() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("", d, d, 1, "0512100001", "0512105215");
	    r.setStato("Accettato");
	    assertEquals("Accettato", r.getStato());
	  }
	  

	  @Test
	  void testSetData() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", null, d, 1, "0512100001", "0512105215");
	    r.setData(d);
	    assertEquals(d, r.getData());
	  }

	  
	  @Test
	  void testSetDataPrenotazione() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, null, 1, "0512100001", "0512105215");
	    r.setDataPrenotazione(d);
	    assertEquals(d, r.getDataPrenotazione());
	  }
	  
	  @Test
	  void testSetId() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "0512105215");
	    r.setId(2);
	    assertEquals(2, r.getId());
	  }

	  
	  @Test
	  void testSetMatDocente() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "", "0512105215");
	    r.setMatDocente("0512100001");
	    assertEquals("0512100001", r.getMatDocente());
	  }
	  
	  @Test
	  void testSetMatStudente() {
		Date d = new Date();
	    Ricevimento r = new Ricevimento("Accettato", d, d, 1, "0512100001", "");
	    r.setMatStudente("0512105215");
	    assertEquals("0512105215", r.getMatStudente());
	  }
	  
	  
}
