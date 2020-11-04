package jpql;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mysql.hospital.Pacient;

public class PacientJPQL {
	public static void main( String[ ] args ) 
	{
		EntityManagerFactory emfactory = Persistence.
			createEntityManagerFactory( "Eclipselink_JPA" );
		EntityManager entitymanager = emfactory.
			createEntityManager();
		//Between
		Query query = entitymanager.
			createQuery("SELECT name from pacient where name = 'Vasya'");
		List<Pacient> list=(List<Pacient>)query.getResultList( );
		 
		for( Pacient e:list )
		{
			System.out.print("Pacient ID :"+e.getId( ));
			System.out.println("\t Pacient name :"+e.getName( ));
		}
		
		//Like
		Query query1 = entitymanager.
			createQuery("Select e " +
				"from Pacient e " +
				"where e.ename LIKE 'V%'");
		List<Pacient> list1=(List<Pacient>)query1.getResultList( );
		for( Pacient e:list1 )
		{
			System.out.print("Pacient ID :"+e.getId( ));
			System.out.println("\t Pacient name :"+e.getName( ));
		}
	}
}
