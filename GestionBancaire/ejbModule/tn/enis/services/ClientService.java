package tn.enis.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.ClientDAOLocal;
import tn.enis.dto.ClientDTO;
import tn.enis.dto.CompteBancaireDTO;
import tn.enis.model.Client;
import tn.enis.model.CompteBancaire;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
public class ClientService implements ClientServiceLocal {

	@EJB
	ClientDAOLocal clientDAOLocal;

	public void creerClient(ClientDTO clientDTO) {
		clientDAOLocal.saveClient(clientDtoToClient(clientDTO));
	}

	public void majClient(ClientDTO clientDTO) {
		clientDAOLocal.updateClient(clientDtoToClient(clientDTO));
	}

	public void supprimerClient(String cin) {
		clientDAOLocal.removeClient(cin);
	}

	@Override
	public ClientDTO trouverClient(String cin) {
		Client client = clientDAOLocal.findClient(cin);
		if (client != null){
			return clientToClientDTO(client);
			
		}else
			return null;
	}
	public List<ClientDTO> listeClients(){
		List<Client> clients = clientDAOLocal.detailsClient();
		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
		for (Client c : clients){
			clientDTOs.add(clientToClientDTO(c));
		}
		return clientDTOs;
	}

	/* parsing personnel ************************************ */
	private ClientDTO clientToClientDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAdresse(client.getAdresse());
		clientDTO.setCin(client.getCin());
		clientDTO.setNom(client.getNom());
		clientDTO.setPrenom(client.getPrenom());
		List<CompteBancaireDTO> listDTO = new ArrayList<CompteBancaireDTO>();
		for (CompteBancaire compteBancaire : client.getCompteBancaires()) {
			CompteBancaireDTO compteBancaireDTO = compteToCompteDTO(compteBancaire,clientDTO);
			listDTO.add(compteBancaireDTO);
		}
		clientDTO.setCompteBancaireDTOs(listDTO);
		return clientDTO;
	}

	private Client clientDtoToClient(ClientDTO client) {
		Client c = new Client(client.getCin(), client.getNom(),
				client.getPrenom(), client.getAdresse());
		return c;
	}
	private CompteBancaireDTO compteToCompteDTO(CompteBancaire compteBancaire,ClientDTO clientDTO) {
		CompteBancaireDTO compteBancaireDTO = new CompteBancaireDTO();
		compteBancaireDTO.setRib(compteBancaire.getRib());
		compteBancaireDTO.setSolde(compteBancaire.getSolde());
		compteBancaireDTO.setClientDTO(clientDTO);
		return compteBancaireDTO;
	}

}
