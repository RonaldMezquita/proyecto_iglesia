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
public enum TipoRelacionEnum {
    PADRINO(1),
    MADRINA(2),
    NOVIO(3),
    NOVIA(4),
    TESTIGO(5),
    SACRAMENTADO(6);

    private final Integer value;

    private TipoRelacionEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
