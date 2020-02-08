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
 * @author remsf
 */
@Entity
@Table(name = "sacerdote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sacerdote.findAll", query = "SELECT s FROM Sacerdote s"),
    @NamedQuery(name = "Sacerdote.findById", query = "SELECT s FROM Sacerdote s WHERE s.id = :id"),
    @NamedQuery(name = "Sacerdote.findByNombres", query = "SELECT s FROM Sacerdote s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Sacerdote.findByApellidos", query = "SELECT s FROM Sacerdote s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Sacerdote.findByFechaCreacion", query = "SELECT s FROM Sacerdote s WHERE s.fechaCreacion = :fechaCreacion")})
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
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSacerdote", fetch = FetchType.LAZY)
    private List<Boda> bodaList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSacerdote", fetch = FetchType.LAZY)
    private List<Bautizo> bautizoList;

    public Sacerdote() {
    }

    public Sacerdote(Integer id) {
        this.id = id;
    }

    public Sacerdote(Integer id, String nombres, String apellidos, Date fechaCreacion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Boda> getBodaList() {
        return bodaList;
    }

    public void setBodaList(List<Boda> bodaList) {
        this.bodaList = bodaList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Bautizo> getBautizoList() {
        return bautizoList;
    }

    public void setBautizoList(List<Bautizo> bautizoList) {
        this.bautizoList = bautizoList;
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
