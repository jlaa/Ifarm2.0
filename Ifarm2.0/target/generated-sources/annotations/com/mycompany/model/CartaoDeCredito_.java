package com.mycompany.model;

import com.mycompany.model.Cliente;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-16T13:34:13")
@StaticMetamodel(CartaoDeCredito.class)
public class CartaoDeCredito_ { 

    public static volatile SingularAttribute<CartaoDeCredito, Calendar> dataExpiracao;
    public static volatile SingularAttribute<CartaoDeCredito, Cliente> cliente;
    public static volatile SingularAttribute<CartaoDeCredito, String> codigo;
    public static volatile SingularAttribute<CartaoDeCredito, Long> id;
    public static volatile SingularAttribute<CartaoDeCredito, String> bandeira;
    public static volatile SingularAttribute<CartaoDeCredito, String> numero_cartao;

}