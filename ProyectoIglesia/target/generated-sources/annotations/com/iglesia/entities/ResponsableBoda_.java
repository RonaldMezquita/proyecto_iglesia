package com.iglesia.entities;

import com.iglesia.entities.Boda;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Relacion;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-08T18:34:36")
@StaticMetamodel(ResponsableBoda.class)
public class ResponsableBoda_ { 

    public static volatile SingularAttribute<ResponsableBoda, Boolean> estado;
    public static volatile SingularAttribute<ResponsableBoda, Usuario> idUsuario;
    public static volatile SingularAttribute<ResponsableBoda, Boda> idBoda;
    public static volatile SingularAttribute<ResponsableBoda, Date> fechaCreacion;
    public static volatile SingularAttribute<ResponsableBoda, Date> fechaActualizacion;
    public static volatile SingularAttribute<ResponsableBoda, Relacion> idRelacion;
    public static volatile SingularAttribute<ResponsableBoda, Integer> id;
    public static volatile SingularAttribute<ResponsableBoda, Persona> idPersona;

}