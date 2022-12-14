package pro.sky.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// отвечает за адреса
@RestController
@RequestMapping("/emploee")
public class EmployeeController {
    private final EmployeeServis employeeServis;

    public EmployeeController(EmployeeServis employeeServis) {
        this.employeeServis = employeeServis;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeServis.add(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeServis.find(firstName, lastName);
    }

    @GetMapping("/delete")
    public Employee delete(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
        return employeeServis.delete(firstName, lastName);
    }

    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return employeeServis.findAll();
    }

    @ExceptionHandler //указали  вызвать этот метод;
    public String stringEmployeeNotFoundException(EmployeeNotFoundException e) {
        return "Сотрудник не найден"; //вызывает в коде
    }
    @ExceptionHandler //указали  вызвать этот метод;
    public String EmployeeAlreadyAddedException(EmployeeAlreadyAddedException e) {
        return "Сотрудник уже добавлен"; //вызывает в коде
    }
    @ExceptionHandler //указали  вызвать этот метод;
    public String EmployeeStorageIsFullException(EmployeeStorageIsFullException e) {
        return "Список сотрудников заполнен"; //вызывает в коде
    }
}
