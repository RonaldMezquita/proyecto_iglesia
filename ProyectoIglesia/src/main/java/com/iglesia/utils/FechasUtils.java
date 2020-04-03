/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author remsf
 */
public class FechasUtils {

    /**
     * Retorna la fecha actual en formato util.Date
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar time = Calendar.getInstance();
        time.add(Calendar.DAY_OF_MONTH, 0);
        return time.getTime();
    }

    /**
     * Retorna la cantidad de años transcurridos entre dos fechas
     *
     * @param firstDate
     * @param secondDate
     * @return
     * @throws IOException
     */
    public static int yearsBetween(Date firstDate, Date secondDate) throws IOException {
        if (firstDate != null && secondDate != null) {
            LocalDate f1 = firstDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate f2 = secondDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period pr = Period.between(f1, f2);
            return pr.getYears();
        }
        return 0;
    }

    /**
     * Retorna el nombre del mes ingresado en formato de enteros
     *
     * @param mes
     * @return
     */
    public static String getMonthName(Integer mes) {
        StringBuilder monthName = new StringBuilder();
        switch (mes) {
            case 1:
                monthName.append("Enero");
                break;
            case 2:
                monthName.append("Febrero");
                break;
            case 3:
                monthName.append("Marzo");
                break;
            case 4:
                monthName.append("Abril");
                break;
            case 5:
                monthName.append("Mayo");
                break;
            case 6:
                monthName.append("Junio");
                break;
            case 7:
                monthName.append("Julio");
                break;
            case 8:
                monthName.append("Agosto");
                break;
            case 9:
                monthName.append("Septiembre");
                break;
            case 10:
                monthName.append("Octubre");
                break;
            case 11:
                monthName.append("Noviembre");
                break;
            case 12:
                monthName.append("Diciembre");
                break;
        }
        return monthName.toString();
    }

    public static int calcularEdad(Date fechaNacimiento) {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);

        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        // Hay que comprobar si el día de su cumpleaños es posterior
        // a la fecha actual, para restar 1 a la diferencia de años,
        // pues aún no ha sido su cumpleaños.
        if (months < 0 // Aún no es el mes de su cumpleaños
                || (months == 0 && days < 0)) { // o es el mes pero no ha llegado el día.
            years--;
        }
        return years;
    }

    /**
     * Metodo para <b>sumar</b> o <b>restar</b> dias a una fecha
     *
     * @param dateToOperate Fecha sobre la cual se va a operar
     * @param numDays Numero de dias a operar(si es negativo se realiza una
     * resta de los dias especificados sino se realiza una suma)
     * @return
     */
    public static Date operateDate(Date dateToOperate, Integer numDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateToOperate);
        cal.add(Calendar.DAY_OF_YEAR, numDays);
        return cal.getTime();
    }
}
