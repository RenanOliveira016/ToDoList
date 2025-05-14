package todolist.repository;

import jakarta.persistence.EntityManager;
import todolist.model.Task;
import todolist.model.User;
import todolist.util.JpaUtil;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

	public void save(Task task) {
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(task);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Unable to complete operation: " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public Task findById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Task task = null;
		
		try {
			task = em.find(Task.class, id);
		} catch (Exception e) {
			System.out.println("Unable to complete operation: " + e.getMessage());
		} finally {
			em.close();
		}
		
		return task;
	}
	
	public List<Task> findAll() {
	    EntityManager em = JpaUtil.getEntityManager();
	    List<Task> tasks = new ArrayList<>();

	    try {
	        tasks = em.createQuery("SELECT u FROM Task u", Task.class).getResultList();
	    } catch (Exception e) {
	        System.out.println("Error retrieving user list: " + e.getMessage());
	    } finally {
	        em.close();
	    }

	    return tasks;
	}
	
	public void delete(Task task) {
	    EntityManager em = JpaUtil.getEntityManager();

	    try {
	        em.getTransaction().begin();
	        task = em.merge(task); 
	        em.remove(task);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        System.out.println("Error deleting user: " + e.getMessage());
	    } finally {
	        em.close();
	    }
	}
	
	public List<Task> findByUser(User user) {
	    EntityManager em = JpaUtil.getEntityManager();
	    List<Task> tasks = new ArrayList<>();

	    try {
	        tasks = em.createQuery("SELECT t FROM Task t WHERE t.user = :user", Task.class)
	                  .setParameter("user", user)
	                  .getResultList();
	    } catch (Exception e) {
	        System.out.println("Error retrieving tasks: " + e.getMessage());
	    } finally {
	        em.close();
	    }

	    return tasks;
	}

	
}
