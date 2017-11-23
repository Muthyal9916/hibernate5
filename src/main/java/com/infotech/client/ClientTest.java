package com.infotech.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {

		
//		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			String sql ="SELECT version()";
			String result = (String) session.createNativeQuery(sql).getSingleResult();
			System.out.println("Mysql version without cfg file:::"+result);
		}catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
