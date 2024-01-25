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

public class InsertBook {

	public static void main(String[] args) {
		// crea sessionFactory y session
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
			    .configure( "hibernate.cfg.xml" )
			    .build();

		Metadata metadata = new MetadataSources( standardRegistry )
			    .addAnnotatedClass( Author.class )
			    .addAnnotatedClass( Book.class )
			    .getMetadataBuilder()
			    .build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
			    .build();    
		
		Session session = sessionFactory.openSession();
		
		try {
			Book unLibro = unlibro();		
						
			
			// comienza la transacci n
			session.beginTransaction();
			
			session.persist(unLibro);
			
			// hace commit de la transaccion
			session.getTransaction().commit();
			
			
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
	
	private static Book unlibro() {
		Book unlibro = new Book();
		Author unAutor = new Author();
		unAutor.setId(1);	
		
		
		unlibro.setTittle("pruebas");
		unlibro.setGenre("terror");
		unlibro.setPublication_date(LocalDate.parse("1985-04-04"));
		unlibro.setAuthor_id(unAutor);
		
		
		return unlibro;
	}

}
