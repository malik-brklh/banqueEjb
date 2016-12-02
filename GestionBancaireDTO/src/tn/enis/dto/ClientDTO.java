package tn.enis.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClientDTO implements Serializable {
	private String cin;//="";
	private List<CompteBancaireDTO> compteBancaireDTOs;// = new ArrayList<CompteBancaireDTO>();
	private String nom, prenom, adresse;
	public ClientDTO() {}
	public ClientDTO(String cin, String nom, String prenom, String adresse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	public ClientDTO(String cin, List<CompteBancaireDTO> compteBancaireDTOs,
			String nom, String prenom, String adresse) {
		super();
		this.cin = cin;
		this.compteBancaireDTOs = compteBancaireDTOs;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public List<CompteBancaireDTO> getCompteBancaireDTOs() {
		return compteBancaireDTOs;
	}
	public void setCompteBancaireDTOs(List<CompteBancaireDTO> compteBancaireDTOs) {
		this.compteBancaireDTOs = compteBancaireDTOs;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
