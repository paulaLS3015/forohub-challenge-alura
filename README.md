# ForoHub: API REST para Gestión de Tópicos

![Badge-Spring](Badge-Spring.png)

ForoHub es una API REST construida con Spring que permite a los usuarios gestionar tópicos en un foro. Si estás buscando una solución completa para crear, consultar, actualizar y eliminar tópicos, ¡has llegado al lugar correcto!

## Tabla de Contenidos

- [Introducción](#introducción)
- [Instalación](#instalación)
- [Rutas de la API](#rutas-de-la-api)
- [Autenticación y Autorización](#autenticación-y-autorización)
- [Documentación con Swagger](#documentación-con-swagger)
- [Contribución](#contribución)
- [Licencia](#licencia)

## Introducción

Un foro es un espacio donde los participantes pueden plantear preguntas, compartir conocimientos y colaborar. ForoHub replica este proceso a nivel de back end, permitiendo a los usuarios interactuar con tópicos de manera eficiente.

## Instalación

1. **Clona el repositorio:**
   ```
   git clone https://github.com/paulaLS3015/forohub.git
   cd forohub
   ```

2. **Independencias:**
   ```
   spring-boot-starter-web
   spring-boot-devtools
   lombok
   spring-boot-starter-test
   spring-boot-starter-data-jpa
   flyway-core
   flyway-mysql
   mysql-connector-j
   spring-boot-starter-validation
   ```

3. **Configura la base de datos:**
   - ForoHub utiliza una base de datos relacional - MySQL.
   - Crea una base de datos llamada `forohub` y configura las credenciales en `application.properties`.

4. **Ejecuta la aplicación:**
   ```
   mvn spring-boot:run
   ```

## Rutas de la API

- **Crear y Actualizar un nuevo tópico:**
  ```
  POST /topicos
  ```

- **Mostrar todos los tópicos:**
  ```
  GET /topicos
  ```

- **Mostrar un tópico específico:**
  ```
  GET /topicos/{id}
  ```

- **Eliminar un tópico:**
  ```
  DELETE /topicos/{id}
  ```

## Autenticación y Autorización

- ForoHub utiliza autenticación basada en tokens (JWT).
- Cuenta con Spring Security que proporciona autenticación, autorización y protección a la aplicación.
- Los usuarios deben registrarse e iniciar sesión para acceder a las rutas protegidas.

## Documentación con Swagger

ForoHub está documentado automáticamente con Swagger. Accede a la interfaz gráfica en:
[Swagger UI](http://localhost:8080/swagger-ui.html)

## Contribución

¡Estamos abiertos a contribuciones! Si deseas colaborar, sigue estos pasos:
1. Haz un fork del repositorio.
2. Crea una nueva rama para tu función o corrección.
3. Envía una solicitud de extracción.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
