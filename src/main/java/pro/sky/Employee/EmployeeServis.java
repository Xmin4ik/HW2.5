package pro.sky.Employee;
// отвечает за код

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class EmployeeServis {
    private static final int SIZE = 4;
    private String firstName;
    private String lastName;
    private Integer department;
    private int salary;
    private final Map<Integer,Employee> employees; //создает список


    public EmployeeServis() {
        this.employees = new HashMap<>();
    }


    public Employee add(String firstName, String lastName, Integer department, int salary) {
        Employee employee = new Employee(firstName, lastName,department,salary); //создает другой список для проверки
        if (department < 0 || department >= 6) {throw new IllegalArgumentException("Такого депортамента нет");}
        if (employees.containsValue(employee.getFullName())) //сравнивает в списках на совпадения
        {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE)//проверяет на вместимость массива(листа)
        {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(employee.getDepartment(),employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName,Integer department, int salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
        if (department < 0 || department >= 6) {throw new IllegalArgumentException("Такого депортамента нет");}
        if (employees.containsValue(employee.getFullName())) {
           return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName,Integer department,int salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
        if (employees.containsValue(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    public Employee findAllInDepartment(Integer department) {
        Employee employee = new Employee(firstName, lastName,department,salary);
        if (employees.containsKey(employee.getDepartment())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }



    public Employee findInDepartmentMaxSalary(Integer department,int salary) {
        Employee employee = new Employee(firstName, lastName,department,salary);
       // employees.forEach(employee ->employee ); как тут делать?)





        if (employees.containsKey(employee.getDepartment())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}


