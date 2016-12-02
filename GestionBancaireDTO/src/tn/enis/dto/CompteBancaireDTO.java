package tn.enis.dto;

import java.io.Serializable;

public class CompteBancaireDTO implements Serializable{
	private long rib;
	private float solde;
	private ClientDTO clientDTO;
	public CompteBancaireDTO() {
		super();
	}
	public long getRib() {
		return rib;
	}
	public void setRib(long rib) {
		this.rib = rib;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public ClientDTO getClientDTO() {
		return clientDTO;
	}
	public void setClientDTO(ClientDTO clientDTO) {
		this.clientDTO = clientDTO;
	}
	
}
