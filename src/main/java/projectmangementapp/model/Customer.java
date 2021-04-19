/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmangementapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anton
 */
@Entity
public class Customer extends Entities {
   
    @NotNull
    @NotEmpty
    @Size(max = 20, message = "Customer name can be maximally 20 characters.")
    private String name;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String country;
    @NotNull(message = "An email is required.")
    @NotEmpty(message = "An email is required.")
    @Email(message = "Invalid email")
    private String email;
    @OneToOne
    private ContactPerson contact;
    @OneToMany(mappedBy = "customer")
    private List<Project>projects= new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public ContactPerson getContact() {
        return contact;
    }

    public void setContact(ContactPerson contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
    
    
}
