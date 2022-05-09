package com.openbank.openbank.database;

import java.io.Serializable;
import java.util.List;

import com.openbank.openbank.model.Manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ManagerManager {

    SessionFactory sessionFactory;

    public ManagerManager() {
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

    public List<Manager> read() {
		Session session = sessionFactory.openSession();
    	Query<Manager> query = session.createQuery("select g from Manager g", Manager.class);
		List<Manager> gestores = query.getResultList();
    	session.close();
		return gestores;
	}

	public Manager read(Long id) {
		Session session = sessionFactory.openSession();
	    Manager gestor = session.get(Manager.class, id);
	    session.close();
	    return gestor;
	}

    public Manager create(Manager gestor) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(gestor);
    	session.getTransaction().commit();
    	session.close();
    	gestor.setId((int) id);
    	return gestor;
    }

    public Manager update(Manager gestor) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(gestor);
    	session.getTransaction().commit();
    	session.close();
    	return gestor;
    }

    public Manager delete(Manager gestor) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(gestor);
    	session.getTransaction().commit();
    	session.close();
    	return gestor;
    }
    
}
