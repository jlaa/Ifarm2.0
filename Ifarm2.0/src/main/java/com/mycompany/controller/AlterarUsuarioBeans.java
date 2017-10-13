/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Aplicacao;
import com.mycompany.model.Cliente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author LucasPC
 */
@Named(value = "alterarUsuario")
@RequestScoped
public class AlterarUsuarioBeans implements Serializable {

    @EJB
    private Aplicacao aplicacao;

    private String telefone;

    private String estado;

    private String rua;

    private String numero;

    private String cidade;

    private String bairo;

    private String cep;

    private String nome;   
    

    public String getTelefone() {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getTelefone();
        }
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {

        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getEndereco().getEstado();
        }
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {

        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getEndereco().getRua();
        }
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {

        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getEndereco().getNumero();
        }
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {

        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getEndereco().getCidade();
        }
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairo() {

        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getEndereco().getBairro();
        }
        return this.bairo;
    }

    public void setBairo(String bairo) {
        this.bairo = bairo;
    }

    public String getCep() {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getEndereco().getCep();
        }
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    } 

    public String getNome() {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {
            return cliente.getNome();
        }
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String alterarUsuario()
    {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");        
        cliente.AdicionarEndereco(rua, numero, bairo, cidade, estado,cep);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        aplicacao.AtualizaCliente(cliente);
        return "Logado.xhtml?faces-redirect=true";
    }

}
