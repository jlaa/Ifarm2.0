package com.mycompany.model;

import com.mycompany.model.Cliente;
import com.mycompany.model.DonoDeFarmacia;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-16T21:13:44")
@StaticMetamodel(HistoricoDeCompras.class)
public class HistoricoDeCompras_ { 

    public static volatile SingularAttribute<HistoricoDeCompras, Long> id_historico;
    public static volatile SingularAttribute<HistoricoDeCompras, Cliente> cliente;
    public static volatile SingularAttribute<HistoricoDeCompras, DonoDeFarmacia> dono;
    public static volatile SingularAttribute<HistoricoDeCompras, Double> valorCompra;
    public static volatile SingularAttribute<HistoricoDeCompras, Integer> quantidade;
    public static volatile SingularAttribute<HistoricoDeCompras, Calendar> dataCompra;

}