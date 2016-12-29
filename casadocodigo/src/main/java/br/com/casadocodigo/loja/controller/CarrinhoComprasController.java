package br.com.casadocodigo.loja.controller;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.CarrinhoItem;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author regis
 */
@Controller
@RequestMapping("/carrinho")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    ProdutoDAO produtoDao;
    
    @Autowired
    CarrinhoCompras carrinhoCompras;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipo) {

        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        CarrinhoItem carrinhoItem = create(produtoId, tipo);
        carrinhoCompras.add(carrinhoItem);

        return modelAndView;
    }

    private CarrinhoItem create(Integer produtoId, TipoPreco tipoPreco) {

        Produto produto = produtoDao.find(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);

        return carrinhoItem;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView itens(){
        return new ModelAndView("carrinhos/itens");
    }

}
