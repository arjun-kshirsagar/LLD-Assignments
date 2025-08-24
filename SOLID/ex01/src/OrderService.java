/*

### 1. **Single Responsibility Principle (SRP)** ❌

* `OrderService` is doing **multiple things**:

  * Calculating totals (`totalWithTax`)
  * Handling checkout business logic
  * Sending emails (`email.send`)
  * Pretending to store the order in a DB

👉 It mixes **business logic + infrastructure concerns (email, persistence)**, so SRP is violated.

---

### 2. **Open/Closed Principle (OCP)** ❌

* `OrderService` is **not open for extension** without modification:

  * If tax calculation rules change (different rates, exemptions, region-specific rules), you must edit this class.
  * If email needs to change (e.g., SMS or push notification instead), you must modify `OrderService`.

👉 Instead, it should depend on abstractions/interfaces that can be extended.

---

### 5. **Dependency Inversion Principle (DIP)** ❌

* `OrderService` depends on the **concrete class** `EmailClient`.
* It should depend on an **abstraction** (like `NotificationSender` or `IEmailClient`), so that we can easily swap out implementations (e.g., mock email in tests, use SMS instead).

👉 DIP is violated.

---

 */
public class OrderService {
    double taxRate = 0.18;
    EmailClient email = new EmailClient();

    double totalWithTax(double subtotal) {
        return subtotal + subtotal * taxRate;
    }
    void checkout(String customerEmail, double subtotal) {
        double total = totalWithTax(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}