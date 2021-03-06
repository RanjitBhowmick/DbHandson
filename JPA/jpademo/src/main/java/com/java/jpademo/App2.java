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
public class App2 {
	public static void main(String[] args) {

		// This is old method
		/*
		 * Configuration con = new
		 * Configuration().configure("HibernateProperties.cfg.xml")
		 * .addAnnotatedClass(Student.class); SessionFactory sf =
		 * con.buildSessionFactory(); Session session = sf.openSession();
		 */

		Configuration con = new Configuration().configure("HibernateProperties.cfg.xml")
				.addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		// setting student object before saving the data in table
		Employee emp = new Employee();
		fullname fn = new fullname();
		fn.setFirstname("Ranjit");
		fn.setMiddlename("Amar Kumar");
		fn.setLastname("Bhowmick");

		emp.setId(100);
		emp.setName(fn);
		emp.setSalary(10000);

		Transaction tx = session.beginTransaction();
		session.save(emp); // To store the data in table
		emp = (Employee) session.get(Employee.class, 5); // to fetch the data from table
		System.out.println(emp);
		tx.commit();

	}
}
