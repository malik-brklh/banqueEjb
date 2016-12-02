package tn.enis.services.calc;

import javax.naming.InitialContext;

public class Client {

	public static void main(String[] args) throws Exception {
		InitialContext ctx = new InitialContext();
		CalculatriceRemote cal = (CalculatriceRemote) ctx
				.lookup("Calculatrice/remote");
		System.out.println("La somme est " + cal.som(2, 5));
		System.out.println("La multiplication est " + cal.mult(2, 5));
		System.out.println("La soustraction est " + cal.sous(2, 5));

	}

}
