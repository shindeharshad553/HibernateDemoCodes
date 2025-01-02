package com.mainclass;

import com.entity.Student;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

		int id = 2;
		Student stud = s.get(Student.class, id);
		if(stud!=null){
			stud.setName("karan");
			s.update(stud);
			tr.commit();
		}else{
			System.out.println("Id doesn't exists in table");
		}

	}

}
