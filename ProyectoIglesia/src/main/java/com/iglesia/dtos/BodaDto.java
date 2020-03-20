/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.dtos;

import com.iglesia.entities.Lugar;
import com.iglesia.entities.Persona;
import com.iglesia.entities.Sacerdote;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class BodaDto {

    private String tomo;
    private String folio;
    private Lugar lugar;
    private Date fecha;
    private Persona novio;
    private Persona padreNovio;
    private Persona madreNovio;
    private Persona novia;
    private Persona padreNovia;
    private Persona madreNovia;
    private Persona testigo;
    private Sacerdote sacerdote;

    public BodaDto() {
    }

    public BodaDto(String tomo, String folio, Lugar lugar, Date fecha, Persona novio, Persona padreNovio, Persona madreNovio, Persona novia, Persona padreNovia, Persona madreNovia, Persona testigo, Sacerdote sacerdote) {
        this.tomo = tomo;
        this.folio = folio;
        this.lugar = lugar;
        this.fecha = fecha;
        this.novio = novio;
        this.padreNovio = padreNovio;
        this.madreNovio = madreNovio;
        this.novia = novia;
        this.padreNovia = padreNovia;
        this.madreNovia = madreNovia;
        this.testigo = testigo;
        this.sacerdote = sacerdote;
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

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
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

    public Persona getTestigo() {
        return testigo;
    }

    public void setTestigo(Persona testigo) {
        this.testigo = testigo;
    }

    public Sacerdote getSacerdote() {
        return sacerdote;
    }

    public void setSacerdote(Sacerdote sacerdote) {
        this.sacerdote = sacerdote;
    }

}
