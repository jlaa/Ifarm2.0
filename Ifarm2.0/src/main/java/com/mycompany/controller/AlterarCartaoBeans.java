/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Aplicacao;
import com.mycompany.model.CartaoDeCredito;
import com.mycompany.model.Cliente;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author LucasPC
 */
@Named(value = "alterarCartaoBeans")
@RequestScoped
public class AlterarCartaoBeans implements Serializable {

    @EJB
    private Aplicacao aplicacao;

    private String dataExpiracao;

    private String numeroCartao;

    private String bandeira;

    private List<CartaoDeCredito> cartoes;

    /**
     * Creates a new instance of UpdateCartaoBeans
     */
    public AlterarCartaoBeans() {

    }

    public String AlterarCartao(String numeroCartao) {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getUsuarioLogado();
        CartaoDeCredito cartao;
        cartao = aplicacao.PesquisaCartao(numeroCartao);
        //cartao=aplicacao.PesquisaCartao(id);
        Calendar cal = null;
//        try {
//            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//            String dataCerta = formatter.format(dataExpiracaoString);
//            dataExpiracaoString = (Date) formatter.parse(dataCerta);
//            cal = Calendar.getInstance();
//            cal.setTime(dataExpiracaoString);
//        } catch (ParseException e) {
//            System.out.println("Exception :" + e);
//        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse(dataExpiracao));
        } catch (ParseException e) {

        }
        cartao.setDataExpiracao(cal);
        List<CartaoDeCredito> cartaos;
        cartaos = cliente.getCartaos();
        cartaos.add(cartao);
        boolean alterou = aplicacao.AlterarCartao(cartao);
        if (alterou) {
            return "Logado.xhtml?faces-redirect=true";
        }
        return "#";

    }

    public void RemoverCartao(String numeroCartao) {
        CartaoDeCredito cartao = aplicacao.PesquisaCartao(numeroCartao);
        aplicacao.DeletaCartao(cartao);
    }

    public String getDataExpiracao() {       
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public List<CartaoDeCredito> getCartoes() {
        Cliente cliente = (Cliente) SingletonSession.getInstance().getUsuarioLogado();
        List<CartaoDeCredito> listCartao = aplicacao.listarCartao(cliente.getLogin());
        cartoes = listCartao;
        return cartoes;
    }

    public void setCartoes(List<CartaoDeCredito> cartoes) {
        this.cartoes = cartoes;
    }

}
