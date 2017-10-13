/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Aplicacao;
import com.mycompany.model.CartaoDeCredito;
import com.mycompany.model.Cliente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author LucasPC
 */
@Named(value = "registerCartao")
@RequestScoped
public class RegisterCartaoBeans {

    @EJB
    private Aplicacao aplicacao;

    private Long id_cartao;

    private String bandeira;

    private String numeroCartao;

    private String dataExpiracao;
    
    private String codigo;

    private List<CartaoDeCredito> cartao;

    /**
     * Creates a new instance of RegisterCartao
     */
    public RegisterCartaoBeans() {
    }

    public Long getId_cartao() {
        return id_cartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public List<CartaoDeCredito> getCartao() {
        return cartao;
    }

    public void setCartao(List<CartaoDeCredito> cartao) {
        this.cartao = cartao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public String RegisterCartao() {

        CartaoDeCredito cartaoNovo = new CartaoDeCredito();
        cartaoNovo.setBandeira(bandeira);
        Calendar cal = null;
//        try {
//            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//            String dataCerta = formatter.format(dataExpiracao);
//            dataExpiracao = (Date) formatter.parse(dataCerta);
//            cal = Calendar.getInstance();
//            cal.setTime(dataExpiracao);
//        } catch (ParseException e) {
//            System.out.println("Exception :" + e);
//        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            cal = Calendar.getInstance();
            cal.setTime(sdf.parse(dataExpiracao));
        } catch (ParseException e) {
            
        }
        cartaoNovo.setDataExpiracao(cal);
        cartaoNovo.setNumero_cartao(numeroCartao);
        cartaoNovo.setCodigo(codigo);
        Cliente cliente = (Cliente) SingletonSession.getInstance().getUsuarioLogado();
        cartaoNovo.setCliente(cliente);
        cartao = cliente.getCartaos();
        cartao.add(cartaoNovo);
        cliente.setCartaos(cartao);
        aplicacao.InserirCartao(cartaoNovo);
        return "Logado.xhtml?faces-redirect=true";
    }

}
