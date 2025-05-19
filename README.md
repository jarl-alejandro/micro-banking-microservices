# micro-banking-microservices


# compila cada servicio
cd customer-service && mvn clean package -DskipTests
cd ../account-service && mvn clean package -DskipTests
cd ../api-gateway && mvn clean package -DskipTests
cd ..

# levanta todo
docker-compose up --build
