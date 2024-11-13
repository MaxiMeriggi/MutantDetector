# Spring Boot REST API

## Overview

This project is a simple Spring Boot REST API built using Java 21. It exposes an endpoint `/mutant` that can be used for your specific functionality (you can expand the logic as needed).

## Technologies

- **Spring Boot**: Version 3.3.5
- **Java**: Version 21
- **Gradle**: Build automation
- **Spring Web**: For creating RESTful services

## Setup

### Prerequisites

Before running the application, ensure you have the following installed:

- **Java 21**: You can download and install it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html).
- **Gradle**: If you don't have Gradle, you can install it from [gradle.org](https://gradle.org/install/).

### Running the Application

To run the application, follow these steps:

### 1. Clone the repository:
   ```
    git clone <repository-url>

    cd <repository-directory>
   ```
### 2. Build the project using Gradle:
    ```
    ./gradlew build
    ```
### 3. Run the application:
    ```
    ./gradlew bootRun
    ```
The application will start on port `8080` by default. Once the application is running, you can test the `/mutant` endpoint by sending a `POST` request.

#### Request Body Example:
```
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}
```
### API Responses


- **Success (200 OK)**: If the mutant DNA is recognized, the response will be:
```
{
  "message": "Mutant detected"
}
```
- **Error (403 Forbidden)**: If the DNA does not represent a mutant, the response will be:
```
{
  "message": "Access denied"
}
```
### Project Structure

- `src/main/java/com/challenge/adn`: The main Java source files.
- `src/main/resources`: Resources, such as application properties.
- `src/test/java`: Test cases for the application.

## Endpoints

- **POST `/mutant`**: Validates if the DNA sequence represents a mutant.
  - **Request Body**: A JSON object with an array of DNA sequences.
  - **Response**: A JSON response indicating whether the DNA is of a mutant.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.