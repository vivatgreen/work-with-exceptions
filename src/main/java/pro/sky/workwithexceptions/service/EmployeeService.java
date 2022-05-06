package pro.sky.workwithexceptions.service;

import pro.sky.workwithexceptions.Employee;

public interface EmployeeService {
    int numberEmployees();

    String addEmployee(String firstName, String lastName);

    String removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
}
