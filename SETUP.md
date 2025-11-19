# Guía Rápida de Configuración

## Pasos Rápidos

### 1. Clonar/Inicializar Repositorio
```bash
git init
git remote add origin https://github.com/TU_USUARIO/talle_I.git
```

### 2. Instalar Backend (Java + Maven)
```bash
./scripts/install-backend.sh
# O manualmente:
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 21.0.1-tem
sdk install maven
```

### 3. Instalar Frontend (Node.js + Angular)
```bash
./scripts/install-frontend.sh
# O manualmente:
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
source ~/.zshrc
nvm install --lts
npm install -g @angular/cli
```

### 4. Instalar Docker
- **macOS**: Descargar Docker Desktop desde docker.com
- **Linux**: `sudo apt-get install docker.io docker-compose`
- **Windows**: Descargar Docker Desktop

### 5. Verificar Todo
```bash
./scripts/verify-installation.sh
```

### 6. Probar Proyectos

**Backend:**
```bash
cd backend
mvn clean install
mvn spring-boot:run
# Abrir http://localhost:8080/api/hello
```

**Frontend:**
```bash
cd frontend
npm install
ng serve
# Abrir http://localhost:4200
```

### 7. Probar Docker
```bash
docker run hello-world
```

### 8. Subir a GitHub
```bash
git add .
git commit -m "Initial commit: Estructura del proyecto"
git push -u origin main
```

## Documentación Completa

- [README.md](README.md) - Documentación principal
- [docs/INSTALLATION.md](docs/INSTALLATION.md) - Guía detallada de instalación
- [docs/DOCKER.md](docs/DOCKER.md) - Guía de Docker
- [docs/COMMITS.md](docs/COMMITS.md) - Guía de commits

