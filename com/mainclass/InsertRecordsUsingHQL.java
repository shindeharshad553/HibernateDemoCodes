package com.mainclass;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.Scanner;
import com.entity.Student;

public class InsertRecordsUsingHQL {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		Scanner sc = new Scanner(System.in);

		try {
			Query<Student> q = s.createQuery("insert into Student (age,phone,name)values(:age,:mobileNo,:fullName)");
			System.out.println("Enter age ");
			int age = sc.nextInt();
			System.out.println("Enter phone number ");
			long phone = sc.nextLong();
			sc.nextLine();  //consumes the newLine character left by nextLong()
			System.out.println("Enter fullname ");
			String fullname = sc.nextLine();

			q.setParameter("age", age);
			q.setParameter("mobileNo", phone);
			q.setParameter("fullName", fullname);
			q.executeUpdate();
			System.out.println("Inserted ");
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
			if (sc != null)
				sc.close();
			sf.close();
		}

	}

}
