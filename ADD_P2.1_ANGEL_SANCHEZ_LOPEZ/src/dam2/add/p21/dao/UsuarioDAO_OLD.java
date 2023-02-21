package dam2.add.p21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import dam2.add.p21.config.Conexion;
import dam2.add.p21.interfaces.iUsuario;
import dam2.add.p21.model.Usuario;

public class UsuarioDAO_OLD implements iUsuario<Usuario> {
		
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>() {
		{
			add(new Usuario("Angel", "Sanchez Lopez", "chaip@gmail.com", 666555444, "1234", true));
			add(new Usuario("Michael", "Jackson", "MJ@gmail.com", 111111111, "1234", false));
			add(new Usuario("Paco", "Hernandez", "PH@gmail.com", 999999999, "1234", false));
			add(new Usuario("A", "A", "A@gmail.com", 999999999, "1234", false));
			add(new Usuario("B", "B", "B@gmail.com", 999999999, "1234", true));
			add(new Usuario("C", "C", "C@gmail.com", 999999999, "1234", false));
		}
	};

	public static ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public static ArrayList<Usuario> getListaUsuariosNoAdmin() {
		ArrayList<Usuario> listaSinAdmins = new ArrayList<Usuario>();
		for (Usuario usuario : listaUsuarios) {
			if (!usuario.isRol_admin()) {
				listaSinAdmins.add(usuario);
			}
		}

		return listaSinAdmins;
	}

	public static void setListaUsuarios(Usuario usuario) {
		listaUsuarios.add(usuario);
	}

	public static void editUser(int id, String nombre, String apellidos, String email, int telefono) {
		UsuarioDAO_OLD.getListaUsuarios().get(id).setNombre(nombre);
		UsuarioDAO_OLD.getListaUsuarios().get(id).setApellidos(apellidos);
		UsuarioDAO_OLD.getListaUsuarios().get(id).setEmail(email);
		UsuarioDAO_OLD.getListaUsuarios().get(id).setTelefono(telefono);
	}

	public static void deleteUser(int id) {
		listaUsuarios.remove(id);
	}

}
