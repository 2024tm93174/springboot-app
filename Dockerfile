FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]



#git init
#git add .
#git commit -m "Spring Boot CRUD API"
#git branch -M main
#git remote add origin https://github.com/username/springboot-crud.git
#git push -u origin main