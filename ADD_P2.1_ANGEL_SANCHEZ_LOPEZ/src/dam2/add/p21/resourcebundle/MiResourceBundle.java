package dam2.add.p21.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class MiResourceBundle {

	private static String idioma;
	
	public static String traductor(String palabra) {
		Locale locale = new Locale(idioma);
		ResourceBundle rb = ResourceBundle.getBundle("idioma", locale);
		String cadena = rb.getString(palabra);
		return cadena;
	}

	public static void idiomaActivo(String idioma) {
		MiResourceBundle.idioma = idioma;
	}
	
}
