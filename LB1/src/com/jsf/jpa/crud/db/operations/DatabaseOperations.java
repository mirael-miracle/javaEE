package com.jsf.jpa.crud.db.operations;
 
import java.util.List;
 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
 
import com.jsf.jpa.crud.DoctorBean;
import com.jsf.jpa.crud.DoctorEntityManager;
 
public class DatabaseOperations {
 
    private static final String PERSISTENCE_UNIT_NAME = "JSFJPACrud";   
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

    @SuppressWarnings("unchecked")
    public static List getAllDoctorDetails() {
        Query queryObj = entityMgrObj.createQuery("SELECT * FROM DoctorEntityManager");
        List doctorList = queryObj.getResultList();
        if (doctorList != null && doctorList.size() > 0) {           
            return doctorList;
        } else {
            return null;
        }
    }

    public static String createNewDoctor(String name) {
        if(!transactionObj.isActive()) {
            transactionObj.begin();
        }
 
        DoctorEntityManager newDoctorObj = new DoctorEntityManager();
        newDoctorObj.setId(getMaxDoctorId());
        newDoctorObj.setName(name);
        entityMgrObj.persist(newDoctorObj);
        transactionObj.commit();
        return "doctorList.xhtml?faces-redirect=true"; 
    }

    public static String deleteDoctorDetails(int doctorId) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
 
        DoctorEntityManager deleteDoctorObj = new DoctorEntityManager();
        if(isDoctorIdPresent(doctorId)) {
            deleteDoctorObj.setId(doctorId);
            entityMgrObj.remove(entityMgrObj.merge(deleteDoctorObj));
        }       
        transactionObj.commit();
        return "doctorsList.xhtml?faces-redirect=true";
    }

    public static String updateDoctorDetails(int doctorId, String updatedDoctorName) {
        if (!transactionObj.isActive()) {
            transactionObj.begin();
        }
 
        if(isDoctorIdPresent(doctorId)) {
            Query queryObj = entityMgrObj.createQuery("UPDATE DoctorEntityManager s SET s.name=:name WHERE s.id= :id");         
            queryObj.setParameter("id", doctorId);
            queryObj.setParameter("name", updatedDoctorName);
            int updateCount = queryObj.executeUpdate();
            if(updateCount > 0) {
                System.out.println("Record For Id: " + doctorId + " Is Updated");
            }
        }
        transactionObj.commit();
        FacesContext.getCurrentInstance().addMessage("editDoctorForm:doctorId", new FacesMessage("Doctor Record #" + doctorId + " Is Successfully Updated In Db"));
        return "doctorEdit.xhtml";
    }

    private static int getMaxDoctorId() {
        int maxDoctorId = 1;
        Query queryObj = entityMgrObj.createQuery("SELECT MAX(s.id)+1 FROM DoctorEntityManager s");
        if(queryObj.getSingleResult() != null) {
            maxDoctorId = (Integer) queryObj.getSingleResult();
        }
        return maxDoctorId;
    }

    private static boolean isDoctorIdPresent(int doctorId) {
        boolean idResult = false;
        Query queryObj = entityMgrObj.createQuery("SELECT s FROM DoctorEntityManager s WHERE s.id = :id");
        queryObj.setParameter("id", doctorId);
        DoctorEntityManager selectedDoctorId = (DoctorEntityManager) queryObj.getSingleResult();
        if(selectedDoctorId != null) {
            idResult = true;
        }
        return idResult;
    }
}