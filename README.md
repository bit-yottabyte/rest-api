# User Management REST API

## Synopsis

This is a simple User Management REST API built with Spring Boot. The application provides endpoints for creating, retrieving, updating, and deleting user records. Each user has the following attributes:

- **Username**
- **First Name**
- **Last Name**
- **Email**
- **Phone Number**

The API is designed to be straightforward and is suitable for demonstrating basic CRUD (Create, Read, Update, Delete) operations.

## Features

- Create a new user
- Retrieve a list of all users
- Retrieve a single user by ID
- Update an existing user
- Delete a user

## API Endpoints

| HTTP Method | Endpoint          | Description                       |
|-------------|-------------------|-----------------------------------|
| POST        | /users            | Create a new user                |
| GET         | /users            | Retrieve all users                |
| GET         | /users/{id}       | Retrieve a user by ID             |
| PUT         | /users/{id}       | Update an existing user           |
| DELETE      | /users/{id}       | Delete a user                     |

## Dependencies

This project uses the following dependencies:

- **Spring Boot**: Framework for building Java-based web applications.
- **Spring Web**: For creating RESTful web services.
- **Spring Data JPA**: For data access and persistence.
- **H2 Database**: An in-memory database for testing purposes.
- **Lombok**: To reduce boilerplate code for getters, setters, and constructors.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven (if you want to manage dependencies)
- An IDE (like IntelliJ IDEA or Eclipse) for development

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/user-management-api.git
