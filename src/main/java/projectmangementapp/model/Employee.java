/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmangementapp.model;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author anton
 */
@Entity
public class Employee extends Person{
private String iban;
private String password;
private int authorizationLvl;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthorizationLvl() {
        return authorizationLvl;
    }

    public void setAuthorizationLvl(int authorizationLvl) {
        this.authorizationLvl = authorizationLvl;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getName() {
     
        return getFirstName()+ " " + getLastName();
    }


}
    
    

    

