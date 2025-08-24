# Exercise ex08 - Interface Segregation Principle (ISP)

## Problem Identified
- **Violation**: The `Vehicle` interface was forcing all implementing classes to provide implementations for all methods (`startEngine`, `pedal`, `recharge`), even if they didn't support all functionalities.
- **Issue**: This led to `Bicycle` throwing `UnsupportedOperationException` for `startEngine` and `recharge` methods, which is a code smell and violates the Interface Segregation Principle.

## SOLID Principle Applied: Interface Segregation Principle (ISP)
> "Clients should not be forced to depend upon interfaces that they do not use."

## Changes Made
1. **Split the large `Vehicle` interface** into smaller, focused interfaces:
   - `EngineVehicle` - For vehicles with engines
   - `Rechargeable` - For vehicles that can be recharged
   - `HumanPowered` - For human-powered vehicles

2. **Created specific implementations**:
   - `Bicycle` - Implements only `HumanPowered`
   - `Car` - Implements both `EngineVehicle` and `Rechargeable`

3. **Updated Demo** to show both vehicle types in action.

## How to Run
```bash
cd src
javac Demo08.java
java Demo08
```

## Expected Output
```
=== Bicycle Demo ===
Pedal effort: 50

=== Car Demo ===
Engine started
Charged: 10kWh. Battery level: 10kWh
Engine stopped
```

## Benefits of the Refactoring
- **No more unexpected exceptions** - Each class only implements what it can actually do
- **Better type safety** - The compiler enforces which operations are available
- **More flexible design** - Easy to create new vehicle types with different capabilities
- **Clearer code** - The interfaces clearly communicate what operations are supported
- **Easier to maintain** - Changes to one type of functionality don't affect unrelated types
