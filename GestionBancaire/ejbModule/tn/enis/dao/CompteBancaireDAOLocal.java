package tn.enis.dao;

import java.util.List;

import javax.ejb.Local;

import tn.enis.model.Client;
import tn.enis.model.CompteBancaire;

@Local
public interface CompteBancaireDAOLocal {

	void save(CompteBancaire compteBancaire);
	CompteBancaire getInfo(long rib);
	void update(CompteBancaire compteBancaire);
	List<CompteBancaire> detailComptes();
	void remove(long rib);
	List<CompteBancaire> detailComptes(Client c);
}
