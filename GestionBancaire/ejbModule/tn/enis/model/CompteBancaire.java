package tn.enis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompteBancaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long rib;
	private float solde;
	@ManyToOne
	@JoinColumn(name="client_cin")
	private Client client;
	
	public CompteBancaire() {}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client2) {
		this.client = client2;
	}
	public long getRib() {
		return rib;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
}
