package service;

import java.util.*;
import model.Employee;

public class EmployeeDirectoryService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Map<String, Integer> getDepartmentCount() {
        Map<String, Integer> departmentCount = new LinkedHashMap<>();

        for (Employee employee : employees) {
            departmentCount.merge(employee.getDepartment(), 1, Integer::sum);
        }

        return departmentCount;
    }

    public Map<String, Integer> getSortedDepartmentReport() {
        return new TreeMap<>(getDepartmentCount());
    }

    public List<Employee> getEmployeesSortedById() {
        List<Employee> result = new ArrayList<>(employees);
        Collections.sort(result);
        return result;
    }

    public List<Employee> getEmployeesSortedBySalary() {
        List<Employee> result = new ArrayList<>(employees);

        Comparator<Employee> comparator =
            Comparator.comparingDouble(Employee::getSalary)
                      .reversed()
                      .thenComparing(Employee::getName);

        result.sort(comparator);
        return result;
    }

    public List<Employee> getTopFiveEmployees() {
        List<Employee> sorted = getEmployeesSortedBySalary();
        return new ArrayList<>(sorted.subList(0, Math.min(5, sorted.size())));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
