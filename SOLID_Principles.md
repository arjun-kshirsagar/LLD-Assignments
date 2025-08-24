# 🔑 What is SOLID?

SOLID is an **object-oriented design principle** acronym that helps make software more maintainable, flexible, and scalable. It was popularized by Robert C. Martin (Uncle Bob).

**SOLID stands for:**

1. **S** – Single Responsibility Principle
2. **O** – Open/Closed Principle
3. **L** – Liskov Substitution Principle
4. **I** – Interface Segregation Principle
5. **D** – Dependency Inversion Principle

---

## 1️⃣ Single Responsibility Principle (SRP)

> A class should have **only one reason to change**.

Each class/module should do **one thing and do it well**. If a class has multiple responsibilities, it becomes harder to maintain and test.

✅ **Good Example:**

```java
class Invoice {
    private double amount;

    public double getAmount() { return amount; }
}

class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Invoice amount: " + invoice.getAmount());
    }
}

class InvoiceSaver {
    public void save(Invoice invoice) {
        // Save to database
    }
}
```

👉 Here, `Invoice` handles data, `InvoicePrinter` handles printing, and `InvoiceSaver` handles persistence.
If you want to change the print format, you don’t touch the saving logic.

❌ **Bad Example:**
One `Invoice` class that has both database saving and printing code inside.

---

## 2️⃣ Open/Closed Principle (OCP)

> Software entities should be **open for extension, but closed for modification**.

This means we should be able to add **new features** without modifying existing code.

✅ **Good Example (Polymorphism):**

```java
interface Shape {
    double area();
}

class Circle implements Shape {
    private double r;
    public Circle(double r) { this.r = r; }
    public double area() { return Math.PI * r * r; }
}

class Rectangle implements Shape {
    private double w, h;
    public Rectangle(double w, double h) { this.w = w; this.h = h; }
    public double area() { return w * h; }
}

class AreaCalculator {
    public double totalArea(List<Shape> shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.area();
        return sum;
    }
}
```

👉 To add `Triangle`, we don’t modify `AreaCalculator`. We just add another class implementing `Shape`.

❌ **Bad Example:**
If `AreaCalculator` had:

```java
if (shape instanceof Circle) {...}
else if (shape instanceof Rectangle) {...}
```

That violates OCP, because we must change `AreaCalculator` every time a new shape is added.

---

## 3️⃣ Liskov Substitution Principle (LSP)

> Subtypes must be substitutable for their base types **without breaking functionality**.

If class `B` is a subclass of class `A`, then anywhere `A` is expected, we should be able to use `B` without errors.

✅ **Good Example:**

```java
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Sparrow extends Bird {}
class Pigeon extends Bird {}
```

👉 Both `Sparrow` and `Pigeon` behave correctly if substituted for `Bird`.

❌ **Bad Example (Violation):**

```java
class Bird {
    public void fly() {}
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can’t fly!");
    }
}
```

👉 This breaks LSP, because substituting `Ostrich` for `Bird` causes runtime errors.
Fix: Introduce hierarchy: `FlyingBird` and `NonFlyingBird`.

---

## 4️⃣ Interface Segregation Principle (ISP)

> Clients should not be forced to depend on interfaces they do not use.

Instead of one big interface, create smaller, more specific ones.

✅ **Good Example:**

```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class BasicPrinter implements Printer {
    public void print() { System.out.println("Printing..."); }
}

class MultiFunctionPrinter implements Printer, Scanner {
    public void print() { System.out.println("Printing..."); }
    public void scan() { System.out.println("Scanning..."); }
}
```

👉 Clients who only need printing implement only `Printer`.

❌ **Bad Example:**

```java
interface Machine {
    void print();
    void scan();
}

class OldPrinter implements Machine {
    public void print() {}
    public void scan() { throw new UnsupportedOperationException(); }
}
```

👉 Forces unused methods → ISP violation.

---

## 5️⃣ Dependency Inversion Principle (DIP)

> High-level modules should not depend on low-level modules.
> Both should depend on **abstractions**.

Also: Abstractions should not depend on details. Details should depend on abstractions.

✅ **Good Example:**

```java
interface MessageSender {
    void send(String to, String message);
}

class EmailSender implements MessageSender {
    public void send(String to, String message) {
        System.out.println("[EMAIL] " + message + " to " + to);
    }
}

class NotificationService {
    private MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notify(String to, String msg) {
        sender.send(to, msg);
    }
}
```

👉 `NotificationService` depends on `MessageSender` (an abstraction), not a concrete `EmailSender`.
We can swap in `SMSSender` without changing `NotificationService`.

❌ **Bad Example:**

```java
class NotificationService {
    private EmailSender email = new EmailSender();
    public void notify(String to, String msg) {
        email.send(to, msg);
    }
}
```

👉 Tightly coupled. Hard to extend.

---

# ✅ Summary Table

| Principle | Definition                                   | Example Fix                                  |
| --------- | -------------------------------------------- | -------------------------------------------- |
| **SRP**   | One responsibility per class                 | Separate printing and saving in Invoice      |
| **OCP**   | Open for extension, closed for modification  | Use `Shape` interface instead of `if` checks |
| **LSP**   | Subtypes replace base types safely           | Split `FlyingBird` and `NonFlyingBird`       |
| **ISP**   | No client forced to implement unused methods | Split `Machine` into `Printer` and `Scanner` |
| **DIP**   | Depend on abstractions, not concretions      | `MessageSender` interface for notifications  |
