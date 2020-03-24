/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class BodaDto {

    private String tomo;
    private String folio;
    private String numero;
    private TipoSacramentos tipoSacramento;
    private Lugar lugar;
    private Sacerdote sacerdote;
    private Date fecha;
    private Persona novio;
    private Persona padreNovio;
    private Persona madreNovio;
    private Persona novia;
    private Persona padreNovia;
    private Persona madreNovia;
    private Persona testigo1;
    private Persona testigo2;

    public BodaDto() {
    }

    public BodaDto(String tomo, String folio, String numero, TipoSacramentos tipoSacramento, Lugar lugar, Sacerdote sacerdote, Date fecha, Persona novio, Persona padreNovio, Persona madreNovio, Persona novia, Persona padreNovia, Persona madreNovia, Persona testigo1, Persona testigo2) {
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

}
