package pro.sky.workwithexceptions.Service;

import org.springframework.stereotype.Service;
import pro.sky.workwithexceptions.Data.Employee;
import pro.sky.workwithexceptions.Expceptions.BadEmployeeExceptions;
import pro.sky.workwithexceptions.Expceptions.OverflowArrayException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>(5);

    private boolean isNotValue(String a, String b) {
        return (a.isEmpty() || b.isEmpty());
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new BadEmployeeExceptions();
        }

        for (Employee e : employees) {
            if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                throw new BadEmployeeExceptions();
            }
        }

        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " добавлен.");
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new BadEmployeeExceptions();
        }

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().equals(firstName) && employees.get(i).getLastName().equals(lastName)) {
                employees.remove(i);
                Employee employee = new Employee(firstName, lastName);
                System.out.println("Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " удален.");
                return employee;
            }
        }
        throw new OverflowArrayException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (isNotValue(firstName, lastName)) {
            throw new BadEmployeeExceptions();
        }

        for (Employee e : employees) {
            if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                System.out.println("Сотрудник " + e.getFirstName() + " " + e.getLastName() + " найден.");
                return e;
            }
        }
        throw new BadEmployeeExceptions();
    }

    @Override
    public List<Employee> showEmployee() {
        return employees;
    }


}