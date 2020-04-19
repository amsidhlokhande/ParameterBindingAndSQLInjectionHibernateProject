package com.amsidh.hibernate.app;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
       /* Query query=session.createQuery("from userdetails where userId=?");
        query.setInteger(0, 5);*/
		 Query query=session.createQuery("from userdetails where userId=:userId or userId > :id");
	    query.setInteger("userId", 5);
	    query.setInteger("id", 7);
		List<UserDetails> userNames=(List<UserDetails>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails userDetails : userNames) {
			System.out.println(userDetails.getUserName());
		}
		
	}

}
