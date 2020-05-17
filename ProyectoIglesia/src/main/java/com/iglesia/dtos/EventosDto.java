/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.dtos;

import com.iglesia.entities.Evento;
import com.iglesia.entities.Lugar;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Sacerdote;
import com.iglesia.entities.TipoSacramentos;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoRelacionEnum;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ronald Mezquita
 */
public class EventosDto {

    private Integer idEvento;
    private Evento evento;
    private String tomo;
    private String folio;
    private String numero;
    private TipoSacramentos tipoSacramento;
    private Lugar lugar;
    private Sacerdote sacerdote;
    private Date fecha;
    // boda
    private Persona novio;
    private Persona padreNovio;
    private Persona madreNovio;
    private Persona novia;
    private Persona padreNovia;
    private Persona madreNovia;
    private Persona testigo1;
    private Persona testigo2;
    // bautizo, confirmacion
    private Persona sacramentado;
    private Persona padreSacramentado;
    private Persona madreSacramentado;
    private Persona padrino;
    private Persona madrina;
    private Usuario usuario;
    private Lugar lugarBautizo;
    // <idRelacion, idResponsableEvento>
    private Map<TipoRelacionEnum, Integer> relacionMap = new HashMap<>();

    public EventosDto() {
    }

    public EventosDto(String tomo, String folio, String numero, TipoSacramentos tipoSacramento, Lugar lugar, Sacerdote sacerdote, Date fecha, Persona novio, Persona padreNovio, Persona madreNovio, Persona novia, Persona padreNovia, Persona madreNovia, Persona testigo1, Persona testigo2, Persona sacramentado, Persona padreSacramentado, Persona madreSacramentado, Persona padrino, Persona madrina, Usuario usuario, Lugar lugarBautizo) {
        this.tomo = tomo;
        this.folio = folio;
        this.numero = numero;
        this.tipoSacramento = tipoSacramento;
        this.lugar = lugar;
        this.sacerdote = sacerdote;
        this.fecha = fecha;
        this.novio = novio;
        this.padreNovio = padreNovio;
        this.madreNovio = madreNovio;
        this.novia = novia;
        this.padreNovia = padreNovia;
        this.madreNovia = madreNovia;
        this.testigo1 = testigo1;
        this.testigo2 = testigo2;
        this.sacramentado = sacramentado;
        this.padreSacramentado = padreSacramentado;
        this.madreSacramentado = madreSacramentado;
        this.padrino = padrino;
        this.madrina = madrina;
        this.usuario = usuario;
        this.lugarBautizo = lugarBautizo;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
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

    public Persona getNovio() {
        return novio;
    }

    public void setNovio(Persona novio) {
        this.novio = novio;
    }

    public Persona getPadreNovio() {
        return padreNovio;
    }

    public void setPadreNovio(Persona padreNovio) {
        this.padreNovio = padreNovio;
    }

    public Persona getMadreNovio() {
        return madreNovio;
    }

    public void setMadreNovio(Persona madreNovio) {
        this.madreNovio = madreNovio;
    }

    public Persona getNovia() {
        return novia;
    }

    public void setNovia(Persona novia) {
        this.novia = novia;
    }

    public Persona getPadreNovia() {
        return padreNovia;
    }

    public void setPadreNovia(Persona padreNovia) {
        this.padreNovia = padreNovia;
    }

    public Persona getMadreNovia() {
        return madreNovia;
    }

    public void setMadreNovia(Persona madreNovia) {
        this.madreNovia = madreNovia;
    }

    public Persona getTestigo1() {
        return testigo1;
    }

    public void setTestigo1(Persona testigo1) {
        this.testigo1 = testigo1;
    }

    public Persona getTestigo2() {
        return testigo2;
    }

    public void setTestigo2(Persona testigo2) {
        this.testigo2 = testigo2;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Map<TipoRelacionEnum, Integer> getRelacionMap() {
        return relacionMap;
    }

    public void setRelacionMap(Map<TipoRelacionEnum, Integer> relacionMap) {
        this.relacionMap = relacionMap;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Lugar getLugarBautizo() {
        return lugarBautizo;
    }

    public void setLugarBautizo(Lugar lugarBautizo) {
        this.lugarBautizo = lugarBautizo;
    }

}
