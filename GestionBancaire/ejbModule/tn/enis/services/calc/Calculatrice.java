package tn.enis.services.calc;

import javax.ejb.Stateless;

@Stateless
public class Calculatrice implements CalculatriceRemote, CalculatriceLocal {
	@Override
	public double som(double x, double y) {	
		return x+y;
	}
	@Override
	public double mult(double x, double y) {
		return x*y;
	}
	@Override
	public double sous(double x, double y) {	
		return x-y;
	}
}
