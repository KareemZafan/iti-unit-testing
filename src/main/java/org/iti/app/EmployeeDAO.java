package org.iti.app;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee employee);
    Employee findById(int id);
    List<Employee> findAll();
}