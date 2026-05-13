FROM eclipse-temurin

WORKDIR /HelloWorld

COPY . .

WORKDIR src/saludo

RUN ["javac","Saludo.java"]

ENTRYPOINT ["java","Saludo"]