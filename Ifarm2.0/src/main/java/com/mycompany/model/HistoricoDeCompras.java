/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "HISTORICO_DE_COMPRAS_TABLE")
@Access(AccessType.FIELD)
public class HistoricoDeCompras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    private Long id_historico;

    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "TXT_DATA_COMPRA")
    private Calendar dataCompra;

    @NotNull
    @Column(name = "TXT_VALOR_COMPRA")
    private Double valorCompra;

    @NotNull
    @Column(name = "TXT_QUANTIDADE")
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HISOTRICO_DONO", referencedColumnName = "ID_DONO")
    private DonoDeFarmacia dono;

    @OneToOne(mappedBy="historico",optional=false)   
    private Cliente cliente;

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public DonoDeFarmacia getDonos() {
        return dono;
    }

    public void setDonos(DonoDeFarmacia dono) {
        this.dono = dono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

}
