package pro.sky.seconveremp;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastSurname;

    public Employee(String firstName, String lastSurname) {
        this.firstName = firstName;
        this.lastSurname = lastSurname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastSurname() {
        return lastSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastSurname, employee.lastSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastSurname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastSurname='" + lastSurname + '\'' +
                '}';
    }
}
