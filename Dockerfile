FROM openjdk:17-alpine
ADD target/*.jar app-bookmark.jar
##ENV app.env=PROD
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /app-bookmark.jar"]