package com.iglesia.entities;

import com.iglesia.entities.Bautizo;
import com.iglesia.entities.Boda;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-09T21:26:07")
@StaticMetamodel(Lugar.class)
public class Lugar_ { 

    public static volatile SingularAttribute<Lugar, Boolean> estado;
    public static volatile ListAttribute<Lugar, Bautizo> bautizoList;
    public static volatile SingularAttribute<Lugar, Usuario> idUsuario;
    public static volatile SingularAttribute<Lugar, Date> fechaCreacion;
    public static volatile SingularAttribute<Lugar, Date> fechaActualizacion;
    public static volatile SingularAttribute<Lugar, Integer> id;
    public static volatile SingularAttribute<Lugar, String> nombre;
    public static volatile ListAttribute<Lugar, Boda> bodaList;

}