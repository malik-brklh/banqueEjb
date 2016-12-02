package tn.enis.services;

import java.util.List;

import javax.ejb.Local;

import tn.enis.dto.ClientDTO;
import tn.enis.dto.CompteBancaireDTO;

@Local
public interface CompteBancaireServiceLocal {

	//void creerClient(ClientDTO clientDTO);
	void ouvrirCompteBancaire(CompteBancaireDTO compteBancaireDTO);
	void retraitArgent(long rib, float montant);
	void depotArgent(long rib, float montant);
	//void majCompte(CompteBancaireDTO compteBancaireDTO);
	List<CompteBancaireDTO> detailComptes();
	CompteBancaireDTO trouverCompte(long rib);
	void supprimerCompte (long rib);
	List<CompteBancaireDTO> detailComptes(ClientDTO c);
}
