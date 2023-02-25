package dam2.add.p21.interfaces;

import java.util.ArrayList;

import dam2.add.p21.model.Usuario;

public interface iUsuarioDAO {

	public ArrayList<Usuario> obtenerTodos();
	
	public ArrayList<Usuario> obtenerTodosSinAdmin();
	
	public void crearUsuario(Usuario user);
	
	public void modificarUsuario(int id, Usuario u);
	
	public void eliminar(int id);
	
	public Usuario obtener(int id);
}
