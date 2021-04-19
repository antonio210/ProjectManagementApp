/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import static projectmanagementapp.util.InitialFixtures.start;
import projectmanagementapp.model.ContactPerson;
import projectmanagementapp.model.Customer;
import projectmanagementapp.model.Employee;
import projectmanagementapp.model.Project;

/**
 *
 * @author Korisnik
 */
public class InitialFixtures {
    
    public static void start(){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        
        // Domaća zadaća: optimizirati kod (metode,...)
        
        
        
        Faker faker = new Faker();
        
        
       
        
        Customer parker = new Customer();
        parker.setName("Parker Hannifin");
        parker.setAddress("6035 Parkland Blvd, Cleveland, Ohio");
        ContactPerson contactParker = new ContactPerson();
        contactParker.setFirstName(faker.name().firstName());
        contactParker.setLastName(faker.name().lastName());
        contactParker.setEmail("test@test.com");
        parker.setContact(contactParker);
        parker.setEmail("support@parker.com");
        s.save(contactParker);
        parker.setCountry("United States");
        List<Project> parkerProjects =  new ArrayList<>();
        parker.setProjects(parkerProjects);
        
        s.save(parker);
        
//         Customer eaton = new Customer();
//        eaton.setName("Eaton");
//        eaton.setAddress("1000 Eaton Boulevard Cleveland, Ohio");
////        ContactPerson contactEaton = new ContactPerson();
////        contactEaton.setFirstName(faker.name().firstName());
////        contactEaton.setLastName(faker.name().lastName());
////        eaton.setContact(contactEaton);
//        eaton.setCountry("United States");
//        List<Project> eatonProjects =  new ArrayList<>();
//        parker.setProjects(eatonProjects);
//        s.save(eaton);
        
        
//        List<Employee> employees=new ArrayList<>();
//        Employee e;
//        for(int i=0;i<5;i++){
//            e=new Employee();
//            e.setFirstName(faker.name().firstName());
//            e.setLastName(faker.name().lastName());
//            e.setEmail(e.getFirstName().toLowerCase()+"."+e.getLastName().toLowerCase()+"@mail.com");
//            e.setTel(faker.phoneNumber().cellPhone());
//            //e.setIban(faker.idNumber().invalidSvSeSsn());
//            s.save(e);
//            employees.add(e);
//        }
        
        Employee admin = new Employee();
        admin.setFirstName("Antonio");
        admin.setLastName("Blatancic");
        admin.setAuthorizationLvl(3);
        admin.setEmail("antonio.blatancic21@gmail.com");
        admin.setPassword(BCrypt.hashpw("antonio21", BCrypt.gensalt()));
        admin.setIban("HR5724840085537433861");
        
        s.save(admin);
        
//        Project project;
//        for(int i=0;i<15;i++){
//            project=new Project();
//            project.setName(faker.funnyName().name());
//            project.setCreated(new Date());
//            project.setDeadline(faker.date().future(20, TimeUnit.DAYS, project.getCreated()));
//            project.setManager(employees.get(new Random().nextInt(employees.size()-1)));
//            
//            s.save(project);
//            
//        }
        
        
//        Grupa jp23 = new Grupa();
//        jp23.setNaziv("RP");
//        jp23.setSmjer(java);
//        jp23.setPredavac(predavac);
//        
//        Collections.shuffle(polaznici);
//        for(int i=0;i<19;i++){
//            jp23.getPolaznici().add(polaznici.get(i));
//        }
//        
//        s.save(jp23);
//        
//        
//         Grupa pp22 = new Grupa();
//        pp22.setNaziv("WD");
//        pp22.setSmjer(php);
//        pp22.setPredavac(predavac);
//        
//        Collections.shuffle(polaznici);
//        for(int i=0;i<16;i++){
//            pp22.getPolaznici().add(polaznici.get(i));
//        }
//        
//        s.save(pp22);
        s.getTransaction().commit();

        
    }
    
    public static void main(String[] args) {
        start();
    }
   
}

