# ---------- Etapa 1: Construcción con Maven ----------
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Compila el proyecto y empaqueta el JAR
RUN ./mvnw clean package -DskipTests

# ---------- Etapa 2: Imagen final ligera ----------
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR construido desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto de la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
