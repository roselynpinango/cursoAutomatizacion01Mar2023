package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase6 {
	String url = "http://automationpractice.pl/index.php";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio  = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosLoginExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT-61772\\Datos\\Datos_Login_01032023.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() {
		Object[][] datos = new Object[5][2];
		
		datos[0][0] = "abc@mail.com";
		datos[0][1] = "43r3wt43ts";
		
		datos[1][0] = "def@mail.com";
		datos[1][1] = "463w4et4e";
		
		datos[2][0] = "ghi@mail.com";
		datos[2][1] = "34tetetdses";
		
		datos[3][0] = "jkl@mail.com";
		datos[3][1] = "3tests";
		
		datos[4][0] = "mno@mail.com";
		datos[4][1] = "67u76y6t";
		
		return datos;
	}
}
