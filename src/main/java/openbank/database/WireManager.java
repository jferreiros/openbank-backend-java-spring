package openbank.database;

import java.io.Serializable;
import java.util.List;

import openbank.model.Wire;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class WireManager {
    SessionFactory sessionFactory;

    public WireManager() {
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

    public List<Wire> read() {
		Session session = sessionFactory.openSession();
    	Query<Wire> query = session.createQuery("select c from Wire c", Wire.class);
		List<Wire> wires = query.getResultList();
    	session.close();
		return wires;
    }

	public Wire read(int id) {
        Session session = sessionFactory.openSession();
        Wire wire = session.get(Wire.class, id);
        session.close();
        return wire;
    }

    public Wire create(Wire wire) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(wire);
    	session.getTransaction().commit();
    	session.close();
    	wire.setId((int) id);
    	return wire;
    }

    public Wire update(Wire wire) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(wire);
    	session.getTransaction().commit();
    	session.close();
    	return wire;
    }

    public Wire delete(Wire wire) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(wire);
    	session.getTransaction().commit();
    	session.close();
    	return wire;
    }
}
