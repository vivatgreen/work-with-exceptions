package pro.sky.workwithexceptions.Service;

import pro.sky.workwithexceptions.Data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeDeptService {

    Employee getEmployeeWithMinimalSalaryByDept(int departmentId);

    Employee getEmployeeWithMaximumSalaryByDept(int departmentId);

    Collection<Employee> getEmployeesOnlyThisDeptByDept(int departmentId);

    Map<Integer, List<Employee>> getAllEmployeesByDept();

}



