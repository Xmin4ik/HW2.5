package pro.sky.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
                        @RequestParam("department") Integer department,
                        @RequestParam("id") int salary
    ) {
        return employeeServis.add(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("department") Integer department,
                         @RequestParam("id") int salary
    ) {
        return employeeServis.find(firstName, lastName, department, salary);
    }

    @GetMapping("/delete")
    public Employee delete(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") Integer department,
                           @RequestParam("id") int salary) {
        return employeeServis.delete(firstName, lastName, department, salary);
    }

   @GetMapping("/departments/all")
    public Map<Integer, List<Employee>>  findAll() {
      return employeeServis.findAll();
    }

    @GetMapping(value = "/departments/all", params = "department")
    public Collection<Employee> findDepartments() {
        return employeeServis.finDepartments();
    }


    //@GetMapping("/departments/all")
   // public Employee findAllInDepartment(@RequestParam("department") Integer department) {
    //    return employeeServis.findAllInDepartment(department);
  //  }


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
