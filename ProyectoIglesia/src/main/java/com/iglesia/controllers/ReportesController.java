/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.controllers;

import com.iglesia.utils.Conexion;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alexis
 */
public class ReportesController {

    private Conexion con;
    private Map parametros;
    private InputStream reporte;

    public ReportesController() {
        this.con = new Conexion();
        this.parametros = new HashMap<String, Object>();
    }

    public void generarRepotemain() {
        java.util.Locale locale = new Locale("es", "CL");
        try {

            JasperReport jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("/reportes/Matrimonio.jrxml"));
            Map parametro = new HashMap<String, Date>();

            parametro.put("id_evento", 1);
            parametro.put("fecha_evento", "asdfasdfa");
            parametro.put("fecha_emision", "fsdfsdf");
//            parametro.put(JRParameter.REPORT_LOCALE, locale);

            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, this.con.getConexion());
//            JasperViewer jv = new JasperViewer(jp, false);            
            JasperViewer.viewReport(jp, false);
//            jv.show();

            //  JasperPrintManager.printReport(jp, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(rootPane, "error" + e);
        }
    }

    public void generarRepote() {
        java.util.Locale locale = new Locale("es", "CL");
        try {
            JasperReport jr = JasperCompileManager.compileReport(this.reporte);
            JasperPrint jp = JasperFillManager.fillReport(jr, this.parametros, this.con.getConexion());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            System.out.println(e.getMessage());
        }
    }

    public Map getParametros() {
        return parametros;
    }

    public void setParametros(Map parametros) {
        this.parametros = parametros;
    }

    public InputStream getReporte() {
        return reporte;
    }

    public void setReporte(InputStream reporte) {
        this.reporte = reporte;
    }
    
    
}
