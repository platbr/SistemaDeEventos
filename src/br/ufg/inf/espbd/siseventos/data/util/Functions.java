/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOAO VICTOR
 */
public class Functions {

    public static Date strToDate(String data) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String dateToStr(Date data) {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }

    public static Timestamp strToTimeStamp(String data) {
        try {
            String oldstring = "2011-01-18 00:00:00.0";
            Timestamp date = (Timestamp) new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(oldstring);
            return date;
        } catch (Exception ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String dateToTimeStamp(Timestamp data) {
        return new SimpleDateFormat("dd/MM/yyyy mm:SS").format(data);
    }

}
