/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.interfaces;

import java.util.List;

/**
 *
 * @author remsf
 */
public interface IBuscable<T> {
    List<T> buscar();
    List<T> buscarPorNombre();
    List<T> buscarPorDui();
}
