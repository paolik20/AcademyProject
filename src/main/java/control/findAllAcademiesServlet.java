package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

import model.Academy;
import service.AcademyService;
import service.ServiceException;
import service.impl.AcademyServiceImpl;

/**
 * Servlet implementation class findAllAcademiesServlet
 */
@WebServlet("/findAllAcademiesServlet")
public class findAllAcademiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AcademyService academyService = new AcademyServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findAllAcademiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			HttpSession session = request.getSession();
			//  session.getAttribute("usernameAdmin");
			
			List<Academy> academies = academyService.findAll();
			request.setAttribute("academies", academies);
			request.getRequestDispatcher("academies.jsp").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
