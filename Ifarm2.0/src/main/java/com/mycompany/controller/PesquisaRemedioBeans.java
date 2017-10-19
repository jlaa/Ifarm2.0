/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Aplicacao;
import com.mycompany.model.Remedio;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author joao_dev
 */
@Named(value = "pesquisaRemedio")
@RequestScoped
public class PesquisaRemedioBeans {
    
    @EJB
    private Aplicacao aplicacao;
    
    private List<Remedio> remedios;
    
    private String nomeRemedio;
    /**
     * Creates a new instance of PesquisaRemedioBeans
     */
    public PesquisaRemedioBeans() {
    }
    
    public void pesquisaRemedio(){
        remedios = aplicacao.PesquisaRemedio(nomeRemedio);
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }
    
}
