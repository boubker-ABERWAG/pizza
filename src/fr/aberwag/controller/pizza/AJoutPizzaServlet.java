package fr.aberwag.controller.pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.INTERNAL;

import fr.aberwag.business.pizza.PizzaBusiness;

/**
 * Servlet implementation class AJoutPizzaServlet
 */
@WebServlet("/ajout_pizza")
public class AJoutPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaBusiness pizzaBz = new PizzaBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AJoutPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pizza/ajout_pizza.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("libelle");
		String ref = request.getParameter("reference");
		Integer prix = Integer.valueOf(request.getParameter("prix"));
		String url = request.getParameter("url");
		
		pizzaBz.ajoutPizza(libelle, ref, prix, url);
		
		response.sendRedirect("pizzas");
	}

}
