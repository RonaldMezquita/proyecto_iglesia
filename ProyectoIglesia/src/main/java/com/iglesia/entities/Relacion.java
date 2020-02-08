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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "relacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacion.findAll", query = "SELECT r FROM Relacion r"),
    @NamedQuery(name = "Relacion.findById", query = "SELECT r FROM Relacion r WHERE r.id = :id"),
    @NamedQuery(name = "Relacion.findByNombre", query = "SELECT r FROM Relacion r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Relacion.findByEstado", query = "SELECT r FROM Relacion r WHERE r.estado = :estado"),
    @NamedQuery(name = "Relacion.findByFechaCreacion", query = "SELECT r FROM Relacion r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Relacion.findByFechaActualizacion", query = "SELECT r FROM Relacion r WHERE r.fechaActualizacion = :fechaActualizacion")})
public class Relacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRelacion", fetch = FetchType.LAZY)
    private List<ResponsableBoda> responsableBodaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRelacion", fetch = FetchType.LAZY)
    private List<ResponsableBautizo> responsableBautizoList;

    public Relacion() {
    }

    public Relacion(Integer id) {
        this.id = id;
    }

    public Relacion(Integer id, String nombre, boolean estado, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<ResponsableBoda> getResponsableBodaList() {
        return responsableBodaList;
    }

    public void setResponsableBodaList(List<ResponsableBoda> responsableBodaList) {
        this.responsableBodaList = responsableBodaList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacion)) {
            return false;
        }
        Relacion other = (Relacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.Relacion[ id=" + id + " ]";
    }
    
}

