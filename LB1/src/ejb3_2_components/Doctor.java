package ejb3_2_components;
import javax.ejb.Local;

@Local
public interface Doctor {
 
      void addDoctor(Doctor doctor);
 
      void checkOut();
 
}