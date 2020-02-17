package com.iglesia.entities;

import com.iglesia.entities.ResponsableBautizo;
import com.iglesia.entities.ResponsableBoda;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-16T20:10:00")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidos;
    public static volatile SingularAttribute<Persona, Boolean> estado;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, Usuario> idUsuario;
    public static volatile ListAttribute<Persona, ResponsableBautizo> responsableBautizoList;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> nombres;
    public static volatile ListAttribute<Persona, ResponsableBoda> responsableBodaList;
    public static volatile SingularAttribute<Persona, String> nit;
    public static volatile SingularAttribute<Persona, String> dui;
    public static volatile SingularAttribute<Persona, Date> fechaCreacion;
    public static volatile SingularAttribute<Persona, Date> fechaActualizacion;
    public static volatile SingularAttribute<Persona, Integer> id;

}