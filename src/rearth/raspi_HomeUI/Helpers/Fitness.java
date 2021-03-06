/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearth.raspi_HomeUI.Helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * Fitness Backup Format: 
 * 
running medium 13 08 2016
bike long 14 08 2016
workout short 15 08 2016
bike short 16 08 2016
workout medium 18 08 2016
 * 
 * 
 * @author Darkp
 */
public class Fitness {
    
    public static String[][] Activities = null;
    static int NumOfElements = 0;
    public static String DataFilePath = "Error";
    
    public static void init() {
        
        System.out.println(" ------------------ Init Fitness -------------------");
        
        String folderPath = new File("").getAbsolutePath();
        folderPath = folderPath + "/FitnessData";
        File folder = new File(folderPath);
        
        if(!folder.exists()) {
            folder.mkdir();
            System.out.println("Created FitnessData folder");
        }  
        
        String FitnessDataPath = folderPath + "/Activies.txt";
        DataFilePath = FitnessDataPath;
        
        System.out.println("Path: " + folderPath);
        
        File ActiviesData = new File((FitnessDataPath));
        if (!ActiviesData.exists()) {
            try {
                ActiviesData.createNewFile();
                System.out.println("Created ActiviesData");
            } catch (IOException ex) {
                Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        
        
        BufferedReader in = null;
        String ReadData[] = new String[512];
        
        try {
            in = new BufferedReader(new FileReader(FitnessDataPath));
            String line;
            int curLine = 0;
            
            while((line = in.readLine()) != null) {
                ReadData[curLine] = line;
                //System.out.println(ReadData[curLine]);
                curLine++;
            }   in.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        int i = 0;
        
        while(ReadData[i] != null) {
            i++;
        }
        
        NumOfElements = i;
        
        System.out.println("Fitness-Elemente: " + NumOfElements);
        
        String lastActivities[][] = new String[512][5];       //Aufbaus: 0=type; 1=dauer; 2 3 4: dd MM yyyy
        
        for (int k = 0; k < i; k++) {
            
            String Data[] = new String[i];
            
            try {
                Data = ReadData[k].split("-");
            } catch(java.lang.NullPointerException ex) {
                System.err.println("Komischer Fehler");
            }
            
            lastActivities[k][0] = Data[0];
            lastActivities[k][1] = Data[1];
            lastActivities[k][2] = Data[2];
            lastActivities[k][3] = Data[3];
            lastActivities[k][4] = Data[4];
            //System.out.println(lastActivities[k][0]);
        }
        
        Activities = lastActivities;
        
        
    }
    
    public static void updatePanels(JLabel Labels[]){
        
        int Activity = NumOfElements - 5;
        
        for (int curLabel = 0; curLabel <= 4; curLabel ++, Activity++ ) {
            
            int Datum[] = {Integer.valueOf(Activities[Activity][2]), Integer.valueOf(Activities[Activity][3]), Integer.valueOf(Activities[Activity][4])};
            
            String DateText = rearth.raspi_HomeUI.Helpers.TimeService.getniceFormat(Datum);
            
            Labels[curLabel].setText(getNiceName(Activities[Activity][0]) + DateText);
        }
    
    }
    
    static String getNiceName(String Art) {
        
        String Text = "Unknown";
        
        switch(Art) {
            case "running":
                Text = "Joggen";
                break;
            case "bike":
                Text = "Rad Fahren";
                break;
            case "workout":
                Text = "Workout";
                break;
        }
        
        return Text;
    }
    
    public static void AddActivity(String Type, String length, int Date[]) {
        
        Activities[NumOfElements][0] = Type;
        Activities[NumOfElements][1] = length;
        Activities[NumOfElements][2] = Integer.toString(Date[0]);
        Activities[NumOfElements][3] = Integer.toString(Date[1]);
        Activities[NumOfElements][4] = Integer.toString(Date[2]);
        
        String WriteString = System.getProperty("line.separator") + Type + "-" + length + "-" + Integer.toString(Date[0])+ "-" + Integer.toString(Date[1])+ "-" + Integer.toString(Date[2]);
        
        try {
            Files.write(Paths.get(DataFilePath), WriteString.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*try {
            PrintWriter writer= new PrintWriter(DataFilePath);
            writer.append(WriteString);
            //writer.printf(WriteString);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fitness.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        System.out.println("Added Activity: " + Activities[NumOfElements][0] + Activities[NumOfElements][1] + Activities[NumOfElements][2] + Activities[NumOfElements][3] + Activities[NumOfElements][4]);
        
        NumOfElements++;
    }
    
}
