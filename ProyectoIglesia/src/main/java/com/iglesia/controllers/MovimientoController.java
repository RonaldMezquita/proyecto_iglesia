/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.entities.Movimiento;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.enums.TipoMovimientoEnum;
import com.iglesia.services.MovimientoService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.RenderCellTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author remsf
 */
public class MovimientoController {
    
    private Movimiento selected;
    private List<Movimiento> items;
    private MovimientoService movimientoService;
    private List<TipoMovimientoEnum> tipoMovLst;
    
    public MovimientoController() {
        this.movimientoService = new MovimientoService();
        this.selected = new Movimiento();
        this.items = new ArrayList<>();        
        this.tipoMovLst = Arrays.asList(TipoMovimientoEnum.values());
    }
    
    public void consultarTodos() {
        this.items = this.movimientoService.consultarTodos("select t from Movimiento t "
                + "left join fetch t.idEvento evento "
                + "left join fetch t.idJustificacion justi");
    }
    
    public Movimiento consultarPorId(Integer idMovimiento) {
        return this.movimientoService.consultarPor("select t from Movimiento t "
                + "left join fetch t.idEvento evento "
                + "left join fetch t.idJustificacion justi "
                + "where t.id=:idMov", "idMov", idMovimiento);
    }

//    public void llenarTabla(JTable tabla, Object[] filtro, TipoBusquedaEnum tipo) {
//        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
//        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
//        model = ProjectUtils.removeRows(model);
//        this.items = this.movimientoService.consultarMovimientos(filtro, tipo);
//        if (this.items == null) {
//            return;
//        }
//        JButton btnDetail = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/detalle.png"),
//                "Click para ver detalle del evento");
//        JButton btnPrint = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/imprimir.png"),
//                "Click para generar reporte");
//        JButton btnPrintConstancia = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/archivo.png"),
//                "Click para generar constancia");
//
//        Object[] row = new Object[6];
//        for (Movimiento item : this.items) {
//            row[0] = item.getId().toString();
//            row[1] = ProjectUtils.formatearFecha(item.getFechaMov());
//            row[2] = ProjectUtils.formatearMoneda(item.getMonto());
//            row[3] = item.getTipo();
//            row[4] = item.getIdEvento() != null ? item.getIdEvento().getIdTipoSacramento().getNombre() : null;
//            row[5] = item.getIdJustificacion().getNombre();
//            model.addRow(row);
//        }
//    }
    public void llenarTablaConsulta(JTable tabla, Object[] filtro, TipoBusquedaEnum tipo) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
        model = ProjectUtils.removeRows(model);
        this.items = this.movimientoService.consultarMovimientos(filtro, tipo);
        if (this.items == null) {
            return;
        }
        JButton btnSeleccionar = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/seleccionar.png"),
                "Click para seleccionar un movimiento");
        JButton btnPrint = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/imprimir.png"),
                "Click para generar reporte");
        JButton btnPrintConstancia = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/archivo.png"),
                "Click para generar constancia");
        
        Object[] row = new Object[7];
        for (Movimiento item : this.items) {
            row[0] = item.getId().toString();
            row[1] = ProjectUtils.formatearFecha(item.getFechaMov());
            row[2] = ProjectUtils.formatearMoneda(item.getMonto());
            row[3] = item.getTipo();
            row[4] = item.getIdEvento() != null ? item.getIdEvento().getIdTipoSacramento().getNombre() : null;
            row[5] = item.getIdJustificacion().getNombre();
            row[6] = btnSeleccionar;
            model.addRow(row);
        }
    }
    
    public boolean crear() {
        boolean response = false;
        if (this.selected == null) {
            System.out.println("[MovimientoController][crear]->No hay una instancia creada de tipo movimiento");
            return response;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        this.selected.setIdUsuario(new Usuario(1));
        try {
            if (this.movimientoService.crear(this.selected) != null) {
                response = true;
            }
        } catch (Exception e) {
            System.out.println("[MovimientoController][crear]->excepcion: " + e.getMessage());
        }
        return response;
    }
    
    public boolean actualizar() {
        boolean response = false;
        if (this.selected == null) {
            System.out.println("[MovimientoController][actualizar]->No hay una instancia creada de tipo movimiento");
            return response;
        }
        this.selected.setFechaCreacion(FechasUtils.getCurrentDate());
        try {
            if (this.movimientoService.actualizar(this.selected) != null) {
                response = true;
            }
        } catch (Exception e) {
            System.out.println("[MovimientoController][actualizar]->excepcion: " + e.getMessage());
        }
        return response;
    }
    
    public void getComboTipoMov(JComboBox<String> combo) {
        combo.addItem("*** Seleccione ***");
        for (TipoMovimientoEnum item : this.tipoMovLst) {
            combo.addItem(item.getValue());
        }
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Movimiento getSelected() {
        return selected;
    }
    
    public void setSelected(Movimiento selected) {
        this.selected = selected;
    }
    
    public List<Movimiento> getItems() {
        return items;
    }
    
    public void setItems(List<Movimiento> items) {
        this.items = items;
    }
    
    public List<TipoMovimientoEnum> getTipoMovLst() {
        return tipoMovLst;
    }
    
    public void setTipoMovLst(List<TipoMovimientoEnum> tipoMovLst) {
        this.tipoMovLst = tipoMovLst;
    }
    //</editor-fold>
}
