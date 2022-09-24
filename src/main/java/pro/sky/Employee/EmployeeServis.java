package pro.sky.Employee;
// отвечает за код

import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServis {
    private static final int SIZE = 4;
    private final List<Employee> employees; //создает список

    public EmployeeServis() {
        this.employees = new ArrayList<>();
    }


    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName); //создает другой список для проверки
        if (employees.contains(employee)) //сравнивает в списках на совпадения
        {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE)//проверяет на вместимость массива(листа)
        {
            throw new EmployeeStorageIsFullException();
        }
        employees.add(employee);//добовляет
        return employee; //работает++
    }
    public Employee delete(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);// не работает(
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public List<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}


