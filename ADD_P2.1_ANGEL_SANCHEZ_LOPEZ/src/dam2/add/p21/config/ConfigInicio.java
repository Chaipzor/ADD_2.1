package dam2.add.p21.config;

import dam2.add.p21.servicios.UsuarioService;

public class ConfigInicio {
	
	static String persistencia = ConfigFichero.getParametro("bd.persistencia");
	public static void cargar() {
		UsuarioService.persistencia(persistencia);
	}
}
