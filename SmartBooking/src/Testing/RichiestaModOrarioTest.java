package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;

import org.junit.jupiter.api.Test;

import Model.Disponibilita;
import Model.RichiestaModOrario;

class RichiestaModOrarioTest {

	
	@Test
	  void testDocentCostructorEmpty() {
	    RichiestaModOrario rmo = new RichiestaModOrario();
	    assertNotNull(rmo);
	  }

	  @Test
	  void testGetId() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals(1, rmo.getId());
	  }
	  
	  @Test
	  void testGetMatricolaDocente() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals("0512100001", rmo.getMatricolaDocente());
	  }
	  
	  @Test
	  void testGetMatricolaSegreteria() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals("0512199999", rmo.getMatricolaSegreteria());
	  }
	  
	  @Test
	  void testGetOraInizio() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals("15.00", rmo.getOraInizio());
	  }
	  
	  @Test
	  void testGetOraFine() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals("17.00", rmo.getOraFine());
	  }
	  
	  @Test
	  void testGetGiornoPrecedente() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals("Lunedi", rmo.getGiornoPrecedente());
	  }
	  
	  @Test
	  void testGetGiorno() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
	    assertEquals("Martedi", rmo.getGiorno());
	  }
	  
	  @Test
	  void testSetId() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
		rmo.setId(2);
	    assertEquals(2, rmo.getId());
	  }
	  
	  @Test
	  void testSetMatricolaDocente() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "", "0512199999", "15.00", "17.00", "Lunedi", "Martedi");
		rmo.setMatricolaDocente("0512100001");
	    assertEquals("0512100001", rmo.getMatricolaDocente());
	  }
	  
	  
	  @Test
	  void testSetMatricolaSegreteria() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "", "15.00", "17.00", "Lunedi", "Martedi");
		rmo.setMatricolaSegreteria("0512199999");
	    assertEquals("0512199999", rmo.getMatricolaSegreteria());
	  }
	  
	  @Test
	  void testSetOraInizio() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "", "17.00", "Lunedi", "Martedi");
		rmo.setOraInizio("15.00");
	    assertEquals("15.00", rmo.getOraInizio());
	  }
	  
	  @Test
	  void testSetOraFine() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "", "Lunedi", "Martedi");
		rmo.setOraFine("17.00");
	    assertEquals("17.00", rmo.getOraFine());
	  }
	  
	  @Test
	  void testSetGiornoPrecedente() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "", "Martedi");
		rmo.setGiornoPrecedente("Lunedi");
	    assertEquals("Lunedi", rmo.getGiornoPrecedente());
	  }
	  
	  @Test
	  void testSetGiorno() {
		RichiestaModOrario rmo = new RichiestaModOrario(1, "0512100001", "0512199999", "15.00", "17.00", "Lunedi", "");
		rmo.setGiorno("Martedi");
	    assertEquals("Martedi", rmo.getGiorno());
	  }

}
