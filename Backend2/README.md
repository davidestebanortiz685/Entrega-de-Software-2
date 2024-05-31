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

![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/e1bb959d-15df-4895-89cb-96e033d14524)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/20de4027-cb79-42f0-8f5c-6d5af4d0b467)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/ec634c8d-ac64-4d27-bcbf-a05b33510486)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/27a41cf5-0475-4f8f-8776-56434bcaaac5)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/7dea3d00-eccb-4002-a51e-05290be1ecc6)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/8ee42ed6-c5c4-4588-9a10-8c38352d4d41)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/9d808c3a-c992-4e95-ae93-e4dcd9f1b896)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/c45b69c4-eb3e-476b-936e-af5aa8b8b2d3)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/2f7d777a-54ad-4b03-9913-1439e5b675db)
![image](https://github.com/davidestebanortiz685/Entrega-de-Software-2/assets/107454129/71cccf81-0755-4989-ba19-eefdd93afeaf)

