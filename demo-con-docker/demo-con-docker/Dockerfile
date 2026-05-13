FROM eclipse-temurin:17-jdk-alpine

COPY target/demo-con-docker-0.0.1-SNAPSHOT.jar app.jar
#Estamos renombrando el .jar que obtuvimos haciendo mvn clean package en el directorio
#donde se encuentra el pom.xm
ENTRYPOINT ["java","-jar","/app.jar"]

#¡Ha sido un éxito! el contenerdor llamado sprinbootcontainer2 fue creado a partir de esta imagen y funciona
#perfectamente