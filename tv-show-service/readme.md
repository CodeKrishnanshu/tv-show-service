**TV Shows API**
-----------------

**Description** - This is TV Show API to create, retrieve, update and delete the TV Show.

Java and Springboot framework is used to create this TV show service application.

Hibernate and Maven are used in this application.

All the  necessary dependencies used in the application are mentioned in pom.xml file.


To run the application locally - 
---------------------------------

Step 1 - Build and run the application "TvShowServiceApplication" from "src/main/java/org/example/tvshowservice/TvShowServiceApplication.java".

Step 2 - H2 embedded database is used in this project and can be accessed through "http://localhost:8080/h2-console/"

Step 3 - To access the database enter the username - "sh" and do not provide password. Provide the correct JDBC url for "mem" Database- "jdbc:h2:mem:testdb" and for "file based"- "jdbc:h2:file:~/db/testdb" and login.

Step 4 - In application-local.properties  "in memory" based database in used and in application.properties "file" based database is used. 

Step 5 - Currently it is set to "spring.profiles.active=local" in application.properties to use the "in memory" database, if "file" based database is required remove "spring.profiles.active=local" from application.properties.

Step 6 - Go to browser and test the h2 database connection and connect to access the database to check the records in the database.

Step 7 - Go to path "http://localhost:8080/swagger-ui/index.html" on the web browser to access the swagger to test the created APIs.

Step 8 - To access and test the endpoints through swagger use username - "krishna" and password - "krishna" to access the endpoints.

Step 9 - Use the example payload request mentioned below to create the TVShow record through post mapping "/v1/tv/shows" endpoint. Feel free to modify it.

{
"title": "Friends",
"genre": "Comedy",
"releaseYear": 2024,
"language": "English",
"description": "Six American friends living in a house",
"country": "United States",
"rating": 4.6,
"duration": "2h 10m",
"imageURL": "https://images.app.goo.gl/iYiG99TgmBhwjF2VA",
"trailerURL": "https://www.youtube.com/watch?v=IEEbUzffzrk&ab_channel=WS"
}

Step 10 - In the get mapping "/v1/tv/shows/{showId}" endpoint enter the showId you received after executing Step 9 to retrieve the details of a specific show through it's showId.

Step 11 - In the get mapping "/v1/tv/shows" endpoint to retrieve all the records of TV shows exists in the database. In case, there are no shows, 404 status code is shown.

Step 12 - In the get mapping "/v1/tv/shows/genre/{genre} endpoint, enter the desired genre and execute it to retrieve the records of all the TV shows where the genre is same as the desired genre entered.

Step 13 - In the put mapping "/v1/tv/shows/{showId}" endpoint, update the attributes of the existing TV show record and execute it to update TV show record to the database.

Step 14 - In the delete mapping "/v1/tv/shows/{showId}" endpoint, enter the showId and execute it to delete TV show record from the database.



To execute the created test cases in the application -
------------------------------------

Step 1 - Go to "src/test/java/org/example/tvshowservice/service" and execute the created unit tests.

Step 2 - Go to "src/test/java/org/example/tvshowservice/controller" and execute the created integration tests.



