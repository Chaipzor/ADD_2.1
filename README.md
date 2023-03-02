# ADD_2.1
Acceso a Datos 2.1


(Esta información viene en el readme.md del repositorio):

# Enunciado
Dota a la Práctica 2.1 de Desarrollo de Interfaces de un sistema de persistencia de datos utilizando una base de datos MySQL mediante el conector JDBC. Se recomienda hacer una copia del proyecto y trabajar sobre ella, estableciendo las operaciones necesarias de lectura, escritura, etc. a través de la base de datos.

Haciendo uso del patrón DAO, haz que al iniciar el programa se determine el método de persistencia, seleccionando así si los usuarios se gestionarán a través de una estructura en memoria o de una base de datos. De esta forma, todo el manejo de datos de usuarios vendrá determinado por el modo de persistencia elegido. Se propone que, al arrancar el programa, se lea una tabla de configuración dónde vendrá determinado el sistema de persistencia a utilizar.

De igual forma, dota a la interfaz del programa de internacionalización (como mínimo en español e inglés). En lugar de mostrar cadenas explícitas, se deberán de obtener del correspondiente fichero de propiedades, según el idioma seleccionado. Dicho idioma se seleccionará al iniciar la aplicación, dando la opción al usuario de elegir entre los idiomas disponibles. Los ficheros de propiedades de idiomas se almacenarán en una carpeta /i18n (idioma_es.properties, idioma_en.properties, etc.).

Almacena el idioma por defecto del usuario con el que cargará el programa, modificándose si al iniciar la aplicación seleccionamos un idioma diferente al de por defecto, por lo tanto, al volver a iniciar el programa, la interfaz se mostrará con el último idioma seleccionado. Recordad que lo primero que debe aparecer es la selección de idioma, mostrando esta selección en el idioma por defecto, pudiendo cambiar dicho idioma. Si no lo cambiamos o seleccionamos el mismo, se mantendrá el idioma por defecto.

Además de las salidas por consola en el idioma seleccionado, se registrarán los accesos y uso de la aplicación mediante trazas en un fichero con la librería log4j. Su configuración se hará a través de un fichero de propiedades log4j.properties. Los datos de acceso a la base de datos deberán leerse de un fichero bbdd.properties. Los datos de conexión a utilizar para la base de datos deberán ser:

servidor: localhost

base de datos: p21

usuario: root (sin contraseña)

Todos los ficheros de propiedades utilizados en la aplicación deberán almacenarse dentro de una carpeta /properties (a excepción de los destinados a la internacionalización).

Las contraseñas almacenadas deberán ir encriptadas, para ello puedes utilizar la librería jasypt o cualquier otra que consideres.

A la hora de la entrega, se creará una carpeta /sql en el raíz del proyecto incluyendo el script de exportación de la base de datos, tablas y datos iniciales necesarios para el manejo de la aplicación (p21.sql), así como el esquema entidad-relación de dicha base de datos.

Como ampliación, incluye una funcionalidad adicional a los usuarios con rol administrador que permita configurar de una manera más cómoda el modo de persistencia utilizado en la aplicación, así como cualquier otro parámetro que se considere, a modo de configuración del sistema.

# Desarrollo
Se ha realizado el desarrollo completo de la aplicación a excepción de la ampliación

- El archivo "registro.log" no se guarda en la ruta prevista. Se guarda en la ruta de instalación de eclipse (normalmente: C/Archivos de programa/Eclipse)
- Todas las contraseñas por defecto son "1234" con su encriptación correspondiente
- Al pulsar en las banderas en la parte derecha del header, nos redirigirá al index cambiando al idioma correspondiente.
- Cada usuario tiene por defecto el último idioma que utilizó en la web en su anterior sesión.
