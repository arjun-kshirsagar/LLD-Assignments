# Exercise ex09 - Dependency Inversion Principle (DIP)

## Problem Identified
- **Violation**: The `OrderController` had a direct dependency on the concrete `SqlOrderRepository` class, violating the Dependency Inversion Principle (DIP).
- **Issue**: This tight coupling made the code less flexible and harder to test, as you couldn't easily swap out the repository implementation.

## SOLID Principle Applied: Dependency Inversion Principle (DIP)
> "High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions."

## Changes Made
1. **Created an abstraction**:
   - Added `OrderRepository` interface
   - Made `SqlOrderRepository` implement this interface

2. **Applied Dependency Injection**:
   - Modified `OrderController` to depend on `OrderRepository` abstraction
   - Used constructor injection for better testability

3. **Added flexibility**:
   - Created `InMemoryOrderRepository` to demonstrate easy swapping of implementations
   - Showed how different repository types can be used with the same controller

## How to Run
```bash
cd src
javac Demo09.java
java Demo09
```

## Expected Output
```
Saved order ORD-1 to SQL
Created order: ORD-1
Saved order ORD-2 to memory
Created order: ORD-2
```

## Benefits of the Refactoring
- **Loose Coupling**: `OrderController` now depends on an abstraction, not a concrete implementation
- **Testability**: Easy to mock the repository for unit testing
- **Flexibility**: Can switch between different repository implementations without changing the controller
- **Maintainability**: Changes to the repository implementation don't affect the controller
- **Extensibility**: Easy to add new repository types (e.g., MongoDB, file-based) without modifying existing code
