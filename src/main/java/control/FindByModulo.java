package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Academy;
import service.AcademyService;
import service.ServiceException;
import service.impl.AcademyServiceImpl;

/**
 * Servlet implementation class FindByModulo
 */
@WebServlet("/FindByModulo")
public class FindByModulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AcademyService academyService = new AcademyServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByModulo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modulo = (String) request.getAttribute("nomeModulo");
		try {
			List<Academy> academies = academyService.findByModulo(modulo);
			request.setAttribute("academies", academies);
			request.getRequestDispatcher("academies.jsp").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
