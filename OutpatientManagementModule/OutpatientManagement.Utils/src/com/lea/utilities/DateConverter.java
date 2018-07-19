/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lea
 */
public class DateConverter {
    
    private static final DateFormat DB_DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat PRESENTATION_DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    private DateConverter() {
    }
    
    public static Date databaseToPresentation(Date date) throws ParseException {
        String other = DB_DATEFORMAT.format(date);
        return PRESENTATION_DATEFORMAT.parse(other);
    }
    
    public static Date presentationToDatabase(Date date) throws ParseException {
        String other = PRESENTATION_DATEFORMAT.format(date);
        return DB_DATEFORMAT.parse(other);
    }
    
    public static Date getDateFromString(String date) throws ParseException {
        return PRESENTATION_DATEFORMAT.parse(date);
    }
    
    public static String getStringFromDate(Date date) {
        return PRESENTATION_DATEFORMAT.format(date);
    }
}
