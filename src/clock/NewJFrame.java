package clock;

import java.awt.Color;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
//import javafx.embed.swing.JFXPanel;
import java.io.*;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NewJFrame extends javax.swing.JFrame {
    private Timezone tz;
    private Time t;    
    private Date date;
    private Configure config;
    private Color background,text,frame;
    private JFontChooser f;
    private AlarmClock a;
    boolean sendAlarmSig = false;
//    final JFXPanel fxPanel = new JFXPanel();
//    MediaPlayer mediaplayer;
//    Media hit;
    boolean alreadyPlaying = false;
    boolean stopPressed = false;
    int count = 0;
    
    public NewJFrame() {
        
        initComponents(); 
        
        // Set day song
        Timezone tempTz = new Timezone(time_zone);
        Calendar tempCal = new GregorianCalendar(tempTz.getTimeZone());
        String playFile  =  tempCal.get(Calendar.DAY_OF_WEEK) +".mp3" ;
        System.out.println(playFile);
//        hit = new Media(new File(playFile).toURI().toString());
//        mediaplayer = new MediaPlayer(hit);
        // End of block
                
        new Thread()
        {
            public void run()
            {    
                stopAlarm.setVisible(false);
                while(true)
                {
                    tz = new Timezone(time_zone); //get the selected time zone
                    Calendar cal = new GregorianCalendar(tz.getTimeZone()); //get details of that time zone     
                    t = new Time(cal); //get current time
                    clock.setText(t.setTime(jRadioButton24,jRadioButton12)); //set time
                    date = new Date(); //get date
                    date_field.setText(" " + date);//set date                
                    config = new Configure();
                    
                    //Set alarm 
                    if(sendAlarmSig) { 
                        if(a.getStatus()) {                        
                            if(cal.get(Calendar.HOUR) == a.getHour() && cal.get(Calendar.MINUTE) == a.getMin() && cal.get(Calendar.SECOND) == a.getSec() && cal.get(Calendar.AM_PM) == (a.getAMPM()) ) {
                                // Play song
//                                mediaplayer.play();            
                                stopAlarm.setVisible(true);
                            } 
                        }
                    }
                    
                }
            }            
        }.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        clock = new javax.swing.JLabel();
        date_field = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        time_zone = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        stopAlarm = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        text_colour = new javax.swing.JMenuItem();
        frame_colour = new javax.swing.JMenuItem();
        bg_colour = new javax.swing.JMenuItem();
        font_style = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jRadioButton12 = new javax.swing.JRadioButtonMenuItem();
        jRadioButton24 = new javax.swing.JRadioButtonMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(7, 6, 5));

        jPanel1.setBackground(Color.BLACK);

        clock.setFont(new java.awt.Font("DS-Digital", 0, 100)); // NOI18N
        clock.setForeground(new java.awt.Color(0, 153, 255));
        clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 131, 131), 4));

        date_field.setFont(new java.awt.Font("DS-Digital", 1, 24)); // NOI18N
        date_field.setForeground(new java.awt.Color(255, 245, 245));

        jButton2.setFont(new Font("Sitka Text", Font.BOLD, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(31, 7, 7));
        jButton2.setText("SET ALARM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        time_zone.setFont(new java.awt.Font("Noto Sans CJK KR Medium", 3, 15)); // NOI18N
        time_zone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "America/Los_Angeles", "Asia/Colombo", "Canada/Central", "Egypt", "Europe/Berlin", "Greenwich", "IST", "Japan" }));
        time_zone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_zoneActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 242, 242));
        jLabel1.setText("Select time zone");

        stopAlarm.setFont(new Font("Sitka Text", Font.BOLD, 15)); // NOI18N
        stopAlarm.setText("STOP THE ALARM");
        stopAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopAlarmActionPerformed(evt);
            }
        });
        
        JButton btnStopWatch = new JButton("STOP WATCH");
        btnStopWatch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		Stopwatch s = new Stopwatch();
        		s.setVisible(true);
        	}
        });
        btnStopWatch.setFont(new Font("Sitka Text", Font.BOLD, 15));
        
        JButton btnNewButton = new JButton("TIMER");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		GUITimer t = new GUITimer();
        		t.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(93, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(date_field, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
        					.addGap(359))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(45)
        							.addComponent(btnStopWatch)
        							.addPreferredGap(ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
        							.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        							.addGap(191)
        							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jLabel1)
        							.addGap(113)
        							.addComponent(time_zone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(159))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(93)
        							.addComponent(clock, GroupLayout.PREFERRED_SIZE, 822, GroupLayout.PREFERRED_SIZE)))
        					.addContainerGap(133, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(stopAlarm)
        					.addGap(440))))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(29)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(time_zone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(65)
        			.addComponent(clock, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(date_field, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnStopWatch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
        			.addGap(26)
        			.addComponent(stopAlarm)
        			.addGap(96))
        );
        jPanel1.setLayout(jPanel1Layout);

        jButton1.setText("jButton1");

        jMenuBar1.setFont(new java.awt.Font("URW Bookman L", 1, 15)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Digital Clock");
        jMenu1.setFont(new java.awt.Font("Noto Sans CJK KR Medium", 1, 15)); // NOI18N

        text_colour.setText("ClockText colour");
        text_colour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_colourActionPerformed(evt);
            }
        });
        jMenu1.add(text_colour);

        frame_colour.setText("Frame colour");
        frame_colour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frame_colourActionPerformed(evt);
            }
        });
        jMenu1.add(frame_colour);

        bg_colour.setText("Background colour");
        bg_colour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bg_colourActionPerformed(evt);
            }
        });
        jMenu1.add(bg_colour);

        font_style.setText("Font style");
        font_style.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                font_styleActionPerformed(evt);
            }
        });
        jMenu1.add(font_style);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Time Format");
        jMenu3.setFont(new java.awt.Font("Noto Sans CJK TC Medium", 1, 15)); // NOI18N

        buttonGroup1.add(jRadioButton12);
        jRadioButton12.setText("12 hour");
        jMenu3.add(jRadioButton12);

        buttonGroup1.add(jRadioButton24);
        jRadioButton24.setSelected(true);
        jRadioButton24.setText("24 hour");
        jMenu3.add(jRadioButton24);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGap(29)
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bg_colourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bg_colourActionPerformed
        background = config.get_background(bg_colour);
        jPanel1.setBackground(background);
    }//GEN-LAST:event_bg_colourActionPerformed

    private void font_styleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_font_styleActionPerformed
       f = new JFontChooser(this,clock.getFont());
    	f.setVisible(true);
    	if(f.getReturnStatus() == JFontChooser.RET_OK){
    	       clock.setFont(f.getFont());
    	}    	
    	f.dispose();
    }//GEN-LAST:event_font_styleActionPerformed

    private void text_colourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_colourActionPerformed
        text = config.get_text(text_colour);
        clock.setForeground(text);
    }//GEN-LAST:event_text_colourActionPerformed

    private void frame_colourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frame_colourActionPerformed
        frame = config.get_frame(frame_colour);
        clock.setBorder(BorderFactory.createLineBorder(frame));
    }//GEN-LAST:event_frame_colourActionPerformed

    private void time_zoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_zoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_time_zoneActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        a = new AlarmClock();
        a.setVisible(true);
        sendAlarmSig = true;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void stopAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopAlarmActionPerformed
        // TODO add your handling code here:
//        mediaplayer.stop();
        a = new AlarmClock();
        stopAlarm.setVisible(false);
    }//GEN-LAST:event_stopAlarmActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bg_colour;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel date_field;
    private javax.swing.JMenuItem font_style;
    private javax.swing.JMenuItem frame_colour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButton12;
    private javax.swing.JRadioButtonMenuItem jRadioButton24;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JButton stopAlarm;
    private javax.swing.JMenuItem text_colour;
    private javax.swing.JComboBox<String> time_zone;
}
