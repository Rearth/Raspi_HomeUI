/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rearth.raspi_HomeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import rearth.raspi_HomeUI.Helpers.Weather;
import rearth.raspi_HomeUI.Helpers.Fitness;

/**
 *
 * @author Darkp
 */
public class HomeUI_main extends javax.swing.JFrame {

    final String MONTHS[] ={"Nichts", "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    final String TAGE[] = {null, "Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
    int numOfUpdates = 0;
    int quarters = 0;
    
    
    private void firstInit() {
        System.out.println(" ----------------- Initialising --------------------");
        int date[] = rearth.raspi_HomeUI.Helpers.TimeService.getDate();
        int time[] = rearth.raspi_HomeUI.Helpers.TimeService.getTime();
        displayTime(date, time);
        Weather.updateWeather();
        Weather.showWeather(TemperaturLabel, Regenlabel, LuftLabel, WindLabel, OrtsLabel, WolkenLabel);
        Fitness.init();
        JLabel Labels[] = {ActivityData1, ActivityData2, ActivityData3, ActivityData4, ActivityData5};
        Fitness.updatePanels(Labels);
        
        System.out.println(" --------- Starting up periodic Funktions ----------");
        HalfMinTasks();
        QuarterHourTasks();
        
        System.out.println(" --------------------- All Done --------------------");
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
            int Date[] = {18, 8, 2016};
            Fitness.AddActivity("workout", "long", Date);
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
        
        int dayofWeek = rearth.raspi_HomeUI.Helpers.TimeService.getDayOfWeek();
        
        TimeDisplay.setText("<html><span style='font-size:45px'><font face=\"verdana\"><b></" + time + "</b></font></span><br><font size=\"5\">" + TAGE[dayofWeek] + ", " + day + "." + MONTHS[Date[1]] + "</font></html>");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TimeDisplay = new javax.swing.JLabel();
        WeatherPanel = new javax.swing.JPanel();
        LuftLabel = new javax.swing.JLabel();
        Regenlabel = new javax.swing.JLabel();
        TemperaturLabel = new javax.swing.JLabel();
        WindLabel = new javax.swing.JLabel();
        WolkenLabel = new javax.swing.JLabel();
        OrtsLabel = new javax.swing.JLabel();
        FitnessPanel = new javax.swing.JPanel();
        ActivityData1 = new javax.swing.JLabel();
        ActivityData2 = new javax.swing.JLabel();
        ActivityData3 = new javax.swing.JLabel();
        ActivityData4 = new javax.swing.JLabel();
        ActivityData5 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();

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

        LuftLabel.setText("Luftfeuchte");

        Regenlabel.setText("Regen%");

        TemperaturLabel.setText("Temperatur");

        WindLabel.setText("Wind");

        WolkenLabel.setText("Wolkenstatus");

        OrtsLabel.setText("Ort");

        javax.swing.GroupLayout WeatherPanelLayout = new javax.swing.GroupLayout(WeatherPanel);
        WeatherPanel.setLayout(WeatherPanelLayout);
        WeatherPanelLayout.setHorizontalGroup(
            WeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WeatherPanelLayout.createSequentialGroup()
                .addGroup(WeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WeatherPanelLayout.createSequentialGroup()
                        .addComponent(TemperaturLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(WeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Regenlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LuftLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(WindLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(WeatherPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(WeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WeatherPanelLayout.createSequentialGroup()
                                .addComponent(WolkenLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WeatherPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(OrtsLabel)))))
                .addContainerGap())
        );
        WeatherPanelLayout.setVerticalGroup(
            WeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WeatherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WeatherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(WeatherPanelLayout.createSequentialGroup()
                        .addComponent(Regenlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LuftLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(WindLabel))
                    .addComponent(TemperaturLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OrtsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WolkenLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FitnessPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ActivityData1.setText("jLabel2");
        ActivityData1.setFocusable(false);
        FitnessPanel.add(ActivityData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 201, 47));

        ActivityData2.setText("jLabel3");
        FitnessPanel.add(ActivityData2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 64, 201, 50));

        ActivityData3.setText("jLabel4");
        FitnessPanel.add(ActivityData3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 201, 51));

        ActivityData4.setText("jLabel5");
        FitnessPanel.add(ActivityData4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 177, 201, 49));

        ActivityData5.setText("jLabel6");
        FitnessPanel.add(ActivityData5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 232, 201, 39));

        jToggleButton1.setText("Workout");
        jToggleButton1.setFocusable(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 80, -1));

        jToggleButton2.setSelected(true);
        jToggleButton2.setText("Joggen");
        jToggleButton2.setFocusable(false);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 70, -1));

        jToggleButton3.setText("Radeln");
        jToggleButton3.setFocusable(false);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 70, -1));

        jToggleButton5.setSelected(true);
        jToggleButton5.setText("Mittel");
        jToggleButton5.setFocusable(false);
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 70, -1));

        jToggleButton6.setText("Kurz");
        jToggleButton6.setFocusable(false);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 70, -1));

        jToggleButton4.setText("Lang");
        jToggleButton4.setFocusable(false);
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 80, -1));

        jToggleButton7.setSelected(true);
        jToggleButton7.setText("Heute");
        jToggleButton7.setFocusable(false);
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 110, -1));

        jToggleButton8.setText("Gestern");
        jToggleButton8.setFocusable(false);
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jToggleButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, -1));

        jButton2.setText("Add!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        FitnessPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 110, 40));

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
                .addComponent(WeatherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FitnessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TimeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(WeatherPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(FitnessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        TimeDisplay.getAccessibleContext().setAccessibleName("Timename");
        TimeDisplay.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    String SelectedType = "running";
    String SelectedLength = "medium";
    String SelectedDay = "Today";
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        jToggleButton1.setSelected(true);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        
        SelectedType = "workout";
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        jToggleButton1.setSelected(false);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(true);
        
        SelectedType = "bike";
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        jToggleButton1.setSelected(false);
        jToggleButton2.setSelected(true);
        jToggleButton3.setSelected(false);
        
        SelectedType = "running";
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(true);   
        
        SelectedLength = "short";
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(true);
        jToggleButton6.setSelected(false);   
        
        SelectedLength = "medium";
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        jToggleButton4.setSelected(true);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);   
        
        SelectedLength = "long";
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        // TODO add your handling code here:
        jToggleButton7.setSelected(true);
        jToggleButton8.setSelected(false);
        
        SelectedDay = "Today";
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        // TODO add your handling code here:
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(true);
        
        SelectedDay = "Yesterday";
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int Date[] = rearth.raspi_HomeUI.Helpers.TimeService.getDate();
        if (SelectedDay == "Yesterday") {
            Date[0] -= 1;
        }
        Fitness.AddActivity(SelectedType, SelectedLength, Date);
        
        JLabel Labels[] = {ActivityData1, ActivityData2, ActivityData3, ActivityData4, ActivityData5};
        Fitness.updatePanels(Labels);
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JLabel ActivityData1;
    private javax.swing.JLabel ActivityData2;
    private javax.swing.JLabel ActivityData3;
    private javax.swing.JLabel ActivityData4;
    private javax.swing.JLabel ActivityData5;
    private javax.swing.JPanel FitnessPanel;
    private javax.swing.JLabel LuftLabel;
    private javax.swing.JLabel OrtsLabel;
    private javax.swing.JLabel Regenlabel;
    private javax.swing.JLabel TemperaturLabel;
    private javax.swing.JLabel TimeDisplay;
    private javax.swing.JPanel WeatherPanel;
    private javax.swing.JLabel WindLabel;
    private javax.swing.JLabel WolkenLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    // End of variables declaration//GEN-END:variables
}
