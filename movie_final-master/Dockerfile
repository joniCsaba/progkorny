FROM openjdk:17-jdk-alpine3.14

# Set the working directory
WORKDIR /app

# Copy the application JAR file into the container
COPY "./target/book-catalog.jar" "/app/book-catalog.jar"

# Expose the port the application will run on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "/app/book-catalog.jar"]
