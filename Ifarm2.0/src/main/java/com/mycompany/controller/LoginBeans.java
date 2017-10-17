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
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author LucasPC
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBeans implements Serializable {

    @EJB
    private Aplicacao aplicacao;

    private String senha;

    private String email;

    private FacesContext facesContext;

    /**
     * Creates a new instance of LoginBeans
     */
    public LoginBeans() {

    }

    public String autenticacao() {
        Cliente cliente;
        facesContext = FacesContext.getCurrentInstance();

        cliente = aplicacao.LoginUuario(email, senha);
        if (cliente != null) {
            SingletonSession.getInstance().setAttribute("clienteLogado", cliente);
            facesContext.getExternalContext().getSession(true);
            return "Logado?faces-redirect=true";
        }
        return "LoginError?faces-redirect=true";
    }

    public String retornaCliente() {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getAttribute("clienteLogado");
        if (cliente != null) {

            String clienteAtual = cliente.getLogin();

            if (clienteAtual != null) {
                return clienteAtual;
            }

        }
        return "";
    }

    public String logout() throws ServletException {
        SingletonSession.getInstance().encerrarSessao();
        return "Index.xhtml?faces-redirect=true";
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}