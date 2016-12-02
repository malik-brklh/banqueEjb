package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enis.services.ClientServiceLocal;

/**
 * Servlet implementation class SuppClientServlet
 */
public class SuppClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppClientServlet() {
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
	ClientServiceLocal clientServiceLocal;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notifSupp;
		String cin=request.getParameter("cin");
		if(clientServiceLocal.trouverClient(cin) != null){
			clientServiceLocal.supprimerClient(cin);
			notifSupp="Client supprimé avec succès";
		}
		else{
			notifSupp="Client introuvable";
		}
		request.getSession().setAttribute("notifSupp", notifSupp);
		response.sendRedirect("supprimerclient.jsp");
	}

}
