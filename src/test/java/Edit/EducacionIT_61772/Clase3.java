package Edit.EducacionIT_61772;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clase3 {
	String url = "http://automationpractice.pl/index.php";
	
	@Test
	public void registrarUsuario() {
		// Paso 1 : Abrir el navegador en la página a probar
		WebDriver navegador = new ChromeDriver();
		navegador.navigate().to(url);  // Es igual a navegador.get(url);
		navegador.manage().window().maximize(); // Maximiza la ventana
		
		// Paso 2 : Hacer clic en 'Sign in'
		WebElement lnkSignIn = navegador.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		// Paso 3 : Escribir el correo y hacer clic en el botón
		String email = "correo" + Math.random() + "@mail.com";
		
		WebElement txtEmail = navegador.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys(email);
		
		WebElement btnCreate = navegador.findElement(By.id("SubmitCreate"));
		btnCreate.click();
		
		// Hay que agregar una espera
		WebDriverWait espera = new WebDriverWait(navegador, Duration.ofSeconds(15));
		espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// Paso 4 : Completar el formulario y hacer clic en el botón
		WebElement radMr = navegador.findElement(By.id("id_gender1"));
		radMr.click(); // Radio button Mr.
		
		WebElement txtFirstname = navegador.findElement(By.name("customer_firstname"));
		txtFirstname.sendKeys("Arturo");
		
		WebElement txtLastname = navegador.findElement(By.xpath("//input[@id='customer_lastname']"));
		txtLastname.sendKeys("Gonzalez");
		
		WebElement txtPassword = navegador.findElement(By.cssSelector("#passwd"));
		txtPassword.sendKeys("1q2w3e4r5");
		
		Select selDays = new Select(navegador.findElement(By.id("days")));
		selDays.selectByValue("18");
		
		Select selMonths = new Select(navegador.findElement(By.name("months")));
		selMonths.selectByIndex(6);
		
		Select selYears = new Select(navegador.findElement(By.xpath("//select[@id='years']")));
		selYears.selectByVisibleText("1993  ");
		
		WebElement chkNews = navegador.findElement(By.cssSelector("#newsletter"));
		chkNews.click(); // Checkbox Newsletter
		
		WebElement chkOptin = navegador.findElement(By.id("optin"));
		chkOptin.click();
		
		WebElement btnRegister = navegador.findElement(By.name("submitAccount"));
		btnRegister.click();
	}
}
