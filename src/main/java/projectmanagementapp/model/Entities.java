/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Korisnik
 */
@MappedSuperclass
public abstract class Entities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @ManyToOne
//    private Employee inputAdmin;
//    
//    @ManyToOne
//    private Employee changeAdmin;
//
//    private Date inputDate;
//    private Date changeDate;
//    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Employee getInputAdmin() {
//        return inputAdmin;
//    }
//
//    public void setInputAdmin(Employee inputAdmin) {
//        this.inputAdmin = inputAdmin;
//    }
//
//    public Employee getChangeAdmin() {
//        return changeAdmin;
//    }
//
//    public void setChangeAdmin(Employee changeAdmin) {
//        this.changeAdmin = changeAdmin;
//    }
//
//    public Date getInputDate() {
//        return inputDate;
//    }
//
//    public void setInputDate(Date inputDate) {
//        this.inputDate = inputDate;
//    }
//
//    public Date getChangeDate() {
//        return changeDate;
//    }
//
//    public void setChangeDate(Date changeDate) {
//        this.changeDate = changeDate;
//    }
    
    
    

    
    
    
}
