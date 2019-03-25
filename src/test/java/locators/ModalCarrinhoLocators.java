package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalCarrinhoLocators {
	@FindBy(css = ".btn.btn-default.button.button-medium")
	protected WebElement botaoProcederCheckout;
	
	@FindBy(css = ".cart_item.last_item.first_item.address_0.odd")
	protected WebElement nomeProduto;
	
	protected WebElement total_product;
	
	@FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium")
	protected WebElement botaoProcederCheckoutResumo;
}

