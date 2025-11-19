# taller_1 - Proyecto Full-Stack Java + Angular

## 📋 Descripción del Proyecto

Este proyecto es una aplicación full-stack que combina:
- **Backend**: Java 17 con Spring Boot y Maven
- **Frontend**: Angular 17 con TypeScript
- **Containerización**: Docker para facilitar el despliegue y desarrollo

## 🏗️ Estructura del Proyecto

```
taller_1/
├── backend/          # Proyecto Java/Spring Boot
│   ├── src/
│   ├── pom.xml
│   └── Dockerfile
├── frontend/         # Proyecto Angular
│   ├── src/
│   ├── package.json
│   └── Dockerfile
├── docker/           # Configuraciones Docker
│   └── docker-compose.yml
├── docs/             # Documentación adicional
├── scripts/          # Scripts de instalación
└── README.md         # Este archivo
```

## 🚀 Inicio Rápido con Docker

### Prerrequisitos

- Docker Desktop instalado y corriendo
- Git instalado

### Pasos para Ejecutar con Docker

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/calebngp/taller_1.git
   cd taller_1
   ```

2. **Construir y ejecutar los contenedores:**
   ```bash
   cd docker
   docker-compose up --build
   ```

3. **Acceder a la aplicación:**
   - Frontend: http://localhost:4200
   - Backend API: http://localhost:8080/api/hello

4. **Detener los contenedores:**
   ```bash
   docker-compose down
   ```

## 🐳 Uso de Docker

### Comandos Básicos

#### Construir las imágenes
```bash
cd docker
docker-compose build
```

#### Iniciar los servicios
```bash
docker-compose up          # Modo interactivo (ver logs)
docker-compose up -d       # Modo detached (en segundo plano)
```

#### Ver logs
```bash
docker-compose logs         # Todos los servicios
docker-compose logs -f      # Seguir logs en tiempo real
docker-compose logs backend # Solo backend
docker-compose logs frontend # Solo frontend
```

#### Detener los servicios
```bash
docker-compose stop         # Detener sin eliminar contenedores
docker-compose down         # Detener y eliminar contenedores
docker-compose down -v      # Detener, eliminar contenedores y volúmenes
```

#### Reconstruir después de cambios
```bash
docker-compose up --build   # Reconstruir y ejecutar
docker-compose build --no-cache  # Reconstruir sin caché
```

### Servicios Disponibles

#### Backend (Spring Boot)
- **Puerto**: 8080
- **URL**: http://localhost:8080
- **API Endpoint**: http://localhost:8080/api/hello
- **Health Check**: http://localhost:8080/actuator/health (si está configurado)

#### Frontend (Angular)
- **Puerto**: 4200
- **URL**: http://localhost:4200
- **Servido por**: Nginx

### Comandos Avanzados

#### Ejecutar comandos dentro de un contenedor
```bash
# Backend
docker-compose exec backend sh

# Frontend
docker-compose exec frontend sh
```

#### Ver estado de los contenedores
```bash
docker-compose ps
```

#### Reiniciar un servicio específico
```bash
docker-compose restart backend
docker-compose restart frontend
```

#### Limpiar recursos Docker
```bash
# Eliminar contenedores detenidos
docker container prune

# Eliminar imágenes no utilizadas
docker image prune

# Limpieza completa (¡cuidado!)
docker system prune -a
```

## 💻 Desarrollo Local (Sin Docker)

### Backend (Java + Maven)

#### Instalación
```bash
# Instalar SDKMAN
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Instalar Java 17
sdk install java 17.0.9-tem
sdk default java 17.0.9-tem

# Instalar Maven
sdk install maven
sdk default maven
```

#### Ejecutar
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend (Angular)

#### Instalación
```bash
# Instalar NVM
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
source ~/.zshrc  # o ~/.bashrc

# Instalar Node.js LTS
nvm install --lts
nvm use --lts

# Instalar Angular CLI
npm install -g @angular/cli
```

#### Ejecutar
```bash
cd frontend
npm install
ng serve
```

## 📦 Instalación del Entorno Completo

### Opción 1: Scripts Automatizados

```bash
# Instalar backend
./scripts/install-backend.sh

# Instalar frontend
./scripts/install-frontend.sh

# Verificar instalaciones
./scripts/verify-installation.sh
```

### Opción 2: Manual

Ver la documentación completa en [docs/INSTALLATION.md](docs/INSTALLATION.md)

## 🔧 Configuración

### Variables de Entorno

#### Backend
Las variables de entorno se pueden configurar en `docker-compose.yml`:
```yaml
environment:
  - SPRING_PROFILES_ACTIVE=docker
  - DATABASE_URL=jdbc:h2:mem:testdb
```

#### Frontend
El frontend está configurado para conectarse al backend en `http://localhost:8080`.

## 🧪 Pruebas

### Backend
```bash
cd backend
mvn test
```

### Frontend
```bash
cd frontend
ng test
```

### Con Docker
```bash
docker-compose exec backend mvn test
```

## 📚 Documentación Adicional

- [docs/INSTALLATION.md](docs/INSTALLATION.md) - Guía detallada de instalación
- [docs/DOCKER.md](docs/DOCKER.md) - Guía completa de Docker
- [docs/COMMITS.md](docs/COMMITS.md) - Guía de commits
- [SETUP.md](SETUP.md) - Guía rápida de referencia

## 🐛 Solución de Problemas

### Docker no inicia
- **macOS/Windows**: Asegúrate de que Docker Desktop esté corriendo
- **Linux**: `sudo systemctl start docker`

### Puerto ya en uso
```bash
# Ver qué proceso usa el puerto
lsof -i :8080  # Backend
lsof -i :4200  # Frontend

# Detener contenedores
docker-compose down
```

### Reconstruir después de cambios
```bash
docker-compose down
docker-compose build --no-cache
docker-compose up
```

### Ver logs de errores
```bash
docker-compose logs -f backend
docker-compose logs -f frontend
```

## 🔄 Flujo de Trabajo con Git

### Inicializar Repositorio (Primera vez)
```bash
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/calebngp/taller_1.git
git push -u origin main
```

### Trabajo Diario
```bash
# Ver cambios
git status

# Agregar cambios
git add .

# Commit
git commit -m "feat: descripción del cambio"

# Push
git push origin main
```

## 📝 Convenciones de Commits

- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Documentación
- `style`: Formato de código
- `refactor`: Refactorización
- `test`: Tests
- `chore`: Mantenimiento

## 🛠️ Tecnologías Utilizadas

- **Backend**: Java 17, Spring Boot 3.2.0, Maven, H2 Database
- **Frontend**: Angular 17, TypeScript, RxJS
- **Containerización**: Docker, Docker Compose
- **Herramientas**: SDKMAN, NVM, Git

## 👥 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'feat: Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 👤 Autor

**Caleb Nehemias**
- GitHub: [@calebngp](https://github.com/calebngp)

---

## 🎯 Resumen de Comandos Docker Más Usados

```bash
# Iniciar todo
cd docker && docker-compose up -d

# Ver logs
docker-compose logs -f

# Detener todo
docker-compose down

# Reconstruir
docker-compose up --build

# Estado
docker-compose ps
```

¡Listo para desarrollar! 🚀
