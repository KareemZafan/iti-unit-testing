package org.iti.app_tests;

import org.iti.app.Employee;
import org.iti.app.EmployeeDAO;
import org.iti.app.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTests {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testCalculateAverageSalary() {
        // Mock database response
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(2, "Bob", "HR", 75000)
        );

        when(employeeDAO.findAll()).thenReturn(mockEmployees);

        // Test calculation
        double average = employeeService.calculateAverageSalary();
        assertEquals(80000, average, 0.001);
        verify(employeeDAO, times(1)).findAll();
    }

    @Test
    void testGetEmployeesByDepartment() {
        // Mock database response
        List<Employee> mockEmployees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000),
                new Employee(3, "Charlie", "Engineering", 90000)
        );

        when(employeeDAO.findAll()).thenReturn(mockEmployees);

        // Test department filter
        List<Employee> engineering = employeeService.getEmployeesByDepartment("Engineering");
        assertEquals(2, engineering.size());
        List<String> names = engineering.stream().map(Employee::getName).toList();
        assertEquals(List.of("Alice", "Charlie"), names);
        verify(employeeDAO, times(1)).findAll();
    }

    @Test
    void testGetEmployeeById() {
        // Mock database response
        Employee mockEmployee = new Employee(1, "Alice", "Engineering", 85000);
        when(employeeDAO.findById(1)).thenReturn(mockEmployee);

        // Test ID lookup
        Employee result = employeeService.getEmployeeById(1);
        assertEquals("Alice", result.getName());
        verify(employeeDAO, times(1)).findById(1);
    }

    @Test
    void testEmptyResultHandling() {
        when(employeeDAO.findAll()).thenReturn(List.of());

        double average = employeeService.calculateAverageSalary();
        assertEquals(0.0, average, 0.001);
        verify(employeeDAO, times(1)).findAll();
    }

    @Test
    void testNonExistentEmployee() {
        when(employeeDAO.findById(999)).thenReturn(null);

        Employee result = employeeService.getEmployeeById(999);
        assertNull(result);
        verify(employeeDAO, times(1)).findById(999);
    }
}
