package tn.enis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.enis.model.Client;


/**
 * Session Bean implementation class ClientDAO
 */
@Stateless
public class ClientDAO implements ClientDAOLocal {
	
	@PersistenceContext
	EntityManager em;
	
	public void saveClient(Client client){
		em.persist(client);
	}
	public Client findClient(String cin){
		return em.find(Client.class, cin);
		
	}
	public void removeClient(String cin){
		em.remove(findClient(cin));
	}
	public void updateClient(Client client){
		em.merge(client);
	}
	public List<Client> detailsClient(){
		Query q = em.createQuery("select c from Client c");
		return (List<Client>) q.getResultList();
	}
}
