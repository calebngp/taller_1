# Guía de Commits

Esta guía muestra la estructura recomendada de commits para el proyecto.

## Estructura de Commits Recomendada

### 1. Commit Inicial
```bash
git add .
git commit -m "Initial commit: Estructura del proyecto"
```

### 2. Backend
```bash
git add backend/
git commit -m "feat: Agregar proyecto Java Spring Boot"
```

### 3. Frontend
```bash
git add frontend/
git commit -m "feat: Agregar proyecto Angular"
```

### 4. Docker
```bash
git add docker/ backend/Dockerfile frontend/Dockerfile
git commit -m "feat: Agregar configuración Docker"
```

### 5. Documentación
```bash
git add docs/ README.md
git commit -m "docs: Agregar documentación de instalación"
```

### 6. Scripts
```bash
git add scripts/
git commit -m "feat: Agregar scripts de instalación y verificación"
```

## Convenciones de Commits

Usa el formato: `tipo: descripción breve`

### Tipos de commits:
- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Documentación
- `style`: Formato, punto y coma faltante, etc.
- `refactor`: Refactorización de código
- `test`: Agregar o modificar tests
- `chore`: Tareas de mantenimiento

### Ejemplos:
```bash
git commit -m "feat: Agregar endpoint de usuarios"
git commit -m "fix: Corregir error de conexión a base de datos"
git commit -m "docs: Actualizar README con instrucciones"
git commit -m "style: Formatear código según estándares"
```

## Verificar Commits

```bash
# Ver historial de commits
git log --oneline

# Ver detalles de un commit
git show <hash>

# Ver cambios entre commits
git diff <hash1> <hash2>
```

## Push al Repositorio

```bash
# Primera vez
git push -u origin main

# Siguientes veces
git push origin main
```

