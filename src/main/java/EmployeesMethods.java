import java.util.List;

public interface EmployeesMethods {

    Employee toAdd(Employee employee);
    void toRemove(Employee employee);
    Employee toChange(Employee employee, Employee newEmployee);
    Employee toFindEmployee(String surname);

    List<Employee> getAll();
}
