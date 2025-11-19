# 🚀 Comandos Rápidos - taller_1

## Inicializar Repositorio Git

```bash
# Opción 1: Script automatizado
./init-git.sh
git push -u origin main

# Opción 2: Manual (como solicitaste)
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/calebngp/taller_1.git
git push -u origin main
```

## Iniciar con Docker

```bash
# Opción 1: Script automatizado
cd docker
./start.sh

# Opción 2: Manual
cd docker
docker-compose up --build -d
```

## Ver Logs

```bash
cd docker
docker-compose logs -f
```

## Detener Docker

```bash
cd docker
./stop.sh
# o
docker-compose down
```

## URLs de Acceso

- **Frontend**: http://localhost:4200
- **Backend**: http://localhost:8080
- **API**: http://localhost:8080/api/hello

## Comandos Docker Comunes

```bash
# Construir
docker-compose build

# Iniciar
docker-compose up -d

# Detener
docker-compose down

# Ver estado
docker-compose ps

# Ver logs
docker-compose logs -f

# Reconstruir
docker-compose up --build -d
```

## Desarrollo Local (Sin Docker)

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

---

**Nota**: Asegúrate de que Docker Desktop esté corriendo antes de ejecutar comandos de Docker.

