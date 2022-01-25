package com.hibernate.cache;

import org.hibernate.Transaction;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main 
{
    public static void main( String[] args ) throws Exception 
    {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();		
		Transaction t = session.beginTransaction();
		Product product = new Product("Laptop", 25000);
		session.persist(product);
		Product pr = session.get(Product.class, product.getId());
		t.commit();
		session.close();

		//sessionFactory.getCache().evictEntity(Product.class, product.getId());
		//Thread.sleep(10000);
		//System.out.println("sleep over");
		
		Session session2 = sessionFactory.openSession();
		t = session2.beginTransaction();
		Product pr_2 = session2.get(Product.class, product.getId());
		pr_2.setPrice(12000);
		t.commit();
		session2.close();
		
		sessionFactory.close();
    }
    
}
