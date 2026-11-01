# Student CRUD Application

A Student Management System developed using Java and Spring Boot that performs CRUD (Create, Read, Update, Delete) operations with a MySQL database.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Postman

## Features

- Add new student records.
- Retrieve student details by ID.
- Update existing student information.
- Delete student records.
- Soft delete functionality.
- Store and manage student data using MySQL.

## Project Architecture

The application follows a layered architecture:

- **Controller Layer:** Handles incoming HTTP requests and returns responses using ResponseEntity.
- **Service Layer:** Contains business logic.
- **Repository Layer:** Communicates with the database using Spring Data JPA.
- **Entity Layer:** Represents the Student table in the database.

## Database

Database: MySQL

Table: Student

Student fields:
- ID
- Name
- Age
- Email
- Roll Number
- Subject
- Delete Status

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/students/create` | Create student |
| GET | `/api/students/get/{id}` | Get student by ID |
| PUT | `/api/students/update/{id}` | Update student |
| DELETE | `/api/students/delete/{id}` | Delete student |
| PATCH | `/api/students/delete-soft/{id}` | Soft delete student |

## How to Run the Project

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Configure MySQL database credentials in `application.properties`.
4. Create the database `student_crud_db`.
5. Run the main Spring Boot application class.
6. Test the REST APIs using Postman.

## Author

Apeksha Chavan
