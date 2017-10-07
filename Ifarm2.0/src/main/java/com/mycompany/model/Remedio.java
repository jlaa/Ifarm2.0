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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author LucasPC
 */

@Entity
@Table(name="REMEDIO_TABLE")
@Access(AccessType.FIELD)
public class Remedio implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_REMEDIO", nullable= false)
    private Long id;    
    
    @Column(name="TXT_PRECO", nullable= false)
    private double preco;
    
    @Column(name="TXT_NOME", nullable= false)
    private String nome;
    
    @Column(name= "TXT_QUANTIDADE", nullable= false)
    private long quantidade;
    
    @Column(name="TXT_FAIXA_ETARIA", nullable= false)
    private String faixaEtaria;
    
    @Column(name="TXT_DESCONTO")
    private Integer desconto;
        
    @Column(name="DT_VALIDADE", nullable= false)
    @Temporal(TemporalType.DATE)
    private Calendar dataValidade;    
    
    @Column(name="TXT_TIPO", nullable= false)
    private String tipo;
    
    @ManyToMany(mappedBy = "remediosFarmacia")
    private List<Farmacia> farmacia;
    
    @ManyToMany(mappedBy = "remediosCliente")
    private List<Cliente> clientes;

    public Remedio() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Farmacia> getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(List<Farmacia> farmacia) {
        this.farmacia = farmacia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
     public Remedio(String nome, double preco, String faixaEtaria, long quantidade, String tipo, Calendar dataValidade){
        this.nome= nome;
        this.preco= preco;
        this.faixaEtaria= faixaEtaria;
        this.quantidade= quantidade;
        this.tipo = tipo;
        this.dataValidade= dataValidade;
        
        
    }
    
    
}
