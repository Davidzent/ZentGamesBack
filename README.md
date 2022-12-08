# ZentGames

## Executive Summary

## Technologies Used

   - [Spring Boot](https://spring.io/projects/spring-boot)
   - [Angular](https://angular.io/)
   - [JUnit](https://junit.org/junit4/)
   - [Gradle](https://gradle.org/)
   - [SonarCloud](https://sonarcloud.io/project/overview?id=Davidzent_ZentGamesBack) (Click to see analysis)
   - [Javamail](https://javaee.github.io/javamail/)


## User Stories

As an user:

-   Login.
-   Logout.
-   Update account information.
-   View my account information.
-   Recieve emails on important events.


## Getting Started
   
#### Clone Project

```shell
   git clone https://github.com/Davidzent/ZentGamesBack
```

### Run Front End using Angular

```shell
  Run `ng serve`
  Navigate to `http://localhost:4200/`
```

### Run Back End using Intellij

#### Database

Uses a h2 local database with the option of using an online database

#### Setup Environment Variables for online database

#### Windows
```shell
Add the following environment variables with your customer database configuration parameters: 
DB_HOST
DB_USER
DB_PASS
```

#### Linux

```shell
export the following environment variables in ~bashrc file: 
DB_HOST
DB_USER
DB_PASS
```

### build.gradle
```
Go to src/main/resources/application.properties and change the following lines from

spring.datasource.username=user
spring.datasource.password=pass

To 

spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}

And uncomment the following lines

spring.datasource.url=jdbc:postgresql://${DB_HOST}/postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=postgres
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
## Contributors
- [David Guijosa Infante](https://github.com/Davidzent)