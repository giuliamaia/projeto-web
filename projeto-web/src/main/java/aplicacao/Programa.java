package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Produto;
import dominio.Usuario;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoweb");
		EntityManager em = emf.createEntityManager();
		Produto p1 = new Produto(001, "cocacola", 2.80);
		System.out.println(p1.toString());
		Usuario user1 = new Usuario(01, "joana", "joana@gmail.com", "aloalo123");
		System.out.println(p1.toString());
		em.getTransaction().begin();
		Usuario u1 = em.find(Usuario.class, user1.getId());
		em.persist(u1);
		em.getTransaction().commit();
	
	}

}
