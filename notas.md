# Notas sobre Bootstrap

Bootstrap gestiona los elementos de la página en función de contenedores y columnas. Específicamente, se
basa en el modelo Flexbox.

## Utilizando Flexbox con Bootstrap

La clase `.d-flex` se aplica sobre contenedores para que puedan manipularse mediante mediante flexbox

```
<div class="d-flex p-2 bd-highlight">I'm a flexbox container!</div>
```

También existe la clase `.d-inline-flex` para insertar elementos inline dentro de un contenedor flexbox. De esta manera solamente se expanden el espacio máximo que necesitan.

Por defecto, Bootstrap aplica de forma implícita las propiedades de la clase `.flex-row` a un contenedor, de manera que sus elementos se agrupan en una sola fila de **izquierda a derecha**.

Utilizando `.flex-row-reverse` se posicionan de derecha a izquierda en su lugar.

### Modelo Grid

Bootstrap posee clases utilitarias para manipular la estructura de una página estructuradas como una malla, o *Grids*, utilizando las clases `row` y `col-*`. [Más información.](https://getbootstrap.com/docs/5.0/examples/grid/#containers) 

# Anexos

* [Consultar sobre tablas.](https://getbootstrap.com/docs/5.0/content/tables/)
* [Ejemplos perfiles Bootstrap.](https://mdbootstrap.com/docs/standard/extended/profiles/#)
* [Bootstrap Cards.](https://getbootstrap.com/docs/5.0/components/card/)