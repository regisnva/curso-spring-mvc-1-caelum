/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.dao;

import br.com.casadocodigo.loja.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author regis
 */
@Repository
@Transactional
public class ProdutoDAO {
    
    @PersistenceContext
    private EntityManager manager;
    
    public void save(Produto produto){
        manager.persist(produto);
    }
    
    public List<Produto> list(){
        return manager.createQuery("select p from Produto p").getResultList();
    }
    
}
