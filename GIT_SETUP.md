# 🔧 Configuración de Git

## Inicialización del Repositorio

### Opción 1: Script Automatizado

```bash
./init-git.sh
git push -u origin main
```

### Opción 2: Manual

```bash
# Inicializar repositorio
git init

# Agregar todos los archivos
git add .

# Primer commit
git commit -m "first commit"

# Configurar rama main
git branch -M main

# Agregar remote
git remote add origin https://github.com/calebngp/taller_1.git

# Subir al repositorio
git push -u origin main
```

## Verificación

```bash
# Ver estado
git status

# Ver remotes
git remote -v

# Ver commits
git log --oneline
```

## Estructura de Commits Recomendada

```bash
# Commit inicial
git commit -m "first commit"

# Backend
git add backend/
git commit -m "feat: Agregar proyecto Java Spring Boot"

# Frontend
git add frontend/
git commit -m "feat: Agregar proyecto Angular"

# Docker
git add docker/
git commit -m "feat: Agregar configuración Docker"

# Documentación
git add docs/ README.md
git commit -m "docs: Agregar documentación completa"
```

## Comandos Útiles

```bash
# Ver cambios
git status
git diff

# Agregar cambios
git add .
git add archivo-especifico

# Commit
git commit -m "tipo: descripción"

# Push
git push origin main

# Pull
git pull origin main
```

## Convenciones de Commits

- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Documentación
- `style`: Formato
- `refactor`: Refactorización
- `test`: Tests
- `chore`: Mantenimiento

