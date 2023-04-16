# Back-End proyecto Final Argentina Programa

En Desarrollo...

## Descripción

Lo que hice fue iniciar un proyecto de Java con Spring Boot utilizando la página web: 
https://start.spring.io/

Elegí como herramienta de gestión de proyectos Maven y seleccioné las siguientes dependencias:

- **Spring Web** para crear una aplicación web.
- **JPA** para la persistencia de datos.
- **MySQL Driver** para conectarme a la base de datos MySQL.
- **Validation** para validar los datos que se envíen a la aplicación.
- **DevTools** para visualizar en tiempo real las configuraciones.

Configuré la conexión con MySQL en el archivo `application.properties`. 
Utilizando los siguientes parámetros de configuración:

- `spring.jpa.hibernate.ddl-auto=update`: Esta propiedad indica que Hibernate debe actualizar automáticamente la base de datos cada vez que se inicia la aplicación.
- `spring.datasource.url=jdbc:mysql://localhost:3306/nombrebdd?useSSL=false&serverTimezone=UTC`: Esta propiedad indica la URL de la base de datos que se va a utilizar. En este caso, se utiliza una base de datos llamada "backend_dinoferre" que está alojada en el localhost y utiliza el puerto 3306. También se indica que no se utiliza SSL y se utiliza el huso horario UTC.
- `spring.datasource.username=root`: Esta propiedad indica el nombre de usuario que se utiliza para conectarse a la base de datos.
- `spring.datasource.password=`: Esta propiedad indica la contraseña que se utiliza para conectarse a la base de datos.
- `spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect`: Esta propiedad indica el dialecto de la base de datos que se está utilizando. En este caso, se está utilizando MySQL 8.

Generé diferentes paquetes para estructurar el proyecto en el back-end. 
Los paquetes son los siguientes:

- `Entity`: Aquí encuentran las clases de entidades que representan las tablas de la base de datos.
- `Repository`: Aquí se encuentran las interfaces que extienden de JPA y sus métodos para realizar operaciones en la base de datos. 
- `Interface`: Aquí se encuentran las interfaces que definen los métodos que serán implementados en las clases de servicio.
- `Service`: Aquí se encuentran las clases de servicio que implementan los métodos definidos en las interfaces.
- `Controller`: Aquí se encuentran las clases de controlador que se comunican con el front-end y los métodos que manejan las peticiones HTTP.  

