package com.mainclass;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import com.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class FetchAllRecordsUsingHQL {
	public static void main(String args[]) {
		try {
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			conf.addAnnotatedClass(Student.class);
			SessionFactory sf = conf.buildSessionFactory();
			Session s = sf.openSession();

			Query<Student> query = s.createQuery("from Student");
			List<Student> allStudents = query.list();
			for (Student stud : allStudents)
				System.out.println(stud);
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
