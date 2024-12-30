package com.mainclass;

import org.hibernate.cfg.Configuration;

import com.entity.Student;
import com.entity.Teacher;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Teacher.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

//		Student s1=new Student();
//		s1.setId(2);
//		s1.setAge(22);
//		s1.setName("sham");
//		s1.setPhone(7854637237L);

		List<Student> studs = new ArrayList<Student>();
		studs.add(new Student(9, "jay", 7856895434L, 23));
		studs.add(new Student(10, "kalpesh", 8965834798L, 24));
		studs.add(new Student(11, "umesh", 9876564587l, 22));

		// s.persist(studs); //not allowed
//		persists method will take single object as parameter so in order to store entire list into the 
//		database  we have to iterate over list and can access the individual object and store it into table which is present
//		in database

		for (Student obj : studs)
			s.persist(obj);
		tr.commit();
		s.beginTransaction();
		Teacher t1 = new Teacher();
		s.persist(new Teacher(2, "Ramakant", 45000));
		tr.commit();
	}
}
