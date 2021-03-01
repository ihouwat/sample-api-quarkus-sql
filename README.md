# API for To-Do list using Quarkus with SQL

## 1a. Start PostgreSQL DB with:
```
docker run 
--name quarkus-list-pg 
-e POSTGRES_USER=list-db 
-e POSTGRES_PASSWORD=list-db 
-e POSTGRES_DB=list-db 
-p 5432:5432 
postgres:10.5
```

## 1b. Alternatively, start MySQL DB with:
Make sure the right properties are active in application.properties file.
```
docker run
--name quarkus-list-mysql 
-e MYSQL_USER=list-db 
-e MYSQL_ROOT_PASSWORD=secret 
-p 3306:3306 
mysql:latest
```

## 2. Running the app in dev mode

This approach enables live coding:
```shell script
./mvnw compile quarkus:dev
```
## 3. Connect to server at
http://localhost:8080/list \
Alternatively, test the API with the [frontend app](https://github.com/ihouwat/frontend-sample-api-quarkus-sql).

## Technologies used
- Quarkus
- Hibernate ORM with Panache: Define your persistent model with Hibernate ORM and JPA
- RESTEasy JAX-RS: REST endpoint framework implementing JAX-RS and more
- PostgreSQL: Relational database
