# PagueMob Challenge

This is a REST application to register employees and companies. It was written in Java using Spring Boot and HSQLDB.

# Requirements

  - Java 8
  - Maven 3.x

### Java

On linux

    sudo apt-get install python-software-properties
    sudo add-apt-repository ppa:webupd8team/java
    sudo apt-get update
    sudo apt-get install oracle-java8-installer
    
### Maven

#### Installation

On linux

    sudo apt-get update
    sudo apt-get install maven

### Build  

Retrieve the project

    git clone https://github.com/gustavotsuji/interview.git

Then build with maven

    mvn clean install

### Tests
Unfortunatelly I did not have time to create tests (they are quite simple but I really did not time to do it...)

### Deploy

Spring Boot has a embedded Tomcat. It will start at localhost:8080 by executing

    java -jar challenge-0.1.0.jar

### Todos

 - Report coverage
 - Create unit tests
