package tn.enis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.enis.dto.ClientDTO;
import tn.enis.model.Client;
import tn.enis.model.CompteBancaire;

/**
 * Session Bean implementation class CompteBancaireDAO
 */
@Stateless
public class CompteBancaireDAO implements CompteBancaireDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
	public void save(CompteBancaire compteBancaire){
		em.persist(compteBancaire);
	}
	public void remove(long rib){
		em.remove(getInfo(rib));
	}
	public CompteBancaire getInfo(long rib){
		return em.find(CompteBancaire.class, rib);
	}
	public void update(CompteBancaire compteBancaire){
		em.merge(compteBancaire);
	}
	public List<CompteBancaire> detailComptes(){
		Query q = em.createQuery("select c from CompteBancaire c");
		List<CompteBancaire> l =(List<CompteBancaire>) q.getResultList();
		return l;
				
	}
	public List<CompteBancaire> detailComptes(Client c){
		Query q = em.createQuery("select c from CompteBancaire c");// where cin="+c.getCin());
		List<CompteBancaire> l =(List<CompteBancaire>) q.getResultList();
		return l;
				
	}
	
	 
}
