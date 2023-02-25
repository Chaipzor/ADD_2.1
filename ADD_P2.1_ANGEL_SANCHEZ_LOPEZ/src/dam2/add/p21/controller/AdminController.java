package dam2.add.p21.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAOMemoria;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/edit_admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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
		String referencia = "./jsp/index.jsp";
		Usuario usuario = null;

		// Si se quiere eliminar un usuario
		if (request.getParameter("del") != null) {
			// Busca la posición en el array del usuario "id".
			int id = Integer.parseInt(request.getParameter("del"));

			usuario = UsuarioService.obtener(id);

			if (usuario != null) {
				// Si existe el usuario lo elimina.
				UsuarioService.eliminar(usuario.getId());
			}

			// Si se quiere editar un usuario
		} else if (request.getParameter("edit") != null) {
			int id = Integer.parseInt(request.getParameter("edit"));
			usuario = UsuarioService.obtener(id);

			if (usuario != null) {
				// Seteamos los atributos para que aparezcan rellenos en la vista del perfil del
				// usuario seleccionado
				referencia = "./jsp/perfil_editable.jsp";
				request.setAttribute("nombre", usuario.getNombre());
				request.setAttribute("apellidos", usuario.getApellidos());
				request.setAttribute("email", usuario.getEmail());
				String telefono = String.valueOf(usuario.getTelefono());
				request.setAttribute("telefono", telefono);
				request.getSession().setAttribute("editid", id);
				request.getSession().setAttribute("emailsesion",
						usuario.getEmail());
			}

		}
		// Actualizamos la lista de contactos de la sesión
		request.getSession().setAttribute("listaContactos", UsuarioService.obtenerTodosSinAdmin());
		request.getRequestDispatcher(referencia).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
