package dam2.add.p21.config;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import dam2.add.p21.util.Rutas;

/**
 * Funciones auxiliares
 */
public class ConfigFichero {
	
	//private static HashMap<String, String> parametros = new HashMap<String, String>();
    private static Properties properties = null;
    
        
    private ConfigFichero(String fichero) {
        properties = new Properties();
        try {
        	properties.load(new FileInputStream(fichero));
        } catch (IOException ex) {
        	System.out.println("NO existe el fichero de propiedades");
        	ex.printStackTrace();
        }
    }//Configuration
 
    /**
     * Implementando Singleton
     *
     * @return
     */
    public static ConfigFichero getInstance(String fichero) {
        return new ConfigFichero(fichero);
    }

	public static String getParametro(String parametro) {				
		String ficheroConf = Rutas.path + "\\properties\\bbdd.properties";
		if(properties==null) {
			ConfigFichero.getInstance(ficheroConf);
		}
		
		String param = properties.getProperty(parametro);
		return param;
	}
}
