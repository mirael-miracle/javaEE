package jpql;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mysql.hospital.Doctor;

public class NamedQueries {
	public static void main( String[ ] args ) 
	{
		EntityManagerFactory emfactory = Persistence.
			createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.
			createEntityManager();
		Query query = entitymanager.createNamedQuery(
			"find doctor by id");
		query.setParameter("id", 1);
		List<Doctor> list = query.getResultList( );
		for( Doctor e:list )
		{
			System.out.print("Doctor ID :"+e.getId( ));
			System.out.println("\t Doctor Name :"+e.getName( ));
		}
	}
}
