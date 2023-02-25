package dam2.add.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.resourcebundle.MiResourceBundle;
import dam2.add.p21.servicios.UsuarioService;

/**
 * Servlet implementation class LanguageController
 */
@WebServlet("/lang")
public class IdiomaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdiomaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idioma = request.getParameter("lang");
		request.getSession().setAttribute("idioma", idioma);
		MiResourceBundle.idiomaActivo(idioma);
		if(request.getSession().getAttribute("id")!=null) {
			int id = (Integer) request.getSession().getAttribute("id");
			UsuarioService.actualizarIdioma(id,idioma);
		}
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
