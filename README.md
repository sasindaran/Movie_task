# Movie REST API

Simple REST API for managing movies with in-memory storage.

## Requirements

- Java 21
- Maven

## Run Application

```bash
mvn spring-boot:run
```

Application starts on `https://movie-task-f8tf.onrender.com/`

## API Endpoints

### Add Movie (POST)
```bash
POST /movies
Content-Type: application/json

{
  "name": "Inception",
  "description": "A thriller by Nolan"
}

Response: 201 Created
```

### Get Movie by ID (GET)
```bash
GET /movies/{id}

Response: 200 OK or 404 Not Found
```

### Get All Movies (GET)
```bash
GET /movies

Response: 200 OK
```

### Update Movie (PUT)
```bash
PUT /movies/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "description": "Updated Description"
}

Response: 200 OK or 404 Not Found
```

### Delete Movie (DELETE)
```bash
DELETE /movies/{id}

Response: 200 OK or 404 Not Found
```

## Validation

- `name` and `description` are required (cannot be empty)
- Returns 400 Bad Request if validation fails

## Testing with Postman

### Get All Movies
- Method: `GET`
- URL: `https://movie-task-f8tf.onrender.com//movies`

### Get Movie by ID
- Method: `GET`
- URL: `https://movie-task-f8tf.onrender.com//movies/1`

### Add New Movie
- Method: `POST`
- URL: `https://movie-task-f8tf.onrender.com//movies`
- Headers: `Content-Type: application/json`
- Body (raw JSON):
```json
{
  "name": "Avatar",
  "description": "Pandora adventure"
}
```

### Update Movie
- Method: `PUT`
- URL: `https://movie-task-f8tf.onrender.com//movies/1`
- Headers: `Content-Type: application/json`
- Body (raw JSON):
```json
{
  "name": "Updated Name",
  "description": "Updated Description"
}
```

### Delete Movie
- Method: `DELETE`
- URL: `https://movie-task-f8tf.onrender.com//movies/1`

## Implementation

- **Model**: `Movie.java` - Item with id, name, description
- **Storage**: `MovieRepository.java` - ArrayList for in-memory storage
- **Service**: `MovieService.java` - Business logic
- **Controller**: `MovieController.java` - REST endpoints

Pre-loaded with 3 sample movies: Inception, Interstellar, The Dark Knight
