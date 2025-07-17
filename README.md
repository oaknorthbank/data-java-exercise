Pairing Exercise: Java
=====================

This is a pairing exercise for prospective data engineers with a focus on Java.

The candidate should guide the exercise and do as much as is feasible within the time limit (~30-35 minutes).

## Workflow

The candidate can choose to use any tools, IDEs and editors they like and is expected to have some setup to be able to share their screen and write Java code.

The pairing exercise should be run following [Test-Driven Development (TDD)](https://en.wikipedia.org/wiki/Test-driven_development). The candidate doesn't need to have previous TDD experience, but some understanding of what it is at high level can be helpful.

The main idea is to start by writing a failing test with the expected behaviour of the code, and then work on it until the test passes.

## Setup

The exercise should not require the use of any external dependencies except for JUnit 5 to run the tests.

### Prerequisites

- Java 11 or higher
- Maven 3.6+ (optional - you can use your IDE's built-in tools)

### Running the Tests

```bash
mvn test
```

Or if you prefer to use the IDE's built-in test runner, you can run the tests directly from your IDE.

### Project Structure

The project follows standard Java conventions:
- `src/main/java/` - Main source code
- `src/test/java/` - Test code
- `src/main/resources/` - Resources (CSV file)
- `pom.xml` - Maven configuration
