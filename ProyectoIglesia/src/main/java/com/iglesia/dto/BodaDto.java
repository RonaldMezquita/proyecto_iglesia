/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.dto;

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
    private String lugar;
    private Date fecha;
    private Persona esposo;
    private Persona padreEsposo;
    private Persona madreEsposo;
    private Persona esposa;
    private Persona padreEsposa;
    private Persona madreEsposa;
    private Persona testigo;
    private Sacerdote sacerdote;

    public BodaDto() {
    }

    public BodaDto(String tomo, String folio, String lugar, Date fecha, Persona esposo, Persona padreEsposo, Persona madreEsposo, Persona esposa, Persona padreEsposa, Persona madreEsposa, Persona testigo, Sacerdote sacerdote) {
        this.tomo = tomo;
        this.folio = folio;
        this.lugar = lugar;
        this.fecha = fecha;
        this.esposo = esposo;
        this.padreEsposo = padreEsposo;
        this.madreEsposo = madreEsposo;
        this.esposa = esposa;
        this.padreEsposa = padreEsposa;
        this.madreEsposa = madreEsposa;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getEsposo() {
        return esposo;
    }

    public void setEsposo(Persona esposo) {
        this.esposo = esposo;
    }

    public Persona getPadreEsposo() {
        return padreEsposo;
    }

    public void setPadreEsposo(Persona padreEsposo) {
        this.padreEsposo = padreEsposo;
    }

    public Persona getMadreEsposo() {
        return madreEsposo;
    }

    public void setMadreEsposo(Persona madreEsposo) {
        this.madreEsposo = madreEsposo;
    }

    public Persona getEsposa() {
        return esposa;
    }

    public void setEsposa(Persona esposa) {
        this.esposa = esposa;
    }

    public Persona getPadreEsposa() {
        return padreEsposa;
    }

    public void setPadreEsposa(Persona padreEsposa) {
        this.padreEsposa = padreEsposa;
    }

    public Persona getMadreEsposa() {
        return madreEsposa;
    }

    public void setMadreEsposa(Persona madreEsposa) {
        this.madreEsposa = madreEsposa;
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
