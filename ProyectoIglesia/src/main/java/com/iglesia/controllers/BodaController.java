/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.dtos.EventosDto;
import com.iglesia.entities.Evento;
import com.iglesia.entities.Relacion;
import com.iglesia.entities.ResponsableEvento;
import com.iglesia.entities.TipoSacramentos;
import com.iglesia.enums.TipoRelacionEnum;
import com.iglesia.enums.TipoSacramentoEnum;
import com.iglesia.interfaces.IEvento;
import com.iglesia.services.ResponsableEventoService;
import com.iglesia.utils.FechasUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald Mezquita
 */
public class BodaController implements IEvento {

    private final ResponsableEventoService service;

    public BodaController() {
        this.service = new ResponsableEventoService();
    }

    @Override
    public boolean registrar(EventosDto data) {
        if (data != null) {
            try {
                Evento evento = new Evento();
                List<ResponsableEvento> resLst = new ArrayList<>();
                data.setTipoSacramento(new TipoSacramentos(TipoSacramentoEnum.BODA.getValue()));
                evento.setEstado(true);
                evento.setFecha(data.getFecha());
                evento.setFechaCreacion(FechasUtils.getCurrentDate());
                evento.setFolio(data.getFolio());
                evento.setIdLugar(data.getLugar());
                evento.setIdSacerdote(data.getSacerdote());
                evento.setIdTipoSacramento(data.getTipoSacramento());
                evento.setIdUsuario(data.getUsuario());
                evento.setNumero(data.getNumero());
                evento.setTomo(data.getTomo());

                // Novio
                ResponsableEvento resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdMadre(data.getMadreNovio());
                resEve.setIdPadre(data.getPadreNovio());
                resEve.setIdPersona(data.getNovio());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.NOVIO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // Novia
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdMadre(data.getMadreNovia());
                resEve.setIdPadre(data.getPadreNovia());
                resEve.setIdPersona(data.getNovia());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.NOVIA.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // Testigo 1
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdPersona(data.getTestigo1());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.TESTIGO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // Testigo 2
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdPersona(data.getTestigo2());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.TESTIGO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                return this.service.registrarEvento(evento, resLst);
            } catch (Exception e) {
                System.out.println("[BodaController][registrarBoda]->error=" + e.getMessage());
            }
        } else {
            System.out.println("[BodaController][registrarBoda]->Ocurrio un error al registrar la boda");
        }
        return false;
    }

    @Override
    public boolean actualizar(EventosDto data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
