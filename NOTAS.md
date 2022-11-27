# PROBLEMAS QUE ME HE ENCONTRADO

## MySQL

* En caso de olvidar la contraseña de root. [Fuente](https://dev.mysql.com/doc/mysql-windows-excerpt/8.0/en/resetting-permissions-windows.html)

* ¿Cómo hice funcionar la base de datos? [Fuente](https://www.hostinger.com/tutorials/mysql/how-create-mysql-user-and-grant-permissions-command-line)

  * Loguearse utilizando la interfaz de línea
  de comandos de MySQL o usando MySQL Workbench como usuario root

  * Crear un usuario de prueba

  ~~~
  CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'laclave_123';
  ~~~

  * Crear una base de datos y asignarle privilegios
  al usuario recién creado

  ~~~
  CREATE DATABASE db;
  GRANT ALL PRIVILEGES ON db.* TO 'usuario'@'localhost';
  ~~~

  * Agregar las credenciales de acceso en `application.properties`. [Fuente](https://stackoverflow.com/questions/51221777/failed-to-configure-a-datasource-url-attribute-is-not-specified-and-no-embedd)

  ~~~
  spring.datasource.url=jdbc:mysql://localhost:3306/db
  spring.datasource.username=usuario
  spring.datasource.password=laclave_123
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
  spring.jpa.generate-ddl=true
  spring.jpa.hibernate.ddl-auto=update
  ~~~