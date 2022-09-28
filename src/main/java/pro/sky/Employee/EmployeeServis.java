package pro.sky.Employee;
// отвечает за код

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
public class EmployeeServis {
    private static final int SIZE = 4;
    private String firstName;
    private String lastName;
    private final Map<String,Employee> employees; //создает список


    public EmployeeServis() {
        this.employees = new HashMap<>();
    }


    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName); //создает другой список для проверки
        if (employees.containsKey(employee.getFullName())) //сравнивает в списках на совпадения
        {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE)//проверяет на вместимость массива(листа)
        {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
           return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}


