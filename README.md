# An Opinionated Spring Boot Configuration
This is a simple Spring Boot for reading entities (in our case, a book) from an embedded H2 database.

## Getting Started

### Run the project
```shell
mvn spring-boot:run
```
## Sample Commands
Run the following commands in a separate terminal window.

### Retrieve a book
```shell
curl localhost:8080/books/fa1f9e20-2e03-4aa4-b981-16789d5fa92f
```

### Retrieve a book and pipe it to JQ for readability
```shell
curl localhost:8080/books/fa1f9e20-2e03-4aa4-b981-16789d5fa92f | jq .
```

### Pass an invalid ID
Use this to see an expected error response
```shell
curl localhost:8080/books/not-valid | jq .
```

### Pass a valid UUID that does not exist in the database
```shell
curl localhost:8080/books/fa1f9e20-2e03-4aa4-b981-16789d5fa91f | jq .
```
