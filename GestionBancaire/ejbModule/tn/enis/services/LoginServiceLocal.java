package tn.enis.services;

import javax.ejb.Local;

import tn.enis.model.Login;

@Local
public interface LoginServiceLocal {

	void creerCompte(Login l);
	Login chercherCompte(String userName);
}
