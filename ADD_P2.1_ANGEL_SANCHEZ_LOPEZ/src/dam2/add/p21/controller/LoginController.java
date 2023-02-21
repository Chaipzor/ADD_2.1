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
		int comprobacion = new UsuarioService().comprobarDatos(email, pass);
		// Usuario no existe.
		if (comprobacion == -1) {
			texto = "El email no está dado de alta.";
			referencia = "/jsp/registro.jsp";
		} // Contraseña incorrecta.
		else if (comprobacion == -2) {
			texto = "Contraseña incorrecta. Vuelva a intentarlo.";
			repetir = true;
			referencia = "/jsp/login.jsp";
		} // Login correcto
		else {
			String nombre = UsuarioDAO_OLD.getListaUsuarios().get(comprobacion).getNombre();
			request.getSession().setAttribute("nombresesion", nombre);
			request.getSession().setAttribute("id", comprobacion);
			String admin = String.valueOf(UsuarioDAO_OLD.getListaUsuarios().get(comprobacion).isRol_admin());
			request.getSession().setAttribute("admin", admin);
		}

		request.setAttribute("repetir", repetir);
		request.setAttribute("texto", texto);
		request.getRequestDispatcher(referencia).forward(request, response);
	}

}
