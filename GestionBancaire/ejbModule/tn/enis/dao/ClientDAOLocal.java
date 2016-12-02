package tn.enis.dao;

import java.util.List;

import javax.ejb.Local;

import tn.enis.model.Client;


@Local
public interface ClientDAOLocal {
	 void saveClient(Client client);
	 Client findClient(String cin);
	 void removeClient(String cin);
	 void updateClient(Client client);
	 List<Client> detailsClient();
}