# Guía de Docker

## Instalación de Docker

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
```

### Windows
1. Descarga Docker Desktop desde el sitio oficial
2. Ejecuta el instalador
3. Reinicia el sistema
4. Verifica la instalación

## Verificación de Instalación

### Comando básico
```bash
docker --version
```

### Prueba con hello-world
```bash
docker run hello-world
```

**Salida esperada:**
```
Hello from Docker!
This message shows that your installation appears to be working correctly.
```

## Uso de Docker en el Proyecto

### Construir las imágenes
```bash
cd docker
docker-compose build
```

### Iniciar los servicios
```bash
docker-compose up
```

### Iniciar en segundo plano
```bash
docker-compose up -d
```

### Detener los servicios
```bash
docker-compose down
```

### Ver logs
```bash
docker-compose logs -f
```

### Ver logs de un servicio específico
```bash
docker-compose logs -f backend
docker-compose logs -f frontend
```

## Comandos Útiles

### Listar contenedores
```bash
docker ps
docker ps -a  # incluye detenidos
```

### Listar imágenes
```bash
docker images
```

### Limpiar recursos
```bash
# Eliminar contenedores detenidos
docker container prune

# Eliminar imágenes no utilizadas
docker image prune

# Limpieza completa (cuidado!)
docker system prune -a
```

## Estructura de Dockerfiles

### Backend (Java/Spring Boot)
- Usa Maven para compilar
- Multi-stage build para optimizar tamaño
- Expone puerto 8080

### Frontend (Angular)
- Usa Node.js para compilar
- Nginx para servir la aplicación
- Multi-stage build para optimizar tamaño
- Expone puerto 80 (mapeado a 4200)

## Solución de Problemas

### Docker daemon no está corriendo
```bash
# macOS/Windows: Abre Docker Desktop
# Linux:
sudo systemctl start docker
```

### Error de permisos (Linux)
```bash
sudo usermod -aG docker $USER
# Luego cierra sesión y vuelve a iniciar
```

### Limpiar y reconstruir
```bash
docker-compose down
docker-compose build --no-cache
docker-compose up
```

