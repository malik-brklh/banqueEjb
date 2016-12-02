package tn.enis.dao;

import javax.ejb.Local;

import tn.enis.model.Login;

@Local
public interface LoginDAOLocal {
	void saveLogin (Login l);
	Login findLogin(String userName);
}
