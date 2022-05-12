package openbank.database;

import java.io.Serializable;
import java.util.List;

import openbank.model.Message;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class MessageManager {

    SessionFactory sessionFactory;

    public MessageManager() {
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

    public Message read(int id) {
        Session session = sessionFactory.openSession();
        Message message = session.get(Message.class, id);
        session.close();
        return message;
    }

    public List<Message> read() {
		Session session = sessionFactory.openSession();
    	Query<Message> query = session.createQuery("select m from Message m", Message.class);
		List<Message> message = query.getResultList();
    	session.close();
		return message;
    }

    public Message create(Message message) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(message);
    	session.getTransaction().commit();
    	session.close();
    	message.setId((int) id);
    	return message;
    }

    public Message update(Message message) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(message);
    	session.getTransaction().commit();
    	session.close();
    	return message;
    }

    public Message delete(Message message) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(message);
    	session.getTransaction().commit();
    	session.close();
    	return message;
    }
    
}
