package jpql;
import java.util.List;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DoctorJPQL {
	public static void main( String[ ] args ) 
	{
		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.
				createEntityManager();
		//Scalar function
		Query query = entitymanager.
		createQuery("Select * from doctor");
		List<String> list=query.getResultList();
		
		for(String d:list)
		{
			System.out.println("Doctor name :"+d);
		}

	}
}