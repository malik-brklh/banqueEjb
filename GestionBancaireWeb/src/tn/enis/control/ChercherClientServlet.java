package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.dto.ClientDTO;
import tn.enis.services.ClientServiceLocal;

/**
 * Servlet implementation class ChercherClientServlet
 */
public class ChercherClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	ClientServiceLocal clientServiceLocal;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cin=request.getParameter("cin");
		String clientCherNotif = null;
		ClientDTO clientChercher=clientServiceLocal.trouverClient(cin);
		if (clientChercher==null){
			clientCherNotif="Client introuvable, vérifier son CIN";
		}
		request.getSession().setAttribute("clientCherNotif", clientCherNotif);
		request.getSession().setAttribute("clientChercher", clientChercher);
		response.sendRedirect("chercherclient.jsp");
		
	}

}
