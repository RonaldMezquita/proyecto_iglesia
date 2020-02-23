package com.iglesia.entities;

import com.iglesia.entities.Evento;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-23T15:48:06")
@StaticMetamodel(Lugar.class)
public class Lugar_ { 

    public static volatile SingularAttribute<Lugar, Boolean> estado;
    public static volatile SingularAttribute<Lugar, Usuario> idUsuario;
    public static volatile ListAttribute<Lugar, Evento> eventoList;
    public static volatile SingularAttribute<Lugar, Date> fechaCreacion;
    public static volatile SingularAttribute<Lugar, Date> fechaActualizacion;
    public static volatile SingularAttribute<Lugar, Integer> id;
    public static volatile SingularAttribute<Lugar, String> nombre;

}