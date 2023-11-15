
# Incident-API
CRUD API for controlling incidents at diazero
## API 
- [x] Incident creation
- [x] Incident update
- [x] Incident removal 
- [x] Search all incidents
- [x] Search incident by id 
- [x] Search last 20 incidents by decresing order of creation
- [x] Docker and Docker Compose
- [x] Swagger

## Install
Run the following command for dependency installation

``` mvn clean package install ```

Run following command on root project folder to run jar
```java -jar target/incidentApi.jar```

Run following command on root project folder to build image by docker
``` docker-compose build ``` >
``` docker-compose up ```


## Documentation
Documentation on the following link:
http://localhost:8080/swagger-ui.html#/