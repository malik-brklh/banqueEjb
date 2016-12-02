package tn.enis.services.shop;

import javax.ejb.Remote;

@Remote
public interface ShopRemote {
	public void achatProduit(String produit, int quantite, double prix);

	public String listProduitAchete();

	public double getTotal();

	public void payement(long rib);

	public boolean suppressionProduit(String produit, int quantite);
}
