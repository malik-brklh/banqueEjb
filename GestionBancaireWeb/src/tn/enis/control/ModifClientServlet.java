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
 * Servlet implementation class ModifClientServlet
 */
public class ModifClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	ClientServiceLocal clientServiceLocal;
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cin = request.getParameter("cin");
		String nom = request.getParameter("nom");
		String clientmodife="";
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\ncin = "+cin+"\nnom = "+nom+"\n\n\n\n\n\n\n\n\n\n\n");
		
		
		
		if (nom==null && cin!=null){
			ClientDTO clientDTO = clientServiceLocal.trouverClient(cin);
			if(clientDTO==null){
				clientmodife="Client inexistant";
				request.getSession().setAttribute("clientmodife", clientmodife);
			}else{
				request.getSession().setAttribute("client", clientDTO);
			}
			response.sendRedirect("modifierclient.jsp");
			return;
		}else if (nom!=null){
			ClientDTO clientDTO = (ClientDTO) request.getSession().getAttribute("client");
			clientDTO.setNom(request.getParameter("nom"));
			clientDTO.setPrenom(request.getParameter("prenom"));
			clientDTO.setAdresse(request.getParameter("adresse"));
			clientServiceLocal.majClient(clientDTO);
			request.getSession().setAttribute("client", null);
			response.sendRedirect("ChercherClientServlet?cin="+clientDTO.getCin());
		}
		

	}

}
