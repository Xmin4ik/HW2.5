package pro.sky.Employee;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String lastName;


    public String getName() {
        return name;
    }

    public String getFullName() {

        return name +" "+ lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public Employee(String name, String lastName) {

        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
