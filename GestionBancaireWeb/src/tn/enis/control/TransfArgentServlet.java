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
 * Servlet implementation class TransfArgentServlet
 */
public class TransfArgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransfArgentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ribS1 = request.getParameter("rib1");
		String ribS2 = request.getParameter("rib2");
		long rib1=Long.parseLong(ribS1);
		long rib2=Long.parseLong(ribS2);
		String montantStr = request.getParameter("montant");
		float montant = Float.parseFloat(montantStr);
		CompteBancaireDTO cDto1 = compteBancaireServiceLocal.trouverCompte(rib1);
		CompteBancaireDTO cDto2 = compteBancaireServiceLocal.trouverCompte(rib2);
		String notifTransf="";
		if(cDto1==null){
			notifTransf="Compte dont le RIB = "+rib1+" est inexistant";
		}
		if(cDto2==null){
			if(!notifTransf.equals("")) notifTransf+="<br>";
			notifTransf+="Compte dont le RIB = "+rib2+" est inexistant";
		}
		if(cDto1!=null && cDto2!=null){
			if(cDto1.getSolde()>=montant){
				compteBancaireServiceLocal.retraitArgent(rib1, montant);
				compteBancaireServiceLocal.depotArgent(rib2, montant);
				notifTransf="Transfert effectué avec succès";
			}
			else
				notifTransf="Solde sur le compte "+rib1+" est insuffisant";
				
		}
		request.getSession().setAttribute("notifTransf", notifTransf);
		response.sendRedirect("transfertargent.jsp");
		
		
	}

}
