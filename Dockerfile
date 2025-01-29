FROM maven:3.8-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src

ARG DB_URL
ENV DB_URL=${DB_URL}

ARG DB_USERNAME
ENV DB_USERNAME=${DB_USERNAME}

ARG DB_PASSWORD
ENV DB_PASSWORD=${DB_PASSWORD}

ARG MICROSERVICIO_REGISTRO_URI
ENV MICROSERVICIO_REGISTRO_URI=${MICROSERVICIO_REGISTRO_URI}

RUN mvn clean package
FROM maven:3.8-openjdk-17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]