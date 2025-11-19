#!/bin/bash

# Script para inicializar el repositorio Git

echo "=========================================="
echo "Inicializando repositorio Git"
echo "=========================================="
echo ""

# Verificar que Git esté instalado
if ! command -v git &> /dev/null; then
    echo "❌ Error: Git no está instalado"
    exit 1
fi

# Inicializar repositorio
echo "Inicializando repositorio..."
git init

# Agregar todos los archivos
echo "Agregando archivos..."
git add .

# Primer commit
echo "Creando primer commit..."
git commit -m "first commit"

# Cambiar a rama main
echo "Configurando rama main..."
git branch -M main

# Agregar remote
echo "Configurando remote..."
git remote add origin https://github.com/calebngp/taller_1.git

echo ""
echo "=========================================="
echo "Repositorio inicializado"
echo "=========================================="
echo ""
echo "Para subir al repositorio, ejecuta:"
echo "  git push -u origin main"
echo ""

