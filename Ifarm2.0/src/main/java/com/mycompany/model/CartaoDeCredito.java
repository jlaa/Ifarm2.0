/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "CARTAO_TABLE")
@Access(AccessType.FIELD)
public class CartaoDeCredito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTAO", nullable = false)
    private long id;

    @NotBlank
    @Column(name = "TXT_BANDEIRA", nullable = false)
    private String bandeira;

    @CreditCardNumber
    @Column(name = "TXT_NUMERO", nullable = false, unique = true)
    private String numero_cartao;

    @NotBlank
    @Column(name = "TXT_CODIGO", nullable = false)
    private String codigo;

    @Future
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EXPIRACAO", nullable = false)
    private Calendar dataExpiracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARTAO_CLIENTE", referencedColumnName = "ID_USUARIO")
    private Cliente cliente;

    public CartaoDeCredito() {

    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataExpiracao() {
        return dataExpiracao;
    }
    

    public void setDataExpiracao(Calendar dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

}
