/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.controller;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import projectmanagementapp.util.MyException;
import projectmangementapp.model.Customer;
import projectmangementapp.model.Employee;

/**
 *
 * @author anton
 */
public class EmployeeProcessor extends PersonProcessor<Employee>{
    
        @Override
    public List<Employee> getData() {
        return session.createQuery("from Employee ").list();
    }

    @Override
    protected void controlCreate() throws MyException {
        super.controlCreate();
        
    }

    @Override
    protected void controlUpdate() throws MyException {
        super.controlUpdate();
    }

    @Override
    protected void controlDelete() throws MyException {
       super.controlDelete();
               
    }
    
        public Employee authorization(String email, char[] password){
       
        Employee user = (Employee)session
                .createQuery("from Employee e where e.email=:email")
                .setParameter("email", email)
                .getSingleResult();
        if(user==null){
            return null;
        }
        return BCrypt.checkpw(new String(password),user.getPassword()) ? user : null;
    }
    
        
//            private boolean oibValid(String oib){
//       
//        
//        
//        if (oib==null || oib.length() != 11) {
//            return false;
//        }
//
//        try {
//            Long.parseLong(oib);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//
//        int a = 10;
//        for (int i = 0; i < 10; i++) {
//            a = a + Integer.parseInt(oib.substring(i, i + 1));
//            a = a % 10;
//            if (a == 0) {
//                a = 10;
//            }
//            a *= 2;
//            a = a % 11;
//        }
//        int control = 11 - a;
//        if (control == 10) {
//            control = 0;
//        }
//        return control == Integer.parseInt(oib.substring(10));
//
//    }
    
}
