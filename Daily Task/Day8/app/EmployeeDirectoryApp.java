package app;

import model.Employee;
import service.EmployeeDirectoryService;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDirectoryApp {

    public static void main(String[] args) {

        EmployeeDirectoryService service = new EmployeeDirectoryService();

        service.addEmployee(new Employee(103, "Arun", "IT", 60000));
        service.addEmployee(new Employee(101, "Bala", "HR", 45000));
        service.addEmployee(new Employee(104, "Divya", "IT", 80000));
        service.addEmployee(new Employee(102, "Kavi", "HR", 70000));
        service.addEmployee(new Employee(105, "Nila", "Sales", 55000));

        System.out.println("=== Employee Lookup ===");
        Employee found = service.findEmployeeById(104);

        if (found != null) {
            found.display();
        } else {
            System.out.println("Employee not found");
        }

        System.out.println("\n=== Department Frequency ===");
        service.getDepartmentCount().forEach(
            (department, count) ->
                System.out.println(department + ": " + count)
        );

        System.out.println("\n=== Sorted Department Report ===");
        service.getSortedDepartmentReport().forEach(
            (department, count) ->
                System.out.println(department + ": " + count)
        );

        System.out.println("\n=== Employees Sorted by ID ===");
        service.getEmployeesSortedById().forEach(Employee::display);

        System.out.println("\n=== Top 5 Employees by Salary ===");
        service.getTopFiveEmployees().forEach(Employee::display);

        System.out.println("\n=== equals() and hashCode() Demo ===");

        Employee first = new Employee(101, "Bala", "HR", 45000);
        Employee second = new Employee(101, "Different Name", "IT", 90000);

        System.out.println("first.equals(second): " + first.equals(second));

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(first);
        employeeSet.add(second);

        System.out.println("HashSet size: " + employeeSet.size());
    }
}
