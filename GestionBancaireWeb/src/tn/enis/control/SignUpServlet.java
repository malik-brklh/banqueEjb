package tn.enis.control;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.enis.model.Login;
import tn.enis.services.LoginServiceLocal;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	LoginServiceLocal loginServiceLocal;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String notifCompte = "";
		HttpSession session = request.getSession();
		if(userName!=null && passwd != null){
			Login login = loginServiceLocal.chercherCompte(userName);
			if (login==null){

				 long hash = 1;
			     hash = hash * 17 + passwd.hashCode();
			     hash = hash * 31 + (passwd.hashCode()+hash);
			     hash = hash * 13;
			     passwd=""+hash;
			     login= new Login(userName,passwd);
			     loginServiceLocal.creerCompte(login);
			     notifCompte = "Administrateur ajouté avec succès";
			     
				
				
			}else{
				notifCompte = "Nom d'utilisateur existe déjà";
			}
		} 
		else {
			notifCompte = "veuillez renseigner toutes les cases";
		}
		session.setAttribute("notifCompte", notifCompte);
		response.sendRedirect("inscription.jsp");
			
	}

}
