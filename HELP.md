# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#web)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#io.webservices)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.1/reference/htmlsingle/#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

### Texto de apoyo:

# Tallwer 28

- Un API (proyeto java) ,un api tiene muchos servicios
- -> Servicio (Clase Controlador):Estudiante, un servicio tiene muchas capacidades
- -> Capacidad (Metodo de la Clase): Buscar

# Microservicio: es un paradigma de arquitectura

- Esta relacionado con las funcionalidades

- Nomenclatura de los servicios(controller): deben estar en plural
- El paradigma monolitico en donde el sistema es un solo componente o una sola masa(puede traer muchos problemas).

- SOA es un paradigma que intenta partir al sistema en diferentes servicios independientes (Arquitectura orientada a servicios).

- La evolucion de SOA es partir aun mas los servicios, obteniedo microservicios (no necesariament lo mas pequenio posible), partes pequenioas que deben corresponder a un mismo dominio.
 - se puede agrupar los dominios por medio de: DDD (Disenio dirigido por dominios).

- Dominio, Microservicio, API (Esta conformado por uno o varios servicios).

- El nomber del API debe referenciar a la **funcionalidad** del dominio.

- un reporte seria un dominio dependiendo si se acopla como una capacidad adicional del dominio o manejar como si fuese un modulo de reportes generico o para mostrar de manera dinamica (una reporteria mas compleja).

### Taller 29

- Si la cantidad de datos es muy pequeña, se utiliza PATCH, importa cantidad de informacion que se este enviando para utilizar esta anotacion
- Pero si la cantidad de datos es grande, se utiliza PUT

- Si requiero enviar info adicional a mi API es necesario: **@PahVariable**  **@RequestParam**

- ath Variable es para un unico valor, significa n identificador

### Taller 30

#### Modelo de Madurez

CMMI -> richardson maturity model

0. Las comunicaciones que se manejan en una API restful deben ser 
    - HTTP (Dev / NO productivos)
    - https (Prod / productivos)

1. debemos siempre manejar la terminologia de recursos y una correcta descripcion de las URLs(Path), con el objetivo de que sean autodescriptivas(solo con la URL ya se lo que hace)

    - Una URI(que es) correctamente nombrada consta de : 

    Protocolo de transporte://host:puerto/nombre del API/nombre del servicio/nombre de la capacidad

    host:puerto => socket

    nombre del API:/tipo de implementacion/version/Dominio



    Version :  hasta segundo digito => 1.0
    
    Dominio: no verbo, singular
    
    nombre del servicio: es el nombre del controlador, funcionalidad logica del dominio, representado por un recurso, en plural

    nombre de la capacidad: no se debe poner verbos ni funcionalidad

    cualquier dato que venga despues del nombre del servicio, significa que va a traer un unico recurso
   GET: Ejm: http://localhost:8080/API/v1.0/Matricula/estudiantes/12322334
         <!--\____/\________/\___/\__/\___/\________/\__________/\_______/
                     host     puer nom ver  dominio    servicio      *   
                   \_____________/ 
                        socket -->

    por cada API debe existir un contrato (una herramienta es Swagger)                        
    
<
### Taller31
2.

- Planteamos un uso correcto de los verbos:

    - La funcionalidad debe ser coherente con los verbos y metodos http
    - Manejar codigos de estado http (existen 5 grupos 1xx,2xx,3xx,4xx,5xx), sirven para obtener una respuesta de codificacion, utilizar codigos de manera correcto, de acuerdo al grupo que le pertenece.

    - Tipos de contenido de aceptacion

- **1 Informational responses (100 – 199)**

    100 El cliente debe continuar con la solicitud.

    101 Debe hacer un swicheo (cambio) del protocolo para la solicitud que está haciendo.

    102 La petición aún se está procesando.

- **2 Successful responses (200 – 299)**

    200 La petición fue exitosa o satisfactoria (el OK depende del verbo).

    201 Satisfactoria la creación de un nuevo recurso (No se utiliza mucho).

    202 La solicitud ha sido recibida corrrectamente, pero el método no puede emitir una respuesta.

    203 La petición fue aceptada, pero no tienen autorización para ser respondidas.

    204 La petición fue correcta pero no hay un request body para procesar la respuesta.

    206 Se envía cuando se devuelve un contenido o respuesta parcial. 

