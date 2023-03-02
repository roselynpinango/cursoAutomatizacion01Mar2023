package Edit.EducacionIT_61772;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Clase4 {
	String url = "http://automationpractice.pl/index.php";
	WebDriver driver;
	File pantalla;
	String rutaEvidencias = "..\\EducacionIT-61772\\Evidencias\\";
	String nombreDocumento = "Evidencias AutomationPractice.docx";
	String nombreImagenGenerica = "img.jpg";
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 Ir a contactanos",priority=100)
	public void enviarFormularioContacto() throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Pantalla
		CapturaEvidencia.escribirTituloEnDocumento(
											rutaEvidencias + nombreDocumento, 
											"Evidencias de Prueba - AutomationPractice", 
											18);	
		
		CapturaEvidencia.capturarPantallaEnDocumento(
											driver, 
											rutaEvidencias + nombreImagenGenerica, 
											rutaEvidencias + nombreDocumento, 
											"Paso 1: Pantalla Principal");
		
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + nombreImagenGenerica, 
				rutaEvidencias + nombreDocumento, 
				"Paso 2: Luego de hacer clic en Contact us");
		
		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.name("from"));
		txtEmail.sendKeys("correo0102@mail.com");
		
		WebElement txtOrder = driver.findElement(By.cssSelector("#id_order"));
		txtOrder.sendKeys("123ABC");
		
		WebElement filAttached = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		filAttached.sendKeys("C:\\addIntegerData.txt");
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Mensaje de Contacto para la tienda");
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + nombreImagenGenerica, 
				rutaEvidencias + nombreDocumento, 
				"Paso 3: Luego de completar el formulario");
		
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		
		// Captura de Pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				rutaEvidencias + nombreImagenGenerica, 
				rutaEvidencias + nombreDocumento, 
				"Paso 4: Luego de enviar el formulario");
	}
	
	@Test(description="CP02 Buscar palabra",priority=200)
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "01_pantallaInicial.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "02_palabraABuscar.jpg"));
		
		WebElement btnBuscar = driver.findElement(By.name("submit_search"));
		btnBuscar.click();
		
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencias + "03_resultadoFinal.jpg"));
		
		// Comprobar que la URL cambia a http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=
		String urlEsperada = "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl(); // URL actual
		
		Assert.assertEquals(urlActual, urlEsperada);
		
		// Comprobar que el título cambia a Search - My Store
		String tituloEsperado = "Search - My Store";
		String tituloActual = driver.getTitle(); // Titulo Actual
		
		Assert.assertEquals(tituloEsperado, tituloActual, "ERR-001: El título no es el esperado");
		
		/*
		String variable = null;
		
		Assert.assertNotEquals("", "");
		Assert.assertTrue(3 == 3);
		Assert.assertFalse(false);
		Assert.assertNull(variable);
		Assert.assertNotNull(tituloActual);
		*/
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
