# Guía de Instalación Paso a Paso

Esta guía te ayudará a instalar todo el entorno de desarrollo desde cero.

## Índice

1. [Preparación del Repositorio](#1-preparación-del-repositorio)
2. [Instalación Backend (Java)](#2-instalación-backend-java)
3. [Instalación Frontend (Angular)](#3-instalación-frontend-angular)
4. [Instalación Docker](#4-instalación-docker)
5. [Verificación](#5-verificación)

---

## 1. Preparación del Repositorio

### 1.1. Crear cuenta en GitHub

Si no tienes cuenta:
1. Visita [github.com](https://github.com)
2. Haz clic en "Sign up"
3. Completa el formulario
4. Verifica tu email

### 1.2. Crear repositorio público

1. En GitHub, haz clic en el botón "+" (arriba derecha) → "New repository"
2. Nombre: `talle_I`
3. Descripción: "Proyecto Full-Stack Java + Angular"
4. Visibilidad: **Público**
5. **NO** marques "Add a README file" (ya lo tenemos)
6. Haz clic en "Create repository"

### 1.3. Configuración inicial

```bash
# Si ya clonaste el repositorio, omite estos pasos
cd /ruta/a/tu/proyecto
git init
git add .
git commit -m "Initial commit: Estructura del proyecto"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/talle_I.git
git push -u origin main
```

---

## 2. Instalación Backend (Java)

### 2.1. Instalar SDKMAN!

**macOS/Linux:**
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

**Verificación:**
```bash
sdk version
```

**O usar el script automatizado:**
```bash
./scripts/install-backend.sh
```

### 2.2. Instalar Java 21

```bash
sdk install java 21.0.1-tem
sdk default java 21.0.1-tem
```

**Verificación:**
```bash
java -version
# Debe mostrar algo como: openjdk version "21.0.1" ...
```

### 2.3. Instalar Maven

```bash
sdk install maven
sdk default maven
```

**Verificación:**
```bash
mvn -version
```

### 2.4. Probar el proyecto backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

Abre tu navegador en `http://localhost:8080/api/hello`

---

## 3. Instalación Frontend (Angular)

### 3.1. Instalar NVM

**macOS/Linux:**
```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
```

**Configurar en tu shell:**
```bash
# Agregar a ~/.zshrc o ~/.bashrc
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"
```

**Recargar:**
```bash
source ~/.zshrc  # o ~/.bashrc
```

**Verificación:**
```bash
nvm --version
```

**O usar el script automatizado:**
```bash
./scripts/install-frontend.sh
```

### 3.2. Instalar Node.js LTS

```bash
nvm install --lts
nvm use --lts
nvm alias default lts/*
```

**Verificación:**
```bash
node -v
npm -v
```

### 3.3. Instalar Angular CLI

```bash
npm install -g @angular/cli
```

**Verificación:**
```bash
ng version
```

### 3.4. Probar el proyecto frontend

```bash
cd frontend
npm install
ng serve
```

Abre tu navegador en `http://localhost:4200`

---

## 4. Instalación Docker

### 4.1. macOS

1. Descarga Docker Desktop: [docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop/)
2. Instala el archivo `.dmg`
3. Abre Docker Desktop desde Applications
4. Espera a que se inicie (ícono de ballena en la barra de menú)

### 4.2. Linux (Ubuntu/Debian)

```bash
sudo apt-get update
sudo apt-get install docker.io docker-compose
sudo systemctl start docker
sudo systemctl enable docker

# Agregar usuario al grupo docker (opcional, evita usar sudo)
sudo usermod -aG docker $USER
# Cierra sesión y vuelve a iniciar
```

### 4.3. Windows

1. Descarga Docker Desktop desde el sitio oficial
2. Ejecuta el instalador
3. Reinicia el sistema
4. Abre Docker Desktop

### 4.4. Verificar instalación

```bash
docker --version
docker-compose --version
```

### 4.5. Prueba con hello-world

```bash
docker run hello-world
```

**Captura de pantalla:**
Toma una captura de pantalla del resultado y guárdala en `docs/docker-verification.png`

---

## 5. Verificación

### Verificar todo el entorno

Ejecuta el script de verificación:

```bash
./scripts/verify-installation.sh
```

O verifica manualmente:

```bash
# Git
git --version

# Java
java -version

# Maven
mvn -version

# Node.js
node -v

# npm
npm -v

# Angular CLI
ng version

# Docker
docker --version
docker run hello-world
```

---

## Comandos de Git para Subir Cambios

```bash
# Ver estado
git status

# Agregar cambios
git add .

# Commit
git commit -m "feat: Agregar proyecto Java Spring Boot"
git commit -m "feat: Agregar proyecto Angular"
git commit -m "docs: Agregar documentación de instalación"
git commit -m "feat: Agregar configuración Docker"

# Push
git push origin main
```

---

## Solución de Problemas

### SDKMAN no funciona después de reiniciar terminal

Agrega a `~/.zshrc` o `~/.bashrc`:
```bash
export SDKMAN_DIR="$HOME/.sdkman"
[[ -s "$HOME/.sdkman/bin/sdkman-init.sh" ]] && source "$HOME/.sdkman/bin/sdkman-init.sh"
```

### NVM no funciona después de reiniciar terminal

Agrega a `~/.zshrc` o `~/.bashrc`:
```bash
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"
```

### Docker daemon no está corriendo

- **macOS/Windows**: Abre Docker Desktop
- **Linux**: `sudo systemctl start docker`

---

## Próximos Pasos

1. ✅ Verificar que todo esté instalado correctamente
2. ✅ Tomar capturas de pantalla de las instalaciones
3. ✅ Subir todo al repositorio de GitHub
4. ✅ Actualizar el README con la URL del repositorio
5. ✅ Verificar que los commits estén organizados

