package todolist.repository;

import todolist.model.User;

import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import todolist.util.JpaUtil;

public class UserRepository {
	
	public void save(User user) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Unable to complete operation: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public User findById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		User user = null;
		
		try {
			user = em.find(User.class, id);
		} catch (Exception e) {
			System.out.println("Unable to complete operation: " + e.getMessage());
		} finally {
			em.close();
		}
		
		return user;
	}
	
	public List<User> findAll() {
	    EntityManager em = JpaUtil.getEntityManager();
	    List<User> users = new ArrayList<>();

	    try {
	        users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
	    } catch (Exception e) {
	        System.out.println("Error retrieving user list: " + e.getMessage());
	    } finally {
	        em.close();
	    }

	    return users;
	}

	public void delete(User user) {
	    EntityManager em = JpaUtil.getEntityManager();

	    try {
	        em.getTransaction().begin();
	        user = em.merge(user); 
	        em.remove(user);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error deleting user: " + e.getMessage());
	    } finally {
	        em.close();
	    }
	}
	
	public User findByEmail(String email) {
	    EntityManager em = JpaUtil.getEntityManager();
	    User user = null;

	    try {
	        user = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
	                 .setParameter("email", email)
	                 .getSingleResult();
	    } catch (NoResultException e) {
	        // Nenhum usuário encontrado com esse email → retorna null
	    } catch (Exception e) {
	        System.out.println("Error finding user by email: " + e.getMessage());
	    } finally {
	        em.close();
	    }

	    return user;
	}



}