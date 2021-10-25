#Question game

Hola soy Luis Herrera y este es mi juego de preguntas.

En la carpeta documentación encontrarás los documentos técnicos
del proyecto diagramas, Dll, entre otros.

En la carpeta proyecto encontrarás el código fuente desarrollado
en Java (11), en el IDE Eclipse con persistencia de datos en 
postgresSQL.

patrón de diseño dao.
Arquitectura acercándose a la hexagonal.

Para iniciar este proyecto debes:

+ Instalar PgAdmin4.
+ Crear la base de datos con el DLL (completo si quieres el
  banco de preguntas base).
+ Configura el driver de postgres en tu proyecto y asegura las
  configuraciones de conexiones en la clase ConnectionPostgres
  situada en el paquete repositorio.
+ Ejecuta en el paquete principal el archivo Main y con eso ya
  deberías de estar observando la ventana principal.
  
  Agrega un participante y si ingresaste el banco de preguntas
  base podrás empezar a jugar. del caso contrario tendrás que
  añadirlas en la opción preguntas.

Notas de versión: existe un bug con el JDBC que no te permite
buscar el participante. se reparará en versiones posteriores.


el diseño puede ser costoso pero la manteneabilidad y la claridad
del proyecto lo justifica.

El codigo se encuentra en ingles.
