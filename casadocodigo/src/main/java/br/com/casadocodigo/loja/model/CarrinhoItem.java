package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;

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
    
    public BigDecimal getPreco(){
        return produto.precoPara(tipoPreco);
    }

    public BigDecimal getTotal(int quantidade) {
        return this.getPreco().multiply(new BigDecimal(quantidade));
    }
}
