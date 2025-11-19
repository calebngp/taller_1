# Backend - Spring Boot

## Descripción

Backend desarrollado con Spring Boot, Java 17/21 y Maven.

## Requisitos

- Java 17 o 21
- Maven 3.6+

## Instalación

```bash
# Verificar versiones
java -version
mvn -version

# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

## Endpoints

- `GET /api/hello` - Endpoint de prueba

## Configuración

La aplicación se ejecuta en `http://localhost:8080`

La consola H2 está disponible en `http://localhost:8080/h2-console`

## Estructura del Proyecto

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/talle/backend/
│   │   │   ├── BackendApplication.java
│   │   │   └── controller/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

