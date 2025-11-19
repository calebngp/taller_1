# 🐳 Guía de Docker - taller_1

Esta guía explica cómo usar Docker para ejecutar el proyecto completo.

## 📋 Tabla de Contenidos

1. [Instalación de Docker](#instalación-de-docker)
2. [Uso Básico](#uso-básico)
3. [Comandos Comunes](#comandos-comunes)
4. [Arquitectura](#arquitectura)
5. [Solución de Problemas](#solución-de-problemas)

## 🔧 Instalación de Docker

### macOS
1. Descarga Docker Desktop desde [docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop/)
2. Instala el archivo `.dmg`
3. Abre Docker Desktop desde Applications
4. Verifica la instalación:
   ```bash
   docker --version
   docker-compose --version
   ```

### Linux (Ubuntu/Debian)
```bash
sudo apt-get update
sudo apt-get install docker.io docker-compose
sudo systemctl start docker
sudo systemctl enable docker

# Agregar usuario al grupo docker (opcional)
sudo usermod -aG docker $USER
# Cierra sesión y vuelve a iniciar
```

### Windows
1. Descarga Docker Desktop desde el sitio oficial
2. Ejecuta el instalador
3. Reinicia el sistema
4. Abre Docker Desktop

### Verificar Instalación
```bash
docker run hello-world
```

Deberías ver:
```
Hello from Docker!
This message shows that your installation appears to be working correctly.
```

## 🚀 Uso Básico

### Primera Ejecución

1. **Navegar al directorio docker:**
   ```bash
   cd docker
   ```

2. **Construir las imágenes:**
   ```bash
   docker-compose build
   ```
   Esto construye las imágenes de Docker para backend y frontend.

3. **Iniciar los servicios:**
   ```bash
   docker-compose up
   ```
   O en modo detached (segundo plano):
   ```bash
   docker-compose up -d
   ```

4. **Acceder a la aplicación:**
   - Frontend: http://localhost:4200
   - Backend: http://localhost:8080
   - API Endpoint: http://localhost:8080/api/hello

### Detener los Servicios

```bash
# Detener sin eliminar contenedores
docker-compose stop

# Detener y eliminar contenedores
docker-compose down

# Detener, eliminar contenedores y volúmenes
docker-compose down -v
```

## 📝 Comandos Comunes

### Gestión de Servicios

```bash
# Iniciar servicios
docker-compose up -d

# Detener servicios
docker-compose down

# Reiniciar un servicio específico
docker-compose restart backend
docker-compose restart frontend

# Ver estado
docker-compose ps
```

### Logs

```bash
# Ver todos los logs
docker-compose logs

# Seguir logs en tiempo real
docker-compose logs -f

# Logs de un servicio específico
docker-compose logs backend
docker-compose logs frontend

# Últimas 100 líneas
docker-compose logs --tail=100
```

### Reconstrucción

```bash
# Reconstruir después de cambios en el código
docker-compose up --build

# Reconstruir sin usar caché
docker-compose build --no-cache
docker-compose up

# Reconstruir solo un servicio
docker-compose build backend
docker-compose up -d backend
```

### Ejecutar Comandos Dentro de Contenedores

```bash
# Acceder al shell del backend
docker-compose exec backend sh

# Acceder al shell del frontend
docker-compose exec frontend sh

# Ejecutar comando Maven en backend
docker-compose exec backend mvn test

# Ejecutar comando npm en frontend
docker-compose exec frontend npm install
```

### Inspección

```bash
# Ver información de los contenedores
docker-compose ps

# Ver uso de recursos
docker stats

# Inspeccionar un contenedor
docker inspect backend-app
docker inspect frontend-app
```

## 🏗️ Arquitectura

### Servicios

#### Backend (backend-app)
- **Imagen base**: `maven:3.9-eclipse-temurin-17` (build) → `eclipse-temurin:17-jre-alpine` (runtime)
- **Puerto**: 8080
- **Puerto interno**: 8080
- **Comando**: `java -jar app.jar`
- **Variables de entorno**: `SPRING_PROFILES_ACTIVE=docker`

#### Frontend (frontend-app)
- **Imagen base**: `node:18-alpine` (build) → `nginx:alpine` (runtime)
- **Puerto**: 4200 (host) → 80 (contenedor)
- **Servidor**: Nginx
- **Comando**: `nginx -g daemon off;`

### Red

Los servicios están conectados a través de una red Docker llamada `app-network` (tipo bridge), lo que permite que se comuniquen entre sí usando los nombres de los servicios.

### Volúmenes

Actualmente no se usan volúmenes persistentes. Los datos se almacenan en memoria (H2 para backend).

## 🔍 Solución de Problemas

### Problema: Puerto ya en uso

**Error**: `Bind for 0.0.0.0:8080 failed: port is already allocated`

**Solución**:
```bash
# Ver qué proceso usa el puerto
lsof -i :8080  # macOS/Linux
netstat -ano | findstr :8080  # Windows

# Detener el proceso o cambiar el puerto en docker-compose.yml
```

### Problema: Docker daemon no está corriendo

**Error**: `Cannot connect to the Docker daemon`

**Solución**:
- **macOS/Windows**: Abre Docker Desktop
- **Linux**: `sudo systemctl start docker`

### Problema: Imagen no se construye correctamente

**Solución**:
```bash
# Limpiar y reconstruir
docker-compose down
docker-compose build --no-cache
docker-compose up
```

### Problema: Cambios en el código no se reflejan

**Solución**:
```bash
# Reconstruir las imágenes
docker-compose up --build

# O reconstruir solo el servicio afectado
docker-compose build backend
docker-compose up -d backend
```

### Problema: Contenedor se detiene inmediatamente

**Solución**:
```bash
# Ver logs para identificar el error
docker-compose logs backend
docker-compose logs frontend

# Verificar que los Dockerfiles sean correctos
# Verificar que los puertos no estén en uso
```

### Problema: Frontend no se conecta al backend

**Solución**:
1. Verificar que ambos contenedores estén corriendo: `docker-compose ps`
2. Verificar que estén en la misma red
3. En el código del frontend, usar `http://backend:8080` en lugar de `http://localhost:8080` cuando se ejecuta en Docker

### Limpieza Completa

```bash
# Detener y eliminar todo
docker-compose down -v

# Eliminar imágenes
docker rmi taller_1-backend taller_1-frontend

# Limpieza completa del sistema Docker
docker system prune -a --volumes
```

⚠️ **Advertencia**: El último comando elimina TODAS las imágenes, contenedores y volúmenes no utilizados.

## 📊 Monitoreo

### Ver uso de recursos
```bash
docker stats
```

### Ver procesos en contenedores
```bash
docker-compose top
```

### Ver redes Docker
```bash
docker network ls
docker network inspect taller_1_app-network
```

## 🔄 Flujo de Desarrollo con Docker

1. **Hacer cambios en el código**
2. **Reconstruir la imagen afectada:**
   ```bash
   docker-compose build backend  # o frontend
   ```
3. **Reiniciar el servicio:**
   ```bash
   docker-compose up -d backend
   ```
4. **Verificar logs:**
   ```bash
   docker-compose logs -f backend
   ```

## 📚 Recursos Adicionales

- [Documentación oficial de Docker](https://docs.docker.com/)
- [Documentación de Docker Compose](https://docs.docker.com/compose/)
- [Best practices de Docker](https://docs.docker.com/develop/dev-best-practices/)

## ✅ Checklist de Verificación

- [ ] Docker Desktop instalado y corriendo
- [ ] `docker --version` funciona
- [ ] `docker-compose --version` funciona
- [ ] `docker run hello-world` funciona
- [ ] `docker-compose build` ejecuta sin errores
- [ ] `docker-compose up` inicia ambos servicios
- [ ] Frontend accesible en http://localhost:4200
- [ ] Backend accesible en http://localhost:8080
- [ ] API endpoint funciona en http://localhost:8080/api/hello

---

**¿Problemas?** Revisa la sección de [Solución de Problemas](#solución-de-problemas) o consulta los logs con `docker-compose logs -f`.

