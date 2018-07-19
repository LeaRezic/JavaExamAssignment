/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.console;

import java.util.Date;
import com.lea.utilities.DateConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lea
 */
public class DatesTest {

    public static void main(String[] args) {

        String someDate = "12/12/2001";
        System.out.println("String: " + someDate);

        DateFormat DB_DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat PRESENTATION_DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = DateConverter.getDateFromString(someDate);
            System.out.println("Date: " + date);

            String other = PRESENTATION_DATEFORMAT.format(date);
            System.out.println("String: " + other);
            String newDate = DB_DATEFORMAT.format(date);
            System.out.println("String: " + newDate);

            String otherFormat = DateConverter.getStringFromDate(date);
            System.out.println("String: " + otherFormat);
            
            Date yetAnotherDate = DateConverter.getDateFromString(otherFormat);
            System.out.println("Date: " + yetAnotherDate);

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
