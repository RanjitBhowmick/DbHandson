package com.java.jpademo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// This is old method
		/*
		 * Configuration con = new
		 * Configuration().configure("HibernateProperties.cfg.xml")
		 * .addAnnotatedClass(Student.class); SessionFactory sf =
		 * con.buildSessionFactory(); Session session = sf.openSession();
		 */

		Configuration con = new Configuration().configure("HibernateProperties.cfg.xml")
				.addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		// setting student object before saving the data in table
		Student stud = new Student();
		stud.setAid(8);
		stud.setAcolor("Pink");
		stud.setAname("Mask");

		Transaction tx = session.beginTransaction();
		session.save(stud); // To store the data in table
		stud = (Student) session.get(Student.class, 5); // to fetch the data from table
		System.out.println(stud);
		tx.commit();

	}
}
