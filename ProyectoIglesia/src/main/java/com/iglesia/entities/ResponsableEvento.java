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
 * @author Alexis
 */
@Entity
@Table(name = "responsable_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsableEvento.findAll", query = "SELECT r FROM ResponsableEvento r"),
    @NamedQuery(name = "ResponsableEvento.findById", query = "SELECT r FROM ResponsableEvento r WHERE r.id = :id"),
    @NamedQuery(name = "ResponsableEvento.findByEstado", query = "SELECT r FROM ResponsableEvento r WHERE r.estado = :estado"),
    @NamedQuery(name = "ResponsableEvento.findByFechaCreacion", query = "SELECT r FROM ResponsableEvento r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ResponsableEvento.findByFechaActualizacion", query = "SELECT r FROM ResponsableEvento r WHERE r.fechaActualizacion = :fechaActualizacion")})
public class ResponsableEvento implements Serializable {

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
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evento idEvento;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_padre", referencedColumnName = "id")
    @ManyToOne
    private Persona idPadre;
    @JoinColumn(name = "id_madre", referencedColumnName = "id")
    @ManyToOne
    private Persona idMadre;
    @JoinColumn(name = "id_relacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Relacion idRelacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_lugar_bautizo", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Lugar idLugarBautizo;

    public ResponsableEvento() {
    }

    public ResponsableEvento(Integer id) {
        this.id = id;
    }

    public ResponsableEvento(Integer id, boolean estado, Date fechaCreacion) {
        this.id = id;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
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

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Persona idPadre) {
        this.idPadre = idPadre;
    }

    public Persona getIdMadre() {
        return idMadre;
    }

    public void setIdMadre(Persona idMadre) {
        this.idMadre = idMadre;
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

    public Lugar getIdLugarBautizo() {
        return idLugarBautizo;
    }

    public void setIdLugarBautizo(Lugar idLugarBautizo) {
        this.idLugarBautizo = idLugarBautizo;
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
        if (!(object instanceof ResponsableEvento)) {
            return false;
        }
        ResponsableEvento other = (ResponsableEvento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.ResponsableEvento[ id=" + id + " ]";
    }

}
