# How to Use APIs

Assuming your Spring Boot application is running on `http://localhost:8080`, here's how to interact with the APIs:

## Select Single Student:

- **URL:** `http://localhost:8080/selectSingle?id=1`
- **Method:** GET

## Select All Students:

- **URL:** `http://localhost:8080/selectStudent`
- **Method:** GET

## Insert Student:

- **URL:** `http://localhost:8080/insertStudent`
- **Method:** POST
- **Request Body:** JSON representation of the `Student` object

## Update Student:

- **URL:** `http://localhost:8080/updateStudent`
- **Method:** POST
- **Request Body:** JSON representation of the updated `Student` object

## Delete Student:

- **URL:** `http://localhost:8080/deleteStudent?id=1`
- **Method:** GET
