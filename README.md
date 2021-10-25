# CrazyQ
Question game

Hola soy Luis Herrera y este es mi juego de preguntas.

En la carpeta documentacion encontrarás los documentos tecnicos
del proyecto diagramas, Dll, entre otros.

En la carpeta proyecto encontrarás el codigo fuente desarrollado
en Java (11), en el IDE Eclipse con persistencia de datos en 
postgresSQL.

patron de diseño dao.
Arquitecutra acercandose a la exagonal.

Para iniciar este proyecto debes:

+ Instalar PgAdmin4.
+ Crear la base de datos con el DLL (completo si quieres el
  banco de preguntas base).
+ Confugura el driver de postgres en tu proyecto y asegura las
  configuraciones de conexiones en la clase ConnectionPostgres
  situada en el paquete repositorio.
+ Ejecuta en el paquete principal el archivo Main y con eso ya
  deberias de estar observando la ventana principal.
  
  Agrega un participante y si ingresaste el banco de preguntas
  base podras empezar a jugar. del caso contrario tendras que
  añadirlas en la opcion preguntas.

Notas de version: existe un bug con el JDBC que no te permite
buscar el participante. se reparará en versiones posteriores.

falta implementar la representacion de las preguntas en la UI
se pueden guardar y obtener pero aun no se implementan.

el diseño puede ser costoso pero la manteneabilidad y la claridad
del proyecto lo justifica.

El codigo se encuentra en ingles.
