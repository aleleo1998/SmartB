package SystemTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Controller.LoginServlet;
import Model.Docente;
import Model.DocenteModel;
import Model.Studente;
import Model.StudenteModel;

class TestRegistrazioneStudente {

	 private WebDriver driver;
	 private String baseUrl;
	 private boolean acceptNextAlert = true;
	 private StringBuffer verificationErrors = new StringBuffer();
	 private StudenteModel sm;
	 private Studente s;
	 
	 LoginServlet myServlet;

		@Mock
		HttpServletRequest request;
		
		@Mock
		HttpServletResponse response;
		
		@Mock
		HttpSession session;
	 
	 @Test
	  public void testRegistrazioneStudente() throws Exception {
		 
		sm = new StudenteModel();

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\alfre\\Desktop\\chromedriver.exe");
		
		driver = new ChromeDriver();	
		String baseUrl="http://localhost:8080/SmartBooking/jsp/RegView.jsp";
		driver.get(baseUrl);
		WebElement nome = driver.findElement(By.name("nome"));
		WebElement cognome = driver.findElement(By.name("cognome"));
		WebElement matricola = driver.findElement(By.name("matricola"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement confermaPassword = driver.findElement(By.name("confermaPassword"));

		WebElement submitReg = driver.findElement(By.id("buttonRegistrazione"));
	
		nome.sendKeys("StudNome");
		cognome.sendKeys("StudCognome");
		matricola.sendKeys("0512105103");
		email.sendKeys("stud.studente2@studenti.unisa.it");
		password.sendKeys("12345678");
		confermaPassword.sendKeys("12345678");
		submitReg.click();
		
		Thread.sleep(2000);
		
		
		
		
		Studente s = sm.doRetrieveByKey("0512105103");
		System.out.println("MATRICLOA: ");
		assertEquals(s.getMatricola(),"0512105103");
	    sm.doDelete(s.getMatricola());

	    driver.quit();

	  }
}
