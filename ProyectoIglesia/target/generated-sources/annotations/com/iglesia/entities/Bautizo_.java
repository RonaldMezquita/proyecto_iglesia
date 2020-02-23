package com.iglesia.entities;

import com.iglesia.entities.Lugar;
import com.iglesia.entities.Movimiento;
import com.iglesia.entities.ResponsableBautizo;
import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-20T22:09:16")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-21T22:20:44")
>>>>>>> master
@StaticMetamodel(Bautizo.class)
public class Bautizo_ { 

    public static volatile SingularAttribute<Bautizo, Boolean> estado;
    public static volatile SingularAttribute<Bautizo, String> numero;
    public static volatile SingularAttribute<Bautizo, Usuario> idUsuario;
    public static volatile ListAttribute<Bautizo, ResponsableBautizo> responsableBautizoList;
    public static volatile ListAttribute<Bautizo, Movimiento> movimientoList;
    public static volatile SingularAttribute<Bautizo, String> tomo;
    public static volatile SingularAttribute<Bautizo, Lugar> idLugar;
    public static volatile SingularAttribute<Bautizo, Date> fecha;
    public static volatile SingularAttribute<Bautizo, Sacerdote> idSacerdote;
    public static volatile SingularAttribute<Bautizo, String> folio;
    public static volatile SingularAttribute<Bautizo, Date> fechaCreacion;
    public static volatile SingularAttribute<Bautizo, Date> fechaActualizacion;
    public static volatile SingularAttribute<Bautizo, Integer> id;

}