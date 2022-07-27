# Abstract

This is my approach to solution of Wefox Java Challenge (I have kept the original wording at the end of this document).
To begin with, I will describe the problems I have found in the settings of working environment.
Secondly, I'll explain my solution to each one of the four exercises.

#  

# Wefox Java Challenge

- This is a Spring Boot Application with all needed dependencies included in the POM file.
- Feel free to change the project architecture or any relevant configuration.
- You have a docker file to run a postgresDB.
- Add as many tests as you need.

# Exercise

1 - Implement REST API to retrieve:

- Pokemons whose name starts with {parameter}
- The 3 heaviest Pokemons
- the 3 Pokemons with more base experience

2 - Configure the heaviest pokemons endpoint to avoid spring security.

3 - Create a sql script to create the necessary tables and column in the DB to store the pokemons information.

4 - Create remaining CRUD endpoints for pokemons using DB entities.

### Infrastructure

The required infrastructure is already provided. All you need to do is to
install [Docker Engine]("https://docs.docker.com/get-docker/") and to use docker-compose to start
the services.

To start the services run `docker-compose up`. Use `-d` to start in detached mode and run the
containers in the background.

For a more detailed information about docker-compose commands refer to the official
documentation: [Overview of Docker Compose](https://docs.docker.com/compose/).