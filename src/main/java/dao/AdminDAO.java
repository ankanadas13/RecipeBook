package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pojo.Admin;
import util.HibernateUtil;

public class AdminDAO {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static Transaction tx;

	public void addNewAdmin(Admin admin) {
		Session session = sf.openSession();
		try {
			tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public List<Admin> getAllAdmin() {
		Session session = sf.openSession();
		List<Admin> admin = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Admin");
			admin = q.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return admin;
	}

	public List<Admin> getAllAdminID() {
		Session session = sf.openSession();
		List<Admin> admin = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select idadmin from Admin");
			admin = q.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return admin;
	}

	public Admin getAdminById(int idadmin) {
		Session session = sf.openSession();
		Admin admin = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Admin where idadmin = :id");
			q.setParameter("id", idadmin);
			admin = (Admin) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return admin;
	}

	public void updateAdmin(Admin admin) {
		Session session = sf.openSession();
		try {
			tx = session.beginTransaction();
			System.out.println(admin);
			session.update(admin);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public void deleteAdmin(Admin admin) {
		Session session = sf.openSession();
		try {
			tx = session.beginTransaction();
			session.delete(admin);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}
	
	public List<Admin> validateLogin(Admin admin) {
		Session session = sf.openSession();
		List<Admin> list = new ArrayList<Admin>();
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Admin where username = :uname and password = :pass and status = :status");
			q.setParameter("uname", admin.getUsername());
			q.setParameter("pass", admin.getPassword());
			q.setParameter("status", "Aktif");
			list = q.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	
	public Admin getAdminLastRecord() {
		Session session = sf.openSession();
		Admin admin = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Admin order by idadmin DESC");
			q.setMaxResults(1);
			admin = (Admin) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return admin;
	}

	public AdminDAO() {

	}
}
