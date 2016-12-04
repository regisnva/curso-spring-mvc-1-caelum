/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.controller;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import br.com.casadocodigo.loja.validation.ProductValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author regis
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDao;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new ProductValidator());
    }
    
    @RequestMapping("/form")
    public ModelAndView form(Produto produto){
        
        ModelAndView modelView = new ModelAndView("produtos/form", "produto", produto);
        
        modelView.addObject("tipos", TipoPreco.values());
        
        return modelView;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAtt){
        
        if(result.hasErrors()){
            return form(produto);
        }
        
        produtoDao.save(produto);
        
        redirectAtt.addFlashAttribute("sucesso", "Produto Cadastrado com Sucesso!");
        
        return new ModelAndView("redirect:produtos");
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(){
        
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        
        modelAndView.addObject("produtos", produtoDao.list());
        
        return modelAndView;    
    }
    
}
