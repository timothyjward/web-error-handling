# web-error-handling
Some simple examples for handling errors from web interfaces in OSGi

## Building the project

This project uses the OSGi enRoute R7 templates to provide a Maven build. The build can be run easily from the `parent` directory by running

    mvn verify

## Running the project

This project creates two runnable applications, one using raw servlets, the other using JAX-RS. Both projects produce executable JAR files runnable from the command line

### The Servlet application

The servlet application is runnable from `parent/servlet-app`

    java -jar target/servlet-app-1.0-SNAPSHOT.jar

You can then access one of the two registered servlets

 * http://localhost:8080/error/teapot - this servlet responds to get requests with a 418 *I'm a teapot* response code
 * http://localhost:8080/error/io - this servlet throws an IOException from its doGet method

These two errors are handled by separate error page servlets registered in the application

### The JAX-RS application

The JAX-RS application is runnable from `parent/jax-rs-app`

    java -jar target/jax-rs-app-1.0-SNAPSHOT.jar

You can then access the rest resource at http://localhost:8080/error/io 

