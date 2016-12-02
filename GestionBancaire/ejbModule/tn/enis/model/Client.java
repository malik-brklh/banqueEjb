package tn.enis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;


@Entity
public class Client {
	
	@Id
	private String cin;
	@OneToMany(mappedBy="client",cascade=CascadeType.REMOVE)
	private List<CompteBancaire> compteBancaires;// = new ArrayList<CompteBancaire>();
	private String nom, prenom, adresse;
	public Client() {}
	public Client(String cin, String nom, String prenom, String adresse) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	public List<CompteBancaire> getCompteBancaires() {
		return compteBancaires;
	}
	public void setCompteBancaires(List<CompteBancaire> compteBancaires) {
		this.compteBancaires = compteBancaires;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
