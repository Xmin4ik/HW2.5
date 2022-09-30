package pro.sky.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
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
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") int department,
                        @RequestParam("id") int id
    ) {
        return employeeServis.add(firstName, lastName, department, id);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("department") int department,
                         @RequestParam("id") int id
    ) {
        return employeeServis.find(firstName, lastName,department,id );
    }

    @GetMapping("/delete")
    public Employee delete(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") int department,
                           @RequestParam("id") int id) {
        return employeeServis.delete(firstName, lastName,department,id);
    }

    @GetMapping("/departments/all")
    public Collection<Employee> findAll() {
        return employeeServis.findAll();
    }

    @GetMapping("/departments/all")
    public Employee findDepartment(
                         @RequestParam("department") int department) {
        return employeeServis.finDepartment(department);
    }


    @GetMapping("/departments/all")
    public Employee findAllInDepartment(
                                   @RequestParam("departmentId") int department) {
        return employeeServis.findAllInDepartment(department);
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
