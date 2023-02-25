package dam2.add.p21.util;

import org.jasypt.util.password.StrongPasswordEncryptor;

import dam2.add.p21.model.Usuario;
import dam2.add.p21.servicios.UsuarioService;

//http://www.jasypt.org/
public class EncriptarJasypt {

	public static String encriptar(String password) {

		// ALTA
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(password);
		System.out.println("encriptado: " + encryptedPassword);
		return encryptedPassword;

	}

	public static boolean desencriptar(int id, String password) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		Usuario usuario = UsuarioService.obtener(id);
		// LOGIN
		if (passwordEncryptor.checkPassword(password, usuario.getPass())) {
			System.out.println("Clave correcta");
			return true;
		} else {
			System.out.println("Clave incorrecta");
			return false;
		}
	}

}
