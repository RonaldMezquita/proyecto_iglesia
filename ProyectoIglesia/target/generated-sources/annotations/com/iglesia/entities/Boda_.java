package com.iglesia.entities;

import com.iglesia.entities.Lugar;
import com.iglesia.entities.ResponsableBoda;
import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-08T19:29:23")
@StaticMetamodel(Boda.class)
public class Boda_ { 

    public static volatile SingularAttribute<Boda, Date> fecha;
    public static volatile SingularAttribute<Boda, Boolean> estado;
    public static volatile SingularAttribute<Boda, String> numero;
    public static volatile SingularAttribute<Boda, Sacerdote> idSacerdote;
    public static volatile SingularAttribute<Boda, Usuario> idUsuario;
    public static volatile ListAttribute<Boda, ResponsableBoda> responsableBodaList;
    public static volatile SingularAttribute<Boda, String> folio;
    public static volatile SingularAttribute<Boda, Date> fechaCreacion;
    public static volatile SingularAttribute<Boda, Date> fechaActualizacion;
    public static volatile SingularAttribute<Boda, String> tomo;
    public static volatile SingularAttribute<Boda, Integer> id;
    public static volatile SingularAttribute<Boda, Lugar> idLugar;

}