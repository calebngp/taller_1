#!/bin/bash

# Script de verificación de instalación del entorno de desarrollo
# Este script verifica que todas las herramientas estén correctamente instaladas

echo "=========================================="
echo "Verificación del Entorno de Desarrollo"
echo "=========================================="
echo ""

# Colores para output
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Función para verificar comando
check_command() {
    if command -v $1 &> /dev/null; then
        echo -e "${GREEN}✓${NC} $1 está instalado"
        $1 --version 2>/dev/null | head -n 1 || echo "  Versión: $(which $1)"
        return 0
    else
        echo -e "${RED}✗${NC} $1 NO está instalado"
        return 1
    fi
}

# Verificar Git
echo "1. Verificando Git..."
check_command git
echo ""

# Verificar Java
echo "2. Verificando Java..."
if check_command java; then
    JAVA_VERSION=$(java -version 2>&1 | head -n 1)
    echo "  $JAVA_VERSION"
fi
echo ""

# Verificar Maven
echo "3. Verificando Maven..."
check_command mvn
echo ""

# Verificar SDKMAN
echo "4. Verificando SDKMAN..."
if [ -d "$HOME/.sdkman" ]; then
    echo -e "${GREEN}✓${NC} SDKMAN está instalado"
    if [ -f "$HOME/.sdkman/bin/sdkman-init.sh" ]; then
        source "$HOME/.sdkman/bin/sdkman-init.sh"
        sdk version 2>/dev/null || echo "  SDKMAN encontrado en $HOME/.sdkman"
    fi
else
    echo -e "${RED}✗${NC} SDKMAN NO está instalado"
fi
echo ""

# Verificar Node.js
echo "5. Verificando Node.js..."
check_command node
echo ""

# Verificar npm
echo "6. Verificando npm..."
check_command npm
echo ""

# Verificar NVM
echo "7. Verificando NVM..."
if [ -d "$HOME/.nvm" ]; then
    echo -e "${GREEN}✓${NC} NVM está instalado"
    if [ -f "$HOME/.nvm/nvm.sh" ]; then
        source "$HOME/.nvm/nvm.sh"
        nvm --version 2>/dev/null || echo "  NVM encontrado en $HOME/.nvm"
    fi
else
    echo -e "${RED}✗${NC} NVM NO está instalado"
fi
echo ""

# Verificar Angular CLI
echo "8. Verificando Angular CLI..."
check_command ng
echo ""

# Verificar Docker
echo "9. Verificando Docker..."
if check_command docker; then
    echo "  Verificando Docker daemon..."
    if docker info &> /dev/null; then
        echo -e "${GREEN}✓${NC} Docker daemon está corriendo"
    else
        echo -e "${YELLOW}⚠${NC} Docker daemon NO está corriendo"
    fi
fi
echo ""

# Verificar Docker Compose
echo "10. Verificando Docker Compose..."
check_command docker-compose || check_command docker compose
echo ""

echo "=========================================="
echo "Verificación completada"
echo "=========================================="

