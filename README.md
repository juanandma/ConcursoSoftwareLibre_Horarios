# ConcursoSoftwareLibre_Horarios
Concurso Universitario Software Libre 2019

Horarios para Alumnos

**Todavia contiene bugs esta aplicación**


Este proyecto ayuda a elegir cuales son las asignaturas que debería matricularse un alumno de Grado.

La aplicación permite elegir un conjunto de asignaturas, e indicar si tanto los horarios de teoría como de prácticas de todas las asignaturas, son compatibles entre sí.

Para más información sobre cómo están distribuidos los horarios de teoría y prácticas en las asignaturas de Grado, visitar:

[Horarios Grupo Grande (Teoría)](https://www.uhu.es/etsi/simplesml/www/Horario/xml/plantilla_xml_horarios_1.php?tit=2&year=2018)
[Horarios Grupos Reducidos (Prácticas)](http://www.uhu.es/etsi/informacion-academica/informacion-comun-todos-los-titulos/horarios-2/horarios-de-grupos-reducidos-curso-2018-19/?tit=2)


**REQUISITOS.**

	Windows 8/10. No se garantiza el funcionamiento en otras plataformas.
	MySQL.
	OpenJDK.

**INSTRUCCIONES DE INSTALACIÓN**

Para sistemas operativos Windows, 
Descargar el archivo .jar y el script [baseDeDatos.sql](https://github.com/juanandma/ConcursoSoftwareLibre_Horarios/blob/master/baseDeDatos.sql)
Crear una base de datos MySQL llamada ‘horarios’ y ejecutar las sentencias de tablas.sql.

*Atención: Existe un bug en el release. El hibernate.cfg.xml de Horarios.jar, a veces, no es capaz de realizar la conexión con la BD. Se recomienda ejecutar el proyecto en Netbeans*
	
Mas información en la [wiki](https://github.com/juanandma/ConcursoSoftwareLibre_Horarios/wiki/Instalaci%C3%B3n).

**INSTRUCCIONES DE COMPILACIÓN**

	git clone https://github.com/juanandma/ConcursoSoftwareLibre_Horarios.git

	O

	Descargar el proyecto en un zip, y luego importar al IDE que prefiera. Hemos usado OpenJDK, apache Netbeans y Maven.
	
	Para generar .jar, ejecutar "mvn package" en el directorio del proyecto.
	
**ACCESIBILIDAD**

El programa hace uso de una interfaz gráfica sencilla. Es accesible por personas con daltonismo.



*Todas las contribuciones son más que bienvenidas.*

Para mas información sobre el proyecto, visítanos nuestro blog en: https://horariosalumnosgrado.wordpress.com/
Y en la wiki.
