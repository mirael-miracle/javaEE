package ejb3_2_components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
 
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ejb3_2_components.Doctor;
 
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
public class DoctorBEAN implements Doctor {
 
    @PersistenceContext(unitName = "pu", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
 
    private List doctor;
 
    @PostConstruct
    private void initializeBean(){
       doctor = new ArrayList<>();
    }
 
    @Override
    public void addDoctor(Doctor doctor) {
         doctor.add(doctor));
 
    }
 
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void checkOut() {
        for(Doctor doctor:doctor){
            entityManager.persist(doctor);
        }
        doctor.clear();
 
    }
    @Remove
    public void remove() {
    	doctor = null;
    }
}