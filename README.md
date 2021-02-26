# Sample API using Quarkus with SQL

## Start postgresql with:
```
docker run \
--name quarkus_test \
-e POSTGRES_USER=list-db \
-e POSTGRES_PASSWORD=list-db \
-e POSTGRES_DB=list-db \
-p 5432:5432 \
postgres:10.5
```

## Running the app in dev mode

This approach enables live coding:
```shell script
./mvnw compile quarkus:dev
```
## Connect to endpoint at
http://localhost:8080/list

## Technologies used
- Quarkus
- Hibernate ORM with Panache: Define your persistent model with Hibernate ORM and JPA
- RESTEasy JAX-RS: REST endpoint framework implementing JAX-RS and more
- PostgreSQL: Relational database