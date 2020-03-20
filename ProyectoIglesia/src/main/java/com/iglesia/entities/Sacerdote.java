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
@Table(name = "sacerdote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sacerdote.findAll", query = "SELECT s FROM Sacerdote s"),
    @NamedQuery(name = "Sacerdote.findById", query = "SELECT s FROM Sacerdote s WHERE s.id = :id"),
    @NamedQuery(name = "Sacerdote.findByNombres", query = "SELECT s FROM Sacerdote s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Sacerdote.findByApellidos", query = "SELECT s FROM Sacerdote s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Sacerdote.findByDui", query = "SELECT s FROM Sacerdote s WHERE s.dui = :dui"),
    @NamedQuery(name = "Sacerdote.findByNit", query = "SELECT s FROM Sacerdote s WHERE s.nit = :nit"),
    @NamedQuery(name = "Sacerdote.findByParroco", query = "SELECT s FROM Sacerdote s WHERE s.parroco = :parroco"),
    @NamedQuery(name = "Sacerdote.findByEstado", query = "SELECT s FROM Sacerdote s WHERE s.estado = :estado"),
    @NamedQuery(name = "Sacerdote.findByFechaCreacion", query = "SELECT s FROM Sacerdote s WHERE s.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Sacerdote.findByFechaActualizacion", query = "SELECT s FROM Sacerdote s WHERE s.fechaActualizacion = :fechaActualizacion")})
public class Sacerdote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "dui")
    private String dui;
    @Basic(optional = false)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @Column(name = "parroco")
    private boolean parroco;
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
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Sacerdote() {
    }

    public Sacerdote(Integer id) {
        this.id = id;
    }

    public Sacerdote(Integer id, String nombres, String apellidos, String dui, String nit, boolean parroco, boolean estado, Date fechaCreacion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.nit = nit;
        this.parroco = parroco;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public boolean getParroco() {
        return parroco;
    }

    public void setParroco(boolean parroco) {
        this.parroco = parroco;
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

    public String getNombreCompleto() {
        return new StringBuilder(this.nombres).append(" ").append(this.apellidos).toString();
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
        if (!(object instanceof Sacerdote)) {
            return false;
        }
        Sacerdote other = (Sacerdote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.Sacerdote[ id=" + id + " ]";
    }

}
