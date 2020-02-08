/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexi
 */
@Entity
@Table(name = "responsable_boda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsableBoda.findAll", query = "SELECT r FROM ResponsableBoda r"),
    @NamedQuery(name = "ResponsableBoda.findById", query = "SELECT r FROM ResponsableBoda r WHERE r.id = :id"),
    @NamedQuery(name = "ResponsableBoda.findByEstado", query = "SELECT r FROM ResponsableBoda r WHERE r.estado = :estado"),
    @NamedQuery(name = "ResponsableBoda.findByFechaCreacion", query = "SELECT r FROM ResponsableBoda r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ResponsableBoda.findByFechaActualizacion", query = "SELECT r FROM ResponsableBoda r WHERE r.fechaActualizacion = :fechaActualizacion")})
public class ResponsableBoda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @JoinColumn(name = "id_boda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Boda idBoda;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersona;
    @JoinColumn(name = "id_relacion", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Relacion idRelacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public ResponsableBoda() {
    }

    public ResponsableBoda(Integer id) {
        this.id = id;
    }

    public ResponsableBoda(Integer id, boolean estado, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
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

    public Boda getIdBoda() {
        return idBoda;
    }

    public void setIdBoda(Boda idBoda) {
        this.idBoda = idBoda;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Relacion getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Relacion idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof ResponsableBoda)) {
            return false;
        }
        ResponsableBoda other = (ResponsableBoda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.ResponsableBoda[ id=" + id + " ]";
    }
    
}

