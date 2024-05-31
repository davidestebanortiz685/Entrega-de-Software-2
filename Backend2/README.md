Esta API REST proporciona funcionalidades para gestionar información sobre Productos de un negocio de comidas, incluyendo la informacion de los clientes

Paso para ejecutar el programa de forma local:

Clone el repositorio desde GitHub a su máquina local

El proyecto utiliza una base de datos para almacenar la información en MySQL Workbrench. Asegurese de tenerla instalada y lista y configure las credenciales de conexión en el archivo `application.properties`.


////////////////////////////////////////////////////////////////////////////


IMPORTANTE SI SE ELIMINA UN OBJETO NO SE PUEDE VOLVER A RECUPERAR SU ID

MODELOS
Cliente 
Atributos:
Id (Long): Identificador del cliente.
nombrec (String): Nombres del cliente.
email (String): Correo electrónico del cliente.
telefono (String): Número de teléfono del cliente.

Producto 
Atributos:
id (Long): Identificador del producto.
nombre (String): Nombre del producto.
precio (Integer): Precio del producto.
peso (String): Peso del producto.

CONTROLADORES

PRODUCTO 
Ruta predeterminada api/productos
GET api/productos: Obtiene todas los productos almacenados. 
GET api/productos/id : Obtiene un producto especifico por su ID. 
POST api/productos: Crea una nuevo producto, no es necesario colocar su ID. 
PUT api/productos/id: Actualiza los productos por ID. 
DELETE api/productos/:id: Elimina un producto.

CLIENTE
Ruta predeterminada api/clientes
GET api/clientes: Obtiene todas los clientes almacenados. 
GET api/clientes/id : Obtiene un cliente especifico por su ID. 
POST api/clientes: Crea una nuevo cliente, no es necesario colocar su ID. 
PUT api/clientes/id: Actualiza los clientes por ID. 
DELETE api/clientes/:id: Elimina un clientes.

SWAGGER
Controlador base para API, este controlador se extendera para todos los endpoints
