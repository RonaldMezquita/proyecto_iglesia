package com.iglesia.entities;

import com.iglesia.entities.Bautizo;
import com.iglesia.entities.Justificacion;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-08T17:37:51")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-08T15:38:36")
>>>>>>> Stashed changes
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, String> tipo;
    public static volatile SingularAttribute<Movimiento, Boolean> estado;
    public static volatile SingularAttribute<Movimiento, Double> monto;
    public static volatile SingularAttribute<Movimiento, Usuario> idUsuario;
    public static volatile SingularAttribute<Movimiento, Date> fechaCreacion;
    public static volatile SingularAttribute<Movimiento, Date> fechaActualizacion;
    public static volatile SingularAttribute<Movimiento, Bautizo> idBautizo;
    public static volatile SingularAttribute<Movimiento, Justificacion> idJustificacion;
    public static volatile SingularAttribute<Movimiento, Integer> id;

}