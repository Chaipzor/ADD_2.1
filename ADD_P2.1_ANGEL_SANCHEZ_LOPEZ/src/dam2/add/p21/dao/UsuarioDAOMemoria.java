package dam2.add.p21.dao;


import java.util.ArrayList;

import dam2.add.p21.interfaces.iUsuarioDAO;
import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

public class UsuarioDAOMemoria implements iUsuarioDAO{
		
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>() {
		{
			add(new Usuario("Angel", "Sanchez Lopez", "chaip@gmail.com", 666555444, "1234", true, "es"));
			add(new Usuario("Michael", "Jackson", "MJ@gmail.com", 111111111, "1234", false, "en"));
			add(new Usuario("Paco", "Hernandez", "PH@gmail.com", 999999999, "1234", false, "es"));
			add(new Usuario("A", "A", "A@gmail.com", 999999999, "1234", false, "es"));
			add(new Usuario("B", "B", "B@gmail.com", 999999999, "1234", true, "es"));
			add(new Usuario("C", "C", "C@gmail.com", 999999999, "1234", false, "es"));
		}
	};

	public ArrayList<Usuario> obtenerTodos() {
		return listaUsuarios;
	}

	public ArrayList<Usuario> obtenerTodosSinAdmin() {
		ArrayList<Usuario> listaSinAdmins = new ArrayList<Usuario>();
		for (Usuario usuario : listaUsuarios) {
			if (!usuario.isRol_admin()) {
				listaSinAdmins.add(usuario);
			}
		}

		return listaSinAdmins;
	}

	public void crearUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}

	public void modificarUsuario(int id, Usuario u) {
		int posicion= UsuarioService.obtenerPosicion(id);
		listaUsuarios.get(posicion).setNombre(u.getNombre());
		listaUsuarios.get(posicion).setApellidos(u.getApellidos());
		listaUsuarios.get(posicion).setEmail(u.getEmail());
		listaUsuarios.get(posicion).setTelefono(u.getTelefono());
		listaUsuarios.get(posicion).setIdioma(u.getIdioma());
	}

	public void eliminar(int id) {
		
		listaUsuarios.remove(UsuarioService.obtenerPosicion(id));
	}
	
	public Usuario obtener(int id){
		return listaUsuarios.get(UsuarioService.obtenerPosicion(id));
	}

}
