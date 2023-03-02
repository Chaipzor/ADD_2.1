package dam2.add.p21.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

public class Conexion {
	/*
	 * static String bd = "add_p21"; static String login = "root"; static String
	 * password = ""; static String host = "127.0.0.1"; // localhost
	 */

	static String bd = ConfigFichero.getParametro("bd.nombre");
	static String login = ConfigFichero.getParametro("bd.login");
	static String password = ConfigFichero.getParametro("bd.pass");
	static String host = ConfigFichero.getParametro("bd.host");
	
	static String url = "jdbc:mysql://";
	static Connection conexion; // Atributo para guardar el objeto Connection

	public static Connection getConexion() {
		if (conexion == null) {
			if(!crearConexion()) {
				System.out.println("Problema al crear la bbdd.");
			} else {
				Usuario.setIdGlobal(UsuarioService.getIdGlobal());
			}
		}
		return conexion;
	}

	// True si se crea correctamente.
	private static boolean crearConexion() {
		try {
			// cargo el driver
			Class.forName("com.mysql.cj.jdbc.Driver"); // Driver
			conexion = DriverManager.getConnection(url + host + "/" + bd, login, password);
			conexion.setAutoCommit(false);
		} catch (SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void desconectar() {
		try {
			conexion.close();
			conexion = null;
			System.out.println("La conexión a la BBDD se ha cerrado.");
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión.");
		}
	}

}
