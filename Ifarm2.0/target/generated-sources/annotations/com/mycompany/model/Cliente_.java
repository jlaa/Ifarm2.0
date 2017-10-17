package com.mycompany.model;

import com.mycompany.model.CartaoDeCredito;
import com.mycompany.model.Endereco;
import com.mycompany.model.Farmacia;
import com.mycompany.model.HistoricoDeCompras;
import com.mycompany.model.Remedio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-16T21:13:44")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> telefone;
    public static volatile SingularAttribute<Cliente, Endereco> endereco;
    public static volatile ListAttribute<Cliente, Remedio> remediosCliente;
    public static volatile SingularAttribute<Cliente, HistoricoDeCompras> historico;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, String> login;
    public static volatile ListAttribute<Cliente, CartaoDeCredito> cartaos;
    public static volatile SingularAttribute<Cliente, String> senha;
    public static volatile SingularAttribute<Cliente, String> ocupacao;
    public static volatile ListAttribute<Cliente, Farmacia> farmacia;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile SingularAttribute<Cliente, String> sexo;
    public static volatile SingularAttribute<Cliente, String> email;

}