/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.admin.AdminScreenMain;
import com.admin.LoginPage;
import javax.swing.SwingUtilities;

/**
 *
 * @author BINDESH CHITALIA
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                new LoginPage();
                }
            
        });
    }
    
}
