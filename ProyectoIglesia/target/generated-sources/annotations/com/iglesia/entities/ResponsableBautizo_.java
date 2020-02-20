package com.iglesia.entities;

import com.iglesia.entities.Bautizo;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Relacion;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-19T21:40:38")
@StaticMetamodel(ResponsableBautizo.class)
public class ResponsableBautizo_ { 

    public static volatile SingularAttribute<ResponsableBautizo, Boolean> estado;
    public static volatile SingularAttribute<ResponsableBautizo, Usuario> idUsuario;
    public static volatile SingularAttribute<ResponsableBautizo, Date> fechaCreacion;
    public static volatile SingularAttribute<ResponsableBautizo, Date> fechaActualizacion;
    public static volatile SingularAttribute<ResponsableBautizo, Relacion> idRelacion;
    public static volatile SingularAttribute<ResponsableBautizo, Bautizo> idBautizo;
    public static volatile SingularAttribute<ResponsableBautizo, Integer> id;
    public static volatile SingularAttribute<ResponsableBautizo, Persona> idPersona;

}