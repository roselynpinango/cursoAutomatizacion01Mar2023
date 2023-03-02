package Edit.EducacionIT_61772;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2 {
	// Variables
	String url = "http://automationpractice.pl/index.php";
	
	/**
	 * Método de Prueba
	 * Hacer una búsqueda en AutomationPractice.pl
	 */
	@Test
	public void hacerBusquedaEnChrome() {
		// Paso 1: Configurar el navegador a utilizar
		WebDriver navegador = new ChromeDriver(); 
		
		// Paso 2: Abrir la página 
		navegador.get(url);
		
		// Paso 3: Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // Escribe en el campo de texto
		
		// Paso 4: Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionamos ENTER
		
		// Paso 5: Cerrar el navegador
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		// Paso 1: Configurar el navegador a utilizar
		WebDriver navegador = new FirefoxDriver(); 
		
		// Paso 2: Abrir la página 
		navegador.get(url);
		
		// Paso 3: Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // Escribe en el campo de texto
		
		// Paso 4: Hacer la búsqueda
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionamos ENTER
		
		// Paso 5: Cerrar el navegador
	}
}
