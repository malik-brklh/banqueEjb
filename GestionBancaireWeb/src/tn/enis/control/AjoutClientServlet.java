package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.dto.ClientDTO;
import tn.enis.services.ClientServiceLocal;

/**
 * Servlet implementation class AjoutClientServlet
 */
public class AjoutClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	ClientServiceLocal clientServiceLocal;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String cin = request.getParameter("cin");
		String adresse = request.getParameter("adresse");
		Boolean clientCreer;
		if (clientServiceLocal.trouverClient(cin)!=null){
			clientCreer=new Boolean(false);
		}else{
			ClientDTO clientDTO = new ClientDTO(cin,nom,prenom,adresse);
			clientServiceLocal.creerClient(clientDTO);
			clientCreer=new Boolean(true);
		}
		request.getSession().setAttribute("clientCreer", clientCreer);
		response.sendRedirect("ajoutclient.jsp");
	}

}
