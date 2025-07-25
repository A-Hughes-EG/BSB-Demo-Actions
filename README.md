# Simple API Demo

A basic Spring Boot REST API for demonstrating GitHub Actions CI/CD with automated testing.

## Project Overview

This is a simple REST API that provides a greeting endpoint. The project includes:
- A Spring Boot web application
- REST endpoints for greeting users
- Unit tests to validate API responses
- GitHub Actions workflow for continuous integration

## API Endpoints

- `GET /api/greet/{name}` - Returns a personalized greeting
- `GET /api/health` - Returns API health status

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Git

## Running the Project

### 1. Clone the repository
```bash
git clone <your-repo-url>
cd simple-api-demo
```

### 2. Build the project
```bash
mvn clean compile
```

### 3. Run tests
```bash
mvn test
```

### 4. Start the application
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

### 5. Test the endpoints
```bash
# Health check
curl http://localhost:8080/api/health

# Greeting endpoint
curl http://localhost:8080/api/greet/World
```

## Demo Script

This project is designed to demonstrate GitHub Actions testing:

1. **Initial state**: All tests pass on main branch
2. **Break the API**: Create a branch and modify the greeting response
3. **Create PR**: GitHub Actions will run tests and show failures
4. **Fix and merge**: Correct the response to make tests pass

## GitHub Actions

The project includes a CI workflow (`.github/workflows/ci.yml`) that:
- Runs on every push and pull request
- Sets up Java 11 environment
- Executes all unit tests
- Reports test results

## Project Structure

```
simple-api-demo/
├── .github/workflows/ci.yml    # GitHub Actions workflow
├── src/
│   ├── main/java/com/demo/
│   │   ├── ApiApplication.java      # Main application
│   │   └── GreetingController.java  # REST controller
│   └── test/java/com/demo/
│       └── GreetingControllerTest.java # API tests
├── pom.xml                     # Maven configuration
└── README.md                   # This file
```
