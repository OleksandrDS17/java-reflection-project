# Mini Test Framework-Reflection-PostgreSQL-GUI

A lightweight Java testing framework built using **Reflection**.  
The project demonstrates how to detect and execute custom test methods, store results in **PostgreSQL**, and display them using a **Swing GUI**.

This project was created for learning and demonstrating:

- Java Reflection
- Custom Annotations
- JDBC Database Integration
- Dockerized PostgreSQL
- Swing GUI development

---

# Features

✔ Custom `@Test` annotation  
✔ Reflection-based test discovery and execution  
✔ Automatic test result tracking  
✔ PostgreSQL database integration  
✔ Docker Compose setup for database  
✔ Swing graphical interface for running tests  
✔ View and clear stored test results

---

# Technologies

| Technology | Purpose |
|-----------|--------|
| Java 17 | Core language |
| Maven | Build management |
| PostgreSQL | Storing test results |
| JDBC | Database communication |
| Docker Compose | Database container |
| Swing | Graphical interface |
| Reflection API | Dynamic test discovery |

---

# Project Structure
src/main/java/com/github/oleksandrds17
│
├── CalculatorTest.java
│ Example test class with methods annotated using @Test
│
├── Test.java
│ Custom annotation used to mark test methods
│
├── TestRunner.java
│ Reflection-based engine that discovers and executes test methods
│
├── DatabaseManager.java
│ Handles database operations (save, load, clear test results)
│
├── DatabaseConfig.java
│ Loads database configuration from environment variables
│
├── TestController.java
│ Controller layer connecting GUI and backend
│
├── TestGUI.java
│ Swing GUI for running tests and viewing results
│
└── DBTest.java
Simple utility class to test database connectivity


---

# How the Test Runner Works

1. Methods are annotated using the custom `@Test` annotation.
2. `TestRunner` scans the class using Java Reflection.
3. Each test method is executed dynamically.
4. The result (PASSED / FAILED) is stored in PostgreSQL.
5. Results can be viewed in the Swing GUI.

Example:

```java
@Test
public void testAddition() {
    int a = 5;
    int b = 3;

    if (a + b != 8) {
        throw new RuntimeException("Addition failed");
    }
}

Only methods annotated with @Test will be executed.

Database Setup

The project uses PostgreSQL.

Database table:

CREATE TABLE IF NOT EXISTS test_results (
    id SERIAL PRIMARY KEY,
    test_name VARCHAR(255) NOT NULL,
    result VARCHAR(50) NOT NULL,
    run_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
Run PostgreSQL with Docker

Start the database:

docker compose up -d

This will start PostgreSQL with:

Database: testdb
User: postgres
Password: password
Port: 5432
Database Configuration

The application reads database credentials from environment variables.

Example:

export DB_URL=jdbc:postgresql://localhost:5432/testdb
export DB_USER=postgres
export DB_PASSWORD=password

If variables are not set, the application uses default values.

Build Project

Compile the project with Maven:

mvn clean install
Run the Application

Run the Swing GUI:

TestGUI

Buttons:

Button	Action
Run Tests	Executes all tests
Load Results	Loads results from database
Clear DB	Clears stored results
Example Output

Console:

Test passed: testAddition
Test passed: testMultiplication

Passed: 2
Failed: 0

Database:

ID	Test Name	Result	Run Time
1	testAddition	PASSED	...
2	testMultiplication	PASSED	...
Learning Goals

This project demonstrates:

Creating custom Java annotations

Using Reflection to inspect classes and methods

Building a simple test framework

JDBC database interaction

Integrating Docker with Java projects

Building a desktop GUI with Swing

Possible Improvements

Support multiple test classes

Add test suites

Show stack traces in GUI

Export results to JSON

Add parallel test execution

Add JUnit-style assertions

Author

GitHub:
https://github.com/oleksandrds17


---

# Kleiner GitHub Tipp

Wenn du dein Projekt veröffentlichst, empfehle ich:

Repository Name:


reflect-test-runner


Beschreibung:


A simple Java testing framework using Reflection, PostgreSQL and Swing GUI.


---

Wenn du möchtest, kann ich dir auch noch eine **richtig starke README mit GitHub Badges, Architekturdiagramm und Screenshots-Sektion bauen**.  
Die sieht dann **viel professioneller aus (wie echte Open-Source Projekte)**.