/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.conf;

import br.com.casadocodigo.loja.controller.HomeController;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author regis
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDAO.class })
public class AppWebConfiguration {
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
    
    @Bean
    public MessageSource messageSource(){
        
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        
        bundleMessageSource.setBasename("/WEB-INF/message");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setCacheSeconds(1);
        
        return bundleMessageSource;
        
    }
    
    @Bean
    public FormattingConversionService mvcConversionService(){
        
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
        
        dateFormatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
        dateFormatterRegistrar.registerFormatters(conversionService);
        
        return conversionService;
        
    }
    
}
