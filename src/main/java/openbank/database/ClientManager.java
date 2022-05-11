package openbank.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import openbank.model.Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ClientManager {
    
    SessionFactory sessionFactory;

    public ClientManager() {
        this.setup();
    }

    public void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}    	
    }

    public List<Client> read() {
		Session session = sessionFactory.openSession();
    	Query<Client> query = session.createQuery("select c from Client c", Client.class);
		List<Client> gestores = query.getResultList();
    	session.close();
		return gestores;
    }

	public Client read(Long id) throws Exception {
        Session session = sessionFactory.openSession();
        // Client client = (Client)session.get(Client.class, id);
		Query<Client> query = session.createQuery("FROM Client c WHERE id=6", Client.class);//  WHERE c.id = :id
		
		// query.setParameter("id", id);
		List<Client> results = query.getResultList();
		System.out.println(results);
		try {
			
			ArrayList<Client> list = new ArrayList<Client>(results);
			Client client = (Client)list.get(0);
			System.out.println(results);
			System.out.println("---------------------------------------------");
			System.out.println(client);

			
			session.close();
			return client;
		} catch(Exception e) {
			e.printStackTrace();
		}
		throw new Exception("man petao");

    }

    public Client create(Client client) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(client);
    	session.getTransaction().commit();
    	session.close();
    	client.setId((long) id);
    	return client;
    }

    public Client update(Client client) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(client);
    	session.getTransaction().commit();
    	session.close();
    	return client;
    }

    public Client delete(Client client) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(client);
    	session.getTransaction().commit();
    	session.close();
    	return client;
    }

}
