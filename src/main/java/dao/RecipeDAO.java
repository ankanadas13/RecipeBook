package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pojo.Admin;
import pojo.Recipe;
import util.HibernateUtil;

public class RecipeDAO {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static Transaction tx;

	public void addNewRecipe(Recipe recipe) {
		try {
			Session session = sf.openSession();
			tx = session.beginTransaction();
			recipe.setIdadmin(idadmin);
			session.save(recipe);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
	}

	public List<Recipe> getAllRecipe() {
		Session session = sf.openSession();
		List<Recipe> recipe = new ArrayList<Recipe>();
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Recipe");
			recipe = q.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}
		return recipe;
	}

	public List<Recipe> getAllRecipeID() {
		Session session = sf.openSession();
		List<Recipe> list = null;
		try {
			tx = session.beginTransaction();

			Query q = session.createQuery("select idrecipe from Recipe");
			list = q.list();

			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}

	public Recipe getRecipeById(int idrecipe) {
		Session session = sf.openSession();
		Recipe recipe = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Recipe where idrecipe = :id");
			q.setParameter("id", idrecipe);
			recipe = (Recipe) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return recipe;
	}

	public void updateRecipe(Recipe recipe) {
		Session session = sf.openSession();
		try {
			tx = session.beginTransaction();
			recipe.setIdadmin(idadmin);
			session.update(recipe);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public void deleteRecipe(Recipe recipe) {
		Session session = sf.openSession();
		try {
			tx = session.beginTransaction();
			session.delete(recipe);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	public String getImageById(int id) {
		Session session = sf.openSession();
		String image = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("select imgpath from Recipe where idrecipe = :id");
			q.setParameter("id", id);
			image = (String) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return image;
	}

	public List<Recipe> getRecipeByCategory(String category) {
		Session session = sf.openSession();
		List<Recipe> list = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Recipe where category = :category");
			q.setParameter("category", category);
			list = q.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}

	public Recipe getRecipeLastRecord() {
		Session session = sf.openSession();
		Recipe recipe = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Recipe order by idrecipe DESC");
			q.setMaxResults(1);
			recipe = (Recipe) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return recipe;
	}

	public RecipeDAO() {

	}

	private int idadmin = 17;
}
