package com.hibernate.one_many;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_1_N 
{
    public static void main( String[] args )
    {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session1 = sessionFactory.openSession();
		Question qus = new Question("Which are the europian countries?");
		Answer ans = new Answer("Sweden", qus);
		Answer ans2 = new Answer("France", qus);
		Answer ans3 = new Answer("Austria", qus);
		Set<Answer> answers = new HashSet<Answer>();
		answers.add(ans);answers.add(ans2);answers.add(ans3);
		qus.setAnswers(answers);
		Transaction t1 = session1.beginTransaction();
		session1.persist(qus);
		long q_id = qus.getQusId(); //Managed
		System.out.println("Question id = " + q_id);
		t1.commit();
		session1.close();
    	
		
		
		
		
		
		Session session2 = sessionFactory.openSession();
		Transaction t2 = session2.beginTransaction();
		Question qus2 = session2.load(Question.class, q_id); // Managed
		qus2.setQusDesc("List down the european countries");
		t2.commit();
		session2.close();
		
		Session session3 = sessionFactory.openSession();
		Query query = session3.createQuery("from Question");
		List<Question> questions = query.list();
		for(Question q: questions) {
			System.out.println("Question = " + q);
		}
		session3.close();
		
		Session session4 = sessionFactory.openSession();
		Transaction t4 = session4.beginTransaction();
		Question qus4 = session4.load(Question.class, q_id);
		session4.delete(qus4);
		t4.commit();
		session4.close();
		
		sessionFactory.close();
    }
}
