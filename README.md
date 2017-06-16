# Dockerized Spring Boot Microservices

This sample application consist of spring boot registry service (Eureka), edge service (Zuul), sample user app and consumer application. 



### Prerequisites

- [Git](http://git-scm.com/downloads)
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Docker]( https://docs.docker.com/engine/installation/ )
- [Maven](https://maven.apache.org/install.html)

### Running the application

Download or clone git repository, then use maven to build projects. You can also run this project as a java application or spring boot applicaiton if you are using STS. 

- Service Registry:
Spring Boot Eureka (Netflix Eureka) service registry server.
- Edge Service
Spring Boot Zuul (Netflix Zuul) server. 
- User app:
This is the sample spring boot REST API, exposes 2 end points. 

 - /registerUser

Json structure

```
{
	"userId":1,
	"name":"user_name",
	"email":"username@gmail.com"	
}

Example:
http://localhost:8083/user-consumer/registerUser

```
 - /getUser

```
Example:
http://localhost:8083/user-consumer/getUser?userID=1

```

## Docker build

- You can use docker engine or maven plugin to build docker image.
- Before you build docker image:
   - Edit application.properties file and replace localhost with appropreate ip address.
   - Edit pom.xml file and enter appropriate value for <docker.image.prefix>.
- If you intend to push docker images to your private repository such as Azure ACR or Amazone ECR, edit the pom.xml file from each service and enter appropreate <serverId>, <repositoryUrl>.
- Here is the maven command to build docker image:

```
mvn package docker:build

```
- This should build docker image using the Dockerfile provided in the each service.  
- Use below maven command to build and push docker image to private container repository:

```
mvn package docker:build -DpushImage

```

- if you are not able to push images using above command, push images using docker engine.

```
docker push <image_name>

```