# Proyecto de Gestión de Frutas en Spring Boot

Este es un proyecto simple desarrollado en Spring Boot para gestionar frutas en una base de datos MySQL. Está diseñado con el patrón MVC, y te permitirá añadir, listar, modificar y eliminar frutas mediante una interfaz web.

## Características

-   **Formulario para Agregar Frutas**: Permite ingresar el nombre, cantidad y precio de una fruta.
-   **Listado de Frutas**: Muestra todas las frutas almacenadas en la base de datos con opciones para editar y eliminar.
-   **CRUD Completo**: Funcionalidades de Crear, Leer, Actualizar y Eliminar frutas.
-   **Base de Datos MySQL**: Utiliza MySQL para almacenar los datos y está configurado con el conector adecuado.

## Estructura del Proyecto

-   **`controller`**: Contiene la lógica del negocio. Aquí se manejan las solicitudes HTTP y se interactúa con la capa de servicio (en este caso, directamente con el repositorio).
-   **`entities`**: Define la estructura de la entidad `Fruta` que se guarda en la base de datos.
-   **`repositories`**: Gestiona la conexión a la base de datos y las operaciones CRUD.

## Instalación y Configuración

1.  **Clona el Repositorio**
    
    bash
    
    Copiar código
    
    `git clone https://github.com/Eliseo-Sanchez/Gestion-De-Frutas-Spring.git` 
    
2.  **Configuración del Archivo `.env`**
    
    Asegúrate de tener un archivo `.env` en la raíz del proyecto con la configuración de tu base de datos. Aquí un ejemplo:
    
    properties
    
    Copiar código
    
    `SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/bd_frutas
    SPRING_DATASOURCE_USERNAME=tu_usuario
    SPRING_DATASOURCE_PASSWORD=tu_contraseña` 
    
3.  **Dependencias**
    
    Este proyecto utiliza Maven para la gestión de dependencias. Asegúrate de tenerlo instalado y ejecuta:
    
    bash
    
    Copiar código
    
    `mvn clean install` 
    
4.  **Ejecutar el Proyecto**
    
    Inicia el servidor Spring Boot con:
    
    bash
    
    Copiar código
    
    `mvn spring-boot:run` 
    
    El servidor estará disponible en `http://localhost:8080`.
    

## Uso

-   **Agregar Frutas**: Navega a `http://localhost:8080/frutas/formulario` para añadir nuevas frutas.
-   **Listar Frutas**: Dirígete a `http://localhost:8080/frutas/listar` para ver todas las frutas almacenadas.
-   **Modificar y Eliminar**: Desde la página de listado, puedes modificar o eliminar frutas utilizando los botones correspondientes.

## Contribuciones

Si tienes ideas para mejorar este proyecto o encuentras algún error, ¡no dudes en hacer un pull request o abrir un issue!

## Autor

-   **Cristian Sanchez** - eliseo.rivera044@gmail.com

----------