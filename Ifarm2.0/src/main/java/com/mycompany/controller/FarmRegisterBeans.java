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
@Named(value = "farmRegister")
@RequestScoped
public class FarmRegisterBeans {
    
    @EJB
    private Aplicacao aplicacao;
    
    private String nome;
    
    private String estado;
   
    private String rua;
 
    private String numero;

    private String cidade;
   
    private String bairo;
    
    private String cep;   

    public FarmRegisterBeans() {
    }
    
    public void cadastrarFarmacia(){
        Farmacia farmacia = new Farmacia();
        farmacia.CadastrarFarmacia(nome);
        farmacia.InserirEndereco(rua, numero, bairo, cidade, estado, cep);
        aplicacao.CadastrarFarmacia(farmacia);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairo() {
        return bairo;
    }

    public void setBairo(String bairo) {
        this.bairo = bairo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
