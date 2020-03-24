/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.dtos.EventosDto;
import com.iglesia.entities.Evento;
import com.iglesia.entities.Persona;
import com.iglesia.entities.ResponsableEvento;
import com.iglesia.entities.Usuario;
import com.iglesia.enums.TipoBusquedaEnum;
import com.iglesia.enums.TipoRelacionEnum;
import com.iglesia.enums.TipoSacramentoEnum;
import com.iglesia.interfaces.IEvento;
import com.iglesia.services.EventoService;
import com.iglesia.utils.FechasUtils;
import com.iglesia.utils.NumeroALetras;
import com.iglesia.utils.ProjectUtils;
import com.iglesia.utils.RenderCellTable;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author remsf
 */
public class EventoController implements Serializable {

    private Evento selected;
    private List<Evento> items;
    private EventoService eventoService;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private ResponsableEventoController responsableEventoController;
    private EventosDto dtoSelected;

    public EventoController() {
        this.eventoService = new EventoService();
        this.selected = new Evento();
        this.selected.setEstado(true);
        this.selected.setIdUsuario(new Usuario(1));
        this.dtoSelected = new EventosDto();
    }

    public void consultarTodos() {
        this.items = this.eventoService.consultarTodos("select t from Evento t"
                + "inner join fetch t.idLugar lug "
                + "inner join fetch t.idSacerdote sac "
                + "inner join fetch t.idTipoSacramento tipoSacramento "
                + "inner join fetch t.idUsuario usu ");
    }

    public Evento consultarPorId(Integer id) {
        this.selected = this.eventoService.consultarPor("select t from Evento t "
                + "inner join fetch t.idLugar lug "
                + "inner join fetch t.idSacerdote sac "
                + "inner join fetch t.idTipoSacramento tipoSacramento "
                + "inner join fetch t.idUsuario usu "
                + "where t.id=:id",
                "id", id);
        return this.selected;
    }

