package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.dto.ClientDTO;
import tn.enis.dto.CompteBancaireDTO;
import tn.enis.services.ClientServiceLocal;
import tn.enis.services.CompteBancaireServiceLocal;

/**
 * Servlet implementation class AjoutCBServlet
 */
public class AjoutCBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;
	@EJB
	ClientServiceLocal clientServiceLocal;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cin = request.getParameter("cin");
		ClientDTO clientDTO = clientServiceLocal.trouverClient(cin);
		String notifCompteCreer="";
		if (clientDTO != null) {
			String soldeStr = request.getParameter("montant");
			float solde;
			try{solde = Float.parseFloat(soldeStr);}catch(Exception e){solde=0;}
			CompteBancaireDTO compteBancaireDTO = new CompteBancaireDTO();
			compteBancaireDTO.setSolde(solde);
			compteBancaireDTO.setClientDTO(clientDTO);
			compteBancaireServiceLocal.ouvrirCompteBancaire(compteBancaireDTO);
			notifCompteCreer="Compte Bancaire ajouté avec succès";
		} else {
			notifCompteCreer="Echec de l'ouverture du compte, Client inexistant";
		}
		request.getSession().setAttribute("comptecreer", notifCompteCreer);
		response.sendRedirect("ajoutcomptebancaire.jsp");
	}

}
