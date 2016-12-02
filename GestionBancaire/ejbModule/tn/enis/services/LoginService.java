package tn.enis.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.LoginDAOLocal;
import tn.enis.model.Login;

/**
 * Session Bean implementation class LoginService
 */
@Stateless
public class LoginService implements LoginServiceLocal {

	@EJB
	LoginDAOLocal loginDAOLocal;
	public void creerCompte(Login l){
		loginDAOLocal.saveLogin(l);
	}
	public Login chercherCompte(String userName){
		return loginDAOLocal.findLogin(userName);
	}
}
