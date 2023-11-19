# Selecciona una imagen base que contenga Maven y la versión de Java que necesitas
FROM maven:3.8.6-openjdk-17

# Crea y establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y los directorios src y target al directorio de trabajo
COPY pom.xml /app
COPY src /app/src
COPY target /app/target

# Construye la aplicación, omitiendo las pruebas unitarias
RUN mvn clean package -DskipTests

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Configura el comando para ejecutar la aplicación
# Asegúrate de reemplazar 'tu-app.jar' con el nombre del JAR generado por Maven
CMD ["java", "-jar", "target/tu-app.jar"]
