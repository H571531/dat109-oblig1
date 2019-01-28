package no.hvl.dat109.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.spill.YatzooSpill;

/**
 * Servlet implementation class YatzooFerdigServlet
 */
@WebServlet("/YatzooFerdigServlet")
public class YatzooFerdigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	YatzooSpill spill;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		spill = (YatzooSpill) request.getSession().getAttribute("spill");
		request.getRequestDispatcher("WEB-INF/JSP/spillFerdig.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		spill = (YatzooSpill) request.getSession().getAttribute("spill");
		spill.finnVinner();
		
		response.sendRedirect("YatzooFerdigServlet");
	}

}
