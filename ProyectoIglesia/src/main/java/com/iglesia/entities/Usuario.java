/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexi
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuario.findByFechaActualizacion", query = "SELECT u FROM Usuario u WHERE u.fechaActualizacion = :fechaActualizacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Relacion> relacionList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Justificacion> justificacionList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Persona> personaList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<ResponsableBoda> responsableBodaList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Boda> bodaList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Movimiento> movimientoList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Lugar> lugarList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Sacerdote> sacerdoteList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Bautizo> bautizoList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<ResponsableBautizo> responsableBautizoList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido, String usuario, String clave, boolean estado, Date fechaActualizacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    @XmlTransient
    public List<Relacion> getRelacionList() {
        return relacionList;
    }

    public void setRelacionList(List<Relacion> relacionList) {
        this.relacionList = relacionList;
    }

    @XmlTransient
    public List<Justificacion> getJustificacionList() {
        return justificacionList;
    }

    public void setJustificacionList(List<Justificacion> justificacionList) {
        this.justificacionList = justificacionList;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<ResponsableBoda> getResponsableBodaList() {
        return responsableBodaList;
    }

    public void setResponsableBodaList(List<ResponsableBoda> responsableBodaList) {
        this.responsableBodaList = responsableBodaList;
    }

    @XmlTransient
    public List<Boda> getBodaList() {
        return bodaList;
    }

    public void setBodaList(List<Boda> bodaList) {
        this.bodaList = bodaList;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    @XmlTransient
    public List<Lugar> getLugarList() {
        return lugarList;
    }

    public void setLugarList(List<Lugar> lugarList) {
        this.lugarList = lugarList;
    }

    @XmlTransient
    public List<Sacerdote> getSacerdoteList() {
        return sacerdoteList;
    }

    public void setSacerdoteList(List<Sacerdote> sacerdoteList) {
        this.sacerdoteList = sacerdoteList;
    }

    @XmlTransient
    public List<Bautizo> getBautizoList() {
        return bautizoList;
    }

    public void setBautizoList(List<Bautizo> bautizoList) {
        this.bautizoList = bautizoList;
    }

    @XmlTransient
    public List<ResponsableBautizo> getResponsableBautizoList() {
        return responsableBautizoList;
    }

    public void setResponsableBautizoList(List<ResponsableBautizo> responsableBautizoList) {
        this.responsableBautizoList = responsableBautizoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}


