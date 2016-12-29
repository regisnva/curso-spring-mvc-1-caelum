/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author regis
 */
@Embeddable
public class Preco {
    
    private BigDecimal valor;
    private TipoPreco tipo;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Preco other = (Preco) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }
}
