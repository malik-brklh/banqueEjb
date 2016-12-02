package tn.enis.services.shop;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.enis.services.calc.CalculatriceRemote;

/**
 * Session Bean implementation class Shop
 */
@Stateless
public class Shop implements ShopRemote, ShopLocal {

	ArrayList<String> listProduit = new ArrayList<String>();
	ArrayList<Integer> listQuantite = new ArrayList<Integer>();
	ArrayList<Double> listPrix = new ArrayList<Double>();
	double total = 0;
	@EJB
	private CalculatriceRemote calculatrice;

	@PostConstruct
	void instanceCree() {
		System.out.println("Instance créer avec succès");
	}

	public void achatProduit(String produit, int quantite, double prix) {

		int i = listProduit.indexOf(produit);
		if (i == -1) {
			listProduit.add(produit);
			listQuantite.add(quantite);
			listPrix.add(prix);
		} else {
			listQuantite.set(i, new Integer(listQuantite.get(i).intValue()
					+ quantite));
		}
		total += quantite * prix;

	}

	public String listProduitAchete() {
		String q = "";
		for (String x : listProduit) {
			q += " " + x;
		}
		return q;
	}

	public boolean suppressionProduit(String produit, int quantite) {
		int i = listProduit.indexOf(produit);
		if (i != -1) {
			if (listQuantite.get(i).doubleValue() < quantite)
				return false;
			listQuantite.set(i, new Integer(listQuantite.get(i).intValue()
					- quantite));
			total -= quantite * listPrix.get(i).doubleValue();
			return true;
		}
		return false;
	}

	// supprime unproduit du caddie

	public double getTotal() {

		return total;
	}

	// retourne le prix des produits dans le caddie
	// (utiliser les méthodes offertes par l’EJB injecté Calculatrice)
	public void payement(long rib) {
		System.out.println("payement avec succès");
	} // affiche un message de réussite du payement
		// du tota

}
