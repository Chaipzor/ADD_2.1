package dam2.add.p21.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAO_OLD;
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
		ArrayList<Usuario> listaContactos = UsuarioDAO_OLD.getListaUsuarios();
		String referencia = "./jsp/index.jsp";
		int posicion = -1;

		// Si se quiere eliminar un usuario
		if (request.getParameter("del") != null) {
			// Busca la posición en el array del usuario "id".
			int id = Integer.parseInt(request.getParameter("del"));
			posicion = new UsuarioService().buscarUsuario(id);

			if (posicion != -1) {
				// Si existe el usuario lo elimina.
				UsuarioDAO_OLD.deleteUser(posicion);
			}
			// Si se quiere editar un usuario
		} else if (request.getParameter("edit") != null) {
			int id = Integer.parseInt(request.getParameter("edit"));
			posicion = new UsuarioService().buscarUsuario(id);

			if (posicion != -1) {
				// Seteamos los atributos para que aparezcan rellenos en la vista del perfil del
				// usuario seleccionado
				referencia = "./jsp/perfil_editable.jsp";
				request.setAttribute("nombre", UsuarioDAO_OLD.getListaUsuarios().get(posicion).getNombre());
				request.setAttribute("apellidos", UsuarioDAO_OLD.getListaUsuarios().get(posicion).getApellidos());
				request.setAttribute("email", UsuarioDAO_OLD.getListaUsuarios().get(posicion).getEmail());
				String telefono = String.valueOf(UsuarioDAO_OLD.getListaUsuarios().get(posicion).getTelefono());
				request.setAttribute("telefono", telefono);
				request.getSession().setAttribute("editid", id);
				request.getSession().setAttribute("emailsesion",
						UsuarioDAO_OLD.getListaUsuarios().get(posicion).getEmail());
			}

		}
		// Actualizamos la lista de contactos de la sesión
		listaContactos = UsuarioDAO_OLD.getListaUsuariosNoAdmin();
		request.getSession().setAttribute("listaContactos", listaContactos);
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
