#!/bin/bash

# Script para iniciar el proyecto con Docker

echo "=========================================="
echo "Iniciando taller_1 con Docker"
echo "=========================================="
echo ""

# Verificar que Docker esté corriendo
if ! docker info > /dev/null 2>&1; then
    echo "❌ Error: Docker daemon no está corriendo"
    echo ""
    echo "Por favor:"
    echo "  - macOS/Windows: Abre Docker Desktop"
    echo "  - Linux: Ejecuta 'sudo systemctl start docker'"
    exit 1
fi

echo "✓ Docker está corriendo"
echo ""

# Navegar al directorio docker
cd "$(dirname "$0")"

# Construir e iniciar los servicios
echo "Construyendo imágenes..."
docker-compose build

echo ""
echo "Iniciando servicios..."
docker-compose up -d

echo ""
echo "=========================================="
echo "Servicios iniciados"
echo "=========================================="
echo ""
echo "Frontend: http://localhost:4200"
echo "Backend:  http://localhost:8080"
echo "API:      http://localhost:8080/api/hello"
echo ""
echo "Para ver logs:"
echo "  docker-compose logs -f"
echo ""
echo "Para detener:"
echo "  docker-compose down"
echo ""

