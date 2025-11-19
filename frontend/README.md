# Frontend - Angular

## Descripción

Frontend desarrollado con Angular 17 y TypeScript.

## Requisitos

- Node.js LTS (v18 o superior)
- npm o yarn
- Angular CLI

## Instalación

```bash
# Verificar versiones
node -v
npm -v
ng version

# Instalar dependencias
npm install

# Ejecutar servidor de desarrollo
ng serve
# o
npm start
```

La aplicación estará disponible en `http://localhost:4200`

## Estructura del Proyecto

```
frontend/
├── src/
│   ├── app/
│   │   ├── app.component.ts
│   │   ├── app.component.html
│   │   └── app.component.css
│   ├── index.html
│   ├── main.ts
│   └── styles.css
├── angular.json
├── package.json
└── tsconfig.json
```

## Comandos Útiles

```bash
# Desarrollo
ng serve

# Compilar para producción
ng build --prod

# Ejecutar tests
ng test

# Linting
ng lint
```

## Configuración

El frontend está configurado para conectarse al backend en `http://localhost:8080`.

