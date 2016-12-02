package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.services.CompteBancaireServiceLocal;

/**
 * Servlet implementation class DepotArgentServlet
 */
public class DepotArgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;

   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String montantStr = request.getParameter("montant");
		String ribStr = request.getParameter("rib");
		long rib = Integer.parseInt(ribStr);
		String notifDepot;
		float montant = Float.parseFloat(montantStr);
		if (compteBancaireServiceLocal.trouverCompte(rib)!=null){
			compteBancaireServiceLocal.depotArgent(rib, montant);
			notifDepot="Depot effectué avec succès";
		}else{
			notifDepot="Compte inexistant";
		}
		request.getSession().setAttribute("notifDepot", notifDepot);
		response.sendRedirect("depotargent.jsp");
		
	}

}
