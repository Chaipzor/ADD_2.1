package dam2.add.p21.log;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import dam2.add.p21.util.Rutas;

//https://logging.apache.org/log4j/1.2/apidocs/index.html
//http://programacion.jias.es/2013/03/log4j-tutorial-configuracion-rapida/
//http://migranitodejava.blogspot.com/2011/07/log4j.html

public class MiLog {

	private static Logger log = Logger.getLogger(MiLog.class);

	public static void activarLog() {
		// Configuracion a traves de fichero de propiedades
		String path = Rutas.path;
		String path_log4j = path + "\\properties\\log4j.properties";

		Properties p = new Properties();
		// Set server log file location
		
		try (FileInputStream fis = new FileInputStream(path_log4j)) {
			p.load(fis);
			String actionLogFilePath = path + "\\log\\registro.log";
			p.setProperty("log4j.appender.miLogFichero.File", actionLogFilePath);
			PropertyConfigurator.configure(path_log4j);
			System.out.println(p.getProperty("log4j.appender.miLogFichero.File"));
			Logger.getLogger("generic")
					.info("Path " + p.getProperty("log4j.appender.miLogFichero.File"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("DEBUG");
		log.info("INFO");
		log.warn("WARN");
		log.error("ERROR");
		log.fatal("FATAL");

	}

}
