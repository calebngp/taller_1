#!/bin/bash

# Script de instalación del entorno frontend (Node.js + Angular)

echo "=========================================="
echo "Instalación del Entorno Frontend"
echo "=========================================="
echo ""

# Instalar NVM
if [ ! -d "$HOME/.nvm" ]; then
    echo "Instalando NVM..."
    curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.0/install.sh | bash
    export NVM_DIR="$HOME/.nvm"
    [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
    echo "✓ NVM instalado"
    echo ""
    echo "IMPORTANTE: Ejecuta el siguiente comando o reinicia tu terminal:"
    echo "  source ~/.zshrc  # o ~/.bashrc"
else
    echo "✓ NVM ya está instalado"
    export NVM_DIR="$HOME/.nvm"
    [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"
fi

# Instalar Node.js LTS
echo ""
echo "Instalando Node.js LTS..."
nvm install --lts
nvm use --lts
nvm alias default lts/*
echo "✓ Node.js LTS instalado"

# Instalar Angular CLI
echo ""
echo "Instalando Angular CLI..."
npm install -g @angular/cli
echo "✓ Angular CLI instalado"

# Verificar instalaciones
echo ""
echo "=========================================="
echo "Verificación de instalaciones:"
echo "=========================================="
node -v
npm -v
ng version

echo ""
echo "=========================================="
echo "Instalación completada!"
echo "=========================================="

