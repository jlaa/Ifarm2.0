package com.mycompany.model;

import com.mycompany.model.Cliente;
import com.mycompany.model.Endereco;
import com.mycompany.model.Remedio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-09T16:33:50")
@StaticMetamodel(Farmacia.class)
public class Farmacia_ { 

    public static volatile ListAttribute<Farmacia, Cliente> cliente;
    public static volatile SingularAttribute<Farmacia, Endereco> endereco;
    public static volatile ListAttribute<Farmacia, Remedio> remediosFarmacia;
    public static volatile SingularAttribute<Farmacia, Long> id_farmacia;
    public static volatile SingularAttribute<Farmacia, String> nome;

}