/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.Bautizo;
import com.iglesia.utils.CrudUtils;

/**
 *
 * @author alexi
 */
public class BautizoService  extends CrudUtils<Bautizo>{

    public BautizoService() {
        super(Bautizo.class);
    }
    
}


