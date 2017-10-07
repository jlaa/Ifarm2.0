/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name="FARMACIA_TABLE")
@Access(AccessType.FIELD)
public class Farmacia implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FARMACIA", nullable = false)
    private long id_farmacia;
    
    @NotBlank
    @Size(max = 30)
    @Column(name = "TXT_NOME_FARMACIA", nullable = false)
    private String nome;  
    
    @Valid
    @Embedded
    private Endereco endereco;   
    
    @Valid 
    @ManyToMany(mappedBy = "farmacia")
    private List<Cliente> cliente;
    
    @Valid
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_FARMACIA_REMEDIOS", joinColumns = {
        @JoinColumn(name = "ID_FARMACIA")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_REMEDIO")
    })
    private List<Remedio> remediosFarmacia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Remedio> getRemedios() {
        return remediosFarmacia;
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remediosFarmacia = remedios;
    }
    
    public void CadastrarFarmacia(String nome)
    {
        this.nome = nome;
    }
    
    public void InserirEndereco(String rua,String numero,String bairro,String cidade,String estado,String cep)
    {
        this.endereco=new Endereco();
        this.getEndereco().CadastrarEndereco(rua, numero, bairro,cidade,estado,cep);
    }
    
    
}
