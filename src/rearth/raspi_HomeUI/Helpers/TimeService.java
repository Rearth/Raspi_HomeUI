/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearth.raspi_HomeUI.Helpers;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Darkp
 */
public class TimeService {
    
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
    
    public static int getDayOfWeek(int[] Date) {              //starting at 1 = Sonntag; 7 = Samstag
        
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
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
    
}
