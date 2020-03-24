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
public enum TipoSacramentoEnum {
    BODA(1), BAUTIZO(2), CONFIRMACION(3);
    private final Integer value;

    private TipoSacramentoEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
