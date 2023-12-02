# Etap pakietowania (Package stage)
FROM eclipse-temurin:17-jdk-alpine

# Kopiowanie gotowego pliku .jar do /usr/local/lib/demo.jar w kontenerze
COPY target/house-cleaning-backend-0.0.1-SNAPSHOT.jar /usr/local/lib/house-cleaning-backend-0.0.1-SNAPSHOT.jar

# Ustalenie punktu wejściowego dla kontenera
ENTRYPOINT ["java","-jar","/usr/local/lib/house-cleaning-backend-0.0.1-SNAPSHOT.jar"]