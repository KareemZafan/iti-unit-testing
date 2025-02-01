package org.iti.app;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public double calculateAverageSalary() {
        List<Employee> employees = employeeDAO.findAll();
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeDAO.findAll().stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .toList();
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.findById(id);
    }
}
