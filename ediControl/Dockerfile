FROM eclipse-temurin:19-jammy
WORKDIR /ediControl
LABEL mentainer="pino440@gmail.com"
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]