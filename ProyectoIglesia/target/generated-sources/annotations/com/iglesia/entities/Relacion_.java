package com.iglesia.entities;

import com.iglesia.entities.ResponsableBautizo;
import com.iglesia.entities.ResponsableBoda;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-09T21:26:07")
@StaticMetamodel(Relacion.class)
public class Relacion_ { 

    public static volatile SingularAttribute<Relacion, Boolean> estado;
    public static volatile SingularAttribute<Relacion, Usuario> idUsuario;
    public static volatile ListAttribute<Relacion, ResponsableBoda> responsableBodaList;
    public static volatile ListAttribute<Relacion, ResponsableBautizo> responsableBautizoList;
    public static volatile SingularAttribute<Relacion, Date> fechaCreacion;
    public static volatile SingularAttribute<Relacion, Date> fechaActualizacion;
    public static volatile SingularAttribute<Relacion, Integer> id;
    public static volatile SingularAttribute<Relacion, String> nombre;

}