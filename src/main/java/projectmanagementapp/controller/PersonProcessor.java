/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.controller;

import java.util.List;
import projectmanagementapp.util.MyException;
import projectmangementapp.model.Person;

/**
 *
 * @author anton

 */
public abstract class PersonProcessor<T extends Person> extends Processor<T>{
    
    @Override
    protected void controlCreate() throws MyException {
 
    }

    @Override
    protected void controlUpdate() throws MyException {

    }


    @Override
    protected void controlDelete() throws MyException {
     
    }

    @Override
    public List<T> getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
    

