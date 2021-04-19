/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagmentapp;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import projectmanagementapp.util.HibernateUtil;
import projectmanagementapp.view.SplashScreen;

/**
 *
 * @author anton
 */
public class Start {
    
    
    
    public static void main(String[] args) {
        new SplashScreen().setVisible(true);
//        Session s = HibernateUtil.getSession();
//        
//        
//        s.close();
        
    }
    
}

        
