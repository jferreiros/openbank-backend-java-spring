package com.openbank.openbank.database;

import java.io.Serializable;
import java.util.List;

import com.openbank.openbank.model.Loan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class LoanManager {
    
    SessionFactory sessionFactory;

    public LoanManager() {
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

    public Loan read(int id) {
        Session session = sessionFactory.openSession();
        Loan loan = session.get(Loan.class, id);
        session.close();
        return loan;
    }

    public List<Loan> read() {
		Session session = sessionFactory.openSession();
    	Query<Loan> query = session.createQuery("select m from Mensaje m", Loan.class);
		List<Loan> loan = query.getResultList();
    	session.close();
		return loan;
    }

    public Loan create(Loan loan) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Serializable id = session.save(loan);
    	session.getTransaction().commit();
    	session.close();
    	loan.setId((int) id);
    	return loan;
    }

    public Loan update(Loan loan) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(loan);
    	session.getTransaction().commit();
    	session.close();
    	return loan;
    }

    public Loan delete(Loan loan) {
        Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	session.delete(loan);
    	session.getTransaction().commit();
    	session.close();
    	return loan;
    }
}
