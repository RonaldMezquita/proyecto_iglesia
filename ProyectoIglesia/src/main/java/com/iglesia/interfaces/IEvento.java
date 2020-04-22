package com.iglesia.interfaces;

import com.iglesia.dtos.EventosDto;

/**
 *
 * @author Ronald Mezquita
 */
public interface IEvento {

    boolean registrar(EventosDto data);
    boolean actualizar(EventosDto data);
}
