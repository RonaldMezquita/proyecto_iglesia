package com.iglesia.controllers;

import com.iglesia.dtos.EventosDto;
import com.iglesia.entities.Evento;
import com.iglesia.entities.Relacion;
import com.iglesia.entities.ResponsableEvento;
import com.iglesia.entities.TipoSacramentos;
import com.iglesia.enums.TipoRelacionEnum;
import com.iglesia.enums.TipoRelacionValorEnum;
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
                resEve.setIdLugarBautizo(data.getLugarBautizo());
                resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.SACRAMENTADO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // padrino
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdPersona(data.getPadrino());
                resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.PADRINO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                // madrina
                resEve = new ResponsableEvento();
                resEve.setEstado(true);
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setIdPersona(data.getMadrina());
                resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.MADRINA.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);

                return this.service.registrarEvento(evento, resLst);
            } catch (Exception e) {
                System.out.println("[ConfirmacionController][registrar]->error=" + e.getMessage());
            }
        } else {
            System.out.println("[ConfirmacionController][registrar]->Ocurrio un error al registrar la confirmación");
        }
        return false;
    }

    @Override
    public boolean actualizar(EventosDto data) {
        if (data != null) {
            try {
                Evento evento = new Evento();
                List<ResponsableEvento> resLst = new ArrayList<>();
                data.setTipoSacramento(new TipoSacramentos(TipoSacramentoEnum.CONFIRMACION.getValue()));
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
                resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.SACRAMENTADO));
                resEve.setEstado(true);
                resEve.setIdEvento(data.getEvento());
                resEve.setFechaCreacion(evento.getFechaCreacion());
                resEve.setFechaActualizacion(evento.getFechaActualizacion());
                resEve.setIdMadre(data.getMadreSacramentado());
                resEve.setIdPadre(data.getPadreSacramentado());
                resEve.setIdPersona(data.getSacramentado());
                resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.SACRAMENTADO.getValue()));
                resEve.setIdUsuario(data.getUsuario());
                resLst.add(resEve);
                

                // padrino
                if (data.getPadrino() != null) {
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.PADRINO));
                    resEve.setIdEvento(data.getEvento());
                    resEve.setEstado(true);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdPersona(data.getPadrino());
                    resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.PADRINO.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                } else if (data.getPadrino() == null && data.getRelacionMap().containsKey(TipoRelacionEnum.PADRINO)) {
                    // el registro del padrino existia pero fue eliminado, entonces solo se cambiara el estado a false
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.PADRINO));
                    resEve.setIdEvento(data.getEvento());
                    resEve.setEstado(false);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.PADRINO.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                }

                // madrina
                if (data.getMadrina() != null) {
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.MADRINA));
                    resEve.setIdEvento(data.getEvento());
                    resEve.setEstado(true);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdPersona(data.getMadrina());
                    resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.MADRINA.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                } else if (data.getMadrina() == null && data.getRelacionMap().containsKey(TipoRelacionEnum.MADRINA)) {
                    // el registro de la madrina existia pero fue eliminado, entonces solo se cambiara el estado a false
                    resEve = new ResponsableEvento();
                    resEve.setId(data.getRelacionMap().get(TipoRelacionEnum.MADRINA));
                    resEve.setIdEvento(data.getEvento());
                    resEve.setEstado(false);
                    resEve.setFechaCreacion(evento.getFechaCreacion());
                    resEve.setFechaActualizacion(evento.getFechaActualizacion());
                    resEve.setIdRelacion(new Relacion(TipoRelacionValorEnum.MADRINA.getValue()));
                    resEve.setIdUsuario(data.getUsuario());
                    resLst.add(resEve);
                }

                return this.service.actualizarEvento(evento, resLst);
            } catch (Exception e) {
                System.out.println("[ConfirmacionController][actualizar]->error=" + e.getMessage());
            }
        } else {
            System.out.println("[ConfirmacionController][actualizar]->Ocurrio un error al actualizar la confirmación");
        }
        return false;
    }

}
