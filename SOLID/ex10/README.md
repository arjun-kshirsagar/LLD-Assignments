# Exercise ex10 - Dependency Inversion Principle (DIP)

## Problem Identified
- **Violation**: The `ReportService` had a direct dependency on the concrete `ConsoleLogger` class, violating the Dependency Inversion Principle (DIP).
- **Issue**: This tight coupling made the code less flexible and harder to test, as you couldn't easily swap out the logging implementation.

## SOLID Principle Applied: Dependency Inversion Principle (DIP)
> "High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions."

## Changes Made
1. **Created an abstraction**:
   - Added `Logger` interface
   - Made `ConsoleLogger` implement this interface
   - Added `FileLogger` as an alternative implementation

2. **Applied Dependency Injection**:
   - Modified `ReportService` to depend on `Logger` abstraction
   - Used constructor injection for better testability

3. **Added flexibility**:
   - Can now easily swap between different logger implementations
   - Demonstrated with both console and file logging

## How to Run
```bash
cd src
javac Demo10.java
java Demo10
```

## Expected Output
```
[LOG] Generating daily report...
Report contents...
[FileLogger] Logged to app.log: Generating daily report...
Report contents...
```

## Benefits of the Refactoring
- **Loose Coupling**: `ReportService` now depends on an abstraction, not a concrete implementation
- **Testability**: Easy to mock the logger for unit testing
- **Flexibility**: Can switch between different logger implementations without changing the service
- **Maintainability**: Changes to the logging implementation don't affect the report generation
- **Extensibility**: Easy to add new logger types (e.g., database, remote logging) without modifying existing code
