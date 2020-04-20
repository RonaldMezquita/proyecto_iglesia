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
public class BautizoController implements IEvento {

    private final ResponsableEventoService service;

    public BautizoController() {
        this.service = new ResponsableEventoService();
    }

    @Override
    public boolean registrar(EventosDto data) {
        if (data != null) {
            try {
                Evento evento = new Evento();
                List<ResponsableEvento> resLst = new ArrayList<>();
                data.setTipoSacramento(new TipoSacramentos(TipoSacramentoEnum.BAUTIZO.getValue()));
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
                if (data.getPadrino() != null) {
                    resEve = new ResponsableEvento();
                    resEve.setEstado(true);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setIdPersona(data.getPadrino());
                    resEve.setIdRelacion(new Relacion(TipoRelacionEnum.PADRINO.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                }

                // madrina
                if (data.getMadrina() != null) {
                    resEve = new ResponsableEvento();
                    resEve.setEstado(true);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setIdPersona(data.getMadrina());
                    resEve.setIdRelacion(new Relacion(TipoRelacionEnum.MADRINA.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                }

                return this.service.registrarEvento(evento, resLst);
            } catch (Exception e) {
                System.out.println("[BautizoController][registrar]->error=" + e.getMessage());
            }
        } else {
            System.out.println("[BautizoController][registrar]->Ocurrio un error al registrar el bautizo");
        }
        return false;
    }

    @Override
    public boolean actualizar(EventosDto data) {
        if (data != null) {
            try {
                Evento evento = new Evento();
                List<ResponsableEvento> resLst = new ArrayList<>();
                data.setTipoSacramento(new TipoSacramentos(TipoSacramentoEnum.BAUTIZO.getValue()));
                evento.setId(data.getIdEvento());
                evento.setEstado(true);
                evento.setFecha(data.getFecha());
                evento.setFechaCreacion(data.getEvento().getFechaCreacion());
                evento.setFechaActualizacion(FechasUtils.getCurrentDate());
                evento.setFolio(data.getFolio());
                evento.setIdLugar(data.getLugar());
                evento.setIdSacerdote(data.getSacerdote());
                evento.setIdTipoSacramento(data.getTipoSacramento());
                evento.setIdUsuario(data.getUsuario());
                evento.setNumero(data.getNumero());
                evento.setTomo(data.getTomo());

                // sacramentado
                ResponsableEvento resEve = new ResponsableEvento();
                resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.SACRAMENTADO.getValue()));
                resEve.setEstado(true);
                resEve.setIdEvento(new Evento(data.getIdEvento()));
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setFechaActualizacion(evento.getFechaActualizacion());
                resEve.setIdMadre(data.getMadreSacramentado());
                resEve.setIdPadre(data.getPadreSacramentado());
                resEve.setIdPersona(data.getSacramentado());
                resEve.setIdRelacion(new Relacion(TipoRelacionEnum.SACRAMENTADO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // padrino
                if (data.getPadrino() != null) {
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.PADRINO.getValue()));
                    resEve.setIdEvento(new Evento(data.getIdEvento()));
                    resEve.setEstado(true);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdPersona(data.getPadrino());
                    resEve.setIdRelacion(new Relacion(TipoRelacionEnum.PADRINO.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                } else if (data.getPadrino() == null && data.getRelacionMap().containsKey(TipoRelacionEnum.PADRINO.getValue())) {
                    // el registro del padrino existia pero fue eliminado, entonces solo se cambiara el estado a false
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.PADRINO.getValue()));
                    resEve.setIdEvento(new Evento(data.getIdEvento()));
                    resEve.setEstado(false);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdRelacion(new Relacion(TipoRelacionEnum.PADRINO.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                }

                // madrina
                if (data.getMadrina() != null) {
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.MADRINA.getValue()));
                    resEve.setIdEvento(new Evento(data.getIdEvento()));
                    resEve.setEstado(true);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdPersona(data.getMadrina());
                    resEve.setIdRelacion(new Relacion(TipoRelacionEnum.MADRINA.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                } else if (data.getMadrina() == null && data.getRelacionMap().containsKey(TipoRelacionEnum.MADRINA.getValue())) {
                    // el registro de la madrina existia pero fue eliminado, entonces solo se cambiara el estado a false
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.MADRINA.getValue()));
                    resEve.setIdEvento(new Evento(data.getIdEvento()));
                    resEve.setEstado(false);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdRelacion(new Relacion(TipoRelacionEnum.MADRINA.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                }

                return this.service.actualizarEvento(evento, resLst);
            } catch (Exception e) {
                System.out.println("[BautizoController][actualizar]->error=" + e.getMessage());
            }
        } else {
            System.out.println("[BautizoController][actualizar]->Ocurrio un error al actualizar el bautizo");
        }
        return false;
    }

}
