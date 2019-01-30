package no.hvl.dat109.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.spill.Spiller;
import no.hvl.dat109.spill.YatzooSpill;
import no.hvl.dat109.utils.ServletUtils;

/**
 * Servlet implementation class YatzooSpillRundeServlet
 */
@WebServlet("/YatzooSpillRundeServlet")
public class YatzooSpillRundeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	YatzooSpill spill;
	Spiller aktivSpiller;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//spill = (YatzooSpill) request.getSession().getAttribute("spill");
		
		//request.getSession().setAttribute("valgteTerninger", sp);
		
		
		//request.getSession().setAttribute("aktivSpiller", aktivSpiller);
		
		request.getRequestDispatcher("WEB-INF/JSP/spillRunde.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		spill = (YatzooSpill) request.getSession().getAttribute("spill");
		
		//Hent array med terninger som ble haket av
		String[] valgt = request.getParameterValues("valgteTerninger");
		//boolean[] valgteTerninger = new boolean[5];
		
		//"Oversett" til boolean[]
		boolean[] valgteTerninger = ServletUtils.checkboxValgTabellTilBooleanTabell(valgt);
		
		//Hvis det velges en ny spiller nullstilles valgteTerninger
		valgteTerninger = spill.utforNesteKast(valgteTerninger);
		
		request.getSession().setAttribute("valgteTerninger", valgteTerninger);
		
		if(spill.heltFerdig()) {
			response.sendRedirect("YatzooSpillServlet");
		} else {
			response.sendRedirect("YatzooSpillRundeServlet");
		}
		
		
		
		
	}

}
