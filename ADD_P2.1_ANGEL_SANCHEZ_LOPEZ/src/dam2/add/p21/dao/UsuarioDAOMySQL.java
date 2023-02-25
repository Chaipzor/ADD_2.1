package dam2.add.p21.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dam2.add.p21.config.Conexion;
import dam2.add.p21.interfaces.iUsuarioDAO;
import dam2.add.p21.model.Usuario;

public class UsuarioDAOMySQL implements iUsuarioDAO{

	final String INSERT = "INSERT INTO usuarios(nombre, apellidos, email, telefono, pass, rol_admin, id, idioma) VALUES(?,?,?,?,?,?,?,?)";
	final String UPDATE = "UPDATE usuarios SET nombre = ?, apellidos = ?, email = ?, telefono = ?, idioma = ? WHERE id = ?";
	final String DELETE = "DELETE FROM usuarios WHERE id = ?";
	final String GETALL = "SELECT * FROM usuarios";
	final String GETONE = "SELECT * FROM usuarios WHERE id = ?";

	public void crearUsuario(Usuario u) {
		Connection conn = Conexion.getConexion();
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setString(1, u.getNombre());
			stat.setString(2, u.getApellidos());
			stat.setString(3, u.getEmail());
			stat.setInt(4, u.getTelefono());
			stat.setString(5, u.getPass());
			stat.setBoolean(6, u.isRol_admin());
			stat.setInt(7, u.getId());
			stat.setString(8, u.getIdioma());
			if (stat.executeUpdate() == 0) {
				System.out.println("Puede que no se haya insertado el nuevo usuario.");
			}
			conn.commit();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificarUsuario(int id, Usuario u) {
		Connection conn = Conexion.getConexion();
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, u.getNombre());
			stat.setString(2, u.getApellidos());
			stat.setString(3, u.getEmail());
			stat.setInt(4, u.getTelefono());
			stat.setString(5, u.getIdioma());
			stat.setInt(6, id);
			int filas = stat.executeUpdate();
			System.out.println(filas + " filas actualizadas.");
			conn.commit();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminar(int id) {
		Connection conn = Conexion.getConexion();
		PreparedStatement stat = null;
		int filas = 0;
		try {
			stat = conn.prepareStatement(DELETE);
			stat.setInt(1, id);
			filas = stat.executeUpdate();
			conn.commit();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(filas + " filas eliminadas.");
	}

	// TO DO!!
	public ArrayList<Usuario> obtenerTodosSinAdmin() {
		Connection conn = Conexion.getConexion();
		PreparedStatement stat = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while (rs.next()) {
				if(!rs.getBoolean(6)) {
					Usuario u = new Usuario();
					u.setNombre(rs.getString(1));
					u.setApellidos(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setTelefono(rs.getInt(4));
					u.setPass(rs.getString(5));
					u.setRol_admin(rs.getBoolean(6));
					u.setId(rs.getInt(7));
					u.setIdioma(rs.getString(8));
					usuarios.add(u);
				}
			}
		} catch (SQLException ex) {
			System.out.println("Error al obtener.");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error en SQL");
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					System.out.println("Error en SQL");
				}
			}
		}
		return usuarios;
	}

	public ArrayList<Usuario> obtenerTodos() {
		Connection conn = Conexion.getConexion();
		PreparedStatement stat = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNombre(rs.getString(1));
				u.setApellidos(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setTelefono(rs.getInt(4));
				u.setPass(rs.getString(5));
				u.setRol_admin(rs.getBoolean(6));
				u.setId(rs.getInt(7));
				u.setIdioma(rs.getString(8));
				usuarios.add(u);
			}
		} catch (SQLException ex) {
			System.out.println("Error al obtener.");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error en SQL");
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					System.out.println("Error en SQL");
				}
			}
		}
		return usuarios;
	}

	public Usuario obtener(int id) {
		Connection conn = Conexion.getConexion();
		PreparedStatement stat = null;
		ResultSet rs = null;
		Usuario usuario = new Usuario();
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if (rs.next()) {
				usuario.setNombre(rs.getString(1));
				usuario.setApellidos(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				usuario.setTelefono(rs.getInt(4));
				usuario.setEmail(rs.getString(5));
				usuario.setIdioma(rs.getString(6));
			}
		} catch (SQLException ex) {
			System.out.println("Error al obtener.");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Error en SQL");
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					System.out.println("Error en SQL");
				}
			}
		}
		return usuario;
	}
}
