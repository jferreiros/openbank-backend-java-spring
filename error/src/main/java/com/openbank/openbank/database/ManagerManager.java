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
    	Query<Manager> query = session.createQuery("select m from Manager m", Manager.class);
		List<Manager> managers = query.getResultList();
    	session.close();
		return managers;
	}

	public Manager read(int id) {
		Session session = sessionFactory.openSession();
	    Manager manager = session.get(Manager.class, id);
	    session.close();
	    return manager;
	}

    public Manager create(Manager manager) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(manager);
    	session.getTransaction().commit();
    	session.close();
    	manager.setId((int) id);
    	return manager;
    }

    public Manager update(Manager manager) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(manager);
    	session.getTransaction().commit();
    	session.close();
    	return manager;
    }

    public Manager delete(Manager manager) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(manager);
    	session.getTransaction().commit();
    	session.close();
    	return manager;
    }
    
}
