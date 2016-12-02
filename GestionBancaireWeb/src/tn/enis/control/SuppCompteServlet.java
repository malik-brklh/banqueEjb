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
 * Servlet implementation class SuppCompteServlet
 */
public class SuppCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ribStr = request.getParameter("rib");
		String notifSupp="";
		long rib = Integer.parseInt(ribStr);
		if (compteBancaireServiceLocal.trouverCompte(rib)!=null){
			compteBancaireServiceLocal.supprimerCompte(rib);
			notifSupp="Compte fermé avec succès";
		}else{
			notifSupp="Compte inexistant";
		}
		request.getSession().setAttribute("notifSupp", notifSupp);
		response.sendRedirect("supprimercompte.jsp");
		
	}

}
