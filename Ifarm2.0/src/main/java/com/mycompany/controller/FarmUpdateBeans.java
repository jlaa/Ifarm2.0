/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Aplicacao;
import com.mycompany.model.Endereco;
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
    
    private String pesquisaNome;
    /**
     * Creates a new instance of FarmUpdateBeans
     */
    public FarmUpdateBeans() {
    }
    
    public void preencherFarmacia(){
        Farmacia farmacia = aplicacao.PesquisaFarmacia(pesquisaNome);
        Endereco endereco = farmacia.getEndereco();
        this.nome = farmacia.getNome();
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        
    }
    
    public String atualizarFarmacia(){
        Farmacia farmacia = aplicacao.PesquisaFarmacia(nome);
        farmacia.CadastrarFarmacia(nome);
        farmacia.InserirEndereco(rua, numero, bairro, cidade, estado, cep);
        aplicacao.AtualizaFarmacia(farmacia);
        
        return "gerenciaFarmacia";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPesquisaNome() {
        return pesquisaNome;
    }

    public void setPesquisaNome(String newNome) {
        this.pesquisaNome = newNome;
    }
    
}
