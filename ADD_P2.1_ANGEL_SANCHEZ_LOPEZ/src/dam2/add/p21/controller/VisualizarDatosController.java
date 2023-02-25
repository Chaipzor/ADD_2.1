package dam2.add.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAOMemoria;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

/**
 * Servlet implementation class PerfilController
 */
@WebServlet("/modificardatos")
public class VisualizarDatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisualizarDatosController() {
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
		// Muestra los datos del usuario con el que estamos logeados para su edición.
		int id = (int) request.getSession().getAttribute("id");
		Usuario usuario = UsuarioService.obtener(id);

		String nombre = usuario.getNombre();
		String apellidos = usuario.getApellidos();
		String email = usuario.getEmail();
		Integer telefono = usuario.getTelefono();
		String tlf = telefono.toString();
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("email", email);
		request.setAttribute("telefono", tlf);
		request.getRequestDispatcher("./jsp/perfil_editable.jsp").forward(request, response);
	}

}
