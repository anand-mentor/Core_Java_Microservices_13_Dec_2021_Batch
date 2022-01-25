package com.hibernate.many_many;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main_N_N 
{
	public static SessionFactory sessionFactory;

	public static void insertCourses() {
		Student student_tom = new Student("Tom"); //Java, Hibernate
		Student student_jerry = new Student("Jerry"); //Java, Spring
		Student student_ivan = new Student("Ivan"); //Hibernate, Spring
		
		Set<Student> java_students = new HashSet<Student>();
		java_students.add(student_tom);java_students.add(student_jerry);
		Set<Student> hibernate_students = new HashSet<Student>();
		hibernate_students.add(student_tom);hibernate_students.add(student_ivan);
		Set<Student> spring_students = new HashSet<Student>();
		spring_students.add(student_jerry);spring_students.add(student_ivan);
		
		Course course_java = new Course("Java programming", java_students);		
		Course course_hibernate = new Course("Hibernate", hibernate_students);
		Course course_spring = new Course("Spring", spring_students);

		Session session = sessionFactory.openSession();
		Transaction t1 = session.beginTransaction();
		session.persist(course_java);
		session.persist(course_hibernate);
		session.persist(course_spring);
		t1.commit();
		session.close();
	}
	
	public static void insertStudents() {
		Course course_1 = new Course("Java programming");		
		Course course_2 = new Course("Hibernate");
		Course course_3 = new Course("Spring");
		Set<Course> tomCourses = new HashSet<Course>();
		Set<Course> jerryCourses = new HashSet<Course>();
		tomCourses.add(course_1);tomCourses.add(course_2);tomCourses.add(course_3);
		jerryCourses.add(course_1);jerryCourses.add(course_3);
		Student student_tom = new Student("Tom", tomCourses);
		Student student_jerry = new Student("Jerry", jerryCourses);

				Session session1 = sessionFactory.openSession();
				Transaction t1 = session1.beginTransaction();
				session1.persist(student_tom);
				session1.persist(student_jerry);
				t1.commit();
				session1.close();
	}
    public static void main( String[] args )
    {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		sessionFactory = cfg.buildSessionFactory();
		
		//insertStudents();
		insertCourses();
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Course where courseId=:courseId").setParameter("courseId", 2L);
		List<Course> courses = query.list();
		System.out.println("courses: " + courses);
		sessionFactory.close();
    }
}
