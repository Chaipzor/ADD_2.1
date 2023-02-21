package dam2.add.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAO_OLD;
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
		int posicion = new UsuarioService().buscarUsuario(id);

		String nombre = UsuarioDAO_OLD.getListaUsuarios().get(posicion).getNombre();
		String apellidos = UsuarioDAO_OLD.getListaUsuarios().get(posicion).getApellidos();
		String email = UsuarioDAO_OLD.getListaUsuarios().get(posicion).getEmail();
		Integer telefono = UsuarioDAO_OLD.getListaUsuarios().get(posicion).getTelefono();
		String tlf = telefono.toString();
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("email", email);
		request.setAttribute("telefono", tlf);
		request.getRequestDispatcher("./jsp/perfil_editable.jsp").forward(request, response);
	}

}
