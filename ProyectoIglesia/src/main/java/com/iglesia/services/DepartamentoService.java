/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Departamento;
import com.iglesia.utils.CrudUtils;

/**
 *
 * @author remsf
 */
public class DepartamentoService extends CrudUtils<Departamento>{

    public DepartamentoService() {
        super(Departamento.class);
    }
    
}
