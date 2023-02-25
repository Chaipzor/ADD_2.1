package dam2.add.p21.servicios;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import dam2.add.p21.dao.UsuarioDAOMemoria;
import dam2.add.p21.dao.UsuarioDAOMySQL;
import dam2.add.p21.interfaces.iUsuarioDAO;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.util.EncriptarJasypt;

public class UsuarioService {

	private static Logger log = Logger.getLogger("user");

	public static iUsuarioDAO udao = new UsuarioDAOMemoria();

	public static void persistencia(String tipo) {
		if (tipo.equalsIgnoreCase("bbdd")) {
			UsuarioService.udao = new UsuarioDAOMySQL();
		}
	}

	// Devuelve -1 si no existe el email o id en caso de que exista.
	public static int comprobarEmail(String email) {
		for (int i = 0; i < udao.obtenerTodos().size(); i++) {
			if (email.equalsIgnoreCase(udao.obtenerTodos().get(i).getEmail())) {
				return udao.obtenerTodos().get(i).getId();
			}
		}
		return -1;
	}

	// Devuelve la id del email si coincide la contraseña. Sino devuelve -2.
	public static int comprobarPass(int comprobacionEmail, String pass) {
		if (EncriptarJasypt.desencriptar(comprobacionEmail, pass)) {
			return comprobacionEmail;
		}
		return -2;
	}

	// Devuelve la id si es correcto el email y la contraseña, -1 si no existe el
	// email y -2 si la contraseña es incorrecta.
	public static int comprobarDatos(String email, String pass) {
		int comprobacionEmail = comprobarEmail(email);
		if (comprobacionEmail != -1) {
			
				log.info("Contraseña incorrecta para el Email: " + email);

				log.info("Datos correctos. Email: " + email);
		
			return comprobarPass(comprobacionEmail, pass);
		} else
			log.info("Email no existe: " + email);
		return -1;
	}

	// Comprueba si las 2 contraseñas son iguales.
	public static boolean comprobacionDoblePass(String pass, String pass2) {
		if (pass.equals(pass2)) {
			return true;
		}
		return false;
	}

	
	//Obtener usuario por ID.
	public static Usuario obtener(int id) {
		ArrayList<Usuario> listaUsuarios = udao.obtenerTodos();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario u = listaUsuarios.get(i);
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public static void eliminar(int id) {

		udao.eliminar(id);
		log.info("Eliminación de usuario id: " + id);
	}

	public static ArrayList<Usuario> obtenerTodos() {
		return udao.obtenerTodos();
	}

	public static ArrayList<Usuario> obtenerTodosSinAdmin() {
		return udao.obtenerTodosSinAdmin();
	}

	public static void crearUsuario(Usuario u) {
		udao.crearUsuario(u);
		log.info("Creación del usuario: " + u.getId());
	}

	public static void modificarUsuario(int posicion, int id, String nombre, String apellidos, String email,
			int telefono) {
		Usuario u = UsuarioService.obtener(id);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setEmail(email);
		u.setTelefono(telefono);
		u.setPass(EncriptarJasypt.encriptar(u.getPass()));
		u.setId(u.getId());
		udao.modificarUsuario(id, u);
		log.info("Modificación del usuario: " + id);
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
		for (int i = 0; i < listaContactos.size(); i++) {
			if (x < listaContactos.get(i).getId()) {
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
