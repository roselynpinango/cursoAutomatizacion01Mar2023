package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContacUs {
	// Atributos
	@FindBy(id="id_contact")
	WebElement selSubject;
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='id_order']")
	WebElement txtOrder;
	
	@FindBy(css="#fileUpload")
	WebElement filAttached;
	
	@FindBy(tagName="textarea")
	WebElement txtMessage;
	
	@FindBy(name="submitMessage")
	WebElement btnSend;
	
	// Constructor
	public PaginaContacUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void seleccionarSubject(String seleccion) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(seleccion);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrden(String orden) {
		txtOrder.sendKeys(orden);
	}
	
	public void adjuntarArchivo(String ruta) {
		filAttached.sendKeys(ruta);
	}
	
	public void escribirMensaje(String mensaje) {
		txtMessage.sendKeys(mensaje);
	}
	
	public void hacerClicEnEnviar() {
		btnSend.click();
	}
}
