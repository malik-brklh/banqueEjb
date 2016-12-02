package tn.enis.clients;

import javax.naming.InitialContext;

import tn.enis.services.shop.ShopRemote;

public class ClientShop {

	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		ShopRemote shop = (ShopRemote) ctx.lookup("Shop/remote");
		shop.achatProduit("prod1", 5, 2.5);
		shop.achatProduit("prod2", 5, 2.5);
		shop.achatProduit("prod1", 5, 2.5);
		System.out.println(shop.listProduitAchete() + "\nTotal = "
				+ shop.getTotal());

	}

}
