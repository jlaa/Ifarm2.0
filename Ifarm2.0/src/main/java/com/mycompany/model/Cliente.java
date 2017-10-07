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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author LucasPC
 */
@Entity
@Table(name = "CLIENTE_TABLE")
@Access(AccessType.FIELD)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    private long id;

    @NotBlank
    @Size(max = 30)
    @Column(name = "TXT_NOME", nullable = false)
    private String nome;

    @NotBlank
    @Size(max = 30)
    @Column(name = "TXT_OCUPACAO", nullable = false)
    private String ocupacao;

    @NotBlank
    @Size(max = 15)
    @Column(name = "TXT_SEXO", nullable = false)
    private String sexo;

    @NotBlank
    @Size(min = 6)
    @Column(name = "TXT_SENHA", nullable = false)
    private String senha;

    @NotNull
    @Email
    @Column(name = "TXT_EMAIL", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "TXT_LOGIN", nullable = false, unique = true)
    private String login;

    @Size(max = 17)
    @Column(name = "TXT_TELEFONE", nullable = true)
    private String telefone;

    @Valid
    @Embedded
    private Endereco endereco;

    @Valid
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_CLIENTE_REMEDIOS", joinColumns = {
        @JoinColumn(name = "ID_CLIENTE")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_REMEDIO")
            })
    private List<Remedio> remediosCliente;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TB_FARMACIA_CLIENTE", joinColumns = {
        @JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_FARMACIA")
            })
    private List<Farmacia> farmacia;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartaoDeCredito> cartaos;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private HistoricoDeCompras historico;

    //cadastra o cliente 
    public void CadastrarCliente(String email, String senha,
            String login) {
        this.login = login;
        this.senha = senha;
        this.email = email;

    }

    //adiciona informações do cliente como numero de telefone,ocupação,nome
    public void adicionarInformaçõesCliente(String nome, String telefone, String ocupacao, String sexo) {
        this.nome = nome;
        this.telefone = telefone;
        this.ocupacao = ocupacao;
        this.sexo = sexo;
    }

    //adiciona as informações de endereco
    public void AdicionarEndereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.endereco = new Endereco();
        this.getEndereco().CadastrarEndereco(rua, numero, bairro, cidade, estado, cep);
    }

    public String getLogin() {
        return this.login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Remedio> getRemediosCliente() {
        return remediosCliente;
    }

    public void setRemediosCliente(List<Remedio> remediosCliente) {
        this.remediosCliente = remediosCliente;
    }

    public List<CartaoDeCredito> getCartaos() {
        return cartaos;
    }

    public void setCartaos(List<CartaoDeCredito> cartaos) {
        this.cartaos = cartaos;
    }

    public HistoricoDeCompras getHistorico() {
        return historico;
    }

    public void setHistorico(HistoricoDeCompras historico) {
        this.historico = historico;
    }

    public List<Farmacia> getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(List<Farmacia> farmacia) {
        this.farmacia = farmacia;
    }
    
    
}
