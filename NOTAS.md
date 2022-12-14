# PROBLEMAS QUE ME HE ENCONTRADO

## MySQL

* En caso de olvidar la contrase�a de root. [Fuente](https://dev.mysql.com/doc/mysql-windows-excerpt/8.0/en/resetting-permissions-windows.html)

* �C�mo hice funcionar la base de datos? [Fuente](https://www.hostinger.com/tutorials/mysql/how-create-mysql-user-and-grant-permissions-command-line)

  * Loguearse utilizando la interfaz de l�nea
  de comandos de MySQL o usando MySQL Workbench como usuario root

  * Crear un usuario de prueba

  ~~~
  CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'laclave_123';
  ~~~

  * Crear una base de datos y asignarle privilegios
  al usuario reci�n creado

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
  
  # Notas sobre Bootstrap

Bootstrap gestiona los elementos de la página en función de contenedores y columnas. Específicamente, se
basa en el modelo Flexbox.

## Bootstrap

### Utilizando Flexbox con Bootstrap

La clase `.d-flex` se aplica sobre contenedores para que puedan manipularse mediante mediante flexbox

```
<div class="d-flex p-2 bd-highlight">I'm a flexbox container!</div>
```

También existe la clase `.d-inline-flex` para insertar elementos inline dentro de un contenedor flexbox. De esta manera solamente se expanden el espacio máximo que necesitan.

Por defecto, Bootstrap aplica de forma implícita las propiedades de la clase `.flex-row` a un contenedor, de manera que sus elementos se agrupan en una sola fila de **izquierda a derecha**.

Utilizando `.flex-row-reverse` se posicionan de derecha a izquierda en su lugar.

#### Modelo Grid

Bootstrap posee clases utilitarias para manipular la estructura de una página estructuradas como una malla, o *Grids*, utilizando las clases `row` y `col-*`. [Más información.](https://getbootstrap.com/docs/5.0/examples/grid/#containers) 

# Anexos

* [Consultar sobre tablas.](https://getbootstrap.com/docs/5.0/content/tables/)
* [Ejemplos perfiles Bootstrap.](https://mdbootstrap.com/docs/standard/extended/profiles/#)
* [Bootstrap Cards.](https://getbootstrap.com/docs/5.0/components/card/)
* https://javascript.tutorialink.com/how-to-dynamically-create-a-table-from-a-json-with-nested-lists-using-javascript/
* https://developer.mozilla.org/en-US/docs/Web/API/Element/classList
* https://stackoverflow.com/questions/13980982/add-class-to-html-with-javascript
* https://stackoverflow.com/questions/53992707/get-the-selected-value-in-a-select-option-thymeleaf-and-spring-boot
* https://stackoverflow.com/questions/42135114/how-does-spring-jpa-hibernate-ddl-auto-property-exactly-work-in-spring