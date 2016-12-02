package tn.enis.services;

import java.util.List;

import javax.ejb.Local;

import tn.enis.dto.ClientDTO;

@Local
public interface ClientServiceLocal {


	void creerClient(ClientDTO clientDTO);
	void majClient(ClientDTO clientDTO);
	void supprimerClient(String cin);
	ClientDTO trouverClient(String cin);
	List<ClientDTO> listeClients();
}
