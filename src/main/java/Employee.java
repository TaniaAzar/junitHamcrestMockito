import java.util.ArrayList;
import java.util.List;

public class Employee{

    private String name;
    private String surname;
    private int salary;

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Employee() {
    }

    //getter and setter
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getSalary() { return salary; }
    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }this.name = name;
    }
    public void setSurname(String surname) {
        if (surname == null){
            throw new IllegalArgumentException("Фамилия не должна быть пустой");
        }this.surname = surname;
    }
    public void setSalary(int salary) {
        if (getSalary() <= 0){
            throw new IllegalArgumentException("Зарплата не должна быть пустой");
        }
        this.salary = salary;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Employee employee = (Employee) object;

        if (salary != employee.salary) return false;
        if (!name.equals(employee.name)) return false;
        return surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        return "Employee " +
                "имя = '" + name + '\'' +
                ", фамилия = '" + surname + '\'' +
                ", зарплата = " + salary ;
    }

}
