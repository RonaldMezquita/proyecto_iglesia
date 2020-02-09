package com.iglesia.entities;

import com.iglesia.entities.Bautizo;
import com.iglesia.entities.Boda;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-08T17:37:51")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-08T15:38:36")
>>>>>>> Stashed changes
@StaticMetamodel(Sacerdote.class)
public class Sacerdote_ { 

    public static volatile SingularAttribute<Sacerdote, String> apellidos;
    public static volatile SingularAttribute<Sacerdote, Boolean> estado;
    public static volatile ListAttribute<Sacerdote, Bautizo> bautizoList;
    public static volatile SingularAttribute<Sacerdote, Usuario> idUsuario;
    public static volatile SingularAttribute<Sacerdote, Date> fechaCreacion;
    public static volatile SingularAttribute<Sacerdote, Date> fechaActualizacion;
    public static volatile SingularAttribute<Sacerdote, Integer> id;
    public static volatile ListAttribute<Sacerdote, Boda> bodaList;
    public static volatile SingularAttribute<Sacerdote, String> nombres;

}