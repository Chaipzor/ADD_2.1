package dam2.add.p21.servicios;

import java.util.ArrayList;

import dam2.add.p21.dao.UsuarioDAOMemoria;
import dam2.add.p21.dao.UsuarioDAOMySQL;
import dam2.add.p21.interfaces.iUsuarioDAO;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.resourcebundle.MiResourceBundle;

public class UsuarioService {

	//public static iUsuarioDAO udaomem = new UsuarioDAOMemoria();
	public static iUsuarioDAO udao = new UsuarioDAOMemoria();

	public static void persistencia(String tipo) {
		if(tipo.equalsIgnoreCase("bbdd")) {
			 UsuarioService.udao = new UsuarioDAOMySQL();
		}
	}
	
	// Devuelve -1 si no existe el email o "i" en caso de que exista.
	public static int comprobarEmail(String email) {
		for (int i = 0; i < udao.obtenerTodos().size(); i++) {
			if (email.equalsIgnoreCase(udao.obtenerTodos().get(i).getEmail())) {
				return i;
			}
		}
		return -1;
	}

	// Devuelve el id del email si coincide la contraseña. Sino devuelve -2.
	public static int comprobarPass(int comprobacionEmail, String pass) {
		if (pass.equals(udao.obtenerTodos().get(comprobacionEmail).getPass())) {
			return comprobacionEmail;
		}
		return -2;
	}

	// Devuelve el id si es correcto el email y la contraseña, -1 si no existe el
	// email y -2 si la contraseña es incorrecta.
	public static int comprobarDatos(String email, String pass) {
		int comprobacionEmail = comprobarEmail(email);
		if (comprobacionEmail != -1) {
			return comprobarPass(comprobacionEmail, pass);
		} else {
			return -1;
		}
	}

	// Comprueba si las 2 contraseñas son iguales.
	public static boolean comprobacionDoblePass(String pass, String pass2) {
		if (pass.equals(pass2)) {
			return true;
		}
		return false;
	}

	public static Usuario obtener(int id) {
		ArrayList<Usuario> listaContactos = udao.obtenerTodos();
		for (int i = 0; i < listaContactos.size(); i++) {
			Usuario u = listaContactos.get(i);
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public static void eliminar(int id) {

		udao.eliminar(id);
	}

	public static ArrayList<Usuario> obtenerTodos() {
		return udao.obtenerTodos();
	}

	public static ArrayList<Usuario> obtenerTodosSinAdmin() {
		return udao.obtenerTodosSinAdmin();
	}

	public static void crearUsuario(Usuario u) {
		udao.crearUsuario(u);
	}

	public static void modificarUsuario(int posicion, int id, String nombre, String apellidos, String email,
			int telefono) {
		Usuario u = UsuarioService.obtener(id);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setEmail(email);
		u.setTelefono(telefono);
		u.setPass(u.getPass());
		u.setId(u.getId());
		udao.modificarUsuario(id, u);
	}

	// Devuelve la posición en la lista del usuario con esa id.
	public static int obtenerPosicion(int id) {
		ArrayList<Usuario> listaContactos = udao.obtenerTodos();
		for (int i = 0; i < listaContactos.size(); i++) {
			if (listaContactos.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getIdGlobal() {
		ArrayList<Usuario> listaContactos = udao.obtenerTodos();
		int x = 0;
		for(int i = 0; i < listaContactos.size(); i++) {
			if(x < listaContactos.get(i).getId()) {
				x = listaContactos.get(i).getId();
			}
		}
		return x;
	}

	public static void actualizarIdioma(int id, String idioma) {
		Usuario u = UsuarioService.obtener(id);
		u.setIdioma(idioma);
		udao.modificarUsuario(id, u);
	}
	
}
