package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import locators.CompraLocators;
import system.TestRule;
import system.Utils;

public class CompraPage extends CompraLocators{
	public CompraPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	public boolean validarTotalCompra() {
		Double totalProd = Double.parseDouble(total_product.getText().replace("$", ""));
		Double totalEnvio = Double.parseDouble(total_shipping.getText().replace("$", ""));
		Double totalGeral = Double.parseDouble(total_price.getText().replace("$", ""));
		
		if(totalGeral == (totalProd+totalEnvio)) {
			return true;
		}else {
			return false;
		}	
	}
	public void selecionarPagamento() throws InterruptedException {
		WebElement clickFormaPgt = HOOK_PAYMENT.findElement(By.cssSelector("a[class='cheque']"));
		Utils.waitElementClicavel(clickFormaPgt);
		clickFormaPgt.click();
		Utils.waitElementClicavel(btnFinalizar);
		Actions hover = new Actions(TestRule.getDriver());
		hover.moveToElement(btnFinalizar).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) TestRule.getDriver(); 
		js.executeScript("arguments[0].click();", btnFinalizar);
	}
	public boolean validarMsgSucessoCompra() {
		String strsgSucessoCompra = msgSucessoCompra.getText();
		if(strsgSucessoCompra.contains("Your order on My Store is complete.")) {
			return true;
		}else {
			return false;
		}
	}
}

