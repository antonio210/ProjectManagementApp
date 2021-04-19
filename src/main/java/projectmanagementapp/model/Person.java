/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author anton
 */

@MappedSuperclass
public abstract class Person extends Entities{

    @NotNull(message="First name must be set")
    @NotEmpty(message="First name must not be empty")
    @Size(max = 20, message = "First name is limited to 20 characters.")
    private String firstName;
    @NotNull(message="Last name must be set")
    @NotEmpty(message="Last name must not be empty")
    @Size(max = 20, message = "Last name is limited to 20 characters.")
    private String lastName;
    @NotNull(message = "An email is required.")
    @NotEmpty(message = "An email is required.")
    @Email(message="Invalid email")
    private String email;
    private String tel;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
    
}
