/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.enums;

/**
 *
 * @author Alexis
 */
public enum TipoSacramentosEnum {
    BODA(1), BAUTIZO(2), CONFIRMACION(3);
    private final Integer value;

    private TipoSacramentosEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
