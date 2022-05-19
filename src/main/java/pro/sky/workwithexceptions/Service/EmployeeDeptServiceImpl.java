package pro.sky.workwithexceptions.Service;

import pro.sky.workwithexceptions.Expceptions.NotFoundException;
import pro.sky.workwithexceptions.Data.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeDeptServiceImpl implements EmployeeDeptService {

    private final EmployeeService employeeService;

    public EmployeeDeptServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee getEmployeeWithMinimalSalaryByDept(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMaximumSalaryByDept(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Collection<Employee> getEmployeesOnlyThisDeptByDept(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDept() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
