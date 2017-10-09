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
@Named(value = "farmUpdate")
@RequestScoped
public class FarmUpdateBeans {

    @EJB
    private Aplicacao aplicacao;
    
    private String nome;
    
    private String estado;
   
    private String rua;
 
    private String numero;

    private String cidade;
   
    private String bairro;
    
    private String cep;   
    /**
     * Creates a new instance of FarmUpdateBeans
     */
    public FarmUpdateBeans() {
    }
    
    public void atualizarFarmacia(String nome, String novoNome,String rua,String numero,String bairro,String cidade,String estado,String cep){
        Farmacia farmacia = aplicacao.PesquisaFarmacia(nome);
        farmacia.CadastrarFarmacia(novoNome);
        farmacia.InserirEndereco(rua, numero, bairro, cidade, estado, cep);
        aplicacao.AtualizaFarmacia(farmacia);
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
        return bairro;
    }

    public void setBairo(String bairo) {
        this.bairro = bairo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
