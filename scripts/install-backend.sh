#!/bin/bash

# Script de instalación del entorno backend (Java + Maven)

echo "=========================================="
echo "Instalación del Entorno Backend"
echo "=========================================="
echo ""

# Instalar SDKMAN
if [ ! -d "$HOME/.sdkman" ]; then
    echo "Instalando SDKMAN..."
    curl -s "https://get.sdkman.io" | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
    echo "✓ SDKMAN instalado"
else
    echo "✓ SDKMAN ya está instalado"
    source "$HOME/.sdkman/bin/sdkman-init.sh"
fi

# Instalar Java 21
echo ""
echo "Instalando Java 21..."
sdk install java 21.0.1-tem
sdk default java 21.0.1-tem
echo "✓ Java 21 instalado"

# Instalar Maven
echo ""
echo "Instalando Maven..."
sdk install maven
sdk default maven
echo "✓ Maven instalado"

# Verificar instalaciones
echo ""
echo "=========================================="
echo "Verificación de instalaciones:"
echo "=========================================="
java -version
echo ""
mvn -version

echo ""
echo "=========================================="
echo "Instalación completada!"
echo "=========================================="

