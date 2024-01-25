package ejercicios;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entidades.Author;
import entidades.Book;


public class CreateAuthor {

	public static void main(String[] args) {
		// crea sessionFactory y session
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			    .configure( "hibernate.cfg.xml" )
			    .build();

		Metadata metadata = new MetadataSources( standardRegistry )
			    .addAnnotatedClass( Author.class )
			    //.addAnnotatedClass( Book.class )
			    .getMetadataBuilder()
			    .build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
			    .build();    
		
		Session session = sessionFactory.openSession();
		
		try {
			Author unAutor = crearautor();
			
			// comienza la transacci n
			session.beginTransaction();
			
			session.persist(unAutor);
			
			// hace commit de la transaccion
			session.getTransaction().commit();
			
			System.out.println("Autor creado correctamente.");
			
			
			
		}catch(Exception e) {
			// rollback ante alguna excepci n
			System.out.println("Realizando Rollback");
			session.getTransaction().rollback();
			e.printStackTrace();
		}		
		finally {
			session.close();
			sessionFactory.close();
		}
		
		

	}
	
	private static Author crearautor() {
		Author unAutor = new Author();
		
		unAutor.setFirst_name("pepe");
		unAutor.setLast_name("lopez");
		unAutor.setBirthdate(LocalDate.parse("1985-04-04"));
		unAutor.setNationality("francia");
		
		return unAutor;
		
		
	}

}
