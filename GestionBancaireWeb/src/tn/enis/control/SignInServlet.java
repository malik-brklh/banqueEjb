package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.enis.dto.ClientDTO;
import tn.enis.model.Login;
import tn.enis.services.ClientServiceLocal;
import tn.enis.services.LoginServiceLocal;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	LoginServiceLocal loginServiceLocal;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String notifCompte = "";
		HttpSession session = request.getSession();
		Boolean authentified=(Boolean) session.getAttribute("authentified");
		if (authentified==null){
			authentified=new Boolean(false);
		}
		
		if(authentified.booleanValue()==true){
			response.sendRedirect("accueil.jsp");
		
		}else if(userName!=null && passwd != null){
			Login login = loginServiceLocal.chercherCompte(userName);
			if (login!=null){

				 long hash = 1;
			     hash = hash * 17 + passwd.hashCode();
			     hash = hash * 31 + (passwd.hashCode()+hash);
			     hash = hash * 13;
			     passwd=""+hash;
				
				
				if(login.getPasswd().equals(passwd)){
					authentified=new Boolean(true);
					session.setAttribute("authentified", authentified);
					response.sendRedirect("accueil.jsp");
					return;
				}else{
					notifCompte = "Mot de passe éroné";
					session.setAttribute("notifCompte", notifCompte);
					response.sendRedirect("connexion.jsp");
					return;
				}
			}else{
				notifCompte = "Nom d'utilisateur inexistant";
				session.setAttribute("notifCompte", notifCompte);
				response.sendRedirect("connexion.jsp");
				return;
			}
		} 
		else response.sendRedirect("connexion.jsp");
			
	}

}
