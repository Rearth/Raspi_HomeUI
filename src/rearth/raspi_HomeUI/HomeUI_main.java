/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearth.raspi_HomeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import rearth.raspi_HomeUI.Helpers.Weather;

/**
 *
 * @author Darkp
 */
public class HomeUI_main extends javax.swing.JFrame {

    String MONTHS[] ={"Nichts", "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    String TAGE[] = {null, "Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
    int numOfUpdates = 0;
    int quarters = 0;
    
    
    private void firstInit() {
        System.out.println(" ----------------- Initialising --------------------");
        int date[] = rearth.raspi_HomeUI.Helpers.TimeService.getDate();
        int time[] = rearth.raspi_HomeUI.Helpers.TimeService.getTime();
        displayTime(date, time);
        
        System.out.println(" ---------- Setting up periodic Funktions ----------");
        HalfMinTasks();
        QuarterHourTasks();
        Weather.updateWeather();
        Weather.showWeather(TemperaturLabel);
    }
    
    private void updateTime() {
        
        int date[] = rearth.raspi_HomeUI.Helpers.TimeService.getDate();
        int time[] = rearth.raspi_HomeUI.Helpers.TimeService.getTime();
        displayTime(date, time);
    }
    
    public void HalfMinTasks() {
        
        int delay = 30000; //milliseconds
        
        ActionListener taskPerformer = (ActionEvent evt) -> {
            numOfUpdates++;
            System.out.println(" --------------- 30sec Update #" + Integer.toString(numOfUpdates) + " -------------------");
            updateTime();
        };
        new javax.swing.Timer(delay, taskPerformer).start();
    }
    
    public void QuarterHourTasks() {
        
        int delay = 900000; //milliseconds -> 15 mins
        
        ActionListener taskPerformer = (ActionEvent evt) -> {
            quarters++;
            System.out.println(" --------------- 15min Update #" + Integer.toString(quarters) + " -------------------");
            Weather.updateWeather();
        };
        new javax.swing.Timer(delay, taskPerformer).start();
    }
    
    public HomeUI_main() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
     }
    
    public void displayTime(int Date[], int Time[]) {
        //Zeilenumbruch: "<html>Economy<br>Regularity</html>"
        String day = Integer.toString(Date[0]);
        String time = Integer.toString(Time[0]) + ":" + Integer.toString(Time[1]);
        
        if(Time[0] <= 9) {
            time = "0" + Integer.toString(Time[0]) + ":" + Integer.toString(Time[1]);
        }
        if(Time[1] <= 9) {
            time = Integer.toString(Time[0]) + ":0" + Integer.toString(Time[1]);
        }
        if(Time[0] <= 9 && Time[1] <= 9) {
            time = "0" + Integer.toString(Time[0]) + ":0" + Integer.toString(Time[1]);
        }
        
        int dayofWeek = rearth.raspi_HomeUI.Helpers.TimeService.getDayOfWeek(Date);
        
        TimeDisplay.setText("<html><span style='font-size:40px'><font face=\"verdana\"><b></" + time + "</b></font></span><br><font size=\"5\">" + TAGE[dayofWeek] + ", " + day + "." + MONTHS[Date[1]] + "</font></html>");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TimeDisplay = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LuftFLabel = new javax.swing.JLabel();
        Regenlabel = new javax.swing.JLabel();
        TemperaturLabel = new javax.swing.JLabel();
        WindLabel = new javax.swing.JLabel();
        WolkenLabel = new javax.swing.JLabel();
        OrtsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Hallo Welt!");

        jButton1.setText("End now");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TimeDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeDisplay.setText("Time and Date");
        TimeDisplay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TimeDisplay.setMaximumSize(new java.awt.Dimension(214, 104));
        TimeDisplay.setMinimumSize(new java.awt.Dimension(214, 104));
        TimeDisplay.setName(""); // NOI18N

        LuftFLabel.setText("Luftfeuchte");

        Regenlabel.setText("Regen%");

        TemperaturLabel.setText("Temperatur");

        WindLabel.setText("Wind");

        WolkenLabel.setText("Wolkenstatus");

        OrtsLabel.setText("Ort");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TemperaturLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Regenlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LuftFLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(WindLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(WolkenLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(OrtsLabel)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Regenlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LuftFLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(WindLabel))
                    .addComponent(TemperaturLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OrtsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WolkenLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(TimeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TimeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        TimeDisplay.getAccessibleContext().setAccessibleName("Timename");
        TimeDisplay.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeUI_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeUI_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeUI_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeUI_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            HomeUI_main mainUI;
            mainUI = new HomeUI_main();
            mainUI.setVisible(true);
            mainUI.firstInit();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LuftFLabel;
    private javax.swing.JLabel OrtsLabel;
    private javax.swing.JLabel Regenlabel;
    private javax.swing.JLabel TemperaturLabel;
    private javax.swing.JLabel TimeDisplay;
    private javax.swing.JLabel WindLabel;
    private javax.swing.JLabel WolkenLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
