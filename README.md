# Movie Watchlist System
Final project for CPSC 449  
Cassandra Santillano  
CWID: 884464942

---
### Overview:
This project is a movie watchlist system, that is a RESTful backend application using Spring Boot, MongoDB,
JWT authentication, and Docker.

---
### Prerequisites:
* Java 21
* Docker Desktop
* MongoDB running locally on port 27017
---
### How to build and run:
Open terminal and run:
* docker build --no-cache -t moviewatchlist:1.0 .
* docker run -d --name moviewatchlist -p 8080:8080 
-e SPRING_DATA_MONGODB_URI=mongodb://host.docker.internal:27017/moviewatchlist
-e JWT_SECRET=cpsc449-moviewatchlist-secret-key-must-be-at-least-256-bits-long! moviewatchlist:1.0
* docker logs moviewatchlist
---

### Endpoints include:
auth endpoints don't require Jwt bearer token, movies endpoints do
* POST /api/auth/login
  * ex: { "email": "john@example.com", "password": "pass123" }
* POST /api/auth/register
  * ex: { "username": "john", "email": "john@example.com", "password": "pass123" }
* POST /api/movies
  * ex: { "title": "Interstellar", "genre": "Sci-Fi", "releaseYear": 2014, "isWatched": false, "rating": null }
* GET /api/movies
* GET /api/movies/{id}
* PUT /api/movies/{id}
  * ex: { "title": "Interstellar", "genre": "Sci-Fi", "releaseYear": 2014, "isWatched": true, "rating": 5 }
* DELETE /api/movies/{id}
---
## Screenshots: