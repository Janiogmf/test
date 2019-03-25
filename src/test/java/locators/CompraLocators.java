package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompraLocators {
	protected WebElement total_product;
	protected WebElement total_shipping;
	protected WebElement total_price;
	
//	@FindBy(css = "cheque")
	protected WebElement HOOK_PAYMENT;
	
	@FindBy(css = ".alert.alert-success")
	protected WebElement msgSucessoCompra;
	
	@FindBy(css = "button[class='button btn btn-default button-medium']")
	protected WebElement btnFinalizar;
}
