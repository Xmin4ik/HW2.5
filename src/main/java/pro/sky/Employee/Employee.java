package pro.sky.Employee;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String lastName;
    private int department; //отдел
    public int salary; //значение id

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department < 0 || department >= 6) {throw new IllegalArgumentException("Такого депортамента нет");}
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getFullName() {

        return name +" "+ lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public Employee(String name, String lastName,int department,int salary) {
        if (department < 0 || department >= 6){ throw new IllegalArgumentException("Такого депортамента нет");}
        this.name = name;
        this.lastName = lastName;
        this.department=department;
        this.salary=salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
