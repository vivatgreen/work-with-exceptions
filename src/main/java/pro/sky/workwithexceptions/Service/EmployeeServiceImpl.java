package pro.sky.workwithexceptions.Service;

import pro.sky.workwithexceptions.Expceptions.HasAlreadyBeenAddedException;
import pro.sky.workwithexceptions.Expceptions.NotFoundException;
import pro.sky.workwithexceptions.Data.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String,Employee> employees = new HashMap<>();

    @Override
    public String addEmployee(String firstName, String lastName, int salary, int departmentId) {

        Employee addingEmployee = new Employee(firstName, lastName, salary, departmentId);

        String keyForMap = firstName + lastName;

        if (employees.containsKey(keyForMap)) {
            throw new HasAlreadyBeenAddedException("Этот сотрудник уже был добавлен");
        }

        employees.put(keyForMap,addingEmployee);
        return "Сотрудник " + addingEmployee.getFirstName() + " " + addingEmployee.getLastName() + " успешно создан";
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName, lastName);

        String keyForMap = firstName + lastName;

        if (!employees.containsKey(keyForMap)) {
            throw new NotFoundException ("Мы не можем найти этого сотрудника");
        }
        employees.remove(keyForMap);

        return "Сотрудник " + removingEmployee.getFirstName() + " " + removingEmployee.getLastName() + " успешно удален";
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        String keyForMap = firstName + lastName;

        if (!employees.containsKey(keyForMap)) {
            throw new NotFoundException ("Мы не можем найти этого сотрудника");
        }

        return employees.get(keyForMap);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
