# rest-api-without-springboot
A simple REST API implementing a CRUD without Spring Boot usage

**Resources**:

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#spring-web
- https://www.baeldung.com/spring-xml-vs-java-config
- http://websystique.com/springmvc/spring-4-mvc-helloworld-tutorial-annotation-javaconfig-full-example/

## Running the application

You need to have a Tomcat installed to deploy the war file.

To create the war file, just execute the following command:

```
gradlew war
```

Then, copy the war file created to the webapps folder in the application container.
