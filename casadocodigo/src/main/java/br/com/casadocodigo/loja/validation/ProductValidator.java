/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.model.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author regis
 */
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        
        return Produto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) o;
        
        if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "filed.required");
        }
    }
}
