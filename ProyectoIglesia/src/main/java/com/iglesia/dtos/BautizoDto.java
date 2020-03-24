package com.iglesia.dtos;

import com.iglesia.entities.Lugar;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.TipoSacramentos;
import java.util.Date;

/**
 *
 * @author Ronald Mezquita
 */
public class BautizoDto {

    private String tomo;
    private String folio;
    private String numero;
    private TipoSacramentos tipoSacramento;
    private Lugar lugar;
    private Sacerdote sacerdote;
    private Date fecha;
    private Persona sacramentado;
    private Persona padreSacramentado;
    private Persona madreSacramentado;
    private Persona padrino;
    private Persona madrina;

    public BautizoDto() {
    }

    public BautizoDto(String tomo, String folio, String numero, TipoSacramentos tipoSacramento, Lugar lugar, Sacerdote sacerdote, Date fecha, Persona sacramentado, Persona padreSacramentado, Persona madreSacramentado, Persona padrino, Persona madrina) {
        this.tomo = tomo;
        this.folio = folio;
        this.numero = numero;
        this.tipoSacramento = tipoSacramento;
        this.lugar = lugar;
        this.sacerdote = sacerdote;
        this.fecha = fecha;
        this.sacramentado = sacramentado;
        this.padreSacramentado = padreSacramentado;
        this.madreSacramentado = madreSacramentado;
        this.padrino = padrino;
        this.madrina = madrina;
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

    public TipoSacramentos getTipoSacramento() {
        return tipoSacramento;
    }

    public void setTipoSacramento(TipoSacramentos tipoSacramento) {
        this.tipoSacramento = tipoSacramento;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Sacerdote getSacerdote() {
        return sacerdote;
    }

    public void setSacerdote(Sacerdote sacerdote) {
        this.sacerdote = sacerdote;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getSacramentado() {
        return sacramentado;
    }

    public void setSacramentado(Persona sacramentado) {
        this.sacramentado = sacramentado;
    }

    public Persona getPadreSacramentado() {
        return padreSacramentado;
    }

    public void setPadreSacramentado(Persona padreSacramentado) {
        this.padreSacramentado = padreSacramentado;
    }

    public Persona getMadreSacramentado() {
        return madreSacramentado;
    }

    public void setMadreSacramentado(Persona madreSacramentado) {
        this.madreSacramentado = madreSacramentado;
    }

    public Persona getPadrino() {
        return padrino;
    }

    public void setPadrino(Persona padrino) {
        this.padrino = padrino;
    }

    public Persona getMadrina() {
        return madrina;
    }

    public void setMadrina(Persona madrina) {
        this.madrina = madrina;
    }

}
