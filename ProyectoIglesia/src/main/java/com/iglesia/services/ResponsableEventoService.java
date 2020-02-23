/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.services;

import com.iglesia.entities.ResponsableEvento;
import com.iglesia.utils.CrudUtils;

/**
 *
 * @author alexi
 */
public class ResponsableEventoService extends CrudUtils<ResponsableEvento>{

    public ResponsableEventoService() {
        super(ResponsableEvento.class);
    }
    
}


