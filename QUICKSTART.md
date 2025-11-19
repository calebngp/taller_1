# 🚀 Inicio Rápido - taller_1

## Opción 1: Con Docker (Recomendado)

### Prerrequisitos
- Docker Desktop instalado y corriendo

### Pasos

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/calebngp/taller_1.git
   cd taller_1
   ```

2. **Iniciar con Docker:**
   ```bash
   cd docker
   ./start.sh
   ```
   
   O manualmente:
   ```bash
   cd docker
   docker-compose up --build -d
   ```

3. **Acceder a la aplicación:**
   - Frontend: http://localhost:4200
   - Backend API: http://localhost:8080/api/hello

4. **Ver logs:**
   ```bash
   cd docker
   docker-compose logs -f
   ```

5. **Detener:**
   ```bash
   cd docker
   ./stop.sh
   ```
   
   O manualmente:
   ```bash
   cd docker
   docker-compose down
   ```

## Opción 2: Desarrollo Local

### Backend

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

Backend disponible en: http://localhost:8080

### Frontend

```bash
cd frontend
npm install
ng serve
```

Frontend disponible en: http://localhost:4200

## Comandos Docker Útiles

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

## Solución de Problemas

### Docker no inicia
- Abre Docker Desktop
- Verifica: `docker --version`

### Puerto en uso
```bash
# Detener contenedores
cd docker && docker-compose down
```

### Ver errores
```bash
cd docker
docker-compose logs -f backend
docker-compose logs -f frontend
```

---

Para más información, consulta [README.md](README.md)

