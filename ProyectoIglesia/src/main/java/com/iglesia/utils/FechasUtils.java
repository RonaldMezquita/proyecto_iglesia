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
}

