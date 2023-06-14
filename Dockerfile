from maven: latest as build
copy . .
run mvn clean package -DskipTests=true


from openjdk:latest
copy --from=build /target/ExampleRest-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","ExampleRest-0.0.1SNAPSHOT.jar"]

