package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import locators.ModalCarrinhoLocators;
import system.TestRule;
import system.Utils;

public class ModalCarrinhoPage extends ModalCarrinhoLocators {
	//Captura e valida produto adicionado na cesta
	public ModalCarrinhoPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void clicarProceder() throws InterruptedException {
		Thread.sleep(1500);
		botaoProcederCheckout.click();
	}
	public boolean verificarInclusao() throws InterruptedException {		
		String strProdutoResumo = nomeProduto.findElement(By.tagName("p")).getText();		
		if(DetalhesProdutoPage.strProduto.contains(strProdutoResumo) && DetalhesProdutoPage.strValor.contains(total_product.getText())) {
			return true;
		}else {
			return false;
		}		
	}
	public void clicarProcederResumo() {
		Utils.waitElementClicavel(botaoProcederCheckoutResumo);
		botaoProcederCheckoutResumo.click();
	}	
}
