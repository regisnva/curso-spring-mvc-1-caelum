/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controller;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author regis
 */
@Controller
public class ProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDao;
    
    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }
    
    @RequestMapping("/produtos")
    public String save(Produto produto){
        produtoDao.save(produto);
        
        System.out.println(produto.toString());
        
        return "produtos/ok";
    }
    
}
