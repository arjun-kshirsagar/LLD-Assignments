# Exercise ex01

How to run:
```bash
cd src
javac Demo01.java
java Demo01
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test


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

### 3. **Liskov Substitution Principle (LSP)** ✅

* No inheritance here, so **not violated**.

---

### 4. **Interface Segregation Principle (ISP)** ✅ (for now)

* There aren’t interfaces yet, so nothing is being forced on clients.
* However, introducing a fat interface later could risk violation.

---

### 5. **Dependency Inversion Principle (DIP)** ❌

* `OrderService` depends on the **concrete class** `EmailClient`.
* It should depend on an **abstraction** (like `NotificationSender` or `IEmailClient`), so that we can easily swap out implementations (e.g., mock email in tests, use SMS instead).

👉 DIP is violated.

---

✅ **Summary:**

* **Violated:** SRP, OCP, DIP
* **Not violated:** LSP, ISP

---
