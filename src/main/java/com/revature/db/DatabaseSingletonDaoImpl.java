package com.revature.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxy;

import com.revature.model.System;
import com.revature.model.Test;
import com.revature.model.TestType;

public class DatabaseSingletonDaoImpl implements DatabaseSingletonDao{
	private static SessionFactory mysession;
	private void initDB() {
		if(mysession == null) {
			mysession = new Configuration().configure().buildSessionFactory();
		}
	}
	private DatabaseSingletonDaoImpl() {initDB();}
	private static DatabaseSingletonDao instance = new DatabaseSingletonDaoImpl();
	public static DatabaseSingletonDao getInstance() {
		return instance;
	}
	@Override
	public boolean create(Test t) {
		Session session = mysession.openSession();
		Transaction t1 = null;
		try {
			t1 = session.beginTransaction();
			session.save(t);
			t1.commit();
		} catch (HibernateException e) {
			if(t1 !=null)
				t1.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Test read(long id) {
		Session session = mysession.openSession();
		Transaction t1 = null;
		Test t = null;
		try {
			t1 = session.beginTransaction();
			t = session.get(Test.class, id);
		} catch (HibernateException e) {
			if(t1 !=null)
				t1.rollback();
		} finally {
			session.close();
		}
		return t;
	}
	
	@Override
	public TestType readTT(long id) {
		Session session = mysession.openSession();
		Transaction t1 = null;
		TestType t = null;
		try {
			t1 = session.beginTransaction();
			t = session.get(TestType.class, id);
		} catch (HibernateException e) {
			if(t1 !=null)
				t1.rollback();
		} finally {
			session.close();
		}
		return t;
	}
	@Override
	public System readS(long id) {
		Session session = mysession.openSession();
		Transaction t1 = null;
		System s = null;
		try {
			t1 = session.beginTransaction();
			s = session.get(System.class, id);
		} catch (HibernateException e) {
			if(t1 !=null)
				t1.rollback();
		} finally {
			session.close();
		}
		return s;
	}
	@Override
	public boolean update(Test t) {
		Session session = mysession.openSession();
		Transaction t1 = null;
		Test emp;
		try {
			t1 = session.beginTransaction();
			emp = session.get(Test.class, t.getId());
			emp.setComments(t.getComments());;
			emp.setResult(t.getResult());
			session.saveOrUpdate(emp);
			t1.commit();
		} catch (HibernateException e) {
			if(t1 !=null)
				t1.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Test t) {
		t.setDeleted(true);
		return update(t);
	}

	@SuppressWarnings("unchecked")
	public List<Test> getAllTest() {
		Session session = mysession.openSession();
		Transaction t1 = null;
		List<Test> emp = null;
		try {
			t1 = session.beginTransaction();
			emp = session.createQuery("from Test").list();
		} catch (HibernateException e) {
			if(t1 !=null)
				t1.rollback();
		} finally {
			session.close();
		}
//		List<Test>result = new ArrayList<Test>();
//		for(Test temp: emp) {
//			try {
//			result.add(initializeAndUnproxy(temp));
//			}catch(Exception e) {
//				java.lang.System.out.println("Something went Wrong");
//			}
		//}
		
	
		return emp;
	}
	@SuppressWarnings("unchecked")
	public static <T> T initializeAndUnproxy(T entity) {
	    if (entity == null) {
	        throw new 
	           NullPointerException("Entity passed for initialization is null");
	    }

	    Hibernate.initialize(entity);
	    if (entity instanceof HibernateProxy) {
	        entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
	                .getImplementation();
	    }
	    return entity;
	}
	public static void main(String[] args) {
		DatabaseSingletonDao db = new DatabaseSingletonDaoImpl();
		Test t = new Test(1, "Time measured", "1000", false,db.readTT(10),db.readS(10));
		db.create(t);
		
//		List<Test>temp = getAllTest();
//		for(Test item:temp)
//			java.lang.System.out.println("Test: " + item.toString());
	}

	

}
