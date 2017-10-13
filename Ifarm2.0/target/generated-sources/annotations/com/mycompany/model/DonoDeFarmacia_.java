package com.mycompany.model;

import com.mycompany.model.Endereco;
import com.mycompany.model.HistoricoDeCompras;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T19:58:04")
@StaticMetamodel(DonoDeFarmacia.class)
public class DonoDeFarmacia_ { 

    public static volatile SingularAttribute<DonoDeFarmacia, String> senha;
    public static volatile SingularAttribute<DonoDeFarmacia, String> telefone;
    public static volatile SingularAttribute<DonoDeFarmacia, Endereco> endereco;
    public static volatile SingularAttribute<DonoDeFarmacia, String> ocupacao;
    public static volatile ListAttribute<DonoDeFarmacia, HistoricoDeCompras> historico;
    public static volatile SingularAttribute<DonoDeFarmacia, String> nome;
    public static volatile SingularAttribute<DonoDeFarmacia, Long> id;
    public static volatile SingularAttribute<DonoDeFarmacia, String> sexo;
    public static volatile SingularAttribute<DonoDeFarmacia, String> login;
    public static volatile SingularAttribute<DonoDeFarmacia, String> email;

}