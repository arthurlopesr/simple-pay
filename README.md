<h1 align="center">
  Simple-pay
</h1>

Java API respecting the principles of clean architecture, using messaging with Kafka

## Tech
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- [Spring for Apache Kafka](https://spring.io/projects/spring-kafka)
- [Docker Compose](https://docs.docker.com/compose/)
- [MySql](https://www.mysql.com/)

## How to run

- Clone repo
```
git clone https://github.com/arthurlopesr/simple-pay.git
```
- Run Kafka and MySql:
```
docker-compose up -d
```
- Run the Spring Boot application
- Access application at `http://localhost:8080/simple-pay`.

## Architecture

![Diagrama sem nome drawio](https://github.com/arthurlopesr/simple-pay/assets/72874475/f5636a55-02cd-4e33-b12a-9cb514cd3626)
