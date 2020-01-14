package SystemTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
import Model.Segreteria;
import Model.SegreteriaModel;

class TestRegistrazioneDocente {
	 private WebDriver driver;
	 private String baseUrl;
	 private boolean acceptNextAlert = true;
	 private StringBuffer verificationErrors = new StringBuffer();
	 private DocenteModel dm;
	 private Docente d;
	 
	 LoginServlet myServlet;

		@Mock
		HttpServletRequest request;
		
		@Mock
		HttpServletResponse response;
		
		@Mock
		HttpSession session;
	 
	 @Test
	  public void testRegistrazioneDocente() throws Exception {
		 
		dm = new DocenteModel();

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\alfre\\Desktop\\chromedriver.exe");
		
		driver = new ChromeDriver();	
		String baseUrl="http://localhost:8080/SmartBooking/jsp/Login.jsp";
		driver.get(baseUrl);
		WebElement emailLogin = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		
		
		emailLogin.sendKeys("d");
		password.sendKeys("d");
		
		WebElement submit = driver.findElement(By.id("loginButton"));
		submit.click(); //Effettua Login
		
		driver.getCurrentUrl();
		//if(driver.getCurrentUrl().contentEquals("http://localhost:8080/SmartBooking/jsp/ProfiloSegreteria.jsp")) {
			driver.get("http://localhost:8080/SmartBooking/jsp/RegDocente.jsp");

		//}
		
		driver.getCurrentUrl();
		if(driver.getCurrentUrl().contentEquals("http://localhost:8080/SmartBooking/jsp/RegDocente.jsp")) {
			WebElement nome = driver.findElement(By.name("nome"));
			WebElement cognome = driver.findElement(By.name("cognome"));
			WebElement matricola = driver.findElement(By.name("matricola"));
			WebElement email = driver.findElement(By.name("email"));
			WebElement ufficio = driver.findElement(By.name("ufficio"));
			WebElement submitReg = driver.findElement(By.id("buttonRegistrazione"));

			nome.sendKeys("Filomena");
			cognome.sendKeys("Ferrucci");
			matricola.sendKeys("0512100001");
			email.sendKeys("filomena.ferrucci@unisa.it");
			ufficio.sendKeys("ufficio01");
			submitReg.click(); //Effettua Login

		}
		
		Thread.sleep(2000);
		
		Docente d = dm.doRetrieveByKey("0512100001");
		  dm.doDelete(d.getMatricola());
		assertEquals(d.getMatricola(),"0512100001");
	  

	    driver.quit(); 

	  }
}
