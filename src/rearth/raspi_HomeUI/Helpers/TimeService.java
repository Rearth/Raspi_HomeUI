/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearth.raspi_HomeUI.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Darkp
 */
public class TimeService {
    
    final static String MONTHS[] ={"Nichts", "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    final static String TAGE[] = {null, "Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
    
    public static int[] getDate() {
        int date[] = {1, 1, 2016};
        Date rawDate = new Date();
        
        SimpleDateFormat day = new SimpleDateFormat( "dd" );    //dd-MM-yyyy HH:mm:ss
        date[0] = Integer.parseInt(day.format(rawDate));
        
        SimpleDateFormat month = new SimpleDateFormat( "MM" );
        date[1] = Integer.parseInt(month.format(rawDate));
        
        SimpleDateFormat year = new SimpleDateFormat( "yyyy" );
        date[2] = Integer.parseInt(year.format(rawDate));
        
        return date;
    }
    
    public static int getDayOfWeek() {              //starting at 1 = Sonntag; 7 = Samstag
        
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }
    
    static int getDayOfWeekByDate(int Datum[]) {
        
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy" );
        String tag = Integer.toString(Datum[0]);
        if(Datum[0] <= 9) {
            tag = "0" + tag;
        }
        String monat = Integer.toString(Datum[1]);
        if (Datum[1] <= 9) {
            monat = "0" + monat;
        }
        
        String DateString = tag + "/" +  monat + "/" + Integer.toString(Datum[2]);
        try {
            date = format.parse(DateString);
        } catch (ParseException ex) {
            Logger.getLogger(TimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        
        return dayOfWeek;
    }
    
    public static int[] getTime(){
        int time[] = {0, 0};
        
        Date rawDate = new Date();
        SimpleDateFormat hours = new SimpleDateFormat("HH");
        time[0] = Integer.parseInt(hours.format(rawDate));
        
        SimpleDateFormat minutes = new SimpleDateFormat("mm");
        time[1] = Integer.parseInt(minutes.format(rawDate));
        
        return time;
        
    }
    
    public static String getniceFormat(int Datum[]) {
        String Text = "Error";
        
        
        
        if (inLastWeek(Datum)) {
            Text = " am " + TAGE[getDayOfWeekByDate(Datum)];
            if (howLongAgo(Datum) == 0) {
                Text = " Heute";
            } else if (howLongAgo(Datum) == 1) {
                Text = " Gestern";
            } else if (howLongAgo(Datum) == 2) {
                Text = " Vorgestern";
            }
        } else {
            Text = " vor " + Integer.toString(howLongAgo(Datum)) + " Tagen (" + Integer.toString(Datum[0]) + "." + Datum[1] +  ")";
        }
        
        return Text;
    }
    
    static boolean inLastWeek(int date[]) {
        boolean state = false;
        
        int days = howLongAgo(date);
        if (days <= 6) {
            state = true;
        }
        
        return state;
    }
    
    static int howLongAgo(int Datum[]) {
        
        SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy" );
        Date date = new Date();
        
        String Date1 = format.format(date);
        
        String tag = Integer.toString(Datum[0]);
        if(Datum[0] <= 9) {
            tag = "0" + tag;
        }
        String monat = Integer.toString(Datum[1]);
        if (Datum[1] <= 9) {
            monat = "0" + monat;
        }
        
        String Date2 = tag + "/" +  monat + "/" + Integer.toString(Datum[2]);
        
        Date DateObj1 = null;
        Date DateObj2 = null;
        try {
            DateObj1 = format.parse(Date1);
            DateObj2 = format.parse(Date2);
        } catch (ParseException ex) {
            Logger.getLogger(TimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("Date1: " + Date1);
        //System.out.println("Date2: " + Date2);
        
        long difference = DateObj1.getTime() - DateObj2.getTime();
        
        int differenceDays = (int) (difference / (24* 1000 * 60 * 60));

        //System.out.println("Tage: " + differenceDays);
        
        return differenceDays;
    }
    
}
