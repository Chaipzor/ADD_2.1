package dam2.add.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CerrarSesion
 */
@WebServlet("/cerrarsesion")
public class CerrarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CerrarSesionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Convertimos a null todas las sesiones abiertas.
		request.getSession().setAttribute("listaContactos", null);
		request.getSession().setAttribute("admin", null);
		request.getSession().setAttribute("nombresesion", null);
		request.getSession().setAttribute("id", null);
		request.getSession().setAttribute("editid", null);
		request.getSession().setAttribute("emailsesion", null);
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}

}
