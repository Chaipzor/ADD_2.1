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
 * Servlet implementation class EditarDatosController
 */
@WebServlet("/editar")
public class EditarDatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarDatosController() {
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
		int id = 0;
		String texto = "";
		String referencia = "/jsp/perfil.jsp";

		// Obtenemos los parámetros introducidos por el usuario
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		Integer telefono = Integer.parseInt(request.getParameter("telefono"));
		String tlf = telefono.toString();

		// Comprobamos si hay editid (sólo disponible desde un usuario administrador)
		if (request.getSession().getAttribute("editid") != null) {
			id = (Integer) request.getSession().getAttribute("editid");
		} else {
			// Comprobamos si el perfil a editar es el del propio administrador o el de
			// cualquier usuario
			id = (Integer) request.getSession().getAttribute("id");
		}
		Usuario usuario = UsuarioService.obtener(id);
		int posicion = UsuarioService.obtenerPosicion(id);
		
		
		// Comparamos los emails
		if (!email.equalsIgnoreCase(usuario.getEmail())) {
			// Si son diferentes entramos por aquí y comprobamos si existe (comprobacion =
			// -1) o no (!= -1)
			int comprobacion = UsuarioService.comprobarEmail(email);
			if (comprobacion != -1) {
				texto = "Email ya registrado.";
				referencia = "/jsp/perfil_editable.jsp";
			} else {
				UsuarioService.modificarUsuario(posicion, id, nombre, apellidos, email, telefono);
			}
		} else {
			// Si los emails coincidian
			UsuarioService.modificarUsuario(posicion, id, nombre, apellidos, email, telefono);
		}
		// Seteamos los atributos para la nueva carga de los datos en pantalla
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellidos", apellidos);
		request.setAttribute("email", email);
		request.setAttribute("telefono", tlf);
		request.setAttribute("texto", texto);
		request.getRequestDispatcher(referencia).forward(request, response);
	}

}
