package exercise;

import java.util.*;

public class Client {
  public static void main(String[] args) {

    // TODO: Wrap each legacy object with the right adapter and collect into one list
    EmployeeRepository repo = new EmployeeRepository();
    List<Employee> all = repo.getAllEmployees();

    EmployeePrinter.print(all);
  }
}
