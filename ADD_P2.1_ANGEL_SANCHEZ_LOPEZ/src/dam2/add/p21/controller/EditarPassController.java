package dam2.add.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAO_OLD;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

/**
 * Servlet implementation class EditarDatosController
 */
@WebServlet("/editarpass")
public class EditarPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarPassController() {
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
		String texto = "";
		String referencia = "/jsp/perfil_edit_pass.jsp";
		int id = (int) request.getSession().getAttribute("id");

		int posicion = new UsuarioService().buscarUsuario(id);
		
		// Recibimos la info. del usuario
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String newPass2 = request.getParameter("newPass2");
		String actualPass = UsuarioDAO_OLD.getListaUsuarios().get(id).getPass();

		

		// Comparamos las contraseñas
		if (!oldPass.equals(actualPass)) {
			texto = "La contraseña introducida no es la actual.";
		} else {
			if (newPass.equals(newPass2)) {
				UsuarioDAO_OLD.getListaUsuarios().get(posicion).setPass(newPass);
				texto = "Contraseña modificada con éxito.";
				request.setAttribute("nombre", UsuarioDAO_OLD.getListaUsuarios().get(posicion).getNombre());
				request.setAttribute("apellidos", UsuarioDAO_OLD.getListaUsuarios().get(posicion).getApellidos());
				request.setAttribute("email", UsuarioDAO_OLD.getListaUsuarios().get(posicion).getEmail());
				String tlf = String.valueOf(UsuarioDAO_OLD.getListaUsuarios().get(posicion).getTelefono());
				request.setAttribute("telefono", tlf);
				referencia = "/jsp/perfil.jsp";
			} else {
				texto = "Las contraseñas no coinciden.";
			}
		}
		request.setAttribute("texto", texto);
		request.getRequestDispatcher(referencia).forward(request, response);
		
	}

}