- **3 Redirection messages (300 – 399)**

    300 La petición tiene mutiples resultados, el usuario debe elegir una de ellas.

    301 La URL ha sido cambiada de forma permanente y se debe redirteccionar la petición hacia una URL diferente.

    302 Similar a 301, pero La URL es cambiana sólamente de manera temporal.

    307 Se va a pedir que habrá una redirección tremporal.

    308 El recurso se encuentra en otro uri permanentemente a continuación.

- **4 Client error responses (400 – 499)**

    400 La peticion es erronea.
    
    401 El cliente no esta autorizado para acceder, debe autenticarse (algo que se, algo que tengo y algo que soy).
        otps: codigo que tengo que se reenvia por correo (generalmente).

    403 No permitido, se autentico, pero no esta autorizado

    404 No se encontro el recurso solicitado, no se reconoce la URL. (**MAL ESCRITO**)

    405 El metodo es conocido por el servidor, pero no es compatbile con el recurso del destino (**CHEQUEAR EL VERBO**)

    407  se tiene que hacer la autenticacion por medio de un proxy
    Proxy: representante con un objetivo de trazabilidad, un filtro, reglas de navegacion, un ente de confianza
    
    408 El cliente decide parar la peticion, se envia una conexion inactiva por parte de los servidores

    413 entidad de solicitud es mayor que los limites del servidor

    414 El URI solicitado por el cliente es mas largo de lo que el servidor esta dispuesto a interpretar

    415 mal formato de archivo, formato de entrada mal realizado

    423 existio un bloqueo al recurso que se trato de acceder

    429 demasiadas solicitudes en determinado de tiempo(el software, hardware debe ser escalable )

- **5 Server error responses (500 – 599)**

    500 error interno del servidor.

    501 mensaje destinado a capacidades no implementadas, existe la URL pero no se ha implementado ninguna funcionalidad.

    502 En el momento de responder, ocurrio un error.

    503 El servicio no esta disponible.

- Cuando requiera que mi aplicación responda un mensaje informativo, usar el rango 100-199.

__Cuando hay un response__
- Existe un conjunto de codigos que se encuentran en la web y se encuentran estandarizados.

__Mensajes de redireccion__   
- Para los codigos en el caso de no encotrar nada en el backend

- Estos códigos, no hace falta configurarlos de manera manual, el sistema ya los utiliza de manera automática a menos de que se necesite algo más personalizado (Escoger un rango).

Si necesito manejar los codigos de respuesta, necesito un Wrapper(**ResponseEntity**)

Como sabe el cliente cual es el codigo de respueta
El contrato de un API debe constar
Debe retornar un mensaje

Tanto Request y Response esta conformado de dos partes:
    1. Cabecera(Headers) : aqui se envian los mensajes,
    2. Cuerpo(Body)

### Taller 32    

- Componente 3 de lvl2 

**Tipo de Contenido** 

- El back y el front se comunican a travez de request y response, llevan contenido.

request (texto plano, audio, video, etc).

response (devuelve html).

- el contenido que se envian los dos se conoce como (media-type o content-type)

- consta de un **formato** y un **tipo MIME** que es el formato de representacion de recursos.

formato <------------> MIME
- HTML            -> text/HTML
- Texto plano     -> text/plain
- json            -> application/json
- xml             -> application/xml

- quien rige estas normas es W3G (World Wide Web)

- Produces: Dentro del back cuando envio un recurso (json).

- Consumes: Como API va a consumir (un json).

- si no especificamos , las apis aceptan tipo json resfull por defecto.Pero no es buena practica el no especificar.

- Segun el modelo de Madurez de Richarson en el nivel 2 se debe especificar de manera explicita si es produces con consmumes.

## Taller 33

- nivlel 3. Manejo de Hipermedia

Nuestra API va a retornar informacion del objeto principal, y de los objetos secundarios deberia retornar un enlace(un enlance de los hijos de un padre)
Comunmente conocido como HATEOAS
(hypermedia as the engine of application state)

- Serializar: el paquete tiene que convertirse en 0,1 para  que viaje en la red, y para convertir a objeto es deserializar.

- Representation Model: le da la capacidad de agregar hipermedia. (extendiendo, teniendo la clase TO) 

## Taller 34

- Agregar hipermedia se lo relaciona con agregar un hipervinculo (una capacidad).

- TO es la representacion del modelo.

- La construccion del enlace se realiza por medio de "Link", en funcion de una capacidad existente.

- 

![RMM](./src/main/resources/static/img/rmm.png)<!-- imagen -->


# taller 35

- no se puede utilizar el `fetch` con apis que que sean locales, se tiene que usar `axios`

``` bash
npm install axios
```


