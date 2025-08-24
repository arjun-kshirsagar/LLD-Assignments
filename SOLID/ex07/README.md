# Exercise ex07 - Interface Segregation Principle (ISP)

## Problem Identified
- **Violation**: The `Machine` interface was forcing all implementing classes to provide implementations for all methods (`print`, `scan`, `fax`), even if they didn't support all functionalities.
- **Issue**: This led to `BasicPrinter` throwing `UnsupportedOperationException` for `scan` and `fax` methods, which is a code smell.

## SOLID Principle Applied: Interface Segregation Principle (ISP)
> "Clients should not be forced to depend upon interfaces that they do not use."

## Changes Made
1. **Split the large interface** into smaller, focused interfaces:
   - `Printer` - For printing functionality
   - `Scanner` - For scanning functionality
   - `FaxMachine` - For faxing functionality

2. **Created two implementations**:
   - `BasicPrinter` - Implements only `Printer` interface
   - `MultiFunctionPrinter` - Implements all three interfaces

3. **Updated Demo** to show both types of printers in action.

## How to Run
```bash
cd src
javac Demo07.java
java Demo07
```

## Expected Output
```
=== Basic Printer ===
Print: Hello World

=== Multi-function Printer ===
Printing: Document
Scanning to: /scans/document1.pdf
Sending fax to: 123-456-7890
```

## Benefits of the Refactoring
- **No more unexpected exceptions** - Each class only implements what it can actually do
- **Better type safety** - The compiler enforces which operations are available
- **Easier to maintain** - Adding new printer types is more straightforward
- **Clearer code** - The interfaces clearly communicate what operations are supported
