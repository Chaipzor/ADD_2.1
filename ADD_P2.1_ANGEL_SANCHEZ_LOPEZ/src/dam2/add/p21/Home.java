package dam2.add.p21;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.dao.UsuarioDAO_OLD;
import dam2.add.p21.model.Usuario;

/**
 * Servlet implementation class index A través de esta clase conseguimos acceder
 * a la web por la url vacía y sin / al final, y redireccionar de forma limpia
 * al index.
 */
@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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

		// Carga el listado de usuarios inicial y redirige al index
		ArrayList<Usuario> listaContactos = UsuarioDAO_OLD.getListaUsuariosNoAdmin();
		request.getSession().setAttribute("listaContactos", listaContactos);
		request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
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
