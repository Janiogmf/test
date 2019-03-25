#language: pt
#Author: janiogouveia@hotmail.com

@CompraProduto
Funcionalidade: Compra produto
  Automação de simulação de compra

  @tag1
  Cenario: Fluxo Compra Produto
    Dado escolher um produto qualquer na loja.
    E Adicione o produto escolhido ao carrinho.
    Entao Prosseguir para o checkout.
    Entao Valide se o produto foi corretamente adicionado ao carrinho e prossiga caso esteja tudo certo.
    E Realize o cadastro do cliente preenchendo todos os campos obrigatorios do formulario.
    Entao Valide se o endereco esta correto e prossiga.
    E Aceite os termos de servico e prossiga.
    Entao Valide o valor total da compra.
    E Selecione um metodo de pagamento e prossiga.
    E Confirme a compra e valide se foi finalizada com sucesso.