package todolist.app;

import jakarta.persistence.*;
import todolist.model.User;
import todolist.util.JpaUtil;

public class App {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		User user = new User();
		user.setName("Renan");
		user.setEmail("renandosanto577@gmail.com");
		user.setAge(19);
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		em.close();
		JpaUtil.shutdown();

	}

}
