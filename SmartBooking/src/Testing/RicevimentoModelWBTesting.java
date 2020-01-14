package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DBConnection.DriverManagerConnectionPool;
import Model.Docente;
import Model.DocenteModel;
import Model.ListaPreferitiModel;
import Model.Ricevimento;
import Model.RicevimentoModel;
import Model.Studente;
import Model.StudenteModel;

class RicevimentoModelWBTesting {

static Docente doc = new Docente("Alfredo", "Raimondo", "0512105214", "12345678", "a.raimondo52@unisa.it", "uff01");
	
	static Studente s = new Studente("Alfredo", "Raimondo", "0512105215", "12345678", "a.raimondo12@studenti.unisa.it");
	
	static Calendar calendar = Calendar.getInstance();
	
	
	static Ricevimento ric;
	
	static RicevimentoModel rm = new RicevimentoModel();
	
	static Ricevimento secRic;
	
	static LinkedList<Ricevimento> lista;
	
	@BeforeAll
	static public void beforeEachTestCase1() throws SQLException{
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		calendar.set(2030, 11, 31, 59, 59, 59);
		
		Date primo = new Date();
		
		calendar.set(2031, 11, 31, 59, 59, 59);
		
		Date secondo = new Date();
		
		ric = new Ricevimento("acc",primo,secondo,2,"0512105214","0512105215");
		rm.doSave(ric, calendar);
		
		 lista = (LinkedList<Ricevimento>) rm.doRetrieveAllByDoc("0512105214");
		
		secRic = lista.get(0);
		
	}
	
	@AfterAll
	static public void afterall() throws SQLException{
		
		
		for(Ricevimento r : lista){
			
			rm.doDelete(r.getId());
		}
		
	
		
		
		
	}

	@Test
	void tc1() throws SQLException {
		
		rm.changeState(secRic.getId(), "no");
		
		Ricevimento r = ((LinkedList<Ricevimento>) rm.doRetrieveAllByDoc("0512105214")).get(0);
		
		System.out.println(r.getStato());
		
		assertEquals(r.getStato(),"no");
	}
	
	@Test
	void tc2() throws SQLException {
		
		LinkedList<Ricevimento> ricevimenti = (LinkedList<Ricevimento>) rm.doRetrieveAllByStudent(s);
		
		
		
		assertEquals(ricevimenti.get(0).getId(),secRic.getId());
	}
	
	@Test
	void tc3() throws SQLException {
		
		Ricevimento r = rm.doRetrieveByKey(secRic.getId());		
		
		
		assertEquals(r.getId(),secRic.getId());
	}
	
	@Test
	void tc4() throws SQLException {
		
		Ricevimento r = new Ricevimento("acc",new Date(),new Date(),2,"0512105214","0512105215");
		rm.doSave(r, calendar.getInstance());
		LinkedList<Ricevimento> ricevimenti = (LinkedList<Ricevimento>) rm.doRetrieveAllByDoc("0512105214");
		
		
		assertEquals(ricevimenti.size(),1);
	}
	
	@Test
	void tc5() throws SQLException {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		calendar.set(2031, 11, 31, 59, 59, 59);
		
		LinkedList<Ricevimento> ricevimenti = (LinkedList<Ricevimento>) rm.doRetrieveAllByDate(calendar);
		
		assertEquals(ricevimenti.size(),1);
	}
	
	@Test
	void tc6() throws SQLException {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		calendar.set(2031, 11, 31, 59, 59, 59);
		
		LinkedList<Ricevimento> ricevimenti = (LinkedList<Ricevimento>) rm.doRetrieveTodayByDocente("0512105214");
		
		assertEquals(ricevimenti.size(),0);
	}
	
	@Test
	void tc7() throws SQLException {
		
		LinkedList<Ricevimento> ricevimenti = (LinkedList<Ricevimento>) rm.doRetrieveAll(); 
		System.out.println("SSSS"+ricevimenti.size());
		int i=0;
		for(Ricevimento r : ricevimenti){
			if(!r.getMatDocente().equals("0512105214")){
				ricevimenti.remove(r);
			}
		}
		
	
		assertEquals(ricevimenti.size(),1);
	}
	
	
	

}
