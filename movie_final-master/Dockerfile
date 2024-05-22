FROM openjdk:17-jdk-alpine3.14

# Set the working directory
WORKDIR /app

# Copy the application JAR file into the container
COPY "./target/movie_final.jar" "/app/movie_final.jar"

# Expose the port the application will run on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "/app/movie_final.jar"]
