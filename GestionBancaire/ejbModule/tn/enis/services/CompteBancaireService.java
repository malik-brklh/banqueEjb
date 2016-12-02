package tn.enis.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.dao.ClientDAOLocal;
import tn.enis.dao.CompteBancaireDAOLocal;
import tn.enis.dto.ClientDTO;
import tn.enis.dto.CompteBancaireDTO;
import tn.enis.model.Client;
import tn.enis.model.CompteBancaire;

/**
 * Session Bean implementation class CompteBancaireService
 */
@Stateless
public class CompteBancaireService implements CompteBancaireServiceLocal {

	@EJB
	CompteBancaireDAOLocal compteBancaireDAOLocal;
	@EJB
	ClientDAOLocal clientDAOLocal;

	public void ouvrirCompteBancaire(CompteBancaireDTO compteBancaireDTO) {
		CompteBancaire compteBancaire = new CompteBancaire();
		compteBancaire.setSolde(compteBancaireDTO.getSolde());
		compteBancaire.setClient(clientDAOLocal.findClient(compteBancaireDTO
				.getClientDTO().getCin()));
		compteBancaireDAOLocal.save(compteBancaire);
	}

	public CompteBancaireDTO trouverCompte(long idCompte) {
		CompteBancaire compteBancaire = compteBancaireDAOLocal
				.getInfo(idCompte);
		if (compteBancaire != null) {
			CompteBancaireDTO compteBancaireDTO = this
					.compteToCompteDTO(compteBancaire);
			return compteBancaireDTO;
		}
		return null;
	}

	public void retraitArgent(long rib, float montant) {
		CompteBancaire compteBancaire = compteBancaireDAOLocal.getInfo(rib);
		compteBancaire.setSolde(compteBancaire.getSolde() - montant);
		compteBancaireDAOLocal.update(compteBancaire);

	}

	public void depotArgent(long rib, float montant) {
		CompteBancaire compteBancaire = compteBancaireDAOLocal.getInfo(rib);
		compteBancaire.setSolde(compteBancaire.getSolde() + montant);
		compteBancaireDAOLocal.update(compteBancaire);
	}

	public List<CompteBancaireDTO> detailComptes() {
		List<CompteBancaire> list = compteBancaireDAOLocal.detailComptes();
		List<CompteBancaireDTO> listDTO = new ArrayList<CompteBancaireDTO>();
		for (CompteBancaire compteBancaire : list) {
			CompteBancaireDTO compteBancaireDTO = this
					.compteToCompteDTO(compteBancaire);
			listDTO.add(compteBancaireDTO);
		}
		return listDTO;
	}
	public List<CompteBancaireDTO> detailComptes(ClientDTO c ) {
		List<CompteBancaire> list = compteBancaireDAOLocal.detailComptes(clientDtoToClient(c));
		List<CompteBancaireDTO> listDTO = new ArrayList<CompteBancaireDTO>();
		for (CompteBancaire compteBancaire : list) {
			CompteBancaireDTO compteBancaireDTO = this
					.compteToCompteDTO(compteBancaire);
			listDTO.add(compteBancaireDTO);
		}
		return listDTO;
	}

	public void supprimerCompte(long idCompte) {
		compteBancaireDAOLocal.remove(idCompte);
	}

	private CompteBancaireDTO compteToCompteDTO(CompteBancaire compteBancaire) {
		CompteBancaireDTO compteBancaireDTO = new CompteBancaireDTO();
		compteBancaireDTO.setRib(compteBancaire.getRib());
		compteBancaireDTO.setSolde(compteBancaire.getSolde());
		compteBancaireDTO.setClientDTO(clientToClientDTO(compteBancaire.getClient()));
		return compteBancaireDTO;
	}

	private ClientDTO clientToClientDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO(client.getCin(),client.getNom(), client.getPrenom(), client.getAdresse());
		return clientDTO;
	}

	private Client clientDtoToClient(ClientDTO client) {
		Client c = new Client(client.getCin(), client.getNom(),
				client.getPrenom(), client.getAdresse());
		return c;
	}
}
