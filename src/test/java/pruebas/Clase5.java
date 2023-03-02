package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContacUs;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase5 {
	String url = "http://automationpractice.pl/index.php";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirPassword("123eq23rrq");
		login.escribirEmail("correo1@gmail.com");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@Test
	public void irAContactanos() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
		
		PaginaContacUs contact = new PaginaContacUs(driver);
		contact.seleccionarSubject("Webmaster");
		contact.escribirEmail("correo@gmail.com");
		contact.escribirOrden("56416A");
		contact.adjuntarArchivo("C:\\addIntegerData.txt");
		contact.escribirMensaje("mensaje del formulario");
		contact.hacerClicEnEnviar();
	}
	
	@Test
	public void irAContactanosCamposVacios() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
		
		PaginaContacUs contact = new PaginaContacUs(driver);
		contact.hacerClicEnEnviar();
	}
	
	@Test
	public void irAContactanosArchivoInexistente() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
		
		PaginaContacUs contact = new PaginaContacUs(driver);
		contact.seleccionarSubject("Webmaster");
		contact.escribirEmail("correo@gmail.com");
		contact.escribirOrden("56416A");
		contact.adjuntarArchivo("C:\\archivoInexistente.txt");
		contact.escribirMensaje("mensaje del formulario");
		contact.hacerClicEnEnviar();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
