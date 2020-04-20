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
import java.util.Objects;
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
        JButton btnDetail = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/detalle.png"),
                "Click para ver detalle del evento");
        JButton btnPrint = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/imprimir.png"),
                "Click para generar reporte");
        JButton btnPrintConstancia = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/archivo.png"),
                "Click para generar constancia");
        JButton btnSeleccionar = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/seleccionar.png"),
                "Click para seleccionar evento");
        JButton btnSelectToEdit = ProjectUtils.getButton(this.getClass().getResource("/META-INF/images/icon/editar_black.png"),
                "Click para editar");

        Object[] row = new Object[10];
        for (Evento item : this.items) {
            row[0] = item.getId().toString();
            row[1] = this.sdf.format(item.getFecha());
            row[2] = item.getIdLugar().getNombre();
            row[3] = item.getIdSacerdote().getNombreCompleto();
            row[4] = item.getIdTipoSacramento().getNombre();
            row[5] = btnDetail;
            row[6] = btnPrint;
            row[7] = item.getIdTipoSacramento().getId() != TipoSacramentoEnum.BODA.getValue() ? btnPrintConstancia : null;
            row[8] = btnSelectToEdit;
            row[9] = btnSeleccionar;
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
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();
        ;
        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

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
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append("días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        cal.setTime(evento.getFecha());
        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

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
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        cal.setTime(evento.getFecha());
        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

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
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        cal.setTime(evento.getFecha());
        String fecha_evento = new StringBuilder()
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        cal.setTime(FechasUtils.getCurrentDate());

        String fecha_emision = new StringBuilder("los ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.DATE)))
                .append(" días del mes de ")
                .append(FechasUtils.getMonthName(cal.get(Calendar.MONTH) + 1).toLowerCase()).append(" del año ")
                .append(NumeroALetras.convertirLetras(cal.get(Calendar.YEAR)).trim()).toString();

        String edad_letras = NumeroALetras.convertirLetras(
                FechasUtils.calcularEdad(persona.getFechaNacimiento()));

        rc.getParametros().put("edad_letras", edad_letras);
        rc.getParametros().put("fecha_nacimiento", fecha_nacimiento);
        rc.getParametros().put("fecha_evento", fecha_evento);
        rc.getParametros().put("fecha_emision", fecha_emision);
        rc.generarRepote();
    }

    /**
     * Metodo que carga los datos de un evento en el objeto EventosDto
     *
     * @param idEvento
     */
    public void cargarEvento(Integer idEvento) {
        this.responsableEventoController = new ResponsableEventoController();
        this.responsableEventoController.consultarReponsablesPorEvento(idEvento);
        int contTestigo = 1;        
        for (ResponsableEvento item : this.responsableEventoController.getItems()) {
            if (this.dtoSelected.getIdEvento() == null) {
                this.dtoSelected.setEvento(item.getIdEvento());
                this.dtoSelected.setIdEvento(item.getIdEvento().getId());
                this.dtoSelected.setTomo(item.getIdEvento().getTomo());
                this.dtoSelected.setFolio(item.getIdEvento().getFolio());
                this.dtoSelected.setNumero(item.getIdEvento().getNumero());
                this.dtoSelected.setFecha(item.getIdEvento().getFecha());
                this.dtoSelected.setLugar(item.getIdEvento().getIdLugar());
                this.dtoSelected.setSacerdote(item.getIdEvento().getIdSacerdote());
            }
            // bautizo -confirmación
            if (Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.SACRAMENTADO.getValue())) {
                this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.SACRAMENTADO.getValue(), item.getId());
                this.dtoSelected.setSacramentado((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.SACRAMENTADO.getValue())) ? item.getIdPersona() : null);
                this.dtoSelected.setPadreSacramentado((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.SACRAMENTADO.getValue())) ? item.getIdPadre() : null);
                this.dtoSelected.setMadreSacramentado((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.SACRAMENTADO.getValue())) ? item.getIdMadre() : null);
            } else if (Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.PADRINO.getValue())) {
                this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.PADRINO.getValue(), item.getId());
                this.dtoSelected.setPadrino((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.PADRINO.getValue())) ? item.getIdPersona() : null);
            } else if (Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.MADRINA.getValue())) {
                this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.MADRINA.getValue(), item.getId());
                this.dtoSelected.setMadrina((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.MADRINA.getValue())) ? item.getIdPersona() : null);
            } else if (Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIO.getValue())) { // boda
                this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.NOVIO.getValue(), item.getId());
                this.dtoSelected.setNovio((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIO.getValue())) ? item.getIdPersona() : null);
                this.dtoSelected.setPadreNovio((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIO.getValue())) ? item.getIdPadre() : null);
                this.dtoSelected.setMadreNovio((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIO.getValue())) ? item.getIdMadre() : null);
            } else if (Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIA.getValue())) {
                this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.NOVIA.getValue(), item.getId());
                this.dtoSelected.setNovia((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIA.getValue())) ? item.getIdPersona() : null);
                this.dtoSelected.setPadreNovia((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIA.getValue())) ? item.getIdPadre() : null);
                this.dtoSelected.setMadreNovia((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.NOVIA.getValue())) ? item.getIdMadre() : null);
            } else if (Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.TESTIGO.getValue())) {
                if (contTestigo == 1) {
                    this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.TESTIGO.getValue(), item.getId());
                    this.dtoSelected.setTestigo1((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.TESTIGO.getValue())) ? item.getIdPersona() : null);
                } else {
                    this.dtoSelected.getRelacionMap().put(TipoRelacionEnum.TESTIGO.getValue(), item.getId());
                    this.dtoSelected.setTestigo2((Objects.equals(item.getIdRelacion().getId(), TipoRelacionEnum.TESTIGO.getValue())) ? item.getIdPersona() : null);
                }
                contTestigo++;
            }
        }
    }    

    /**
     * Metodo para registrar los eventos
     *
     * @param evento Clase que implementa la interfaz IEvento
     * @return
     */
    public boolean registrarEvento(IEvento evento) {
        return evento.registrar(this.dtoSelected);
    }
    
    /**
     * Metodo para actualizar los eventos
     *
     * @param evento Clase que implementa la interfaz IEvento
     * @return
     */
    public boolean actualizarEvento(IEvento evento) {
        return evento.actualizar(this.dtoSelected);
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
