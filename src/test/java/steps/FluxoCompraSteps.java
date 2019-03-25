package steps;

import org.junit.Assert;

import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import pages.CadastroPage;
import pages.CompraPage;
import pages.DetalhesProdutoPage;
import pages.ModalCarrinhoPage;
import pages.ProdutoPage;
import system.Utils;

public class FluxoCompraSteps {

	@Dado("^escolher um produto qualquer na loja\\.$")
	public void escolherProduto() throws InterruptedException {
		ProdutoPage produtoPage = new ProdutoPage();
		produtoPage.selecionarProduto();
		Utils.logPrint("Escolher produto");
	}

	@E("^Adicione o produto escolhido ao carrinho\\.$")
    public void adicionarProdutoCarrinho() throws InterruptedException {
		DetalhesProdutoPage detalhesProdutoPage = new DetalhesProdutoPage();
		detalhesProdutoPage.adicionarCarrinho();
		Utils.logPrint("Adicionar o produto no carrinho");
	}

	@Entao("^Prosseguir para o checkout\\.$")
	public void prosseguirCheckout() throws InterruptedException {
		ModalCarrinhoPage modalCarrinhoPage = new ModalCarrinhoPage();
		modalCarrinhoPage.clicarProceder();
	}

	@Entao("^Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo\\.$")
	public void validarCarrinho() throws InterruptedException { 
		ModalCarrinhoPage modalCarrinhoPage = new ModalCarrinhoPage();
		boolean blnverificarInclusao = modalCarrinhoPage.verificarInclusao();
		if (blnverificarInclusao) {
			Utils.logPass("Produto adicionado no carrinho com sucesso!");
		}else {
			Utils.logPass("Produto adicionado no carrinho com erro!");
		}
		Utils.logPrint("Validar Carrinho");
		
		try {
		Assert.assertTrue("Produto adicionado no carrinho com sucesso!", blnverificarInclusao );		
	    } catch (AssertionError error)  {
	    	modalCarrinhoPage.clicarProcederResumo();
	    	error.toString();
        }		
	}

	@E("^Realize o cadastro do cliente preenchendo todos os campos obrigatorios do formulario\\.$")
	public void cadastroCliente() throws InterruptedException { 
		CadastroPage cadastroPage = new CadastroPage();
		cadastroPage.newEmail();
		Utils.logPrint("Fazer novo cadastro");
		cadastroPage.cadastroNovo();
	}

	@Entao("^Valide se o endereco esta correto e prossiga\\.$")
	public void validarEndereco() {
		CadastroPage cadastroPage = new CadastroPage();
		boolean blnvalidarEndereco = cadastroPage.validarEndereco();
		if (blnvalidarEndereco) {
			Utils.logPass("Endereço validaddo com sucesso!");
		}else {
			Utils.logPass("Endereço validaddo com erro!");
		}
		Utils.logPrint("Validar Endereço");
		Assert.assertTrue("Endereço validaddo com sucesso!", blnvalidarEndereco );
		cadastroPage.btnCheckoutFinalizacao();
	}

	@E("^Aceite os termos de servico e prossiga\\.$")
	public void aceitarTermo() { 
		CadastroPage cadastroPage = new CadastroPage();
		cadastroPage.checkBoxTermo();
		Utils.logPrint("Termo de aceite");
		cadastroPage.btnProsseguir();
	}

	@Entao("^Valide o valor total da compra\\.$")
	public void validarCompra() {
		CompraPage compraPage = new CompraPage();
		boolean blnTotalCompra = compraPage.validarTotalCompra();
		if (blnTotalCompra) {
			Utils.logPass("Valor Total Validado com sucesso!");
		}else {
			Utils.logPass("Valor Total Validado com erro!");
		}
		Assert.assertTrue("Valor Total Validado!", blnTotalCompra );
		Utils.logPrint("Validar total de compra");
	}

	@E("^Selecione um metodo de pagamento e prossiga\\.$")
	public void selecionarMetodo() throws InterruptedException {
		CompraPage compraPage = new CompraPage();
		Utils.logPrint("Selecionar pagamento");
		compraPage.selecionarPagamento();
	}

	@E("^Confirme a compra e valide se foi finalizada com sucesso\\.$")
	public void confirmarCompra() {
		CompraPage compraPage = new CompraPage();
		boolean blncompraPage = compraPage.validarMsgSucessoCompra();
		if (blncompraPage) {
			Utils.logPass("Valor Total Validado com sucesso!");
		}else {
			Utils.logPass("Valor Total Validado com erro!");
		}
		Assert.assertTrue("Valor Total Validado!", blncompraPage );
		Utils.logPrint("Validar compra com sucesso!");
	}


}
