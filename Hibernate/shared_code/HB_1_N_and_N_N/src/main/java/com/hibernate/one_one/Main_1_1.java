package com.hibernate.one_one;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_1_1 
{
    public static void main( String[] args )
    {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session1 = sessionFactory.openSession();
		Profile profile = new Profile("Xoriant", 5);
		Employee emp = new Employee("Tom", 20000, profile);
		Transaction t1 = session1.beginTransaction();
		session1.persist(emp);
		long e_id = emp.getEmployeeId(); //Managed
		System.out.println("Employee id = " + e_id);
		t1.commit();
		session1.close();
    	
		Session session2 = sessionFactory.openSession();
		Transaction t2 = session2.beginTransaction();
		Employee emp2 = session2.load(Employee.class, e_id); // Managed
		emp2.setSal(35000);
		emp2.getProfile().setExperience(6);
		t2.commit();
		session2.close();
		
		Session session3 = sessionFactory.openSession();
		Query query = session3.createQuery("from Employee");
		List<Employee> employees = query.list();
		for(Employee e: employees) {
			System.out.println("employee = " + e);
		}
		session3.close();
		
		Session session4 = sessionFactory.openSession();
		Transaction t4 = session4.beginTransaction();
		Employee emp4 = session4.load(Employee.class, e_id);
		session4.delete(emp4);
		t4.commit();
		session4.close();
		
		sessionFactory.close();
    }
}
