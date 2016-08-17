/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearth.raspi_HomeUI.Helpers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

/**
 *
 * @author Darkp
 */
public class Weather {
    
    public static double Temperatur = 20;       //in C°
    public static float Feuchtigkeit = 50;      //in %
    public static float WindSpeed = 1;          //in m/s
    public static float rain = 1;               //in ?
    public static float clouds = 30;            //in %
    public static String Wolken = "Bewölkt";
    
    public static void showWeather(JLabel Temperaturlabel, JLabel Regenlabel, JLabel LuftLabel, JLabel Windlabel, JLabel Ortslabel, JLabel Wolkenlabel) {
        Temperaturlabel.setText("<html><span style='font-size:44px'><font face=\"calibri\">" + Temperatur + "°</font></span></html>");
        Regenlabel.setText(Integer.toString((int)rain) + " %");
        LuftLabel.setText(Integer.toString((int) Feuchtigkeit) + " %");
        Windlabel.setText(Float.toString(WindSpeed) + " m/s");
        Ortslabel.setText("Nagold");
        Wolkenlabel.setText(Wolken);
    }
    
    public static void updateWeather() {
        
        try {
            OpenWeatherMap owm = new OpenWeatherMap("e6bec647009bc6239203ead91b289219");
            CurrentWeather cwd = owm.currentWeatherByCityCode(2867164);
            
            float tempInF = cwd.getMainInstance().getTemperature();
            Feuchtigkeit = cwd.getMainInstance().getHumidity();
            WindSpeed = cwd.getWindInstance().getWindSpeed();
            rain = cwd.getRainInstance().getRain3h();
            clouds = cwd.getCloudsInstance().getPercentageOfClouds();
            
            Temperatur = (((tempInF - 32) / 1.8));
            Temperatur = Math.round(Temperatur*100.)/100;
            
            if(clouds <= 7) {
                Wolken = "Klar";
            } else if (clouds <= 30) {
                Wolken = "Leicht bewölkt";
            } else if (clouds <= 70) {
                Wolken = "Bewölkt";
            } else if (clouds <= 98) {
                Wolken = "Stark bewölkt";
            } else {
                Wolken = "Alien Invasion";
            }
            
            System.out.println("Temperatur: " + Temperatur + " C°");
            System.out.println("Feuchtigkeit: " + Feuchtigkeit + " %");
            System.out.println("Wind: " + WindSpeed + " m/s");
            System.out.println("Regen: " + rain + " mm");
            System.out.println("Wolken: " + clouds + " %");
            System.out.println(Wolken);
            System.out.println(" ------------------ Wetter Done ---------------------");

        } catch (JSONException ex) {
            Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
