/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Aplicacao;
import com.mycompany.model.Farmacia;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author joao_dev
 */
@Named(value = "farmDelete")
@RequestScoped
public class FarmDeleteBeans {

    @EJB
    private Aplicacao aplicacao;
    
    private String nome;
    /**
     * Creates a new instance of FarmDeleteBeans
     */
    public FarmDeleteBeans() {
    }
    
    public void DeleteFarmacia(){
        Farmacia farmacia = aplicacao.PesquisaFarmacia(nome);
        aplicacao.DeletaFarmacia(farmacia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
