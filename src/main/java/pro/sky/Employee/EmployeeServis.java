package pro.sky.Employee;
// отвечает за код

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServis {
    private static final int SIZE = 4;
    private String firstName;
    private String lastName;
    private Integer department;
    private int salary;
    private final Map<Integer, List<Employee>> employees = new HashMap<>(); //создает список


    public Employee add(String firstName, String lastName, Integer department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary); //создает другой список для проверки
        if (department < 0 || department >= 6) {
            throw new IllegalArgumentException("Такого депортамента нет");
        }
        if (employees.containsValue(employee.getFullName())) //сравнивает в списках на совпадения
        {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= SIZE)//проверяет на вместимость массива(листа)
        {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(employee.getDepartment(), employee);
        return employee;
    }

    public Employee delete(String firstName, String lastName, Integer department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (department < 0 || department >= 6) {
            throw new IllegalArgumentException("Такого депортамента нет");
        }
        if (employees.containsValue(employee.getFullName())) {
            return (Employee) employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName, Integer department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsValue(employee.getFullName())) {
            return (Employee) employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    public Employee findAllInDepartment(Integer department) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .forEach(s -> System.out.println(s.getFullName()));
        return (Employee) employees.get(employee.getFullName());


    }

    public Collection<Employee> finDepartments(Integer department) {
        return employees.values().stream()
                .filter(em -> em.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public void findEmployees() {
        Map<Integer, List<Employee>> map = employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }


    public void findInDepartmentMaxSalary(Integer department) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        Map<Integer, List<Employee>> map = employees.values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);


    }

    public void findInDepartmentMinSalary(Integer department) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.values().stream()
                .filter(e -> employee.getDepartment() == department) // фильтр ищим в номере департамента //выбираем самое большее значение
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new); //в последней строке бросаем исключение, если не нашли искомый элемент

    }


    public Map<Integer, List<Employee>> findAll() {
        return (Map<Integer, List<pro.sky.Employee.Employee>>) employees.values();
    }

}
