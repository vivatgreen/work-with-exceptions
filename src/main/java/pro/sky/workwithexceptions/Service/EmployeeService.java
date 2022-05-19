package pro.sky.workwithexceptions.Service;

import pro.sky.workwithexceptions.Data.Employee;

import java.util.Collection;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName, int salary, int departmentID);

    String removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}
