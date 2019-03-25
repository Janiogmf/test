package pages;

import org.openqa.selenium.support.PageFactory;
import locators.DetalhesProdutoLocators;
import system.TestRule;

public class DetalhesProdutoPage extends DetalhesProdutoLocators {
	public static String strProduto = "";
	public static String strValor = "";
	// somente clica e adicionar no carrinho e captura nome e valor produto
	public DetalhesProdutoPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	public void adicionarCarrinho() throws InterruptedException {
		add_to_cart.click();
		Thread.sleep(1000);
		strProduto = layer_cart_product_title.getText();
		strValor = layer_cart_product_price.getText();
	}
}

