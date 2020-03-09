/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.enums;

/**
 *
 * @author remsf
 */
public enum TipoMovimientoEnum {
    MOV_IN("ENTRADA"), MOV_OUT("SALIDA");

    private final String value;

    private TipoMovimientoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
