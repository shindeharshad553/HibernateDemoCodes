package com.mainclass;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.entity.Student;

public class UpdateRecordUsingHQL {
	public static void main(String args[]) {

//		Configuration code 
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();

//		code for updating the record from the table 
		Query<Student> query = s.createQuery("Update Student set name=:name where id=:id");
		query.setParameter("name", "jayesh");
		query.setParameter("id", 3);
		int rowsAffected = query.executeUpdate();
		tr.commit(); ///to save the changes permanently to the database 
		if(rowsAffected>0)
			System.out.println("Updated successfully");
		else
			System.out.println("Error in updation");

	}
}
