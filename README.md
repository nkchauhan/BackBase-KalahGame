# Kalah Game
This is a java web application that runs the game of 6-stone Kalah.
For the general rules of the game please refer to Wikipedia: https://en.wikipedia.org/wiki/Kalah.
The default implementation of this app for 6-stone.

## About the game
* Each of the two players has six pits in front of him/her.
* To the right of the six pits, each player has a larger pit, his Kalah or house.
* At the start of the game, six stones are put In each pit.
* The player who begins picks up all the stones in any of their own pits, and sows the stones on to the right, one in each of the following pits, including his own Kalah.
* No stones are put in the opponent's' Kalah. If the players last stone lands in his own Kalah, he gets another turn. This can be repeated any number of times before it's the other player's turn.

## Implementation decisions.

* Spring Boot and Java 8 in the backend.
* Allowed to connect just two players.
* For fallback mechanism Circuit Breaker(Hystrix implementation of NetFlix) is used.
* Added spring security
* UserId and Password for first user: user1/password1
* UserId and Password for second user: user2/password2

## Install & Running

### Prerequisites
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  - Programming language
* [Maven 3.5.0](https://maven.apache.org/download.cgi) - Build tool


### Pull from git
```
$ git clone https://github.com/nkchauhan/BackBase-KalahGame
```

### Build & run

* Run test
```
$ mvn test
```

* Run the web server
```
$ mvn spring-boot:run
```

### API documentation
After running the project on local environment and browse
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


## Built With
* [Spring boot 2.2.4](https://projects.spring.io/spring-boot/) -Backed Framework
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Nripendra Chauhan**
