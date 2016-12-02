package tn.enis.services.calc;

import javax.ejb.Remote;

@Remote
public interface CalculatriceRemote {
	double som(double x, double y);
	double mult(double x, double y);
	double sous(double x, double y);


}
