package fr.aberwag.controller.pizza;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.aberwag.bean.Pizza;
import fr.aberwag.business.pizza.PizzaBusiness;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/pizzas")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaBusiness pizzaBz = new PizzaBusiness();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pizza> listePizza = pizzaBz.getPizzas();
		request.setAttribute("listePizza", listePizza);
		this.getServletContext().getRequestDispatcher("/WEB-INF/pizza/pizzas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
