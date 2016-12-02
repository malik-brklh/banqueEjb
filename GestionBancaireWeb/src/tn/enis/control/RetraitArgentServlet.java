package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.dto.CompteBancaireDTO;
import tn.enis.services.CompteBancaireServiceLocal;

/**
 * Servlet implementation class RetraitArgentServlet
 */
public class RetraitArgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;

   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String montantStr = request.getParameter("montant");
		String ribStr = request.getParameter("rib");
		long rib = Integer.parseInt(ribStr);
		float montant = Float.parseFloat(montantStr);
		String notifRetrai;
		CompteBancaireDTO compteBancaireDTO = compteBancaireServiceLocal.trouverCompte(rib);
		if (compteBancaireDTO!=null){
			if (compteBancaireDTO.getSolde()>=montant){
				compteBancaireServiceLocal.retraitArgent(rib, montant);
				notifRetrai="Retrait effectué avec succès";
			}else{
				notifRetrai="Solde insuffisant";
			}
		}else{
			notifRetrai="Compte inexistant";
		}
		request.getSession().setAttribute("notifRetrai", notifRetrai);
		response.sendRedirect("retraitargent.jsp");
		
	}

}
