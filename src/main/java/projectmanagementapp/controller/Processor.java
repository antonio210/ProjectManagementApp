package projectmanagementapp.controller;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;


import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import projectmanagementapp.util.HibernateUtil;
import projectmanagementapp.util.MyException;


public abstract class Processor <T> {

    @Getter
    @Setter
    protected T entity;
    protected Session session;
    protected Validator validator;

    public abstract List<T> getData();

  
    protected abstract void controlCreate() throws MyException;
    protected abstract void controlUpdate() throws MyException;
    protected abstract void controlDelete() throws MyException;


    public Processor(){
             this.session=HibernateUtil.getSession();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator=factory.getValidator();
    }

    public Processor(T entity){
        this();
        this.entity=entity;
    }

    public T create() throws MyException{
        validation();
        controlCreate();
        save();
        return this.entity;
    }

    public T update() throws MyException{
        validation();
        controlUpdate();
        save();
        return this.entity;
    }

    public boolean delete() throws MyException{
        controlDelete();
        session.beginTransaction();
        session.delete(this.entity);
        session.getTransaction().commit();
        return true;
    }

    private void save(){
        session.beginTransaction();
        session.save(this.entity);
        session.getTransaction().commit();
    }

    protected void validation() throws MyException{
        //https://howtodoinjava.com/hibernate/hibernate-validator-java-bean-validation/
         Set<ConstraintViolation<T>> constraintViolations 
                 = validator.validate(this.entity);
         
         if(constraintViolations.size()>0){
             
             
             StringBuilder sb=new StringBuilder();
             for (ConstraintViolation<T> violation : constraintViolations) {
             //   s+=violation.getMessage() + ", ";
             sb.append(violation.getMessage());
             sb.append(", ");
            }
            // throw new EdunovaException(s);
             throw new MyException(sb.toString());
         }
         
         
    }


}
