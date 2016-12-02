package tn.enis.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.enis.model.Login;

/**
 * Session Bean implementation class LoginDAO
 */
@Stateless
public class LoginDAO implements LoginDAOLocal {

	@PersistenceContext
	EntityManager em;
	public void saveLogin (Login l){
		em.persist(l);
	}
	public Login findLogin(String userName){
		return em.find(Login.class, userName);
	}
	
}
