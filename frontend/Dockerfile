# Multi-stage build para optimizar el tamaño de la imagen
FROM node:18-alpine AS build

WORKDIR /app

# Copiar archivos de configuración
COPY package*.json ./

# Instalar dependencias
RUN npm ci

# Copiar código fuente
COPY . .

# Compilar la aplicación
RUN npm run build

# Imagen final con Nginx
FROM nginx:alpine

# Copiar los archivos compilados
COPY --from=build /app/dist/frontend /usr/share/nginx/html

# Copiar configuración de Nginx (opcional)
# COPY nginx.conf /etc/nginx/conf.d/default.conf

# Exponer el puerto
EXPOSE 80

# Nginx se inicia automáticamente
CMD ["nginx", "-g", "daemon off;"]

