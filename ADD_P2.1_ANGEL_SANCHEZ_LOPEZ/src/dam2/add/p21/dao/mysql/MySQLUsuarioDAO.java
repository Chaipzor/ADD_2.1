package dam2.add.p21.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dam2.add.p21.config.Conexion;
import dam2.add.p21.dao.UsuarioDAO;
import dam2.add.p21.model.Usuario;

public class MySQLUsuarioDAO implements UsuarioDAO {

	final String INSERT = "INSERT INTO usuarios(nombre, apellidos, email, telefono, pass, rol_admin) VALUES(?,?,?,?,?,?)";
	final String UPDATE = "UPDATE usuarios SET nombre ? =, apellidos = ?, email = ?, telefono = ?, pass = ? WHERE id = ?";
	final String DELETE = "DELETE FROM usuarios WHERE id = ?";
	final String GETALL = "SELECT * FROM usuarios";
	final String GETONE = "SELECT * FROM usuarios WHERE id = ?";

	private Connection conn;

	public MySQLUsuarioDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Usuario a) throws SQLException {
		PreparedStatement stat = null;
		stat = conn.prepareStatement(INSERT);
		stat.setString(1, a.getNombre());
		stat.setString(2, a.getApellidos());
		stat.setString(3, a.getEmail());
		stat.setInt(4, a.getTelefono());
		stat.setString(5, a.getPass());
		stat.setBoolean(6, a.isRol_admin());
		if (stat.executeUpdate() == 0) {
			System.out.println("Puede que no se haya insertado el nuevo usuario.");
		}

		stat.close();

	}

	@Override
	public void modificar(Usuario a) throws SQLException {
		PreparedStatement stat = null;
		stat = conn.prepareStatement(UPDATE);
		stat.setString(1, a.getNombre());
		stat.setString(2, a.getApellidos());
		stat.setString(3, a.getEmail());
		stat.setInt(4, a.getTelefono());
		stat.setString(5, a.getPass());
		int filas = stat.executeUpdate();
		System.out.println(filas + " filas actualizadas.");

	}

	@Override
	public void eliminar(Usuario a) throws SQLException{
		PreparedStatement stat = null;
		stat = conn.prepareStatement(DELETE);
		stat.setInt(7, a.getId());
		int filas = stat.executeUpdate();
		System.out.println(filas + " filas eliminadas.");
	}

	@Override
	public List<Usuario> obtenerTodos() throws Exception {
		PreparedStatement stat = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while (rs.next()) {
				usuarios.add(convertir(rs));
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

	@Override
	public Usuario obtener(Long id) throws SQLException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Usuario u = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setLong(1, id);
			rs = stat.executeQuery();
			if (rs.next()) {
				u = convertir(rs);
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
		return u;
	}

	private Usuario convertir(ResultSet rs) throws SQLException {
		String nombre = rs.getString("nombre");
		String apellidos = rs.getString("apellidos");
		String email = rs.getString("email");
		int telefono = rs.getInt("telefono");
		String pass = rs.getString("pass");
		boolean rol_admin = rs.getBoolean("rol_admin");
		Usuario usuario = new Usuario(nombre, apellidos, email, telefono, pass, rol_admin);
		// usuario.setId(rs.getLong("id"));
		return usuario;
	}
	
}
