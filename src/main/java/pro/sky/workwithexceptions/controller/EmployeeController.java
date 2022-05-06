package pro.sky.workwithexceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.workwithexceptions.Employee;
import pro.sky.workwithexceptions.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        return ("Сотрудник " + employeeService.addEmployee(firstName, lastName) + " успешно создан.");
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        return ("Сотрудник " + employeeService.removeEmployee(firstName, lastName) + " удален.");
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return (employeeService.findEmployee(firstName, lastName));
    }
}
