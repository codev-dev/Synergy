# BenchED

It's a common practice to start a Java project with some goals in mind.

If you want to build RESTful APIs with DB as the backend, you may think of:

## Get started

Make sure you have Maven 3.x and JDK 1.8+ installed.

```
$ java -version
openjdk version "1.8.0_242"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_242-b08)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.242-b08, mixed mode)

$ mvn -version
Apache Maven 3.6.2 ...
```

## SETUP MySQL

Firstly, log into the MySQL and create the database, and update properties in application.properties:

```
mysql> CREATE DATABASE codev_benched;
```

### Start up the app

Let's get started:

```
$ mvn clean spring-boot:run
```

> Note: 
> 1. The app serves at port `8080`, as usual, but we can use another port, say `8090` by explictly setting `server.port`, like `-Dspring-boot.run.jvmArguments="-Dserver.port=8090"` or update application.properties

### Access Swagger UI

Open a browser and navigate to: http://localhost:8080/

```sh
$ open http://localhost:8080/
```

![swagger-ui](misc/screenshot-swagger.png "Swagger UI")

> Note: 
> 1. Note the `/` URI will be automatically redirected to Swagger UI: in v2.x it's at `/swagger-ui.html`; while in v3.x, it's at `/swagger-ui/index.html`;
> 2. All the APIs exposed can be tried through the UI, do try it out!



## References

- Spring Boot with Docker: https://spring.io/guides/gs/spring-boot-docker/
- Spring Data JPA Doc: https://docs.spring.io/spring-data/jpa/docs/2.2.4.RELEASE/reference/html/#jpa.query-methods.query-creation
