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
public class ConfirmacionController implements IEvento{

    private final ResponsableEventoService service;

    public ConfirmacionController() {
        this.service = new ResponsableEventoService();
    }

    @Override
    public boolean registrar(EventosDto data) {
        if (data != null) {
            try {
                Evento evento = new Evento();
                List<ResponsableEvento> resLst = new ArrayList<>();
                data.setTipoSacramento(new TipoSacramentos(TipoSacramentoEnum.CONFIRMACION.getValue()));
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

                // sacramentado
                ResponsableEvento resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdMadre(data.getMadreSacramentado());
                resEve.setIdPadre(data.getPadreSacramentado());
                resEve.setIdPersona(data.getSacramentado());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.SACRAMENTADO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // padrino
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdPersona(data.getPadrino());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.PADRINO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // madrina
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdPersona(data.getMadrina());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.MADRINA.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                return this.service.registrarEvento(evento, resLst);
            } catch (Exception e) {
                System.out.println("[ConfirmacionController][registrar]->error=" + e.getMessage());
            }
        } else {
            System.out.println("[ConfirmacionController][registrar]->Ocurrio un error al registrar la bautizo");
        }
        return false;
    }

}
