/**
 * 
 */
package com.revature.db;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.revature.model.Test;
import com.revature.model.UpdatedTest;

/**
 * @author Ed M
 * @date May 12, 2018
 * @time time 9:59:33 AM
 */
public class UpdatedDBSingletonDAOImpl implements UpdatedDBSingletonDAO{
	private static SessionFactory mysession;
	public static int LIMITPERPAGE=25;
	private void initDB() {
		if(mysession == null) {
			mysession = new Configuration().configure().buildSessionFactory();
		}
	}
	private UpdatedDBSingletonDAOImpl() {initDB();}
	private static UpdatedDBSingletonDAO instance = new UpdatedDBSingletonDAOImpl();
	public static UpdatedDBSingletonDAO getInstance() {
		return instance;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UpdatedDBSingletonDAO db = new UpdatedDBSingletonDAOImpl();
//		Timestamp  timestamp = new Timestamp(System.currentTimeMillis());
//		UpdatedTest t = new UpdatedTest(-12L,"TempName","PASSED",false,timestamp,"12:12temp");
//		System.out.println(db.create(t));
//		System.out.println(db.read(3L).toString());
//		UpdatedTest updateTest = new UpdatedTest(3L,"TestUpdate","FAILED",false,timestamp,"temp");
//		System.out.println(db.update(updateTest));
//		UpdatedTest t1 = db.read(2);
//		System.out.println(db.delete(t1));
		List<UpdatedTest> leList = db.getAllTest(0,LIMITPERPAGE);
		for(UpdatedTest tempout : leList) {
			System.out.println(tempout.toString());
			//System.out.println(leList.isEmpty());
		}
		
	}

	@Override
	public boolean create(UpdatedTest test) {
		Session session = mysession.openSession();
		Transaction createTranscation = null;
		try {
			createTranscation = session.beginTransaction();
			session.save(test);
			createTranscation.commit();
		} catch (HibernateException e) {
			if(createTranscation !=null)
				createTranscation.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public UpdatedTest read(long id) {
		Session session = mysession.openSession();
		Transaction updateTranscation = null;
		UpdatedTest t = null;
		try {
			updateTranscation = session.beginTransaction();
			t = session.get(UpdatedTest.class, id);
		} catch (HibernateException e) {
			if(updateTranscation !=null)
				updateTranscation.rollback();
		} finally {
			session.close();
		}
		return t;
	}

	@Override
	public boolean update(UpdatedTest test) {
		Session session = mysession.openSession();
		Transaction updateTranscation = null;
		UpdatedTest NewObject; //empty
		try {
			updateTranscation = session.beginTransaction();
			NewObject = session.get(UpdatedTest.class, test.getTest_id());
			//NewObject.setTest_id(test.getTest_id());
			NewObject.setTest_name(test.getTest_name());
			NewObject.setTest_context(test.getTest_context());
			NewObject.setDeleted(test.isDeleted());
			NewObject.setTest_start_date((test.getTest_start_date()));
			NewObject.setTest_end_date((test.getTest_end_date()));
			updateTranscation.commit();
		} catch (HibernateException e) {
			if(updateTranscation !=null)
				updateTranscation.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(UpdatedTest test) {
		test.setDeleted(true);
		return update(test);
	}

	@Override
	public List<UpdatedTest> getAllTest(int page,int LIMITPERPAGE) {
//		try {
//		return mysession.getCurrentSession().createQuery("from Updated_Test").list();
//		} catch (HibernateException e) {
//		System.out.println(e.getLocalizedMessage());
//		}catch (Exception e ) {
//			System.out.println(e.getLocalizedMessage());
//		}finally {
//			return null;
//		}
//		
		Session session = mysession.openSession();
		Transaction getAllTestTranscation = null;
		List<UpdatedTest> listOfResults = null;
		int offset = page*LIMITPERPAGE;
		System.out.println("page : "+page+" Limit : "+LIMITPERPAGE);
		try {
			//return mysession.getCurrentSession().createQuery("from Foo").list();
			getAllTestTranscation = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query getAllUpdatedTestQuery =  session.createQuery("from UpdatedTest",UpdatedTest.class );	
			getAllUpdatedTestQuery.setFirstResult(offset);
			getAllUpdatedTestQuery.setMaxResults(LIMITPERPAGE);
			listOfResults = getAllUpdatedTestQuery.list();
		} catch (HibernateException e) {
			if(getAllTestTranscation != null)
				getAllTestTranscation.rollback();
			System.out.println(e.getLocalizedMessage());
		}catch (Exception e ) {
			System.out.println(e.getLocalizedMessage());

		} finally {
			session.close();
		}
		return listOfResults;
	}

}
