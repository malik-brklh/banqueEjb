package tn.enis.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ListerClients
 */
public class ListerClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@EJB
	ClientServiceLocal clientServiceLocal;
	@EJB
	CompteBancaireServiceLocal compteBancaireServiceLocal;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		List<ClientDTO> clientDTOs = clientServiceLocal.listeClients();
		req.getSession().setAttribute("clients", clientDTOs);
		resp.sendRedirect("listerclient.jsp");
	}

}
