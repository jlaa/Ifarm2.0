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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author LucasPC
 */
@Named(value = "register")
@RequestScoped
public class RegisterBeans implements Serializable {

    @EJB
    private Aplicacao aplicacao;

    private String login;

    private String senha;

    private String confirmarSenha;

    private String primeiroNome;

    private String segundoNome;

    private String sexo;

    private String email;

    private String ocupacao;

    private String telefone;

    private String estado;

    private String rua;

    private String numero;

    private String cidade;

    private String bairo;

    private String cep;

    private String nome = "";

    public RegisterBeans() {
    }

    public String cadastrarCliente() {
        Cliente cliente = new Cliente();
        if (senha.equals(confirmarSenha)) {
            cliente.CadastrarCliente(email, senha, login);
            cliente.AdicionarEndereco(rua, numero, bairo, cidade, estado, cep);
            this.nome = primeiroNome + " " + segundoNome;
            cliente.adicionarInformaçõesCliente(nome, telefone, ocupacao, sexo);
            if(aplicacao.CadastrarCliente(cliente))
            {
                return "Index.xhtml";
            }
            
            
        }
        return "Register.xhtml";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
    }

    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
