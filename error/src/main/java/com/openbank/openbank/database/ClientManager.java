package com.openbank.openbank.database;

import java.io.Serializable;
import java.util.List;

import com.openbank.openbank.model.Client;

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

    public Client read(int id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public List<Client> read() {
		Session session = sessionFactory.openSession();
    	Query<Client> query = session.createQuery("select c from Cliente c", Client.class);
		List<Client> gestores = query.getResultList();
    	session.close();
		return gestores;
    }

    public Client create(Client client) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(client);
    	session.getTransaction().commit();
    	session.close();
    	client.setId((int) id);
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
