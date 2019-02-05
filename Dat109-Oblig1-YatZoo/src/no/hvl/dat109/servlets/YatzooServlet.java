package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import no.hvl.dat109.spill.Spiller;
import no.hvl.dat109.spill.YatzooSpill;

/**
 * Servlet implementation class YatzooServlet
 */
@WebServlet("/YatzooServlet")
public class YatzooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private String forFaaFeil = "<h1><font color=\"red\">Det m&aring; være minst to spillere!</font></h1>";

    /**
     * Default constructor. 
     */
    public YatzooServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feil = request.getParameter("forFaaSpillere");
		if(feil != null) {
			request.setAttribute("forFaaSpillereFeilmelding", forFaaFeil);
		}
		request.getRequestDispatcher("WEB-INF/JSP/spillerRegistrering.jsp").forward(request, response);;
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int antallSpillere = 0;
		List<Spiller> spillere = new ArrayList<Spiller>();
		
		for(int i = 1; i < 6; i++) {
			String navn = request.getParameter("spiller" + i);
			if(navn != null && !navn.equals("")) {
				spillere.add(new Spiller(navn));
				antallSpillere++;
			}
		}
		
		if(antallSpillere < 2) {
			response.sendRedirect("YatzooServlet?forFaaSpillere");
		} else {
			YatzooSpill spill = new YatzooSpill(spillere);
			spill.startSpill();
			request.getSession().setAttribute("spill", spill);
			response.sendRedirect("YatzooSpillServlet");
		}
		
	}
	
	

}
