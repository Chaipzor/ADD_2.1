package dam2.add.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAOMemoria;
import dam2.add.p21.resourcebundle.MiResourceBundle;
import dam2.add.p21.servicios.UsuarioService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String texto = "";
		String referencia = "/jsp/index.jsp";
		boolean repetir = false;

		// Obtenemos los datos del login
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		// Comprobamos los datos
		int id = UsuarioService.comprobarDatos(email, pass);
		int posicion = UsuarioService.obtenerPosicion(id);
		// Usuario no existe.
		if (posicion == -1) {
			texto = "El email no está dado de alta.";
			referencia = "/jsp/registro.jsp";
		} // Contraseña incorrecta.
		else if (posicion == -2) {
			texto = "Contraseña incorrecta. Vuelva a intentarlo.";
			repetir = true;
			referencia = "/jsp/login.jsp";
		} // Login correcto
		else {
			String nombre = UsuarioService.obtenerTodos().get(posicion).getNombre();
			request.getSession().setAttribute("nombresesion", nombre);
			request.getSession().setAttribute("id", UsuarioService.obtenerTodos().get(posicion).getId());
			String admin = String.valueOf(UsuarioService.obtenerTodos().get(posicion).isRol_admin());
			request.getSession().setAttribute("admin", admin);
			MiResourceBundle.idiomaActivo(UsuarioService.obtenerTodos().get(posicion).getIdioma());
		}

		request.setAttribute("repetir", repetir);
		request.setAttribute("texto", texto);
		request.getRequestDispatcher(referencia).forward(request, response);
	}

}
