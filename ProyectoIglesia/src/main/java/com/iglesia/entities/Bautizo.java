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
@Table(name = "bautizo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bautizo.findAll", query = "SELECT b FROM Bautizo b"),
    @NamedQuery(name = "Bautizo.findById", query = "SELECT b FROM Bautizo b WHERE b.id = :id"),
    @NamedQuery(name = "Bautizo.findByFecha", query = "SELECT b FROM Bautizo b WHERE b.fecha = :fecha"),
    @NamedQuery(name = "Bautizo.findByTomo", query = "SELECT b FROM Bautizo b WHERE b.tomo = :tomo"),
    @NamedQuery(name = "Bautizo.findByFolio", query = "SELECT b FROM Bautizo b WHERE b.folio = :folio"),
    @NamedQuery(name = "Bautizo.findByNumero", query = "SELECT b FROM Bautizo b WHERE b.numero = :numero"),
    @NamedQuery(name = "Bautizo.findByEstado", query = "SELECT b FROM Bautizo b WHERE b.estado = :estado"),
    @NamedQuery(name = "Bautizo.findByFechaCreacion", query = "SELECT b FROM Bautizo b WHERE b.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Bautizo.findByFechaActualizacion", query = "SELECT b FROM Bautizo b WHERE b.fechaActualizacion = :fechaActualizacion")})
public class Bautizo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tomo")
    private String tomo;
    @Basic(optional = false)
    @Column(name = "folio")
    private String folio;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBautizo", fetch = FetchType.LAZY)
    private List<Movimiento> movimientoList;
    @JoinColumn(name = "id_lugar", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lugar idLugar;
    @JoinColumn(name = "id_sacerdote", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sacerdote idSacerdote;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBautizo", fetch = FetchType.LAZY)
    private List<ResponsableBautizo> responsableBautizoList;

    public Bautizo() {
    }

    public Bautizo(Integer id) {
        this.id = id;
    }

    public Bautizo(Integer id, Date fecha, String tomo, String folio, String numero, boolean estado, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.fecha = fecha;
        this.tomo = tomo;
        this.folio = folio;
        this.numero = numero;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Lugar getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Lugar idLugar) {
        this.idLugar = idLugar;
    }

    public Sacerdote getIdSacerdote() {
        return idSacerdote;
    }

    public void setIdSacerdote(Sacerdote idSacerdote) {
        this.idSacerdote = idSacerdote;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Bautizo)) {
            return false;
        }
        Bautizo other = (Bautizo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.Bautizo[ id=" + id + " ]";
    }
    
}

