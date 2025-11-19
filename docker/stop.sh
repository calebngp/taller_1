#!/bin/bash

# Script para detener el proyecto con Docker

echo "=========================================="
echo "Deteniendo taller_1"
echo "=========================================="
echo ""

# Navegar al directorio docker
cd "$(dirname "$0")"

# Detener servicios
docker-compose down

echo ""
echo "✓ Servicios detenidos"
echo ""

