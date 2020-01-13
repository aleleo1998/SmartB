package SystemTesting;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class LoginTest {
	
	 private WebDriver driver;
	 private String baseUrl;
	 private boolean acceptNextAlert = true;
	 private StringBuffer verificationErrors = new StringBuffer();

	 @Before
	  public void setUp() throws Exception {
		
	 
	 }
	 
	 @Test
	  public void testLogin() throws Exception {
		 System.setProperty("webdriver.chrome.driver","/SmartBooking/WebContent/Driver/chromedriver");

		driver = new ChromeDriver();	  
		driver.get("http://localhost:8080/SmartBooking/jsp/Login.jsp");
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));

		email.sendKeys("ff.ferrucci@unisa.it");
		password.sendKeys("123");
		
		WebElement submit = driver.findElement(By.id("loginButton"));
		submit.click();
		
	    /*
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("ff.ferruci@unisa.it");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("123");
	    
	    driver.findElement(By.id("loginButton")).click(); */
	    /*driver.findElement(By.xpath(
	        "(.//*[normalize-space(text()) and normalize-space(.)='Login'])[3]/following::button[1]"))
	        .click(); */
	    
	    
	  }
	 
	 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	 
	 

}
