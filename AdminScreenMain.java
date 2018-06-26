/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.model.Account;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class AdminScreenMain extends JFrame {
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
     private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
     private javax.swing.JButton jButton1;
    
    public AdminScreenMain()
    {
        addComponents();
        setVisible(true);
        setSize(800,600);
    }
    private void addComponents()
    { jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem4 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        
        
        jTable1.setVisible(false);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jButton1.setText("logout");
        jButton1.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new LoginPage();
        }
            
        });
        

        jMenu1.setText("File");

        jMenuItem1.setText("Book Patient Appointment");
        jMenu1.add(jMenuItem1);
        
        jMenuItem1.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            BookApptMain bam=new BookApptMain();
            bam=null;
        }
            
        });

        jMenuItem2.setText("Cancel Appointment");
       
        jMenu1.add(jMenuItem2);
        jMenuItem2.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            CancelApptMain cam = new CancelApptMain();
            cam= null;
        }
            
        });

        jMenuItem3.setText("Search Patient information");
        jMenu1.add(jMenuItem3);
        jMenuBar1.add(jMenu1);
        jMenuItem3.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            FetchDataMain fd =  new FetchDataMain();
            //fd=null;
            
        }
            
        });

        

        jMenu2.setText("Report");

        jMenuItem4.setText("View All Today Appointment");
        jMenu2.add(jMenuItem4);
        jMenuItem4.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
               
               
                
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
                jScrollPane1.setViewportView(jTable1);
                jTable1.setVisible(true);
                fetchPatient();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        });

        jMenuItem5.setText("View All Tomorrow's Appointment");
        jMenu2.add(jMenuItem5);
        jMenuItem5.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            try { 
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
               
               
                
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
                jScrollPane1.setViewportView(jTable1);
                jTable1.setVisible(true);
                fetchPatientTomorrow();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminScreenMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        });

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
       
    }// </editor-fold>                        

     private void fetchPatient() throws ClassNotFoundException, SQLException{
         Account a= new Account();
         ResultSet rst=a.fetchPatient();
         jTable1.setModel(DbUtils.resultSetToTableModel(rst));
     }
     private void fetchPatientTomorrow() throws ClassNotFoundException, SQLException{
         Account a= new Account();
         ResultSet rst=a.fetchPatientTomorrow();
         jTable1.setModel(DbUtils.resultSetToTableModel(rst));
     }
    }

