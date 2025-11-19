# 📋 Instrucciones Completas - taller_1

## 🎯 Resumen del Proyecto

Proyecto full-stack con:
- **Backend**: Java 17 + Spring Boot + Maven
- **Frontend**: Angular 17 + TypeScript
- **Docker**: Containerización completa

## 🚀 Pasos para Ejecutar

### 1. Inicializar Repositorio Git

```bash
# Opción A: Script automatizado
./init-git.sh
git push -u origin main

# Opción B: Manual
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/calebngp/taller_1.git
git push -u origin main
```

### 2. Iniciar con Docker

**Prerrequisito**: Docker Desktop debe estar corriendo

```bash
# Opción A: Script automatizado
cd docker
./start.sh

# Opción B: Manual
cd docker
docker-compose up --build -d
```

**Acceder a la aplicación:**
- Frontend: http://localhost:4200
- Backend: http://localhost:8080/api/hello

### 3. Ver Logs

```bash
cd docker
docker-compose logs -f
```

### 4. Detener Docker

```bash
# Opción A: Script
cd docker
./stop.sh

# Opción B: Manual
cd docker
docker-compose down
```

## 📚 Documentación Disponible

1. **README.md** - Documentación principal completa
2. **QUICKSTART.md** - Guía de inicio rápido
3. **docker/README.md** - Guía completa de Docker
4. **docs/INSTALLATION.md** - Instalación detallada del entorno
5. **docs/DOCKER.md** - Documentación de Docker
6. **GIT_SETUP.md** - Configuración de Git

## 🐳 Comandos Docker Esenciales

```bash
# Iniciar
cd docker && docker-compose up -d

# Ver logs
docker-compose logs -f

# Detener
docker-compose down

# Reconstruir
docker-compose up --build -d

# Estado
docker-compose ps
```

## 🔧 Desarrollo Local (Sin Docker)

### Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### Frontend
```bash
cd frontend
npm install
ng serve
```

## ✅ Checklist de Verificación

- [ ] Docker Desktop instalado y corriendo
- [ ] Repositorio Git inicializado
- [ ] Docker Compose construye sin errores
- [ ] Servicios se inician correctamente
- [ ] Frontend accesible en http://localhost:4200
- [ ] Backend accesible en http://localhost:8080
- [ ] API endpoint funciona: http://localhost:8080/api/hello

## 🆘 Solución de Problemas

### Docker no inicia
- Abre Docker Desktop
- Verifica: `docker --version`

### Puerto en uso
```bash
cd docker
docker-compose down
```

### Ver errores
```bash
cd docker
docker-compose logs -f backend
docker-compose logs -f frontend
```

### Reconstruir todo
```bash
cd docker
docker-compose down
docker-compose build --no-cache
docker-compose up -d
```

## 📝 Próximos Pasos

1. ✅ Inicializar repositorio Git
2. ✅ Configurar Docker
3. ✅ Probar la aplicación
4. 🔄 Desarrollar nuevas funcionalidades
5. 🔄 Agregar tests
6. 🔄 Configurar CI/CD

---

**¿Necesitas ayuda?** Consulta la documentación en los archivos README.md o docs/

