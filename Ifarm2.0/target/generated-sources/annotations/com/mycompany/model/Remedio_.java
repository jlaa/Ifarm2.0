package com.mycompany.model;

import com.mycompany.model.Cliente;
import com.mycompany.model.Farmacia;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-07T12:16:25")
@StaticMetamodel(Remedio.class)
public class Remedio_ { 

    public static volatile SingularAttribute<Remedio, Double> preco;
    public static volatile SingularAttribute<Remedio, String> tipo;
    public static volatile SingularAttribute<Remedio, String> faixaEtaria;
    public static volatile SingularAttribute<Remedio, Integer> desconto;
    public static volatile SingularAttribute<Remedio, Calendar> dataValidade;
    public static volatile SingularAttribute<Remedio, String> nome;
    public static volatile ListAttribute<Remedio, Farmacia> farmacia;
    public static volatile SingularAttribute<Remedio, Long> id;
    public static volatile ListAttribute<Remedio, Cliente> clientes;
    public static volatile SingularAttribute<Remedio, Long> quantidade;

}