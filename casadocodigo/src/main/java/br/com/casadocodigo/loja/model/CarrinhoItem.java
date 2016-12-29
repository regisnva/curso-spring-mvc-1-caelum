package br.com.casadocodigo.loja.model;

/**
 *
 * @author regis
 */
public class CarrinhoItem {

    private Produto produto;
    private TipoPreco tipoPreco;

    public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
        this.produto = produto;
        this.tipoPreco = tipoPreco;
    }

    public Produto getProduto() {
        return produto;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }
}
