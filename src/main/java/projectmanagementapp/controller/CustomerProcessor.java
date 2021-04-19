/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.controller;

import java.util.List;
import projectmanagementapp.util.MyException;
import projectmanagementapp.model.Customer;

/**
 *
 * @author anton
 */
public class CustomerProcessor extends Processor<Customer> {

    @Override
    public List<Customer> getData() {
        return session.createQuery("from Customer ").list();
    }

    @Override
    protected void controlCreate() throws MyException {
        controlIsNameUnique();
        
    }

    @Override
    protected void controlUpdate() throws MyException {
        controlIsNameUnique();
    }

    @Override
    protected void controlDelete() throws MyException {
        controlIsProjectSet();
    }


    
    
        private void controlIsNameUnique() throws MyException{

        var customerList = session
                .createQuery("from Customer c where c.name=:name")
                .setParameter("name", entity.getName())
                .list();

        if(customerList.size() > 0){

            throw new MyException("Customer with that name already exists, name must be unique.");

        }

    }
    

                    private void controlIsProjectSet() throws MyException{

        var boxList = session
                .createQuery("from Project p where p.customer.id=:id")
                .setParameter("id", entity.getId())
                .list();

        if(boxList.size() > 0){

            throw new MyException("That customer has assigned projects and can not to be deleted.");

        }
                
}
                    
}
