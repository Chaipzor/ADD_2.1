package dam2.add.p21.servicios;

import java.util.ArrayList;

import dam2.add.p21.dao.UsuarioDAO_OLD;
import dam2.add.p21.model.Usuario;

public class UsuarioService {

	// Devuelve -1 si no existe el email o "i" en caso de que exista.
	public int comprobarEmail(String email) {
		int comprobacion = 0;
		for (int i = 0; i < UsuarioDAO_OLD.getListaUsuarios().size(); i++) {
			if (email.equalsIgnoreCase(UsuarioDAO_OLD.getListaUsuarios().get(i).getEmail())) {
				return comprobacion;
			}
		}
		return -1;
	}

	// Devuelve el id del email si coincide la contraseña. Sino devuelve -2.
	public int comprobarPass(int comprobacionEmail, String pass) {
		if (pass.equals(UsuarioDAO_OLD.getListaUsuarios().get(comprobacionEmail).getPass())) {
			return comprobacionEmail;
		}
		return -2;
	}

	// Devuelve el id si es correcto el email y la contraseña, -1 si no existe el
	// email y -2 si la contraseña es incorrecta.
	public int comprobarDatos(String email, String pass) {
		int comprobacionEmail = comprobarEmail(email);
		if (comprobacionEmail != -1) {
			int comprobacionPass = comprobarPass(comprobacionEmail, pass);
			return comprobacionPass;
		} else {
			return -1;
		}
	}

	// Comprueba si las 2 contraseñas son iguales.
	public boolean comprobacionDoblePass(String pass, String pass2) {
		if (pass.equals(pass2)) {
			return true;
		}
		return false;
	}

	public int buscarUsuario(int id) {
		ArrayList<Usuario> listaContactos = UsuarioDAO_OLD.getListaUsuarios();
		int pos = 0;
		do {
			if (listaContactos.get(pos).getId() == id) {
				return pos;
			}
			pos++;
		} while (pos < listaContactos.size());
		return -1;
	}

}
