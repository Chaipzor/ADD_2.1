package dam2.add.p21;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.add.p21.config.ConfigInicio;
import dam2.add.p21.log.MiLog;
import dam2.add.p21.resourcebundle.MiResourceBundle;
import dam2.add.p21.servicios.UsuarioService;
import dam2.add.p21.util.Rutas;

/**
 * Servlet implementation class index A través de esta clase conseguimos acceder
 * a la web por la url vacía y sin / al final, y redireccionar de forma limpia
 * al index.
 */
@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @return
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
		//Idioma por defecto al entrar a la web.
		final String IDIOMA = "es";
		
		// Cargamos el path para leer el fichero.
		String ruta = (request.getServletContext().getRealPath(""));
		Rutas.recibePath(ruta);
		System.out.println("Ruta " + ruta);
		ConfigInicio.cargar();

		// Se aplica el idioma por defecto sin usuarios activos.
		request.getSession().setAttribute("idioma", IDIOMA);
		MiResourceBundle.idiomaActivo(IDIOMA);
		MiLog.activarLog();
		
		
		// Carga el listado de usuarios inicial y redirige al index
		request.getSession().setAttribute("listaContactos", UsuarioService.obtenerTodosSinAdmin());
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
