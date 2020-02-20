package com.iglesia.entities;

import com.iglesia.entities.Bautizo;
import com.iglesia.entities.Boda;
import com.iglesia.entities.Justificacion;
import com.iglesia.entities.Lugar;
import com.iglesia.entities.Movimiento;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Relacion;
import com.iglesia.entities.ResponsableBautizo;
import com.iglesia.entities.ResponsableBoda;
import com.iglesia.entities.Sacerdote;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-19T21:40:38")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Boolean> estado;
    public static volatile ListAttribute<Usuario, Sacerdote> sacerdoteList;
    public static volatile ListAttribute<Usuario, Persona> personaList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile ListAttribute<Usuario, ResponsableBautizo> responsableBautizoList;
    public static volatile ListAttribute<Usuario, Movimiento> movimientoList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Boda> bodaList;
    public static volatile ListAttribute<Usuario, Bautizo> bautizoList;
    public static volatile ListAttribute<Usuario, Relacion> relacionList;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile ListAttribute<Usuario, Justificacion> justificacionList;
    public static volatile ListAttribute<Usuario, ResponsableBoda> responsableBodaList;
    public static volatile ListAttribute<Usuario, Lugar> lugarList;
    public static volatile SingularAttribute<Usuario, Date> fechaCreacion;
    public static volatile SingularAttribute<Usuario, Date> fechaActualizacion;
    public static volatile SingularAttribute<Usuario, String> usuario;

}