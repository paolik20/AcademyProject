package control;

import java.io.IOException;
/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;*/
import model.Admin;
import service.AdminService;
import service.ServiceException;
import service.impl.AdminServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/loginAdmin")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminService adminService = new AdminServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // dalla home porta l'admin che inserisce la password corretta alla pagina amministratore.jsp, se no 
    // da errore(da fare)
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Admin admin = adminService.findByUsername(username);
			if (admin != null && admin.getPassword().equals(password)) {
				request.getSession().setAttribute("idAdmin", admin.getId());
				request.getSession().setAttribute("usernameAdmin", admin.getUsername());
				response.sendRedirect("amministratore.jsp");
			}
			else {
				response.sendRedirect("about.html?error");
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
