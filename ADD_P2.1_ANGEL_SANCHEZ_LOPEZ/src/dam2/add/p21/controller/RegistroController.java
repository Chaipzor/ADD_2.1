package dam2.add.p21.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.config.Conexion;
import dam2.add.p21.dao.UsuarioDAO;
import dam2.add.p21.dao.UsuarioDAO_OLD;
import dam2.add.p21.dao.mysql.MySQLUsuarioDAO;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroController() {
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
		String referencia = "/jsp/registro.jsp";
		boolean repetir = false;

		// Obtenemos los datos de registro del formulario
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// Se comprueba el email introducido
		int comprobacion = new UsuarioService().comprobarEmail(email);
		// Si ya estaba registrado
		if (comprobacion != -1) {
			texto = "Email ya registrado.";
			referencia = "/jsp/registro.jsp";
		} // Si no existía
		else {
			// Se comprueba la doble contraseña
			boolean comprobacionDoblePass = new UsuarioService().comprobacionDoblePass(pass, pass2);
			if (!comprobacionDoblePass) {
				texto = "Las contraseñas no coinciden.";
			} else {
				texto = "Usuario registrado.";
				//UsuarioDAO_OLD.setListaUsuarios(new Usuario(nombre, apellidos, email, telefono, pass, false));
				
				try {
					Connection conn = null;
					conn = Conexion.getConexion();
					Statement st = conn.createStatement();
					UsuarioDAO usuario = new MySQLUsuarioDAO(conn);
					usuario.insertar(new Usuario(nombre, apellidos, email, telefono, pass, false));
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ArrayList<Usuario> listaContactos = UsuarioDAO_OLD.getListaUsuariosNoAdmin();
		request.getSession().setAttribute("listaContactos", listaContactos);
		request.setAttribute("repetir", repetir);
		request.setAttribute("texto", texto);
		request.getRequestDispatcher(referencia).forward(request, response);
	}

}
