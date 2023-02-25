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
@WebServlet("/perfil")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PerfilController() {
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

		// Entramos en el perfil del usuario y reseteamos los datos de sesión
		// emailsesion y editid.
		int id = (int) request.getSession().getAttribute("id");
		boolean admin = Boolean.parseBoolean((String) request.getSession().getAttribute("admin"));
		if(admin) {
			request.getSession().setAttribute("editid", null);
			request.getSession().setAttribute("emailsesion", null);
		}
		
		Usuario usuario = UsuarioService.obtener(id);

		// Obtenemos los datos del usuario con el que estamos logeados en el sistema.
		String nombre = usuario.getNombre();
		String apellidos = usuario.getApellidos();
		String email = usuario.getEmail();
		Integer telefono = usuario.getTelefono();
		String tlf = telefono.toString();

		// Mostramos los datos del usuario con el que estamos logeados en el sistema.
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("email", email);
		request.setAttribute("telefono", tlf);
		request.getRequestDispatcher("./jsp/perfil.jsp").forward(request, response);
	}

}
