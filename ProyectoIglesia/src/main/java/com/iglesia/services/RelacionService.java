/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Relacion;
import com.iglesia.utils.CrudUtils;

/**
 *
 * @author alexi
 */
public class RelacionService extends CrudUtils<Relacion>{

    public RelacionService() {
        super(Relacion.class);
    }
    
}


