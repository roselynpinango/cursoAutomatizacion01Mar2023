package Edit.EducacionIT_61772;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowsing {
	String url = "http://automationpractice.pl/index.php";
	WebDriver driver;
	
	@Parameters("navegador")
	@BeforeTest
	public void setUp(String navegador) {
		// De acuerdo al navegador, se inicializa el driver
		if (navegador.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (navegador.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
	    
		driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		btnBuscar.click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
