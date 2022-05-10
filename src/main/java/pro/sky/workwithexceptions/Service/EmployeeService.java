package pro.sky.workwithexceptions.Service;

import pro.sky.workwithexceptions.Data.Employee;

import java.util.List;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastNam);

    Employee removeEmployee(String firstName, String lastNam);

    Employee findEmployee(String firstName, String lastNam);

    List<Employee> showEmployee();

}

