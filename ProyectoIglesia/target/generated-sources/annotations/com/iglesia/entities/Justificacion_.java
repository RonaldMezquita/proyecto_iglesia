package com.iglesia.entities;

import com.iglesia.entities.Movimiento;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-05T20:51:08")
@StaticMetamodel(Justificacion.class)
public class Justificacion_ { 

    public static volatile SingularAttribute<Justificacion, Usuario> idUsuario;
    public static volatile ListAttribute<Justificacion, Movimiento> movimientoList;
    public static volatile SingularAttribute<Justificacion, Date> fechaCreacion;
    public static volatile SingularAttribute<Justificacion, Integer> id;
    public static volatile SingularAttribute<Justificacion, String> nombre;

}