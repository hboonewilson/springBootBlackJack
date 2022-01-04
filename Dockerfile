FROM amazoncorretto:11-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
RUN ls
ARG JAR_FILE=target/blackJackSpring.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]