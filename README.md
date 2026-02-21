# 📘 Command Executor Service 
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)
![JWT](https://img.shields.io/badge/Security-JWT-yellow)
![Swagger](https://img.shields.io/badge/Docs-Swagger-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)
![Status](https://img.shields.io/badge/Status-Production%20Ready-success)
### Microservicio en Java + Spring Boot para ejecución segura de comandos del sistema. Arquitectura limpia, JWT, Swagger y Docker.

Un microservicio construido con **Java + Spring Boot**, diseñado para ejecutar comandos del sistema operativo de forma controlada, segura y documentada. Implementa **arquitectura limpia**, seguridad con **JWT**, documentación con **Swagger**, contenedorización con **Docker** y un diseño orientado a producción.

Este proyecto está pensado para demostrar **dominio técnico**, buenas prácticas y un enfoque profesional en el desarrollo backend moderno.


## ✨ Características destacadas

- Arquitectura limpia y modular  
- Ejecución segura de comandos del sistema  
- Validaciones robustas  
- Autenticación y autorización con **JWT**  
- Documentación automática con **Swagger/OpenAPI**  
- Preparado para despliegue con **Docker** y **Docker Compose**  
- Configurable mediante variables de entorno  
- Código mantenible, escalable y orientado a producción  

---

## 🏗️ Arquitectura del proyecto

```
src/
 └── main/
     ├── java/
     │   └── com.example.commandexecutor
     │       ├── controller/        → Endpoints REST
     │       ├── service/           → Lógica de negocio
     │       ├── domain/            → Modelos y entidades
     │       └── infrastructure/    → Integración con el sistema
     └── resources/
         ├── application.properties
         └── static/
```

### Principios aplicados
- Separación estricta de responsabilidades  
- Inyección de dependencias  
- Manejo centralizado de excepciones  
- Validaciones a nivel DTO  
- Seguridad por capas  
- Código limpio y documentado  

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Propósito |
|-----------|-----------|
| Java 17+ | Lenguaje principal |
| Spring Boot | Framework backend |
| Spring Web | API REST |
| Spring Security + JWT | Autenticación |
| Swagger / OpenAPI | Documentación |
| Docker | Contenedorización |
| Maven | Gestión de dependencias |

---

## 🚀 Ejecución del proyecto

### ✔️ Ejecutar localmente

Requisitos:  
- Java 17+  
- Maven  

Comandos:

```bash
mvn clean install
mvn spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
```

---

## 🐳 Ejecución con Docker

### ✔️ Usando la imagen publicada en Docker Hub

```bash
docker run -p 8080:8080 tuusuario/command-executor-service:1.0.0
```

### ✔️ Construir tu propia imagen

```bash
docker build -t command-executor-service .
docker run -p 8080:8080 command-executor-service
```

---

## 🔐 Variables de entorno

| Variable | Descripción | Ejemplo |
|---------|-------------|---------|
| `JWT_SECRET` | Clave secreta para firmar tokens | `mysecretkey123` |
| `JWT_EXPIRATION` | Tiempo de expiración del token (ms) | `3600000` |

---

## 📚 Documentación Swagger

Una vez levantado el servicio:

```
http://localhost:8080/swagger-ui.html
```

Incluye:
- Endpoints  
- Modelos  
- Ejemplos  
- Autenticación JWT integrada  

---

## 🔑 Autenticación JWT

### 1. Obtener un token

```
POST /auth/login
```

Body:

```json
{
  "username": "admin",
  "password": "admin123"
}
```

Respuesta:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 2. Usar el token

Header:

```
Authorization: Bearer <token>
```

---

## 🧪 Ejemplo de ejecución de comando

```
POST /commands/execute
```

Body:

```json
{
  "command": "ping -c 4 google.com"
}
```

Respuesta:

```json
{
  "output": "PING google.com ...",
  "exitCode": 0
}
```

---

## 📦 Despliegue con Docker Compose

```yaml
version: '3.8'

services:
  command-executor-service:
    image: tuusuario/command-executor-service:1.0.0
    container_name: command-executor-service
    ports:
      - "8080:8080"
    environment:
      JWT_SECRET: "mysecretkey123"
      JWT_EXPIRATION: "3600000"
```

Levantar:

```bash
docker-compose up -d
```

---

## 🧭 Diagrama conceptual

```
[Client] → [Controller] → [Service] → [Command Executor] → [OS]
                         ↓
                    [JWT Security]
```

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**.

---

## 🎯 Estado del proyecto

✔️ Listo para producción  
✔️ Documentado  
✔️ Publicado en Docker Hub  
✔️ Publicado en GitHub  
✔️ Arquitectura limpia  
✔️ Seguridad integrada  
