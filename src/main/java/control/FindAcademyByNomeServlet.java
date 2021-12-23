package control;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.sql.Date;
import java.util.List;
>>>>>>> branch 'master' of https://github.com/paolik20/AcademyProject.git

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
/*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
*/
=======

import model.Academy;
import service.AcademyService;
import service.ServiceException;
import service.impl.AcademyServiceImpl;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

>>>>>>> branch 'master' of https://github.com/paolik20/AcademyProject.git

/**
 * Servlet implementation class FindAcademyByNomeServlet
 */
@WebServlet("/FindAcademyByNomeServlet")
public class FindAcademyByNomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AcademyService academyService = new AcademyServiceImpl();
	
    /**
     * Default constructor. 
     */
    public FindAcademyByNomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = (String) request.getAttribute("nomeAcademy");
			Date dataInizio = (Date) request.getAttribute("dataInizio");
			Date dataFine = (Date) request.getAttribute("dataFine");
			List<Academy> academies = academyService.findByNomeEDate(nome, dataInizio, dataFine);
			request.setAttribute("academies", academies);
			request.getRequestDispatcher("academies.jsp").forward(request, response);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
