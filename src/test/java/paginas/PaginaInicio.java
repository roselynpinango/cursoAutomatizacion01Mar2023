package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Atributos => Elementos Web
	@FindBy(partialLinkText="Sign")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		// Inicializar todos los elementos web que esten definidos en esta pagina
		PageFactory.initElements(driver, this); 
	}
	
	// Métodos => Acciones sobre los Elementos Web
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
