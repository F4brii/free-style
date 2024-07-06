# Usa una imagen base de Node.js
FROM node:14-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo package.json y package-lock.json al directorio de trabajo
COPY package*.json ./

# Instala las dependencias del proyecto
RUN npm install

# Copia el resto del código de la aplicación al directorio de trabajo
COPY . .

# Compila la aplicación React para producción
RUN npm run build

# Usa una imagen base de nginx para servir la aplicación compilada
FROM nginx:alpine

# Copia los archivos compilados de React al directorio que Nginx usará para servir la aplicación
COPY --from=0 /app/build /usr/share/nginx/html

# Exponer el puerto en el que el contenedor va a correr
EXPOSE 80

# Inicia el servidor Nginx
CMD ["nginx", "-g", "daemon off;"]