    public void llenarTablaBusqueda(JTable tabla, Object[] filtro, TipoBusquedaEnum tipo) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        tabla.setDefaultRenderer(Object.class, new RenderCellTable());
        model = ProjectUtils.removeRows(model);
        this.items = this.eventoService.buscarEvento(filtro[0], filtro[1], tipo);
        if (this.items == null) {
            return;
        }
        JButton btnDetail = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/x26-lista.png"),
                "Click para ver detalle del evento");
        JButton btnPrint = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/x26-imprimir.png"),
                "Click para generar reporte");
        JButton btnPrintConstancia = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/x26-ticket.png"),
                "Click para generar constancia");

        Object[] row = new Object[8];
        for (Evento item : this.items) {
            row[0] = item.getId().toString();
            row[1] = this.sdf.format(item.getFecha());
            row[2] = item.getIdLugar().getNombre();
            row[3] = item.getIdSacerdote().getNombres();
            row[4] = item.getIdTipoSacramento().getNombre();
            row[5] = btnDetail;
            row[6] = btnPrint;
            row[7] = item.getIdTipoSacramento().getId() != TipoSacramentoEnum.BODA.getValue() ? btnPrintConstancia : null;
            model.addRow(row);
        }
    }

    public void generarRpt(Evento evento) {
        if (evento.getIdTipoSacramento().getId() == TipoSacramentoEnum.BODA.getValue()) {
            this.generarRptBoda(evento);
        } else if (evento.getIdTipoSacramento().getId() == TipoSacramentoEnum.BAUTIZO.getValue()) {
            this.generarRptBautizo(evento);
        } else if (evento.getIdTipoSacramento().getId() == TipoSacramentoEnum.CONFIRMACION.getValue()) {
            this.generarRptConfirmacion(evento);
        }
    }

    private void generarRptBoda(Evento evento) {
        ReportesController rc = new ReportesController();
        rc.setReporte(this.getClass().getResourceAsStream("/reportes/Matrimonio.jrxml"));
        rc.getParametros().put("id_evento", evento.getId());
        Calendar cal = Calendar.getInstance();
        cal.setTime(evento.getFecha());

        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();
        ;
        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("dias del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        rc.getParametros().put("fecha_evento", fecha_evento);
        rc.getParametros().put("fecha_emision", fecha_emision);
        rc.generarRepote();
    }

    private void generarRptBautizo(Evento evento) {
        ReportesController rc = new ReportesController();
        this.responsableEventoController = new ResponsableEventoController();
        this.responsableEventoController.consultarReponsablesPorEvento(evento.getId());
        Persona persona = null;
        for (ResponsableEvento item : this.responsableEventoController.getItems()) {
            if (item.getIdRelacion().getId() == TipoRelacionEnum.SACRAMENTADO.getValue()) {
                persona = item.getIdPersona();
                break;
            }
        }
        if (persona == null) {
            System.out.println("no se encontro persona relacionada");
            return;
        }
        rc.setReporte(this.getClass().getResourceAsStream("/reportes/Bautizo.jrxml"));
        rc.getParametros().put("id_evento", evento.getId());
        Calendar cal = Calendar.getInstance();
        cal.setTime(persona.getFechaNacimiento());

        String fecha_nacimiento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        cal.setTime(evento.getFecha());
        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("dias del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        rc.getParametros().put("fecha_nacimiento", fecha_nacimiento);
        rc.getParametros().put("fecha_evento", fecha_evento);
        rc.getParametros().put("fecha_emision", fecha_emision);
        rc.generarRepote();

    }

    private void generarRptConfirmacion(Evento evento) {
        ReportesController rc = new ReportesController();
        this.responsableEventoController = new ResponsableEventoController();
        this.responsableEventoController.consultarReponsablesPorEvento(evento.getId());
        Persona persona = null;
        for (ResponsableEvento item : this.responsableEventoController.getItems()) {
            if (item.getIdRelacion().getId() == TipoRelacionEnum.SACRAMENTADO.getValue()) {
                persona = item.getIdPersona();
                break;
            }
        }
        if (persona == null) {
            System.out.println("no se encontro persona relacionada");
            return;
        }
        rc.setReporte(this.getClass().getResourceAsStream("/reportes/Confirmacion.jrxml"));
        rc.getParametros().put("id_evento", evento.getId());
        Calendar cal = Calendar.getInstance();
        cal.setTime(persona.getFechaNacimiento());

        String fecha_nacimiento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        cal.setTime(evento.getFecha());
        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("dias del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        rc.getParametros().put("fecha_nacimiento", fecha_nacimiento);
        rc.getParametros().put("fecha_evento", fecha_evento);
        rc.getParametros().put("fecha_emision", fecha_emision);
        rc.generarRepote();
    }

    public void generarRptConstancia(Evento evento) {
        ReportesController rc = new ReportesController();
        this.responsableEventoController = new ResponsableEventoController();
        this.responsableEventoController.consultarReponsablesPorEvento(evento.getId());
        Persona persona = null;
        for (ResponsableEvento item : this.responsableEventoController.getItems()) {
            if (item.getIdRelacion().getId() == TipoRelacionEnum.SACRAMENTADO.getValue()) {
                persona = item.getIdPersona();
                break;
            }
        }
        if (persona == null) {
            System.out.println("no se encontro persona relacionada");
            return;
        }
        rc.setReporte(this.getClass().getResourceAsStream("/reportes/Constancia.jrxml"));
        rc.getParametros().put("id_evento", evento.getId());
        Calendar cal = Calendar.getInstance();
        cal.setTime(persona.getFechaNacimiento());

        String fecha_nacimiento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        cal.setTime(evento.getFecha());
        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.DATE))).toLowerCase())
                .append("dias del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.cantidadConLetra(String.valueOf(cal.get(Calendar.YEAR))).trim().toLowerCase()).toString();

        rc.getParametros().put("fecha_nacimiento", fecha_nacimiento);
        rc.getParametros().put("fecha_evento", fecha_evento);
        rc.getParametros().put("fecha_emision", fecha_emision);
        rc.generarRepote();
    }

    public boolean registrarEvento(IEvento evento) {
        return evento.registrar(this.dtoSelected);
    }

    //<editor-fold defaultstate="collapsed" desc="getters & setters">
    public Evento getSelected() {
        return selected;
    }

    public void setSelected(Evento selected) {
        this.selected = selected;
    }

    public List<Evento> getItems() {
        return items;
    }

    public void setItems(List<Evento> items) {
        this.items = items;
    }

    public EventosDto getDtoSelected() {
        return dtoSelected;
    }

    public void setDtoSelected(EventosDto dtoSelected) {
        this.dtoSelected = dtoSelected;
    }
    //</editor-fold>

}
