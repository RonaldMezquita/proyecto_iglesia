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
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Alexis
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findById", query = "SELECT e FROM Evento e WHERE e.id = :id"),
    @NamedQuery(name = "Evento.findByFecha", query = "SELECT e FROM Evento e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Evento.findByTomo", query = "SELECT e FROM Evento e WHERE e.tomo = :tomo"),
    @NamedQuery(name = "Evento.findByFolio", query = "SELECT e FROM Evento e WHERE e.folio = :folio"),
    @NamedQuery(name = "Evento.findByNumero", query = "SELECT e FROM Evento e WHERE e.numero = :numero"),
    @NamedQuery(name = "Evento.findByEstado", query = "SELECT e FROM Evento e WHERE e.estado = :estado"),
    @NamedQuery(name = "Evento.findByFechaCreacion", query = "SELECT e FROM Evento e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Evento.findByFechaActualizacion", query = "SELECT e FROM Evento e WHERE e.fechaActualizacion = :fechaActualizacion")})
public class Evento implements Serializable {

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
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @OneToMany(mappedBy = "idEvento")
    private List<ResponsableEvento> responsableEventoList;
    @JoinColumn(name = "id_lugar", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lugar idLugar;
    @JoinColumn(name = "id_sacerdote", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sacerdote idSacerdote;
    @JoinColumn(name = "id_tipo_sacramento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoSacramentos idTipoSacramento;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idEvento")
    private List<Movimiento> movimientoList;

    public Evento() {
    }

    public Evento(Integer id) {
        this.id = id;
    }

    public Evento(Integer id, Date fecha, String tomo, String folio, String numero, boolean estado, Date fechaCreacion) {
        this.id = id;
        this.fecha = fecha;
        this.tomo = tomo;
        this.folio = folio;
        this.numero = numero;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
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
    public List<ResponsableEvento> getResponsableEventoList() {
        return responsableEventoList;
    }

    public void setResponsableEventoList(List<ResponsableEvento> responsableEventoList) {
        this.responsableEventoList = responsableEventoList;
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

    public TipoSacramentos getIdTipoSacramento() {
        return idTipoSacramento;
    }

    public void setIdTipoSacramento(TipoSacramentos idTipoSacramento) {
        this.idTipoSacramento = idTipoSacramento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
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
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iglesia.entities.Evento[ id=" + id + " ]";
    }
    
}
